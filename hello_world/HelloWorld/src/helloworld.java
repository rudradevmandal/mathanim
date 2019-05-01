import java.awt.Color;
import java.io.File;

import com.hamoid.VideoExport;

import mathanim.OneDimGrid.OneDGrid;
import mathanim.TwoDimGrid.XYGrid;
import mathanim.color.ColorPalette;
import mathanim.text.textanim;
import mathanim.video.VideoOut;
import processing.core.PApplet;
import processing.core.PImage;

public class helloworld extends PApplet{
	textanim tex1,tex2,tex3,tex4;
	static XYGrid p;
	static OneDGrid o,o1,o2;
	VideoOut video;
	String file1,file2, fileb, file_mark; 	
	VideoExport videoExport;
	PImage t1, t2;
	int i = 0;
	int test,xo,yo;
	String text,text1,text2,text3,text4,dir;
	textanim tex;
	Color col,col1;
	int ani_grid,ani_tex,ani_texb,ani_texc,ani_gridb,ani_texd,ani_gridc,ani_texe,ani_tex3,ani_tex4,ani_tex2b,ani_tex3b,ani_tex4b;
	File dir1;
	ColorPalette c;
	
	
	public void settings(){
		size(1920, 1080);
		
	}
	
	public void setup() {
		xo = width/2;
		yo = height/2;
		 
		  oneDaddSetup();
		 
		}
	
