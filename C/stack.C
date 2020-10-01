#include<stdio.h>
int main()
{
	int a[10],n,x,y,z,q,i,j,count=0;
	int m;
	printf("Enter No. of elements in array\n");
	scanf("%d",&n);
	printf("Enter %d elements\n",n);
	for(q=0; q<n; q++)
	{
		scanf("%d",&a[q]);
	}
	count = n;
	x=q;
	do
	{

	printf("Press 1 to add element\n");
    printf("Press 2 to remove element\n");
    scanf("%d",&y);

    switch(y)
    {
    	case 2:
    		if(count==0)
    		printf("Array is Empty\nCannot be removed\n");
    		else
    		{
    			printf("New Array is : ");
    			for(i=0; i<count-1; i++)
    			{
    				printf("%d ",a[i]);
				}
				count--;
			}
			break;

		case 1:
			if(count>9)
			printf("Cannot be added\nArray is full");
			else
			{

			printf("Enter element to be added\n");
            scanf("%d",&z);
			a[count]=z;
			printf("New Array is : ");
			for(i=0; i<=count; i++)
			{
				printf("%d ",a[i]);
			}
			count++;
					}
					break;
}
	printf("\nPress 0 to further edit\n");
	scanf("%d",&m);

 }

 while(m==0);
 printf("Thanks!!");
}
