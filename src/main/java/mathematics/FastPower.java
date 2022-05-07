package main.java.mathematics;

public class FastPower {
    /***
     * Naive approach to find power of x^n
     * O(n) solution
     */
    static long power(int x, int n){
        int res = 1;

        for (int i=0; i<n; i++)
            res = res * x;

        return res;
    }

    /***
     * An optimised recursive solution
     * The approach is that every even power n can be represented as x^n = (x^n/2)^2
     * and odd power n can be represented as x^n = x*(x^n/2)^2
     * Time Complexity of this solution is O(log(n))
     */
    static long fastPower(int x, int n){
        //base case
        if(n==0) return 1;
        long temp = fastPower(x, n/2);
        temp *= temp;
        if(n%2!=0) temp = x*temp;

        return temp;
    }

    /***
     * Driver code
     */
    public static void main(String[] args) {
        int x=2, n=5;
        System.out.println(x+"^"+n+"="+ power(x,n));
        System.out.println(x+"^"+n+"="+fastPower(x,4));
    }
}
