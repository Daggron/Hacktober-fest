
import java.util.Scanner;
import java.util.Stack;

public class DuplicateParenthesis {


	/*
	 * Create a stack.
	 * 
	 * Iterate over the string
	 * 
	 * if(char != ')') {
	 * 
	 * s.push(char);
	 * 
	 * 
	 * } else {
	 * 
	 * pop the top value
	 * 
	 * count = 0;
	 * 
	 * loop over the stack till we encounter '('
	 * 
	 * keep poping up and increase count;
	 * 
	 * 
	 * check if count < 1 duplicates
	 * 
	 * else { no duplicates
	 */
	

	/*
	 * Time Complexity - O(n)
	 * Space Complexity - O(n)
	 */
	
	public static String findDuplicateParenthesis(String inputString) {

		Stack<Character> s = new Stack<Character>();
		for(int i = 0; i < inputString.length(); i++) {
			if(inputString.charAt(i) != ')') {
				s.push(inputString.charAt(i));
			} else {
				Character top = s.pop();
				int count = 0;
				
				while(top != '(') {
					top = s.peek();
					s.pop();
					count++;
				}
				
				if(count < 1) {
					return "Input String contains Duplicate Parenthesis";
				}
			}
		}
		return "Input String does not contain Duplicate Parenthesis";
	}


	public static void main(String[] args) {
		DuplicateParenthesis obj = new DuplicateParenthesis();
		String inputString = new String();
		Scanner in = new Scanner(System.in);
		inputString = in.nextLine();
		System.out.println(obj.findDuplicateParenthesis(inputString));

	}
}
