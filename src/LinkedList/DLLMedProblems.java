package LinkedList;
import java.util.*;
import static LinkedList.DoubleLLBasics.*;

//import static LinkedList.DoubleLLBasics.*;

public class DLLMedProblems
{
    public static void main(String[] args)
    {
//        int[] arr = {10,4,10,10,6,10};
//        int k=10;
//        print(deleteAllOccurrenceOfK(head,k));
//        int[] arr = {1,2,3,4,9};
//        int k=5;
//        DLLNode head = arrayToDll(arr);
//        for(List<Integer> n:allPairsWithSumK(head,k))
//        {
//            System.out.println(n.getFirst() + "," + n.getLast());
//        }
        DLLNode head = arrayToDll(new int[]{1,1,1,2,3,3,4});
        print(removeDuplisFromSortedDll(head));

    }

    private static DLLNode deleteAllOccurrenceOfK(DLLNode head, int k)
    {
        //tc - O(n)
        DLLNode temp = head;
        DLLNode preNode = null;
        DLLNode postNode = null;
        while (temp!=null)
        {
            if(temp.data == k)
            {
                if(temp == head)
                {
                    head = head.next;
                }
                postNode = temp.next;
                preNode = temp.prev;
                if(postNode!=null) postNode.prev = preNode;
                if(preNode!=null) preNode.next = postNode;
                temp = postNode;
            }
            else
            {
                temp = temp.next;
            }
        }
        return head;
    }

    //given is a sorted DLL
    private static List<List<Integer>> allPairsWithSumK(DLLNode head, int k)
    {
        //brute force tc = O(n^2);
//        List<List<Integer>> answer = new ArrayList<>();
//        DLLNode temp1 = head;
//
//        while (temp1!=null)
//        {
//            DLLNode temp2 = temp1.next;
//            while (temp2!=null && temp1.data+temp2.data<=k)
//            {
//                if(temp1.data + temp2.data == k)
//                {
//                    answer.add(Arrays.asList(temp1.data, temp2.data));
//                }
//                temp2 = temp2.next;
//            }
//            temp1 = temp1.next;
//        }
//        return answer;

        //optimal
        List<List<Integer>> answer = new ArrayList<>();
        DLLNode temp1 = head;
        DLLNode temp2 = tailOfDLL(head);

        while (temp1.data<temp2.data)
        {
            if(temp1.data+temp2.data == k)
            {
                answer.add(Arrays.asList(temp1.data, temp2.data));
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            else if(temp1.data+temp2.data > k) temp2 = temp2.prev;
            else temp1 = temp1.next;
        }

        return answer;
    }
    private static DLLNode tailOfDLL(DLLNode head)
    {
        DLLNode tail = head;
        while (tail.next!=null)
        {
            tail = tail.next;
        }
        return tail;
    }

    private static DLLNode removeDuplisFromSortedDll(DLLNode head)
    {
        //TC: O(n);
        DLLNode temp = head;
        while (temp!=null && temp.next!=null)
        {
            DLLNode front = temp.next;
            while(temp.data == front.data && front!=null)
            {
                front = front.next;
            }
            temp.next = front;
            if(front!=null)front.prev = temp;
            temp = front.next;
        }
        return head;
    }
}
