/*
 * a. Show the contents of Circular linked list
b. Insert the data in the Circular linked list
c. Check how many elements are there in the Circular linked list.
d. Check to see if Circular linked list is empty.
 */

package assgn6;

public class CircularLinkedList<T> {

	private static class Node<T>{
		private T data;
		private Node<T> next;
		
//		public Node() {
//			data=0;
//			left=right=null;
//		}
		public Node(T ele) {
			data = ele;
			next=null;
		}
		
	}
	private Node<T> head;
	public CircularLinkedList() {
		head=null;
	}
	
	public boolean isEmpty() {
		return head==null;
	}
	
	public void insert(T ele) {
		Node<T> newNode = new Node<>(ele);
		if(isEmpty()) {
			head=newNode;
			newNode.next=head;
		}
		if(head.next==head) {
			head.next=newNode;
			newNode.next=head;
			return;
		}
		else {
			Node<T> trav=head;
			while(trav.next!=head) {
				trav=trav.next;
			}
			trav.next=newNode;
			newNode.next=head;
			System.out.println("successfully entered");
		}
	}
	public void insertAtFirst(T ele) {
		
	Node<T> newNode = new Node<>(ele);
	if(isEmpty()) {
		insert(ele);
	}
	else {
		Node<T> temp=head;
		while(temp.next!=head) {
			temp=temp.next;
		}
		temp.next=newNode;
		newNode.next=head;
		head=newNode;
		System.out.println("successfully entered");
	}
	}
	public void insert(T ele,int pos) {
		Node<T> newNode = new Node<>(ele);
		if(pos<1) {
			throw new RuntimeException("wrong position!!");
			
		}
		if(isEmpty()) {
			System.out.println("List is empty so add at first position");
			insertAtFirst(ele);
			return;
		}
		if(pos==1) {
			insertAtFirst(ele);
			return;
		}
		else {
			Node<T> trav=head,temp=null;
			for(int i=1;i<pos;i++) {
				
				temp=trav;
				trav=trav.next;
			}
			newNode.next=trav;
			temp.next=newNode;
			System.out.println("successfully added");
			
		}
	}
	public void insertLast(T ele) {
		if(isEmpty()) {
			insert(ele);
		}
		Node<T> newNode = new Node<>(ele);
		Node<T> trav=head;
		while(trav.next!=head) {
			trav=trav.next;
		}
		trav.next=newNode;
		newNode.next=head;
	}
	public void display() {
		if(isEmpty()) {
			System.out.println("list is empty!!");
			return;
		}
		if(head.next==null) {
			System.out.println(head.data);
			return;
		}
		Node<T> trav=head;
		System.out.println("list elements are : ");
		while(trav.next!=head) {
			System.out.print(trav.data+" ");
			trav=trav.next;
		}
		System.out.print(trav.data+" ");
		System.out.println();
	}
	public int totalElements() {
		if(isEmpty()) {
			return 0;
		}
		if(head.next==null) {
			return 1;
		}
		Node<T> trav=head;
		int cnt=0;
		while(trav.next!=head) {
			cnt++;
			trav=trav.next;
		}
		return ++cnt;
	}
	public void deleteAll() {
		head=null;
	}
	public T deleteAtFirst() {
		if(isEmpty()) {
			throw new RuntimeException("empty list!!");
			
		}
		Node<T> trav=head;
		
		while(trav.next!=head) {
			
			trav=trav.next;
		}
		trav.next=head.next;
		T ele = head.data;
		head=head.next;
		return ele;
	}
	public T deleteAtLast() {
		if(isEmpty()) {
			throw new RuntimeException("empty list!!");
		}
		Node<T>trav=head,prev=null;
		while(trav.next!=head) {
			prev=trav;
			trav=trav.next;
		}
		prev.next=head;
		return trav.data;
	}
	public T deleteAtPos(int pos) {
		if(isEmpty()) {
			throw new RuntimeException("empty list!!");
		}
		if(pos==1) {
			return deleteAtFirst();
			
		}else {
			Node<T>trav=head,prev = null;
			for(int i=1;i<pos;i++) {
				prev = trav;
				trav=trav.next;
			}
		
			prev.next = trav.next;
			return trav.data;
		}
		
	}
}
