import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Main {
    static class Item {
        int profit;
        int weight;

        public Item(int profit, int weight) {
            this.profit = profit;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Number of Objects: ");
        int n = scanner.nextInt();

        System.out.println("Enter Profit and Weight (P W):");
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            int profit = scanner.nextInt();
            int weight = scanner.nextInt();
            items[i] = new Item(profit, weight);
        }

        System.out.print("Enter the Capacity: ");
        int w = scanner.nextInt();

        long startTime = System.nanoTime();

        Arrays.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item item1, Item item2) {
                double v1 = (double) item1.profit / item1.weight;
                double v2 = (double) item2.profit / item2.weight;
                return Double.compare(v2, v1);
            }
        });

        double ans = 0;
        double[] solution = new double[n];

        for (int i = 0; i < n; i++) {
            if (w >= items[i].weight) {
                ans += items[i].profit;
                w -= items[i].weight;
                solution[i] = 1.0;
            } else {
                double vw = (double) items[i].profit / items[i].weight;
                ans += vw * w;
                solution[i] = (double) w / items[i].weight;
                w = 0;
                break;
            }
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000_000; // Convert to milliseconds

        System.out.printf("Optimal Solution Vector: (%s)\n", Arrays.toString(solution));
        System.out.printf("Optimal Value: %.2f\n", ans);
        System.out.printf("Execution Time: %d milliseconds\n", duration);
    }
}
