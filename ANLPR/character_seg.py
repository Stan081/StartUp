from skimage import img_as_float, img_as_ubyte, iofrom matplotlib import pyplot as pltimport numpy as npfrom skimage.restoration import denoise_nl_means, estimate_sigmafrom skimage import img_as_ubyte, img_as_float, color# import the imageimage = img_as_float(io.imread('plate.jpg')) #plt.imshow(image)#clean the noise using edge preserving filter.sigma_est = np.mean(estimate_sigma(image, multichannel=True))denoise = denoise_nl_means(image, h=1.15 * sigma_est, fast_mode=True,                                patch_size=5, patch_distance=3, multichannel=True)denoise_ubyte = img_as_ubyte(denoise)#plt.imshow(denoise_ubyte)#converting to grayscaleimage_gray = color.rgb2gray(image) #plt.imshow(image_gray, cmap = 'gray')#print (image_gray.shape)#plt.hist(image_gray)#segmenting into background and foregroundgray_r = image_gray.reshape(image_gray.shape[0]*image_gray.shape[1])for i in range(gray_r.shape[0]):    if gray_r[i] > gray_r.mean():        gray_r[i] = 1    else:        gray_r[i] = 0image_gray = gray_r.reshape(image_gray.shape[1],image_gray.shape[2])plt.imshow(image_gray, cmap='gray')#plt.hist(image_gray, bins = 100, range = (223,254))plt.show()