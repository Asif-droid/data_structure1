package offline_8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class closest_pair {
    public static double minimum=10000000;
    public static  double secondMin=minimum;
    public static int closestPair[]=new int [2];
    public static int secndColset[]=new int[2];


    public static void bruteForce(point arr[],int strt,int lst){

        for (int i=strt;i<=lst;i++){
            for (int j=i+1;j<=lst;j++){
                double dis=Math.abs(distance(arr[i],arr[j]));
                //System.out.println(dis+"   "+i+" "+j);
                if(dis<=minimum){
                    secondMin=minimum;
                    minimum=dis;
                    secndColset[0]=closestPair[0];
                    secndColset[1]=closestPair[1];
                    closestPair[0]=arr[i].getIndex();
                    closestPair[1]=arr[j].getIndex();
                }
                else if(dis<=secondMin){
                    secondMin=dis;
                    secndColset[0]=arr[i].getIndex();
                    secndColset[1]=arr[j].getIndex();
                }
            }
        }


    }
    public static void stripClosest(point arr[],int strt,int lst){
        if(arr==null)
            return ;

        for (int i=strt;i<=lst;i++){
            for(int j=i+1;j<=lst && j<=i+15;j++){
                if(Math.abs(arr[i].getY()-arr[j].getY())<secondMin){
                    double dis=Math.abs(distance(arr[i],arr[j]));
                    if(dis<minimum){
                        secondMin=minimum;
                        minimum=dis;
                        secndColset[0]=closestPair[0];
                        secndColset[1]=closestPair[1];
                        closestPair[0]=arr[i].getIndex();
                        closestPair[1]=arr[j].getIndex();
                    }
                    else if(dis<secondMin){
                        secondMin=dis;
                        secndColset[0]=arr[i].getIndex();
                        secndColset[1]=arr[j].getIndex();
                    }
                }
            }
        }


    }
    public static void closestPairUtil(point px[],point py[],int strt,int lst){
        //if(strt>lst)return;
        int ln=lst-strt+1;
        if(ln<=3){
            bruteForce(px,strt,lst);
            return;

        }

        int mid=(strt+lst)/2;
        //System.out.println(mid);
        point midPoint=px[mid];
        /*
        * Point Pyl[mid];   //redundant
        Point Pyr[n-mid];
        int li = 0, ri = 0;
        for (int i = 0; i < n; i++)
        {
          if (Py[i].x <= midPoint.x && li<mid)
             Pyl[li++] = Py[i];
          else
             Pyr[ri++] = Py[i];
        }*/


        closestPairUtil(px,py,strt,mid);
        closestPairUtil(px,py,mid+1,lst);


        point stripArr[]=new point[py.length];
        int j=0;
        for (int i=0;i<py.length;i++){
            if(Math.abs(py[i].getX()-midPoint.getX())<secondMin){
                stripArr[j]=py[i];
                j++;
            }
        }
        //merge_sort(stripArr,0,j-1,'y');
        stripClosest(stripArr,0,j-1);
    }
    public static void closestPairFind(point px[],point py[],int strt,int lst){
        closestPairUtil(px,py,strt,lst);


    }
    public static void main(String[] args) {

        File file=new File("src\\offline_8\\input.txt");//file path name from content root
        Scanner scanner= null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int n=scanner.nextInt();
        point points[]=new point[n];
        point px[]=new point[n];
        point py[]=new point[n];
        for(int i=0;i<n;i++){
            int x=scanner.nextInt();
            int y=scanner.nextInt();
            //points[i]=new point(x,y,i);
            px[i]=new point(x,y,i);
            py[i]=new point(x,y,i);
        }

        merge_sort(px,0,n-1,'x');
        merge_sort(py,0,n-1,'y');
        closestPairFind(px,py,0,n-1);
        System.out.println(secndColset[0]+" "+secndColset[1]);
        System.out.println(secondMin);
        /*System.out.println(closestPair[0]+" "+closestPair[1]);
        System.out.println(minimum);*/






    }
    static double min(double a, double b){
        if(a<b){
            return a;
        }
        else
            return b;
    }
    static double distance(point p1,point p2){
        return Math.sqrt(Math.pow((p1.getX()-p2.getX()),2)+Math.pow((p1.getY()-p2.getY()),2));
    }

    static void merge_arr(point arr[],int strt,int mid,int lst,char c){
        int lf_arr_len=mid-strt+1;
        int rt_arr_len=lst-mid;

        point l_arr[]=new point[lf_arr_len];
        point r_arr[]=new point [rt_arr_len];
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
                if(c=='x'){
                    if(l_arr[l_indx].getX()<r_arr[r_indx].getX()){
                        arr[k]=l_arr[l_indx];
                        l_indx++;
                    }
                    else{
                        arr[k]=r_arr[r_indx];
                        r_indx++;

                    }

                }
                else{
                    if(l_arr[l_indx].getY()<r_arr[r_indx].getY()){
                        arr[k]=l_arr[l_indx];
                        l_indx++;
                    }
                    else{
                        arr[k]=r_arr[r_indx];
                        r_indx++;

                    }
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


    static void merge_sort(point arr[],int strt,int lst,char c){

        if(strt==lst){
            return;
        }
        int mid=(strt+lst)/2;
        merge_sort(arr,strt,mid,c);
        merge_sort(arr,mid+1,lst,c);
        merge_arr(arr,strt,mid,lst,c);



    }
}
