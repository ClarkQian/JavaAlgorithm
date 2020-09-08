#include <iostream>
#include <algorithm>
#include "sortHelper.h"
#include "Student.h"
#include "assert.h"

using namespace std;

class Test{
private:
    int a = 12;
    int c = 23;
public:
    friend void show(Test t);
};

//template <typename T>
//void insertSort(T* a, int n){
//    for(int i = 1; i < n; i++){
//        int j = i-1;
//        T pivot = a[i];
//        while(j >= 0 && a[j] >= pivot){
//            a[j+1] = a[j];
//            j--;
//        }
//        a[j] = pivot;
//    }
//}
//template <typename T>
//void insertSort(T* a, int n){
//    for(int i = 1; i < n; i++){
//        T pivot = a[i];
//        int j;
//        for(j = i; j > 0 && a[j-1] > pivot; j--){
//            a[j] = a[j-1];
//        }
//        a[j] = pivot;
//    }
//}

template <typename T>
int partition(T*a, int l, int mid, int r){

    return 0;
}
template <typename T>
int* partition2(T* a, int l, int mid, int r){

    int*b = new int[2];
    b[0] = 1;
    b[1] = 2;
    return b;
}

////todo finish quickSort()
//template <typename T>
//void quickSort(T*a, int n);
//
//
//
////todo finish quickSort() two ways
//template <typename T>
//void quickSort2(T*a, int n);



//todo finish quickSort() three ways
template <typename T>
void quickSort3(T*a, int n);

template <typename T>
void insertSort(T* a, int n){
    for(int i = 1; i < n; i++){
        int j;
        int e = a[i];
        for(j = i; j>0&&a[j-1]> e; j--){
            a[j] = a[j-1];
        }
        a[j] = e;
    }
}

template <typename T>
void _merge(T*a, int l, int mid, int r){
    int size = r-l+1;
    T* aux = new T[size];
    for(int i = 0; i < size; i++){
        aux[i] = a[l+i];
    }

    int lp = l;
    int rp = mid+1;

    /**
     * the frist problem is the a[i+l]: to a the start index is not 0, instead, it is 0+j
     * aux and a's relative index position
     */
    for(int i = 0; i < size; i++){
        if(lp > mid){// get from later one
            a[i+l] = aux[rp-l];
            rp++;
        } else if(rp > r){ //get from former one
            a[i+l] = aux[lp-l];
            lp++;
        }else if(aux[lp-l] <= aux[rp-l]){
            a[i+l] = aux[lp-l];
            lp++;
        } else {
            a[i+l] = aux[rp-l];
            rp++;
        }
    }

//    int count = 0;
//    int lp = l;
//    int rp = mid + 1;
//    while(count < size){
//        if(lp<=mid && rp <= r && a[lp] <= a[rp]){
//            aux[count++] = a[lp++];
//        } else if(lp <= mid && rp <= r && a[lp] > a[rp]){
//            aux[count++] = a[rp++];
//        } else if(lp > mid) {
//            aux[count++] = a[rp++];
//        }else if(rp > r){
//            aux[count++] = a[lp++];
//        } else { // usually useless
//            cout<<"else"<<endl;
//        }
//    }
//
//    //write back
//    for(int i = 0; i < size; i++){
//         a[l+i] = aux[i];
//    }
//    return;
}

template <typename T>
void mergeSortProc(T*a, int l, int r){
    if(l >= r)
        return;

    int mid = l + ((r-l)>>1);

    mergeSortProc(a, l, mid);
    mergeSortProc(a, mid+1, r);
    if(a[mid] > a[mid+1])
        _merge(a, l, mid, r);

}

template <typename T>
void mergeSort(T*a, int n){
    mergeSortProc(a, 0, n-1);
}





template <typename T>
void selectionSort(T* a, int n){
    for(int i = 0; i < n; i++){
        int index = i;
        for(int j = i+1; j < n; j++){
            if(a[j] < a[index]){
                index  = j;
            }
        }
        if(index != i){
            swap(a[index],a[i]);
        }
    }

}


int main() {
//    int n = 10000;
//    for(int i = 0; i < 10; i++){
//        int *a = Helper::generateSeq<int>(n, 0, 100);
////    Student d[4] = {{"D",90},{"B",95},{"C",100},{"A",95}};
//        cout<<"slection sort "<<Helper::sortTest("slection sort", selectionSort, a, n)<<endl;
//        int *b = Helper::generateSeq<int>(n, 0, 100);
//        cout<<"intsert sort "<<Helper::sortTest("insert sort", insertSort, b, n)<<endl;
//        int *c = Helper::generateSeq<int>(n, 0, 100);
//        cout<<"merge sort "<<Helper::sortTest("insert sort ", mergeSort, c, n)<<endl;
//    }
//
    int a[]{1,3,5,2,4,6};
//    _merge(a, 0,2,5);
//    Helper::showSeq(a,6);

    int* c = partition2(a,0,0,0);
    cout<<c[0]<<" "<<c[1]<<endl;


    return 0;
}
