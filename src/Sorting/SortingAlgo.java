public class SortingAlgo {
    public static void main(String[] args) {

        int[] arr = {9, 46, 11, 20, 1};
        //selectionSort(arr);
        //bubbleSort(arr);
        //insertionSort(arr);
        //mergeSort(arr, 0, arr.length-1);
        //quickSort(arr, 0, arr.length-1);

        for(int i:arr)
        {
            System.out.println(i);
        }

    }

    private static void selectionSort(int[] arr) {
        for(int i=0; i<arr.length-1; i++)
        {
            int min =i;
            for(int j=i+1;j<arr.length; j++)
            {
                if(arr[min] > arr[j]) {
                    min =j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    private static void bubbleSort(int[] arr) {
        for(int i=0; i<arr.length-1; i++)
        {
            int swap = 0;
            for(int j=0; j<arr.length-1-i; j++)
            {
                if(arr[j+1] <arr[j])
                {
                    int temp = arr[j];
                     arr[j] = arr[j+1];
                     arr[j+1] = temp;
                     swap = 1;
                }
            }
            if(swap == 0)
            {
                break;
            }
        }
    }

    private static void insertionSort(int[] arr) {

//        int n = arr.length;
//
//        for(int i=1; i<n; i++)
//        {
//            int k = arr[i];
//            int j=i-1;
//
//            while (j>=0 && arr[j] > k)
//            {
//                arr[j+1] = arr[j];
//                j--;
//            }
//
//            arr[j+1] = k;
//        }
        int n = arr.length;

        for(int i=0; i<n; i++)
        {
            int j = i;

            while (j>0 && arr[j-1] > arr[j])
            {
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
                j--;

            }
        }

    }

    private static void mergeSort(int[] arr, int low, int high)
    {
        if(low>=high) return;
        int mid = (low+high)/2;

        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);


        merge(arr, low, mid, high);
    }

    private static void merge(int[] arr, int low, int mid, int high)
    {
        int[] temp= new int[high-low+1];

        int i=0;
        int l=low;
        int r=mid+1;

        while ((l<=mid && r<=high))
        {
            if(arr[l]<=arr[r])
            {
                temp[i++] = arr[l++];
            }
            else
            {
                temp[i++] = arr[r++];
            }
        }

        while (l<=mid)
        {
            temp[i++] = arr[l++];
        }

        while (r<=high)
        {
            temp[i++] = arr[r++];
        }

        for(int a=0; a<temp.length; a++)
        {
            arr[low+a] = temp[a];
        }

    }

    private static void quickSort(int[] arr, int low, int high)
    {
        if(low<high)
        {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high)
    {
        int i=low;
        int j=high;
        int p=arr[low];

        while (i<j)
        {
            while(arr[i]<=p && i<=high-1)
            {
                i++;
            }
            while (arr[j]>p && j>=low+1)
            {
                j--;
            }
            if(i<j)
            {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        //swap
        int temp = arr[j];
        arr[j] = arr[low];
        arr[low] = temp;
        //return

        return j;
    }

}
