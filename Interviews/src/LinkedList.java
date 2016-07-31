import java.util.Arrays;
import java.util.Stack;

public class LinkedList {
	   Node head;  // head of list
	   int size = 0;
	   class Node {
	      int data;
	      Node next;
	      Node (int d) {
	         data = d;
	         next = null;
	      }
	   } // Node
	    
	   void print() {
	      Node temp = head;
	      while (temp != null) {
	         System.out.print(temp.data + " ");
	         temp = temp.next;
	      }
	      System.out.println();
	   } //print()

	   void insert(int data) {
		   if (!exist(data)){
			   Node node = new Node(data);
			   node.next = head;
			   head = node;
			   size++;
		   }
	   } // insert() without duplicate data

	   void reverse () {
		   System.out.print("reverse() = ");		   
//		   int[] array = new int[size];
//		   Node pointer = head;
//		   int count = 0;
//		   while(pointer != null) {
//			   array[count] = pointer.data;
//			   count++;
//			   pointer = pointer.next;
//		   }
//		   pointer = head;
//		   while(pointer != null) {
//			   pointer.data = array[count - 1];
//			   count--;
//			   pointer = pointer.next;
//		   }
		   
		   Node p = null;
		   Node c = head;
		   Node n = null;
		   while(c.next != null) {
			   n = c.next;
			   c.next = p;
			   p = c;
			   c = n;
			   n = n.next;
		   }
		   c.next = p;
		   head = c;
		   
	   } // reverse

	   void remove (int data) {
		   System.out.print ("remove(" + data + ") = ");		   
		   // Enter code here
		   if(exist(data)) {
			   Node current = head;
			   if(current.data == data) {
				   head = head.next;
				   current = null;
				   size--;
			   } else {
				   while(current.next != null) {
					   if(current.next.data == data) {
						   Node next = current.next.next;
						   current.next = null;
						   current.next = next;
						   size--;
						   break;
					   }
					   current = current.next;
				   }
			   }
		   }
	   } // remove
	   
	   void removeNth (int data) {
		   System.out.print ("removeNth(" + data + ") = ");		   
		   if(size >= data && data > 0) {
			   Node current = head;
			   if(data == 1) {
				   head = head.next;
				   current = null;
				   size--;
			   } else {
				   for(int index = 2; index < data; index++) {
					   current = current.next;
				   }
				   Node next = current.next.next;
				   current.next = null;
				   current.next = next;
				   size--;
			   }
		   }	   
	   } // remove

	   boolean exist(int data) {
	     Node n = head;
	     while (n != null) {
	       if (n.data == data)
	         return true;
	       n = n.next;
	     } // while
	     return false;
	   } //exist() return true when data exists in list
	   
	   boolean exist(Node head, int data) {
		     Node n = head;
		     while (n != null) {
		       if (n.data == data)
		         return true;
		       n = n.next;
		     } // while
		     return false;
	   } //exist() return true when data exists in list

	   void sort(){
		   System.out.print("sort() = ");		   
		   int[] array = new int[size];
		   Node pointer = head;
		   int index = 0;
		   while(pointer != null) {
			   array[index] = pointer.data;
			   index++;
			   pointer = pointer.next;
		   }
		   pointer = head;
		   Arrays.sort(array);
		   for(int i = 0; i < array.length; i++) {
			   pointer.data = array[i];
			   pointer = pointer.next;
		   }
	   }
	   
	   void bubble() {
		   System.out.print("bubble() = ");		   
			boolean flag = true;   // set flag to true to begin first pass
			
			while(flag) {
				Node current = head;
				Node next = head.next;
				flag = false;    //set flag to false awaiting a possible swap
			    while(next != null) {
			    	if(current.data > next.data) {
			    		int temp = current.data;
			    		current.data = next.data;
			        	next.data = temp;
			        	flag = true;
			        }
			        next = next.next;
			        current = current.next;
			    }
			}
	   }
	   

	 
	    /* Function to get Union of 2 Linked Lists */
	   void getUnion(Node head1, Node head2)
	   {
		 //Enter code here
		   head = head1;
		   Node n2 = head2;
		   while(n2 != null) {
			   Node n1 = head;
			   boolean add = true;
			   while(n1 != null) {
				   if(n1.data == n2.data) {
					   add = false;
					   break;
				   }				   
				   n1 = n1.next;
			   }
			   if(add) {
				  Node node = new Node(n2.data);
			      node.next = head;
			      head = node;
			      size++;
			   }
			   n2 = n2.next;
		   }
	   }
	 
	   void getIntersection(Node head1, Node head2)
	   {
//		   Node list1 = head1;
//		   Node list2 = head2;
//
//		   while(list1 != null) {
//			   while(list2 != null) {
//				   if(list1.data == list2.data) {
//					   Node newHead = new Node(list2.data);
//					   newHead.next = head;
//					   head = newHead;
//					   size++;
//				   }
//				   list2 = list2.next;
//			   }
//			   list2 = head2;
//			   list1 = list1.next;
//		   }
		   Node list1 = head1;
		   Node list2 = head2;
		   while(list2 != null) {
			   if(exist(list1, list2.data)) {
				   insert(list2.data);
			   }
			   list2 = list2.next;
		   }
	   }
	  

	    /* Drier program to test above functions */
	   public static void main(String args[])
	   {
	      LinkedList llist1 = new LinkedList();
	      LinkedList llist2 = new LinkedList();
	      LinkedList union = new LinkedList();
	      LinkedList intersection = new LinkedList();
	   
	      int length1 = 10; // (int)(Math.random()*20+1);
	      int length2 = 5; // (int)(Math.random()*20+1);

	      for (int i = 0; i < length1; i++) {
	         llist1.insert(Random.randomNumber(1, 5));
	      } 

	      for (int i = 0; i < length2; i++) {
	         llist2.insert((int)(Math.random()*6+1));
	      } 
	      
	      llist1.print();
	      llist1.reverse();
	      llist1.print();
	      llist2.print();
	      llist1.sort();
	      llist1.print();	      
	      // llist2.print();
	      llist2.bubble();
	      llist2.print();
	      //llist1.remove(1);
	      //llist1.print();
	      //llist1.removeNth(2);
	      //llist1.print();
	      
	      //llist1.remove(Random.randomNumber(1, 5));
	      //llist1.print();
	      //llist1.removeNth(Random.randomNumber(1, 5));
	      //llist1.print();
   
	   
	      intersection.getIntersection(llist1.head, llist2.head);
	      System.out.println("Intersection List is");
	      intersection.print();
	   
	
	      union.getUnion(llist1.head, llist2.head);
	      System.out.println("Union List is");
	      union.print();
/*	   
	      System.out.println("First List is");
	      llist1.print();
	   
	      System.out.println("Second List is");
	      llist2.print();
	   
	      
	      System.out.println("Union List is");
	      union.print();
*/
	      

	   }

}
