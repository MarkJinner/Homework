package com.gmail.converter;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Optional;

import com.gmail.exceptions.PageNotFoundException;

public class RequestProcessor implements Runnable {
	private Socket sc;
	private String address;
	private ResponseCompiler compiler;
	private PagesLibrary lib;
	private TextDecoder decoder = new TextDecoder();

	public RequestProcessor(Socket sc, String addr) {
		this.sc = sc;
		this.address = addr;
		compiler = new ResponseCompiler(address);
		lib = new PagesLibrary(address);

	}

	public RequestProcessor(Socket sc) {
		this.sc = sc;
		compiler = new ResponseCompiler(address);
		lib = new PagesLibrary(address);

	}

	public RequestProcessor() {

	}

	public Socket getSc() {
		return sc;
	}

	public void setSc(Socket sc) {
		this.sc = sc;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void process(Socket sc) throws IOException, PageNotFoundException {

		try (BufferedInputStream bis = new BufferedInputStream(sc.getInputStream());
				PrintWriter pw = new PrintWriter(sc.getOutputStream())) {
			String request = readRequest(bis);
			if (request.length() > 0) {
				pw.println(sendResponse(request));

			}
		}
	}

	private String readRequest(BufferedInputStream bis) throws IOException {

		byte[] buffer = new byte[bis.available()];
		bis.read(buffer);
		String request = "";
		for (int i = 0; i < buffer.length; i++) {
			request = request + (char) buffer[i];
		}
//		System.out.println("Complete request = "+System.lineSeparator()+request);
//		System.out.println("The end of the request");
		return decoder.decode(request);
	}

	private Page sendResponse(String request) throws PageNotFoundException, IOException {
		Optional<Page> opt = compiler.compileResponse(request, address);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			return lib.defaultPage();
		}

	}

	@Override
	public void run() {
		try {
			process(sc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PageNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
