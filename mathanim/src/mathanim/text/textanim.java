package mathanim.text;

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
public String ImgTeX(String text,int size, String background, String highlight, String file_name){
	
/** This class take a LaTeX command and returns the path of the stored image file.
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
 * @setup	PImage Image = loadimage(object.ImgTeX("Latex Command", size, text color, text highlight, file name));
 * @draw	image(Image ,x coordinate, y coordinate);*/ 
	
	/**Store the LaTeX command into a string.*/
	this.text = text;
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
	g2.setColor(c.Colour(highlight));
	g2.fillRect(0, 0, ti.getIconWidth(), ti.getIconHeight());
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
	/**Return the file path for loadimage().*/
	return file_name +".png";
	
}
}
