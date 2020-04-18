package myUtilities;

import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;

public class MyImage {
	
	Device device;
	Image image;
	int width, height;
	
	
	public Image resizeImage(Device dev, Image image, int width, int height) {
		
		Image result=null;
		
		ImageData imgData = image.getImageData();
		imgData = imgData.scaledTo(width, height);
		result = new Image(dev,imgData);
		
		return result;
	}

}
