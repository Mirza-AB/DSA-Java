import java.util.ArrayList;
import java.util.List;

public class Recursion {
    public static void main(String[] args) {
        //pName(5);
        //p1ToN(5);
        //pNto1(5);
        //System.out.println(sumOfN(3));
        //System.out.println(fact(5));
//        int[] arr = {1, 2, 3, 4, 5};
//        reverseArray(arr, 0);
//        for(int i : arr)
//        {
//            System.out.print(i + " ");
//        }
//        System.out.println((pali("12521", 0)));
        //System.out.println(fib(6));



    }

    private static void pName(int n)
    {
        if(n<1)
            return;

        System.out.println("Mirza");
        pName(n-1);
    }

    private static void p1ToN(int n)
    {

        if(n<1)
            return;

        p1ToN(n-1);
        System.out.println(n);
    }

    private static void pNto1(int n)
    {

        if(n<1)
            return;

        System.out.println(n);
        pNto1(n-1);

    }

    private static int sumOfN(int n)
    {
        if(n<1)
            return 0;
        return (n + sumOfN(n-1));
    }

    private static int fact(int n)
    {
        if(n<=1)
            return 1;
        return n * fact(n-1);
    }

    private static void reverseArray(int[] arr, int l)
    {
//        if(l>=r)
//        {
//            return;
//        }
//        int temp;
//        temp = arr[l];
//        arr[l] = arr[r];
//        arr[r] = temp;
//        reverseArray(arr, l+1, r-1);
        int n = arr.length;

        if(l>=n/2)
        {
            return;
        }

        int temp = arr[l];
        arr[l] = arr[n-1-l];
        arr[n-1-l] = temp;

        reverseArray(arr, l+1);

    }

    private static boolean pali(String s, int l)
    {

        int r = s.length();

        if(l>=r/2)
            return true;

        if(s.charAt(l) != s.charAt(r-1-l))
            return false;

        return pali(s, l+1);

    }

    private static int fib(int n)
    {

        if(n ==1)
        {
           return 0;
        }
        if(n==2)
        {
            return 1;
        }
        return fib(n-1) + fib(n-2);

    }

}
