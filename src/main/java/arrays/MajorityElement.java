package main.java.arrays;

public class MajorityElement {

    /**
     * Majority element is an element in an array whose
     * frequency/occurrence is more than half the number of elements in an array
     * Naive Approach
     * Time Complexity: O(n^2)
     * Auxiliary Space: O(1)
     *
     * @param arr for which we want to find majority element
     * @return any index of majority element
     */
    static int majorityElementNaive(int[] arr) {
        int n = arr.length;
        int res = -1;
        int count;
        for (int i = 0; i < n; i++) {
            count = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j])
                    count++;
            }
            if (count > n / 2) {
                res = i;
                break;
            }
        }
        return res;
    }

    /**
     * Finds Majority element in an array based on Moore's voting algorithm
     * Efficient Approach
     * Time Complexity: O(n)
     * Auxiliary Space: O(1)
     *
     * @param arr for which we want to find majority candidate
     * @return index of majority candidate
     */
    static int majorityElementEfficient(int[] arr) {
        int n = arr.length;
        /*
        Finding a candidate for majority
        */
        int res = 0; // let's consider first element as candidate
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (arr[res] == arr[i]) count++;
            else count--;
            if (count == 0) {
                res = i;
                count = 1;
            }
        }
        /*
        Checking if candidate proves majority
        */
        count = 0;
        for (int i = 0; i < n; i++) if (arr[res] == arr[i]) ++count;
        if (count <= n / 2) return -1;
        return res;
    }

    public static void main(String[] args) {
        int[] a1 = {8, 3, 4, 8, 8};
        int[] a2 = {3, 7, 4, 7, 7, 5};
        int[] a3 = {20, 30, 40, 50, 50, 50, 50};
        System.out.println(majorityElementNaive(a1)); // 0 or 3 or 4
        System.out.println(majorityElementNaive(a2)); // -1
        System.out.println(majorityElementNaive(a3)); // 3 or 4 or 5 or 6

        System.out.println(majorityElementEfficient(a1)); // 0 or 3 or 4
        System.out.println(majorityElementEfficient(a2)); // -1
        System.out.println(majorityElementEfficient(a3)); // 3 or 4 or 5 or 6
    }
}
