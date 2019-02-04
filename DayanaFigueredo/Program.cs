using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Base
{
    class Program
    {
        static int knapsack(int W, int n, int[] w, int[] val)//Weight of the bag, quantity of items, weight and value of each item
        {
            int[,] K = new int[n + 1, W + 1];

            for (int i = 0; i <= n; i++)
            {
                for (int j = 0; j <= W; j++)
                {
                    if (i == 0 || j == 0)
                        K[i, j] = 0; 

                    else if (w[i - 1] <= j)
                        K[i, j] = Math.Max(val[i - 1] + K[i - 1, j - w[i - 1]], K[i - 1, j]);

                    else
                        K[i, j] = K[i - 1, j];
                }
            }
            return K[n, W];
        }
        static int max(int a, int b)
        {
            if (a > b)
                return a;
            else
                return b;
        }

        static void Main()
        {
            int[] val = new int[] {1, 2, 3};
            int[] wt = new int[] {10, 20, 30};
            int W = 50;
            int n = val.Length;
            Console.WriteLine(" ");
            Console.WriteLine("VALUE SUM:"+knapsack(W, n, wt, val));
            Console.WriteLine(" ");
            Console.WriteLine("PRESS ANY KEY TO EXIT..........................");
            Console.ReadKey();
        }
    }
}
