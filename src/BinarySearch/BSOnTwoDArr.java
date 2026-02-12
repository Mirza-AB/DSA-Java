package BinarySearch;

import javax.xml.transform.stax.StAXResult;

public class BSOnTwoDArr {
    public static void main(String[] args) {

//        int[][] arr = {
//                {0,0,1,1,1},
//                {0,0,0,0,0},
//                {0,1,1,1,1},
//                {0,0,0,0,0},
//                {0,1,1,1,1}
//        };
//        System.out.println(rowWithMaxOne(arr));

//        int[][] m = {
//                {3,4,6,8},
//                {10,12,13,15},
//                {17,18, 19,20}
//        };
//        int t = 12;
//        System.out.println(searchInMatrix(m,t));

//        int[][] m = {
//                {1,4,7,11,15},
//                {2,5,8,12,19},
//                {3,6,9,16,22},
//                {10,13,14,17,24},
//                {18,21,23,26,30}
//        };
//        int t = 12;
//        System.out.println(searchInMatrixII(m, t));

        int[][] m = {
                {4,2,5,1,4,5},
                {2,9,3,2,3,2},
                {1,7,6,0,1,3},
                {3,6,2,3,7,2}
        };

        for(int el:findPeakElInMatrix(m))
        {
            System.out.print(el + " ");
        }
    }

    private static int rowWithMaxOne(int[][] arr)
    {
        //brute force go through each row and col, count 1s and return row with max 1s

        //optimal

        int rowLength = arr.length;
        int colLength = arr[0].length;
        int t=1;
        int maxOne = -1;
        int index = -1;

        for(int i=0; i<rowLength; i++)
        {
            //index of first occurrance of 1 in a row;
            int lb = lowerBound(arr[i], t);
            int length = colLength - lb;
            if(length>maxOne)
            {
                maxOne = length;
                index = i;
            }
        }

        return index;
    }

    private static int lowerBound(int[] arr, int t)
    {
        int low = 0;
        int high = arr.length-1;
        int ans = arr.length;

        while (low<=high)
        {
            int mid = (low+high)/2;

            if(arr[mid]>= t)
            {
                ans = mid;
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }

        return ans;
    }

    //MATRIX FLATTENING
    //all the elements are sorted in the given matrix
    private static boolean searchInMatrix(int[][] matix, int t)
    {
        //brute force is to run nested for loon and do linear search tc - n*m

        //better - for loop for row , on ith row if 1st element<target<last do bs
        //otherwise continue

        //optimal: flatten the matrix to hypothetical arr: TC-log(n*m);

        int n = matix.length;
        int m = matix[0].length;


        int low = 0;
        int high = n*m-1;

        while (low<=high)
        {
            int mid = (low+high)/2;

            if(matix[mid/m][mid%m] == t)
            {
                return true;
            }
            else if (t>matix[mid/m][mid%m])
            {
                low = mid+1;
            }
            else high = mid-1;
        }


        return false;
    }

    //only row and cols are sorted.
    private static boolean searchInMatrixII(int[][] martix, int t)
    {
        //brute is doing linear search using nested for loops
        //better is outer for loop for rows, on each row do a BS.

        //optimal
        //approach is either start form top right or bottom left.
        //those two positions are sorted. Eg: from top left the row from left to right is
        //sorted and col from top to bottom is sorted.

        //the outer row and col is sorted like
        /**
         *   ----
         *      I
         *      I
         *      I
         * is the sorted fashion
         * */

        int n = martix.length;
        int m = martix[0].length;

        //coordinate of top right corner.
        int row = 0;
        int col =  m-1;

        while(row<n && col>=0)
        {
            //if the present coordinate is the target
            if(martix[row][col] == t) return true;
            else if (martix[row][col] > t) col --;
            else row ++;
        }

        return false;
    }

    private static int[] findPeakElInMatrix(int[][] matrix)
    {
        int n = matrix.length;
        int m = matrix[0].length;

        //BS on row, on the col where col is on get teh max el and compare the left and righ
        int low = 0;
        int high = m-1;

        while(low<=high)
        {
            int mid = (low+high)/2;

            //get the index of that column
            int row = findMax(matrix, mid);

            int left = (mid-1 >= 0) ? matrix[row][mid-1] : Integer.MIN_VALUE;
            int right = (mid+1<m) ? matrix[row][mid + 1] : Integer.MIN_VALUE;

            if(left < matrix[row][mid] && matrix[row][mid] > right)
            {
                return new int[] {row, mid};
            }
            else if(left>matrix[row][mid]) high = mid-1;
            else low = mid+1;

        }
        return new int[] {-1,-1};
    }

    private static int findMax(int[][]matrix, int col)
    {
        int n = matrix.length;

        int max = -1;
        int index = -1;
        for(int i=0; i<n; i++)
        {
            if(max<matrix[i][col])
            {
                max = matrix[i][col];
                index = i;
            }
        }
        return index;

    }


    private static int medianInARowWiseSortedMatrix(int[][] matrix)
    {
        return -1;
    }
}
