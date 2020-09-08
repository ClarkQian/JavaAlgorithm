//
// Created by Clark on 2020-09-03.
//
#include <stdlib.h>
#include "iostream"
#include "ctime"
#include "assert.h"
using namespace std;

#ifndef ALGORITHM_SORTHELPER_H
#define ALGORITHM_SORTHELPER_H

namespace Helper{

    template <typename T>
    T* generateSeq(int n, int lbound, int rbound){
        srand(time(NULL));
        T* p = new T[n];
        for(int i = 0; i < n; i++){
            p[i] = rand()%(rbound-lbound+1)  + lbound;
        }
        return p;
    }
    template <typename T>
    void showSeq(T* a, int n){
        for(int i = 0 ;i < n; i++){
            cout<<a[i]<<" ";
        }
        cout<<endl;
    }

    template <typename T>
    bool isSort(T* a, int n){
        for(int i = 0; i < n-1; i++){
            if(a[i] > a[i+1])
                return false;
        }
        return true;
    }

    /**
     *
     * @tparam T
     * @param name
     * @param sort
     * @param a
     * @param n
     * @return
     */
    template <typename T>
    float sortTest(string name, void(*sort)(T* a, int n), T* a, int n){
        clock_t startTime = clock();
        sort(a, n);
        clock_t endTime = clock();
        assert(isSort(a, n));
        return float(endTime-startTime)/CLOCKS_PER_SEC;
    }

}

#endif //ALGORITHM_SORTHELPER_H
