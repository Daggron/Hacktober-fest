import java.util.*;
class CircularDQueueArray{
	static int r=-1;
	static int f=-1;
	static int queue[]=new int[5];
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		boolean b=true;
		while(b){
			System.out.println("enter the function to perform \n1:to insert in front\n2:to insert in back\n3:to delete in front \n4:to delete in back \n5:to print ");
		int z=s.nextInt();
			switch(z)
		{
			case 1:{
				int a=s.nextInt();
				Finsertion(queue,a);
				break;
			}
			case 2:{
				int c=s.nextInt();
				Rinsertion(queue,c);
				break;
			}
			case 3:{
				Fdeletion(queue);
				break;
			}
			case 4:{
				Rdeletion(queue);
				break;
			}
			case 5:{
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
	static void Finsertion(int queue[],int a){
		if(overflow()){
			System.out.println("cant insert");
		}
		else{
			 if (f== -1){ 
            f= 0; 
            r = 0; 
        }
        else if (f== 0) {
            f= 4; 
        }
   
        else{
                    f = f-1; 
        queue[f] =a ;
		}		
	}
}
	static void Rinsertion(int queue[],int c){
		if(overflow()){
			System.out.println("cant insert");
		}
		else{
			 if (f== -1){ 
            f= 0; 
            r = 0; 
        }
        else if (r==4) {
            r=0; 
        }
   
        else{
                    r=r+1; 
        queue[r] =c ;
		}		
	}
	}
	static void Fdeletion(int queue[]){
		if(underflow()){
			System.out.println("cant delete");
		}
		else{ 
    if (f == r) 
    { 
        f= -1; 
        r= -1; 
    } 
    else if (f== 4) 
        f = 0; 
    else
        f=f+1; 
			
		}
	}
	static void Rdeletion(int queue[]){
		if(underflow()){
			System.out.println("cant delete");
		}
		else{ 
    if (f == r) 
    { 
        f= -1; 
        r= -1; 
    } 
    else if (r==0) 
        r=4; 
    else
        r=r-1; 
			
		}
	}
	static void print(int queue[]){
		if (f == -1) 
    { 
        System.out.println("Queue is Empty"); 
        return; 
    } 
    System.out.println("Elements in Circular DQueue are: "); 
    if (r >= f) 
    { 
        for (int i = 0; i <= r; i++) 
            System.out.println(queue[i]); 
    }
	    else{ 
	        for (int i = f; i < 5; i++){
	            System.out.println( queue[i]); 
	        }
	        for (int i = 0; i <= r; i++){
	            System.out.println( queue[i]); 
	        }
	        for (int i = f; i <= r; i++){
	            System.out.println( queue[i]); 
	        }
	    }
 		for (int i = 0; i <5; i++){ 
        	System.out.println( queue[i]); 
		}
}
	static boolean overflow(){
		if ((f== 0 && r == 4) || (f==r+1)){ 
       		return true; 
    	}
    else if(f==r+1){
        return true; 
    }
    else{
    	return false;
    }
	}
	static boolean underflow(){
		
    if (f == -1) { 
        return true; 
    }
		
	else{
		return false;
	}
}

}