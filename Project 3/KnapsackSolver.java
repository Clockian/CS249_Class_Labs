
public class KnapsackSolver implements IKnapsackSolver{
	int n = 0;
	@Override
	public boolean[] knapsack(double capacity, Item[] items) {
		boolean[] prior = new boolean[items.length];
		for(int ii = 0; ii < prior.length; ii++){
			prior[ii] = false;
		}
		return knapsackRecursive(capacity, items, prior);
	}

	@Override
	public boolean[] knapsackRecursive(double capacity, Item[] items, boolean[] prior) {
		return knapsackRecursive2(capacity, 0, items, prior);
		// Base Case
		  /*
		   if (n == 0 || capacity <= 0)
		       return 0;

		   // If weight of the nth item is more than Knapsack capacity W, then
		   // this item cannot be included in the optimal solution
		   if (wt[n-1] > W)
		       return knapSack(W, wt, val, n-1);

		   // Return the maximum of two cases: (1) nth item included (2) not included
		   else return max( val[n-1] + knapSack(W-wt[n-1], wt, val, n-1),
		                    knapSack(W, wt, val, n-1)
		                  );*/
	}
	
	public boolean[] knapsackRecursive2(double capacity, int n, Item[] items, boolean[] prior) {
		
		if(capacity <= 0 || n == items.length){
			prior[n] = true;
			return prior;
		}
		
		// skip if exceed capacity
		if(items[n].getWeight() > capacity){
			return knapsackRecursive2(capacity, n + 1, items, prior);
		}
		
		else{
			return knapsackRecursive2(capacity - items[n].getWeight(), n + 1, items, prior);
		}
		
		/*
		if(n != 0 && items[n].getValue() <= items[n - 1].getValue()){
			prior[n] = false;
			return knapsackRecursive2(capacity, n + 1, items, prior);
		}
		 */
	}
	
	public boolean[] knapsackRecursive3(double capacity, int n, Item[] items, boolean[] prior) {
		frownyface(capacity, n, items, prior);
		return prior;
	}
	
	public double frownyface(double capacity, int n, Item[] items, boolean[] prior){
		if(capacity <= 0 || n == items.length){
			return 0;
		}
		
		if(items[n].getWeight() > capacity){
			return frownyface(capacity, n + 1, items, prior);
		}
		
		else{
			
			//return frownyface(capacity, n + 1, items, prior[n] = false).compareTo(frownyface(capacity - items[n].getWeight(), n + 1, items, prior[n] = true) + items[n].getValue());
			
			double total1 = frownyface(capacity, n + 1, items, prior);
			double total2 = frownyface(capacity - items[n].getWeight(), n + 1, items, prior) + items[n].getValue();
			
			if(total1 > total2){
				prior[n] = true;
				return total1;
			}
			else{
				prior[n] = true;
				//prior[n] = false;
				return total2;
			}
		}
	}
}
