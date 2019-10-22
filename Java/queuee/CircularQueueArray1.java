import java.util.*;
class CircularQueueArray1{
	static int r=-1;
	static int f=-1;
	static int queue[]=new int[5];
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		boolean b=true;
		while(b){
			System.out.println("enter the function to perform 1:to insert 2:to delete 3:to print ");
		int z=s.nextInt();
			switch(z)
		{
			case 1:{
				int a=s.nextInt();
				insertion(queue,a);
				break;
			}
			case 2:{
				deletion(queue);
				break;
			}
			case 3:{
				print(queue);
				break;
			}
			default:{
				System.out.println("GOOD BYE");
				b=false;
			break;
			}

		}
	}	
	}
	static void insertion(int queue[],int a){
		if(overflow()){
			System.out.println("cant insert");
		}
		else{
			 if (f== -1)
    { 
        f= r = 0; 
        queue[r] = a; 
    } 
  
    else if (r== 4 && f!= 0) 
    { 
        r= 0; 
        queue[r] = a; 
    } 
  
    else
    { 
        r++; 
        queue[r] = a; 
    } 

		}		
	}
	static void deletion(int queue[]){
		if(underflow()){
			System.out.println("cant delete");
		}
		else{
			queue[f] = -1; 
    if (f == r) 
    { 
        f= -1; 
        r= -1; 
    } 
    else if (f== 4) 
        f = 0; 
    else
        f++; 
			
		}
	}
	static void print(int queue[]){
		if (f == -1) 
    { 
        System.out.println("Queue is Empty"); 
        return; 
    } 
    System.out.println("Elements in Circular Queue are: "); 
    if (r >= f) 
    { 
        for (int i = f; i <= r; i++) 
            System.out.println(queue[i]); 
    } 
    else
    { 
        for (int i = f; i < 5; i++) 
            System.out.println( queue[i]); 
  
        for (int i = 0; i <= r; i++) 
            System.out.println( queue[i]); 
    }
	}
	static boolean overflow(){
		if ((f== 0 && r == 4) || 
            (r== (f-1)%(4))){ 
        
        return true; 
    }
    else{
    	return false;
    }
	}
	static boolean underflow(){
		
    if (f == -1) 
    { 
        return true; 
    }
		
		else{
			return false;
		}
	}

}