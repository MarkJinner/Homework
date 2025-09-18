package com.gmail.converter;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.gmail.exceptions.PageNotFoundException;

public class PagesLibrary {
	private PageLoader loader; 
	private Page defaultPage;
	private Page mainPage;
	private String siteAddress;
	
	public PagesLibrary(String addr) {
		this.siteAddress = addr;
		loader = new PageLoader(siteAddress);
		this.siteAddress = addr;
	}
	
	public PagesLibrary() {
		loader = new PageLoader();
	}
	
	
	
	public Page defaultPage() throws FileNotFoundException, IOException, PageNotFoundException {
		return defaultPage = loader.loadPage("default").get();
	}
	public Page mainPage() throws FileNotFoundException, IOException, PageNotFoundException {
		return mainPage = loader.loadPage("main").get();
	}
	
	class Message {
		private String defaultMessage = "Requested page not found";
		private String underConstruction = "Page under construction";
	}
}
