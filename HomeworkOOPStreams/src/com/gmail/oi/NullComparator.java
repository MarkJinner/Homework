package com.gmail.oi;

import java.util.Comparator;

public class NullComparator <T>{
	private static int NOT_NULL = 11;
	
	public static <T> Comparator<T> rangeNulls(Comparator<T> any) {
		
		class NullSafeComparator  implements Comparator<T>{
			
			@Override
			public int compare(T o1, T o2) {
				int result = compareTwo(o1, o2);
				if(result!=NOT_NULL) {
					return result;
				}	
				return any.compare(o1, o2);
			}
			
		}
		
		
		
		
		
		return new NullSafeComparator();
		
	}
	
	private static<T> int compareTwo(T one, T two) {
		if(one!=null && two==null) {
			return 1;
		}else if(one==null && two!=null) {
			return -1;
		}else if(one==null && two==null){
			return 0;
		}
		return NOT_NULL;
	}
}
