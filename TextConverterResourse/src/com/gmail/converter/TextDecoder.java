package com.gmail.converter;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class TextDecoder {

	public TextDecoder() {
		
	}
	
	public String decode(String encoded) throws UnsupportedEncodingException {
		return URLDecoder.decode(encoded, "UTF-8");
	}
}
