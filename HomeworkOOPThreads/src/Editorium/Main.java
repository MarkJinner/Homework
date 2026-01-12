package Editorium;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			testEditorium(5, 2, 1);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void testEditorium(int maxPart, int maxWriters, int maxReaders)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {
		Editor editor = new Editor(maxPart, maxWriters, maxReaders);

		Writer[] wrs = (Writer[]) getArray(new Writer(), maxWriters, editor);
		Reader[] rds = (Reader[]) getArray(new Reader(), maxReaders, editor);

	}

	public static Part[] getArray(Part runner, int number, Editor editor)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {
		Part[] parts = (Part[]) Array.newInstance(runner.getClass(), number);

		for (int i = 0; i < number; i++) {
			parts[i] = runner.getClass().getDeclaredConstructor().newInstance();
			parts[i].setEditor(editor);
		}
		
		Thread [] ts = new Thread[number];
		for(int i = 0; i< ts.length;i++) {
			ts[i] = new Thread(parts[i]);
			ts[i].start();
		}

		return parts;
	}

}
