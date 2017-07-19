package com.tobiastrabant.calc;

/**
 * Created by Tobias on 10.06.2017.
 */
public class Series {

    public static int nSum(int n){
        int sum = 0;
        for(int i = 0; i <= n; i++){
            sum += i;
        }
        return sum;
    }

    public static int factorial(int n){
        int result = 1;
        for(int i = 1; i <= n; i++){
            result *= i;
        }
        return result;
    }

    public static int fibonacci(int n){
        if(n == 0){
            return 0;
        }else if(n == 1){
            return 1;
        }
        int nMinus1=1;
        int nMinus2=0;
        int fib=0;
        for(int i = 1; i < n; i++){
            fib = (nMinus1 + nMinus2);
            nMinus2 = nMinus1;
            nMinus1 = fib;
        }
        return fib;
    }
}
