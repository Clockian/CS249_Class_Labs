public class KnapsackSolver implements IKnapsackSolver{
	
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
	}
	
	public boolean[] knapsackRecursive2(double capacity, int n, Item[] items, boolean[] prior) {
		// Checks if it exceeds capacity or array size
		if(capacity <= 0 || n == items.length){
			return prior;
		}
		
		// Skip if exceed capacity
		if(items[n].getWeight() > capacity){
			return knapsackRecursive2(capacity, n + 1, items, prior);
		}
		
		else{
			boolean[] prior1 = knapsackRecursive2(capacity, n + 1, items, prior);		
			boolean[] prior2 = knapsackRecursive2(capacity - items[n].getWeight(), n + 1, items, prior);
			//prior[n] = true;
			
			double val1 = 0;
			double val2 = 0;
			for(int ii = 0; ii < prior1.length; ii++){
				if(prior1[ii] == true){
					val1 = val1 + items[ii].getValue();
				}
				if(prior2[ii] == true){
					val2 = val2 + items[ii].getValue();
				}
			}
			if(val1 >= val2){
				return prior1;
			}
			else{
				return prior2;
			}
		}
	}
}
