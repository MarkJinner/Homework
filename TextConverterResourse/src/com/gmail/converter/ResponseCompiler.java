package com.gmail.converter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

import com.gmail.exceptions.PageNotFoundException;
import com.gmail.logger.Logger;

public class ResponseCompiler implements BrowserResponseCompiler {
	private PagesLibrary lib;
	private Logger logger;
	private String address;

	public ResponseCompiler(String address) {
		this.address = address;
		logger = new Logger();
		lib = new PagesLibrary(address);
	}

	@Override
	public Optional<Page> compileResponse(String request, String address) throws PageNotFoundException, IOException {
		String req = request.split(System.lineSeparator())[0];
		System.out.println(address);
		String specified = "";
		System.out.println("req = "+req);
//		if (req.length() > 0) {
			specified = req.substring(req.indexOf("GET /") + "GET /".length(), req.indexOf(" HTTP/1.1"));
//		}

		try {
			if (specified.contains("main") || specified.equals("") || specified.equals(" ")) {
				Optional<Page> requestedPage = Optional.ofNullable(lib.mainPage());
				if (requestedPage.isPresent()) {
					return requestedPage;
				}
			} else if (specified.contains("toUpperCaseTransformer")) {
				System.out.println("yres!!!");
				return new PageLoader().loadPage("underConstruction");
			} else if (specified.contains("underConstruction")) {
				return new PageLoader().loadPage("underConstruction");
			} else {
				return Optional.ofNullable(new PagesLibrary().defaultPage());
			}

		} catch (PageNotFoundException e) {
			logger.log(e);
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			logger.log(e);
			e.printStackTrace();
		}

		return Optional.ofNullable(new PagesLibrary().defaultPage());

	}

}
