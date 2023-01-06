package main.java.search;

public class LinearSearch {
    public static int linearSearch(int[] a, int x) {
        int size = a.length;
        for (int i = 0; i < size; i++) if (a[i] == x) return i;
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 55, 70, 4, 32};
        System.out.println(linearSearch(arr, 4));
        System.out.println(linearSearch(arr, 20));
        System.out.println(linearSearch(arr, 70));
        System.out.println(linearSearch(arr, 65));
    }
}
