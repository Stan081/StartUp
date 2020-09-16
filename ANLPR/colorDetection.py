import cv2
import numpy as np
import time
import imutils

st = time.time()
charList = []
image = cv2.imread("plate.jpg")
# define the list of boundaries
#image = cv2.MeanAverageBlurr(image, (9,9), 0)
#cv2.imshow("Blurred Image", image)
#cv2.waitKey(0)
#looping over boundaries
#for (lower, upper) in boundaries:
    #create numpy arrays  from the boundaries
lower = np.array([86, 31, 4], dtype="uint8")
upper = np.array([248, 133, 120], dtype="uint8")

    #find the colors around the specified boundaries and apply the mask
mask = cv2.inRange(image, lower, upper)
output = cv2.bitwise_and(image, image, mask = mask)

    #show images
cv2.imshow("images", np.hstack([image, output]))
cv2.waitKey(0)

#gray_image = cv2.cvtColor(output, cv2.COLOR_BGR2GRAY)
#cv2.imshow("Gray", gray_image)
#cv2.waitKey(0)

edged_image = cv2.Canny(output, 30, 150)
#cv2.imshow("Edged", edged_image)
#cv2.waitKey(0)

#thresh_image1 = cv2.threshold(edged_image, 100, 255, cv2.THRESH_BINARY_INV)[1]
#cv2.imshow("Threshold Image", thresh_image1)
#cv2.waitKey(0)

#thresh_image = thresh_image1.copy()
thresh_image = cv2.dilate(edged_image, None, iterations=1)

#contours = cv2.findContours(thresh_image.copy(), cv2.RETR_EXTERNAL,
                            #cv2.CHAIN_APPROX_SIMPLE)
#contours = imutils.grab_contours(contours)
#output = image.copy()
                            
contours, _ = cv2.findContours(thresh_image.copy(), cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)
sorted_ctrs = sorted(contours, key=lambda ctr: cv2.boundingRect(ctr)[0])
img_area = image.shape[0]*image.shape[1]

for i, ctr in enumerate(sorted_ctrs):
    x, y, w, h = cv2.boundingRect(ctr)
    roi_area = w*h
    non_max_sup = roi_area/img_area
    if((non_max_sup >= 0.015) and (non_max_sup < 0.09)):
        if ((h>1.2*w) and (3*w>=h)):
            char = image[y:y+h,x:x+w]
            charList.append(char)
            cv2.rectangle(image,(x,y),( x + w, y + h ),(90,0,255),2)
cv2.imshow('OpenCV character segmentation',image)
    
#licensePlate="".join(charList)
#return licensePlate
print(len(charList))

et = time.time()
tt = (et - st) * 1000
print(tt)


    

