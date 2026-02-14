package LinkedList;
import java.lang.invoke.VarHandle;
import java.util.*;

import static LinkedList.LinkedListBasics.*;
public class LLHardProblems
{
    public static void main(String[] args)
    {
//        Node head = arrToLL(new int[]{1,2,3,4,5,6,7,8,9,10});
//        int k=3;
//        traversalOfLL(reverseNodesInKGroups(head,k));

//        Node head = arrToLL(new int[]{1,2,3,4,5});
//        int k=3;
//        traversalOfLL(rotateLLByKPos(head, k));

//        Node head1 = arrToLL(new int[] {2,4,8,10});
//        Node head2 = arrToLL(new int[] {1,3,3,6,11,14});
//        traversalOfLL(mergeTwoSortedLL(head1,head2));

        //flatten a LL
//        Node head = new Node(3);
//
//        head.next = new Node(2);
//        head.next.child = new Node(10);
//
//        head.next.next = new Node(1);
//        head.next.next.child = new Node(7);
//        head.next.next.child.child = new Node(11);
//        head.next.next.child.child.child = new Node(12);
//
//        head.next.next.next = new Node(4);
//        head.next.next.next.child = new Node(9);
//
//        head.next.next.next.next = new Node(5);
//        head.next.next.next.next.child = new Node(6);
//        head.next.next.next.next.child.child = new Node(8);
//
////        traversalOfLL(flattenLL(head));
//
//        print(flattenLL(head));

//        Node head1 = arrToLL(new int[] {2,4,6});
//        Node head2 = arrToLL(new int[] {1,5});
//        Node head3 = arrToLL(new int[] {1,1,3,7});
//        Node head4 = arrToLL(new int[] {8});
//        List<Node> heads = new ArrayList<>();
//        heads.add(head1);
//        heads.add(head2);
//        heads.add(head3);
//        heads.add(head4);
//
//        traversalOfLL(mergeKSortedLL(heads));
//        Node head = arrToLL(new int[] {3,4,2,1,5});
//        traversalOfLL(sortLL(head));

//        Node head = new Node(7);
//        head.next = new Node(13);
//        head.next.next = new Node(11);
//        head.next.next.next = new Node(10);
//        head.next.next.next.next = new Node(1);
//
//
//        head.random = null;
//        head.next.random = head;
//        head.next.next.random = head.next.next.next.next;
//        head.next.next.next.random = head.next.next;
//        head.next.next.next.next.random = head;
//
//        printLLWithRandomPointers(cloneLL(head));


    }

    //IMPORTANT
    private static Node reverseNodesInKGroups(Node head, int k)
    {
        //O(2n)
        Node temp = head;
        Node preNode = null;
        Node postNode = null;

        while (temp!=null)
        {
            Node kthNode = findKthNode(temp, k);
            if(kthNode == null)
            {
                if(preNode!=null) preNode .next = temp;
                break;
            }

            postNode = kthNode.next;
            kthNode.next = null;

            reverse(temp);

            if(temp == head)
            {
                head = kthNode;
            }
            else
            {
                preNode.next = kthNode;
            }
            preNode = temp;
            temp = postNode;

        }

        return head;
    }

    private static Node findKthNode(Node head, int k)
    {
        Node curr = head;
        k-=1;
        while(curr!=null & k>0)
        {
            curr = curr.next;
            k--;
        }
        return curr;
    }

    private static void reverse(Node head)
    {
        if(head == null || head.next==null) return;
        reverse(head.next);
        Node front = head.next;
        head.next = null;
        front.next = head;
    }

    private static Node rotateLLByKPos(Node head, int k)
    {
        if(head==null || k==0) return head;

        Node temp = head;
        Node tail=head;
        int len=1;

        //get to tail and get the len
        while (tail.next!=null)
        {
            tail = tail.next;
            len++;
        }
        //modulate larger rotation values
        k = k%len;
        if(k == 0) return head;

        //make it circular by attaching tail to head
        tail.next = head;

        //get positioned before kth node
        int diff = len-k;

        while (diff>1)
        {
            temp = temp.next;
            diff--;
        }

        //head is the node next to teh temp and temp will be new tail.
        head = temp.next;
        temp.next = null;

        return head;
    }

    private static Node mergeTwoSortedLL(Node head1, Node head2)
    {
        Node dummyNode = new Node(-1);
        Node current = dummyNode;
        Node temp1 = head1;
        Node temp2 = head2;

        while (temp1!=null && temp2!=null)
        {
            if(temp1.data<temp2.data)
            {
                current.next = temp1;
                temp1 = temp1.next;
                current = current.next;
            }
            else
            {
                current.next = temp2;
                temp2 = temp2.next;
                current = current.next;
            }
        }

        //if either of the LL has nodes, point current to that LL.
        if(temp1!=null) current.next = temp1;
        else current.next = temp2;

        return dummyNode.next;
    }

