import java.util.*;
import java.lang.*;
public class Main
{
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String str=scanner.next();
		int n=str.length();
		Stack<Character> st1=new Stack<Character>();
		Stack<Character> st2=new Stack<Character>();
		for(int i=0;i<n;i++){
		    if(str.charAt(i)=='['){
		        st1.push('[');
		    }else if(!st1.empty()&&str.charAt(i)==']'&&st1.peek()=='['){
		        st1.pop();
		    }else{
		        st2.push(']');
		    }
		}
		int count=0;
		if(st1.empty()){
		    while(!st2.empty()){
		        count++;
		        st2.pop();   
		    }
		}else if(st2.empty()){
		    while(!st1.empty()){
		        count++;
		        st1.pop();
		    }
		}
		int res=count%2==0?count/2:-1;
		System.out.println(res);
	}
}
