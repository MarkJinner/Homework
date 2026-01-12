package com.gmail.filesearcher;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileSearcher {
	private List<String> adds;
	private String sName;
	private int maxTrds;
	private File folder;
	private Thread[] ts;
	private List<Thread> lst = new ArrayList<>();
	private int countTrd = 0;

	public FileSearcher(File folder, String sName, int maxTrds) {
		this.folder = folder;
		this.sName = sName;
		this.maxTrds = maxTrds;
		adds = Collections.synchronizedList(new ArrayList<>());
	}

	public FileSearcher(int max) {
		adds = Collections.synchronizedList(new ArrayList<>());
		this.maxTrds = max;
		ts = new Thread[max];
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public int getMaxTrds() {
		return maxTrds;
	}

	public void setMaxTrds(int maxTrds) {
		this.maxTrds = maxTrds;
	}

	public File getFolder() {
		return folder;
	}

	public void setFolder(File folder) {
		this.folder = folder;
	}

	public List<String> getAdds() {
		return adds;
	}

	public void setAdds(List<String> adds) {
		this.adds = adds;
	}

	public Thread[] getTs() {
		return ts;
	}

	public void setTs(Thread[] ts) {
		this.ts = ts;
	}

	public void search(File folder, String sName) {
		

		if (folder.isDirectory()) {
			
			File[] list = folder.listFiles();
			
			for (File i : list) {
				if (i.isDirectory()) {
					File[] list2 = i.listFiles();
					for (File j : list2) {
						if (j.isFile()) {
							if (countTrd < maxTrds) {
								ts[countTrd] = new Thread(new FileComparator(sName, j, adds));
								ts[countTrd].start();
								countTrd++;
								minusThread(ts);
							}						
							
						} else if (j.isDirectory()) {
							this.search(j, sName);
	
						}
					}

				} else if (i.isFile()) {
				
					if (countTrd < maxTrds) {
						ts[countTrd] = new Thread(new FileComparator(sName, i, adds));
						ts[countTrd].start();
						countTrd++;
						minusThread(ts);
					}
				}
			

			}
			minusThread(ts);
		}
	}

	private void minusThread(Thread[] ts) {
		for (int i = 0; i < ts.length; i++) {
			if (countTrd > 0) {
			if (ts[i] != null && !ts[i].isAlive()) {
				
					this.countTrd--;
				}

			}
		}
	}
}
