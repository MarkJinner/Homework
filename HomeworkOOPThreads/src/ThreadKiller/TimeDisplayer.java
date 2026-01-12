package ThreadKiller;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeDisplayer implements Runnable{
	private SimpleDateFormat sdf;
	private Date date;
	
	public TimeDisplayer() {
		date = new Date();
		sdf = new SimpleDateFormat("dd:mm:ss");
	}

	public SimpleDateFormat getSdf() {
		return sdf;
	}

	public void setSdf(SimpleDateFormat sdf) {
		this.sdf = sdf;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public void runTimeDisplay() {
		while(!Thread.currentThread().isInterrupted()) {
			System.out.println(sdf.format(new Date()));
			try {
				Thread.currentThread().sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				break;
			}
		}
		System.out.println("TimeDisplayer has been stopped");
	}
	
	@Override
	public void run() {
		this.runTimeDisplay();
	}
}
