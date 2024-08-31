package com.gmail.comparable;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		try {
//			showBoxes();
		showAnimals();	
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

	public static void showBoxes() throws InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		Box one = new Box(1);
		Box two = new Box(2);

		BoxDemo oneD = new BoxDemo(one.getLength(), 10);
		BoxDemo twoD = new BoxDemo(two.getLength(), 10);

		System.out.println(one.compareTo(twoD));
		System.out.println(oneD.compareTo(twoD));
		Box[] boxes = getBoxArray(one, 10);
		System.out.println(Arrays.toString(boxes));

		BoxDemo[] demoBoxes = getBoxArray(oneD, 10);
		System.out.println(Arrays.toString(demoBoxes));
		sortArray(boxes);
		System.out.println(Arrays.toString(boxes));
		demoBoxes[0].setHeigth(10);
		demoBoxes[5].setHeigth(3);
		sortArray(demoBoxes);

		System.out.println(Arrays.toString(demoBoxes));
//		ArrayCreator <Box>ac = int[]::new;
		FinBox[] finboxes = getBoxArray(new FinBox(), 10);
		sortArray(finboxes);

		System.out.println(Arrays.toString(finboxes));

	}

	public static void showAnimals() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		String [] names = {"Vas'ka", "Petkas", "Feka", "Lus'ka", "Svetka", "Fox"};
		Animal one = new Animal(5);
		Animal two = new Animal(7);
		System.out.println(one.compareTo(two));
		Cat o1 = new Cat(9, "Vaska");
		Cat o2 = new Cat(7, "Foma");
		System.out.println(o1.compareTo(o2));
		Dog d1 = new Dog(4, "Bars");
		Dog d2 = new Dog(3, "Lev");
		Animal[] animals = getAnimalArray(new Dog(), 10, names);
		
		System.out.println(Arrays.toString(animals));
		sortArray(animals);
		System.out.println(Arrays.toString(animals));
		
		System.out.println(findMax(animals));
	}

	public static <T extends Box> T[] getBoxArray(T box, int length)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {

		T[] array = (T[]) Array.newInstance(box.getClass(), length);
		for (int i = 0; i < array.length; i++) {
			array[i] = (T) box.getClass().getDeclaredConstructor().newInstance();
			array[i].setLength(getRandomizer(length));
			if (box.getClass().equals(BoxDemo.class)) {
				BoxDemo demo = (BoxDemo) array[i];
				demo.setHeigth(getRandomizer(length));
			} else if (box.getClass().equals(FinBox.class)) {
				FinBox demo = (FinBox) array[i];
				demo.setHeigth(getRandomizer(length));
				demo.setVolume(demo.getHeigth() * demo.getLength());
			}
		}
		return array;
	}

	private static int getRandomizer(int max) {
		return 1 + (int) (Math.random() * max);
	}

	public static <T extends Animal> Animal[] getAnimalArray(Animal animal, int length, String [] names) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		Animal[] animals = (Animal[]) Array.newInstance(animal.getClass(), length);

		for (int i = 0; i < length; i++) {
			animals[i] = animal.getClass().getDeclaredConstructor(null).newInstance();
			animals[i].setAge(getRandomizer(10));
			
			if(animal.getClass().equals(Cat.class)) {
				Cat other = (Cat) animals[i];
				
				other.setName(names[getRandomizer(names.length-1)]);
			}else if(animal.getClass().equals(Dog.class)) {
				
				Dog other = (Dog) animals[i];
//				System.out.println("!!");
				other.setName(names[getRandomizer(names.length-1)]);
			}
			
		}
		return animals;
	}

	public static <T extends Comparable<T>> void sortArray(T[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 1; j < array.length; j++) {
				if (j == 0 || array[j].compareTo(array[j - 1]) < 0) {
					T temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
				}
			}
		}
	}

	public static <T extends Comparable<T>> T findMax(T[] array) {
		T max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (max.compareTo(array[i]) < 0) {
				max = array[i];
			}
		}

		return max;
	}
}
