import java.util.Comparator;
import java.util.List;

public class BubbleSorter implements ISorter{

	@Override
	public <T extends Comparable<T>> int sort(List<T> list) {
		Boolean swapped = false;
		int swaps = 0;
		T temp;
		
		while(true){
			swapped = false;
			for(int jj = 0; jj < list.size() - 1; jj++){
				if(list.get(jj).compareTo(list.get(jj + 1)) > 0){
					temp = list.get(jj);
					list.set(jj, list.get(jj + 1));
					list.set(jj + 1, temp);
					swaps++;
					swapped = true;
				}
			}
			
			if(swapped == false){
				break;
			}
		}
		return swaps;
	}

	@Override
	public <T> int sort(List<T> list, Comparator<T> comparator) {
		Boolean swapped = false;
		int swaps = 0;
		T temp;
		
		while(true){
			swapped = false;
			for(int jj = 0; jj < list.size() - 1; jj++){
				//if(list.get(jj).compareTo(list.get(jj + 1)) > 0){
				if(comparator.compare(list.get(jj), list.get(jj + 1)) > 0){
					temp = list.get(jj);
					list.set(jj, list.get(jj + 1));
					list.set(jj + 1, temp);
					swaps++;
					swapped = true;
				}
			}
			
			if(swapped == false){
				break;
			}
		}
		return swaps;
	}

}
