package st;
import java.util.*;
public class circularLinkedList
{
	static class Node
	{
		Node next;
		int data;
		Node (int data)
		{
			this.data=data;
			next=null;
		}
	}
	Node head;
	void insert(int data)
	{
		Node tem=new Node(data);
		if(head==null)
		{
			head=tem;
			return;
		}
		Node cur=head;
		while(cur.next!=null)
		{
			cur=cur.next;
		}
		cur.next=tem;
	}
	public boolean checkCircular()
	{
		if(head==null)
			return true;
		Node tem=head.next;
		while(tem!=null&&tem!=head)
		{
			tem=tem.next;
		}
		return (tem==head);
	}
	void print()
	{
		System.out.print(head.data+" ");
		Node cur=head.next;
		while(cur!=null&&cur!=head)
		{
			System.out.print(cur.data+" ");
			cur=cur.next;
		}
	}
	void madeCircular()
	{
		Node cur=head;
		while(cur.next!=null)
		{
			cur=cur.next;
		}
		cur.next=head;
	}
	public static void main(String args[])
	{
		circularLinkedList l=new circularLinkedList();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the size");
		int size=sc.nextInt();
		for(int i=0;i<size;i++)
		{
			l.insert(sc.nextInt());
		}
		System.out.println(l.checkCircular());
		l.print();
		System.out.println();
		l.madeCircular();
		System.out.println(l.checkCircular());
	}
}
