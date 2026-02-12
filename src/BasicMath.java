import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BasicMath {
    public static void main(String[] args)
    {
        //extractAllDig(7829);
        //reverseNum(1980);
        //palindromeNum(120021);
//        amgstrongNum(153);
        //nonPrimeNum(36);
        //primeNum(17);

//        gcd(20,40);

    }

    public static void extractAllDig(int n)
    {
        int c=0;
        while (n>0)
        {
            c++;
            n = n/10;

        }
        System.out.println(c);

    }

    public static void reverseNum(int n)
    {
        int rev=0;
        while (n>0)
        {
            rev = rev*10 + n%10;
            n = n/10;
        }
        System.out.println(rev);
    }

    public static void palindromeNum(int n)
    {
        int reverse = 0;
        int actualNum = n;

        while (n>0)
        {
            reverse = (reverse * 10) + n%10;
            n = n/10;
        }

        System.out.println(actualNum);
        System.out.println(actualNum == reverse);
    }

    private static void amgstrongNum(int n) {
        int sum = 0;
        int ori = n;
        int len = (int) (Math.log10(n)+1);

        while (n>0)
        {
            sum += (int) (Math.pow(n%10 , len));
            n = n/10;
        }

        System.out.println(sum == ori);
    }

    private static void nonPrimeNum(int n)
    {
        ArrayList<Integer> sortList = new ArrayList<>();
//        int i=1;
//        while (i<=n)
//        {
//            if(n%i == 0)
//                System.out.println(i);
//            i++;
//        }
        for(int i=1; i<=Math.sqrt(n); i++)
        {
            if(n%i == 0)
            {
                sortList.add(i);
                if (i != n/i)
                    sortList.add(n/i);
            }
        }

        Collections.sort(sortList);
        for(int i : sortList)
        {
            System.out.println(i);
        }
    }

    private static void primeNum(int n)
    {
        int c=0;
        for(int i=1; i*i<=n; i++)
        {
            if(n%i == 0)
            {
                c++;

                if(i != n/i)
                {
                    c++;
                }

            }
        }
        System.out.println(c==2);
    }

    private static void gcd(int a, int b)
    {
//        int gcd = 0;
//
//        for(int i=Math.min(a,b); i>=1; i--)
//        {
//            if(a%i == 0 && b%i == 0)
//            {
//                gcd = i;
//                break;
//            }
//        }
//        System.out.println(gcd);


        while (a>0 && b>0)
        {
            if(a>b) a = a%b;
            else b = a%b;
        }
        if (a == 0) System.out.println(b);
        else System.out.println(a);

    }

}
