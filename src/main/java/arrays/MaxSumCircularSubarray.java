package main.java.arrays;

public class MaxSumCircularSubarray {
    private static int maxSumNaive(int[] arr) {
        int n = arr.length;
        int res = arr[0];
        int current;
        int index;

        for (int i = 0; i < n; i++) {
            current = 0;
            for (int j = 0; j < n; j++) {
                index = (i + j) % n;
                current = current + arr[index];
                res = Math.max(current, res);
            }
        }
        return res;
    }

    private static int maxSumNormalArray(int[] arr) {
        int n = arr.length;
        int res = arr[0];
        int current = 0;
        for (int i = 0; i < n; i++) {
            current = Math.max(current + arr[i], arr[i]);
            res = Math.max(res, current);
        }
        return res;
    }

    private static int maxSumEfficient(int[] arr) {
        int maxNormalSum = maxSumNormalArray(arr);
        if (maxNormalSum < 0) return maxNormalSum;
        int maxCircularSum;
        int minCircularSum;
        int arraySum = 0;
        for (int i = 0; i < arr.length; i++) {
            arraySum += arr[i];
            arr[i] = -arr[i];
        }
        minCircularSum = maxSumNormalArray(arr);
        maxCircularSum = arraySum + minCircularSum;
        return Math.max(maxCircularSum, maxNormalSum);
    }

    public static void main(String[] args) {
        int[] a1 = {5, -6, 8, 9, -10};
        int[] a2 = {5, -2, 3, 4};
        int[] a3 = {2, 3, -4};
        int[] a4 = {8, -4, 3, -5, 4};
        int[] a5 = {-3, 4, 6, -2};
        int[] a6 = {-8, 7, 6};
        int[] a7 = {3, -4, 5, 6, -8, 7};
        System.out.println(maxSumNaive(a1));
        System.out.println(maxSumNaive(a2));
        System.out.println(maxSumNaive(a3));
        System.out.println(maxSumNaive(a4));
        System.out.println(maxSumNaive(a5));
        System.out.println(maxSumNaive(a6));
        System.out.println(maxSumNaive(a7));

        System.out.println(maxSumEfficient(a1));
        System.out.println(maxSumEfficient(a2));
        System.out.println(maxSumEfficient(a3));
        System.out.println(maxSumEfficient(a4));
        System.out.println(maxSumEfficient(a5));
        System.out.println(maxSumEfficient(a6));
        System.out.println(maxSumEfficient(a7));
    }
}
