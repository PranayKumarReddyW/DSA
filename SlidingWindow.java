import java.util.*;

public class SlidingWindow {
    public static void main(String[] args) {

        // 1. Maximum sum of subarray of size K
        // ArrayList<Integer> Arr = new ArrayList<>();
        // Arr.addAll(Arrays.asList(1, 4, 2, 10, 2, 3, 1, 0, 20));
        // int K = 4;
        // int N = Arr.size();
        // long maxSum = maximumSumSubarray(K, Arr, N);
        // System.out.println(maxSum);

        // 2 Print negative integer in every window of size K
        // long arr[] = { 12, -1, -7, 8, -15, 30, 16, 28 };
        // int K = 3;
        // int N = arr.length;
        // long ans[] = printFirstNegativeInteger(arr, N, K);
        // System.out.println(Arrays.toString(ans));

        // 3. Count Anagrams
        // String txt = "forxxorfxdofr";
        // String pat = "for";
        // int ans = countAnarams(txt, pat);
        // System.out.println(ans);

        // 4. Longest Distinct characters in string
        // String s = "geeksforgeeks";
        // int ans = longestSubstrDistinctChars(s);
        // System.out.println(ans);

        // 5. Longest subarray with sum K (only psotives)
        // int a[] = { 4, 1, 1, 1, 2, 3, 5 };
        // long k = 5;
        // int ans = longestSubarrayWithSumK(a, k);
        // System.out.println(ans);

    }

    public static long maximumSumSubarray(int K, ArrayList<Integer> Arr, int N) {
        long sum = 0;
        long maxSum = 0;
        int left = 0;
        int right = 0;
        while (right < N) {
            sum += Arr.get(right);
            if (right - left + 1 == K) {
                maxSum = Math.max(sum, maxSum);
                sum -= Arr.get(left);
                left++;
            }
            right++;
        }
        return maxSum;
    }

    public static long[] printFirstNegativeInteger(long A[], int N, int K) {
        Deque<Long> deque = new ArrayDeque<>();
        long[] ans = new long[N - K + 1];
        int i = 0;
        int left = 0;
        int right = 0;
        while (right < N) {
            if (A[right] < 0) {
                deque.offer(A[right]);
            }
            if (right - left + 1 == K) {
                if (deque.isEmpty()) {
                    ans[i++] = 0;
                } else {
                    ans[i++] = deque.peekFirst();
                }
                if (!deque.isEmpty()) {
                    if (deque.peekFirst() == A[left]) {
                        deque.pollFirst();
                    }
                }
                left++;
            }
            right++;
        }
        return ans;
    }

    public static int countAnarams(String txt, String pat) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < pat.length(); i++) {
            map.put(pat.charAt(i), map.getOrDefault(pat.charAt(i), 0) + 1);
        }
        int ans = 0;
        int left = 0;
        int right = 0;
        int count = map.size();
        while (right < txt.length()) {
            char ch = txt.charAt(right);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0) {
                    count--;
                }
            }

            if (right - left + 1 == pat.length()) {
                if (count == 0) {
                    ans++;
                }
                char cha = txt.charAt(left);
                if (map.containsKey(cha)) {
                    map.put(cha, map.get(cha) + 1);
                    if (map.get(cha) == 1) {
                        count++;
                    }
                }

                left++;
            }
            right++;

        }
        return ans;
    }

    public static int longestSubstrDistinctChars(String S) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int left = 0;
        int right = 0;
        int n = S.length();
        while (right < n) {
            char ch = S.charAt(right);
            if (map.containsKey(ch)) {
                left = Math.max(left, map.get(ch) + 1);
            }
            maxLength = Math.max(maxLength, right - left + 1);
            map.put(ch, right);
            right++;

        }
        return maxLength;
    }

    public static int longestSubarrayWithSumK(int[] a, long k) {
        int maxLength = 0;
        int left = 0;
        int right = 0;
        int n = a.length;
        long sum = 0;
        while (right < n) {
            sum += a[right];
            if (sum == k)
                maxLength = Math.max(maxLength, right - left + 1);
            while (sum > k) {
                sum -= a[left];
                left++;
                if (sum == k) {
                    maxLength = Math.max(maxLength, right - left + 1);
                }
            }
            right++;
        }
        return maxLength;
    }
}
