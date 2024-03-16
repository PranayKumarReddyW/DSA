import java.util.*;

public class Stacks {

    // static class StackExample {
    // ArrayList<Integer> arr = new ArrayList<>();

    // public void push(int x) {
    // arr.add(x);
    // }

    // public int pop() {
    // if (arr.size() == 0) {
    // return -1;
    // }
    // int res = arr.get(arr.size() - 1);
    // arr.remove(arr.size() - 1);
    // return res;
    // }

    // public boolean isEmpty() {
    // return arr.size() == 0;
    // }

    // public int peek() {
    // if (arr.size() == 0) {
    // return -1;
    // }
    // return arr.get(arr.size() - 1);
    // }
    // }

    public static void main(String[] args) {
        // StackExample s = new StackExample();
        // s.push(10);
        // s.push(20);
        // s.push(30);
        // System.out.println(s.pop());
        // System.out.println(s.peek());
        // System.out.println(s.isEmpty());

        // int nums[] = { 6, 9, 2, 0, 8, 1, 3 };
        // int ans[] = nextGreaterElementsToRight(nums);
        // System.out.println(Arrays.toString(ans));

        // ans = nextGreaterElementsToLeft(nums);
        // System.out.println(Arrays.toString(ans));

        // ans = nextSmallerElementsToRight(nums);
        // System.out.println(Arrays.toString(ans));

        // ans = nextSmallerElementsToLeft(nums);
        // System.out.println(Arrays.toString(ans));

        // System.out.println(isValid("[[[]]]]"));
        int[] arr = { 100, 80, 60, 70, 60, 75, 85 };
        int[] res = calculateSpan(arr, arr.length);
        System.out.println(Arrays.toString(res));

    }

    public static int[] nextGreaterElementsToRight(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[i] >= nums[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty())
                ans[i] = -1;
            else
                ans[i] = nums[st.peek()];
            st.push(i);
        }
        return ans;
    }

    public static int[] nextGreaterElementsToLeft(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i <= n - 1; i++) {
            while (!st.isEmpty() && nums[i] >= nums[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty())
                ans[i] = -1;
            else
                ans[i] = nums[st.peek()];
            st.push(i);
        }
        return ans;
    }

    public static int[] nextSmallerElementsToRight(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[i] <= nums[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty())
                ans[i] = -1;
            else
                ans[i] = nums[st.peek()];
            st.push(i);
        }
        return ans;
    }

    public static int[] nextSmallerElementsToLeft(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i <= n - 1; i++) {
            while (!st.isEmpty() && nums[i] <= nums[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty())
                ans[i] = -1;
            else
                ans[i] = nums[st.peek()];
            st.push(i);
        }
        return ans;
    }

    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char par = s.charAt(i);
            if (par == '[' || par == '{' || par == '(') {
                st.push(par);
            } else {
                if (st.isEmpty())
                    return false;
                else if (par == '}') {
                    if (st.peek() != '{')
                        return false;
                } else if (par == ']') {
                    if (st.peek() != '[')
                        return false;
                } else if (par == ')') {
                    if (st.peek() != '(')
                        return false;
                }
                st.pop();
            }
        }
        return st.isEmpty();
    }

    public static int[] calculateSpan(int price[], int n) {
        // Your code here
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && price[i] >= price[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty()) {
                ans[i] = i + 1;
            } else {
                ans[i] = i - st.peek();
            }
            st.push(i);

        }
        return ans;
    }

}
