package com.gmail.oi;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class URLChecker {
	private List<String> adds;

	public URLChecker() {

	}

	public List<String> checkURLs(File file) throws IOException {
		Stream<String> stream = Files.lines(file.toPath());
//		List<String> result = stream.filter((s)->s.)
		return adds;

	}

	public int checkAvailability(String add) throws URISyntaxException, IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder(new URI(add)).build();
		 
		   HttpClient client = HttpClient.newBuilder()
		        .version(Version.HTTP_1_1)
		        .build();
		 
		   HttpResponse<Path> response = client.send(request, BodyHandlers.ofFile(new File("log").toPath()));
//		   System.out.println(response.statusCode() );
//		   System.out.println(response.body()); 
		   return response.statusCode();
	}

}
