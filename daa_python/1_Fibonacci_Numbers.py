import time

rSteps = 0
iSteps = 0  # Added count for the iterative method

def rStepFibonacci(n):
    global rSteps
    rSteps += 1
    if n < 0:
        return 0
    if n == 1 or n == 0:
        return 1
    return rStepFibonacci(n - 1) + rStepFibonacci(n - 2)

def iStepFibonacci(n):
    f = [0, 1]
    cnt = 2
    for i in range(2, n):
        cnt += 1
        f.append(f[i - 1] + f[i - 2])
    global iSteps
    iSteps = 1  # In the iterative method, set the count to 1
    print("Fibonacci Series (Iterative):", end=" ")
    for i in range(n):
        print(f[i], end=" ")
    print()

def printFibonacciSeries(n):
    print("Fibonacci Series (Recursive):", end=" ")
    for i in range(n):
        print(rStepFibonacci(i), end=" ")
    print()

while True:
    print("Fibonacci Series Menu:")
    print("1. Calculate Iteratively")
    print("2. Calculate Recursively")
    print("3. Quit")
    choice = int(input("Enter your choice: "))

    if choice == 1 or choice == 2:
        n = int(input("Enter the number of Fibonacci numbers to generate: "))

        if n <= 0:
            print("Invalid input. Please enter a positive number.")
            continue

        if choice == 1:
            iSteps = 0  # Reset the iterative count

            start = time.time()  # Record the start time
            iStepFibonacci(n)
            end = time.time()  # Record the end time

            elapsedTime = (end - start) * 1000  # Calculate elapsed time in milliseconds

            print(f"Iterative function called {iSteps} times.")
            print(f"Time taken: {elapsedTime} milliseconds")
        elif choice == 2:
            rSteps = 0  # Reset the recursive count

            start = time.time()  # Record the start time
            printFibonacciSeries(n)
            end = time.time()  # Record the end time

            elapsedTime = (end - start) * 1000  # Calculate elapsed time in milliseconds

            print(f"Recursive function called {rSteps} times.")
            print(f"Time taken: {elapsedTime} milliseconds")
    elif choice == 3:
        print("Successfully Exited.")
        break
    else:
        print("Invalid choice. Please select a valid option.")
'''Fibonacci Series Menu:
1. Calculate Iteratively
2. Calculate Recursively
3. Quit
Enter your choice: 1
Enter the number of Fibonacci numbers to generate: 10
Fibonacci Series (Iterative): 0 1 1 2 3 5 8 13 21 34 
Iterative function called 1 times.
Time taken: 0.03266334533691406 milliseconds
Fibonacci Series Menu:
1. Calculate Iteratively
2. Calculate Recursively
3. Quit
Enter your choice: 2
Enter the number of Fibonacci numbers to generate: 10
Fibonacci Series (Recursive): 1 1 2 3 5 8 13 21 34 55 
Recursive function called 109 times.
Time taken: 0.232696533203125 milliseconds
Fibonacci Series Menu:
1. Calculate Iteratively
2. Calculate Recursively
3. Quit
Enter your choice: 3
Successfully Exited.
'''