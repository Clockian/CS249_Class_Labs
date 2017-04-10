import java.util.concurrent.TimeUnit;

public class MainRunner {
	public static void main(String[] args){
		MainTester test = new MainTester();
		
		ISorter merge = new MergeSorter();
		
		System.out.println("\nMerge Sort");
		test.randTest20_000(merge);
		test.randTest100_000(merge);
		test.randTest500_000(merge);
		test.randTest2_500_000(merge);
		
		NQueensSolver sadness = new NQueensSolver();
		
		for(int ii = 0; ii < 100; ii++){
			for(int n = 4; n < 13; n++){
				// Amount of time sort takes
				long startTime = System.nanoTime();
				sadness.nQueens(n);
				long difference = System.nanoTime() - startTime;
				
				System.out.println( 
						"  Milliseconds: " + TimeUnit.NANOSECONDS.toMillis(difference) + 
						"  Microseconds: " + TimeUnit.NANOSECONDS.toMicros(difference));
			}
		}
		
		
	}
}
