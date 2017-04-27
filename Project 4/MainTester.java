import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MainTester {
	
	
	public void BSTrandTest10_000(BinarySearchTree<Integer, Integer> test){
		List<Integer> testnumbers = new ArrayList<Integer>();
		Random rand = new Random();
		
		// Fill in array with random numbers
		for(Integer ii = 0; ii < 10000; ii++){
			testnumbers.add(ii);
		}
		Collections.shuffle(testnumbers, rand);
		
		for(int ii = 0; ii < 10000; ii++){
			test.put(testnumbers.get(ii), testnumbers.get(ii));
		}
		
		for(int ii = 0; ii < 10000; ii++){
			// Amount of time sort takes
			long startTime = System.nanoTime();
			int number = test.get(ii);
			long difference = System.nanoTime() - startTime;
			
			System.out.println("number: " +  number + 
					"  Milliseconds: " + TimeUnit.NANOSECONDS.toMillis(difference) + 
					"  Microseconds: " + TimeUnit.NANOSECONDS.toMicros(difference));
		}
	}
	
	public void BSTinOrderTest10_000(BinarySearchTree<Integer, Integer> test){
		//List<Integer> testnumbers = new ArrayList<Integer>();
		//Random rand = new Random();
		
		for(Integer ii = 0; ii < 10000; ii++){
			test.put(ii, ii);
		}
		
		for(int ii = 0; ii < 10000; ii++){
			// Amount of time sort takes
			long startTime = System.nanoTime();
			int number = test.get(ii);
			long difference = System.nanoTime() - startTime;
			
			System.out.println("number: " +  number + 
					"  Milliseconds: " + TimeUnit.NANOSECONDS.toMillis(difference) + 
					"  Microseconds: " + TimeUnit.NANOSECONDS.toMicros(difference));
		}
	}
	
	public void RBTrandTest10_000(RedBlackTree<Integer, Integer> test){
		ArrayList<Integer> testnumbers = new ArrayList<Integer>();
		Random rand = new Random();
		
		// Fill in array with random numbers
		for(Integer ii = 0; ii < 10000; ii++){
			System.out.println("here1");
			testnumbers.add(ii);
		}
		Collections.shuffle(testnumbers, rand);
		
		for(int ii = 0; ii < 10000; ii++){
			System.out.println("here2");
			test.put(testnumbers.get(ii), testnumbers.get(ii));
		}
		
		for(int ii = 0; ii < 10000; ii++){
			// Amount of time sort takes
			long startTime = System.nanoTime();
			int number = test.get(ii);
			long difference = System.nanoTime() - startTime;
			
			System.out.println("number: " +  number + 
					"  Milliseconds: " + TimeUnit.NANOSECONDS.toMillis(difference) + 
					"  Microseconds: " + TimeUnit.NANOSECONDS.toMicros(difference));
		}
	}
	
	public void RBTinOrderTest10_000(RedBlackTree<Integer, Integer> test){
		//List<Integer> testnumbers = new ArrayList<Integer>();
		//Random rand = new Random();
		
		for(Integer ii = 0; ii < 10000; ii++){
			test.put(ii, ii);
		}
		
		for(int ii = 0; ii < 10000; ii++){
			// Amount of time sort takes
			long startTime = System.nanoTime();
			int number = test.get(ii);
			long difference = System.nanoTime() - startTime;
			
			System.out.println("number: " +  number + 
					"  Milliseconds: " + TimeUnit.NANOSECONDS.toMillis(difference) + 
					"  Microseconds: " + TimeUnit.NANOSECONDS.toMicros(difference));
		}
	}
}
