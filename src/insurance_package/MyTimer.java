package insurance_package;

import java.util.Date;

public class MyTimer {
	Date start;
	long mSecond;
	long second;
	boolean running = false;
	public MyTimer(){
		start = new Date();
		running = true;
	}
	public long getTimer(){
		if(running){
			Date now = new Date();
			mSecond = now.getTime() - start.getTime();
			second = mSecond/1000;
		}
		return second;
	}
	public void stop(){
		this.running = false;
	}
	public void reset(){
		start = new Date();
		this.running = true;
	}
}

