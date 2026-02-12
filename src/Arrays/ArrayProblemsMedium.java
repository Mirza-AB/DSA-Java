package Arrays;

import javax.swing.plaf.IconUIResource;
import java.util.*;

public class ArrayProblemsMedium {
    public static void main(String[] args) {

//        int[] arr = {2,6,5,8,11};
//        int target = 14;
//        twoSum(arr, target);

//        int[] arr = {0,1,1,0,1,2,1,2,0,0,0};
//        sortO12(arr);
//        for(int i:arr)
//        {
//            System.out.print(i + " ");
//        }

        int[] arr = {7,7,5,7,5,1,5,7,5,5,7,7,5,5,5,5};
        majorityElements(arr);

//        int[] arr = {-2,-3,4,-1,-2,1,5,-3};
//        maxSubArrSum(arr);

//        int[] arr = {7,1,5,3,6,4};
//        buySellStocks(arr);

//        int[] arr = {3,1,-2,-5,2,-4};
//        rearrangeArrElements(arr);

//        int[] arr = {5,4,3,2,1,0,0};
//        int[] arr = {2,1,5,4,3,0,0};
//        nextPermutation(arr);
//        //print
//        for(int a:arr)
//        {
//            System.out.print(a + ", ");
//        }

//        int[] arr = {10,22,12,3,0,6};
//        leadersInArr(arr);
//        int[] arr = {102,4,100,1,1,2,2,3,3,102,101,101,103,2,1,104,105};
//        longConsecutiveSeq(arr);
//        int[][] arr = {
//                {1,1,1,1},
//                {1,0,1,1},
//                {1,1,0,1},
//                {0,1,1,1}
//        };
//        setMatrinZeros(arr);

//        int[][] arr = {
//                {1,2,3,4},
//                {5,6,7,8},
//                {9,10,11,12},
//                {13,14,15,16}
//        };

//        rotateBy90(arr);

//        int[][] arr = {
//                {1, 2, 3, 4, 5,  6},
//                {20,21,22,23,24, 7},
//                {19,32,33,34,25, 8},
//                {18,31,36,35,26, 9},
//                {17,30,29,28,27,10},
//                {16,15,14,13,12,11}
//        };
//        spiralTraversal(arr);

//        int[] arr = {1,2,3,-3,1,1,1,4,2,-3};
//        int k=3;
//        countSubArrWithSumK(arr, k);
    }


