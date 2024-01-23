package com.gmail.oi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class SymbolsStorage extends Storage {
	private String stopWord = "Save";
	private StringBuilder sb;
	private Scanner sc;
	private Map<String, List<String>> storage;
	private StorageConverter conv;

	public SymbolsStorage() throws IOException, ClassNotFoundException {
		sb = new StringBuilder();
		sc = new Scanner(System.in);
		conv = new StorageConverter();
		storage = conv.load();

	}

	public Map<String, List<String>> getStorage() {
		return storage;
	}

	public void setStorage(Map<String, List<String>> storage) {
		this.storage = storage;
	}

	public StorageConverter getConv() {
		return conv;
	}

	public void setConv(StorageConverter conv) {
		this.conv = conv;
	}

	@Override
	public void addSymbol() throws IOException {
		sb.delete(0, sb.length());
		System.out.println("Input symbol");
		String smb = sc.nextLine();
		if (!storage.containsKey(smb.toUpperCase())) {
			System.out.println("Input symbol's reflection in ASCII");
			inputRefl();

			List<String> symbol = createSymbRefl();

			storage.put(smb, symbol);
			conv.store(storage);

		} else {
			System.out.println("Storage contains symbol " + smb + " already");
		}

	}

	private void inputRefl() {
		String refl = "";
		while (!refl.equals(stopWord)) {
			refl = sc.nextLine();
			if (!refl.equals(stopWord)) {
				if (refl.length() > 0 && !refl.equals(System.lineSeparator())) {
					sb.append(refl + System.lineSeparator());
				}
			}

		}
	}

	private List<String> createSymbRefl() {
		List<String> symbol = new ArrayList<>();
		for (int i = 0; i < sb.toString().split(System.lineSeparator()).length; i++) {
			symbol.add(i, (sb.toString().split(System.lineSeparator()))[i]);
		}
		return symbol;
	}

	@Override
	public void editSymbol() throws IOException, NoSuchSymbolException {
		sb.delete(0, sb.length());
		System.out.println("Input symbol you'd like to edit");
		String smb = sc.nextLine();
		if (storage.containsKey(smb.toUpperCase())) {
			System.out.println("Input NEW symbol's reflection in ASCII");
			inputRefl();
			List<String> symbol = createSymbRefl();

			storage.replace(smb, symbol);
			conv.store(storage);
		} else {
			throw new NoSuchSymbolException("No such symbol in storage");
		}

	}

	@Override
	public void editSymbol(String symbol) throws NoSuchSymbolException, IOException {
		sb.delete(0, sb.length());
		if (storage.containsKey(symbol.toUpperCase())) {
			System.out.println("Input NEW symbol's reflection in ASCII");
			inputRefl();
			List<String> lines = createSymbRefl();

			storage.replace(symbol, lines);
			conv.store(storage);
		} else {
			throw new NoSuchSymbolException("No such symbol in storage");
		}

	}

	@Override
	public void removeSymbol() throws NoSuchSymbolException, IOException {
		sb.delete(0, sb.length());
		System.out.println("Input symbol you'd like to remove");
		String smb = sc.nextLine();
		if (storage.containsKey(smb.toUpperCase())) {
			storage.remove(smb, smb);
			conv.store(storage);
		} else {
			throw new NoSuchSymbolException("No such symbol in storage");
		}

	}

	private String displaySymbol(List<String> symbol) {
		sb.delete(0, sb.length());

		for (int i = 0; i < symbol.size(); i++) {
			sb.append(symbol.get(i) + System.lineSeparator());
		}
		return sb.toString();
	}

	@Override
	public String displaySymbol(String symbol) throws NoSuchSymbolException {
		if (storage.containsKey(symbol.toUpperCase())) {
			return this.displaySymbol(storage.get(symbol));
		} else {
			throw new NoSuchSymbolException("No such symbol in storage");
		}
	}

	@Override
	public String displaySymbols() {
		sb.delete(0, sb.length());

		storage.forEach((key, value) -> sb.append(key + this.displaySymbol(storage.get(key))));

		return sb.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(conv, storage);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SymbolsStorage other = (SymbolsStorage) obj;
		return Objects.equals(conv, other.conv) && Objects.equals(storage, other.storage);
	}
	
	public void displayKeys() {
		storage.forEach((key, value)->System.out.println(key));
	}

	@Override
	public String toString() {
		return this.displaySymbols();
	}

}
