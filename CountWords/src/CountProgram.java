
import java.io.File;

import java.io.FileNotFoundException;

import java.util.*;

public class CountProgram

{

	public static void main(String[] args) throws FileNotFoundException {

		File file = new File("TheRaven.txt");
		
		Scanner input = new Scanner(file);

		Map<String, Integer> wordMap = new HashMap<String, Integer>();

		while (input.hasNext()){
 
			String words = input.next();

			if (wordMap.containsKey(words) == false)
				
				wordMap.put(words, 1);

			else {

				int count = (int) (wordMap.get(words));
				
				wordMap.remove(words);

				wordMap.put(words, count + 1);
			}

		}

		Set<Map.Entry<String, Integer>> wordSet = wordMap.entrySet();

		List<Map.Entry<String, Integer>> setList = new ArrayList<Map.Entry<String, Integer>>(wordSet);

		Collections.sort(setList, new Comparator<Map.Entry<String, Integer>>() {
			
			public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {

				return (b.getValue()).compareTo(a.getValue());
			}

		});

		for (Map.Entry<String, Integer> i : setList) {

			System.out.println(i.getKey() + " Appears in this file " + i.getValue() + " Time(s)");

		}

	}

}