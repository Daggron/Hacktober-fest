import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name of file to be copied");
        String input = sc.next();
        System.out.println("Enter name to be kept of copied file");
        String output = sc.next();
        sc.close();   
        byte[] data = new byte[1000];
        try{
            FileInputStream inFile = new FileInputStream(input);
            FileOutputStream outFile = new FileOutputStream(output);
            int length=inFile.read(data);
            outFile.write(data,0,length);
            System.out.println("The "+input+" file is copied to "+output+".");
            inFile.close();
            outFile.close();
          }
          catch (Exception e) {
            e.getStackTrace();
          }

    }
}
