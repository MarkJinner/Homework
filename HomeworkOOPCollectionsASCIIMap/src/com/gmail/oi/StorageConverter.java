package com.gmail.oi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StorageConverter {
	private File file;

	public StorageConverter() throws IOException {
		file = new File("symbols_storage");
		file.createNewFile();
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public Map<String, List<String>> load() throws ClassNotFoundException, IOException {
		Map<String, List<String>> storage = null;
		if (file.length() == 0) {
			storage = new TreeMap<>();
		} else if (file.length() > 0) {
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
				storage = (Map<String, List<String>>) ois.readObject();
			}
		}
		return storage;
	}
	
	public void store(Map<String, List<String>> storage) throws IOException {
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){
			oos.writeObject(storage);
		}
		System.out.println("Storage stored");
	}

}
