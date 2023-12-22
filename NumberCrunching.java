import java.util.Scanner;

public class NumberCrunching {
    public static void main(String[] args) {
        // reverseNumber();
        // countDigits();
        // happyNumber(68);
    }

    public static void reverseNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = sc.nextInt();
        sc.close();
        int rev = 0;
        while (n > 0) {
            int rem = n % 10;
            rev = rev * 10 + rem;
            n = n / 10;
        }
        System.out.println(rev);
    }

    public static void countDigits() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = sc.nextInt();
        sc.close();
        int count = 0;
        while (n > 0) {
            n = n / 10;
            count++;
        }
        System.out.println(count);
    }

    public static void happyNumber(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = calculate(slow);
            fast = calculate(calculate(fast));
        } while (slow != fast && fast != 1);
        if (fast == 1) {
            System.out.println("Yes Happy Number");
            return;
        }
        System.out.println("Not a Happy Number");

    }

    public static int calculate(int n) {
        int sum = 0;
        while (n != 0) {
            int rem = n % 10;
            sum = sum + (rem * rem);
            n = n / 10;
        }
        return sum;
    }

}
