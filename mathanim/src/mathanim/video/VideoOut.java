package mathanim.video;

import com.hamoid.VideoExport;

import processing.core.PApplet;

public class VideoOut {
	/**For video Exporting*/
	/**Initialising the variables
	 * @param	FilePath		Path where the file is to be saved.
	 * @param	FFMpegPath		Path of the parent FFMpeg.exe file
	 * @param	VideoQuality	Quality if the Video(100 = best , 0 = Worst)
	 * @param	AudioQuality	Quality if the Video(320 = best , 0 = Worst)
	 * @param 	FrameRate		No of frames per second to be captured(60 is default)
	 * 
	 * 
	 * @author 	Rudra Dev Mandal
	 * @version	1.0	
	 * @since	24-04-2019*/

	String FilePath;
	String FFMpegPath = "C:\\FFmpeg\\bin\\FFmpeg.exe";
	int VideoQuality, AudioQuality, FrameRate;
	PApplet sketch;
	VideoExport v;
	
	public VideoOut(PApplet sketch, String FilePath, int VideoQuality, int AudioQuality, int FrameRate) {
		/**
		 * @usage	VideoOut object;
		 * @setup	Object = new VideoOut(this, "FilePath", VideoQuality=100, AudioQualtiy=320, FrameRate=60);
		 * 			Object.set();			
		 * @draw	Object.start;	*/
		/**Assign the current object to all the variables declared using "this" keyword.*/
		this.sketch = sketch;
		this.FilePath = FilePath;
		this.VideoQuality = VideoQuality;
		this.AudioQuality = AudioQuality;
		this.FrameRate = FrameRate;
	}
	public void set() {
		/**Initializes all the variables
		 * @return		Void*/
		v = new VideoExport(sketch);
		v.setFfmpegPath(FFMpegPath);
		v.setMovieFileName(FilePath);;
		v.setQuality(VideoQuality, AudioQuality);
		v.setFrameRate(FrameRate);
		v.startMovie();
		
	}
	public void start() {
		/**Captures the current frames/second and converts it into mp4*/
		v.saveFrame();
	}
}
