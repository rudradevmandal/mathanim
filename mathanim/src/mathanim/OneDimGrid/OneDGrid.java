package mathanim.OneDimGrid;

import java.awt.Color;

import mathanim.color.ColorPalette;
import mathanim.text.textanim;
import processing.core.PApplet;

public class OneDGrid {
	/**Creates a 1-D grid
	 * @param	sketch			Points to the current PApplet.
	 * @param	col,axis		Color of the axis line.
	 * @param	p_col,pcol		Color of the axis points.
	 * @param	o_col,ocol		Color of the origin point.
	 * @param	x,y				Dynamic x,Y points
	 * @param 	x_o,y_o			Origin of the current PApplet window*/
	PApplet sketch;
	String col, p_col, o_col;
	ColorPalette c = new ColorPalette();
	Color axis, pcol, ocol;
	int anim_speed;
	int x_speed;
	int y_speed;
	int height, width, x, y, x_o, y_o, a, b;
	textanim text = new textanim();
	public OneDGrid( PApplet sketch, String col, String p_col, String o_col, int height, int width) {
		/**Initialize all variables*/
		this.col = col;
		this.p_col = p_col;
		this.o_col = o_col;
		this.sketch = sketch;
		this.height = height;
		this.width = width;
		anim_speed = 0;
		x_speed = 0;
		y_speed = 0;
		
	}
	public void AnimateOneDGrid() {
		/**Initializing the color, origin points and speed of animation.*/

		axis = c.Colour(col);
		pcol = c.Colour(p_col);
		ocol = c.Colour(o_col);
		x_o = width/2;
		y_o = height/2;
		anim_speed += 10;
		/**Animating a line using th speed defined.*/
		if(x_o + anim_speed < width) {
			sketch.stroke(axis.getRed(), axis.getGreen(), axis.getBlue());
			sketch.strokeWeight(2);
			sketch.line(x_o, y_o, x_o + anim_speed, y_o);
			sketch.line(x_o, y_o, x_o - anim_speed, y_o);

		}else {
			/**After the animation of the line.
			 * Drawing the 1-D axis and drawing points for labeling.*/
			sketch.strokeWeight(2);
			sketch.stroke(axis.getRed(), axis.getGreen(), axis.getBlue());
			sketch.line(x_o, y_o, width, y_o);
			sketch.line(x_o, y_o, 0, y_o);
			markgrid(x_o, y_o);
			
		}
		
	}
	
	public void markgrid(int x_o, int y_o) {
		/**This function marks the points in the 1-D line using the origin as x_o and y_o*/
		int j = 1;
		//Mark all the points using a for loop
		for (int i = 100; i< width; i+=100) {
			sketch.stroke(pcol.getRed(), pcol.getGreen(), pcol.getBlue());
			sketch.strokeWeight(7);
			sketch.point(x_o + i, y_o);
			sketch.point(x_o - i, y_o);
			text.ImgTeX(sketch,Integer.toString(j),40, p_col,"transparent", x_o - 15 + i, y_o + 7 , "text2");
			text.ImgTeX(sketch,Integer.toString(-j),40, p_col,"transparent",x_o - 47 - i, y_o + 7, "text3");
			j++;
		}
		//Mark the origin
		sketch.stroke(ocol.getRed(), ocol.getGreen(), ocol.getBlue());
		sketch.strokeWeight(6);
		text.ImgTeX(sketch,"0",40, o_col,"transparent", x_o - 15 , y_o + 5 , "text4");
		sketch.point(x_o, y_o);
	}
		
	
	public void movegrid(PApplet sketch, int x, int y, int a, int b) {
		/**This function moves the 1-D line by a set amount.
		 * Also, it animates the markings on the axis.*/
		this.sketch = sketch;
		this.x = x;
		this.y = y;
		this.a = a;
		this.b = b;
		axis = c.Colour(col);
		pcol = c.Colour(p_col);
		ocol = c.Colour(o_col);
		x_o = width/2;
		y_o = height/2;
		a += x_o;
		b += y_o;

		//Move the line only along the y-axis
		if(y_o + y_speed <b) {
			y_speed += 2;
			sketch.strokeWeight(2);
			sketch.stroke(axis.getRed(), axis.getGreen(), axis.getBlue());
			sketch.line(0 , y_o + y_speed, width , y_o + y_speed);
		}else {
			//Move the points only along the x-axis
			x_speed += 2;
			sketch.strokeWeight(2);
			sketch.stroke(axis.getRed(), axis.getGreen(), axis.getBlue());
			sketch.line(0 , b, width , b);
			if(x_o + x_speed < a) {
				markgrid(x_o + x_speed, b);
			}else {
				markgrid(a,b);
			}
		}
		
		
	}

}
