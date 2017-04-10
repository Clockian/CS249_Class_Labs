import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MainTester {
	public void sampleTest(ISorter test){
		List<Integer> testnumbers = new ArrayList<Integer>();

		for(Integer ii = 5; ii > 0; ii--){
			testnumbers.add(ii);
		}
		
		System.out.print(test.sort(testnumbers) + "   List: ");
		
		for(Integer x: testnumbers){
			System.out.print(x + ", ");
		}
		System.out.println();
	}
	
	public void randTest20_000(ISorter test){
		List<Integer> testnumbers = new ArrayList<Integer>();
		Random rand = new Random();
		
		// Fill in array with random numbers
		for(Integer ii = 0; ii < 20000; ii++){
			testnumbers.add(rand.nextInt());
		}
		
		// Amount of time sort takes
		long startTime = System.nanoTime();
		int swaps = test.sort(testnumbers);
		long difference = System.nanoTime() - startTime;
		
		System.out.println("Swaps: " +  swaps + 
				"  Milliseconds: " + TimeUnit.NANOSECONDS.toMillis(difference) + 
				"  Microseconds: " + TimeUnit.NANOSECONDS.toMicros(difference));
	}
	
	public void randTest100_000(ISorter test){
		List<Integer> testnumbers = new ArrayList<Integer>();
		Random rand = new Random();
		
		// Fill in array with random numbers
		for(Integer ii = 0; ii < 100000; ii++){
			testnumbers.add(rand.nextInt());
		}
		
		// Amount of time sort takes
		long startTime = System.nanoTime();
		int swaps = test.sort(testnumbers);
		long difference = System.nanoTime() - startTime;
		
		System.out.println("Swaps: " + swaps + 
				"  Milliseconds: " + TimeUnit.NANOSECONDS.toMillis(difference)+ 
				"  Microseconds: " + TimeUnit.NANOSECONDS.toMicros(difference));
	}
	
	public void randTest500_000(ISorter test){
		List<Integer> testnumbers = new ArrayList<Integer>();
		Random rand = new Random();

		// Fill in array with random numbers
		for(Integer ii = 0; ii < 500000; ii++){
			testnumbers.add(rand.nextInt());
		}
		
		// Amount of time sort takes
		long startTime = System.nanoTime();
		int swaps =  test.sort(testnumbers);
		long difference = System.nanoTime() - startTime;
		System.out.println("Swaps: " + swaps + 
				"  Milliseconds: " + TimeUnit.NANOSECONDS.toMillis(difference)+ 
				"  Microseconds: " + TimeUnit.NANOSECONDS.toMicros(difference));
	}
	
	public void randTest2_500_000(ISorter test){
		List<Integer> testnumbers = new ArrayList<Integer>();
		Random rand = new Random();

		// Fill in array with random numbers
		for(Integer ii = 0; ii < 2500000; ii++){
			testnumbers.add(rand.nextInt());
		}
		
		// Amount of time sort takes
		long startTime = System.nanoTime();
		int swaps = test.sort(testnumbers);
		long difference = System.nanoTime() - startTime;
		
		System.out.println("Swaps: " + swaps + 
				"  Milliseconds: " + TimeUnit.NANOSECONDS.toMillis(difference)+ 
				"  Microseconds: " + TimeUnit.NANOSECONDS.toMicros(difference));
	}
}
