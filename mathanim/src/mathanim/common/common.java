package mathanim.common;

import java.awt.Color;

import mathanim.color.ColorPalette;
import processing.core.PApplet;

public class common {
	/**
	 * This class contains the commonly used command
	 * 
	 * @param sketch       Points to the current PApplet.
	 * @param col          Specifies the color.
	 * @param x1,x2,y1,y2  Specifies the coordinate points.
	 * @param col_point    Color of the point.
	 * @param col_line     Color of the line.
	 * @param x_speed...   Animation speed
	 * @param height,width Height and width of the current PApplet window
	 * @param x_arr,y_arr  Arrays to store the moving x and y points.
	 * @param i            Dynamic counting variable.
	 */
	PApplet sketch;
	String col;
	float x1, y1, x2, y2;
	float x_speed, y_speed, anim_speed, xo, yo;
	float m;
	ColorPalette c;
	Color col_point, col_line;
	float height, width;
	double inf = Double.POSITIVE_INFINITY;
	double inf_n = Double.NEGATIVE_INFINITY;
	float[] x_arr = new float[1000];
	float[] y_arr = new float[1000];
	int i;

	public common(PApplet sketch, float height, float width) {
		/** Initializing all variable to their current state. */
		this.sketch = sketch;
		this.height = height;
		this.width = width;
		c = new ColorPalette();
		xo = width / 2;
		yo = height / 2;
		anim_speed = 0;
		x_speed = 0;
		y_speed = 0;
		i = 0;
	}

	public int dottedline(float x1, float y1, float x2, float y2, String col) {
		// obtaining the xy values
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.col = col;
		// Adding the origin points
		x1 += xo;
		x2 += xo;
		y1 = yo - y1;
		y2 = yo - y2;
		// getting the color from ColourPallete
		col_point = c.Colour(col);
		// calculating the slope of the line between (x1,y1) and (x2,Y2)
		m = (y2 - y1) / (x2 - x1);
		// If slope is not undefined
		if (m != inf && m != inf_n) {
			// y=mx+c
			y_speed = m * x_speed;
			// if x1+x_disp is not equal to x2 or y1+y_disp is not equal to y2
			if (x1 + x_speed != x2 || y1 + y_speed != y2) {
				sketch.stroke(col_point.getRed(), col_point.getGreen(), col_point.getBlue());
				sketch.strokeWeight(5);
				// sketch the point at x1+x_disp and y1+y_disp
				sketch.point(x1 + x_speed, y1 + y_speed);
				// Store x1+x_disp and y1+y_disp in an array for later use
				x_arr[i] = x1 + x_speed;
				y_arr[i] = y1 + y_speed;
				// Increase x_disp in the desired direction
				x_speed += (x2 - x1) / (0.1 * Math.abs(x2 - x1));
				// increase i for array
				i++;
			} else {
				// After animating the line, draw it constantly using the arrays
				for (int i = 0; i < x_arr.length; i++) {
					sketch.stroke(col_point.getRed(), col_point.getGreen(), col_point.getBlue());
					sketch.strokeWeight(5);
					sketch.point(x_arr[i], y_arr[i]);
				}
			}
		} else {
			// If the slope is +-Infinity, the point moves along y-direction
			x_speed = 0;
			// Just increase the y_disp
			m = (float) ((y2 - y1) / (0.1 * Math.abs(y2 - y1)));
			if (x1 + x_speed != x2 || y1 + y_speed != y2) {
				y_speed = (float) (y_speed + m);
				sketch.stroke(col_point.getRed(), col_point.getGreen(), col_point.getBlue());
				sketch.strokeWeight(5);
				sketch.point(x1 + x_speed, y1 + y_speed);
				x_arr[i] = x1 + x_speed;
				y_arr[i] = y1 + y_speed;
				i++;

			} else {
				for (int i = 0; i < x_arr.length; i++) {
					sketch.stroke(col_point.getRed(), col_point.getGreen(), col_point.getBlue());
					sketch.strokeWeight(5);
					sketch.point(x_arr[i], y_arr[i]);
				}
			}
		}
		if (x1 + x_speed != x2 || y1 + y_speed != y2) {
			return 1;
		} else {
			return 0;
		}

	}

	// Generating an arrow
	public int arrow(float x1, float y1, float x2, float y2, String col) {
		// obtaining the xy values
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.col = col;
		// Adding the origin points
		x1 += xo;
		x2 += xo;
		y1 = yo - y1;
		y2 = yo - y2;
		// getting the color from ColourPallete
		col_point = c.Colour(col);

		sketch.stroke(col_point.getRed(), col_point.getGreen(), col_point.getBlue());
		sketch.strokeWeight(4);
		sketch.line(x1, y1, x2, y2);
		// draw a triangle at (x2, y2)
		sketch.pushMatrix();
		sketch.translate(x2, y2);
		float a = sketch.atan2(x1-x2, y2-y1);
		sketch.rotate(a);
		sketch.line(0, 0, -10, -10);
		sketch.line(0, 0, 10, -10);
		sketch.popMatrix();
		return i;
	}

}
