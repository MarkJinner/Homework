package com.gmail.foldercopier;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FolderCopy fc = new FolderCopy(); 
		File file = new File("/Users/olegivanov/Desktop/WORK/sale");
		fc.copyFolder(file, 5);
		
	}

}
