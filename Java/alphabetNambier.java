import java.util.Scanner;

public class alphabetnambiar {
	static String nambiar(String str, int i)
	{
		if(i>=str.length())
			return "";
		int alphabet = str.charAt(i);
		int f = -1;
		if(alphabet=='a'||alphabet=='e'||alphabet=='i'||alphabet=='o'||alphabet=='u')
		{
			f=0;
		}
		int sumd = 0;
		while(i<str.length())
		{
			alphabet = str.charAt(i);
			sumd = sumd + str.charAt(i)-'0';
			int f1 = -1;
			if(alphabet=='a'||alphabet=='e'||alphabet=='i'||alphabet=='o'||alphabet=='u')
			{
				f=0;
			}
			if(f!=f1)
				break;
			i++;
		}
		return (sumd+nambiar(str,i+1));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		System.out.println(nambiar(str,0));
		
}
}
