import cv2
import numpy as np
from matplotlib import pyplot as plt
image = cv2.imread('plate.jpg')
def auto_canny(image, sigma=0.33):
    # compute the median of the single channel pixel intensities
    v = np.median(image)
 
    # apply automatic Canny edge detection using the computed median
    lower = int(max(0, (1.0 - sigma) * v))
    upper = int(min(255, (1.0 + sigma) * v))
    edged = cv2.Canny(image, lower, upper)

    # return the edged image
    return edged

gray = cv2.cvtColor(image,cv2.COLOR_BGR2GRAY)
thresh_inv = cv2.adaptiveThreshold(gray,255,cv2.ADAPTIVE_THRESH_MEAN_C,cv2.THRESH_BINARY_INV,39,1)
edges = auto_canny(thresh_inv)


ctrs, _ = cv2.findContours(edges.copy(), cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)
sorted_ctrs = sorted(ctrs, key=lambda ctr: cv2.boundingRect(ctr)[0])
img_area = image.shape[0]*image.shape[1]
for i, ctr in enumerate(sorted_ctrs):
    x, y, w, h = cv2.boundingRect(ctr)
    roi_area = w*h
    roi_ratio = roi_area/img_area
if((roi_ratio >= 0.015) and (roi_ratio < 0.09)):
        if ((h>1.2*w) and (3*w>=h)):
            a = cv2.rectangle(image,(x,y),( x + w, y + h ),(90,0,255),2)
            plt.imshow(a, cmap='RGB')

cv2.imshow('OpenCV character segmentation',image)
licensePlate="".join(charList)
return licensePlate

