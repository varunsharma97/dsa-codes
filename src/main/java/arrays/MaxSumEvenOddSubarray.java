package main.java.arrays;

public class MaxSumEvenOddSubarray {
    /**
     * Naive Solution
     * Time Complexity: O(n^2)
     * Auxiliary Space: O(1)
     *
     * @param arr
     * @return
     */
    private static int maxSumNaive(int[] arr) {
        int n = arr.length;
        int res = 1;
        int count;
        for (int i = 0; i < n - 1; i++) {
            count = 1;
            for (int j = i; j < n - 1; j++) {
                if ((arr[j] % 2 == 0 && arr[j + 1] % 2 == 1) || (arr[j] % 2 == 1 && arr[j + 1] % 2 == 0))
                    res = Math.max(++count, res);
                else break;
            }
        }
        return res;
    }

    /**
     * Efficient Solution
     * Time Complexity: O(n)
     * Auxiliary Space: O(1)
     *
     * @param arr
     * @return
     */
    private static int maxSumEfficient(int[] arr) {
        int n = arr.length;
        int res = 1;
        int count = 1;
        for (int j = 0; j < n - 1; j++) {
            if ((arr[j] % 2 == 0 && arr[j + 1] % 2 == 1) || (arr[j] % 2 == 1 && arr[j + 1] % 2 == 0))
                res = Math.max(++count, res);
            else {
                count = 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a1 = {10, 12, 14, 7, 8};
        int[] a2 = {7, 10, 13, 4};
        int[] a3 = {10, 12, 8, 4};
        int[] a4 = {10, 12, 7, 6, 4, 1, 2, 3, 6};
        System.out.println(maxSumNaive(a1));
        System.out.println(maxSumNaive(a2));
        System.out.println(maxSumNaive(a3));
        System.out.println(maxSumNaive(a4));
        System.out.println(maxSumEfficient(a1));
        System.out.println(maxSumEfficient(a2));
        System.out.println(maxSumEfficient(a3));
        System.out.println(maxSumEfficient(a4));
    }
}
