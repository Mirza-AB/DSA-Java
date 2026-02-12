package BinarySearch;

public class BSone {
    public static void main(String[] args)
    {
//        int[] arr={6,9,12,15,19,43,90};
//        System.out.println(findX(arr, 12, 0, arr.length-1));

//        int[] arr = {3,6,8,15,19};
//        int target = 20;
//        System.out.println(lowerBound(arr, target, 0, arr.length-1));

//        int[] arr = {3,6,8,15,19};
//        int target = 8;
//        System.out.println(upperBound(arr, target));

//        int[] arr = {10,20,30,40,50};
//        int target = 25;
//        ceil(arr, target);
//        floor(arr, target);

//        int[] arr = {2,4,6,8,8,8,11,13};
//        int target = 5;
//        firstLastOccurrence(arr, target);

//        int[] arr = {7,8,9,1,2,3,4,5,6};
//        int target=1;
//        int n=arr.length;
//        int ans = searchElInRotatedArr(arr, target, n);

//        System.out.println(ans);
//        int[] arr = {3,1,2,3,3,3};
//        int target=3;
//        int n=arr.length;
//        boolean ans = searchElInRotatedArrWithDupli(arr, target, n);
//        System.out.println(ans);

//        int[] arr = {4,5,6,7,8,9,1,2};
//        int n = arr.length;
//        findMinInRotatedArr(arr, n);

//        int[] arr = {1,1,2,3,3,4,4,5,5};
//        System.out.println(singleElInSortedArr(arr));

        int[] arr = {1,5,1,2,1};
//        int[] arr = {1,2,3,4,5,4,3};
        System.out.println(findPeakEl(arr));
    }

    //BS implementation using recursion and loop
    //private static int findX(int[] arr, int target, int low, int high)
    {
        //loop
//        while(low<=high)
//        {
//            int mid = (low+high)/2;
//            if(arr[mid] == target) return mid;
//            else if (target > arr[mid]) low = mid+1;
//            else high = mid-1;
//        }
//        return -1;

        //recursion
//        if(low>high) return -1;
//        int mid = low+ (high-low)/2; //this way we can avoid overflow problem
//        if(arr[mid] == target) return mid;
//        else if(target>arr[mid])
//        {
//            return findX(arr, target, mid+1, high);
//        }
//        return findX(arr, target, low, mid-1);
    }

