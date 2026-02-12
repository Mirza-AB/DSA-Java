package LinkedList;

import java.util.*;

import  LinkedList.LinkedListBasics.*;

public class LLMedProblems
{
    public static void main(String[] args)
    {
//        int[] a = {3,5};
//        int[] b = {4,5,9,9};
//
//        Node l1 = arrToLL(a);
//        Node l2 = arrToLL(b);
//
//        traversalOfLL(addTwoLL(l1,l2));

//        int[] arr = {1,3,4,2,5,6};
//        Node head = arrToLL(arr);
//        traversalOfLL(oddEvenLL(head));

//        Node head = new Node(1);
//        head.next = new Node(0);
//        head.next.next = new Node(1);
//        head.next.next.next = new Node(2);
//        head.next.next.next.next = new Node(0);
//        head.next.next.next.next.next = new Node(2);
//        head.next.next.next.next.next.next = new Node(1);
//        traversalOfLL(sortZeroOneTwo(head));

//        int[] arr = {1,2,3,4,5};
//        Node head = arrToLL(arr);
//        int n=4;
//        traversalOfLL(deleteNthNodeFromEnd(head, n));

//        int[] arr = {1,3,2,5};
//        Node head = arrToLL(arr);
//        traversalOfLL(reverseLL(head));

//        int[] arr = {1,2,3,4,2,1};
//        Node head = arrToLL(arr);
//        System.out.println(checkForPalindrome(head));

//        int[] arr = {1,5,9};
//        traversalOfLL(add1ToNumRepByLL(arrToLL(arr)));

//        Node common = new Node(4);
//        common.next = new Node(6);
//        common.next.next = new Node(2);
//
//        Node head1 = new Node(3);
//        head1.next = new Node(1);
//        head1.next.next = common;
//
//        Node head2 = new Node(1);
//        head2.next = new Node(2);
//        head2.next.next = new Node(4);
//        head2.next.next.next = new Node(5);
//        head2.next.next.next.next = common;
//
//        if(intersectionOfYLL(head1, head2) != null)
//        {
//            System.out.println(intersectionOfYLL(head1, head2).data);
//        }
//        else
//        {
//            System.out.println("Null");
//        }

        Node head = new Node (1);
        head.next = new Node (2);
        Node loopNode = new Node(3);
        head.next.next = loopNode;
        head.next.next.next = new Node (4);
        head.next.next.next.next = new Node (5);
        head.next.next.next.next.next = new Node (6);
        head.next.next.next.next.next.next = new Node (7, loopNode);
//
////        System.out.println(detectLoop(head));
//        System.out.println(lenOfLoop(head));

        System.out.println(startNodeOfLoop(head).data);

//        int[] arr = {1,2,3,4,5};
//        Node head = arrToLL(arr);
//        traversalOfLL(deleteMiddleNode(head));

    }

    private static Node addTwoLL(Node l1, Node l2)
    {
       Node dummyNode = new Node(-1);
       Node current = dummyNode;

       Node h1 = l1;
       Node h2 = l2;

       int carry = 0;

       while (h1!=null || h2!=null)
       {
           int sum = carry;
           if(h1!=null) sum += h1.data;
           if(h2!=null) sum += h2.data;

           Node newNode = new Node(sum%10);
           carry = sum/10;
           current.next = newNode;
           current = current.next;

           if(h1!= null) h1 = h1.next;
           if(h2!=null) h2 = h2.next;
       }

       if(carry!=0)
       {
           current.next = new Node(carry);
       }

        return dummyNode.next;
    }

    //group odd placed/positioned nodes followed by even
    private static Node oddEvenLL(Node head)
    {
            //brute force tc-O(2n); sc-O(n)
//            if(head==null) return null;
//
//            ArrayList<Integer> vals = new ArrayList<>();
//            Node temp = head;
//
//            while (temp!= null && temp.next!=null)
//            {
//                vals.add(temp.data);
//                temp = temp.next.next;
//            }
//            if(temp!=null)
//            {
//                vals.add(temp.data);
//            }
//
//            temp = head.next;
//            while (temp!= null && temp.next!= null)
//            {
//                vals.add(temp.data);
//                temp = temp.next.next;
//            }
//            if(temp!=null)
//            {
//                vals.add(temp.data);
//            }
//
//            temp = head;
//            int i=0;
//            while (temp!=null)
//            {
//                temp.data = vals.get(i);
//                i++;
//                temp = temp.next;
//            }
//
//            return head;

            //optimal tc-O(n)

            //optimal tc is n/2 but at each iteration there are two unit operations
            //the final TC is O(n)
            Node odd = head;
            Node even = head.next;
            Node evenHead = head.next;

            while (even != null && even.next != null)
            {
                odd.next = odd.next.next;
                even.next = even.next.next;

                odd = odd.next;
                even = even.next;
            }
            odd.next = evenHead;

            return head;
    }

