import java.util.*;
class Node{
    int key;
    Node right,left;
    public Node(int item){
        key = item; 
        left = right = null; 
    }
}
class PostOrder 
	{ 
	    Node root; 
	  
	    PostOrder() 
	    { 
	        root = null; 
	    } 
	   
	    void printPostorder(Node node) 
	    { 
	        if (node == null) 
	            return; 
	        printPostorder(node.left);
	        printPostorder(node.right); 
	  
	        System.out.print(node.key + " "); 
	    } 
	    
		void printPostorder()    
		{     
			printPostorder(root);   
		} 
	   // Driver method 
	    public static void main(String[] args) 
	    { 
	        PostOrder tree = new PostOrder(); 
	        tree.root = new Node(1); 
	        tree.root.left = new Node(2); 
	        tree.root.right = new Node(3); 
	        tree.root.left.left = new Node(4); 
	        tree.root.left.right = new Node(5); 
	       System.out.println("\nPostorder traversal of binary tree is "); 
	        tree.printPostorder(); 
	  
	        
	    }
	}


