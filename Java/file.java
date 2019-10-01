import java.util.*;
import java.io.*;

class main
{
    public static void main(String args[])
    {
         File data = new File("demo.txt");  
        FileInputStream  file =null;
        try
        {
        file= new FileInputStream(data);  
        LineNumberInputStream l=new LineNumberInputStream(file);
        System.out.print(l.getLineNumber()+1);
        int n;
        while((n=l.read())!=-1)
        {
            System.out.print((char)n);
            if((char)n=='\n')
            {
                System.out.print(l.getLineNumber()+1);
       
            }
        }
        }
        catch(Exception e)
        {}
    }
}
