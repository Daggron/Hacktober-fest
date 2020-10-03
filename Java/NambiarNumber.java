import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		int i=0,sum=0;
		String str1="";
		for(i=0;i<str.length();) {
			int n = str.charAt(i++)-48;
			sum = n;
			if(n%2==0){
			    
			    while(((sum%2)==0) && i < str.length())
			    {
			           int m =str.charAt(i)-48;
			           sum=sum+m;
			           i++;
			           
			    }
			    str1 += String.valueOf(sum);
			    sum=0;
			}
			else{
			    while(((sum%2)!=0) && i < str.length())
			    {
			           int m =str.charAt(i)-48;
			           sum=sum+m;
			           i++;
			           
			    }
			    str1 += String.valueOf(sum);
			    sum=0;
			}
			
		}
		System.out.println(str1);
	}
}
