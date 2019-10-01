import java.util.*;

public class Main
{
    public static void main(String args[])
    {
        ArrayList<Integer> a=new ArrayList<Integer>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);
        int min=434343,max=-32322;
        for(int i=0;i<a.size();i++)
        {
            if(a.get(i)>max)
                max=a.get(i);
            if(a.get(i)<min)
                min=a.get(i);
        }
        for(int i=0;i<a.size();i++)
        {
            if(a.get(i)<max&&a.get(i)>min)
                min=a.get(i);
        }
        System.out.println(min);
    }
}
