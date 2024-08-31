package com.gmail.comparator;

import java.util.Comparator;

public interface NullFriendlyComparator<T> {
	
	public static final int NOT_NULL = 11;

	public static <T> Comparator<T> rangeNulls(Comparator<T> any) {
		
		class NullSafe implements Comparator<T> {
			int result = 0;

			@Override
			public int compare(T o1, T o2) {
				result = compareTwo(o1, o2);
				if (result != NOT_NULL) {
					return result;
				}
  
				return any.compare(o1, o2);
			}

		}

		return new NullSafe();
	}

	private static <T> int compareTwo(T one, T two) {
		if (one == null && two != null) {
			return 1;
		} else if (one != null && two == null) {
			return -1;
		} else if (one == null && two == null) {
			return 0;
		}

		return NOT_NULL;
	}

}