    private static Node sortZeroOneTwo(Node head)
    {
        //no or one node
        if(head == null || head.next == null) return head;

        //brute force TC: O(2n); SC: O(1);
//        Node temp = head;
//
//        int c0=0;
//        int c1=0;
//        while (temp!=null)
//        {
//            if (temp.data == 0) c0++;
//            else if(temp.data == 1) c1++;
//
//            temp = temp.next;
//        }
//
//        temp = head;
//        while (temp!=null)
//        {
//            if(c0>0)
//            {
//                temp.data = 0;
//                c0--;
//            }
//            else if(c1>0)
//            {
//                temp.data = 1;
//                c1--;
//            }
//            else
//            {
//                temp.data = 2;
//            }
//
//            temp = temp.next;
//        }
//        return head;

        Node temp = head;
        Node zeroHead = new Node(-1);
        Node zero = zeroHead;
        Node oneHead = new Node(-1);
        Node one = oneHead;
        Node twoHead = new Node(-1);
        Node two = twoHead;

        while (temp!=null)
        {
            if(temp.data==0)
            {
                zero.next = temp;
                zero = zero.next;
            }
            else if(temp.data == 1)
            {
                one.next = temp;
                one = one.next;
            }
            else
            {
                two.next = temp;
                two = two.next;
            }
            temp = temp.next;
        }


        zero.next = (oneHead.next == null) ? twoHead.next : oneHead.next;
        one.next = twoHead.next;
        two.next = null;

        return zeroHead.next;
    }

