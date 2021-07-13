package offline_7;

import java.util.Random;

public class testQ {
    static void swap_number(int x,int y){
        int temp=x;
        x=y;
        y=temp;
    }
    static int quick_srt_partition(int arr[],int strt,int lst){
        int piv= lst;
        int pid=strt;
        for(int i=strt;i<lst;i++){
            if(arr[i]<=arr[piv]){
                //swap_number(arr[i],arr[pid]);
                int temp=arr[i];
                arr[i]=arr[pid];
                arr[pid]=temp;

                pid++;
            }
        }
        //swap_number(arr[pid],arr[lst]);
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


    public static void main(String[] args) {
        int a[]=new int[10];
        Random r=new Random();
        for (int i=0;i<10;i++){
            a[i]=r.nextInt(15);
        }
        for(int i: a){
            System.out.println(i);
        }
        System.out.println("after");
        quick_sort(a,0,a.length-1);
        for(int i: a){
            System.out.println(i);
        }

    }
}
