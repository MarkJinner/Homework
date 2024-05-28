package com.gmail.ownlist;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			testList();
		} catch (ListIsEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (OutOfSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void testList() throws ListIsEmptyException, OutOfSizeException {

		List<Integer> nmbs = new List<>();
		nmbs.addFirst(22);
		nmbs.addFirst(55);
		
		
		System.out.println(nmbs);
		
		nmbs.addLast(777);
		nmbs.addByIndex(2, 1);
		System.out.println(nmbs);
		nmbs.addFirst(999);
		System.out.println(nmbs);
		
		System.out.println(nmbs);
		System.out.println(nmbs.getSize());
//		nmbs.removeFirst();
		System.out.println(nmbs);
		
//		nmbs.removeLast();
		System.out.println(nmbs);
		
//		nmbs.removeByIndex(2);
		System.out.println(nmbs);
		
		nmbs.setByIndex(2, 555);
		System.out.println(nmbs);
		System.out.println(nmbs.getSize());
		System.out.println(nmbs.getByIndex(0));
		nmbs.sort((one, two) ->(one.hashCode()-two.hashCode()));
		
		System.out.println(nmbs);
		System.out.println(nmbs.getSize());
		
		nmbs.removeIf((f)->(f>100));
		System.out.println(nmbs);
		System.out.println(nmbs.getSize());
		
//		nmbs.throughList();
		
//		Iterator<Integer> iter = nmbs.iterator();
//		
//		while(iter.hasNext()) {
//			System.out.println(iter.next());
//		}
//		
	}
	

}
