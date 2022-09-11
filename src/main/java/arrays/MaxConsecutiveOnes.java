package main.java.arrays;

public class MaxConsecutiveOnes {
    /**
     * Naive Approach
     * Returns maximum count of consecutive 1's in a binary array with
     * only 0 and 1 as values.
     * Time Complexity: Theta(n^2)
     * Auxiliary Space: Theta(1)
     */
    static int maxConsecutiveOnesInBinaryArrayNaive(int[] arr) {
        int n = arr.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            if (arr[i] == 1) {
                ++count;
                for (int j = i + 1; j < n; j++) {
                    if (arr[j] == 1) {
                        ++count;
                    } else {
                        break;
                    }
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }

    /**
     * Efficient Approach
     * Returns maximum count of consecutive 1's in a binary array with
     * only 0 and 1's as values
     * Time Complexity : Theta(n)
     * Auxiliary Space:  Theta(1)
     */
    static int maxConsecutiveOnesInBinaryArrayEfficient(int[] arr) {
        int n = arr.length;
        int res = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) ++count;
            else {
                res = Math.max(res, count);
                count = 0;
            }
        }
        res = Math.max(res, count);
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0};
        System.out.println(maxConsecutiveOnesInBinaryArrayNaive(arr));
        System.out.println(maxConsecutiveOnesInBinaryArrayEfficient(arr));
    }
}
