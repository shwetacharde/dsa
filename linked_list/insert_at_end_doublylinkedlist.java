import java.util.*;
import java.io.*;
import java.lang.*;

class Node
{
        int data;
        Node prev;
        Node next;
        Node(int d){
            data=d;
            prev=null;
            next=null;
        }
}
  
class Main
{ 
    
    public static void main(String args[]) 
    { 
        Node head=new Node(10);
    	Node temp1=new Node(20);
    	Node temp2=new Node(30);
    	head.next=temp1;
    	temp1.prev=head;
    	temp1.next=temp2;
    	temp2.prev=temp1;
    	head=insertEnd(head,40);
    	printlist(head);
    	
    } 
    
    static Node insertEnd(Node head,int data)
    {
        Node temp=new Node(data);
        if(head==null)return temp;
        Node curr=head;
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.next=temp;
        temp.prev=curr;
        return head;
    }
    
    public static void printlist(Node head)
    {
        Node curr=head;
        while(curr!=null){
        System.out.print(curr.data+" ");
        curr=curr.next;
    }
      System.out.println();
    }
} 
