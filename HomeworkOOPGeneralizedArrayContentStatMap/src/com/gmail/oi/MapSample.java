package com.gmail.oi;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapSample<K, V> {

	public MapSample() {

	}

	public void analyzeArray(K[] array) {
		Map<K, Integer> mp = new HashMap<>();

		for (int i = 0; i < array.length; i++) {
			if (!mp.containsKey(array[i])) {
				mp.put(array[i], 1);
			} else if (mp.containsKey(array[i])) {
				mp.put(array[i], mp.get(array[i]).intValue() + 1);
			}
		}
		displayMapEntry(mp);
	}

	private void displayMapEntry(Map<K, Integer> mp) {
		Set<Entry<K, Integer>> mapEntry = mp.entrySet();
		for (Entry i : mapEntry) {
			System.out.println(i);
		}

	}
}
