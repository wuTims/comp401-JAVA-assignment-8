package a8;

public class ImageEditorModel {

	private Frame original;
	private Frame current;

	public ImageEditorModel(Frame f) {
		original = f;
		current = original.copy();
	}

	public void setCurrent(Frame new_f){
		current = new_f;
	}

	public Frame getCurrent() {
		return current;
	}

	public Pixel getPixel(int x, int y) {
		return current.getPixel(x, y);
	}

	public void paintAt(int x, int y, Pixel brushColor, int brush_size, int opacity) {
		current.suspendNotifications();

		
		for (int xpos=x-brush_size+1; xpos <=x+brush_size-1; xpos++) {
			for (int ypos=y-brush_size+1; ypos <=y+brush_size-1; ypos++) {
				if (xpos >= 0 &&
						xpos < current.getWidth() &&
						ypos >= 0 &&
						ypos < current.getHeight()) {

					Pixel curr_pixel = getPixel(xpos, ypos);
					
					double opacity_percent = (double) opacity/100;
					double new_red = (opacity_percent * brushColor.getRed()) + ((1-opacity_percent)*curr_pixel.getRed());
					double new_green = (opacity_percent * brushColor.getGreen()) + ((1-opacity_percent)*curr_pixel.getGreen());
					double new_blue =(opacity_percent * brushColor.getBlue()) + ((1-opacity_percent)*curr_pixel.getBlue());
					
					Pixel new_brush_color = new ColorPixel(new_red, new_green, new_blue);

					current.setPixel(xpos, ypos, new_brush_color);
				}
			}
		}
		current.resumeNotifications();
	}
}
