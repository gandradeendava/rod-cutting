/* 
A Naive recursive implementation of 0-1 Knapsack problem 
Code found on geeksforgeeks.org
Url: https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10
*/

public class Main 
{ 

	static int max(int a, int b) { 
    return (a > b)? a : b; 
  } 
	
	// Returns the maximum value that can be put in a knapsack of capacity W 
	static int knapSack(int maxWeight, int weights[], int values[], int n) 
	{ 
    // Base Case (End recursion)
    if (n == 0 || maxWeight == 0) 
      return 0; 
    
    // If weight of the nth item is more than Knapsack capacity W, then 
    // this item cannot be included in the optimal solution 
    if (weights[n-1] > maxWeight) 
    return knapSack(maxWeight, weights, values, n-1); 
    
    // Return the maximum of two cases: 
    // (1) nth item included 
    // (2) not included 
    else return max( values[n-1] + knapSack(maxWeight-weights[n-1], weights, values, n-1), 
            knapSack(maxWeight, weights, values, n-1) 
            ); 
	} 

public static void main(String args[]) 
{ 
		int values[] = new int[]{60, 100, 120}; 
		int weights[] = new int[]{10, 20, 30}; 
	int maxWeight = 50; 
	int n = values.length;
  System.out.println("Knapsack Execution");
	System.out.println("Total weight: " +knapSack(maxWeight, weights, values, n)); 
	} 
} 