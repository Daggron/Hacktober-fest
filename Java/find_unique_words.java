import java.util.*;
class Second {
   public static void main(String[] args) {

       Scanner sc= new Scanner(System.in);
       String input = sc.nextLine();
       input=" "+input+" ";
       String[] words = input.split(" ");
           
       Set<String> ll = new HashSet<String>(Arrays.asList(words));
       Iterator itr = ll.iterator();
       String ans="";
       while(itr.hasNext()){
           ans=ans+itr.next()+" ";
       }
       System.out.println(ans);

   }
}