    //two-pointer approach or storing and searching the difference from the hash
    private static void twoSum(int[] arr, int t)
    {
//        //time is O(n) and space is O(n)
//        HashMap<Integer, Integer> hashMap = new HashMap<>();
//
//        for(int i=0; i<arr.length; i++)
//        {
//            int diff = t-arr[i];
//            if(hashMap.containsKey(diff))
//            {
//                System.out.println("Yes");
//                System.out.print(i +", " + hashMap.get(diff));
//                return;
//            }
//            else
//            {
//                hashMap.put(arr[i], i);
//            }
//        }
//        System.out.print("Not found");

        //time is O(nlogn) and space O(1)

        Arrays.sort(arr);
        int n = arr.length;
        int left=0;
        int right = n-1;
        int sum=0;

        while(left<right)
        {
            sum = arr[left] + arr[right];
            if(sum < t)
            {
                left++;
            }
            else if(sum > t)
            {
                right--;
            }
            else
            {
                System.out.println("yes");
                System.out.println(arr[left] + ", " + arr[right]);
                return;
            }
        }


    }
//IMPORTANT: Dutch National Flag Algorithm sorting 0/1/2
    private static void sortO12(int[] arr)
    {
//        //brute is to use sort O(nlogn)
//        Arrays.sort(arr);

        //better sol
//        int n=arr.length;
//        int a=0, b=0, c=0;
//
//        for(int i:arr) {
//            if(i==0) a++;
//            else if(i==1) b++;
//            else c++;
//        }
//        for(int p=0; p<a; p++) {arr[p] = 0;}
//        for(int q=a; q<a+b; q++) {arr[q] = 1;}
//        for(int r=a+b; r<n; r++) {arr[r] = 2;}

        //optimal: DUTCH NATIONAL FLAG ALGO
        int n=arr.length;
        int low=0;
        int mid=0;
        int high=n-1;


            while(mid<=high)
            {
                //check for 0
                if (arr[mid] == 0) {
                    int temp = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp;
                    low++;
                    mid++;
                }

                //check for 1
                else if (arr[mid] == 1) {
                    mid++;
                }

                //check for 2
                else {
                    int temp = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = temp;
                    high--;
                }
            }


    }

//    IMPORTANT: Moore's VOTING algorithm: compare an element and count++ if not equal to the element count--.
//    the element that's count is not 0, check that if it's occurring more than n/2 times
    private static void majorityElements(int [] arr)
    {
        //finding element in arr that is occurring more than n/2 times/
//        //brute approach
//        int n=arr.length;
//        for(int i=0; i<n; i++)
//        {
//            int c=0;
//            for(int j=0; j<n; j++)
//            {
//                if(arr[j] == arr[i])
//                {
//                    c++;
//                }
//            }
//            if(c>n/2)
//            {
//                System.out.println(arr[i]);
//                return;
//            }
//        }

        //space = O(n) time = O(n)
//        HashMap<Integer, Integer> hashMap = new HashMap<>();
//        int n=arr.length;
//        for(int i=0; i<n; i++)
//        {
//            hashMap.put(arr[i], hashMap.getOrDefault( arr[i], 0 ) + 1);
//        }
//
//        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
//            if (entry.getValue() > n / 2) {
//                System.out.println(entry.getKey());
//                return;
//            }
//        }
//
//        System.out.println(-1);

        //Moore's VOTING algo
        int n=arr.length;
        int c=0;
        int el=0;
        for (int k : arr) {
            if (c == 0) {
                el = k;
                c = 1;
            } else if (k == el) {
                c++;
            } else c--;
        }
        System.out.println(el);

        int cel = 0;
        for (int i : arr) {
            if (i == el) {
                cel++;
            }
        }
        if(cel>n/2)
        {
            System.out.println(el);
        }
        else
        {
            System.out.println(-1);
        }

    }

//    IMPORTANT: Kadane's algorithm: max sub-array's sum
    private static void maxSubArrSum(int[] arr)
    {
//        //brute force is to sum of sub arrays
//        int n=arr.length;
//        int maxSum = Integer.MIN_VALUE;
//
//        for(int i=0; i<n; i++)
//        {
//            int sum=0;
//            for(int j=i; j<n; j++)
//            {
//                sum += arr[j];
//                maxSum = Math.max(sum, maxSum);
//            }
//        }
//        System.out.println(maxSum);

        //optimal solution Kadane's
        int n=arr.length;
        int max = arr[0];
        int sum = 0;
        int start = -1;
        int end = -1;

        for(int i=0; i<n; i++)
        {
            if(sum ==0) start = i;
            sum += arr[i];
            if(sum>max)
            {
                max = sum;
                end = i;
            }
            if(sum<0)
            {
                sum = 0;
            }

        }

        System.out.println(max);
        System.out.println(start + ", " + end);

    }

    //with arr of prices find the max profit?
    private static void buySellStocks(int[] arr)
    {
        int n=arr.length;
        int max =0;

        //time: O(n^2) space O(1);
//        for(int i=0; i<n; i++)
//        {
//            for(int j=i; j<n; j++)
//            {
//                if(max<arr[j] -arr[i])
//                {
//                    max = arr[j]-arr[i];
//                }
//            }
//        }

        int buyPrice = Integer.MAX_VALUE;
        for(int i=0; i<n; i++)
        {
            buyPrice = Math.min(buyPrice, arr[i]);
            max = Math.max(max, arr[i] - buyPrice);
        }

        System.out.println(max);
    }

    private static void rearrangeArrElements(int[] arr)
    {
        int n=arr.length;
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        //brute if +ve and -ve are equal and optimal if not with extra for loop at the end.
        //for that check if there are more pos or neg and accordingly all the remaining
        //elements to the final array.
//        for(int i=0; i<n; i++)
//        {
//            if(arr[i] > 0) pos.add(arr[i]);
//            else neg.add(arr[i]);
//        }
//        for(int j=0; j<pos.size(); j++)
//        {
//            arr[j*2] = pos.get(j);
//            arr[j*2+1] = neg.get(j);
//        }
//        for(int a:arr)
//        {
//            System.out.print(a + " ");
//        }

        //optimal if the num of +ve and -ve are equal

//        int[] answer = new int[n];
//
//        int ni=1, pi=0;
//        for(int i=0; i<n; i++)
//        {
//            if(arr[i]>0)
//            {
//                answer[pi] = arr[i];
//                pi=pi+2;
//            }
//            else
//            {
//                answer[ni] = arr[i];
//                ni=ni+2;
//            }
//        }
//
//        for(int a: answer)
//        {
//            System.out.print(a + " ");
//        }

    }

