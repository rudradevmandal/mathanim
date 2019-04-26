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
int x, y, a, b;
int x_speed = 0;
int y_speed = 0;
String file_name, keep;
public PImage ImgTeX(PApplet sketch, String text,int size, String background, String highlight, int x, int y, String file_name){
	
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
	this.file_name = file_name;
	ColorPalette c = new ColorPalette();
	/**Convert the LaTeX command to the particular expression using JLaTeXMath library*/
	TeXFormula fomule = new TeXFormula(text);
	TeXIcon ti = fomule.createTeXIcon(
	TeXConstants.STYLE_DISPLAY, size);
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
	
	//Load the image file
	img = sketch.loadImage(file_name +".png");
	//Load the image for display
	sketch.image(img, x, y);
	return img;

	
}
public void movetext(PApplet sketch,PImage im, int x, int y, int a, int b, String keep) {
	/**This class move the text object from (x,y) to (a,b)
	 * @param 	sketch	Points to the current PApplet.
	 * @param	im		The image vector of the object to be moved.
	 * @param	x		X-coordinate of the object
	 * @param	y		Y-coordinate of the object
	 * @param	a		A-coordinate of the object
	 * @param	b		B-coordinate of the object*/
	this.img = im;
	this.sketch = sketch;
	if (keep == "copy") {
		sketch.image(img, x, y);
	}
	/**Moves the current image vector to the specified location (a,b) 
	 * at the speed of x_speed and y_speed until  it reaches either of the coordinates.*/
	if (x + x_speed > a || y + y_speed > b) {
		sketch.image(img, a, b);
	}else {
		x_speed += 5;
		y_speed += 5;
		sketch.image(img, x + x_speed, y + y_speed);
	}
}

}
