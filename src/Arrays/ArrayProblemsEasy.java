package Arrays;

import java.util.*;

public class ArrayProblemsEasy {
    public static void main(String[] args) {

        int[] arr1 = {1,1,1,2,2,4,7,7};
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1,1,1,2,2,4,7,7));

        int[] arr2 = {1,2,3,4,5,6,7};
        ArrayList<Integer> arr3 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7));

        int[] arr4 = {1, 0, 2, 3, 2, 0, 0, 4, 5, 1};

        ArrayList<Integer> a1 = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 4, 5));
        ArrayList<Integer> a2 = new ArrayList<>(Arrays.asList(2, 3, 4, 4, 5, 6));

        int[] num1 = {1,2,2,3,3,4,5,6};
        int[] num2 = {2,3,3,5,6,6,7};

        int n=5;
        int[] na = {1,2,3,4};
        int[] nums = {1,1,0,1,1,1,0,1,1};

        int[] arr5={1,1,2,3,3,4,4};

        int[] arr6 = {1,2,3,1,1,1,4,2,3};
//        int[] arr6 = {2,0,0,3};
        int k=3;

//        secLargest(arr1);
//        isArrSorted(arr1);
//        removeDupInSorted(arr1);
//        leftRotateByOne(arr2);
//        leftRotateByDPos(arr3, 3);
//        move0ToEnd(arr4);
//        unionOfSortedArray(a1, a2);
//        intersectionOfSortedArr(num1, num2);
//        missingNoFromArrr(na, n);
//        consecutiveOs(nums);
//        oneAppearanceOfElementInArr(arr5);
        lengthOfLongestSubArrWithSumK(arr6, k);


