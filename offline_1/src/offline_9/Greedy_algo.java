package offline_9;

import java.util.Arrays;
import java.util.Scanner;

public class Greedy_algo {


    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int k=scanner.nextInt();
        int price=0;
        int plants[]=new int[n];
        int frnds[]=new int[k];
        Arrays.fill(frnds,0);
        for (int i=0;i<n;i++){
            plants[i]=scanner.nextInt();
        }
        merge_sort(plants,0,n-1);
        int j=0;
        for(int i=n-1;i>=0;i--){
            price+=(frnds[j%k]+1)*plants[i];
            frnds[j%k]+=1;
            j++;
        }
        System.out.println(price);

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



}
