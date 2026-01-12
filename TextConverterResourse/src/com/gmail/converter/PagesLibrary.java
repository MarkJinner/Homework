package com.gmail.converter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

import com.gmail.exceptions.PageNotFoundException;

public class PagesLibrary {
	private PageLoader loader; 
	public Page defaultPage; 
	public Page mainPage;
	private String siteAddress;
	private String pathToPages = "/Users/olegivanov/Homework/TextConverterResourse/src/pages/";
	private Languages langs;
	private LangRequestConverter converter = new LangRequestConverter();
	
	public PagesLibrary(String addr) {
		this.siteAddress = addr;
		loader = new PageLoader(siteAddress);
		this.siteAddress = addr;
	}
	
	public PagesLibrary() {
		loader = new PageLoader();
	}
	
	
	public PageLoader getLoader() {
		return loader;
	}

	public void setLoader(PageLoader loader) {
		this.loader = loader;
	}

	public Page getDefaultPage() {
		return defaultPage;
	}

	public void setDefaultPage(Page defaultPage) {
		this.defaultPage = defaultPage;
	}

	public Page getMainPage() {
		return mainPage;
	}

	public void setMainPage(Page mainPage) {
		this.mainPage = mainPage;
	}

	public String getSiteAddress() {
		return siteAddress;
	}

	public void setSiteAddress(String siteAddress) {
		this.siteAddress = siteAddress;
	}
	
	public Optional<Page> getPage(String pageName) throws FileNotFoundException, IOException, PageNotFoundException {
//		System.out.println("PageName in lib = "+pageName);
		if(checkPage(pageName)) {
			return loader.loadPage(pageName);
		}
		else if(checkOtherLanguagePageRequest(pageName)) {
			return loader.loadPage(converter.convertLangRequest(pageName));
		}
		throw new FileNotFoundException("Requested page not found");
	}
	
	public static void main(String [] args) {
		String addr = "default";
		PagesLibrary lib = new PagesLibrary();
		System.out.println(lib.checkPage(addr));
	}
	
	private boolean checkPage(String name) {
		if(Arrays.stream(new File(pathToPages).list()).anyMatch(s->s.equals(name+".html"))){
			return true;
		}	
		return false;
	}
	
	private boolean checkOtherLanguagePageRequest(String specified) {
		return Arrays.stream(langs.values()).anyMatch(s->specified.contains(s.value));
	}
	
	

	public Page defaultPage() throws FileNotFoundException, IOException, PageNotFoundException {
		return this.defaultPage = loader.loadPage("default").get();
	}
	public Page mainPage() throws FileNotFoundException, IOException, PageNotFoundException {
		return this.mainPage = loader.loadPage("main").get();
	}
	
	
	
	
	
	class Message {
		private String defaultMessage = "Requested page not found";
		private String underConstruction = "Page under construction";
	}
}
