package com.gmail.ownlist;

import java.util.Comparator;

public interface NullSafeComparator<T> {
	static int NOT_NULL = 11;

	public static  <T> Comparator<T> rangeNullsFirst(Comparator<T> any) {
		
		class NullSafe implements Comparator<T>{
			int result = 0;
			@Override
			public int compare(T o1, T o2) {
				if(result!=NOT_NULL) {
					result = compareTwo(o1, o2);
				}
				return result;
			}
		}
		 
		 return new NullSafe();
	}
	
	private static <T> int compareTwo(T one, T two) {
		if(one!=null && two ==null) {
			return 0;
		}else if(one== null && two!=null) {
			return 1;
		}else if(one==null && two== null ) {
			return -1;
		}
		
		return NOT_NULL;
	}

}
