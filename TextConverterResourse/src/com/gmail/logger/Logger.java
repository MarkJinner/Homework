package com.gmail.logger;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

import com.gmail.exceptions.PageNotFoundException;

public class Logger implements DateConverter, StackTraceConverter{
	
	public static void main(String [] args) throws IOException {
		Logger lg = new Logger();
		lg.log("test 1");
		lg.log("test 2");
		PageNotFoundException e = new PageNotFoundException();
		lg.log(e);
	}
	
	public Logger() {
		
	}
	
	public void log(String message) throws IOException {
		Path pathFile  = Paths.get(new File("log_storage.txt").getAbsolutePath());
		try (ByteChannel bc = Files.newByteChannel(pathFile, StandardOpenOption.CREATE,
				StandardOpenOption.APPEND,StandardOpenOption.WRITE)){
			ByteBuffer bb = ByteBuffer.allocate(1024);
			bb.put((formatDate()+" "+message+System.lineSeparator()).getBytes());
			bb.rewind();
			bb.clear();
			bc.write(bb);
			
		}
	}
	
	public void log(Exception e) throws IOException {
		String sTrace = this.convert(e);
		log(sTrace);
	}
	
	@Override
	public String formatDate() {
		return new SimpleDateFormat("YYYY:MMMM:dd HH:mm:ss", new Locale("ENG", "EN")).format(new Date());
	}

	@Override
	public <T extends Exception> String convert(Exception e) {
		StringBuilder sb = new StringBuilder();
		sb.append(System.lineSeparator()+e);
		Arrays.stream(e.getStackTrace()).forEach(s->sb.append(System.lineSeparator()+s));
		return sb.toString();
	}

	
}