    //find smallest index such that arr[i] >= target
    //IMPORTANT
    private static int lowerBound(int[] arr, int target, int low, int high)
    {
        int ans = arr.length;
        while(low<=high)
        {
            int mid = low + (high-low)/2;

            if(arr[mid] >= target)
            {
                ans = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        return ans;
    }

    //IMPORTANT
    //arr[i]>target is upper bound
    private static int upperBound(int[] arr, int target)
    {
        int n=arr.length;
        int low=0;
        int high=n-1;
        int ans=n;
        while (low<=high)
        {
            int mid = (low+high)/2;
            if(arr[mid] >target)
            {
                ans = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        return ans;
    }

    //Search insert position
    /*
    in the give arr of distinct elements, determine the position of the value x
    at which it should be inserted
    eg: arr=[1,2,4,7]
    if the target = 6 pos=3
    if the target = 2 pos=1
    i.e. the answer is LOWER BOUND
    * */

    //Floor and Ceil
    public static void ceil(int[] arr, int target)
    {
//        int n=arr.length;
//        int left=0;
//        int right = n-1;
//        int ans=-1;
//        while (left<=right)
//        {
//            int mid=(left+right)/2;
//            if(arr[mid]>=target)
//            {
//                ans=arr[mid];
//                right=mid-1;
//            }
//            else
//            {
//                left = mid + 1;
//            }
//
//        }
//        System.out.println(ans);
    }

    private static void floor(int[] arr, int target)
    {
//        int n=arr.length;
//        int low=0;
//        int high=n-1;
//        int ans=-1;
//        while (low<=high)
//        {
//            int mid=(low+high)/2;
//            if(arr[mid] <= target)
//            {
//                ans = arr[mid];
//                low = mid+1;
//            }
//            else
//            {
//                high = mid - 1;
//            }
//        }
//        System.out.println(ans);
    }

    //OCCURRENCE PATTERN
    private static void firstLastOccurrence(int[] arr, int target)

    {
        int n=arr.length;
        int low=0;
        int high=n-1;
        int first =-1, last =-1;

        //WAY 1: using first and last occurrence i.e using plane BS
        //first occurrence
        while(low<=high)
        {
            int mid=(low+high)/2;
            //if answer found move left and look for smaller index
            if(arr[mid] == target)
            {
                first = mid;
                high = mid-1;
            }
            else if(target>arr[mid])
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }

        //reset low and high
        low = 0; high = n - 1;

//        last occurrence
        while(low <= high)
        {
            int mid = (low+high)/2;
            if(arr[mid] == target)
            {
                last = mid;
                low= mid+1;
            }
            else if(target>arr[mid])
            {
                low=mid+1;
            }
            else
            {
                high = mid-1;
            }
        }

        //WAY 2: using LB and UP
//        int lb = lowerBound(arr, target, 0, n-1);
//        int ub = upperBound(arr, target);
//
//        if(lb < n && arr[lb] == target)
//        {
//            first = lb;
//            last = ub-1;
//        }

        System.out.println(first + "," + last);
        //to count occurrence
        //can also use count ++ when arr[mid] == target step in the code above but only works with WAY1
        if (last != -1)
        {
            int count = last - first + 1;
            System.out.println("Count: "+ count);
        }
        else System.out.println("Count: "+ 0);

    }

    //with unique elements //IMPORTANT
    private static int searchElInRotatedArr(int[] arr, int target, int n)
    {
        int low = 0;
        int high = n-1;

        while(low<=high)
        {
            int mid = low + (high-low)/2;

            if(arr[mid] == target) return mid;
            //check for sorted and check if the target lies in the sorted range
            //if yes work on sorted side or push the job to other side
            if(arr[low]<=arr[mid])
            {
                if(arr[low]<=target && target<=arr[mid])
                {
                    high = mid-1;
                }
                else
                {
                    low = mid+1;
                }
            }
            else
            {
                if(arr[mid] <=target && target<=arr[high])
                {
                    low = mid+1;
                }
                else
                {
                    high = mid-1;
                }
            }
        }
        return -1;
    }

    //with dupli; checking if the target is in the array. Checking the index is not possible
    //as there can be multiple indices with same num (that'd be solved by LS).
    private static boolean searchElInRotatedArrWithDupli(int[] arr, int target, int n)
    {
        int low=0;
        int high = n-1;

        while(low<=high)
        {
            int mid = low + (high-low)/2;

            if(arr[mid] == target) return true;
            //check for duplis
            //only if low, mid and high are the same elements, as long as they are keep
            //shrinking low and high, that is what continue will ensure.
            //I.e. if the below is true low and high will shrink and the while loop it incremented
            //without exec further below
            if(arr[low] == arr[mid] && arr[mid] == arr[high])
            {
                low++;
                high--;
                continue;
            }

            if(arr[low] <= arr[mid])
            {
                if(arr[low] <= target && target<=arr[mid])
                {
                    high = mid-1;
                }
                else
                {
                    low = mid+1;
                }
            }
            else
            {
                if(arr[mid]<=target && target<=arr[high])
                {
                    low = mid+1;
                }
                else
                {
                    high = mid-1;
                }
            }
        }
        return false;
    }

    //has unique elements
    //also print number of rotations.
    private static void findMinInRotatedArr(int[] arr, int n)
    {
        int low=0;
        int high =n-1;
        int min = Integer.MAX_VALUE;
        int count=0;

        while (low<=high)
        {
            int mid = low + (high-low)/2;

            //check for sorted side and take the first (low for left side, mid for right side
            // el of sorted side and check for the min on the other side.
            //the index of min is the num of rotations.
            if(arr[low]<=arr[mid])
            {
                if(arr[low]<min)
                {
                    min = arr[low];
                    count = low;
                }
                low=mid+1;

            }
            else
            {
                if(arr[mid]<min)
                {
                    min = arr[mid];
                    count = mid;
                }
                high = mid-1;
            }
        }
        System.out.println(min);
        //no. of rotations
        System.out.println(count);
    }

    //compare indices(even, odd) -> left side of single el
    //(odd,even) right side of single el.
    //figure out that and eliminate compare one el to left and one el to right
    //handle elements at 0 and n-1 index and single el arr separately.
    //INTUITION is the single el will always be at the even index.
    private static int singleElInSortedArr(int[] arr)
    {
        int n=arr.length;
        int low=1;
        int high = n-2;

        if(n==1) return arr[0];
        if(arr[0] != arr[1]) return arr[0];
        if(arr[n-1] != arr[n-2]) return arr[n-1];

        while (low<=high)
        {
            int mid = low + (high-low)/2;
            if(arr[mid] != arr[mid-1] && arr[mid] != arr[mid+1])
            {
                return arr[mid];
            }
            //check if we are in left, if so eliminate left
            if(mid%2 == 1 && arr[mid] == arr[mid-1] ||
                    mid%2 ==0 && arr[mid] == arr[mid+1])
            {
                low = mid+1;
            }

            //move right condition
            else
            {
                high = mid-1;
            }

        }

        return -1;
    }

    //peak = arr[i-1]< arr[i] > arr[i+1] (as in mountain peak)
    //the assumption is for el on 0 index the left is - infinity and for n-1 right is -infinity
    private static int findPeakEl(int[] arr)
    {
        int n = arr.length;
        //edge cases are handled before BS
        if(n == 1) return 0;
        if(arr[0] > arr[1]) return 0;
        if(arr[n-1] > arr[n-2]) return n-1;

        //trim down low and high
        int low = 1;
        int high = n-2;

        while (low<=high)
        {
            int mid = low + (high-low)/2;

            if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1])
            {
                return mid;
            }
            //check if the mid is in the increasing side (from left to right)
            else if(arr[mid]>arr[mid-1])
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
}
