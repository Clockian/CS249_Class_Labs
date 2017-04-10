/*
 * Created by Jasque Saydyk
 * Project 03 - Recursion
 * CS 249
 * 10 April 2017
 * Description - Performs a merge sort through Recursion
*/
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeSorter implements IMergeSorter{
	
	// Generic class to compare generic objects generically
	public static class TComparator<T extends Comparable<T>> implements Comparator<T>{

		@Override
		public int compare(T arg0, T arg1) {
			if(arg0.compareTo(arg1) > 0){
				return 1;
			}
			else if(arg0.compareTo(arg1) < 0){
				return -1;
			}
			else{
				return 0;
			}
		}
		
	}
	
	@Override
	public <T extends Comparable<T>> int sort(List<T> list) {
		TComparator<T> comparator = new TComparator<>();
		return mergeSortRecursive(list, 0, list.size()-1, comparator);
	}

	@Override
	public <T> int sort(List<T> list, Comparator<T> comparator) {
		// Created separate function with more variables to use
		return mergeSortRecursive(list, 0, list.size()-1, comparator);
	}

	@Override
	public <T> int mergeSortRecursive(List<T> list, int low, int high, Comparator<T> comparator) {
		int counter = 0;
		
		// Performs recursion as long as the low pointer doesn't get above the high pointer
		// I could put in addition checks, but this is the only one that seems to actually matter
		if(low < high){
			int mid = (high + low) / 2;
			counter += mergeSortRecursive(list, low, mid, comparator);
			counter += mergeSortRecursive(list, mid+1, high, comparator);
			counter += (high - low);
			merge(list, low, mid, high, comparator);
		}
		return counter;
	}
	
	// Merge function that makes a new sorted list in the indices given
	private <T> void merge(List<T>list, int low, int mid, int high, Comparator<T> comparator){
		ArrayList<T> sorted = new ArrayList<T>();
		int left = low;
		int right = mid + 1;
		
		// Combines two sorted segments
		while(left <= mid && right <= high){
			if(comparator.compare(list.get(left), list.get(right)) < 0){
				sorted.add(list.get(left));
				left++;
			}
			else{
				sorted.add(list.get(right));
				right++;
			}
		}

		// Sorts left side
		while(left <= mid){
			sorted.add(list.get(left));
			left++;
		}

		// Sorts right side
		while(right <= high){
			sorted.add(list.get(right));
			right++;
		}
		
		int i = 0;
        int j = low;
        
        // Setting sorted array to original one
        while(i<sorted.size()){
            list.set(j, sorted.get(i++));
            j++;
        }
	}
}
