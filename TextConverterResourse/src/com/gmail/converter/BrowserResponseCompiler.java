package com.gmail.converter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

import com.gmail.exceptions.PageNotFoundException;

public interface BrowserResponseCompiler {
	
	public Optional<Page> compileResponse(String request, String address) throws PageNotFoundException, FileNotFoundException, IOException;
}
