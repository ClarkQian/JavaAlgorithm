int getMin(int*a, int n, int l, int r){

    if(a[l] <a[r])
        return a[l];



    int mid = l + ((r - l)>>1);

    if(a[mid] > a[l]){ // left is in order
        return getMin(a, n, mid+1 , r);
    } else if(a[mid] < a[l]) {// go to left
        if(mid + 1 <n &&a[mid] <= a[mid+1]) //evade the loss of mid's minimal one
            return a[mid];
        return getMin(a, n, l, mid-1 );
    } else {
        if(a[mid] == a[r])
            return a[mid];
        else
            return getMin(a, n, mid +1, r);
    }

}
