public class Main {
    public static void main(String[] args) {
        int knapsackMaxWeight = 5;
        int profit[] = {100, 200, 300, 150};
        int weight[] = {1, 3, 2, 5};

        int maxProfit = maximizeProfit(weight, profit, knapsackMaxWeight);
        System.out.println(maxProfit);
    }

    private static int maximizeProfit(int[] weight, int[] profit, int max) {
        int[][] temp = new int[weight.length+1][max+1];

        for (int row = 0; row <= weight.length; row++) {
            for (int col = 0; col <= max; col++) {
                if(row==0 || col==0){
                    continue;
                }
                if(col >= weight[row-1]){
                    temp[row][col] = Math.max(profit[row-1]+temp[row-1][col-weight[row-1]], temp[row-1][col]);
                }else{
                    temp[row][col] = temp[row-1][col];
                }
            }
        }
        return temp[weight.length][max];
    }
}