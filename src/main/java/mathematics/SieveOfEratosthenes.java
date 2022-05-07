package main.java.mathematics;

import java.util.Arrays;

public class SieveOfEratosthenes {
    /***
     * Returns a boolean array isPrime where index of array represents the number from 0(inclusive) to n(inclusive)
     * Marked True for Prime and False for Non-Prime
     */
    static boolean[] sieveOfEratosthenes(int n){

        // Create a boolean array of size n+1
        boolean[] isPrime = new boolean[n+1];

        //Mark all the indexes as true
        Arrays.fill(isPrime, true);

        //Explicitly mark 0,1 as false
        isPrime[0] = false;
        isPrime[1] = false;

        for(int i=2; i*i<=n; i++)
        {
            if(isPrime[i])
                for(int j=2*i; j<=n; j+=i)
                    isPrime[j]=false;
        }
        return isPrime;
    }

    static boolean[] sieveOfEratosthenesOptimized(int n){

        // Create a boolean array of size n+1
        boolean[] isPrime = new boolean[n+1];

        //Mark all the indexes as true
        Arrays.fill(isPrime, true);

        //Explicitly mark 0,1 as false
        isPrime[0] = false;
        isPrime[1] = false;

        for(int i=2; i*i<=n; i++)
        {
            if(isPrime[i])
                //Optimization here j = i*i since i*(i-1), i*(i-2), ...., i*2 is covered by smaller values of i
                //covered up in previous iterations and their multiples also marked in previous steps
                for(int j=i*i; j<=n; j+=i)
                    isPrime[j]=false;
        }
        return isPrime;
    }

    /***
     * Driver code
     */
    public static void main(String[] args) {
        int n = 20;
        boolean[] isPrime = sieveOfEratosthenes(n);
        boolean[] isPrimeOptimized = sieveOfEratosthenesOptimized(n);
        //Prints output as
        // 2 3 5 7 11 13 17 19
        for(int i=0; i<=n ; i++)
            if (isPrime[i])
                System.out.print(i+" ");

        System.out.print("\n");

        for(int i=0; i<=n ; i++)
            if (isPrimeOptimized[i])
                System.out.print(i+" ");
    }
}
