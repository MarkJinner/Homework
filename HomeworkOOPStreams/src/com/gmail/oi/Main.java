package com.gmail.oi;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Predicate;
import java.util.stream.Stream;

import com.gmail.oi.Language.LEVEL;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			testApp();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void testApp() throws IOException, URISyntaxException, InterruptedException {
		List<Cat> cats = getCatsList();

//		getTheLongestName(cats).ifPresent((s) -> System.out.println(getTheLongestName(cats).get()));
//		System.out.println(filterList());
//		System.out.println(getBiggestFiles());
//		removeWords();
//		removeNoLatinSymbols();
//		System.out.println(sortCats(cats));
//		reduceTest();
//		parseDoc(new File("/Users/olegivanov/eclipse-workspace/HomeworkOOPStreams/mav.txt"));
		String test = "This is test line";
//		System.out.println(test.startsWith("This"));
//		System.out.println(test.endsWith("line"));
//		filesToList(new File("/Users/olegivanov/Desktop/WORK"));
//		sortRockers();
//		checkURL();
//		countVowels();
//		System.out.println(sortCatsList(cats));
//		List<Integer> nmbs = getRandomList(10);
//		System.out.println(nmbs);
//
//		System.out.println(sortIntegersByLastDigit(nmbs));
//		Optional<File[]> opt = scanFolders();
//		opt.ifPresent((s)->{
//			System.out.println(s.toString());
//			for(File i: s) {
//				System.out.println(i);
//			}
//		});
//		int [] numbers = new int[] {1,2,4,5,7, -2};
//		OptionalInt nmb = findMin(numbers);
//		System.out.println(nmb.getAsInt());
		
		System.out.println(getLanguage("Easy"));
			

//		System.out.println(opt.get());
	}

	public static List<Cat> getCatsList() {
		Cat one = new Cat("Vaska", 1, 2);
		Cat two = new Cat("Petka", 2, 3);
		Cat three = new Cat("Efim", 1, 8);
		Cat four = new Cat("Seratonin", 3, 4);
		Cat five = new Cat("Stepan", 5, 4);
		Cat six = new Cat("Avan", 2, 5);
		List<Cat> cats = new ArrayList<>(List.of(one, two, three, four, five, six));
		cats.add(null);
		return cats;
	}

	public static List<Cat> sortCatsList(List<Cat> cats) {
		return cats.stream().filter((s) -> s != null).filter((s) -> s.getAge() > 1)
				.sorted((one, two) -> one.getName().compareTo(two.getName())).toList();
	}

	public static Optional<String> getTheLongestName(List<Cat> cats) {

		Stream<Cat> str = cats.stream();
		NullComparator<Cat> comp = new NullComparator<>();
		Optional<Comparator<Cat>> opCat = Optional
				.ofNullable(comp.rangeNulls((on, tw) -> on.getName().length() - tw.getName().length()));
		Optional<Cat> opt = str.filter((s) -> s != null)
				.max(comp.rangeNulls((on, tw) -> on.getName().length() - tw.getName().length()));
		return opt.map((Cat::getName)).or(() -> Optional.empty()).or(() -> Optional.empty());
	}

	public static List<Integer> filterList() {
		List<Integer> nmbs = new ArrayList<>(List.of(1, 2, 3, 4, -3, 6, 7, 9, 2, -3, 21, 4, 8));
		return nmbs.stream().filter((v) -> v > 0).filter((s) -> s % 2 != 0).sorted().toList();
	}

	public static File getBiggestFiles() {
		File[] file = new File("/Users/olegivanov/Desktop/WORK/sale").listFiles();

		file[1] = null;
		Stream<File> str = Arrays.stream(file);
		Comparator<File> comp = (one, two) ->

		{
			if (one.length() > two.length()) {
				return 1;
			} else if (one.length() < two.length()) {
				return -1;
			}
			return 0;
		};

		Optional<File> max = str.filter((f) -> f != null).max(comp);

		return max.isPresent() ? max.get() : new File("ff");

	}

	public static void removeWords() {
		String wrd = "Another day has come. No joy, no hope and no ending. I guess the one, who said that repeatition is the hell, was rigth";
		System.out.println();
		List<String>[] words = new Formatter().transform(wrd);
		List<String>[] result = new ArrayList[words.length];

		for (int i = 0; i < result.length; i++) {
			result[i] = new ArrayList<>();
			result[i].addAll(words[i].stream().filter((s) -> s.length() < 5).toList());
		}

		System.out.println(Arrays.toString(result));

	}

	public static void removeNoLatinSymbols() {
		String str = "This is тестовая строка it 89";

		Predicate<Character> pr = (s) -> {
			for (int i = 0; i < 28; i++) {
				if (s.toLowerCase(s) == ((char) (97 + i)) || s == ' ') {
					return true;
				}
			}
			return false;
		};

		List<Character> smbs = new ArrayList();

		for (int i = 0; i < str.length(); i++) {
			smbs.add(str.charAt(i));

		}

		List<Character> result = smbs.stream().filter(pr).toList();
		String res = "";

		for (int i = 0; i < result.size(); i++) {
			if (result.get(i) == ' ') {
				if (result.get(i - 1) != ' ') {
					res = res + result.get(i);
				}

			} else {
				res = res + result.get(i);
			}
		}
		System.out.println(res);

	}

	public static List<Cat> sortCats(List<Cat> cats) {
		return cats.stream().filter((s) -> s != null).filter((c) -> c.getWeigth() > 3)
				.sorted((one, two) -> one.getName().compareTo(two.getName())).toList();
	}

	public static void reduceTest() {
		Integer[] nmbs = new Integer[] { 2, 1, 1, 1, 1 };
		Stream<Integer> str = Arrays.stream(nmbs);
		Stream<Integer> str2 = Arrays.stream(nmbs);

		Integer result = str.reduce(2, (one, two) -> one * two);
		Optional<Integer> result2 = str2.reduce((one, two) -> one * two);

		System.out.println(result);
		System.out.println(result2.get());
	}

	public static void parseDoc(File file) {
		DocParser dp = new DocParser();
		System.out.println(dp.parseDoc(file));
	}

	public static void filesToList(File file) throws IOException {
		FileSearcher fs = new FileSearcher();
		String ext = "mp4";
		System.out.println(fs.scanFolder(file.listFiles(), ext));
	}

	public static void sortRockers() {
		Rocker one = new Rocker("Freddy Mercury", "This is how we doing", "What about us", "This is it");
		Rocker two = new Rocker("Billie Idol", "And this is how we doing", "Billy goes mad", "We ain't about us");
		Rocker three = new Rocker("Mike Jagger", "Shitty things", "World gone crazy", "You are not mine anymore");
		RockersSort rs = new RockersSort();
		System.out.println(rs.sortRockers(one, two, three));

	}

	public static void checkURL() throws URISyntaxException, IOException, InterruptedException {
		URLChecker uc = new URLChecker();
		String add = "https://ua.n21mobile.com";
		String add2 = "https://ua.n22mobile.com";
		String add3 = "https://javarush.com";
		List<String> list = new ArrayList<>(List.of(add, add2, add3));
		Stream<String> str = list.stream().filter((s) -> {
			try {
				if (uc.checkAvailability(s) == 200) {
					return true;
				}
			} catch (URISyntaxException | IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		});

		List<String> result = str.toList();
//		uc.checkAvailability(add);
		System.out.println(result);
		sortRockers();
	}

	public static void countVowels() {
		String str = "This is тестовая строка it 89 through trd";
		VowelsCounter vc = new VowelsCounter();
		System.out.println(vc.sortString(str));
	}

	public static List<Integer> sortIntegersByLastDigit(List<Integer> nmbs) {
		return nmbs.stream().filter((d) -> d > 10).sorted(compare()).toList();

	}

	private static Comparator<Integer> compare() {
		class Comp implements Comparator<Integer> {

			@Override
			public int compare(Integer o, Integer t) {
				int one = Integer.parseInt(String.valueOf(o.toString().toCharArray()[1]));
				int two = Integer.parseInt(String.valueOf(t.toString().toCharArray()[1]));

				if (one > two) {
					return 1;
				} else if (one < two) {
					return -1;
				}

				return 0;
			}

		}
		return new Comp();
	}

	private static List<Integer> getRandomList(int size) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			list.add(1 + (int) (Math.random() * 98));
		}
		return list;
	}

	public static Optional<File[]> scanFolders() throws IOException {
		File file = new File("/Users/olegivanov/eclipse-workspace/HomeworkOOPStreams/folderScanner.txt");
		FolderScanner fs = new FolderScanner();
		Optional<File[]> opt = fs.scanFolders(file);
		return opt.isPresent() ? opt : Optional.empty();
	}
	
	public static OptionalInt findMin(int[] list) {
		
		return Arrays.stream(list).min();
	}
	
	public static <T> Optional<Language> getLanguage(T arg){
		Language one = new Language("Java", LEVEL.Hard);
		Language two = new Language("Fortran", LEVEL.Normal);
		Language three = new Language("Basic", LEVEL.Easy);
		Language four = new Language("C", LEVEL.Normal);
		Language five = new Language("C++", LEVEL.Normal);
		
		List<Language> lngs = new ArrayList<>(List.of(one, two, three, four, five));
		Predicate<Language> pr = (s)->s.getName().equals(arg) || s.getLvl().name().contains(arg.toString());
		Optional<Language> opt = lngs.stream().filter(pr).findAny();
		return opt;
		
	}

}
