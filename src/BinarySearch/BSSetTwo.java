package BinarySearch;

import java.util.Arrays;

public class BSSetTwo {

    public static void main(String[] args) {

//        int n = 28;
//        sqrtOfN(n);

//        int m = 8;
//        int n = 3;
//        System.out.println(nthRootOfInt(n, m));

//        int[] piles = {3, 6, 7, 11};
//        int h = 8;
//        System.out.println(kokoEatingBananas(piles, h));

//        int[] arr = {7,7,7,7,13,11,12,7};
//        int m=2;
//        int k=3;
////        int[] arr = {1,10,3,10,2};
////        int m=3;
////        int k=2;
//        System.out.println(minDaysToMakeMBouquets(arr, m, k));

//        int[] arr = {1,2,5,9};
//        int t = 6;
//        System.out.println(smallestDivisorGivenAThreshold(arr, t));

//        int[] arr = {1,2,3,4,5,6,7,8,9,10};
//        int d=5;
//        System.out.println(maxCapacityOfTheShip(arr,d));

//        int[] arr = {2,3,4,7,11};
//        int k= 5;
//        System.out.println(kthMissingPosInt(arr, k));

//        int[] stalls = {0,3,4,7,9,10};
//        int cows = 4;
//        System.out.println(aggressiveCows(stalls, cows));

//        int[] books = {25,46,28,49,24};
//        int students = 4;
//        System.out.println(bookAllocation(books, students));

//        int[] arr1 = {1,3,4,7,10,12};
//        int[] arr2 = {2,3,6,15};
//        System.out.println(medianOfTwoSortedArr(arr1, arr2));

        int[] arr1 = {1,3,4,7,10,12};
        int[] arr2 = {2,3,6,15};
        int k = 4;
        System.out.println(KthElementOfTwoArr(arr1, arr2, k));

    }

