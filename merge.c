#include<stdio.h>
#include<conio.h>
void input(int a[5],int n)
{
	int i;
	for(i=0; i<n; i++)
	{
		scanf("%d",&a[i]);
	}
}

void output(int a[5],int n)
{
	int i;
	for(i=0; i<n; i++)
	{
		printf("the element %d is = %d\n",i,a[i]);
	}
}
void merge(int a[5],int lb, int mid ,int ub)
{
    int i,j,k;
    int b[5];
    i=lb;
    j=mid+1;
    k=lb;
    while(i<=mid && j<=ub)
    {
        if(a[i]<=a[j])
        {
            b[k]=a[i];
            i++;
        }
        else
        {
            b[k]=a[j];
            j++;
        }
        k++;
    }
    if(i>mid)
    {
        while(j<=ub)
        {
            b[k]=a[j];
            j++;
            k++;
        }
    }
    else
    {
        while(i<=mid)
        {
            b[k]=a[j];
            i++;
            k++;
        }
    }
    for(k=lb; k<=ub; k++)
    {
        a[k]=b[k];
    }    
}
void mergesort(int a[5], int lb, int ub)
{
    int mid;
    if(lb<ub)
    {
        mid=(lb+ub)/2;
        mergesort(a,lb,mid);
        mergesort(a,mid+1,ub);
        merge(a,lb,mid,ub);
    }
}
int main()
{
	int a[5],n,lb=0,ub=n-1;
	printf("size of array element\n");
	scanf("%d",&n);
	printf("enter array's element\n");
	input(a,n);
    mergesort(a,lb,ub);
	output(a,n);
	return 0;
}
