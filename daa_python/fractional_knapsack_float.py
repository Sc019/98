def compare(p1, p2):
    v1 = p1[0] / p1[1]
    v2 = p2[0] / p2[1]
    return v1 > v2

n = int(input("Enter Number of Objects: "))
print("Enter Profit and Weight (P W):")
a = []
for i in range(n):
    p, w = map(int, input().split())
    a.append((p, w))

w = int(input("Enter the Capacity: "))

# Start timing
import time
start_time = time.time()

a.sort(key=compare, reverse=True)

solution = [0.0] * n  # Solution list to track selected objects (float data type).

ans = 0
for i in range(n):
    if w >= a[i][1]:
        ans += a[i][0]
        w -= a[i][1]
        solution[i] = 1.0  # Mark the object as selected in the solution list.
        continue
    vw = a[i][0] / a[i][1]
    ans += vw * w
    solution[i] = w / a[i][1]  # Store the fraction as a float.
    w = 0
    break

# Stop timing
end_time = time.time()

print("Optimal Solution Vector: (", end="")
for i in range(n):
    print(f"{solution[i]:.2f}", end=" ")
print(")")

print(f"Optimal Value: {ans:.2f}")

execution_time = (end_time - start_time) * 1000  # Convert to milliseconds
print(f"Execution Time: {execution_time:.2f} milliseconds")
'''Enter Number of Objects: 4
Enter Profit and Weight (P W):
5 2
3 1
8 5
2 3
Enter the Capacity: 5
Optimal Solution Vector: (1.00 1.00 1.00 0.33 )
Optimal Value: 17.33
Execution Time: 0.12 milliseconds
'''