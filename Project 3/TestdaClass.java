import java.util.ArrayList;
import java.util.Comparator;



public class TestdaClass {
	private static class ReverseComparator<T extends Comparable<T>> implements Comparator<T>
	{
	  public int compare(T a, T b)
	  {
	    return -a.compareTo(b);
	  }
	}
	
	public static void main(String[] args){
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		MergeSorter test = new MergeSorter();
		
		//for(int ii = 3; ii >= 1; ii--){
		//	numbers.add(ii);
		//}
		
		numbers.add(-1);
		numbers.add(0);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		numbers.add(6);
		numbers.add(7);
		numbers.add(8);
		numbers.add(9);
		
		//System.out.println(numbers);
		test.mergeSortRecursive(numbers, 2, 8, new ReverseComparator<Integer>());
		System.out.println(numbers);
	}
}