//       for(int i:arr4)
//       {
//           System.out.print(" " + i);
//       }
    }

    private static void secLargest(int[] arr)
    {
        //better solution than sorting
//        int largest = arr[0];
//        int n = arr.length;
//
//        for(int i=1; i<n; i++)
//        {
//            if(arr[i] > largest)
//                largest = arr[i];
//        }
//
//        int secLargest = -1;
//        for(int j=0; j<n; j++)
//        {
//            if(arr[j] > secLargest && arr[j]!=largest)
//            {
//                secLargest = arr[j];
//            }
//        }

        //optimal solution

        int largest = arr[0];
        int secLargest = -1;
        int n = arr.length;

        for(int i=0; i<n; i++)
        {
            if(arr[i] > largest)
            {
                secLargest = largest;
                largest = arr[i];
            }
            else if(arr[i] > secLargest && arr[i] != largest)
            {
                secLargest = arr[i];
            }
        }

        int smallest = arr[0];
        int secSmallest = Integer.MAX_VALUE;
        for(int i=0; i<n; i++)
        {
            if(arr[i]<smallest)
            {
                secSmallest = smallest;
                smallest = arr[i];
            }
            if(arr[i]<secSmallest && arr[i]!=smallest)
            {
                secSmallest = arr[i];
            }

        }

        System.out.println("second largest " + secLargest);
        System.out.println("second smallest " + secSmallest);
    }

    private static void isArrSorted(int[] arr)
    {
        for(int i=0; i<arr.length-1; i++)
        {

            if(arr[i] > arr[i+1])
            {
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);
    }

    private static void removeDupInSorted(int[] arr)
    {
        int j=0;
        for(int i=1; i<arr.length; i++)
        {
            if( arr[i] != arr[j])
            {
                arr[j+1] = arr[i];
                j++;
            }
        }
        System.out.println(j+1);

    }

    private static void leftRotateByOne(int[] arr)
    {
        int temp = arr[0];
        for(int i=1; i<arr.length; i++)
        {
            arr[i-1] = arr[i];
        }
        arr[arr.length-1] = temp;

    }

    private static void leftRotateByDPos(ArrayList<Integer> arr, int d)
    {
//        int n = arr.length;
        int n = arr.size();
//        int[] temp = new int[d];
        d = d % n;

//        for(int i=0; i<d; i++)
//        {
//            temp[i] = arr[i];
//        }
//
//        for(int j=d; j<n; j++)
//        {
//            arr[j-d] = arr[j];
//        }
//
//        for(int i=0; i<d; i++)
//        {
//            arr[n-d+i] = temp[i];
//        }

        Collections.reverse(arr.subList(0,d));

        Collections.reverse(arr.subList(d, n));

        Collections.reverse(arr.subList(0, n));

//        //right rotate by D
//        Collections.reverse(arr.subList(n-d, n));
//        Collections.reverse(arr.subList(0, n-d));
//        Collections.reverse(arr.subList(0,n));

    }

    private static void move0ToEnd(int[] arr)
    {
        int j=-1;
        int n =arr.length;

        for(int a=0; a<n; a++)
        {
            if(arr[a] == 0)
            {
                j=a;
                break;
            }
        }
        for(int i= j+1; i<n; i++)
        {
            if(arr[i] !=0)
            {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                j++;
            }
        }
    }

    private static void unionOfSortedArray(ArrayList<Integer> a1, ArrayList<Integer> a2)
    {
        int n1=a1.size();
        int n2 = a2.size();
        int l =0, r=0;
        ArrayList<Integer> result = new ArrayList<>();

        while (l<n1 && r<n2)
        {
            if(a1.get(l) < a2.get(r))
            {
                if(result.isEmpty() || !Objects.equals(result.getLast(), a1.get(l)))
                {
                    result.add(a1.get(l));

                }
                l++;
            }
            else if(a1.get(l)>a2.get(r))
            {
                if(result.isEmpty() || !Objects.equals(result.getLast(), a2.get(r)))
                {
                    result.add(a2.get(r));

                }
                r++;
            }
            else {
                if (result.isEmpty() || !Objects.equals(result.getLast(), a1.get(l))) {
                    result.add(a1.get(l));
                }
                l++;
                r++;
            }

        }

        while (l<n1)
        {
            if(!Objects.equals(result.getLast(), a1.get(l)))
            {
                result.add(a1.get(l));
                l++;
            }
        }
        while (r<n2)
        {
            if(!Objects.equals(result.getLast(), a2.get(r)))
            {
                result.add(a2.get(r));
                r++;
            }
        }

        for(int res:result)
        {
            System.out.print(" " + res);
        }
    }

    private static void intersectionOfSortedArr(int[] n1, int[] n2)
    {
        ArrayList<Integer> result = new ArrayList<>();

        int j=0;
        int i=0;

        while (i < n1.length && j < n2.length)
        {

            if(n1[i] == n2[j])
            {
                result.add(n1[i]);
                i++;
                j++;
            }
            else if(n1[i]<n2[j])
            {
                i++;
            }
            else
            {
                j++;
            }

        }

        for(int res:result)
        {
            System.out.print(" " + res);
        }
    }

    private static void missingNoFromArrr(int[] a, int n)
    {
//        int sumOfN = (n*(n+1))/2;
//        int sumofA = 0;
//
//        for(int i:a)
//        {
//            sumofA = sumofA+i;
//        }
//        System.out.println(sumOfN-sumofA);

        int xor1 = 0;
        int xor2 = 0;

        for(int j=0; j<n-1; j++)
        {
            xor2 ^= a[j];
            xor1 = xor1 ^ j+1;
        }
        xor1 ^= n;
        System.out.println(xor1 ^ xor2);

    }

    private static void consecutiveOs(int[] a)
    {
        int c=0;
        int max=0;

        for(int i=0; i<a.length; i++)
        {
            if(a[i] == 1)
            {
                c++;
                if(c>max)
                {
                    max = c;
                }
            }
            else
            {
                c=0;
            }
        }

        System.out.println(max);
    }
//  IMPORTANT
    private static void oneAppearanceOfElementInArr(int[] a)
    {
//        HashMap<Integer, Integer> hashMap = new HashMap<>();
//
//        for(int i=0; i<a.length; i++)
//        {
//            hashMap.put(a[i], hashMap.getOrDefault(a[i], 0)+1);
//        }
//        System.out.println(hashMap);
//
//        for(int j=0; j< hashMap.size(); j++)
//        {
//            if(hashMap.get(a[j]) == 1)
//            {
//                System.out.println(j);
//            }
//        }


        int xor=0;
        for(int i=0; i<a.length; i++)
        {
            xor ^= a[i];
        }
        System.out.println(xor);
    }

//   IMPORTANT: Sliding Window && PREFIX SUM
    private static void lengthOfLongestSubArrWithSumK(int[] a, int k)
    {
        //optimal for 0's and -ve's and better for positives

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int maxLen = 0;
        int sum = 0;
        for(int i=0; i<a.length; i++)
        {
            sum += a[i];

            if(sum == k)
            {
                maxLen = i+1;
            }

            int diff = sum-k;

            if(hashMap.containsKey(diff))
            {
                int len = i-hashMap.get(diff);
                maxLen = Math.max(maxLen, len);
            }

            if(!hashMap.containsKey(sum))
            {
                hashMap.put(sum, i);
            }
        }

        System.out.println(maxLen);


//        //optimal for positives only: sliding window approach
//        int left=0, right = 0;
//        int n =a.length;
//        int maxLength = 0;
//        int sum=a[0];
//
//        while (right<n)
//        {
//            while (left<=right && sum>k)
//            {
//                sum -= a[left];
//                left++;
//            }
//            if(sum ==k)
//            {
//                maxLength = Math.max(maxLength, right-left+1);
//            }
//            right++;
//            if(right<n){
//                sum += a[right];
//            }
//        }
//        System.out.println(maxLength);


//
    }
}
