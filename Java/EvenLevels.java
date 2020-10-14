//Even Levels of  a Binary Tree
import java.util.*;   
public class EvenLevels
{ 
    static class Node
{ 
    int data; 
    Node left, right; 
    public Node(int item) 
    { 
        data = item; 
        left = right = null; 
    } 
} ;
    Node root; 
  
    public EvenLevels() 
    { 
        root = null; 
    }
    void printLevelOrder(Node root) 
    { 
        int h = height(root); 
        int i; 
        for (i=1; i<=h; i=i+2) 
            printGivenLevel(root, i); 
    }
    int height(Node root) 
    { 
        if (root == null) 
           return 0; 
        else
        { 

            int lheight = height(root.left); 
            int rheight = height(root.right);
            if (lheight >= rheight) 
                return(lheight+1); 
            else return(rheight+1);  
        } 
    }
    void printGivenLevel (Node root ,int level) 
    { 
        if (root == null) 
            return; 
        if (level == 1) 
            System.out.print(root.data + " "); 
        else if (level > 1) 
        { 
            printGivenLevel(root.left, level-1); 
            printGivenLevel(root.right, level-1); 
        } 
    } 
     Node insert(Node root, int data)  
   {  
    Node node= new Node(data);
    if(root==null){
        return node;
    } 
    Node parent=null, current = root;
    while(current!=null){
        parent=current;
        if(current.data>=data){
            current=current.left;
        }
        else{
            current=current.right;
        }
    }
    if(parent.data>=data){
        parent.left=node;
    }
    else{
        parent.right=node;
    }
    return root;
    }
public static void main(String args[])  
{

    EvenLevels tree=new EvenLevels();
    Node root = null;  
    root = tree.insert(root, 50);  
    tree.insert(root, 30);  
    tree.insert(root, 20);  
    tree.insert(root, 40);  
    tree.insert(root, 70);  
    tree.insert(root, 60);  
    tree.insert(root, 80);    
    tree.printLevelOrder(root);  
    } 
} 
