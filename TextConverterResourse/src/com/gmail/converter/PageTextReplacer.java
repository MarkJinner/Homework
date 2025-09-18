package com.gmail.converter;

public class PageTextReplacer {

	private StringBuilder sb;

	public PageTextReplacer(StringBuilder sb) {
		this.sb = sb;
	}
	
	public PageTextReplacer() {
		
	}

	public StringBuilder getSb() {
		return sb;
	}

	public void setSb(StringBuilder sb) {
		this.sb = sb;
	}

	public void replaceDeafaultPageText(String newText) {
		sb.replace(sb.indexOf("<div class = \"text\">") + "<div class = \"text\">".length(),
				sb.indexOf("</div>", sb.indexOf("<div class = \"text\">")), newText);
	}
	
	public String replaceAddress(String line, String actualAddress) {
		StringBuilder sb2 = new StringBuilder();
		sb2.append(line);
		return sb2.replace(sb2.indexOf("address"), sb2.indexOf("address")+"address".length(), actualAddress).toString();
	}
	
	public static void main(String [] args) {
	
		String actualAddress = "http://localhost:80";
		String  line = "<p><a button class=\"button-link\"; button onclick=\"window.location.href = 'address/toUpperCase';\"><b>ToUpperCaseTextTransformer</b></button></a>  - pretty simple service, which allows you to transform all your text into text in upper case";
		PageTextReplacer dptr = new PageTextReplacer();
//		dptr.setSb(new StringBuilder());
//		dptr.sb.append(line);
		System.out.println(dptr.replaceAddress(line, actualAddress));
//		System.out.println(dptr.sb.toString());
		
		
	}
}
