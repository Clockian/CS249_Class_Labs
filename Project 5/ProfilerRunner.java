/*
 * Created by Jasque Saydyk
 * Project 05 - Hash Tables
 * CS 249
 * 30 April 2017
 * Description - This class runs the profiler
*/
public class ProfilerRunner {
	public static void main(String[] args){
		ProfilerMethods test = new ProfilerMethods();
		
		System.out.println("HashSets");
		
		HashSet<Integer> test1 = new HashSet<>(300110);
		HashSet<Integer> test2 = new HashSet<>(300110);
		HashSet<Integer> test3 = new HashSet<>(300110);
		
		test.hashSetTest100_000(test1);
		test.hashSetTest200_000(test2);
		test.hashSetTest300_000(test3);
		
		System.out.println("HashMaps");
		
		HashMap<Integer, Integer> test4 = new HashMap<>(300110);
		HashMap<Integer, Integer> test5 = new HashMap<>(300110);
		HashMap<Integer, Integer> test6 = new HashMap<>(300110);
		
		test.hashMapTest100_000(test4);
		test.hashMapTest200_000(test5);
		test.hashMapTest300_000(test6);
	}
}
