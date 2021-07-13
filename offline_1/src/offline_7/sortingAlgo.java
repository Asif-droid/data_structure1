package offline_7;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class sortingAlgo {


    static int quick_srt_partition(int arr[],int strt,int lst){
        int piv=lst;
        int pid=strt;
        for(int i=strt;i<lst;i++){
            if(arr[i]<=arr[piv]){
                int temp=arr[i];
                arr[i]=arr[pid];
                arr[pid]=temp;
                pid++;
            }
        }
        int temp2=arr[pid];
        arr[pid]=arr[lst];
        arr[lst]=temp2;
        return pid;


    }
    static void quick_sort(int arr[],int strt,int lst){
        if(strt<lst){
            int pid=quick_srt_partition(arr,strt,lst);
            quick_sort(arr,strt,pid-1);
            quick_sort(arr,pid+1,lst);
        }

    }



    static void merge_arr(int arr[],int strt,int mid,int lst){
        int lf_arr_len=mid-strt+1;
        int rt_arr_len=lst-mid;

        int l_arr[]=new int[lf_arr_len];
        int r_arr[]=new int [rt_arr_len];
        for(int i=0;i<lf_arr_len;i++){
            l_arr[i]=arr[i+strt];
        }
        for(int i=0;i<rt_arr_len;i++){
            r_arr[i]=arr[i+mid+1];
        }
        int l_indx=0;
        int r_indx=0;
        int k=strt;
        while(k<=lst){
            if(l_indx<lf_arr_len && r_indx<rt_arr_len){
                if(l_arr[l_indx]<r_arr[r_indx]){
                    arr[k]=l_arr[l_indx];
                    l_indx++;
                }
                else{
                    arr[k]=r_arr[r_indx];
                    r_indx++;

                }

            }
            else if(l_indx>=lf_arr_len){
                arr[k]=r_arr[r_indx];
                r_indx++;

            }else if(r_indx>=rt_arr_len){
                arr[k]=l_arr[l_indx];
                l_indx++;

            }



            k++;
        }


    }


    static void merge_sort(int arr[],int strt,int lst){

        if(strt==lst){
            return;
        }
        int mid=(strt+lst)/2;
        merge_sort(arr,strt,mid);
        merge_sort(arr,mid+1,lst);
        merge_arr(arr,strt,mid,lst);



    }


    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        long [] mergeSorttime=new long [10];
        long [] quickSorttime=new long [10];
        int iteration=0;

        while(true){
            System.out.println("1=> Run the programme..2=> Quit");
            int choice=scanner.nextInt();
            if(choice==2||iteration==10){
                /*long mS=0;
                long qS=0;
                for(int i=0;i<iteration;i++){
                    mS+=mergeSorttime[i];
                    qS+=quickSorttime[i];
                }
                System.out.println("Avarage"+mS/iteration);
                System.out.println("Avarage"+qS/iteration);*/
                break;

            }
            else {
                System.out.println("Enter array size:");
                int n=scanner.nextInt();
                //int n=1000000;
                int mArray[]=new int[n];
                int qArray[]=new int[n];
                Random rnd=new Random();
                System.out.println("1=>Ascending. 2=>Descending. 3=> Random");
                int c=scanner.nextInt();
                //int c=3;
                if(c==1){
                    int s=rnd.nextInt(1000);
                    for(int i=0;i<n;i++){
                        int x=rnd.nextInt(n);
                        s+=x;
                        mArray[i]=s;
                        qArray[i]=s;
                    }
                    long mStrt=System.nanoTime();
                    merge_sort(mArray,0,mArray.length-1);
                    long mEnd=System.nanoTime();
                    long qStrt=System.nanoTime();
                    quick_sort(qArray,0,qArray.length-1);
                    long qEnd=System.nanoTime();
                    for(int i=0;i<n;i++){
                        System.out.println(mArray[i]+"       "+qArray[i]);
                    }
                    System.out.println("mergeSort time "+ (mEnd-mStrt)+"ns");
                    System.out.println("QuickSort time "+ (qEnd-qStrt)+"ns");
                    //mergeSorttime[iteration]=mEnd-mStrt;
                    //quickSorttime[iteration]=qEnd-qStrt;


                }else if(c==2){
                    int s=rnd.nextInt(1000);
                    for(int i=0;i<n;i++){
                        int x=rnd.nextInt(10);
                        s-=x;
                        mArray[i]=s;
                        qArray[i]=s;
                    }
                    for(int i=0;i<(n-1);i++){
                        if(mArray[i]<mArray[i+1]){
                            System.out.println("not accepted");
                            break;
                        }
                    }
                    long mStrt=System.nanoTime();
                    merge_sort(mArray,0,mArray.length-1);
                    long mEnd=System.nanoTime();
                    long qStrt=System.nanoTime();
                    quick_sort(qArray,0,qArray.length-1);
                    long qEnd=System.nanoTime();
                    for(int i=0;i<n;i++){
                        System.out.println(mArray[i]+"       "+qArray[i]);
                    }
                    System.out.println("mergeSort time "+ (mEnd-mStrt)+"ns");
                    System.out.println("QuickSort time "+ (qEnd-qStrt)+"ns");
                    //mergeSorttime[iteration]=mEnd-mStrt;
                    //quickSorttime[iteration]=qEnd-qStrt;

                }else if(c==3){

                    for(int i=0;i<n;i++){
                        int x=rnd.nextInt(n);
                        mArray[i]=x;
                        qArray[i]=x;
                    }
                    long mStrt=System.nanoTime();
                    merge_sort(mArray,0,mArray.length-1);
                    long mEnd=System.nanoTime();
                    long qStrt=System.nanoTime();

                    quick_sort(qArray,0,qArray.length-1);
                    long qEnd=System.nanoTime();
                    for(int i=0;i<n;i++){
                        System.out.println(mArray[i]+"       "+qArray[i]);
                    }
                    System.out.println("mergeSort time "+ (mEnd-mStrt)+"ns");
                    System.out.println("QuickSort time "+ (qEnd-qStrt)+"ns");
                    //mergeSorttime[iteration]=mEnd-mStrt;
                    //quickSorttime[iteration]=qEnd-qStrt;
                }

            }
            //iteration+=1;



        }


       /*int a[]=new int[5];
       Random r=new Random();
       for (int i=0;i<5;i++){
           a[i]=r.nextInt(15);
       }
       int b[]={0,1,5,4};
       for(int i:a){
           System.out.println(i);
       }
       //merge_sort(a,0,a.length-1);
       quick_sort(a,0,a.length-1);
       for (int i:a){
           System.out.println(i);
       }
        /*for(int i:b){
            System.out.println(i);
        }*/
    }
}
