package endava.dynamic.program.knapsack.models;

public class Principal {

	private int[] weight;
	private int[] values;
	private int numOfItems;
	private int capacity;
	private int[][] knapsackTable;
	private int totalBenefit;


	public Principal(int [] weightsOfKnapsnack, int [] valuesOfKnapsnack, int numOfItems, int capacityKanpsack) {

		this.weight = weightsOfKnapsnack;
		this.values = valuesOfKnapsnack;
		this.numOfItems = numOfItems;
		this.capacity = capacityKanpsack;
		this.knapsackTable = new int [numOfItems+1][capacityKanpsack+1];
	}


	public void ejecucion() {
		
		for (int i = 1; i < numOfItems+1; i++) {

			for (int j = 0; j < capacity+1; j++) {
				
				int notTakingItems = knapsackTable[i-1][j];
				int takingItems = 0;
				
				if (weight [i] <= j) {
					takingItems = values[i] + knapsackTable[i-1][j - weight[i]];
				}
				
				knapsackTable[i][j] = Math.max(notTakingItems, takingItems);
				
			}
		}
		
		System.out.println(totalBenefit = knapsackTable[numOfItems][capacity]);
	}


	
}
