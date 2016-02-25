package util;

public class TimerUtil {
	
	private String process;
	private long startTime;
	private long stopTime;
	
	public TimerUtil(String process) {
		this.process = process;
	}
	
	public void setStartTime() {
		this.startTime = System.nanoTime();
	}
	
	public void setStopTime() {
		this.stopTime = System.nanoTime();
	}
	
	public void calculateExecTime() {
		System.out.println(this.process + " time taken: " + ((this.stopTime - this.startTime)/1000000) + "ms"); 
	}
}
