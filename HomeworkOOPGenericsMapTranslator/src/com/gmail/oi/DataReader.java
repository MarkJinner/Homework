package com.gmail.oi;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class DataReader {
	
	public DataReader() {
		
	}
	
	public String readFile(File file) throws FileNotFoundException {
		StringBuilder sb = new StringBuilder();
		
		try(Scanner sc = new Scanner(file)){
			while(sc.hasNextLine()) {
				sb.append(sc.nextLine());
				sb.append(System.lineSeparator());
			}
		}
		return sb.toString();
	}
	
	public String readFileFast(File file) throws FileNotFoundException, IOException {
		StringBuffer sb = new StringBuffer();
		String text = "";
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			while((text = br.readLine())!=null) {
				sb.append(text);
				sb.append(System.lineSeparator());
			}
		}
		return sb.toString();
	}
	public String readFileByBytes(File file) throws IOException {
		
		int byteRead = 0;
		try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
				ByteArrayOutputStream boss = new ByteArrayOutputStream()){
			while((byteRead !=-1)) {
				byteRead = bis.read();
				if((byteRead !=-1)) {
					boss.write(byteRead);
				}
			}
			return boss.toString();
		}
	}
	
	public int [] readNumbers(File file) throws FileNotFoundException, IOException {
		int count = 0;
		int [] array = null;
		int byteRead = 0;
		try(DataInputStream dis = new DataInputStream(new FileInputStream(file));
				ByteArrayOutputStream boss = new ByteArrayOutputStream()){
			while(dis.available()>0) {
				byteRead = dis.read();
				count++;
				boss.write(byteRead);
			}
			array = new int[count];
			for(int i = 0; i< count;i++) {
				array[i] = boss.toByteArray()[i];
			}
		}
		return array;
	}
	
	public Object readObject(File file) throws FileNotFoundException, IOException, ClassNotFoundException {//serialize class
		Object obj = null;
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
			obj = ois.readObject();
		}
		return obj;
	}
}
