package CodeStudy.Baekjoon;
import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;

/*
 Input
 string of (,),[,]
 
 Output
 Caculated value
 */

public class valueOfbracket_2504 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String bracket = sc.nextLine();
		
		Stack<String> stack = new Stack<>();
		
		int ans = 0;
		int temp = 1;
		for(int idx = 0;idx<bracket.length();idx++) {
			String curr_str = Character.toString(bracket.charAt(idx));
			if(curr_str.equals("(")) {
				stack.add(curr_str);
				temp = temp*2;
			}
			else if(curr_str.equals("[")) {
				stack.add(curr_str);
				temp = temp*3;
			}
			else if(curr_str.equals(")")) {
				if(stack.isEmpty() || !stack.peek().equals("(")) {
					System.out.println(0);
					return;
				}
				else if (Character.toString(bracket.charAt(idx-1)).equals("(")) {
					ans = ans+temp;
				}
				stack.pop();
				temp = (int) temp/2;
			}
			else if(curr_str.equals("]")) {
				if(stack.isEmpty() || !stack.peek().equals("[")) {
					System.out.println(0);
					return;
				}
				else if (Character.toString(bracket.charAt(idx-1)).equals("[")) {
					ans = ans+temp;
				}
				stack.pop();
				temp = (int) temp/3;
			}
		}
		
		if(!stack.isEmpty())	System.out.println(0);
		else System.out.println(ans);
	}

}