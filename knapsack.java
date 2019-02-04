import java.util.Random;

public class knapsack {
    static int max(int a, int b)
    {
        return (a > b)? a : b;
    }
    static int knapSack(int W, int wt[], int val [], int n)
    {
        int i, w;
        int[][] K = new int[n + 1][W + 1];

        for (i = 0; i <= n; i++)
        {
            for (w = 0; w <= W; w++)
            {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (wt[i - 1] <= w)
                    K[i][w] = max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i-1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }

        return K[n][W];
    }

    public static void main(String args[])
    {
        Random rand = new Random();


        int n = 5;;
        int[] wt = new int[n];
        for (int i = 0; i < n; i++)
            wt[i] = rand.nextInt(50) + 1;

        int[] val = new int[n];

        val = new int [n];
        for (int i = 0; i < n; i++)
            val[i] = rand.nextInt(50)+1;
        int W = 150;

        System.out.println("Valor maximo para un peso de " +W+" "+ knapSack(W, wt, val, n));

    }
}