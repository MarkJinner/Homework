package com.gmail.oi;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class FolderScanner {
	private File adds;
	private String[] exts = new String[] { "txt", "docx", "doc" };
	private int count = 0;

	public FolderScanner(File adds) {
		this.adds = adds;
	}

	public FolderScanner() {

	}

	public File getAdds() {
		return adds;
	}

	public void setAdds(File adds) {
		this.adds = adds;
	}

	public Optional<File[]> scanFolders(File file) throws IOException {
		List<String> files = Files.lines(file.toPath()).toList();
		Stream<File[]> str = files.stream().map((s)->new File(s.toString()).listFiles()).filter(ifThree());
	
		return str.findFirst();

	}

	private Predicate<File> getPr() {
		Predicate<File> pr = (f) -> {
			for (String i : exts) {
				if (getFileExt(f).equals(i)) {
					return true;
				}
			}
			return false;
		};

		return pr;
	}

	private Predicate<File[]> ifThree() {

		Predicate<File[]> pr = (folder) -> {
			for (File i : folder) {
				if (getPr().test(i)) {
					count++;
				}
			}
			if (count >= 3) {
				
				return true;
			}
			count = 0;
			return false;
		};

		return pr;

	}

	private String getFileExt(File file) {

		return file.getName().substring(file.getName().lastIndexOf(".") + 1, file.getName().length());
	}

	private Comparator<File[]> compare() {
		class Comp implements Comparator<File[]> {
			public Comp() {

			}

			@Override
			public int compare(File[] o1, File[] o2) {
				if (o1.length > o2.length) {
					return 1;
				} else if (o1.length < o2.length) {
					return -1;
				}
				return 0;
			}

		}
		return new Comp();
	}
}
