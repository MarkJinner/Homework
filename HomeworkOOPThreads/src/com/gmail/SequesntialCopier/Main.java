package com.gmail.SequesntialCopier;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testApp();
	}
	
	public static void testApp() {
		File file = new File("/Users/olegivanov/Desktop/AllUrban.mp4");
		Buffer buffer = new Buffer();
		DataProvider pro = new DataProvider(buffer, file, 512);
		DataConsumer cons = new DataConsumer(buffer, new File(file.getName()));
		
		ProgressMonitor mon = new ProgressMonitor(buffer);
		
		Runnable run = () -> {
			try {
				mon.monitorProgress();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		run.run();

		
		
		
	}

}
