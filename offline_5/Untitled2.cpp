#include<iostream>
#include<cstdio>
#include <vector>
#include "heap.h"
using namespace std;
int main()
{

    int x;
    cin>>x;
    vector<int>v(x);
    for(int i=0;i<x;i++){
        int n;
        cin>>n;
        v[i]=n;
    }
    //Heap he(x);
    heapsort(v);
    for(int i=0;i<v.size();i++){
        cout<<v[i];
    }

}


