package FolderScanner;

import java.io.File;

public class FolderScanner implements Runnable{
	private File file;
	private Thread t;
	
	public FolderScanner(File file) {
		this.file = file;
		t = new Thread(this);
		t.start();
	}
	
	public FolderScanner() {
		
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
	
	private void scan() {
		File [] list = file.listFiles();
		
		while(!Thread.currentThread().isInterrupted()) {
			for(File i: list) {
				System.out.println("File "+i.getName()+" "+i.length());
			}
			try {
				Thread.currentThread().sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File [] list2 = file.listFiles();
			compareFolders(list, list2);
			list = list2;
		}
	}
	
	private void compareFolders(File [] folder, File [] folder2) {
		if(folder.length == folder2.length) {
			System.out.println("CHECKED...");
		}else if(folder.length<folder2.length) {
			defineAdded(folder, folder2);
			pauseThread(2000);
		}else if(folder.length>folder2.length) {
			defineDeleted(folder, folder2);
			pauseThread(2000);
		}
	}
	
	private void pauseThread(int length) {
		System.out.println("WAITING...");
		try {
			Thread.currentThread().sleep(length);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void defineAdded(File [] folder, File [] folder2) {
		for(int i = 0; i< folder.length;i++) {
			if(!folder[i].getName().equals(folder2[i].getName())) {
				System.out.println("File "+folder2[i].getName()+" added");
				break;
			}
		}
	}
	
	private void defineDeleted(File [] folder, File [] folder2) {
		for(int i = 0; i< folder2.length;i++) {
			if(!folder[i].getName().equals(folder2[i].getName())) {
				System.out.println("File "+folder[i].getName()+" deleted");
				break;
			}
		}
	}

	@Override
	public void run() {
		scan();
		
	}

}
