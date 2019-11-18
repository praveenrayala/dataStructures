package com.pra.java.datastruct.queue;

import java.util.Scanner;

public class NodeDriver {
	
	 public static void main(String[] args)
	    {
	        Scanner scan = new Scanner(System.in);
	 
	        System.out.println("Linked list Queue program \n");
	        /* creating object of class arrayQueue */
	        NodeQueue q = new NodeQueue<String>();        
	        /* Perform Queue Operations */        
	        char ch;
	        do{
	            System.out.println("\n Queue Operations");
	            System.out.println("1. enqueue");
	            System.out.println("2. dequeue");
	            System.out.println("3. check empty");
	            System.out.println("4. check full");
	            System.out.println("5. size");
	            int choice = scan.nextInt();
	            switch (choice)
	            {
	            case 1 : 
	                System.out.println("\n Enter name to insert");
	                try
	                {
	                    q.add( scan.next() );
	                }
	                catch(Exception e)
	                {
	                    System.out.println("\n Error : " +e.getMessage());
	                }                         
	                break;                         
	            case 2 : 
	                try
	                {
	                    System.out.println("\n Removed Element = "+q.remove());
	                }
	                catch(Exception e)
	                {
	                    System.out.println("Error : " +e.getMessage());
	                }
	                break;                         
	            case 3 : 
	                try
	                {
	                    System.out.println("Empty status = "+q.isEmpty());
	                }
	                catch(Exception e)
	                {
	                    System.out.println("Error : "+e.getMessage());
	                }
	                break;                            
	            case 4 : 
	                System.out.println("Full status = "+q.isFull());
	                break;                
	            case 5 : 
	                System.out.println("Size = "+ q.size());
	                break;                         
	            default : System.out.println("Wrong Entry \n ");
	                break;
	            }
	            /* display Queue */
	            q.printDataStructure();            
	            System.out.println("\nDo you want to continue (Type y or n) \n \n");
	            ch = scan.next().charAt(0);
	 
	        } while (ch == 'Y'|| ch == 'y');                                                        
	    }   

}
