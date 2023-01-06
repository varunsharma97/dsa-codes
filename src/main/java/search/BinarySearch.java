package main.java.search;

public class BinarySearch {
    public static int binarySearchIterative(int[] array, int element) {
        int low = 0;
        int high = array.length - 1;
        int mid = (low + high) / 2;
        while (low <= high) {
            if (element == array[mid]) return mid;
            else if (element < array[mid]) high = mid - 1;
            else low = mid + 1;
            mid = (low + high) / 2;
        }
        return -1;
    }

    public static int binarySearchRecursive(int[] array, int element, int low, int high) {
        if (low > high) return -1;
        int mid = (low + high) / 2;
        if (element == array[mid]) return mid;
        else if (element > array[mid]) return binarySearchRecursive(array, element, mid + 1, high);
        else return binarySearchRecursive(array, element, low, mid - 1);
    }

    public static void main(String[] args) {
        //Ascending Sorted Array must be input for Binary Search
        int[] arr = {10, 20, 30, 40, 50, 60};
        System.out.println(binarySearchIterative(arr, 30));
        System.out.println(binarySearchIterative(arr, 60));

        System.out.println(binarySearchRecursive(arr, 30, 0, arr.length - 1));
        System.out.println(binarySearchRecursive(arr, 60, 0, arr.length - 1));
    }
}
