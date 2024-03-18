public class RecursionBasics {
    public static void main(String[] args) {
        // printStartToEnd(1, 5);
        // printEndToStart(5, 1);
        // sumOfFirstN(10, 0);
        // System.out.println(factorial(5));
        // removeDuplicates("abbcddefggh", 0, "");
        // removeDuplicatesNonSorted("aabcaefghigh", 0, "");
        // System.out.println(fib(6));
        // printSubsequences("abcd", 0, "");
    }

    public static void printEndToStart(int start, int end) {
        if (start < end)
            return;
        System.out.println(start--);
        printEndToStart(start, end);
    }

    public static int factorial(int n) {
        if (n <= 0)
            return 1;
        return n * factorial(n - 1);
    }

    public static void sumOfFirstN(int n, int sum) {
        if (n == 0) {
            System.out.println(sum);
            return;
        }
        sumOfFirstN(n - 1, sum + n);
    }

    public static void printSubsequences(String s, int i, String newStr) {
        if (i == s.length()) {
            System.out.println(newStr);
            return;
        }
        printSubsequences(s, i + 1, newStr + s.charAt(i));
        printSubsequences(s, i + 1, newStr);
    }

    public static boolean[] map = new boolean[26];

    public static void removeDuplicatesNonSorted(String s, int i, String newStr) {
        if (i == s.length()) {
            System.out.println(newStr);
            return;
        }
        if (map[s.charAt(i) - 97] == false) {
            map[s.charAt(i) - 97] = true;
            removeDuplicatesNonSorted(s, i + 1, newStr + s.charAt(i));
        } else {
            removeDuplicatesNonSorted(s, i + 1, newStr);
        }
    }

    public static void printStartToEnd(int start, int end) {
        if (start > end)
            return;
        System.out.println(start++);
        printStartToEnd(start, end);
    }

    public static void removeDuplicates(String s, int i, String newStr) {
        if (i == s.length()) {
            System.out.println(newStr);
            return;
        }
        if (i == 0) {
            removeDuplicates(s, i + 1, newStr + s.charAt(i));
        } else if (s.charAt(i) != s.charAt(i - 1)) {
            removeDuplicates(s, i + 1, newStr + s.charAt(i));
        } else {
            removeDuplicates(s, i + 1, newStr);
        }
    }

    public static int fib(int n) {
        if (n <= 1)
            return n;
        return fib(n - 1) + fib(n - 2);
    }

    public static void permutations(String s, int i, String newString) {
        if (i == s.length()) {
            System.out.println(newString);
            return;
        }
        permutations(s, i, newString);
    }
}
