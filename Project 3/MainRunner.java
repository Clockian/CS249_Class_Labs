import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MainRunner {
	public static void main(String[] args){
		MainTester test = new MainTester();
		
		ISorter merge = new MergeSorter();
		
		System.out.println("\n\nMerge Sort_________________");
		test.randTest20_000(merge);
		test.randTest100_000(merge);
		test.randTest500_000(merge);
		test.randTest2_500_000(merge);
		
		System.out.println("\n\nNQueens Problem_________________");
		NQueensSolver sadness = new NQueensSolver();
		
		for(int n = 4; n < 13; n++){
			long startTime = System.nanoTime();
			for(int ii = 0; ii < 100; ii++){
				// Amount of time sort takes
				sadness.nQueens(n);
			}
			long difference = System.nanoTime() - startTime;
			System.out.println( 
					"  Milliseconds: " + TimeUnit.NANOSECONDS.toMillis(difference) + 
					"  Microseconds: " + TimeUnit.NANOSECONDS.toMicros(difference));
		}
		
		System.out.println("\n\nKnapsackSize_________________");
		int[] knapsackSize = {10, 15, 20, 25};
		Random rand = new Random();
		IKnapsackSolver.Item[] items;
		KnapsackSolver solve = new KnapsackSolver();
		for(int ii = 0; ii < 4; ii++){
			items = new IKnapsackSolver.Item[knapsackSize[ii]];
			for(int jj = 0; jj < knapsackSize[ii]; jj++){
				items[jj] = new IKnapsackSolver.Item(rand.nextInt(10), rand.nextInt(10));
			}
			double capacity = knapsackSize[ii] * 3;
			
			long startTime = System.nanoTime();
			solve.knapsack(capacity, items);
			long difference = System.nanoTime() - startTime;
			System.out.println( 
					"  Milliseconds: " + TimeUnit.NANOSECONDS.toMillis(difference) + 
					"  Microseconds: " + TimeUnit.NANOSECONDS.toMicros(difference));
		}
		
	}
}