	public void draw(){
		background(255);
		
		oneDadd();
		  

		  
		 
	}
	public void keyPressed() {
		  if (key == 'q') {
		    videoExport.endMovie();
		    exit();
		  }
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] processingArgs = {"MySketch"};
		helloworld mySketch = new helloworld();
		PApplet.runSketch(processingArgs, mySketch);

	}
	
	
	public void oneDlineSetup() {
		text = "\\tt This\\ is\\ you.\\ And...";
		text1 = "\\tt This\\ is\\ your\\ world.";
		file1 = "C:\\Users\\rudra\\Desktop\\study\\hello_world\\text1_";
		fileb = "C:\\Users\\rudra\\Desktop\\study\\hello_world\\textb_";
		file2 = "C:\\Users\\rudra\\Desktop\\study\\hello_world\\text2_";
		o = new OneDGrid(this, "blue","gray","pink", height, width);
		tex1 = new textanim(this,text,80,"black","transparent", (xo-300), (yo-200), file1);
		tex2 = new textanim(this,text1,80,"black","transparent", (xo-300), (yo-200), file2);
		ColorPalette c = new ColorPalette();
		col = c.Colour("pink");
		col1 = c.Colour("orange");
		  //text1.ImgTeX(file1);
		  //text2.ImgTeX(file2);
		test = 0;
		i = 0;
		video = new VideoOut(this,"C:\\Users\\rudra\\Desktop\\study\\hello_world\\hello_world.mp4", 100 , 320, 60);
		video.set();

		
	}
	
	public void oneDline() {
		if(i<100) {
			stroke(col.getRed(), col.getGreen(), col.getBlue());
			strokeWeight(10);
			point(xo, yo);

			tex1.animatetext(file1);
			//text1.backspace(file1);
		}else if (i <200){
			stroke(col.getRed(), col.getGreen(), col.getBlue());
			tex1.backspace(file1);
			o.AnimateOneDGrid(0, 0);
			if(i>150 && i<200) {
				tex2.animatetext(file2);
			}
		}else {
			o.staticgrid(0, 0);
			o.markgrid(0, 0,file1);
			tex2.ImgTeX(file2);
			tex2.drawtext(file2);
		}
		video.start();
		i++;

		
	}
	
	public void oneDaddSetup() {
		//Setting up text
		text = "\\tt Adding\\ 2\\ +\\ 2...";
		text1 = "\\tt Start\\ with\\ 0\\ +\\ 2";
		text2 = "\\tt Then\\ add\\ 0\\ +\\ 2\\ +\\ 2";
		text3 = "\\tt See\\ how\\ 0\\ lines\\ up\\ with\\ 4.";
		text4 = "\\tt So\\ that's\\ our\\ answer.";
		//Setting up the file directory
		dir = "D:\\study\\hello_world\\oneDadd";
		file1 = "D:\\study\\hello_world\\oneDadd\\adding";
		file_mark = "D:\\study\\hello_world\\oneDadd\\adding_mark";
		dir1 = new File(dir);
		//Initiaising the 1D lines
		o1 = new OneDGrid(this, "blue","gray","pink", height, width);
		o2 = new OneDGrid(this, "blue","gray","pink", height, width);
		//Rendering the LaTeX text
		tex = new textanim(this,text,80,"black","transparent", (xo-300), (yo-200), file1);
		tex1 = new textanim(this,text1,80,"black","transparent", (xo-300), (yo-200), file1);
		tex2 = new textanim(this,text2,80,"black","transparent", (xo-300), (yo-200), file1);
		tex3 = new textanim(this,text3,80,"black","transparent", (xo-300), (yo-200), file1);
		tex4 = new textanim(this,text4,80,"black","transparent", (xo-300), (yo-200), file1);
		ColorPalette c = new ColorPalette();
		col = c.Colour("pink");
		//Initialising some dummy counting variables
		test = 0;
		i = 0;
		//Initialising the Video output
		video = new VideoOut(this,"C:\\Users\\rudra\\Desktop\\study\\hello_world\\oneDadd\\oneDadd.mp4", 100 , 320, 60);
		video.set();

		ani_grid = 1;
		ani_tex = 1;
		ani_texb = 1;
		ani_texc = 1;
		ani_texd = 1;
		ani_texe = 1;
		ani_tex2b = 1;
		ani_tex3 = 1;
		ani_tex3b = 1;
		ani_tex4 = 1;
		ani_tex4b = 1;
		ani_gridb = 1;
		ani_gridc = 1;
		
	}
	public void oneDadd() {
		//Waiting for the line to get animated
		if(ani_grid == 1 || ani_tex == 1) {
			ani_grid = o1.AnimateOneDGrid(0, 0);
			ani_tex = tex.animatetext(file1);
			dir1.delete();
		}else if(ani_texb == 1) {
			o1.staticgrid(0, 0);
			o1.markgrid(0, 0,file_mark + "o");
			ani_texb = tex.backspace(file1);
			dir1.delete();
			
			
		}else if(ani_texc == 1) {
			o1.staticgrid(0, 0);
			o1.markgrid(0, 0,file_mark + "o");
			ani_texc = tex1.animatetext(file1);
			dir1.delete();
			
		}
		//Waiting for the second line to move
		else if(ani_gridb == 1) {
			tex1.ImgTeX(file1);
			tex1.drawtext(file1);
			o1.staticgrid(0, 0);
			o1.markgrid(0, 0,file_mark + "o");
			ani_gridb = o1.movegrid(0, 0, 200, 200,file_mark+"s");
		}else if(ani_texd == 1) {
			o1.staticgrid(0, 0);
			o1.markgrid(0, 0,file_mark + "o");
			o1.staticgrid(200, 200);
			o1.markgrid(200, 200,file_mark + "s");
			ani_texd = tex1.backspace(file1);
			dir1.delete();
		}else if(ani_gridc == 1 || ani_texe == 1) {
			ani_texe = tex2.animatetext(file1);
			o1.staticgrid(0, 0);
			o1.markgrid(0, 0,file_mark + "o");
//			o1.staticgrid(200, 200);
			ani_gridc = o1.movegrid(200, 200, 400, 200,file_mark+"s");
			dir1.delete();
		}
		//Showing addition
		else if(ani_tex2b == 1){
			o1.staticgrid(0, 0);
			o1.markgrid(0, 0,file_mark + "o");
			o1.staticgrid(400, 200);
			o1.markgrid(400, 200,file_mark + "s");
			ani_tex2b = tex2.backspace(file1);
			dir1.delete();
		}else if(ani_tex3 == 1){
			o1.staticgrid(0, 0);
			o1.markgrid(0, 0,file_mark + "o");
			o1.staticgrid(400, 200);
			o1.markgrid(400, 200,file_mark + "s");
			ani_tex3 = tex3.animatetext(file1);
			stroke(col.getRed(), col.getGreen(), col.getBlue());
			strokeWeight(2);
			line(xo+400,yo, xo+400,yo+200);
			dir1.delete();
		}else if(ani_tex3b == 1){
			o1.staticgrid(0, 0);
			o1.markgrid(0, 0,file_mark + "o");
			o1.staticgrid(400, 200);
			o1.markgrid(400, 200,file_mark + "s");
			stroke(col.getRed(), col.getGreen(), col.getBlue());
			strokeWeight(2);
			line(xo+400,yo, xo+400,yo+200);
			ani_tex3b = tex3.backspace(file1);
			dir1.delete();
		}else if(ani_tex4 == 1){
			o1.staticgrid(0, 0);
			o1.markgrid(0, 0,file_mark + "o");
			o1.staticgrid(400, 200);
			o1.markgrid(400, 200,file_mark + "s");
			stroke(col.getRed(), col.getGreen(), col.getBlue());
			strokeWeight(2);
			line(xo+400,yo, xo+400,yo+200);
			ani_tex4 = tex4.animatetext(file1);			
			dir1.delete();
		}else {
			tex4.ImgTeX(file1);
			tex4.drawtext(file1);
			o1.staticgrid(0, 0);
			o1.markgrid(0, 0,file_mark + "o");
			o1.staticgrid(400, 200);
			o1.markgrid(400, 200,file_mark + "s");
			stroke(col.getRed(), col.getGreen(), col.getBlue());
			strokeWeight(2);
			line(xo+400,yo, xo+400,yo+200);
			dir1.delete();
			
		}

		video.start();
		i++;
	}


}
