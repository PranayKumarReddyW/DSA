import java.util.HashMap;
import java.util.Scanner;

public class ArrayQuestions {
    public static void main(String[] args) {
        // reverseArray();
        // rotateArrayRightByK();
        // rotateRightOptimal();
        // rotateArrayLeftByK();
        // rotatetLeftOptimal();
        // secondMinMax();
        // missingNumber();
        // uniqueElement();
        // dutchNationalAlgorithm();
        // kadanesAlgorithm();
        // indexOfMaximumSumOfSubarray();
        // twoSumOptimal();
        // twoSumBrute();
    }

    public static void reverseArray() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter array values: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        System.out.print("Initial array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        // Reversing the array
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            // Swapping the elements
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            // Incrementing start and decrementing end
            start++;
            end--;
        }
        System.out.print("\nReversed array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // brute force approach
    public static void rotateArrayRightByK() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter array values: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the value of k: ");
        int k = sc.nextInt();
        k = k % n;
        sc.close();
        System.out.print("Initial array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        for (int i = 1; i <= k; i++) {
            int temp = arr[arr.length - 1];
            for (int j = n - 1; j >= 1; j--) {
                arr[j] = arr[j - 1];
            }
            arr[0] = temp;
        }
        System.out.print("\nRotated array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // optimal approach
    public static void rotateRightOptimal() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter array values: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the value of k: ");
        int k = sc.nextInt();
        k = k % n;
        sc.close();
        System.out.print("Initial array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        reverse(arr, 0, arr.length - k - 1);
        reverse(arr, k + 1, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
        System.out.print("\nRotated array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void reverse(int[] arr, int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // brute force approach
    public static void rotateArrayLeftByK() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter array values: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the value of k: ");
        int k = sc.nextInt();
        k = k % n;
        sc.close();
        System.out.print("Initial array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        for (int i = 1; i <= k; i++) {
            int temp = arr[0];
            for (int j = 0; j <= n - 2; j++) {
                arr[j] = arr[j + 1];
            }
            arr[arr.length - 1] = temp;
        }
        System.out.print("\nRotated array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // optimal approach

    public static void rotatetLeftOptimal() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter array values: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the value of k: ");
        int k = sc.nextInt();
        k = k % n;
        sc.close();
        System.out.print("Initial array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        reverse(arr, 0, k - 1);
        reverse(arr, k, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
        System.out.print("\nRotated array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void secondMinMax() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter array values: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        int maximum = Integer.MIN_VALUE;
        int secondMaximum = Integer.MIN_VALUE;
        int minimum = Integer.MAX_VALUE;
        int secondMinimum = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maximum) {
                secondMaximum = maximum;
                maximum = arr[i];
            } else if (arr[i] != maximum && arr[i] > secondMaximum) {
                secondMaximum = arr[i];
            }
            if (arr[i] < minimum) {
                secondMinimum = minimum;
                minimum = arr[i];
            } else if (arr[i] != minimum && arr[i] < secondMinimum) {
                secondMinimum = arr[i];
            }
        }
        System.out.println("First maximum: " + maximum);
        System.out.println("First minimum: " + minimum);
        System.out.println("Second minimum: " + secondMaximum);
        System.out.println("Second minimum: " + secondMinimum);

    }

    public static int missingNumber() {

        // Given an array nums containing n distinct numbers in the range [0, n], return
        // the only number in the range that is missing from the array.

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter array values: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        int missingVal = n;
        for (int i = 0; i < arr.length; i++) {
            missingVal ^= i ^ arr[i];
        }
        return missingVal;
    }

    public static int uniqueElement() {
        // Problem:
        // Given an array of integers nums representing a sequence, where each element
        // appears twice except for one element which appears only once, find and return
        // the unique element.
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter array values: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        int unique = 0;
        for (int i = 0; i < arr.length; i++) {
            unique ^= arr[i];
        }
        return unique;
    }

    public static void dutchNationalAlgorithm() {
        // Given an array containing only 0s, 1s, and 2s, implement the Dutch National
        // Flag algorithm to sort the array in-place. Write a function sortColors that
        // takes an integer array as input and modifies the array such that all 0s are
        // grouped at the beginning, followed by all 1s, and finally, all 2s at the end.
        // The function should run in O(n) time complexity.
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n = sc.nextInt();
        System.out.println("Enter array values: ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        int low = 0;
        int mid = 0;
        int high = n - 1;
        while (mid <= high) {
            if (arr[mid] == 1) {
                mid++;
            } else if (arr[mid] == 0) {
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                mid++;
                low++;
            } else {
                int temp = arr[high];
                arr[low] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
    }

    public static void kadanesAlgorithm() {
        int maxSum = 0;
        int currentSum = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter array values: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            if (currentSum < 0) {
                currentSum = 0;
            }
            maxSum = Math.max(currentSum, maxSum);
        }
        System.out.println(maxSum);
    }

    public static void indexOfMaximumSumOfSubarray() {
        int maxSum = 0;
        int currentSum = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter array values: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        int startIndex = 0;
        int endIndex = 0;
        int tempIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            if (currentSum < 0) {
                currentSum = 0;
                tempIndex = i;
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
                startIndex = tempIndex;
                endIndex = i;
            }
        }
        System.out.println("Start index: " + startIndex);
        System.out.println("End index: " + endIndex);
        System.out.println(maxSum);
    }

    public static void twoSumBrute() { // ==> Space complexity: O(1) and Time complexity: O(n^2)
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter array values: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter target value: ");
        int target = sc.nextInt();
        sc.close();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == target) {
                    System.out.println(i + " " + j);
                    return;
                }
            }
        }
    }

    // optimal
    public static void twoSumOptimal() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter array values: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter target value: ");
        int target = sc.nextInt();
        sc.close();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(target - arr[i])) {
                System.out.println(i + " " + map.get(target - arr[i]));
            } else {
                map.put(arr[i], i);
            }
        }
    }
}
