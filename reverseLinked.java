import java.util.*;

class Node
{
    int data;
    Node next;
}
class LinkedList
{
    private Node head;
    int size;
    LinkedList()
    {
        head=null;
    }
    LinkedList(int data)
    {
        Node node=new Node();
        node.data=data;
        node.next=null;
        head=node;
    }

    public void insertLast(int data)
    {
        Node node=new Node();
        node.data=data;
        Node temp=head;
        if(temp==null)
            head=node;
        else
        {
            while(temp.next!=null)
            {
                temp = temp.next;
            }
            temp.next = node;

        }
        size++;
    }
    public int getListSize()
    {
        return size;
    }


    public void transverse() {
        if (head == null) {
            System.out.println("List is empty");
        } else
        {
            Node temp = head;
            while (temp.next != null) {
                System.out.print(temp.data+" ");
                temp = temp.next;
            }
            System.out.println(temp.data);
        }
    }
    public Node reverse()
    {
        // Node pointer = head;
        // Node previous = null, current = null;

        // while (pointer != null) {
        //     current = pointer;
        //     pointer = pointer.next;

        //     // reverse the link
        //     current.next=previous;
        //     previous=current;
        //     head=current;
        // }  
       
        Node current=head;
        Node prev=null;
        Node next=null;

        while(current!=null)
        {
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }

          return prev;
        }
        //public Node head;
//        if(head==null)
//        {
//            return head;
//
//        }
//        Node current=head;
//        Node previous=null;
//        Node next=null;
//
//        while(current!=null)
//        {
//            next=current.next;
//            current.next=previous;
//            previous=current;
//            current=next;
//        }
//        return previous;


    }



class reverseLinked {
    public static void main(String args[]) {
        LinkedList list = new LinkedList();
        list.insertLast(10);
        list.insertLast(20);
        list.insertLast(30);
        list.insertLast(40);
        list.insertLast(50);
        list.transverse();
        list.reverse();
    
         list.transverse();

    }
    
}
