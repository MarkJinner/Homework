package com.gmail.niotest;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {
	public static void main(String[] args) {
		try {
			testNIO();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		 
		
	}

	public static void testNIO() throws IOException {
		String text = "This is NIO";
		String text1 = "This is NIO1";
		File file = new File("testfile.txt");
		Path path = Paths.get(file.getAbsolutePath());
		
		try(ByteChannel bc = Files.newByteChannel(path, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.READ)){
			ByteBuffer bb = ByteBuffer.allocate(256);
			bb.put(text.getBytes());
			bb.put(text1.getBytes());
			bb.rewind();
			bc.write(bb);
//			bb.clear();

	
		int x = bb.limit();
		bb.rewind();
		bc.read(bb);
		
		for(int i = 0; i< x;i++) {
			System.out.print((char)bb.get());
		}

		
		
			
		}
	}

}