    private static void nextPermutation(int[] arr)
    {
        int n = arr.length;
        int dip = -1;
        //find dip; meaning if i<i+1 i is dip;
        for(int i=n-2; i>=0; i--)
        {
            if(arr[i] < arr[i+1])
            {
                dip = i;
                break;
            }
        }

        if(dip==-1)
        {
            int l=0;
            int r=n-1;
            while(l < r)
            {
                int temp1 = arr[l];
                arr[l] = arr[r];
                arr[r] = temp1;
                l++;
                r--;
            }
            return;
        }

        //find lowest num greater than dip and swap with dip
        for(int j=n-1; j>dip; j--)
        {
            if(arr[j]>arr[dip])
            {
                int temp = arr[dip];
                arr[dip] = arr[j];
                arr[j] = temp;
                break;
            }
        }

        int left = dip+1;
        int right = n-1;
        while( left < right)
        {
            int temp1 = arr[left];
            arr[left] = arr[right];
            arr[right] = temp1;
            left++;
            right--;
        }
    }

    private static void leadersInArr(int[] arr)
    {
//        //brute force
//        ArrayList<Integer> result = new ArrayList<>();
//        int n=arr.length;
//
//        for(int i=0; i<n; i++)
//        {
//            boolean leader = true;
//
//            for(int j=i+1; j<n; j++)
//            {
//                if(arr[j] > arr[i])
//                {
//                    leader = false;
//                    break;
//                }
//            }
//            if(leader)
//            {
//                result.add(arr[i]);
//            }
//        }
//        for(int r:result)
//        {
//            System.out.print(r + " ");
//        }

        //optimal

        ArrayList<Integer> result = new ArrayList<>();
        int n = arr.length;

        int leader = arr[n-1];
        result.add(leader);

        for(int i = n-2; i>=0; i--)
        {
            if(arr[i] > leader)
            {
                leader = arr[i];
                result.add(leader);
            }
        }
        Collections.reverse(result);

        for(int r:result)
        {
            System.out.print(r + " ");
        }



    }

    private static boolean linearSearch(int[] arr, int t)
    {
        for(int l=0; l<arr.length; l++)
        {
            if(arr[l] == t)
            {
                return true;
            }
        }
        return false;
    }

    //IMPORTANT: HARD
    private static void longConsecutiveSeq(int[] arr)
    {
//        //brute approach O(n^3)
//        int n = arr.length;
//        int maxc = 0;
//
//        for(int i=0; i<n; i++)
//        {
//            int x = arr[i];
//            int c=1;
//            while (linearSearch(arr, x + 1))
//            {
//                x +=1;
//                c+=1;
//
//            }
//            maxc = Math.max(c,maxc);
//        }
//        System.out.println(maxc);

        //better O(nlogn + n)
//        Arrays.sort(arr);
//        int n=arr.length;
//        if (n == 0) {
//            System.out.println(0);
//            return;
//        }
//
//        int secLast = Integer.MIN_VALUE;
//        int c=0;
//        int maxCount = 1;
//
//        for(int i=0; i<n; i++)
//        {
//            int x = arr[i];
//
//            if(x - 1 == secLast)
//            {
//                c++;
//                secLast = x;
//            }
//            else if(arr[i] != secLast)
//            {
//                c=1;
//                secLast = arr[i];
//            }
//            maxCount = Math.max(maxCount, c);
//        }
//
//        System.out.println(maxCount);

        //optimal approach TC - O(n) SP-O(N)

        int n = arr.length;
        int maxLength=0;
        HashSet<Integer> hashSet = new HashSet<>();

        for(int a:arr)
        {
            hashSet.add(a);
        }

        for (int j : arr) {
            if (!hashSet.contains(j - 1)) {
                int num = j;
                int count = 1;

                while (hashSet.contains((num) + 1)) {
                    num++;
                    count++;
                }
                maxLength = Math.max(count, maxLength);
            }

        }

        System.out.println(maxLength);


    }

