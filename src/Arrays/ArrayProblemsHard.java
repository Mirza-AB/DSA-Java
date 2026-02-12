import java.lang.reflect.Array;
import java.util.*;

public class ArrayProblemsHard {
    public static void main(String[] args) {
        //pascal triangle 3 type questions
//        int r=6, c=2;
//        int n=6;
//        pascalTriType1(r, c);
//        ArrayList<Integer> printResults = pascalTriOfNthRow(r);
//        for(int i:printResults)
//        {
//            System.out.println(i);
//        }
//        pascalTriangle(n);

//        int[] arr = {1,1,1,3,3,2,2,2};
//        majorityElementsII(arr);

//        int[] arr = {-1,0,1,2,-1,-4};
//        int k=0;
//        int[] arr1 = {1,2,3,4,5,1,2,3,4,1,2,3,4,5};
//        int target=8;
//        threeSum(arr, k);
//        fourSum(arr1,target);

//        int[] arr = {4,2,2,6,4};
//        int k=6;
//        numOfSubArrWithXorK(arr, k);
//
//        int[][] arr = { {1,3}, {8,9} , {15,18},  {8,10}, {9,11},{2,6} , {16,17}, {2,4} };
//        mergeOverlappingIntervals(arr);

//        int[] a1 = {1,3,5,7};
//        int[] a2 = {0,2,6,8,9};
//
//        merge(a1,a2);
//        int[] arr={4,3,6,2,1,1};
//        findMissAndRepeatNum(arr);
//        int[] arr = {5,3,2,4,1};
//        countInversions(arr);

//        int[] arr = {40, 25,19, 12, 9, 6, 2};
//        reversePairs(arr);

//        int[] arr = {1,2,-3,-3,-1,4};
//        maxProductSubArr(arr);
    }

    //given row and col number, print the element n-1cr-1 is the formula
    //row and col start from 1, not 0 for triangle
    private static void pascalTriType1(int row, int col)
    {
        int ans = 1;
        for(int i=1; i<col; i++)
        {
            ans *= row-i;
            ans /= i;
        }
        System.out.println(ans+"");
    }

    //print the Nth row of the pascal triangle
    private static ArrayList<Integer> pascalTriOfNthRow(int row)
    {
        //brute force near about n^2
//        for(int i=1; i<=row; i++)
//        {
//            pascalTriType1(row, i);
//        }
        //optimal
        ArrayList<Integer> answer = new ArrayList<>();
        int ans=1;
       answer.add(1);

        for(int i=1; i<row; i++)
        {
            ans *= row-i;
            ans /= i;
            answer.add(ans);
        }
        return answer;
    }
    //print the whole pascal tri with given row no. or size n
    private static void pascalTriangle(int n)
    {
        ArrayList<ArrayList<Integer> > ans = new ArrayList<>();

        for(int i=1; i<=n; i++)
        {
            ArrayList<Integer> temp = pascalTriOfNthRow(i);
            ans.add(temp);
        }

        for(ArrayList<Integer> list:ans)
        {
            System.out.println(list);
        }

    }

