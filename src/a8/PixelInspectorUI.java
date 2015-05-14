package a8;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PixelInspectorUI extends JPanel implements ActionListener {

	private JLabel x_label;
	private JLabel y_label;
	private JButton set_brush_button;
	private JLabel pixel_info;
	private Pixel store_pixel;
	private Pixel new_pixel;

	public PixelInspectorUI() {
		x_label = new JLabel("X: ");
		y_label = new JLabel("Y: ");
		pixel_info = new JLabel("(r,g,b)");
		set_brush_button = new JButton("Set Paintbrush Color");
		
		set_brush_button.addActionListener(this);

		setLayout(new GridLayout(4,1));
		add(x_label);
		add(y_label);
		add(pixel_info);
		add(set_brush_button);
	}
	
	public void actionPerformed(ActionEvent e) {
		try{
			store_pixel = new ColorPixel(new_pixel.getRed(), new_pixel.getGreen(), new_pixel.getBlue());
			System.out.println("SET");
		}catch(Exception n){
			System.out.println("No pixel selected.");
		}
	}

	public Pixel getStoredPixel(){
		return store_pixel;
	}

	public void setInfo(int x, int y, Pixel p) {
		x_label.setText("X: " + x);
		y_label.setText("Y: " + y);
		pixel_info.setText(String.format("(%3.2f, %3.2f, %3.2f)", p.getRed(), p.getBlue(), p.getGreen()));		
		new_pixel = p;
	}
	

}
