/* A Naive recursive implementation of 0-1 Knapsack problem */
#include <bits/stdc++.h>
#include <stdlib.h>
#include <iostream>
using namespace std;
// A utility function that returns maximum of two integers
int max(int a, int b)
{
    return (a > b)? a : b;
}
// Returns the maximum value that can be put in a knapsack of capacity W
int knapSack(int MaxWeight, int weight[], int value[], int nitems)
{
// Base Case
    if (nitems == 0 || MaxWeight == 0)
        return 0;
// If weight of the nth item is more than Knapsack capacity W, then
// this item cannot be included in the optimal solution
    if (weight[nitems-1] > MaxWeight)
        return knapSack(MaxWeight, weight, value, nitems-1);
// Return the maximum of two cases:
// (1) nth item included
// (2) not included
    else
        return max(value[nitems-1]+ knapSack(MaxWeight-weight[nitems-1], weight, value, nitems-1),knapSack(MaxWeight, weight, value, nitems-1));
}

// Driver program to test above function
int main()
{
    int nitems;
    int MaxWeight=0;
    cout<<" Enter the number of items : ";
    cin>>nitems;
    int value[nitems];
    int weight[nitems];
    cout<<" Enter the Maximum weight : ";
    cin>>MaxWeight;
    cout<<endl;
    for (int i = 1; i <= nitems; i++)
    {
        cout << " Enter weight and value of item " << i << " : ";
        cin >> weight[i-1] >> value[i-1];
    }

    //int val[] = {60, 100, 120};
    //int wt[] = {10, 20, 30};
    //int W = 50;
    printf("%d", knapSack(MaxWeight, weight, value, nitems));
    return 0;
}
