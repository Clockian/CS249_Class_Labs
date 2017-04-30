/*
 * Created by Jasque Saydyk
 * Project 05 - Hash Tables
 * CS 249
 * 30 April 2017
 * Description - This class creates the methods used by the profiler
*/
import java.util.concurrent.TimeUnit;

public class ProfilerMethods {
	public void hashSetTest100_000(HashSet<Integer> test){
		// Fill in array with random numbers
		for(Integer ii = 0; ii < 100000; ii++){
			test.add(ii);
		}
		
		long startTime = System.nanoTime();
		for(int ii = 0; ii < 100000; ii++){
			test.has(ii);
			//System.out.println("Found?: " +  number);
		}
		long difference = System.nanoTime() - startTime;
		
		System.out.println("Milliseconds: " + TimeUnit.NANOSECONDS.toMillis(difference) + 
				"  Microseconds: " + TimeUnit.NANOSECONDS.toMicros(difference) +
				"  Seconds: " + TimeUnit.NANOSECONDS.toSeconds(difference));
	}
	
	public void hashSetTest200_000(HashSet<Integer> test){
		// Fill in array with random numbers
		for(Integer ii = 0; ii < 200000; ii++){
			test.add(ii);
		}
		long startTime = System.nanoTime();
		for(int ii = 0; ii < 200000; ii++){
			test.has(ii);
			//System.out.println("Found?: " +  number);
		}
		long difference = System.nanoTime() - startTime;
		
		System.out.println("Milliseconds: " + TimeUnit.NANOSECONDS.toMillis(difference) + 
				"  Microseconds: " + TimeUnit.NANOSECONDS.toMicros(difference) +
				"  Seconds: " + TimeUnit.NANOSECONDS.toSeconds(difference));
	}
	
	public void hashSetTest300_000(HashSet<Integer> test){
		// Fill in array with random numbers
		for(Integer ii = 0; ii < 300000; ii++){
			test.add(ii);
		}
		
		long startTime = System.nanoTime();
		for(int ii = 0; ii < 300000; ii++){
			test.has(ii);
			//System.out.println("Found?: " +  number);
		}
		long difference = System.nanoTime() - startTime;
		
		System.out.println("Milliseconds: " + TimeUnit.NANOSECONDS.toMillis(difference) + 
				"  Microseconds: " + TimeUnit.NANOSECONDS.toMicros(difference) +
				"  Seconds: " + TimeUnit.NANOSECONDS.toSeconds(difference));
	}
	
	public void hashMapTest100_000(HashMap<Integer, Integer> test){
		// Fill in array with random numbers
		for(Integer ii = 0; ii < 100000; ii++){
			test.put(ii, ii);
		}
		
		long startTime = System.nanoTime();
		for(int ii = 0; ii < 100000; ii++){
			test.get(ii);
			//System.out.println("Found?: " +  number);
		}
		long difference = System.nanoTime() - startTime;
		
		System.out.println("Milliseconds: " + TimeUnit.NANOSECONDS.toMillis(difference) + 
				"  Microseconds: " + TimeUnit.NANOSECONDS.toMicros(difference) +
				"  Seconds: " + TimeUnit.NANOSECONDS.toSeconds(difference));
	}
	
	public void hashMapTest200_000(HashMap<Integer, Integer> test){
		// Fill in array with random numbers
		for(Integer ii = 0; ii < 200000; ii++){
			test.put(ii, ii);
		}
		
		long startTime = System.nanoTime();
		for(int ii = 0; ii < 200000; ii++){
			test.get(ii);
			//System.out.println("Found?: " +  number);
		}
		long difference = System.nanoTime() - startTime;
		
		System.out.println("Milliseconds: " + TimeUnit.NANOSECONDS.toMillis(difference) + 
				"  Microseconds: " + TimeUnit.NANOSECONDS.toMicros(difference) +
				"  Seconds: " + TimeUnit.NANOSECONDS.toSeconds(difference));
	}
	
	public void hashMapTest300_000(HashMap<Integer, Integer> test){
		// Fill in array with random numbers
		for(Integer ii = 0; ii < 300000; ii++){
			test.put(ii, ii);
		}
		
		long startTime = System.nanoTime();
		for(int ii = 0; ii < 300000; ii++){
			test.get(ii);
			//System.out.println("Found?: " +  number);
		}
		long difference = System.nanoTime() - startTime;
		
		System.out.println("Milliseconds: " + TimeUnit.NANOSECONDS.toMillis(difference) + 
				"  Microseconds: " + TimeUnit.NANOSECONDS.toMicros(difference) +
				"  Seconds: " + TimeUnit.NANOSECONDS.toSeconds(difference));
	}
}
