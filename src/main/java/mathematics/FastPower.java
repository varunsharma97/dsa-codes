package main.java.mathematics;

public class FastPower {
    /***
     * Naive approach to find power of x^n
     * O(n) solution
     */
    static long power(int x, int n) {
        int res = 1;

        for (int i = 0; i < n; i++)
            res = res * x;

        return res;
    }

    /***
     * An optimised recursive solution
     * The approach is that every even power n can be represented as x^n = (x^n/2)^2
     * and odd power n can be represented as x^n = x*(x^n/2)^2
     * Time Complexity of this solution is O(log(n))
     * Auxiliary space of this solution is O(log(n))
     */
    static long fastPower(int x, int n) {
        //base case
        if (n == 0) return 1;
        long temp = fastPower(x, n / 2);
        temp *= temp;
        if (n % 2 != 0) temp = x * temp;

        return temp;
    }

    /***
     * An optimised iterative solution also known as binary exponentiation
     * The approach is that any number can be represented in binary form
     * We traverse from LSB to MSB of the power and multiply when bit is set to 1
     * Eg: 5 = 0101 , lets say we need to calculate 4^5, we can represent as
     * 4^5 = 4^3 * 4^1 using values set in binary representation of 5
     * Time Complexity of this approach is O(log(n))
     * Auxiliary Space of this solution is O(1)
     * Hence better than recursive approach
     */
    static long fastPowerOptimized(int x, int n, int M) {
        int res = 1;
        while (n > 0) {
            if ((n & 1) == 1)
                res = (res * x) % M; //when bit is set to 1 i.e n is odd we multiply x to res

            x = (x * x) % M;
            n = n >> 1; // n=n/2 using bitwise right shift operator
        }
        return res;
    }

    /***
     * Driver code
     */
    public static void main(String[] args) {
        int x = 2, n = 5;
        System.out.println(x + "^" + n + "=" + power(x, n));
        System.out.println(x + "^" + n + "=" + fastPower(x, 4));
        System.out.println(x + "^" + n + "=" + fastPowerOptimized(4, 5, 10));
    }
}
