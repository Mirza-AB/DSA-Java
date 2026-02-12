package LinkedList;

class Node
{
    int data;
    Node next;

    public Node(int data, Node next)
    {
        this.data = data;
        this.next = next;
    }

    public Node(int data)
    {
        this.data = data;
        this.next = null;
    }

}

public class LinkedListBasics
{
    public static void main(String[] args)
    {
        int[] arr = {2,4,6,8};

        //ARR TO LL CONVERSION
        Node head = arrToLL(arr);
        //System.out.println(head.data);


        //TRAVERSAL
        //traversalOfLL(head);

        // LENGTH
        //System.out.println(lengthOfLL(head));

        //SEARCH
        //System.out.println(searchInLL(head, 8));

        //Delete head
//        head = deleteHead(head);
//        System.out.println(head.data);
//        traversalOfLL(head);

        //delete tail
//        head = deleteTail(head);
//        traversalOfLL(head);

//        head = deleteKthNode(head, 9);
//        traversalOfLL(head);

//        head = deleteANode(head,9);
//        traversalOfLL(head);

//        head = insertHead(head, 10);
//        traversalOfLL(head);

//        traversalOfLL(insertTail(head, 10));

//        traversalOfLL(insertAtKthPos(head, 1, 5));

        traversalOfLL(insertBeforeKthVal(head, 99, 4));

    }

    //ARR TO LL CONVERSION
    public static Node arrToLL(int[] arr)
    {
        if (arr.length == 0) return null;
        Node head = new Node(arr[0]);
        //as to not tamper with head take a variable
        Node mover = head;
        //copy to LL and update the next pointer
        for(int i=1; i<arr.length; i++)
        {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    //TRAVERSAL
    public static void traversalOfLL(Node head)
    {
        if(head == null)
        {
            System.out.println("Empty LL");return;
        }
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    //LENGTH
    public static int lengthOfLL(Node head)
    {
        Node temp = head;
        int count = 0;

        while(temp != null)
        {
            count++;
            temp = temp.next;
        }
        return count;
    }

    //SEARCH
    public static boolean searchInLL(Node head, int t)
    {
        Node temp = head;
        while(temp!=null)
        {
            if(temp.data == t) return true;
            temp = temp.next;
        }
        return false;
    }

    //Delete head
    public static Node deleteHead(Node head)
    {
        //if LL is empty
        if(head == null) return head;

        head = head.next;

        return head;
    }

    //Delete tail or last node
    public static Node deleteTail(Node head)
    {
        Node temp = head;

        //if the LL is empty or only one Node exists
        if(head == null || head.next == null) return null;

        //we land on 2nd last node
        while (temp.next.next != null)
        {
            temp = temp.next;
        }

        temp.next = null;

        return head;
    }

    //delete a Kth element/node
    public static Node deleteKthNode(Node head, int t)
    {
        Node temp = head;
        //empty or the head to be removed
        if(head == null) return null;
        if(t == 1)
        {
            head = head.next;
            return head;
        }

        int c=0;
        Node prev = null;
        while (temp != null)
        {
            c++;
            //if the t is more than length this will never gets executed and the whole LL remains
            if(c == t)
            {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }

        return head;
    }

    //delete the node with given value
    public static Node deleteANode(Node head, int val)
    {
        if(head == null) return null;
        if(head.data == val) {
            head = head.next;
            return head;
        }

        Node prev = null;
        Node temp = head;
        while (temp != null)
        {
            if(temp.data == val)
            {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }

        return head;
    }

    //Insert at the head
    public static Node insertHead(Node head, int val)
    {
        return new Node(val, head);
    }

    //Insert at the tail position
    private static Node insertTail(Node head, int val)
    {
        Node tail = head;
        while(tail.next != null)
        {
            tail = tail.next;
        }
        tail.next = new Node(val);
        return head;
    }

    //Insert at the kth position
    public static Node insertAtKthPos(Node head, int val, int i)
    {
        if(head == null) return null;
        if(i==1) return new Node(val, head);

        int c=0;
        Node temp = head;

        while (temp != null)
        {
            c++;
            if(c == i-1)
            {
                Node x = new Node(val);
                x.next = temp.next;
                temp.next = x;
            }
            temp = temp.next;
        }
        return head;
    }

    //Insert before the kth value
    public static Node insertBeforeKthVal(Node head, int val, int pos)
    {
        if(head == null) return null;
        if(pos == head.data) return new Node(val, head);

        Node temp = head;

        while (temp.next != null)
        {
            if(temp.next.data == pos)
            {
                Node x = new Node(val, temp.next);
                temp.next = x;
                break;
            }

            temp = temp.next;
        }

        return head;
    }



}


