package mathanim.text;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;

import mathanim.color.ColorPalette;
import processing.core.PApplet;
import processing.core.PImage;

public class textanim {
	/**
	 * Creating and Animating text from LaTeX commands.
	 * Takes LaTeX commands and renders the given command in TeX workflow,
	 * after which an image is stored at the specified location.
	 * 
	 * 				
	 * 
	 * @author	Rudra Dev Mandal
	 * @version	1.0
	 * @since	18-04-2019*/

public String text;
PApplet sketch;
PImage img;
float x, y, a, b; 
float x_speed = 0, y_speed = 0;
int j = 0, i = 0,k;
String background, highlight, file_name, keep;
float size;
public textanim(PApplet sketch, String text,float size, String background, String highlight, float x, float y, String file_name) {
	/** This class take a LaTeX command and returns the path of the stored image file.
	 * @param	sketch			Points to the current PApplet.		
	 * @param 	text			Input LaTex Command.
	 * @param 	file_name		Name of the image file
	 * @param	size			Font size
	 * @param	background		Text Color
	 * @param	highlight		Text Highlight Color
	 * 
	 * @return	String			Path of the output filename
	 * 
	 * 
	 * 
	 * @usage	textanim object = new textanim();
	 * @draw	object.ImgTeX(this,"Text to render", size, background, highlight, x, y, filename);*/ 
		
		/**Store the LaTeX command into a string.*/
		this.text = text;
		this.sketch = sketch;
		this.size = size;
		this.background = background;
		this.highlight = highlight;
		this.x = x;
		this.y = y;
		this.file_name = file_name;
		j = 0;
		x_speed = 0;
		i = 0;
		k=0;
		
}
public void ImgTeX(String file_name){
	
ColorPalette c = new ColorPalette();
	/**Renders the LaTeX command to the particular expression using JLaTeXMath library*/
	TeXFormula fomule = new TeXFormula(text);
	TeXIcon ti = fomule.createTeXIcon(
	TeXConstants.STYLE_DISPLAY, (float) size);
	/**Create a BufferredImage of the rendered expression.*/
	BufferedImage bi = new BufferedImage(ti.getIconWidth(), ti
	    .getIconHeight(), BufferedImage.TYPE_4BYTE_ABGR);
	/**Create a graphics object and highlight it*/
	Graphics2D g2 = bi.createGraphics();
	if (highlight == "transparent") {
		
	}else {
		g2.setColor(c.Colour(highlight));
		g2.fillRect(0, 0, ti.getIconWidth(), ti.getIconHeight());
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.6f));
	}
	
	JLabel jl = new JLabel();

	/**Store the output file in the particular directory.*/
	File outputfile = new File(file_name +".png");
	jl.setForeground(c.Colour(background));
	ti.paintIcon(jl, g2, 0, 0);
	
	try {
		ImageIO.write(bi, "png", outputfile);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public void drawtext(String file_name) {
	//Load the image file
		img = sketch.loadImage(file_name +".png");
		//Load the image for display
		sketch.image(img, x, y);
}

public int animatetext(String file_name) {
	//Creates the animation of writing on keyboard.
	String[] split = new String[1000];
	String test = "";
	char [] characters = text.toCharArray();
	textanim t;
	if (i < characters.length) {
			x_speed = 0;
			for (i=0;i<characters.length;i++) {
				test = test.concat(Character.toString(characters[i]));
				try {
					if(j==0) {
						t = new textanim(sketch,test,80,"black","transparent", 100, 100 , file_name + j);
						t.ImgTeX(file_name + j);
						split[j] = test;
						j++;
					}else {
						t = new textanim(sketch,test,80,"black","transparent", 100 , 100, file_name + j);
						t.ImgTeX(file_name + j);
						split[j] = test;
						j++;
					}
					
				}catch(Exception e) {
				
				}
				
//				System.out.println(split[j-1]);
//				System.out.println(test);
//				System.out.println(characters.length);
//				System.out.println(j);
//				System.out.println(i);
//				System.out.println(x_speed);
			}
		
		

	}else {
		if (x_speed<j) {
			drawtext(file_name+(int) x_speed);
			x_speed++;
		}else {
			drawtext(file_name+(int) (x_speed-1));
		}
		
	}
	if (x_speed<j) {
		return 1;
	}else {
		return 0;
	}

	
}

public int backspace(String file_name) {
	//Create the animation of pressing backspace on keyboard.
	String[] split = new String[1000];
	String test = "";
	char [] characters = text.toCharArray();
	textanim t;
	if (k < characters.length) {
		x_speed = characters.length-1;
		
			for (k=0;k<characters.length;k++) {
				test = test.concat(Character.toString(characters[k]));
				try {
					if(j==0) {
						t = new textanim(sketch,test,80,"black","transparent", 100, 100 , file_name + j);
						t.ImgTeX(file_name + j);
						split[(int) j] = Character.toString(characters[(int) j]);
						j++;
					}else {
						t = new textanim(sketch,test,80,"black","transparent", 100 , 100, file_name + j);
						t.ImgTeX(file_name + j);
						split[(int) j] = split[(int) (j-1)].concat(Character.toString(characters[j]));
						j++;
					}
					
				}catch(Exception e) {
					//j--;
				
				}
				
//				System.out.println(split[i]);
//				System.out.println(characters.length);
//				System.out.println(j);
//				System.out.println(i);
//				System.out.println(x_speed);
			}
		
		

	}else {
		if (j>0) {
			drawtext(file_name+(int)j);
			j--;
			return 1;
		}else {
			return 0;
			
		}
		
	}
	if (j>0) {
		return 1;
	}else {
		return 0;
		
	}
}
public int movetext(String file_name, int x, int y, int a, int b, String keep) {
	/**This class move the text object from (x,y) to (a,b)
	 * @param 	sketch	Points to the current PApplet.
	 * @param	im		The image vector of the object to be moved.
	 * @param	x		X-coordinate of the object
	 * @param	y		Y-coordinate of the object
	 * @param	a		A-coordinate of the object
	 * @param	b		B-coordinate of the object*/
	//Load the image file
	img = sketch.loadImage(file_name +".png");

	if (keep == "copy") {
		sketch.image(img, x, y);
	}
	/**Moves the current image vector to the specified location (a,b) 
	 * at the speed of x_speed and y_speed until  it reaches either of the coordinates.*/
	if (x + x_speed > a || y + y_speed > b) {
		sketch.image(img, a, b);
		return 0;
	}else {
		x_speed += 5;
		y_speed += 5;
		sketch.image(img, x + x_speed, y + y_speed);
		return 1;
	}
}

}
