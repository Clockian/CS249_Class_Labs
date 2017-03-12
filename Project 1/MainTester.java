import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Timer;
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
	
	public void randTest20(ISorter test){
		List<Integer> testnumbers = new ArrayList<Integer>();
		Random rand = new Random();
		
		// Fill in array with random numbers
		for(Integer ii = 0; ii < 20; ii++){
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
	
	public void randTest100(ISorter test){
		List<Integer> testnumbers = new ArrayList<Integer>();
		Random rand = new Random();
		
		// Fill in array with random numbers
		for(Integer ii = 0; ii < 100; ii++){
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
	
	public void randTest500(ISorter test){
		List<Integer> testnumbers = new ArrayList<Integer>();
		Random rand = new Random();

		// Fill in array with random numbers
		for(Integer ii = 0; ii < 500; ii++){
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
	
	public void randTest2500(ISorter test){
		List<Integer> testnumbers = new ArrayList<Integer>();
		Random rand = new Random();

		// Fill in array with random numbers
		for(Integer ii = 0; ii < 2500; ii++){
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
	
	public <T> void  musicLibrary(ISorter test, Comparator<T> comparator){
		MusicTrack buildLibrary = new MusicTrack("SongA", "AlbumA", 7, "ArtistA", 1998, 3);
		List<T> library = (List<T>) buildLibrary.generateMusicLibrary();
		
		long startTime = System.nanoTime();
		int swaps = test.sort(library, comparator);
		long difference = System.nanoTime() - startTime;
		
		System.out.println("Swaps: " + swaps + 
				"  Milliseconds: " + TimeUnit.NANOSECONDS.toMillis(difference)+ 
				"  Microseconds: " + TimeUnit.NANOSECONDS.toMicros(difference));
	}
}
