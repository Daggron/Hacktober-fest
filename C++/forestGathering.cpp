#include <iostream>
using namespace std;

int check(long long int mid,long long int n,long long int w,long long int l,long long int* h,long long int* r){
    long long int sum=0;
    long long int num=0;
    for(long long int i=0;i<n;i++){
        num=h[i]+(r[i]*mid);
        if(num>=l){
            sum+=num;
            if(sum>=w)
                return 1;
        }
    }
    return 0;
}


int main() {
    int n;
	long long int w,l;
	cin>>n;
	cin>>w;
	cin>>l;
	long long int h[n];
	long long int r[n];
	for(long long int i=0;i<n;i++){
	    cin>>h[i];
	    cin>>r[i];
	}
	long long int l1=0;
	long long int r1=1000000000000000000;
	long long int mid=0;

	
	while(l1<r1){
	    mid=(l1+r1)/2;
	    int n12=check(mid,n,w,l,h,r);
	    if(n12==1){
	        r1=mid;
	    }else{
	        l1=mid+1;
	    }
	}
	cout<<l1;
	return 0;
}

