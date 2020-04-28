package coffeepoweredcrew.proxy.dynamic;

import coffeepoweredcrew.objectpool.Point2D;
import coffeepoweredcrew.proxy.Image;


public class Client {

	public static void main(String[] args) {
		Image img = ImageFactory.getImage("A.bmp");
		img.setLocation(new Point2D(-10, 0));
		System.out.println(img.getLocation());
		System.out.println("*****************************");
		img.render();
		
	}
}
