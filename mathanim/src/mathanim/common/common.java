package mathanim.common;

import java.awt.Color;

import mathanim.color.ColorPalette;
import processing.core.PApplet;

public class common {
	PApplet sketch;
	String col;
	float x1,y1,x2,y2;
	float x_speed,y_speed,anim_speed,xo,yo;
	float m;
	ColorPalette c;
	Color col_point,col_line;
	float height,width;
	double inf = Double.POSITIVE_INFINITY;
	double inf_n = Double.NEGATIVE_INFINITY;
	float[] x_arr = new float[1000];
	float[] y_arr = new float[1000];
	int i;
	
	public common(PApplet sketch,float height,float width) {
		this.sketch = sketch;
		this.height = height;
		this.width = width;
		c = new ColorPalette();
		xo = width/2;
		yo = height/2;
		anim_speed = 0;
		x_speed = 0;
		y_speed = 0;
		i=0;
	}
	
	public int dottedline(float x1, float y1, float x2, float y2,String col) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.col = col;
		
		x1 += xo;
		x2 += xo;
		y1 = yo - y1;
		y2 = yo - y2;
		col_point = c.Colour(col);
//		if (x2<x1) {
//			x2 += x1;
//			x1 = x2-x1;
//			x2 = x2-x1;
//			}if(y2<y1) {
//				y2 += y1;
//				y1 = y2-y1;
//				y2 = y2-y1;
//			}
		try{
			m = (y2-y1)/(x2-x1);
		}catch(Exception e) {
		}
		
		if (m !=  inf && m != inf_n) {
			y_speed = m*x_speed;
			if(x1 + x_speed != x2 || y1 + y_speed != y2) {
				sketch.stroke(col_point.getRed(), col_point.getGreen(), col_point.getBlue());
				sketch.strokeWeight(5);
				sketch.point(x1 + x_speed, y1 + y_speed);
				x_arr[i] = x1 + x_speed;
				y_arr[i] = y1 + y_speed;
				x_speed += (x2-x1)/(0.1 * Math.abs(x2-x1));	
				i++;
			}
			else {
				for (int i = 0;i<x_arr.length;i++) {
					sketch.stroke(col_point.getRed(), col_point.getGreen(), col_point.getBlue());
					sketch.strokeWeight(5);
					sketch.point(x_arr[i], y_arr[i]);
				}
			}
		}else {
			x_speed = 0;
			m = (float) ((y2-y1)/(0.1 * Math.abs(y2-y1)));
			if(x1 + x_speed != x2 || y1 + y_speed != y2) {
				y_speed =  (float) (y_speed + m);
				sketch.stroke(col_point.getRed(), col_point.getGreen(), col_point.getBlue());
				sketch.strokeWeight(5);
				sketch.point(x1 + x_speed, y1 + y_speed);
				x_arr[i] = x1 + x_speed;
				y_arr[i] = y1 + y_speed;
				i++;
				
			}else {
				for (int i = 0;i<x_arr.length;i++) {
					sketch.stroke(col_point.getRed(), col_point.getGreen(), col_point.getBlue());
					sketch.strokeWeight(5);
					sketch.point(x_arr[i], y_arr[i]);
				}
			}
		}
		if(x1 + x_speed != x2 || y1 + y_speed != y2) {
			return 1;
		}else {
			return 0;
		}
		
		
		
	}

}
