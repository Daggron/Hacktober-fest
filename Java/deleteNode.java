
import java.util.*;
public class deleteNode
{
	static class Node
	{
		int data;
		Node next;
		Node(int data)
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
	void print(Node head)
	{
		Node cur=head;
		while(cur!=null)
		{
			System.out.print(cur.data+" ");
			cur=cur.next;
		}
	}
	void delete(Node head,int data)
	{
		boolean t=false;
		Node cur=head;
		if(cur.data==data)
		{
			head=head.next;
			return;
		}
		while(cur.next!=null)
		{
			if(cur.next.data==data)
			{
				cur.next=cur.next.next;
				t=true;
				return;
			}
			else
			{
				cur=cur.next;
			}
		}
		if(t==false)
		{
			System.out.println("Not Found");
		}
	}
	public static void main(String args[])
	{
		deleteNode d=new deleteNode();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the size");
		int size=sc.nextInt();
		for(int i=0;i<size;i++)
		{
			d.insert(sc.nextInt());
		}
		d.delete(d.head,20);
		d.print(d.head);
	}
}
