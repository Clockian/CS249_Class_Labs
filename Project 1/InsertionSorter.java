import java.util.Comparator;
import java.util.List;

public class InsertionSorter implements ISorter{

	@Override
	public <T extends Comparable<T>> int sort(List<T> list) {
		int jj;
		T temp;
		int swaps = 0;
		for(int ii = 1; ii < list.size(); ii++){
			jj = ii;
			while(jj > 0 && list.get(jj - 1).compareTo(list.get(jj)) > 0){
				temp = list.get(jj);
				list.set(jj, list.get(jj - 1));
				list.set(jj - 1, temp);
				jj--;
				swaps++;
			}
		}
		return swaps;
	}

	@Override
	public <T> int sort(List<T> list, Comparator<T> comparator) {
		int jj;
		T temp;
		int swaps = 0;
		for(int ii = 1; ii < list.size(); ii++){
			jj = ii;
			while(jj > 0 && comparator.compare(list.get(jj - 1), list.get(jj)) > 0){
				temp = list.get(jj);
				list.set(jj, list.get(jj - 1));
				list.set(jj - 1, temp);
				jj--;
				swaps++;
			}
		}
		return swaps;
	}

}
