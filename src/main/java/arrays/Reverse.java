package main.java.arrays;

import java.util.Arrays;

public class Reverse {
    static int[] reverse(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            swap(arr, low, high);
            low++;
            high--;
        }
        return arr;
    }

    static int[] reverse(int[] arr, int low, int high) {
        while (low < high) {
            swap(arr, low, high);
            low++;
            high--;
        }
        return arr;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(reverse(input)));
    }
}
