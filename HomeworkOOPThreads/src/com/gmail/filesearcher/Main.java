package com.gmail.filesearcher;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("/Users/olegivanov/Desktop/WORK");
		String sName = "car.jpg";
		FileSearcher fs = new FileSearcher(5);
		fs.search(file, sName);

		for (int i = 0; i < fs.getTs().length; i++) {
			try {
				if (fs.getTs()[i] != null) {
					fs.getTs()[i].join();
				}

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(fs.getAdds().size());

	}

}
