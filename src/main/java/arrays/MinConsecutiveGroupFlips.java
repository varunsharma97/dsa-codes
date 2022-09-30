package main.java.arrays;

public class MinConsecutiveGroupFlips {
    /**
     * Finds minimum number of group flips to convert a binary array elements to all 1's or 0's
     * Naive Approach: Takes 2 traversals to solve
     * Time Complexity: O(n)
     * Auxiliary space: O(1)
     *
     * @param arr an array with binary input elements
     */
    static void minFlipsNaive(int[] arr) {
        int n = arr.length;
        int count1 = 0;
        int count0 = 0;
         /*
         finding minimum flips group
         */
        if (arr[0] == 0) count0++;
        else count1++;

        for (int i = 1; i < n; i++)
            if (arr[i] != arr[i - 1]) {
                if (arr[i] == 0) count0++;
                else count1++;
            }

        /*
        printing minimum flips group
         */

        for (int i = 0; i < n; i++) {
            if (count0 < count1) {
                if (arr[i] == 0 && (i == 0 || (arr[i - 1] != arr[i]))) {
                    System.out.println("From " + i);
                } else if (i != 0 && arr[i - 1] != arr[i]) {
                    System.out.println("To " + (i - 1));
                }
            } else {
                if (arr[i] == 1 && (i == 0 || (arr[i - 1] != arr[i]))) {
                    System.out.println("From " + i);
                } else if (i != 0 && arr[i - 1] != arr[i]) {
                    System.out.println("To " + (i - 1));
                }
            }
        }
    }

    /***
     * Finds minimum number of group flips to convert a binary array elements to all 1's or 0's
     * Efficient Approach: Takes just 1 traversal to solve
     * Time Complexity: O(n)
     * Auxiliary space: O(1)
     * @param arr an array with binary input elements
     */
    static void minFlipsEfficient(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++)
            if (arr[i] != arr[i - 1]) {
                if (arr[i] != arr[0]) System.out.println("From " + i);
                else System.out.println("To " + (i - 1));
            }
        if (arr[n - 1] != arr[0]) System.out.println("To " + (n - 1));
    }

    public static void main(String[] args) {
        int[] a1 = {1, 1, 0, 0, 0, 1};
        int[] a2 = {1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1};
        int[] a3 = {1, 1, 0, 0, 1, 0};
        minFlipsNaive(a1);
        minFlipsNaive(a2);
        minFlipsNaive(a3);

        minFlipsEfficient(a1);
        minFlipsEfficient(a2);
        minFlipsEfficient(a3);
    }
}
