import java.util.*;

public class Greedy {
    static class Job {
        int id, profit, deadline;

        Job(int x, int y, int z) {
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }

    static class Item {
        int value, weight;

        Item(int x, int y) {
            this.value = x;
            this.weight = y;
        }
    }

    public static void main(String[] args) {

        // Activity Selection
        // System.out.println(activitySelection(new int[] { 1, 3, 0, 5, 8, 5 }, new
        // int[] { 2, 4, 6, 7, 9, 9 }, 6));

        // Minimum Cost of cutting a board
        // int M = 6;
        // int N = 4;
        // int X[] = { 2, 1, 3, 1, 4 };
        // int Y[] = { 4, 1, 2 };
        // System.out.println(minimumCostOfBreaking(X, Y, M, N));

        // Job Sequencing
        // Job arr[] = { new Job(1, 4, 20), new Job(2, 1, 10), new Job(3, 1, 40), new
        // Job(4, 1, 30) };
        // int n = arr.length;
        // int[] res = JobScheduling(arr, n);
        // System.out.println(res[0] + " " + res[1])

        // Fractional Knapsack;

        // Item arr[] = { new Item(60, 10), new Item(100, 20), new Item(120, 30) };
        // int n = arr.length;
        // int W = 50;
        // System.out.println(fractionalKnapsack(W, arr, n));

        // Minimum number of coins
        // System.out.println(minPartition(93));
    }

    public static int activitySelection(int start[], int end[], int n) {
        int count = 1;
        int combined[][] = new int[start.length][2];
        for (int i = 0; i < combined.length; i++) {
            combined[i][0] = start[i];
            combined[i][1] = end[i];
        }
        Arrays.sort(combined, Comparator.comparingDouble(o -> o[1]));
        int activity = combined[0][1];
        for (int i = 1; i < combined.length; i++) {
            if (combined[i][0] > activity) {
                count++;
                activity = combined[i][1];
            }
        }
        return count;
    }

    public static int minimumCostOfBreaking(int[] X, int[] Y, int M, int N) {
        Arrays.sort(X);
        Arrays.sort(Y);
        int minCost = 0;
        int horizontalPieces = 1;
        int verticalPieces = 1;
        int xPointer = X.length - 1;
        int yPointer = Y.length - 1;
        while (xPointer >= 0 && yPointer >= 0) {
            if (X[xPointer] > Y[yPointer]) {
                minCost += X[xPointer] * verticalPieces;
                horizontalPieces++;
                xPointer--;
            } else {
                minCost += Y[yPointer] * horizontalPieces;
                verticalPieces++;
                yPointer--;
            }
        }
        while (xPointer >= 0) {
            minCost += X[xPointer] * verticalPieces;
            horizontalPieces++;
            xPointer--;
        }
        while (yPointer >= 0) {
            minCost += Y[yPointer] * horizontalPieces;
            verticalPieces++;
            yPointer--;
        }
        return minCost;
    }

    public static int[] JobScheduling(Job arr[], int n) {
        int maxDeadLine = 0;
        int combined[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            combined[i][0] = arr[i].profit;
            combined[i][1] = arr[i].deadline;
            if (maxDeadLine < arr[i].deadline) {
                maxDeadLine = arr[i].deadline;
            }
        }
        int scheduled[] = new int[maxDeadLine + 1];
        Arrays.sort(combined, Comparator.comparingDouble(o -> o[0]));
        int jobs = 0;
        int profit = 0;
        for (int i = n - 1; i >= 0; i--) {
            int ind = combined[i][1];
            if (scheduled[ind] == 0) {
                profit += combined[i][0];
                jobs++;
                scheduled[ind] = -1;
            } else {
                while (ind > 0) {
                    if (scheduled[ind] == 0) {
                        profit += combined[i][0];
                        jobs++;
                        scheduled[ind] = -1;
                        break;
                    }
                    ind--;
                }
            }
        }
        return new int[] { jobs, profit };
    }

    public static double fractionalKnapsack(int W, Item arr[], int n) {
        double profit = 0;
        double[][] combined = new double[n][2];
        for (int i = 0; i < combined.length; i++) {
            combined[i][0] = arr[i].value;
            combined[i][1] = arr[i].weight;
        }
        Arrays.sort(combined, Comparator.comparingDouble(o -> o[0] / o[1]));
        for (int i = n - 1; i >= 0; i--) {
            if (W >= combined[i][1]) {
                W -= combined[i][1];
                profit += combined[i][0];
            } else {
                profit += (combined[i][0] / combined[i][1]) * W;
                break;
            }

        }
        return profit;
    }

    public static List<Integer> minPartition(int N) {
        int[] coins = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };
        List<Integer> res = new ArrayList<>();
        int pointer = coins.length - 1;
        while (N > 0) {
            while (N >= coins[pointer]) {
                res.add(coins[pointer]);
                N -= coins[pointer];
            }
            pointer--;

        }
        return res;
    }

}