package main.java.arrays;

import java.util.Arrays;

public class LeftRotateByD {
    /**
     * Left rotates elements of array by d places
     * We assume d<=n always
     * Naive Approach: Calls left rotate by 1 method d times to rotate by d places
     * Time Complexity: Theta(n*d)
     * Aux Space: Theta(1)
     */
    static int[] leftRotateByDNaive(int[] arr, int d) {
        for (int i = 1; i <= d; i++) arr = LeftRotateByOne.leftRotateByOne(arr);
        return arr;
    }

    /**
     * Efficient approach
     * Time Complexity: Theta(n)
     * Auxiliary Space: Theta(d)
     */
    static int[] leftRotateByDEfficient(int arr[], int d) {
        int[] temp = new int[d];
        for (int i = 0; i < d; i++) temp[i] = arr[i];
        for (int i = d; i < arr.length; i++) arr[i - d] = arr[i];
        for (int i = 0; i < d; i++) arr[arr.length + i - d] = temp[i];

        return arr;
    }

    static int[] leftRotateByDReversalAlgo(int[] arr, int d) {
        int n = arr.length;
        Reverse.reverse(arr, 0, d - 1);
        Reverse.reverse(arr, n - 1 - d, n - 1);
        Reverse.reverse(arr, 0, n - 1);
        return arr;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5};
        int[] output = leftRotateByDNaive(input, 2);
        int[] outputEff = leftRotateByDEfficient(input, 2);
        int[] outputRev = leftRotateByDReversalAlgo(input, 2);
        System.out.println(Arrays.toString(output));
        System.out.println(Arrays.toString(outputEff));
        System.out.println(Arrays.toString(outputRev));

    }
}
