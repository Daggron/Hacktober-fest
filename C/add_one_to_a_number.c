int* plusOne(int* A, int n1, int *len1) {
    int carry = 0,i;
    A[n1-1] += 1;
    for(i=n1-1;i>=0;i--){
        if(A[i]%10 == 0 && A[i]!=0){
            carry = 1;
            A[i] = 0;
            if(i-1>=0){
                A[i-1]+=1;
                carry=0;
            }
        }
    }
    if(carry == 1){
        int *arr = (int*)malloc(sizeof(int)*(n1+1));
        arr[0] = 1;
        for(i=1;i<=n1;i++)
            arr[i] = A[i-1];
        *len1 = n1+1;
        return arr;
    }
    else{
    int j=0,k=0;
    for(i=0;i<n1;i++){
        if(A[i] == 0)
            j++;
        else
            break;
    }
    int *arr = (int*)malloc(sizeof(int)*(n1-j));
        for(i=j;i<n1;i++)
            arr[k++] = A[i];
        *len1 = k;
    return arr;
}
}
