import java.util.*;
public class Main
{
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(); //size of array
		int arr[] = new int[n];
                int i=0;
                for(i=0;i<n;i++)
                    arr[i]=scan.nextInt();
		int k = scan.nextInt(); //size of group
		int j=0;
		for(i=0;i<n;i=i+k)// n/k are no of groups to be reversed..thus every iteration reverses one group
		{
			if(i+k<=n) // to check if a group of size k is available to be reversed
			{
			      for(j=0;j<k/2;j++)
			      {
                                int temp = arr[j+i];
                                arr[j+i]=arr[k-1-j+i];
                                arr[k-1-j+i]=temp;
			      }
			}
			else // for remaining elements after reversing groups of elements
			{
                              for(j=0;j<(n-i)/2;j++)
               		      {
				int temp = arr[i+j];
				arr[j+i]=arr[n-1-j];
				arr[n-1-j]=temp;
                              }
			}
		}
		for(i=0;i<n;i++)
		{
			System.out.print(arr[i]+" ");
		}
	}
}