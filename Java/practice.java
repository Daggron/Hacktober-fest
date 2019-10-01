import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class Main extends JFrame implements ActionListener
{
    Menu m1;
   MenuBar m;
    MenuItem m11,m12,m13;
    JButton b1,b2;
    Main()
    {
        m1=new Menu("File");
    m=new MenuBar();
    m11=new MenuItem("new");
    m12=new MenuItem("hel");
    m13=new MenuItem("hell");
    m1.add(m11);
    m1.add(m12);
    m1.add(m13);
    m.add(m1);
    setMenuBar(m);
    b1=new JButton("1");
    b2=new JButton("2");
    setLayout(null);
    b1.setBounds(50,50,50,50);
    b2.setBounds(100,50,50,50);
    add(b1);
    add(b2);
    }
    public void actionPerformed(ActionEvent e)
    {
         String str13 = (String) e.getActionCommand();
            if (str13.equals("new")) {
                sub s = new sub();
                s.setComponents();
                s.setVisible(true);
                s.setSize(700, 700);
                s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
    }
    public void setComponents()
    {

     m11.addActionListener(new Main());   
    }
    public static void main(String args[])
    {
        Main m=new Main();
        
        m.setComponents();
        m.setVisible(true);
        m.setSize(600,600);
        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
class sub extends Main
{
    JButton b3,b4;
    sub()
    {
    }
    public void setComponents()
    {
    b3=new JButton("3");
    b4=new JButton("4");
    setLayout(null);
    b3.setBounds(150,50,50,50);
    b4.setBounds(200,50,50,50);
    add(b3);
    add(b4);
    }
}






