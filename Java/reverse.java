import java.util.*;
class main
{
    public static void main(String args[])
    {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        Stack<Integer> s=new Stack<Integer>();
        int digit,count=0;
        while(n!=0)
        {
            digit=n%10;
            s.push(digit);
            n=n/10;
        }
        int new_number=0;
        while(s.empty()!=true)
        {
            new_number=new_number+(int)Math.pow(10,count)*s.pop();
            count++;
        }
        System.out.println(new_number);
    }
}
