package mathanim.color;
import java.awt.Color;
public class ColorPalette {
	/**Definition of all colors to be used for animation.
	 * 
	 * @author	Rudra Dev Mandal
	 * @version	1.0
	 * @since	18-04-2019*/
	
	public Color Colour(String col) {
		/**
		 * @usage	ColorPalette color = new ColorPalette();
		 * 			Color c = new Color();
		 * 			c = color.Colour("Name of the color");*/
		
		
		/**The standard color palette:
		 * @BLACK			[0,0,0]
		 * @BLUE			[0,170,255]
		 * @Light_Blue		[100,200,255]
		 * @Purple			[196,0,255]
		 * @Light_Purple	[196,128,255]
		 * @CYAN			[0,255,255]
		 * @DARK_GRAY		[64,64,64]
		 * @GRAY			[128,128,128]
		 * @GREEN			[64,255,0]
		 * @Light_Green		[128,255,128]
		 * @LIGHT_GRAY		[192,192,192]
		 * @MAGENTA			[255,0,255]
		 * @ORANGE			[255,100,0]
		 * @Light_Orange	[255,150,64]
		 * @PINK			[255,0,255]
		 * @Light_Pink		[255,128,220]
		 * @WHITE			[255,255,255]
		 * @RED				[255,64,64]
		 * @Light_Red		[255,128,128]
		 * @YELLOW			[255,255,32]
		 * @Light_Yellow	[255,255,128]
		 */
		Color C = null;
		if (col == "black") {
			C = Color.BLACK;			
		}
		else if (col == "blue") {
			C = new Color(0,170,255);
		}
		else if (col == "light_blue") {
			C = new Color(100,200,255);
		}

		else if (col == "purple") {
			C = new Color(196,0,255);
		}

		else if (col == "light_purple") {
			C = new Color(196,128,255);
		}
		else if (col == "cyan") {
			C = Color.CYAN;
		}
		else if (col == "dark_gray") {
			C = Color.DARK_GRAY;
		}
		else if (col == "gray") {
			C = Color.GRAY;
		}
		else if (col == "green") {
			C = new Color(64,255,0);
		}
		else if (col == "light_green") {
			C = new Color(128,255,128);
		}
		else if (col == "light_gray") {
			C = Color.LIGHT_GRAY;
		}
		else if (col == "magenta") {
			C = Color.MAGENTA;
		}
		else if (col == "orange") {
			C = new Color(255,100,0);
		}
		else if (col == "light_orange") {
			C = new Color(255,150,64);
		}
		else if (col == "pink") {
			C = new Color(255,0,225);
		}

		else if (col == "light_pink") {
			C = new Color(255,128,220);
		}
		else if (col == "white") {
			C = Color.WHITE;
		}
		else if (col == "red") {
			C = new Color(255,64,64);
		}
		else if (col == "light_red") {
			C = new Color(255,128,128);
		}
		else if (col == "yellow") {
			C = new Color(255,255,32);
		}
		else if (col == "light_yellow") {
			C = new Color(255,255,128);
		}
		else {
			C = Color.WHITE;
		}
		return C;
		
	}

}
