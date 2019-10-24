package com.pra.java.datastruct.queue;

import java.util.Scanner;

public class Driver {
	
	 public static void main(String[] args)
	    {
	        Scanner scan = new Scanner(System.in);
	 
	        System.out.println("Array Queue program \n");
	        System.out.println("Enter Size of Queue ");
	        int n = scan.nextInt();
	        /* creating object of class arrayQueue */
	        BaseQueue q = new BaseQueue<String>(n);        
	        /* Perform Queue Operations */        
	        char ch;
	        do{
	            System.out.println("\nQueue Operations");
	            System.out.println("1. insert");
	            System.out.println("2. peek");
	            System.out.println("3. check empty");
	            System.out.println("4. check full");
	            System.out.println("5. size");
	            int choice = scan.nextInt();
	            switch (choice)
	            {
	            case 1 : 
	                System.out.println("Enter String element to insert");
	                try
	                {
	                    q.add( scan.next() );
	                }
	                catch(Exception e)
	                {
	                    System.out.println("Error : " +e.getMessage());
	                }                         
	                break;                         
	            case 2 : 
	                try
	                {
	                    System.out.println("Removed Element = "+q.remove());
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
	            System.out.println("\nDo you want to continue (Type y or n) \n");
	            ch = scan.next().charAt(0);
	 
	        } while (ch == 'Y'|| ch == 'y');                                                        
	    }   

}
