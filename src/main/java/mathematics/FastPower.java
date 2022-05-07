package main.java.mathematics;

public class FastPower {
    /***
     * Naive approach to find power of x^n
     * O(n) solution
     */
    static long powerNaive(int x, int n){
        int res = 1;

        for (int i=0; i<n; i++)
            res = res * x;

        return res;
    }

    /***
     * Driver code
     */
    public static void main(String[] args) {
        int x=2, n=5;
        System.out.println(x+"^"+n+"="+powerNaive(x,n));
    }
}
