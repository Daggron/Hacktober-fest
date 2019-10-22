import java.util.*;
class QueueArray{
	static int r=-1;
	static int f=-1;
	static int queue[]=new int[5];
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		boolean b=true;
		while(b){
			System.out.println("enter the function to perform 1:to d=insert 2:to delete 3:to print ");
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
			if(r==-1&&f==-1)
			{
				r++;
				f++;
				queue[r]=a;
			}
			else{
				r++;
				queue[r]=a;
			}
		}		
	}
	static void deletion(int queue[]){
		if(underflow()){
			System.out.println("cant delete");
		}
		else{
			f++;
		}

	}
	static void print(int queue[]){
		for(int i=f;i<=r;i++){
			System.out.println(queue[i]);
		}
	}
	static boolean overflow(){
		if(r>=4){
			return true;
		}
		else{
			return false;
		}
	}
	static boolean underflow(){
		if(r==-1&&f==-1){
			return true;
		}
		else{
			return false;
		}
	}

}