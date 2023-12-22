public class Sorting {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 5, 6, 11, 3 };
        // bubbleSort(arr);
        // selectionSort(arr);
        insertionSort(arr);
    }

    public static void bubbleSort(int arr[]) {
        System.out.print("Unsorted array: ");
        printArray(arr);
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.print("Sorted array: ");
        printArray(arr);
    }

    public static void selectionSort(int arr[]) {
        System.out.println("Unsorted array: ");
        printArray(arr);
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int minPos = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[minPos] > arr[j]) {
                    minPos = j;
                }
            }
            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;
        }
        System.out.print("Sorted array: ");
        printArray(arr);
    }

    public static void insertionSort(int arr[]) {
        System.out.println("Unsorted array: ");
        printArray(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            int j = i + 1;
            while (arr[j] < arr[j - 1] && j > 0) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }
        }
        System.out.println("Sorted Array: ");
        printArray(arr);
    }

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
