class Knapsack
{

    static int max(int a, int b) { return (a > b)? a : b; }


    static int knapSack(int totalW, int witems[], int values[], int numberOfItems)
    {
        int i, w;
        int K[][] = new int[numberOfItems+1][totalW+1];


        for (i = 0; i <= numberOfItems; i++)
        {
            for (w = 0; w <= totalW; w++)
            {
                if (i==0 || w==0)
                    K[i][w] = 0;
                else if (witems[i-1] <= w)
                    K[i][w] = max(values[i-1] + K[i-1][w-witems[i-1]],  K[i-1][w]);
                else
                    K[i][w] = K[i-1][w];
            }
        }

        return K[numberOfItems][totalW];
    }


    public static void main(String args[])
    {
        int val[] = new int[]{55, 25, 10};
        int wt[] = new int[]{210, 14, 312};
        int  W = 500;
        int n = val.length;
        System.out.println("The maximum value is:");
        System.out.println(knapSack(W, wt, val, n));
    }
} 