    //floor of sqr root of n eg: 27 = 5;
    private static void sqrtOfN(int n)
    {
        int low = 1;
        int high = n;


        while (low<=high)
        {
            int mid = (low+high)/2;
            if(mid * mid <=n)
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        System.out.println(high);
    }

    //example: 3rootof27; perfect root only otherwise return -1;
    private static int nthRootOfInt(int n, int m)
    {
        int low=1;
        int high = m;

        while (low<=high)
        {
            int mid = (low+high)/2;

            long ans = 1;
            for(int i=1; i<=n; i++)
            {
                ans *= mid;
                if(ans>m) break;
            }
            if(ans == m)
            {
                return mid;
            }
            else if(ans < m)
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        return -1;
    }

    //in the piles array each index represents no. of bananas. h is total number
    //of hours in which all bananas must be eaten. Find (min) t bananas/hr such that at
    //t bananas/hours on each pile could cover all piles in less that total h
    private static int kokoEatingBananas(int[] piles, int h)
    {
        int maxBananas = Arrays.stream(piles).max().getAsInt();
        int low = 1;
        int high = maxBananas;

        while(low<=high)
        {
            int mid = (low+high)/2;

            int t = totalTime(piles, mid);

            if(t<=h)
            {
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }

        return low;
    }

    //time = banana/speed
    private static int totalTime(int[] arr, int mid)
    {
        int totalTime = 0;

        for(int b:arr)
        {
            totalTime += (int) Math.ceil((double) b/mid);
        }

        return totalTime;
    }

    //int the array the content is number of days the flower at that index needs
    //to bloom. To be able to get m number of bouquets that can be made using contegious k flowers
    //what is the min numeber of days to wait for the flowers to bloom.
    private static int minDaysToMakeMBouquets(int[] arr, int m, int k)
    {
        //check if the garden has enough total flowers than the required no.of baskets * flowers in each one.
        if(arr.length< m*k) return -1;
        int minOfArr = Arrays.stream(arr).min().getAsInt();
        int maxOfArr = Arrays.stream(arr).max().getAsInt();

        int low = minOfArr;
        int high = maxOfArr;

        while (low<=high)
        {
            int mid = (low+high)/2;
            boolean check = flowerCheck(arr, m, k, mid);

            if(check)
            {
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        return low;
    }

    private static boolean flowerCheck(int[] arr, int m, int k, int mid)
    {
        int count=0;
        int b = 0;
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i]<=mid)
            {
                count++;
                if(count == k)
                {
                    b++;
                    count = 0;
                }
            }
            else
            {
                count = 0;
            }
        }
        return b>=m;
    }

    //smallest divisor such that the sum of the ceil of the answer after division of all elements
    //in arr is <=t.
    private static int smallestDivisorGivenAThreshold(int[] arr, int t)
    {
        //eg: arr{7,8,9} t=1; even when all are divided by 9 the sum will be 3 which is > than t.
        if(arr.length>t) return -1;
        int low=1;
        int high = Arrays.stream(arr).max().getAsInt();

        while(low<=high)
        {
            int mid = (low+high)/2;

            int check = reminderSum(arr, mid);

            if(check<=t)
            {
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }

        }
        return low;
    }

    private static int reminderSum(int[] arr, int mid)
    {
        int sum=0;

        for(int e:arr)
        {
            sum += (int) Math.ceil( (double) e/ (double) mid);
        }
        return sum;
    }

    //find the least capacity(weight) of the ship such that all the products
    // (the given weight array is the weight of all products) must be shipped within the
    //given days 'd'. Assume the ship can make one delivery per day.
    //eg: {1,2,3,4) if the ship capacity is 100 all products can be shipped in one day.
    //but find min capacity such that all are shipped within given d days.
    private static int maxCapacityOfTheShip(int[] weight, int d)
    {
        //since the capacity be less thant max value then the product with max weight cannot be shipped
        int low = Arrays.stream(weight).max().getAsInt();
        int high = Arrays.stream(weight).sum();

        while(low<=high)
        {
            int mid = (low+high)/2;

            int check = checkForWeightVsDays(weight, mid);
            if(check<=d)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return low;
    }

    private static int checkForWeightVsDays(int[] arr, int mid)
    {
        int sum=0;
        int d=1;
        for (int j : arr) {
            sum += j;
            if (sum > mid) {
                d++;
                sum = j;
            }
        }
        return d;
    }

    //IMPORTANT - HARD
    //find the kth missing positive integer
    //eg: arr = [2,4,9,10] k = 3 the missing numbers are 1,3,5,6,7,8 and 5 is the answer.
    //eg: arr [4,5,6] k =2; ans is also 2;
    private static int kthMissingPosInt(int[] arr,int k)
    {
        //brute tc - O(n)
//        for (int a : arr) {
//            if (a <= k) k++;
//            else break;
//        }
//        return k;

        //optimal
        int low = 0;
        int high = arr.length-1;

        while (low<=high)
        {
            int mid = (low+high)/2;
            //this is basically finding out the number of missing numbers at the mid position
            //this is so that if eg we want 9th missing number that would be between the numbers
            //in the array where missing numbers are 3-11. We are trying to find that range in which k lies
            int missing = arr[mid] - (mid+1);

            if(missing<k)
            {
                low=mid+1;
            }
            else
            {
                high = mid-1;
            }
        }

        //finally after binary search the high
        //or return high+1+k
        //basically for 5th missing number and in arr we have 3,6 missing numbers;
        //when low is at 3 and high is at 6; mid =3 which is <5 so low = mid+1;
        //then low is at 6; high at 6 mid at same index and now we are more missing that 5
        //i.e. 5>6. then high = mid-1;. Finally high is at index where there are 3 missing numbers
        //and low at index with 6 missing numbers.

        //as per high => at that pos there are 3 missing + (remaining missing) ie. 5-3
        // => missing = arr[high] + more
        //=> arr[high] + k - (arr[high] - (high+1)) = > arr[high] + k - arr[high] + high + 1;
        //=> k + high + 1. Since low = high +1
        //either return high+k+1 or low+k;
        return low+k;
    }

    //the stalls array consists of the distance between cows. Find min distance between cows
    //such that distance between each cow is max and all the cows are placed in stalls.
    private static int aggressiveCows(int[] stalls, int cows)
    {
        //brute is to do linear search starting from 1-max(stalls) and then when
        //the i value such that all cows are not being placed return i-1;

        Arrays.sort(stalls);
        int n = stalls.length;
        int low = 0;
        //max distance - min distance and since the array is sorted:
        int high = stalls[n-1] - stalls[0];

        while (low<=high)
        {
            int mid = low + (high-low)/2;

            boolean check = checkForPlace(stalls, cows, mid);

            if(check)
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        return high;
    }

    private static boolean checkForPlace(int[] stalls, int cows, int mid)
    {
        int cowPos = 1;
        int last = stalls[0];

        for(int i=1; i<stalls.length; i++)
        {
            if(stalls[i] - last  >= mid)
            {
                cowPos ++;
                last = stalls[i];
            }
        }
        return cowPos>=cows;
    }

    //books arr length  = no. of books and each index value is no. of pages
    //all books must to allocated and no two students can have the same book
    //can assign more than one book to one student but has to be contiguous
    //max pages assigned to a student is minimum. return max
    private static int bookAllocation(int[] books, int s)
    {
        int n = books.length;
        int low = Arrays.stream(books).max().getAsInt();
        int high = Arrays.stream(books).sum();
        int ans = 0;

        if(s>n) return -1;

        while(low<=high)
        {
            int mid = low + (high-low)/2;

            int check = chekMaxPages(books, mid);
            if(check == s) ans  = mid;
            if(check<=s)
            {
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        //return low
        return ans;
    }

    private static int chekMaxPages(int[] books, int pages)
    {
        int student = 1;
        int sum = 0;
        for (int book : books) {
            if (sum + book <= pages) {
                sum += book;
            } else {
                student++;
                sum = book;
            }
        }
        return student;
    }

    //IMPORTANT: CUT/SYMMETRY
    private static double medianOfTwoSortedArr(int[] arr1, int[] arr2)
    {
        //brute force would be merge two arrays into a third arr in sorted way
        //and return n/2 if odd or (n/1 + n/2-1)/2 if even

        //better approach is same as brute force but it doesn't use extra n1+n2 space but tc is = n1+n2;

//        int n1 = arr1.length;
//        int n2 = arr2.length;
//        int n = n1+n2;
//        int indexN = n/2;
//        int indexN_1 = n/2 -1;
//
//        int median1 = -1;
//        int median2 = -1;
//
//        int i=0;
//        int j=0;
//        int count = 0;
//
//        while(i<n1 && j<n2)
//        {
//            if(arr1[i] < arr2[j])
//            {
//                if(count == indexN) median1 = arr1[i];
//                if(count == indexN_1) median2 = arr1[i];
//                count++;
//                i++;
//            }
//            else
//            {
//                if(count == indexN) median1 = arr2[j];
//                if(count == indexN_1)  median2 = arr2[j];
//                count++;
//                j++;
//            }
//
//        }
//
//        while (i<n1)
//        {
//            if(count == indexN) median1 = arr1[i];
//            if(count == indexN_1) median2 = arr1[i];
//            i++;
//            count++;
//        }
//
//        while (j<n2)
//        {
//            if(count == indexN) median1 = arr2[j];
//            if(count == indexN_1) median2 = arr2[j];
//            j++;
//            count++;
//        }
//
//        if(n%2 == 1) return (double) median1;
//        else return (median1 + median2)/2.0;

        //optimal solution tc(min (log n1, log n2) );
        //use the idea of symmetry to divide the array and figure out the correct right and left part
        //of the final sorted array.

        //use the smallest array and see how many form that array will be in the final sorted merged array
        //and how many from right will be taken. basically find the right cut point on both arrays.

        int n1 = arr1.length;
        int n2 = arr2.length;

        int n = n1+n2;
        if(n1>n2) return medianOfTwoSortedArr(arr2, arr1);

        //low and high are cut positons and not index positions.
        int low = 0;
        //IMPORTANT take n1 not n1-1 unlike regular BS for cut problems.
        int high = n1;


        while (low<=high)
        {
            //the values on these mid position and mid -1 positions are l1, l2 and r1, r2
            //l1 = left from arr1 and l2 = left side of arr 2;

            int mid1 = (low+high)/2;
            //if its even 10 the mid of the largest array will be 5;
            //if big arr length is odd eg 5, then left half will be 3 (one more than right) right 2
            int mid2 = (n1+n2+1)/2 - mid1;

            //if mid 1 index is at 2 that means we take 2 values on index 0, 1 from samll arr and
            //rest elements from right arr (index of mid 2 will be no. of values that come from right arr)

            //basically check if for example from left array no elements are taken on left side then
            //mid1 will be 0 and hence l1 will be Min value; otherwise the index of mid1 will be no of elements that
            //should be taken from left arr eg: if mid1 is on index 2, in arr1 value at 0 and 1 are taken.
            //hence the left most value from arr1 will be arr1[mid-1]
            int l1 = (mid1 == 0) ? Integer.MIN_VALUE : arr1[mid1-1];
            int l2 = (mid2 == 0) ? Integer.MIN_VALUE: arr2[mid2-1];
            int r1 = (mid1 == n1) ? Integer.MAX_VALUE : arr1[mid1];
            int r2 = (mid2 ==n2) ? Integer.MAX_VALUE : arr2[mid2];

            //check for valid cut
            if(l1<=r2 && l2<=r1)
            {
                //check if the total no. of elements are even or odd
                if(n%2 == 0)
                {
                    return (double) ( Math.max(l1,l2) + Math.min(r1, r2) ) / 2.0;
                }
                else
                {
                    return Math.max(l1, l2);
                }
            }
            else if(l1>r2) high = mid1-1;
            else low = mid1+1;
        }
        return 0;
    }

    //IMPORTANT
    private static int KthElementOfTwoArr(int[] arr1, int[] arr2, int k)
    {
        int n1 = arr1.length;
        int n2 = arr2.length;
        if(n2>n1) return KthElementOfTwoArr(arr2, arr1, k);

        int low = Math.max(0, (k-n2));
        int high = Math.min(k, n1);

        while (low<=high)
        {
            int mid1 = (low+high)/2;
            int mid2 = k -mid1;

            int l1 = (mid1 == 0) ? Integer.MIN_VALUE : arr1[mid1-1];
            int l2 = (mid2 == 0) ? Integer.MIN_VALUE : arr2[mid2-1];

            int r1 = (mid1 == n1) ? Integer.MAX_VALUE : arr1[mid1];
            int r2 = (mid2 == n2) ? Integer.MAX_VALUE : arr2[mid2];

            if(l1<=r2 && l2<=r1)
            {
                return Math.max(l1, l2);
            }
            else if(l1>r2)
            {
                high = mid1-1;
            }
            else
            {
                low = mid1+1;
            }
        }

        return -1;
    }

    //N Gas Stations question

}
