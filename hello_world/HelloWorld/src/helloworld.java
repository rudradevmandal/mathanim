import java.awt.Color;
import java.io.File;
import java.util.concurrent.TimeUnit;

import com.hamoid.VideoExport;

import mathanim.OneDimGrid.OneDGrid;
import mathanim.TwoDimGrid.XYGrid;
import mathanim.color.ColorPalette;
import mathanim.common.common;
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
	int ani_grid,ani_tex,ani_texb,ani_texc,ani_gridb,ani_texd,ani_gridc,ani_texe,ani_tex3,ani_tex4,ani_tex2b,ani_tex3b,ani_tex4b,ani_num,ani_mul,ani_mulb;
	File dir1;
	ColorPalette c;
	common com;
	
	
	public void settings(){
		size(1920, 1080);
		
	}
	
	public void setup() {
		xo = width/2;
		yo = height/2;
		 
		basisVecSetup();
		 
		}
	
	public void draw(){
		background(255);
		
		basisVec();
		  

		  
		 
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
		o = new OneDGrid(this, "blue","gray","orange", height, width);
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
			stroke(col1.getRed(), col1.getGreen(), col1.getBlue());
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
		o1 = new OneDGrid(this, "blue","gray","orange", height, width);
		o2 = new OneDGrid(this, "blue","gray","orange", height, width);
		//Rendering the LaTeX text
		tex = new textanim(this,text,80,"black","transparent", (xo-300), (yo-200), file1);
		tex1 = new textanim(this,text1,80,"black","transparent", (xo-300), (yo-200), file1);
		tex2 = new textanim(this,text2,80,"black","transparent", (xo-300), (yo-200), file1);
		tex3 = new textanim(this,text3,80,"black","transparent", (xo-300), (yo-200), file1);
		tex4 = new textanim(this,text4,80,"black","transparent", (xo-300), (yo-200), file1);
		ColorPalette c = new ColorPalette();
		col = c.Colour("orange");
		com = new common(this,height,width);
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
		ani_num = 1;
		
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
		}else if(ani_tex3 == 1 || ani_num == 1){
			o1.staticgrid(0, 0);
			o1.markgrid(0, 0,file_mark + "o");
			o1.staticgrid(400, 200);
			o1.markgrid(400, 200,file_mark + "s");
			ani_num = com.dottedline(400, -200, 400, 0, "orange");
			ani_tex3 = tex3.animatetext(file1);
			
			dir1.delete();
		}else if(ani_tex3b == 1){
			o1.staticgrid(0, 0);
			o1.markgrid(0, 0,file_mark + "o");
			o1.staticgrid(400, 200);
			o1.markgrid(400, 200,file_mark + "s");
			com.dottedline(400, -200, 400, 0, "orange");
			

			ani_tex3b = tex3.backspace(file1);
			
			dir1.delete();
			try {
				TimeUnit.MINUTES.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if(ani_tex4 == 1){
			o1.staticgrid(0, 0);
			o1.markgrid(0, 0,file_mark + "o");
			o1.staticgrid(400, 200);
			o1.markgrid(400, 200,file_mark + "s");
			stroke(col.getRed(), col.getGreen(), col.getBlue());
			com.dottedline(400, -200, 400, 0, "orange");
			ani_tex4 = tex4.animatetext(file1);			
			dir1.delete();
		}else {
			tex4.ImgTeX(file1);
			tex4.drawtext(file1);
			o1.staticgrid(0, 0);
			o1.markgrid(0, 0,file_mark + "o");
			o1.staticgrid(400, 200);
			o1.markgrid(400, 200,file_mark + "s");
			com.dottedline(400, -200, 400, 0, "orange");
			dir1.delete();
			
		}

		video.start();
		i++;
	}
	
	public void oneDmulSetup() {
		//Setting up text
				text = "\\tt Multiplying\\ 2\\ x\\ 2...";
				text1 = "\\tt Start\\ with\\ 1\\ x\\ 2";
				text2 = "\\tt Then\\ multiply\\ 1\\ x\\ 2\\ x\\ 2";
				text3 = "\\tt See\\ how\\ 1\\ lines\\ up\\ with\\ 4.";
				text4 = "\\tt So\\ that's\\ our\\ answer.";
				//Setting up the file directory
				dir = "D:\\study\\hello_world\\oneDmul";
				file1 = "D:\\study\\hello_world\\oneDmul\\multiplying";
				file_mark = "D:\\study\\hello_world\\oneDmul\\multiplying_mark";
				dir1 = new File(dir);
				//Initiaising the 1D lines
				o1 = new OneDGrid(this, "blue","gray","orange", height, width);
				o2 = new OneDGrid(this, "blue","gray","orange", height, width);
				//Rendering the LaTeX text
				tex = new textanim(this,text,80,"black","transparent", (xo-300), (yo-200), file1);
				tex1 = new textanim(this,text1,80,"black","transparent", (xo-300), (yo-200), file1);
				tex2 = new textanim(this,text2,80,"black","transparent", (xo-300), (yo-200), file1);
				tex3 = new textanim(this,text3,80,"black","transparent", (xo-300), (yo-200), file1);
				tex4 = new textanim(this,text4,80,"black","transparent", (xo-300), (yo-200), file1);
				ColorPalette c = new ColorPalette();
				col = c.Colour("orange");
				com = new common(this,height,width);
				//Initialising some dummy counting variables
				test = 0;
				i = 0;
				//Initialising the Video output
				video = new VideoOut(this,"C:\\Users\\rudra\\Desktop\\study\\hello_world\\oneDmul\\oneDmul.mp4", 100 , 320, 60);
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
				ani_num = 1;
				ani_mul = 1;
				ani_mulb = 1;
		
	}
	
	public void oneDmul() {
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
			ani_gridb = o1.movegrid(0, 0, 0, 200,file_mark+"s");
		}else if(ani_mul == 1){
			o1.staticgrid(0, 0);
			o1.markgrid(0, 0,file_mark + "o");
			o1.staticgrid(0,200);
			tex1.ImgTeX(file1);
			tex1.drawtext(file1);
			ani_mul = o1.stretchgrid(0, 200, 2, file_mark+"m");
		}else if(ani_texd == 1){
			o1.staticgrid(0, 0);
			o1.markgrid(0, 0,file_mark + "o");
			o1.staticgrid(0,200);
			o1.custommarkgrid(0, 200, 2, file_mark+"c");
			ani_texd = tex1.backspace(file1);
			dir1.delete();
		}else if(ani_texe == 1) {
			o1.staticgrid(0, 0);
			o1.markgrid(0, 0,file_mark + "o");
			o1.staticgrid(0,200);
			o1.custommarkgrid(0, 200, 2, file_mark+"c");
			ani_texe = tex2.animatetext(file1);
			dir1.delete();			
		}else if(ani_mulb == 1){
			o1.staticgrid(0, 0);
			o1.markgrid(0, 0,file_mark + "o");
			o1.staticgrid(0,200);
			tex2.ImgTeX(file1);
			tex2.drawtext(file1);
			ani_mulb = o1.stretchgrid(0, 200, 4, file_mark+"m1");
		}else if(ani_tex2b == 1) {
			o1.staticgrid(0, 0);
			o1.markgrid(0, 0,file_mark + "o");
			o1.staticgrid(0,200);
			o1.custommarkgrid(0, 200, 4, file_mark+"c");
			ani_tex2b = tex2.backspace(file1);
			dir1.delete();
		}else if(ani_tex3 == 1) {
			o1.staticgrid(0, 0);
			o1.markgrid(0, 0,file_mark + "o");
			o1.staticgrid(0,200);
			o1.custommarkgrid(0, 200, 4, file_mark+"c");
			ani_tex3 = tex3.animatetext(file1);
			com.dottedline(400, -200, 400, 0, "orange");
			dir1.delete();
		}else if(ani_tex3b == 1) {
			o1.staticgrid(0, 0);
			o1.markgrid(0, 0,file_mark + "o");
			o1.staticgrid(0,200);
			o1.custommarkgrid(0, 200, 4, file_mark+"c");
			ani_tex3b = tex3.backspace(file1);
			com.dottedline(400, -200, 400, 0, "orange");
			dir1.delete();
		}
		else if(ani_tex4 == 1) {
			o1.staticgrid(0, 0);
			o1.markgrid(0, 0,file_mark + "o");
			o1.staticgrid(0,200);
			o1.custommarkgrid(0, 200, 4, file_mark+"c");
			ani_tex4 = tex4.animatetext(file1);
			com.dottedline(400, -200, 400, 0, "orange");
			dir1.delete();
		}else {
			o1.staticgrid(0, 0);
			o1.markgrid(0, 0,file_mark + "o");
			o1.staticgrid(0,200);
			o1.custommarkgrid(0, 200, 4, file_mark+"c");
			tex4.ImgTeX(file1);
			tex4.drawtext(file1);
			com.dottedline(400, -200, 400, 0, "orange");
		}
		video.start();
		i++;
		
	}
	
	
	public void basisVecSetup() {
		//Setting up text
		text = "\\tt Basis\\ vector\\ along\\ positive\\ x\\ direction.";
		//Setting up the file directory
		dir = "C:\\Users\\rudra\\Desktop\\study\\hello_world\\basisVec";
		file1 = "C:\\Users\\rudra\\Desktop\\study\\hello_world\\basisVec\\text";
		file_mark = "C:\\Users\\rudra\\Desktop\\study\\hello_world\\basisVec\\mark";
		dir1 = new File(dir);
		//Initiaising the 1D lines
		o1 = new OneDGrid(this, "blue","gray","orange", height, width);
		//Rendering the LaTeX text
		tex = new textanim(this,text,80,"black","transparent", (xo-800), (yo-200), file1);
		com = new common(this,height,width);
		//Initialising the Video output
		video = new VideoOut(this,"C:\\Users\\rudra\\Desktop\\study\\hello_world\\basisVec\\basisVec.mp4", 100 , 320, 60);
		video.set();
		
	}
	
	public void basisVec() {
		tex.ImgTeX(file1);
		tex.drawtext(file1);
		o1.staticgrid(0, 0);
		o1.markgrid(0, 0,file_mark + "o");
		c = new ColorPalette();
		com.arrow(0, 0, 100, 0, "orange");
		video.start();
	}


}
