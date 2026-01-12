package com.gmail.filesearcher;

import java.io.File;
import java.util.List;
import java.util.function.Predicate;

public class FileComparator implements Runnable{
	private Predicate <String> pr;
	private String sName;
	private File file;
	private List <String>list;
	
	public FileComparator(String sName, File file, List<String> list) {
		this.sName = sName;
		this.file = file;
		pr = (sn)->sn.equals(file.getName());
		this.list = list;
	}
	
	public FileComparator() {
		
	}

	public Predicate<String> getPr() {
		return pr;
	}

	public void setPr(Predicate<String> pr) {
		this.pr = pr;
	}
	
	

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}
	
	private void compareFiles() {
		if(pr.test(sName)) {
			System.out.println(file.getAbsolutePath());
			list.add(file.getAbsolutePath());
			
		}
	}

	@Override
	public void run() {
		compareFiles();
		
	}
	
	
}