    //**FAST POINTER SLOW POINTER APPROACH**
    private static Node deleteNthNodeFromEnd(Node head, int n)
    {
        //brute TC: O(len + (len-n))
//        Node temp = head;
//        int len = 0;
//        while (temp!=null)
//        {
//            len++;
//            temp = temp.next;
//        }
//
//        int pos = len-n;
//
//        if(len == n)
//        {
//            head = head.next;
//            return head;
//        }
//
//        temp = head;
//        while (temp!=null)
//        {
//            pos--;
//            if(pos == 0) break;
//            temp=temp.next;
//
//        }
//        temp.next = temp.next.next;

        //optimal
        Node fast = head;
        Node slow = head;

        for(int i=0; i<n; i++)
        {
            fast = fast.next;
        }

        if(fast == null) return head.next;

        while (fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return head;
    }

    private static Node reverseLL(Node head)
    {
        //brute force tc(2n) sc (n)
//        if(head == null || head.next ==null) return head;
//        Stack<Integer> vals = new Stack<>();
//
//        Node temp = head;
//        while (temp!= null)
//        {
//            vals.push(temp.data);
//            temp = temp.next;
//        }
//
//        temp = head;
//        while (temp!=null)
//        {
//            temp.data = vals.pop();
//            temp = temp.next;
//        }
//        return head;

        //Optimal iterative
//        Node temp = head;
//        Node prev = null;
//        Node front = null;
//
//        while (temp!= null)
//        {
//            front = temp.next;
//            temp.next = prev;
//            prev = temp;
//            temp = front;
//
//        }
//        return prev;

        //Optimal recursive
        if(head == null || head.next == null) return head;

        Node newHead = reverseLL(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;

        return newHead;

    }

    //two pointer using fast/slow pointer approach
    private static boolean checkForPalindrome(Node head)
    {

        //brute force tc: O(2n); sc(n);
//        Stack<Integer> vals = new Stack<>();
//        Node temp = head;
//
//        while (temp!=null)
//        {
//            vals.push(temp.data);
//            temp = temp.next;
//        }
//        temp = head;
//        while (temp!=null)
//        {
//            if(temp.data != vals.pop())
//            {
//                return false;
//            }
//            else
//            {
//                temp = temp.next;
//            }
//        }
//        return true;

        //optimal tc(2n) sc(1)

        //to find the mid point
        Node fast = head;
        Node slow = head;
        while (fast.next != null && fast.next.next != null )
        {
            fast = fast.next.next;
            slow = slow.next;
        }

        //reverse the second half
        Node newHead = reverseLL(slow.next);

        //two pointers
        Node left = head;
        Node right = newHead;
        while (right!=null)
        {
            if(left.data != right.data)
            {
                reverseLL(newHead);
                return false;
            }
            else
            {
                left = left.next;
                right = right.next;
            }
        }

        //before returning always make reset the LL
        reverseLL(newHead);
        return true;

    }

    private static Node add1ToNumRepByLL(Node head)
    {
        //brute force tc(2n)
//        head = reverseLL(head);
//        Node temp = head;
//        int carry = 1;
//
//        while (temp!=null)
//        {
//            temp.data = temp.data + carry;
//
//            if(temp.data < 10)
//            {
//                carry = 0;
//                break;
//            }
//            else
//            {
//                temp.data = 0;
//                carry = 1;
//            }
//
//            temp = temp.next;
//        }
//
//        if(carry == 1)
//        {
//            Node newHead = new Node(1);
//            head = reverseLL(head);
//            newHead.next = head;
//            return newHead;
//        }
//
//        return reverseLL(head);

        //optimal O(n)

        int carry = helper(head);

        if(carry == 1)
        {
            Node newHead = new Node(carry);
            newHead.next = head;
            return newHead;
        }
        return head;
    }

    private static int helper(Node head)
    {
        if(head == null) return 1;

        int carry = helper(head.next);
        int sum = head.data + carry;
        head.data = sum%10;

        return sum/10;
    }

    private static Node intersectionOfYLL(Node head1, Node head2)
    {
        //brute: TC: (n1+n2) SC(n1) or (n2) depending which LL is stored.
//        Node temp1 = head1;
//        Node temp2 = head2;
//        HashMap<Node, Boolean> tracker = new HashMap<>();
//
//        while (temp1 != null)
//        {
//            tracker.put(temp1, true);
//            temp1 = temp1.next;
//        }
//
//        while (temp2!=null)
//        {
//            if(tracker.containsKey(temp2))
//            {
//                return temp2;
//            }
//            temp2=temp2.next;
//        }
//        return null;

        //better approach tc(n1+2n2) or (2n1 + n2)
//        Node temp1 = head1;
//        int len1 = 0;
//        Node temp2 = head2;
//        int len2 = 0;
//        //calc len1 and len2
//        while (temp1!=null) {
//            len1++;
//            temp1 = temp1.next;
//        }
//
//        while (temp2!=null)
//        {
//            len2++;
//            temp2 = temp2.next;
//        }
//
//        //reset positions
//        temp1 = head1;
//        temp2 = head2;
//
//        int diff = Math.abs(len1-len2);
//
//        //to make sure temp1 and temp2 are aligned.
//        if(len1<len2)
//        {
//            for(int i=0; i<diff; i++)
//            {
//                temp2 = temp2.next;
//            }
//        }
//
//        else
//        {
//            for(int i=0; i<diff; i++)
//            {
//                temp1 = temp1.next;
//            }
//        }
//
//        //both temp1 and temp2 are aligned
//        //if there is an intersection they meet and loop ends and temp1 or temp2 can be returned.
//        //if there's no intersection they meet at null and loop ends and null gets returned.
//        while (temp1!=temp2)
//        {
//            temp1 = temp1.next;
//            temp2 = temp2.next;
//        }
//        return temp2;

        //optimal tc(n1+n2)
        Node temp1 = head1;
        Node temp2 = head2;

        while (temp1!=temp2)
        {
            temp1 = (temp1 == null) ? head2 : temp1.next ;
            temp2 = (temp2 == null) ? head1 : temp2.next;
        }
        return temp2;
    }

    //loop in LL
    private static boolean detectLoop(Node head)
    {
        //brute force return (n/2 + 1)th node
        //tc (n) sc (n)
//        Node temp = head;
//        HashSet<Node> tracker = new HashSet<>();
//        while (temp!=null)
//        {
//            if(!(tracker.add(temp)))
//            {
//                return true;
//            }
//            temp = temp.next;
//        }
//        return false;


        Node fast = head;
        Node slow = head;
        while (fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }

        return false;
    }

    private static int lenOfLoop(Node head)
    {
        //brute force
//       HashMap<Node, Integer> tracker = new HashMap<>();
//       Node temp = head;
//       int count=0;
//
//       while (temp!=null)
//       {
//
//           if(tracker.containsKey(temp))
//           {
//               return count - tracker.get(temp)-1;
//           }
//
//           count++;
//           tracker.put(temp, count);
//           temp = temp.next;
//
//       }
//
//       return count;

        //optimal sc O(1)
        Node slow = head;
        Node fast = head;

        while(fast!= null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) return loopLen(slow, fast);
        }
        return 0;
    }

    private static int loopLen(Node slow, Node fast)
    {
        int count = 1;
        fast = fast.next;
        while (fast!=slow)
        {
            fast = fast.next;
            count++;
        }
        return count;
    }

    //delete middle node
    private static Node deleteMiddleNode(Node head)
    {
        //optimal 1
//        Node dummy = new Node(-1);
//        dummy.next = head;
//        Node slow = dummy;
//        Node fast = head;
//
//        while (fast!=null && fast.next!= null)
//        {
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//        slow.next = slow.next.next;
//        return head;

        //optimal 2
        Node slow = head;
        Node fast = head;
        fast = head.next.next;
        while (fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;

        return head;
    }

    private static Node startNodeOfLoop(Node head)
    {
        //brute
//        HashMap<Node, Integer> tracker = new HashMap<>();
//        Node temp = head;
//        while (temp!=null)
//        {
//            if(tracker.containsKey(temp)) return temp;
//            tracker.put(temp, 1);
//            temp = temp.next;
//        }
//
//        return null;

        //optimal approach
        if(head == null || head.next == null) return null;
        Node slow = head;
        Node fast = head;

        while (fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast  = fast.next.next;

            if(slow == fast)
            {
                slow = head;
                while (slow!=fast)
                {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        return null;
    }
}
