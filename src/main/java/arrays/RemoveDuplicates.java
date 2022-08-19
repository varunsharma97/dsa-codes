package main.java.arrays;

public class RemoveDuplicates {

    /**
     * Removes duplicates from an array and returns number of unique elements
     * Naive Approach
     * Time Complexity: O(n)
     * Auxiliary space: O(n)
     */
    static int removeDuplicates(int arr[]) {
        int n = arr.length;
        int temp[] = new int[n]; // creating an extra array for duplicate remove operation
        temp[0] = arr[0]; //first element will always be unique
        int res = 1; //maintains index where we will place latest unique element

        for (int i = 1; i < n; i++) {

            if (temp[res - 1] != arr[i]) // checks if last unique element doesn't match current index element
            {
                temp[res] = arr[i];
                ++res;
            }
        }

        for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
            System.out.print(arr[i] + " ");
        }

        return res;
    }

    /**
     * Removes duplicates from an array and returns number of unique elements
     * Efficient Approach
     * Time Complexity: O(n)
     * Auxiliary space: O(1)
     */
    static int removeDuplicatesEfficient(int arr[]) {
        int n = arr.length;
        int res = 1; //Since first element of array will always be unique, latest unique element should be placed at index 1.

        for (int i = 1; i < n; i++)
            if (arr[res - 1] != arr[i]) {
                arr[res] = arr[i];
                ++res;
            }
        for (int i = 0; i < n; i++) System.out.print(arr[i] + " ");

        return res;
    }

    public static void main(String[] args) {
        int unique = removeDuplicates(new int[]{10, 20, 20, 30, 30, 30, 30});
        System.out.println(unique);

        int uniqueEff = removeDuplicatesEfficient(new int[]{10, 20, 20, 30, 30, 30, 30});
        System.out.println(uniqueEff);
    }
}
