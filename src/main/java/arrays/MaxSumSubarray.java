package main.java.arrays;

public class MaxSumSubarray {
    /***
     * Naive Approach
     * Time Complexity: O(n^2)
     * Auxiliary Space: O(1)
     * @param arr
     * @return
     */
    static int maxSumSubarrayNaive(int[] arr) {
        int n = arr.length;
        int res = arr[0];
        int curr_val = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                curr_val += arr[j];
                res = Math.max(res, curr_val);
            }
            curr_val = 0;
        }
        return res;
    }

    /***
     * Efficient Approach : Kadane's Algorithm
     * Time Complexity: O(n)
     * Auxiliary Space: O(1)
     * @param arr
     * @return
     */
    static int maxSumSubarrayEfficient(int[] arr) {
        int n = arr.length;
        int res = arr[0];
        int curr_val = arr[0];
        for (int i = 1; i < n; i++) {
            curr_val = Math.max(curr_val + arr[i], arr[i]);
            res = Math.max(curr_val, res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a1 = {2, 3, -8, 7, -1, 2, 3};
        int[] a2 = {5, 8, 3};
        int[] a3 = {-6, -1, -8};
        System.out.println(maxSumSubarrayNaive(a1));
        System.out.println(maxSumSubarrayNaive(a2));
        System.out.println(maxSumSubarrayNaive(a3));
        System.out.println(maxSumSubarrayEfficient(a1));
        System.out.println(maxSumSubarrayEfficient(a2));
        System.out.println(maxSumSubarrayEfficient(a3));
    }
}
