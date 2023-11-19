package com.gmail.oi;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class DataSaver {
	private Scanner sc = new Scanner(System.in);
	public DataSaver() {
		
	}
	
	public void saveData(File file) throws FileNotFoundException {
		System.out.println("Type text and print 'Save' to save it");
		StringBuilder sb = new StringBuilder();
		String text = "";
		try(PrintWriter pw = new PrintWriter(file)){
			while(text.equals("Save")) {
				text = sc.nextLine();
				if(!text.equals("Save")) {
					sb.append(text);
				}
			}
			pw.print(sb.toString());
		}
		
	}
	
	public void saveDataByBytes(File file) throws IOException {
		System.out.println("Type text and print 'Save' to save it");
		
		String text = "";
		try(BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
				ByteArrayOutputStream boss = new ByteArrayOutputStream()){
			while(!text.equals("Save")) {
				text = sc.nextLine();
				if(!text.equals("Save")) {
					boss.write(text.getBytes());
				}
			}
			
			bos.write(boss.toByteArray());
		}
	}
	
	public void saveNumbers(File file) throws IOException {
		System.out.println("Type numbers and print 'Save' to save it");
		
		String nmb = "";
		
		try(DataOutputStream bos = new DataOutputStream(new FileOutputStream(file));
				ByteArrayOutputStream boss = new ByteArrayOutputStream()){
			while(!nmb.equals("Save")) {
				nmb = sc.nextLine();
				if(!nmb.equals("Save")) {
					boss.write(Integer.parseInt(nmb));
				}
				
			}
			bos.write(boss.toByteArray());
		}
		
	}
	
	public void saveObject(File file, Object obj) throws IOException {
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){
			oos.writeObject(obj);
		}
	}
	
	public void saveWord(File file, String word) throws IOException {
		
		try(BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file, true))){
			bos.write((word+System.lineSeparator()).getBytes());
		}
		
		
	}
}