    //Important
    private static Node flattenLL(Node head)
    {
        //brute force
        //tc: O(N x M) + O(N x M log(N x M)) + O(N x M)
        //sc: O(N x M) + O(N x M)
//        ArrayList<Integer> elements = new ArrayList<>();
//        while (head!=null)
//        {
//            Node t = head;
//            while (t!=null)
//            {
//                elements.add(t.data);
//                t = t.child;
//            }
//            head = head.next;
//        }
//        Collections.sort(elements);
//        head = arrToLL(elements.stream().mapToInt(i->i).toArray());
//        return head;

        //optimal
        if(head == null || head.next == null) return head;

        Node newHead = flattenLL(head.next);

        return merge(head, newHead);
    }

    //merging child Nodes
    private static Node merge(Node head1, Node head2)
    {
        Node dummyNode = new Node(-1);
        Node current = dummyNode;
        Node temp1= head1;
        Node temp2 = head2;

        while (temp1!=null && temp2!=null)
        {
            if(temp1.data<temp2.data)
            {
                current.child = temp1;
                current = temp1;
                temp1 = temp1.child;
            }
            else
            {
                current.child = temp2;
                current = temp2;
                temp2 = temp2.child;
            }
        }

        if(temp1!=null) current.child = temp1;
        else current.child = temp2;

        return dummyNode.child;
    }

    //print LL vertically (child nodes)
    private static void print(Node head)
    {
        while (head!=null)
        {
            System.out.print(head.data + " ");
            head = head.child;
        }
    }

    private static Node mergeKSortedLL(List<Node> heads)
    {
        //brute force
        //TC: O(n*k) + O(n*k log(n*k)) + O(n*k)
        //SC: O(n*k)+O(n*k)
//        List<Integer> vals = new ArrayList<>();
//        for(int i=0; i<heads.size(); i++)
//        {
//            Node temp = heads.get(i);
//            while (temp!=null)
//            {
//                vals.add(temp.data);
//                temp = temp.next;
//            }
//        }
//        Collections.sort(vals);
//        Node head = listToLL(vals);
//        return head;

        //better
//        TC: n+n + n+n+n + n+n+n+n ~ n*(k(k+1)/2) ~ n^3
//        SC: O(1);
        Node head = heads.getFirst();
        for(int i=1; i<heads.size(); i++)
        {
            head = mergeTwoSortedLL(head, heads.get(i));
        }
        return head;

    }

    private static Node listToLL(List<Integer> vals)
    {
        Node head = new Node(vals.get(0));
        Node temp = head;
        for(int i=1; i<vals.size(); i++)
        {
            temp.next = new Node(vals.get(i));
            temp = temp.next;
        }
        return head;
    }

    //merge sort on LL
    private static Node sortLL(Node head)
    {
        //tc: O(long(n)*(n+n/2))
        //sc: O(log(n))
        if(head == null || head.next == null) return head;

        Node mid = findMid(head);
        Node leftHead = head;
        Node rightHead = mid.next;
        mid.next = null;

        leftHead = sortLL(leftHead);
        rightHead = sortLL(rightHead);

        return mergeTwoSortedLL(leftHead, rightHead);
    }

    private static Node findMid(Node head)
    {
        Node slow = head;
        Node fast = head;

        while (fast.next!=null && fast.next.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    //LL with next and random pointer.
    private static Node cloneLL(Node head)
    {
        //brute
        //TC: 2n;
        //SC: extra O(n), answer LL is O(n)

//        //STEP:1 - create all clone Nodes and store original, clone in map
//        HashMap<Node, Node> cloneNodes = new HashMap<>();
//        Node temp = head;
//        while (temp!=null)
//        {
//            Node copy = new Node(temp.data);
//            cloneNodes.put(temp, copy);
//            temp = temp.next;
//        }
//
//        //STEP:2 - make connections
//        temp = head;
//        Node dummyNode = new Node(-1);
//        Node current = dummyNode;
//        while (temp!=null)
//        {
//            current.next = cloneNodes.get(temp);
//            current = current.next;
//            current.random = cloneNodes.get(temp.random);
//            temp = temp.next;
//        }
//        return dummyNode.next;

        //optimal
        //TC: O(3n) and SC: no extra space, O(n) to store and return the answer (copy list)

        //STEP1: Create a copy node in between and alter the links
        Node temp = head;
        while (temp!=null)
        {
            Node copy = new Node(temp.data);
            copy.next = temp.next;
            temp.next = copy;

            temp = temp.next.next;
        }

        //STEP2: give the copy LL random links
        //check for original's random's next is null or not.
        temp = head;
        while (temp!=null)
        {
            Node copy = temp.next;

            if(temp.random!=null)
            {
                copy.random = temp.random.next;
            }
            else
            {
                copy.random = null;
            }
            temp = temp.next.next;
        }

        //STEP3: provide next links to LL and reset original LL's links
        temp = head;
        Node dummyNode = new Node(-1);
        Node current = dummyNode;
        while (temp!=null)
        {
            current.next = temp.next;
            temp.next = temp.next.next;

            current = current.next;
            temp = temp.next;
        }

        return dummyNode.next;
    }

    private static void printLLWithRandomPointers(Node head)
    {
        while (head != null) {
            System.out.print("Data: " + head.data);
            if (head.random != null) {
                System.out.print(", Random: " + head.random.data);
            } else {
                System.out.print(", Random: null");
            }
            System.out.println();
            // Move to the next node
            head = head.next;
        }
    }
}
