package main.java.arrays;

import java.util.Arrays;

public class LeftRotateByOne {

    /**
     * Rotates an array to left (anti-clockwise) by one position
     * Time Complexity: Theta(n)
     * Auxiliary Space: Theta(1)
     */
    static int[] leftRotateByOne(int[] arr) {
        int temp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        arr[arr.length - 1] = temp;

        return arr;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5};
        int[] output = leftRotateByOne(input);
        System.out.println(Arrays.toString(output));
    }
}
