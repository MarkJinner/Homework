package com.gmail.converter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

import com.gmail.exceptions.PageNotFoundException;
import com.gmail.logger.Logger;

import clipboardwrapper.ClipboardWrapper;

public class ResponseCompiler implements BrowserResponseCompiler {
	private PagesLibrary lib;
	private Logger logger;
	private String address;
	private RequestParser parser;
	private AjaxRequestParser ajaxParser;
	private PageLoader loader;
	private ClipboardWrapper clipboardCopier;
	private TextDecoder decoder = new TextDecoder();

	public ResponseCompiler(String address) {
		this.address = address;
		logger = new Logger();
		lib = new PagesLibrary(address);
		parser = new RequestParser();
		loader = new PageLoader(address);
		clipboardCopier = new ClipboardWrapper();
		ajaxParser = new AjaxRequestParser();

	}

	@Override
	public Optional<Page> compileResponse(String request, String address) throws PageNotFoundException, IOException {
		System.out.println("request = " + request);
		request = decoder.decode(request);
		String specified = parser.parseRequest(request);
//		System.out.println("specified = "+specified);
		
		if (ajaxParser.ifAjax(request)) {
			clipboardCopier.copyToClipBoard(ajaxParser.parseRequest(request));
			logger.log("Ajax request: " + parser.parseRequestReferer(request));
			logger.logRequestContent(ajaxParser.getJoinedConverterNameRequestContent(request));
		} else {
			logger.log(parser.parseRequestReferer(request));
			logRequestContent(request);
		}

		

		try {
			if (specified.equals("") || specified.equals(" ")) {
				return Optional.ofNullable(lib.mainPage());
			} else {
				return lib.getPage(specified);
			}

		} catch (PageNotFoundException e) {
			logger.log(e);
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			logger.log(e);
			e.printStackTrace();
		}

		return Optional.ofNullable(lib.defaultPage());

	}

	private void logRequestContent(String req) throws IOException {

		if(req.split(System.lineSeparator())[0].contains("POST")) {
			logger.logRequestContent(parser.parseTextFromPOST(req));
		}
	}

}
