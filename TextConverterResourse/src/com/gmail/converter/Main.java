package com.gmail.converter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		String siteAddr = "http://localhost:8091";
		try {
			Main.runSite(siteAddr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void runSite(String address) throws IOException {
		SiteServer sServer = new SiteServer(address);
		sServer.run();


	}
	
	
	

	

}