    //majority elements more thant n/3 times
    private static void majorityElementsII(int[] arr)
    {
        //brute force n^2
//        int n=arr.length;
//        List<Integer> ans = new ArrayList<>();
//
//        for(int i=0; i<n; i++)
//        {
//            if(ans.contains(arr[i])) continue;
//            int count =0;
//            for(int j=0; j<n; j++)
//            {
//                if(arr[j] == arr[i])
//                {
//                    count ++;
//                }
//            }
//            if(count>n/3)
//            {
//                ans.add(arr[i]);
//            }
//
//            if(ans.size() == 2) break;
//        }

//        for(int i:ans)
//        {
//            System.out.print(i + " ");
//        }

        //better tc-n sc-n
//        HashMap<Integer,Integer> hashMap = new HashMap<>();
//        List<Integer> ans = new ArrayList<>();
//        int n = arr.length;
//        int minLen = n/3 + 1;
//
//        for(int i=0; i<n; i++)
//        {
//            hashMap.put(arr[i], hashMap.getOrDefault(arr[i],0)+1);
//            if(hashMap.get(arr[i]) == minLen)
//            {
//                ans.add(arr[i]);
//            }
//            if(ans.size() == 2) break;
//        }
//
//        for(int i:ans)
//        {
//            System.out.print(i + " ");
//        }

        //optimal
        List<Integer> ans = new ArrayList<>();

        int n=arr.length;
        int count1=0;
        int el1=0;
        int count2=0;
        int el2=0;

        for(int i=0; i<n; i++)
        {
            if(count1==0 && el2!= arr[i])
            {
                el1 = arr[i];
                count1++;
            }
            else if(count2 ==0 && el1 != arr[i])
            {
                el2=arr[i];
                count2++;
            }
            else if (arr[i] == el1)
            {
                count1++;
            }
            else if (arr[i] == el2)
            {
                count2++;
            }
            else {
                count1 --;
                count2--;
            }
        }

        int c1=0, c2=0;
        for(int i=0; i<n; i++)
        {
            if(arr[i] == el1)
            {
                c1++;
            }
            if(arr[i] == el2)
            {
                c2++;
            }
        }

        if(c1>=n/3+1) ans.add(el1);
        if(c2>=n/3+1 && el1 != el2) ans.add(el2);

        for(int i:ans)
        {
            System.out.print(i + " ");
        }
    }

    private static void threeSum(int[] arr, int target)
    {
//        //brute force tc=n^3 and sc = 2*O(no. of triplets whose sum is 0)
//        Set<List<Integer>> ans = new HashSet<>();
//
//        int n=arr.length;
//        for(int i=0; i<n; i++)
//        {
//            for(int j=i+1; j<n; j++)
//            {
//                for(int k=j+1; k<n; k++)
//                {
//                    if(arr[i]+arr[j]+arr[k] == target)
//                    {
//                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
//                        Collections.sort(temp);
//                        ans.add(temp);
//                    }
//                }
//            }
//        }
//
//        for(List<Integer> a:ans)
//        {
//            System.out.println(a);
//        }

        //better approach tc=n^2 and sc = 2*O(no. of triplets whose sum is 0)
//        int n=arr.length;
//        Set<List<Integer>> ans = new HashSet<>();
//
//        for(int i=0; i<n; i++)
//        {
//            Set<Integer> hashSet = new HashSet<>();
//            for(int j=i+1; j<n; j++)
//            {
//                int k = -(arr[i]+arr[j]);
//
//                if(hashSet.contains(k))
//                {
//                    List<Integer> temp = Arrays.asList(arr[i], arr[j], k);
//                    Collections.sort(temp);
//                    ans.add(temp);
//                }
//
//                hashSet.add(arr[j]);
//            }
//        }
//
//        for(List<Integer> a:ans)
//        {
//            System.out.println(a);
//        }

        //optimal approach
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        int n=arr.length;
        for(int i=0; i<n; i++)
        {
            if(i>0 && arr[i] == arr[i-1]) continue;
            int j=i+1, k=n-1;
            while (j<k)
            {
                int sum = arr[i] + arr[j] + arr[k];

                if(sum <0)
                {
                    j++;
                }
                else if(sum>0)
                {
                    k--;
                }
                else
                {
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                    ans.add(temp);
                    j++;
                    k--;

                    while (j<k && arr[j] == arr[j-1]) j++;
                    while (j<k && arr[k] == arr[k+1]) k--;
                }
            }
        }

        //print

        for(List<Integer> a:ans)
        {
            System.out.println(a);
        }
    }

