package com.pra.java.datastruct.stack.examples;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;
/**
 * 
 * 
 */
public class ExpressionEvaluationStack {

	private static Stack<String> operationsStack = new Stack<String>();
	private static Stack<Double> valuesStack = new Stack<Double>();
	
	public static void main(String[] args) {
		  Scanner scan = new Scanner(System.in);
		  String strOriginal = scan.nextLine().trim();
		  String str = strOriginal.replaceAll("\\s+","");
		  System.out.println(str);
		  if (Pattern.compile("[A-Za-z]").matcher(str).find()) {
			    System.err.println("alphabets in the expression, quit");
			} else if (Pattern.compile("[^-+*/()0-9]").matcher(str).find()) {
				System.err.println("other chars in the expression, quit");
			}
		  
		  int leftCount =StringUtilities.countCharInString(str, '(');
		  int rightCount =StringUtilities.countCharInString(str, ')');
		  if(leftCount== rightCount){
			  char  ch[] = str.toCharArray();
			  for (int i = 0; i < ch.length; i++) {
				  
				if(ch[i]=='+' ||ch[i]=='-' ||ch[i]=='*' ||ch[i]=='/' ) {
					operationsStack.push(Character.toString(ch[i]));
					
				}else if (ch[i] >= '0' && ch[i] <= '9') {
					valuesStack.push(Double.valueOf(Character.toString(ch[i])));
				}
				else if(ch[i]==')') {
					String op = operationsStack.pop();
					double v = Double.valueOf(valuesStack.pop());
					if (op.equals("+")) v = Double.valueOf(valuesStack.pop()) + v;
					else if (op.equals("-")) v =Double.valueOf(valuesStack.pop()) - v;
					else if (op.equals("*")) v =Double.valueOf(valuesStack.pop()) * v;
					else if (op.equals("/")) v = Double.valueOf(valuesStack.pop()) / v;
					valuesStack.push(v);
				}
			}
			  System.out.println(valuesStack.pop());
		  }else {
			  System.out.println("wrong expression");
		  }
	}
	
	   
	
	
}

class StringUtilities {
	static int countCharInString(String str,char ch) {
		char c [] = str.toCharArray();
		int count=0;
		for (int i = 0; i < c.length; i++) {
			if(c[i]==ch) {
				count++;
			}
		}
		return count;
	}
	
	
}