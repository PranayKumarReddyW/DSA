import java.util.ArrayList;

public class Recursion {
    public static void main(String[] args) {
        // printPermutationsString("abcd", "");
        // printPermutationsArraySum(new int[] { 2, 3, 6, 7 }, 0, new ArrayList<>(), 0);
        // printPermutationsArray(new int[] { 1, 2, 3, 4 }, new boolean[4], new
        // ArrayList<Integer>());
    }

    public static void printPermutationsString(String s, String perm) {
        if (s.length() == 0) {
            System.out.println(perm);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            printPermutationsString(s.substring(0, i) + s.substring(i + 1), perm + s.charAt(i));
        }
    }

    public static void printPermutationsArray(int arr[], boolean flag[], ArrayList<Integer> al) {
        if (al.size() == 3) {
            System.out.println(al);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (flag[i] == false) {
                flag[i] = true;
                al.add(arr[i]);

                printPermutationsArray(arr, flag, al);
                flag[i] = false;
                al.remove(al.size() - 1);
            }
        }
    }

    public static void printPermutationsArraySum(int arr[], int i, ArrayList<Integer> al, int sum) {
        if (sum == 7) {
            System.out.println(al);
            return;
        }
        if (i > 3)
            return;
        sum = sum + arr[i];
        if (sum > 7) {
            printPermutationsArraySum(arr, i + 1, al, sum - arr[i]);
        } else {
            al.add(arr[i]);
            printPermutationsArraySum(arr, i, al, sum);
            al.remove(al.size() - 1);
            printPermutationsArraySum(arr, i + 1, al, sum - arr[i]);

        }
    }

}