    private static void fourSum(int[] arr, int target)
    {
        //same approach as threeSum for brute, better and optimal
        //optimal solution
        Arrays.sort(arr);
        List<List<Integer>> answer = new ArrayList<>();
        int n= arr.length;

        for(int i=0; i<n; i++)
        {
            if(i>0 && arr[i] == arr[i-1]) continue;
            for(int j=i+1; j<n; j++)
            {
                if(j>1 && arr[j] == arr[j-1])continue;
                int k=j+1, l=n-1;
                while(k<l)
                {
                    long sum = arr[i] + arr[j];
                    sum += arr[k];
                    sum += arr[l];

                    if (sum == target) {
                        answer.add(Arrays.asList(arr[i], arr[j], arr[k], arr[l]));
                        k++;
                        l--;
                        while(k<l && arr[k] == arr[k+1]) k++;
                        while(k<l && arr[l] == arr[l+1]) l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }

        for(List<Integer> a:answer)
        {
            System.out.println(a);
        }
    }

    //prefix hash storing
    private static void numOfSubArrWithXorK(int[] arr, int target)
    {
        //brute and better approaches are to iterate using 2 loops and picking up
        //every sub array and XORing and comparing with target and counting the
        //no of sub-arrays

        //optimal
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0,1);

        int n= arr.length;
        int xor=0;
        int count=0;

        for(int i=0; i<n; i++)
        {
            xor ^= arr[i];

            int required = target^xor;

            if(hashMap.containsKey(required))
            {
                count += hashMap.get(required);
            }

            hashMap.put(xor, hashMap.getOrDefault(xor,0)+1);
        }
        System.out.println(count);
    }
    /**
     * overlapping is (1,3), (2,4) => (1,4)
     * meaning if I go from 1-4 my 3,2 will also be
     * included in the interval
     * */

    private static void mergeOverlappingIntervals(int[][] arr)
    {
        //brute force

//        Arrays.sort(arr, (a,b)->a[0]-b[0]);
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

//        int n = arr.length;
//        int i=0;
//        List<List<Integer>> ans = new ArrayList<>();
//
//        while(i<n)
//        {
//            int start = arr[i][0];
//            int end = arr[i][1];
//            int j=i+1;
//            while(j<n && arr[j][0]<=end)
//            {
//                end = Math.max(end, arr[j][1]);
//                j++;
//            }
//            ans.add(Arrays.asList(start, end));
//            i=j;
//        }
//
//        for(List<Integer> a:ans)
//        {
//            System.out.println(a);
//        }


        //optimal
        List<List<Integer>> ans = new ArrayList<>();
        int n=arr.length;
        Arrays.sort(arr, Comparator.comparingInt(a->a[0]));

        for(int i=0; i<n; i++)
        {
            int start = arr[i][0];
            int end = arr[i][1];

            if(ans.isEmpty() || ans.get( ans.size()-1 ).get(1) < start)
            {
                ans.add(Arrays.asList(start, end));
            }
            else {
                int last = (ans.size() - 1);
                int maxEnd = Math.max(ans.get(last).get(1), arr[i][1]);
                ans.get(last).set(1, maxEnd);
            }
        }


        for(List<Integer> a:ans)
        {
            System.out.println(a);
        }
    }

    //merg sorted arrays without using extra space
    //GAP METHOD
    public static void merge(int[] a1, int[] a2)
    {
//        //optimal sol 1
//        int s1 = a1.length;
//        int s2 = a2.length;
//        int i=s1-1;
//        int j=0;
//
//        while(j<s2 && i>=0)
//        {
//            if(a1[i]>a2[j])
//            {
//                int temp = a1[i];
//                a1[i] = a2[j];
//                a2[j] = temp;
//                i--;
//                j++;
//            }
//            else break;
//
//        }
//        Arrays.sort(a1);
//        Arrays.sort(a2);
//
//        for(int el1:a1)
//        {
//            System.out.print(el1);
//        }
//        System.out.println();
//        for(int el2:a2)
//        {
//            System.out.print(el2);
//        }
        //optimal sol 2
        int s1 = a1.length;
        int s2 = a2.length;
        int l=s1+s2;
        int gap = l/2 + l%2;

        while(gap>0)
        {
            int left = 0;
            int right = left+gap;

            while(right<l)
            {
                //a1 and a2
                if(left<s1 && right>=s1)
                {
                    if(a1[left]>a2[right-s1])
                    {
                        int temp = a1[left];
                        a1[left] = a2[right-s1];
                        a2[right-s1] = temp;

                    }
                }

                //a2 and a2
                else if(left>=s1)
                {
                    if(a2[left-s1]>a2[right-s1])
                    {
                        int temp = a2[left-s1];
                        a2[left-s1] = a2[right-s1];
                        a2[right-s1] = temp;

                    }
                }

                //a1 and a1
                else
                {
                    if(a1[left]>a1[right])
                    {
                        int temp = a1[left];
                        a1[left] = a1[right];
                        a1[right] = temp;
                    }
                }
                left++;
                right++;
            }

            //updating gap
            if(gap==1) break;
            else
            {
                gap = gap/2 + gap%2;
            }
        }
        for(int el1:a1)
        {
            System.out.print(el1);
        }
        System.out.println();
        for(int el2:a2)
        {
            System.out.print(el2);
        }
    }

    //bit manipulation technique with XOR and AND.
    private static void findMissAndRepeatNum(int[] arr)
    {
        //brute tc-n^2
//        int n = arr.length;
//        int missing =-1;
//        int repeating = -1;
//        for(int i=1; i<=n; i++)
//        {
//            int count = 0;
//            for(int j=0; j<n; j++)
//            {
//                if(arr[j] == i)
//                {
//                    count++;
//                }
//            }
//
//            if(count ==2) repeating = i;
//            else if(count == 0) missing = i;
//            if(missing != -1 && repeating!= -1) break;
//        }
//        System.out.println("Missing: " + missing);
//        System.out.println("Repeating: " + repeating);

//        //better tc-O(n) sc-O(n)
//        int missing = -1;
//        int repeating = -1;
//        int n=arr.length;
//        int[] hashArr = new int[n+1];
//
//        for(int i=0; i<n; i++)
//        {
//            hashArr[arr[i]] ++;
//        }
//
//        for(int i=1; i<hashArr.length; i++)
//        {
//            if(hashArr[i] == 0) missing = i;
//            else if (hashArr[i] == 2) {
//                repeating = i;
//
//            }
//        }
//
//        System.out.println("Missing: " + missing);
//        System.out.println("Repeating: " + repeating);

        //optimal 1 - Math repeating - missing
//        long n=arr.length;
//        long sn = n*(n+1)/2;
//        long s=0;
//
//        long ssn = n*(n+1)*(2*n+1)/6;
//        long ss = 0;
//
//        for(int i:arr)
//        {
//            s+= i;
//            ss+=(long)i*i;
//        }
//        long val1 = s-sn; //r-m
//        long val2 = ss - ssn; //r^2-m^2
//        val2 = val2/val1;
//
//
//        int repeating = (int) (val1+val2)/2;
//        int missing = (int) (repeating-val1);
//
//        System.out.println("Missing: " + missing);
//        System.out.println("Repeating: " + repeating);


        //optimal 2

        //optimal 2 XOR
        int n = arr.length;
        int x=0;
        for(int i=0; i<n; i++)
        {
            x^=arr[i];
            x^=i+1;
        }
        int bit=0;
        while(true)
        {
            if((x & 1<<bit) !=0)
            {
                break;
            }
            bit++;
        }
        int zero=0, one=0;
        //divide for arr elements
        for(int i=0; i<n; i++)
        {
            if((arr[i] & 1<<bit) !=0)
            {
                one ^= arr[i];
            }
            else
            {
                zero ^= arr[i];
            }
        }
        //xor with 1=n
        for(int i=1; i<=n; i++)
        {
            if((i & 1<<bit) != 0)
            {
                one ^= i;
            }
            else {
                zero ^= i;
            }
        }

        int count=0;
        int repeating =0, missing=0;
        for(int i:arr)
        {
            if(i== zero)
            {
                count++;
            }
        }
        if(count== 2)
        {
            repeating = zero;
            missing = one;
        }
        else
        {
            repeating = one;
            missing = zero;
        }
        System.out.println("Missing: " + missing);
        System.out.println("Repeating: " + repeating);
    }

    //IMPORTANT
    //(a,b) a>b is an inversion.
    private static void countInversions(int[] arr)
    {
        //brute force O(n^2)
//        int n=arr.length;
//        int c=0;
//        for(int i=0; i<n; i++)
//        {
//            for(int j=i+1; j<n; j++)
//            {
//                if(arr[j]<arr[i])
//                {
//                    c++;
//                }
//            }
//        }
//        System.out.println(c);

//        //optimal tc-nlogn sc-n
//        int n=arr.length;
//        System.out.println(mergSort(arr, 0, n-1));

//

    }

//    private static int mergSort(int[] arr, int start, int end)
//    {
//        int c=0;
//        if(start>=end) return c;
//        int mid = (start+end)/2;
//        c+=mergSort(arr, start, mid);
//        c+=mergSort(arr, mid+1, end);
//        c+=merge(arr, start, mid, end);
//        return c;
//    }
//
//    private static int merge(int[] arr, int start, int mid, int end)
//    {
//        int[] temp = new int[end-start+1];
//        int l=start;
//        int r=mid+1;
//        int i=0;
//        int count=0;
//        while(l<=mid && r<=end)
//        {
//            if(arr[l]<=arr[r])
//            {
//                temp[i] = arr[l];
//                i++;
//                l++;
//            }
//            else {
//                temp[i] = arr[r];
//                i++;
//                r++;
//                count+= (mid-l+1);
//            }
//        }
//
//        while(l<=mid)
//        {
//            temp[i++] = arr[l++];
//        }
//        while(r<=end)
//        {
//            temp[i++] = arr[r++];
//        }
//
//        for(int j=0; j<temp.length; j++)
//        {
//            arr[start+j] = temp[j];
//        }
//        return count;
//    }

    //IMPORTANT
    //(a,b) a>2*b is reverse pair.
    private static void reversePairs(int[] arr)
    {
//        //brute tc-n^2
//        int n=arr.length;
//        int count=0;
//        for(int i=0; i<n; i++)
//        {
//            for(int j=i+1; j<n; j++)
//            {
//                if(arr[i]>2*arr[j])
//                {
//                    count++;
//                }
//            }
//        }
//        System.out.println(count);
        //optimal
//        int start=0;
//        int end = arr.length-1;
//        System.out.println(mergeSort(arr, start, end));
    }

//    private static int mergeSort(int[] arr, int start, int end)
//    {
//        int c=0;
//        if(start>=end) return c;
//        int mid = (start+end)/2;
//        c+=mergeSort(arr, start, mid);
//        c+=mergeSort(arr, mid+1, end);
//        c+=countPairs(arr, start, mid, end);
//        merge(arr, start, mid, end);
//        return c;
//    }
//
//    private static int countPairs(int[] arr, int start, int mid, int end)
//    {
//        int count =0;
//        int right = mid+1;
//        for(int i=start; i<=mid; i++)
//        {
//            while(right<=end && arr[i] > 2*arr[right])
//            {
//                right++;
//            }
//            count = count + right - mid - 1;
//        }
//        return count;
//    }
//
//    private static void merge(int[]arr, int start, int mid, int end)
//    {
//        int[] temp = new int[end-start+1];
//        int i=0;
//        int l=start;
//        int r=mid+1;
//
//        while(l<=mid && r<=end)
//        {
//            if(arr[l]<arr[r])
//            {
//                temp[i++] = arr[l++];
//            }
//            else {
//                temp[i++] = arr[r++];
//            }
//        }
//        while(l<=mid)
//        {
//            temp[i++] = arr[l++];
//        }
//        while (r<=end)
//        {
//            temp[i++] = arr[r++];
//        }
//        for(int t=0; t<temp.length; t++)
//        {
//            arr[start+t] = temp[t];
//        }
//    }

    //HARD
    private static void maxProductSubArr(int[] arr)
    {
//        //brute and better is to go through each sub arr and multiply
//        //optimal is O(n)
//        int n=arr.length;
//        int preProd = 1;
//        int sufProd = 1;
//        int ans = Integer.MIN_VALUE;
//
//        for(int i=0; i<n; i++)
//        {
//            if(preProd ==0) preProd=1;
//            if(sufProd == 0) sufProd=1;
//            preProd *= arr[i];
//            sufProd *= arr[n-i-1];
//            ans =  Math.max(ans, Math.max(sufProd, preProd));
//        }
//        System.out.println(ans);
    }
}

