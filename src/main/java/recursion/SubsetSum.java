package main.java.recursion;

public class SubsetSum {
    static int subSetSum(int[] set, int sum, int index) {
        if (index == set.length) return sum == 0 ? 1 : 0;
        return subSetSum(set, sum, index + 1) + subSetSum(set, sum - set[index], index + 1);
    }

    //Driver code
    public static void main(String[] args) {
        int[] set = {10, 5, 2, 3, 6};
        int sum = 8;
        System.out.println(subSetSum(set, sum, 0));
    }
}
