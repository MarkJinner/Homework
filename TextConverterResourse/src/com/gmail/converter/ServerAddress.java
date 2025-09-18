package com.gmail.converter;

public class ServerAddress {
	private String fullServerAddress = "";
	private String addr = "";
	private int port = 0;

	public ServerAddress(String serverAddress) {
		this.fullServerAddress = serverAddress;
		this.addr = this.parseAddress();
		this.port = this.parsePort();
	}

	public ServerAddress() {

	}
	
	
	public String getFullServerAddress() {
		return fullServerAddress;
	}

	public void setgetFullServerAddress(String serverAddress) {
		this.fullServerAddress = serverAddress;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public static void main(String [] args) {
		String siteAddr = "http://localhost:80";
		ServerAddress sa = new ServerAddress(siteAddr);
		System.out.println("port = "+sa.parsePort());
		System.out.println("address = "+sa.parseAddress());
		System.out.println("fullAddress = "+sa.fullServerAddress);
	}
	
	
	public String parseAddress() {
		return this.addr =  fullServerAddress.substring(0, fullServerAddress.lastIndexOf(":")+1);
	}
	
	public int parsePort() {
		return this.port = Integer.parseInt(fullServerAddress.substring(fullServerAddress.indexOf(":", fullServerAddress.indexOf("//"))+1, fullServerAddress.length()));
	}

}
