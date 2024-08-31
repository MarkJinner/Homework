package com.gmail.list;

import java.util.Comparator;

public interface NullSafeComparator <T>{
	 final static int NOT_NULL =11;
	 
	 public default Comparator<T> rangeNulls(Comparator<T> any){
		 
		class SafeComparator implements Comparator<T>{
			int result;
			
			@Override
			public int compare(T o1, T o2) {
				result = compareTwo(o1,o2);
				if(result!=NOT_NULL) {
					return result;
				}
				return any.compare(o1, o2);
			}
			
		}
		 
		return new SafeComparator(); 
	 }
	 
	 private static <T> int compareTwo(T one, T two) {
		 if(one!=null && two==null) {
			 return 1;
		 }else if(one==null && two!=null) {
			 return -1;
		 }else if(one==null && two==null) {
			 return 0;
		 }
		 return NOT_NULL;
	 }
	 
	 
}
