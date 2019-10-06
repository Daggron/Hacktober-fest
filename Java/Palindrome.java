import java.util.*;
public class Lff {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r, sum = 0, temp;
fun();
    };

          static void fun(){
              Scanner sc = new Scanner(System.in);
              int r, sum = 0, temp;
            int n;
            n = sc.nextInt();
            String s=""+n;
            if (s.length()!=5) {
                System.out.println("Please enter a new value");
                fun();
            } else {
                temp = n;
                while (n > 0) {
                    r = n % 10;
                    sum = (sum * 10) + r;
                    n = n / 10;
                }

            if (temp == sum)
                System.out.println("palindrome number ");
            else
                System.out.println("not a palindrome");
        }
    }
}
