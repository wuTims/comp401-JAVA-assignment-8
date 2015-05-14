package a8;

import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JSlider;

public class PaintBrushTool implements Tool {

	private PaintBrushToolUI ui;
	private ImageEditorModel model;
	private int brush_size = 5;
	private JSlider opacity_slider;
	
	public PaintBrushTool(ImageEditorModel model) {
		this.model = model;
		ui = new PaintBrushToolUI();
		opacity_slider = ui.getOpacitySlider();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public int getOpacity(){
		return opacity_slider.getValue();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		int opacity_level = opacity_slider.getValue();
		model.paintAt(e.getX(), e.getY(), ui.getBrushColor(), brush_size, opacity_level);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		//System.out.println(model.getSelectedPixel().getRed());
	//	System.out.println("HI");
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		int opacity_level = opacity_slider.getValue();
		model.paintAt(e.getX(), e.getY(), ui.getBrushColor(), brush_size, opacity_level);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
		
	}

	@Override
	public String getName() {
		return "Paint Brush";
	}

	@Override
	public JPanel getUI() {
		return ui;
	}

}
