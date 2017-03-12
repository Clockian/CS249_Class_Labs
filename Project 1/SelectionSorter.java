import java.util.Comparator;
import java.util.List;

public class SelectionSorter implements ISorter{

	@Override
	public <T extends Comparable<T>> int sort(List<T> list) {
		int swaps = 0;
		T smallestThing;
		int smallestIndex;
		for(int ii = 0; ii < list.size(); ii++){
			smallestThing = list.get(ii);
			smallestIndex = ii;
			for(int jj = ii + 1; jj < list.size(); jj++){
				if(smallestThing.compareTo(list.get(jj)) > 0){
					smallestThing = list.get(jj);
					smallestIndex = jj;
				}
			}
			
			if(smallestIndex != ii){
				list.set(smallestIndex, list.get(ii));
				list.set(ii, smallestThing);
				swaps++;
			}
		}
		return swaps;
	}

	@Override
	public <T> int sort(List<T> list, Comparator<T> comparator) {
		int swaps = 0;
		T smallestThing;
		int smallestIndex;
		for(int ii = 0; ii < list.size(); ii++){
			smallestThing = list.get(ii);
			smallestIndex = ii;
			for(int jj = ii + 1; jj < list.size(); jj++){
				if(comparator.compare(smallestThing, list.get(jj)) > 0){
					smallestThing = list.get(jj);
					smallestIndex = jj;
				}
			}
			
			if(smallestIndex != ii){
				list.set(smallestIndex, list.get(ii));
				list.set(ii, smallestThing);
				swaps++;
			}
		}
		return swaps;
	}

}
