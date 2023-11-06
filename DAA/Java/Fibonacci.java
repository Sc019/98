import java.util.Scanner;

public class Fibonacci {
    private static int rSteps = 0;
    private static int iSteps = 0; // Added count for the iterative method

    public static int rStepFibonacci(int n) {
        rSteps++;
        if (n < 0) return 0;
        if (n == 1 || n == 0) return 1;
        return rStepFibonacci(n - 1) + rStepFibonacci(n - 2);
    }

    public static void iStepFibonacci(int n) {
        int[] f = new int[n];
        f[0] = 0;
        f[1] = 1;
        iSteps = 1; // In the iterative method, set the count to 1
        System.out.print("Fibonacci Series (Iterative): ");
        for (int i = 2; i < n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        for (int i = 0; i < n; i++) {
            System.out.print(f[i] + " ");
        }
        System.out.println();
    }

    public static void printFibonacciSeries(int n) {
        System.out.print("Fibonacci Series (Recursive): ");
        for (int i = 0; i < n; i++) {
            System.out.print(rStepFibonacci(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int choice;
        int n;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Fibonacci Series Menu:");
            System.out.println("1. Calculate Iteratively");
            System.out.println("2. Calculate Recursively");
            System.out.println("3. Quit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            if (choice == 1 || choice == 2) {
                System.out.print("Enter the number of Fibonacci numbers to generate: ");
                n = scanner.nextInt();

                if (n <= 0) {
                    System.out.println("Invalid input. Please enter a positive number.");
                    continue;
                }

                if (choice == 1) {
                    iSteps = 0; // Reset the iterative count

                    long start = System.currentTimeMillis(); // Record the start time
                    iStepFibonacci(n);
                    long end = System.currentTimeMillis(); // Record the end time

                    double elapsedTime = (end - start); // Calculate elapsed time in milliseconds

                    System.out.println("Iterative function called " + iSteps + " times.");
                    System.out.println("Time taken: " + elapsedTime + " milliseconds");
                } else if (choice == 2) {
                    rSteps = 0; // Reset the recursive count

                    long start = System.currentTimeMillis(); // Record the start time
                    printFibonacciSeries(n);
                    long end = System.currentTimeMillis(); // Record the end time

                    double elapsedTime = (end - start); // Calculate elapsed time in milliseconds

                    System.out.println("Recursive function called " + rSteps + " times.");
                    System.out.println("Time taken: " + elapsedTime + " milliseconds");
                }
            } else if (choice == 3) {
                System.out.println("Successfully Exited.");
                break;
            } else {
                System.out.println("Invalid choice. Please select a valid option.");
            }
        }

        scanner.close();
    }
}
/*Fibonacci Series Menu:
1. Calculate Iteratively
2. Calculate Recursively
3. Quit
Enter your choice: 1
Enter the number of Fibonacci numbers to generate: 10
Fibonacci Series (Iterative): 0 1 1 2 3 5 8 13 21 34 
Iterative function called 1 times.
Time taken: 0 milliseconds
Fibonacci Series Menu:
1. Calculate Iteratively
2. Calculate Recursively
3. Quit
Enter your choice: 2
Enter the number of Fibonacci numbers to generate: 10
Fibonacci Series (Recursive): 0 1 1 2 3 5 8 13 21 34 
Recursive function called 109 times.
Time taken: 0 milliseconds
Fibonacci Series Menu:
1. Calculate Iteratively
2. Calculate Recursively
3. Quit
Enter your choice: 3
Successfully Exited.
 */