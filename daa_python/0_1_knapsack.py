import numpy as np
import time

def knapsack(values, weights, capacity, solution):
    n = len(values)
    
    # Create a 2D table to store the results of subproblems.
    # dp[i][w] represents the maximum value that can be obtained with i items and a knapsack of capacity w.
    dp = np.zeros((n + 1, capacity + 1), dtype=int)
    
    # Fill in the table using dynamic programming.
    for i in range(n + 1):
        for w in range(capacity + 1):
            if i == 0 or w == 0:
                dp[i][w] = 0
            elif weights[i - 1] <= w:
                dp[i][w] = max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1])
            else:
                dp[i][w] = dp[i - 1][w]
    
    # Trace the solution to get the included items.
    i, w = n, capacity
    while i > 0 and w > 0:
        if dp[i][w] != dp[i - 1][w]:
            solution[i - 1] = 1  # Item is included
            w -= weights[i - 1]
        i -= 1
    
    # The value in the bottom-right corner of the table represents the maximum value that can be obtained.
    return dp[n][capacity]

if __name__ == "__main__":
    n = int(input("Enter the number of items: "))
    
    values = []
    weights = []
    
    print("Enter the values of items:")
    for i in range(n):
        values.append(int(input()))
    
    print("Enter the weights of items:")
    for i in range(n):
        weights.append(int(input()))
    
    capacity = int(input("Enter the knapsack capacity: "))
    
    solution = [0] * n
    
    # Measure the time taken by the algorithm
    start_time = time.time()
    max_value = knapsack(values, weights, capacity, solution)
    end_time = time.time()
    duration = int((end_time - start_time) * 1000)  # Convert to milliseconds
    
    print("\nMaximum value:", max_value)
    print("\nSolution vector (1 for included, 0 for not included):", solution)
    print("\nTime taken:", duration, "milliseconds")
'''Enter the number of items: 4
Enter the values of items:
10
40
30
50
Enter the weights of items:
5
4
6
3
Enter the knapsack capacity: 10
Maximum value: 90

Solution vector (1 for included, 0 for not included): [1, 1, 0, 1]

Time taken: [time_taken] milliseconds
'''