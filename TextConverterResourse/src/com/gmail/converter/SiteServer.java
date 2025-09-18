package com.gmail.converter;

import java.io.IOException;
import java.net.ServerSocket;

public class SiteServer {
	private String address;
	private ServerAddress servAddress;

	

	public SiteServer(String add) {
		this.address = add;
		this.servAddress = new ServerAddress(add);

	}

	public SiteServer() {
		this.servAddress = new ServerAddress();
	}
	
	
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ServerAddress getServAddress() {
		return servAddress;
	}

	public void setServAddress(ServerAddress servAddress) {
		this.servAddress = servAddress;
	}

	public static void main(String [] args) throws IOException {
		ServerSocket ss = new ServerSocket();
		
	}
	
	static {
		System.out.println("Server launched");
		
	}

	public void run() throws IOException {
		ServerSocket ss = new ServerSocket(servAddress.parsePort());
		while (Thread.currentThread().isAlive()) {
			Thread one = new Thread(new RequestProcessor(ss.accept(),servAddress.getFullServerAddress()));
			one.start();
		}
	}
}
