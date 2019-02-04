public class Main {

    static int knapSackRecursive(int W, int wt[], int val[], int n) {
        if (n == 0 || W == 0)
            return 0;

        if (wt[n-1] > W)
            return knapSackRecursive(W, wt, val, n-1);

        else return (int)Math.max(
                val[n-1] + knapSackRecursive(W-wt[n-1], wt, val, n-1),
                knapSackRecursive(W, wt, val, n-1)
        );
    }

    static int knapSackDP(int W, int wt[], int val[], int n)
    {
        int i, w;
        int K[][] = new int[n+1][W+1];

        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i==0 || w==0)
                    K[i][w] = 0;
                else if (wt[i-1] <= w)
                    K[i][w] = (int)Math.max(val[i-1] + K[i-1][w-wt[i-1]],  K[i-1][w]);
                else
                    K[i][w] = K[i-1][w];
            }
        }

        return K[n][W];
    }

    public static void main(String[] args) {
        int val [] = new int[]{60, 100, 120};
        int wt  [] = new int[]{10, 20, 30};
        int  W = 50;
        int n = val.length;
        System.out.println(knapSackRecursive(W, wt, val, n));
        System.out.println(knapSackDP(W, wt, val, n));

    }
}
