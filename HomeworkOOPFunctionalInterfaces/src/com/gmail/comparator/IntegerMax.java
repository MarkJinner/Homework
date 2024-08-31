package com.gmail.comparator;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class IntegerMax {

	public List<Integer> numbers;

	public IntegerMax(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public IntegerMax() {

	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	public void setNumbers(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public int findMaxL(List<Integer> numbers) {

		Predicate<Integer> pr = (nmb) -> {

			for (int i = 2; i <= nmb; i++) {

				if (i < nmb) {
					if (nmb % 1 == 0 && nmb % i == 0) {

						return false;
					}
				} else if (i == nmb) {

					if (nmb % 1 == 0 && nmb % i == 0) {

						return true;
					}
				}

			}
			return true;
		};

		Comparator<Integer> comp = (one, two) -> {

			for (Integer i : numbers) {

				if (one > two) {
					if (pr.test(one) && pr.test(two)) {
						two = one;
					}

				}
			}

			return two;
		};

		int max = numbers.get(0);
		for (Integer i : numbers) {

			max = comp.compare(i, max);
		}

		return max;
	}

//	public List<Integer> findMax(List<Integer> numbers) {
//		List<Integer> intgrs = new ArrayList<>();
//
//		Comparator<Integer> comp = (one, two) -> {
//
//			for (Integer i : numbers) {
//				if (one > two) {
//					return one;
//				}
//			}
//			return two;
//		};
//
//		int max = 0;
//
//		for (Integer i : numbers) {
//			max = comp.compare(max, i);
//		}
//		System.out.println(max);
//
//		return intgrs;
//	}

	public Comparator<Integer> checkIfSimple() {
		Comparator<Integer> comp = (one, two) -> {
			for (int i = 2; i < one; i++) {
				if (one % 1 == 0 & one % i == 0) {
					return -1;
				}
			}
			return 0;
		};

		return comp;
	}

//	public void ifSimple(List<Integer> numbers) {
//		for (int j = 0; j < numbers.size(); j++) {
//			Comparator<Integer> cmp = checkIfSimple();
//			if (j == 0) {
//
//				if (cmp.compare(numbers.get(j), 1) > 0) {
////					System.out.println(cmp.compare(numbers.get(j), 1));
//				}
//			} else {
//				if (cmp.compare(numbers.get(j), numbers.get(j - 1)) > 0) {
////					System.out.println(cmp.compare(numbers.get(j), numbers.get(j - 1)));
//				}
//			}
//
//		}
//	}

	public Comparator<Integer> findMax() {
		Comparator<Integer> cmp = (one, two) -> {		
			if (one > two) {		
				return 1;
			}
			return 0;
		};

		return cmp;
	}
//	List<Integer> numbers2 = new ArrayList(List.of(73, 41,43,37, 2,39,37,73, 3, 4,2, 6,8, 10, 24,11, 12, 31, 36, 37, 31, 41, 43,41,42, 44, 46, 44));
	
	public void defineMax(List<Integer> nmbs) {
		Comparator<Integer> intgrs = checkIfSimple();
		Comparator<Integer> max = findMax();
		Comparator <Integer> coll = intgrs.thenComparing(max);
		
		int x = nmbs.get(0);
		
		
		for(int i = 1; i< nmbs.size();i++) {
				if(coll.compare(nmbs.get(i), x)>0) {
					x = nmbs.get(i);
	
				}
		}
		

		System.out.println("max: "+x);
	}

}
