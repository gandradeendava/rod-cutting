public class Main {

        // A utility function that returns maximum of two integers
        static int max(int a, int b) {
            if(a > b)
                return a;
            else
                return b;
        }

        // Returns the maximum value that can be put in a knapsack of capacity W
        static int knapSack(int W, int wt[], int val[], int n)
        {
            int i, w;
            int K[][] = new int[n+1][W+1];

            // Build table K[][] in bottom up manner
            for (i = 0; i <= n; i++)
            {
                for (w = 0; w <= W; w++)
                {
                    System.out.println("Imprime i: " + i );
                    System.out.println("Imprime w: " + w );
                    if (i==0 || w==0){
                        K[i][w] = 0;
                    }

                    else if (wt[i-1] <= w){
                        K[i][w] = max(val[i-1] + K[i-1][w-wt[i-1]],  K[i-1][w]);
                        System.out.println("Valor del elemento " + (i-1) +": " + val[i-1]);
                        System.out.println("Valor a sumar:"+ K[i-1][w-wt[i-1]]);
                        System.out.println("Fila: " + (i-1));
                        System.out.println("Columna: "+ (w-wt[i-1]));
                        System.out.println("Peso: " + wt[i-1] );
                        System.out.println("Suma: " + (val[i-1] + K[i-1][w-wt[i-1]]));
                        System.out.println("Posicion anterior: " + K[i-1][w]);

                    }
                    else{
                        K[i][w] = K[i-1][w];
                    }
                    imprimirMatriz(K, n, W);
                }
            }

            return K[n][W];
        }


        // Driver program to test above function
        public static void main(String args[])
        {
            int val[] = new int[]{60, 100, 120};
            int wt[] = new int[]{1, 2, 3};
            int  W = 5;
            int n = val.length;
            System.out.println(knapSack(W, wt, val, n));
        }

        public static void imprimirMatriz(int matriz[][], int n, int W){
            System.out.println("Se va a imprimir:");
            for (int i = 0; i <= n; i++)
            {
                for (int w = 0; w <= W; w++)
                {
                    System.out.print(matriz[i][w] + "   ");
                }
                System.out.println();
            }

        }
}

