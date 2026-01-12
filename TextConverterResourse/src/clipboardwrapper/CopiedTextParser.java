package clipboardwrapper;

import java.util.Arrays;

public class CopiedTextParser {
	private String copiedText;
	
	public CopiedTextParser() {
		
	}

	public String getCopiedText() {
		return copiedText;
	}

	public void setCopiedText(String copiedText) {
		this.copiedText = copiedText;
	}
	
	public String parseCopiedText(String request) {
		String temp = cutOffTextFromRequest(request.split(System.lineSeparator())[countRequestLenght(request)-1]);
		if(temp.contains("+")) {
			this.copiedText =  takeOffConnectors(temp);
		}
		return temp;
	}
	
	private int countRequestLenght(String request) {
		return request.split(System.lineSeparator()).length;
	}
	
	private String cutOffTextFromRequest(String request) {
		return request.substring(request.indexOf("=")+1, request.length());
	}
	private String takeOffConnectors(String request) {
		StringBuilder sb = new StringBuilder();	
		Arrays.stream(request.split("\\+")).forEach(s->sb.append(s+" "));
		
		return sb.toString();
	}
	
	
	public static void main(String [] args) {
		CopiedTextParser cp = new CopiedTextParser();
		
		System.out.println(cp.takeOffConnectors("THIS+IS"));
	}
}
