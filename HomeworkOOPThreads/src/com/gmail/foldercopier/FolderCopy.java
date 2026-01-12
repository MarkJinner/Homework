package com.gmail.foldercopier;

import java.io.File;

public class FolderCopy {
	private File folder;
	private int trds;
	private int copied = 0;
	private int countTrd = 0;

	public FolderCopy() {

	}

	public File getFolder() {
		return folder;
	}

	public void setFolder(File folder) {
		this.folder = folder;
	}

	public int getTrds() {
		return trds;
	}

	public void setTrds(int trds) {
		this.trds = trds;
	}

	public int getCopied() {
		return copied;
	}

	public void setCopied(int copied) {
		this.copied = copied;
	}

	public void copyFolder(File folder, int max) {

		File[] list = folder.listFiles();
		Thread[] ts = new Thread[max];

		while (copied < list.length) {
			for (int i = copied; i < list.length; i++) {
				if (countTrd < max) {
					ts[countTrd] = new Thread(new Copier(list[copied++]));
					ts[countTrd++].start();
				}

			}
			for (int i = 0; i < max; i++) {
				if(countTrd>0) {
				if (ts[i] != null && !ts[i].isAlive()) {
					countTrd--;
				}
				}
			}
		}

	}
}