    private static void setMatrinZeros(int[][] arr)
    {
//        //brute force with near about O(n^3)
//        //if arr[i][j] == 0; set that row and col to -1
//        for(int i=0; i<arr.length; i++)
//        {
//            for(int j=0; j<arr[0].length; j++)
//            {
//                if(arr[i][j]==0)
//                {
//                    //convert the row to -1
//                    for(int col=0; col<arr[0].length; col++)
//                    {
//                        if(arr[i][col] != 0)
//                        {
//                            arr[i][col] = -1;
//                        }
//                    }
//
//                    //convert the col to -1
//                    for(int row=0; row<arr.length; row++)
//                    {
//                        if(arr[row][j] != 0)
//                            arr[row][j] = -1;
//                    }
//                }
//            }
//        }
//
//        //change all -1s to 0
//        for(int i=0; i<arr.length; i++)
//        {
//            for(int j=0; j<arr[0].length; j++)
//            {
//                if(arr[i][j] ==-1)
//                {
//                    arr[i][j] = 0;
//                }
//            }
//        }
//
//        //print the martix
//        for(int[] row:arr)
//        {
//            for(int col:row)
//            {
//                System.out.print(col + " ");
//            }
//            System.out.println();
//        }

//        //better sol with O(n^2) and space of O(n+m)
//
//        int rowSize = arr.length;
//        int colSize = arr[0].length;
//
//        boolean[] row = new boolean[rowSize];
//        boolean[] col = new boolean[colSize];
//
//        for(int i=0; i<rowSize; i++)
//        {
//            for(int j=0; j<colSize; j++)
//            {
//                if(arr[i][j] == 0)
//                {
//                    row[i] = true;
//                    col[j] = true;
//                }
//            }
//        }
//
//        for(int i=0; i<rowSize; i++)
//        {
//            for(int j=0; j<colSize; j++)
//            {
//                if(row[i] || col[j])
//                    arr[i][j] = 0;
//            }
//        }
//
//        for(int[] r:arr)
//        {
//            for(int c:r)
//            {
//                System.out.print(c+" ");
//            }
//            System.out.println();
//        }

        //optimal sol tc: O(n^2) sc:O(1)
        int rowSize = arr.length;
        int colSize = arr[0].length;
        int col00 = 1;

        //row tracker => arr[..][0]
        //col tracket => arr[0][..]

        //user col0 for row tracking and row0 for col tracking
        //and if arr[i][j] = 0 then change the traker
        //except for the bottom left corner index use col00
        for(int i=0; i<rowSize; i++)
        {
            for(int j=0; j<colSize; j++)
            {
                if(arr[i][j] ==0)
                {
                    arr[i][0] = 0;


                    if(j!=0)
                    {
                        arr[0][j] = 0;
                    }
                    else {
                        col00 = 0;
                    }
                }
            }
        }

        for(int i=1; i<rowSize; i++)
        {
            for(int j=1; j<colSize; j++)
            {
                if(arr[i][j] != 0)
                {
                    if(arr[0][j] == 0 || arr[i][0] ==0)
                    {
                        arr[i][j] = 0;
                    }
                }
            }
        }

        if(arr[0][0] == 0)
        {
            for(int j=0; j<colSize; j++)
            {
                arr[0][j] = 0;
            }
        }

        if(col00 == 0)
        {
            for(int i=0; i<rowSize; i++)
            {
                arr[i][0] = 0;
            }
        }

        //print
        for(int[] r:arr)
        {
            for(int c:r)
            {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    private static void rotateBy90(int[][] arr)
    {
//        //brute force tc = n^2, sc = n^2
//        int n=arr.length;
//
//        int[][] result = new int[n][n];
//
//        for(int i=0; i<n; i++)
//        {
//            for(int j=0; j<n; j++)
//            {
//                result[j][n-1-i] = arr[i][j];
//            }
//        }
//
//        for(int[] r:result)
//        {
//            for(int c:r)
//            {
//                System.out.print(c + " ");
//            }
//            System.out.println();
//        }

        //optimal tc = n^2, sc = 1
        int n = arr.length;

        //transpose
        //swap the upper half of diagonal
        for(int i=0; i<n; i++)
        {
            for(int j=i+1; j<n; j++)
            {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        //reverse every row
        for(int i=0; i<n; i++)
        {
            int start = 0, end = n-1;

            while(start<end)
            {
                int temp = arr[i][start];
                arr[i][start] = arr[i][end];
                arr[i][end] = temp;
                start++;
                end--;
            }

        }

        for(int[] r:arr)
        {
            for(int c:r)
            {
                System.out.print(c+" ");
            }
            System.out.println();
        }
    }

    private static void spiralTraversal(int[][] arr)
    {
        int rowSize = arr.length;
        int colSize = arr[0].length;
        List<Integer> result = new ArrayList<>();

        int top = 0;
        int bottom = rowSize-1;
        int left = 0;
        int right = colSize-1;

        while (top<=bottom && left <= right)
        {
            for (int i = left; i <= right; i++) {
                result.add(arr[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                result.add(arr[i][right]);
            }
            right--;

            if(top<=bottom)
            {
                for (int i = right; i >= left; i--) {
                    result.add(arr[bottom][i]);
                }
                bottom--;
            }
            if(left<=right)
            {
                for (int i = bottom; i >= top; i--) {
                    result.add(arr[i][left]);
                }
                left++;
            }
        }


        for(int i: result)
        {
            System.out.println(i);
        }

    }

    //print the num of sub arrays whose sum is k
    private static void countSubArrWithSumK(int[] arr, int k)
    {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int prefixSum=0;
        int count = 0;

        hashMap.put(0,1);

        for(int i=0; i<arr.length; i++)
        {
            prefixSum += arr[i];

            int diff = prefixSum-k;

            if(hashMap.containsKey(diff))
            {
                count = count+hashMap.get(diff);
            }

            hashMap.put(prefixSum, hashMap.getOrDefault(prefixSum, 0)+1);
        }

        System.out.println(count);

    }


}
