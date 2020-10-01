import java.util.*;
class gre{
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
int a[]=new int[n];
for(int i=0;i<n;i++){
    a[i]=sc.nextInt();

}
Stack<Integer> st=new Stack<>();


for(int i: a){
    if(st.isEmpty()){
        st.add(i);
    }
    else{ while(!st.isEmpty()&&st.peek()<i){
     System.out.println(st.pop()+"--->"+i);
    }
    st.push(i);
}
}
while(!st.isEmpty()){
System.out.println(st.pop()+"---"+"none");


}




}







}


