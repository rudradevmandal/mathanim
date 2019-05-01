package mathanim.TwoDimGrid;

import java.awt.Color;
import mathanim.color.ColorPalette;
import processing.core.PApplet;

public class XYGrid {
	/**Makes a 2D Grid of desired color*/
	/*Declare global variables.*/
	/**Initialize all variables.
	 * @param		sketch		Processing Applet
	 * @param		grid_col	Color of the grid lines
	 * @param		axis_col	Color of the axis lines
	 * @param		height		Height of the window
	 * @param		width		Width of the window
	 * 
	 * 			
	 * 
	 * @author	Rudra Dev Mandal
	 * @version	1.0
	 * @since	18-04-2019*/
	PApplet sketch;
	String grid_col, axis_col;
	int height, width;
	float x_speed = 0;
	float y_speed = 0;
	ColorPalette c = new ColorPalette();
	Color grid, axis;
	
	public XYGrid(PApplet sketch,String grid_col, String axis_col, int height, int width) {
		/**
		 * @usage	XYGrid object;
		 * @setup	Object = new XYGrid(this, "Grid Line Color", "Axis Line Color", height, width);
		 * @draw	Object.AnimateXYGrid();	*/
		/**Assign the current object to all the variables declared using "this" keyword.*/
		this.sketch = sketch;
		this.grid_col = grid_col;
		this.axis_col = axis_col;
		this.height = height;
		this.width = width;
	}
	public void AnimateXYGrid() {
		/**Animates a 2D grid in the given Applet window.
		 * @return	Void*/
		/*Initialize grid and axis color as defined by the current object*/
		grid = c.Colour(grid_col);
		axis = c.Colour(axis_col);
		/*Specify the origin of the display applet window.*/
		int x_origin = width/2;
		int y_origin = height/2;
		/*Animating lines for x axis*/
		for(int x = 0 ; x < width ; x+= 150) {
			//Specify the speed of the animation.
			y_speed += 0.9;
			x_speed += 1.6;
			//Sketch the main grid lines thicker.
			sketch.stroke(grid.getRed(), grid.getGreen(), grid.getBlue());
			sketch.strokeWeight(2);
			sketch.line(x_origin + x, 0, x_origin + x, y_speed);
			sketch.line(x_origin - x, 0, x_origin - x, y_speed);
			//Sketch the intermediate grid lines thinner.
			sketch.strokeWeight((float) 0.5);
			sketch.line(x_origin + x + 75, 0, x_origin + x + 75, y_speed);
			sketch.line(x_origin - x - 75, 0, x_origin - x - 75, y_speed);
			}
		/*Animating lines for x axis*/
		for(int y = 0 ; y < height ; y+= 150) {
			//Sketch the main grid lines thicker.
			sketch.strokeWeight(2);
			sketch.line(0, y_origin + y, x_speed, y_origin + y);
			sketch.line(0, y_origin - y, x_speed, y_origin - y);
			sketch.stroke(grid.getRed(), grid.getGreen(), grid.getBlue());
			//Sketch the intermediate grid lines thinner.
			sketch.strokeWeight((float) 0.5);
			sketch.line(0, y_origin + y + 75, x_speed, y_origin + y + 75);
			sketch.line(0, y_origin - y - 75, x_speed, y_origin - y - 75);

			
			
		}
		//Sketch the main axis lines.
		sketch.stroke(axis.getRed(), axis.getGreen(), axis.getBlue());
		sketch.strokeWeight(2);
		sketch.line(0, y_origin, x_speed, y_origin);
		sketch.line(x_origin, 0, x_origin, y_speed);
		
		//**Applet window exit protocol*/
//		if (x_speed>height+width) {
//			System.exit(0);
//		}
		
		
	}

}
