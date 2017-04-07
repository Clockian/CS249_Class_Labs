import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeSorter implements IMergeSorter{
	
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
		return mergeSortRecursive(list, 0, list.size()-1, comparator);
	}

	@Override
	public <T> int mergeSortRecursive(List<T> list, int low, int high, Comparator<T> comparator) {
		int counter = 0;
		
		//if(low >= high && (high - low) <= 1){
		//	return counter;
		//}
		//else if(counter == 0 && (low - high) == 1){
		//	return counter;
		//}
		if(low < high){
			int mid = (high + low) / 2;
			counter += mergeSortRecursive(list, low, mid, comparator);
			counter += mergeSortRecursive(list, mid+1, high, comparator);
			counter += (high - low);
			merge(list, low, mid, high, comparator);
		}
		return counter;
		

	}
	
	private <T> void merge(List<T>list, int low, int mid, int high, Comparator<T> comparator){
		ArrayList<T> sorted = new ArrayList<T>();
		int left = low;
		int right = mid + 1;
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

		while(left <= mid){
			sorted.add(list.get(left));
			left++;
		}

		while(right <= high){
			sorted.add(list.get(right));
			right++;
		}
		
		int i = 0;
        int j = low;
        //Setting sorted array to original one
        while(i<sorted.size()){
            list.set(j, sorted.get(i++));
            j++;
        }
	}
}
