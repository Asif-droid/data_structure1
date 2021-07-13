#ifndef HEAP_H_INCLUDED
#define HEAP_H_INCLUDED
#include<cstdio>
#include<vector>



#endif // HEAP_H_INCLUDED

using namespace std;


class Heap{
private:
    int heap_size;
    int current=0;
    vector<int>v1;
    int get_parent(int i){
        return i/2;
    }
    int get_lchild(int i){
        return i*2;
    }
    int get_rchild(int i){
        return (i*2)+1;
    }


public:
    Heap(int x){
        this->heap_size=x;
        this->current=0;
        v1.push_back(-1);
        //cout<<"done";

    }
    void climb(int i){
        if(i==1){
            return;
        }
        else if(v1[i]>v1[get_parent(i)]){
            swap(v1[get_parent(i)],v1[i]);
            climb(get_parent(i));
        }
        else
            return;

    }
    void insert(int val){
        if(current+1>=v1.size()){
            v1.push_back(val);
        }
        //v1[++current]=val;
        current++;
        //cout<<v1[current];
        climb(current);


    }
    void descend(int i){
        if(i>current){
            return;
        }
        int swap_child=i;
        if(get_lchild(i)<=current && v1[i]<v1[get_lchild(i)]){
            swap_child=get_lchild(i);

        }
        if(get_rchild(i)<=current && v1[swap_child]<v1[get_rchild(i)]){
            swap_child=get_rchild(i);
        }
        if(swap_child!=i){
            swap(v1[i],v1[swap_child]);

            descend(swap_child);
        }
        return;
    }
    int size(){
        return heap_size;
    }
    int getMax(){
        return v1[1];
    }
    int extractMax(){
        int mx=v1[1];
        v1[1]=v1[current--];
        //cout<<v1[1]<<endl;
        descend(1);
        return mx;

    }

    void deleteKey(){
        //heap_size--;
        v1[1]=v1[current--];
        descend(1);

        //cout<<heap_size;
    }




};
void heapsort(vector <int>& v){

        int n=v.size();
        Heap h1(n);

        for(int i=0;i<n;i++){
            h1.insert(v[i]);
        }
        /*for(int i=1;i<current+1;i++){
            cout<<v1[i];
        }
        cout<<endl;*/
        //cout<<v1[current];
        for(int i=0;i<n;i++){
            v[i]=h1.extractMax();
        }


    }
