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
        // int[] arr = { 100, 80, 60, 70, 60, 75, 85 };
        // int[] res = calculateSpan(arr, arr.length);
        // System.out.println(Arrays.toString(res));

        // String exp = "a+b*(c^d-e)^(f+g*h)-i";
        // System.out.println(infixToPostfix(exp));

        // String exp = "A*B+C/D";
        // System.out.println(infixToPrefix(exp));

        // System.out.println(preToInfix("*+AB-CD"));

        // System.out.println(postToInfix("AB+CD-*"));

        System.out.println();
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

    public static String infixToPostfix(String exp) {
        String postfix = "";
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                postfix += c;
            } else {
                if (c == '(') {
                    st.push(c);
                } else if (c == ')') {
                    while (!st.isEmpty() && st.peek() != '(') {
                        postfix += st.pop();
                    }
                    st.pop();
                } else {
                    while (!st.isEmpty() && infixToPostfixHelper(c) <= infixToPostfixHelper(st.peek())) {
                        postfix += st.pop();
                    }
                    st.push(c);

                }
            }
        }
        while (!st.isEmpty())
            postfix += st.pop();
        return postfix;
    }

    public static int infixToPostfixHelper(char c) {
        if (c == '+' || c == '-') {
            return 1;
        } else if (c == '*' || c == '/') {
            return 2;
        } else if (c == '^') {
            return 3;
        } else {
            return -1;
        }
    }

    public static String infixToPrefix(String s) {
        Stack<Character> st = new Stack<>();
        String res = "";
        s = new StringBuilder(s).reverse().toString();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                res += c;
            } else {
                if (c == ')') {
                    st.push(')');
                } else if (c == '(') {
                    while (!st.isEmpty() && st.peek() != ')') {
                        res += st.pop();
                    }
                    st.pop();
                } else {
                    while (!st.isEmpty() && infixToPostfixHelper(c) <= infixToPostfixHelper(st.peek())) {
                        res += st.pop();
                    }
                    st.push(c);
                }
            }

        }
        while (!st.isEmpty()) {
            res += st.pop();

        }
        return new StringBuilder(res).reverse().toString();
    }

    public static String preToInfix(String pre_exp) {
        Stack<String> st = new Stack<>();
        pre_exp = new StringBuilder(pre_exp).reverse().toString();
        for (int i = 0; i < pre_exp.length(); i++) {
            char c = pre_exp.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                st.push(c + "");
            } else {
                String op1 = st.pop();
                String op2 = st.pop();
                st.push("(" + op1 + c + op2 + ")");
            }
        }
        return st.pop();
    }

    public static String postToInfix(String exp) {
        Stack<String> st = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                st.push(c + "");
            } else {
                String op2 = st.pop();
                String op1 = st.pop();
                st.push("(" + op1 + c + op2 + ")");
            }
        }
        return st.pop();
    }

    public static int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int nSR[] = new int[n]; // next smaller to right
        int nSL[] = new int[n]; // next smaller to left
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty()) {
                nSL[i] = -1;
            } else {
                nSL[i] = st.peek();
            }
            st.push(i);
        }
        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty()) {
                nSR[i] = n;
            } else {
                nSR[i] = st.peek();
            }
            st.push(i);
        }

        for (int i = 0; i < n; i++) {
            int area = heights[i] * (nSR[i] - nSL[i] - 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

}
