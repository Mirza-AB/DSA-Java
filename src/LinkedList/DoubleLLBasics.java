package LinkedList;

class DLLNode
{
    int data;
    DLLNode next;
    DLLNode prev;

    public DLLNode (int data, DLLNode next, DLLNode prev)
    {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
    public DLLNode(int data)
    {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class DoubleLLBasics
{
    public static void main(String[] args)
    {
        //convert arr to DLL
        int[] arr = {1,2,3,4};
        DLLNode head = ArrayToDll(arr);
//        print(ArrayToDll(arr));

        //delete head
//        print(deleteHead(head));

        //delete tail
//        print(deleteTail(head));

        //delete kth element
//        print(deleteKthEl(head, 2));

        //delete val/node from DLL
//        deleteNode(head.next.next);
//        print(head);

//        print(insertHead(head,100));

//        print(insertTail(head,100));
//        print(insertBeforeKthNode(head, 10,3));
//        insertBeforeNode(head.next.next, 99);
//        print(head);

        print(reverseDLL(head));
    }

    //Convert arr to DLL
    private static DLLNode ArrayToDll(int[] arr)
    {
        DLLNode head = new DLLNode(arr[0]);
        DLLNode mover = head;

        for(int i=1; i<arr.length; i++)
        {
            DLLNode temp = new DLLNode(arr[i], null, mover);
            mover.next = temp;
            mover = mover.next;
        }

        return head;
    }

    //Print DLL
    private static void print(DLLNode head)
    {
        DLLNode temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    //delete head
    private static DLLNode deleteHead(DLLNode head)
    {
        if (head == null || head.next == null) return null;
        DLLNode temp = head;
        head = head.next;

        head.prev = null;
        temp.next = null;

        return head;
    }

    //delete tail
    private static DLLNode deleteTail(DLLNode head)
    {
        DLLNode current = head;


        while(current.next != null)
        {
            current = current.next;
        }
        DLLNode prev = current.prev;
        prev.next = null;
        current.prev = null;
        return head;
    }

    private static DLLNode deleteKthEl(DLLNode head, int k)
    {
        if(head == null) return null;

        int c=0;
        DLLNode temp = head;
        while (temp != null)
        {
            c++;
            if(c==k) break;
            temp = temp.next;
        }
        DLLNode preNode = temp.prev;
        DLLNode postNode = temp.next;

        //check for single node, head, tail
        if(preNode == null && postNode == null) return null;
        else if(preNode == null) return deleteHead(head);
        else if(postNode == null) return deleteTail(head);

        //for the middle elements
        preNode.next = postNode;
        postNode.prev = preNode;
        temp.next = null;
        temp.prev = null;
        return head;

    }

    //delete the val/node in DLL
    private static void deleteNode(DLLNode temp)
    {
//        if(head == null) return null;
//
//        DLLNode temp = head;
//
//        while (temp != null)
//        {
//            if(temp.data == val) break;
//            temp = temp.next;
//        }
//        DLLNode preNode = temp.prev;
//        DLLNode postNode = temp.next;
//
//        if(preNode == null &&postNode == null) return null;
//        else if(preNode == null) return deleteHead(head);
//        else if(postNode == null) return deleteTail(head);
//
//        preNode.next = postNode;
//        postNode.prev = preNode;
//        temp.next = null;
//        temp.prev = null;
//
//        return head;
        DLLNode preNode = temp.prev;
        DLLNode postNode = temp.next;

        if(postNode == null)
        {
            preNode.next = null;
            temp.prev = null;
            return;
        }
        preNode.next = postNode;
        postNode.prev = preNode;
        temp.next = null;
        temp.prev = null;
    }

    //insert head
    private static DLLNode insertHead(DLLNode head, int val)
    {
        DLLNode temp = new DLLNode(val, head,null);
        head.prev = temp;
        return temp;
    }

    //insert tail
    private static DLLNode insertTail(DLLNode head, int val)
    {
        //this is to create a new tail
//        DLLNode temp = head;
//        while(temp.next != null)
//        {
//            temp = temp.next;
//        }
//        DLLNode newTail = new DLLNode(val, null, temp);
//        temp.next = newTail;
//        return head;

        //insert before tail
        if(head.next == null) return insertHead(head, val);
        DLLNode tail = head;

        while (tail.next != null)
        {
            tail = tail.next;
        }
        DLLNode temp = new DLLNode(val, tail, tail.prev);
        tail.prev.next = temp;
        tail.prev = tail;


        return head;
    }

    //insert before kth node
    private static DLLNode insertBeforeKthNode(DLLNode head, int val, int k)
    {
        if(k==1) return insertHead(head, val);

        DLLNode temp = head;
        int c=0;
        while (temp != null)
        {
            c++;
            if(c == k) break;
            temp = temp.next;
        }

        DLLNode newNode = new DLLNode(val, temp, temp.prev);
        temp.prev.next = newNode;
        temp.prev = newNode;


        return head;
    }

    //insert before a given node (the given node is never head)
    private static void insertBeforeNode(DLLNode node, int val)
    {
        DLLNode newNode = new DLLNode(val, node, node.prev);
        node.prev.next = newNode;
        node.prev = newNode;

    }

    //reverse a DLL
    private static DLLNode reverseDLL(DLLNode head)
    {
//        //brute force tc: 2n and sc: n
//        Stack<Integer> values = new Stack<>();
//        DLLNode temp = head;
//
//        while (temp!=null)
//        {
//            values.push(temp.data);
//            temp = temp.next;
//        }
//
//        temp = head;
//        while (temp!=null)
//        {
//            temp.data = values.pop();
//            temp = temp.next;
//        }
//        return head;

        //optimal
        DLLNode current = head;
        DLLNode preNode = null;

        while (current != null)
        {
            preNode = current.prev;
            current.prev = current.next;
            current.next = preNode;
            current = current.prev;
        }

        return preNode.prev;
    }
}

//pre = current.prev;
//current.prev = current.next;
//current.next = pre;
//current = current.next;