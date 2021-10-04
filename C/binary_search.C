#include <stdio.h>
int main()
{
    int search, mid, beg, end, i ,j ,n ,a[10] ,temp;
    printf("Enter the number of the elements.\n");
    scanf("%d", &n);
    printf("Enter the elements of the array.\n");
    for(i=0;i<n;i++)
    {
        scanf("%d", &a[i]);
    }
    //sort the elements
    for(i=0;i<n;i++)
    {
        for(j=i+1;j<n;j++)
        {
            if(a[i]>a[j])
            {
                temp=a[i];
                a[i]=a[j];
                a[j]=temp;
            }
        }
    }
    for(i=0;i<n;i++)
    {
        printf("a[%d]=%d\n",i, a[i]);
    }
    printf("Enter element you want to search.\n");
    scanf("%d", &search);
    beg=0;
    end=n-1;
    //find middle element
    mid=(beg+end)/2;
    while(beg<=end)
    {
        if(a[mid]>search)
        {
            end=mid-1;
        }
        else if(search==a[mid])
        {
            printf("Element %d found at a[%d]", search,mid);
            break;
        }
        else
            beg=mid+1;

        mid=(beg+end)/2;
    }

    if(beg>end)
        printf("Element not found.\n");
    return 0;
}
