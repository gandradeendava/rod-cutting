public class KnapsackProblem {
    public static void main(String[] args) {
        int knapsackMaxWeight = 5;
        int profit[] = {200, 240, 140, 150};
        int weight[] = {1, 3, 2, 5};

        int maxProfit = maximizeProfitRecursive(weight, profit, weight.length, knapsackMaxWeight);
        System.out.println("Valor maximo: " + maxProfit);
    }

    private static int maximizeProfitRecursive(int[] weightArr, int[] profitArr, int currentItem, int knapsackWeight) {

        //If either knapsack weight capacity reached 0 or we don't have more items to pick,
        //return 0 in either case.
        if(knapsackWeight == 0 || currentItem == 0){
            return 0;
        }

        //if weight of current item on which we are working is greater than knapsack remaining capacity,
        if(weightArr[currentItem-1] > knapsackWeight){

            //then we can't pick current item, keep knapsack remaining
            //capacity as it is and try checking next item
            return maximizeProfitRecursive(weightArr, profitArr, currentItem-1, knapsackWeight);
        }else{

            //Here we have 2 choice, we can either pick the item or not to pick.
            //So we have to check profit by picking the item and profit by not picking the item
            //(obviously keeping weight constraint in mind otherwise picking item will always be beneficial)

            //we can pick current item, reduce knapsack remaining capacity by subtracting
            //current item weight from knapsack capacity, and check for next item.
            int including = profitArr[currentItem-1] + maximizeProfitRecursive(weightArr, profitArr, currentItem-1, knapsackWeight-weightArr[currentItem-1]);

            //Check Profit by not picking item, keep knapsack remaining capacity as it is and try
            //checking next item
            int excluding = maximizeProfitRecursive(weightArr, profitArr, currentItem-1, knapsackWeight);

            //Whichever gives us maximium profit, return that.
            return Math.max(including, excluding);
        }
    }
}
