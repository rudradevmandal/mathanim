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
	float anim_speed;
	float x_speed;
	float y_speed;
	float height, width, x, y, x_o, y_o, a, b;
	int j;
	float stretch;
	textanim text;
	public OneDGrid( PApplet sketch, String col, String p_col, String o_col, float height, float width) {
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
		j = 1;
		
	}
	public void AnimateOneDGrid(float x, float y) {
		/**Initializing the color, origin points and speed of animation.*/

		axis = c.Colour(col);
		pcol = c.Colour(p_col);
		ocol = c.Colour(o_col);
		x_o = x + width/2;
		y_o = y+ height/2;
		anim_speed += 10;
		/**Animating a line using the speed defined.*/
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
			
		}
		
	}
	public void staticgrid(float x, float y) {
		axis = c.Colour(col);
		pcol = c.Colour(p_col);
		ocol = c.Colour(o_col);
		x_o = x + width/2;
		y_o = y+ height/2;
		/**After the animation of the line.
		 * Drawing the 1-D axis and drawing points for labeling.*/
		sketch.strokeWeight(2);
		sketch.stroke(axis.getRed(), axis.getGreen(), axis.getBlue());
		sketch.line(x_o, y_o, width, y_o);
		sketch.line(x_o, y_o, 0, y_o);
	}
	public void markgrid(float x_o, float y_o) {
		/**This function marks the points in the 1-D line using the origin as x_o and y_o*/
		int j = 1;
		//Mark all the points using a for loop
		for (int i = 100; i< width; i+=100) {
			sketch.stroke(pcol.getRed(), pcol.getGreen(), pcol.getBlue());
			sketch.strokeWeight(7);
			sketch.point(x_o + i, y_o);
			sketch.point(x_o - i, y_o);
			text = new textanim(sketch,Integer.toString(j),40, p_col,"transparent", x_o - 15 + i, y_o + 7 , "markgrid1");
			text.ImgTeX("markgrid1");
			text.drawtext("markgrid1");
			text = new textanim(sketch,Integer.toString(-j),40, p_col,"transparent",x_o - 47 - i, y_o + 7, "markgrid2");
			text.ImgTeX("markgrid2");
			text.drawtext("markgrid2");
			j++;
		}
		//Mark the origin
		sketch.stroke(ocol.getRed(), ocol.getGreen(), ocol.getBlue());
		sketch.strokeWeight(6);
		text = new textanim(sketch,"0",40, o_col,"transparent", x_o - 15 , y_o + 5 , "markgrid_o");
		text.ImgTeX("markgrid_o");
		text.drawtext("markgrid_o");
		sketch.point(x_o, y_o);
	}
		
	
	public void movegrid(PApplet sketch, float x, float y, float a, float b) {
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
	
	public void stretchgrid(float x, float y, float a) {
		/**Stretches the 1-D grid by amount "a".*/
		axis = c.Colour(col);
		pcol = c.Colour(p_col);
		ocol = c.Colour(o_col);
		x_o = x + width/2;
		y_o = x + height/2;

		/**This function marks the points in the 1-D line using the origin as x_o and y_o*/
		
		//Mark all the points using a for loop
		j = 1;
		if(x_speed < 1 ) {
				stretch = 1;
			
			x_speed++;
		}

		if(stretch != a) {
			for (float i = (float) (stretch*100); i< width; i+=stretch*100) {
				sketch.stroke(pcol.getRed(), pcol.getGreen(), pcol.getBlue());
				sketch.strokeWeight(7);
				sketch.point((float) (x_o + i), y_o);
				sketch.point((float) (x_o - i), y_o);

			}
			if(a > 1) {
				//Stretch
				 stretch += 0.1;
			}else {
				//Shrink
				stretch -= 0.1;
			}
			stretch = (float) Math.round(stretch*1000)/1000;
			a = (float) Math.round(a*1000)/1000;
			//Mark the origin
			sketch.stroke(ocol.getRed(), ocol.getGreen(), ocol.getBlue());
			sketch.strokeWeight(6);
			sketch.point(x_o, y_o);
//			System.out.println(stretch);
//			System.out.println(a);
		}
		else if(stretch == a) {
			//After stretching or shrinking, maintain its position and mark ll the points.
			for (float i = a*100; i< width; i+=a*100) {
				sketch.stroke(pcol.getRed(), pcol.getGreen(), pcol.getBlue());
				sketch.strokeWeight(7);
				sketch.point((float) (x_o + i), y_o);
				sketch.point((float) (x_o - i), y_o);
				text = new textanim(sketch,Integer.toString(j),40, p_col,"transparent", x_o - 15 + i, y_o + 7 , "markgrid1");
				text.ImgTeX("markgrid1");
				text.drawtext("markgrid1");
				text = new textanim(sketch,Integer.toString(-j),40, p_col,"transparent",x_o - 47 - i, y_o + 7, "markgrid2");
				text.ImgTeX("markgrid2");
				text.drawtext("markgrid2");
				j++;
				System.out.println(stretch);
			}
			//Mark the origin
			sketch.stroke(ocol.getRed(), ocol.getGreen(), ocol.getBlue());
			sketch.strokeWeight(6);
			text = new textanim(sketch,"0",40, o_col,"transparent", x_o - 15 , y_o + 5 , "markgrid_o");
			text.ImgTeX("markgrid_o");
			text.drawtext("markgrid_o");
			sketch.point(x_o, y_o);
		}

	}

}