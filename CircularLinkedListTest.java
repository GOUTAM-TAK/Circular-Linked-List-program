package tester;

import java.util.Scanner;


import assgn6.CircularLinkedList;

public class CircularLinkedListTest {

	public static void main(String[] args) {
		CircularLinkedList<Double> lists = new CircularLinkedList<Double>();
		try(Scanner sc = new Scanner(System.in)){
			
			boolean exit = false;
			
			while(!exit) {
				System.out.println("Choose an operation: \n1)Show the contents of linked list\n"
						+ "2)Insert the data in the linked list\n3)Check how many elements are there in the linked list\n"
						+ "4)Check to see if linked list is empty \n "
						+ "5)Insert at first\n6)Insert at Last\n 7)Insert at given position\n"
						+ "8)Delete at first\n9)Delete at Last \n 10)Delete at given position\n"
						+ "0)Exit");
			try {
				switch(sc.nextInt()) {
				case 1: lists.display();  
					break;
				case 2: System.out.println("Enter Element to insert"); 
					lists.insert(sc.nextDouble());
					break;
				case 3: 
					System.out.println("Total element in Linked list is: "+lists.totalElements());
					break;
				case 4: System.out.println("Is list empty : "+lists.isEmpty());
					break;
				case 5:System.out.println("enter element ");
					lists.insertAtFirst(sc.nextDouble());
					break;
				case 6:System.out.println("enter element ");
					lists.insertLast(sc.nextDouble());
					break;
				case 7:System.out.println("enter element and postion");
				lists.insert(sc.nextDouble(), sc.nextInt());
					break;
				case 8:System.out.println("delete element is : "+lists.deleteAtFirst());
					break;
				case 9:System.out.println("delete element is : "+lists.deleteAtLast());
					break;
				case 10:System.out.println("enter position to be deleted");
					System.out.println("delete element is : "+lists.deleteAtPos(sc.nextInt()));
					break;
				case 0: System.out.println("Thank You!!!");
				          exit = true;
					break;
					
				}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				sc.nextLine();
			}
		}

	}

	}

}
