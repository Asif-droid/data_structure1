package offline_6;

import java.util.Scanner;

public class dfsCall {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int c=sc.nextInt();
        int r=sc.nextInt();
        int l=sc.nextInt();
        int f=sc.nextInt();
        missionList missionList=new missionList();
        int [][] friendList=new int[f][2];
        int totalPieces=0;
        graph g=new graph(c);
        for(int i=0;i<r;i++){
            int s=sc.nextInt();
            int d=sc.nextInt();
            sc.nextLine();
            g.addEdge(s,d);
        }
        for(int i=0;i<l;i++){
            int coOrdinate=sc.nextInt();
            int p=sc.nextInt();
            totalPieces+=p;
            sc.nextLine();
            missionList.add(coOrdinate,p);
        }
        for(int i=0;i<f;i++){
            int fLocation=sc.nextInt();
            int nFrnd=sc.nextInt();
            sc.nextLine();
            friendList[nFrnd][0]=fLocation;
            friendList[nFrnd][1]=0;

        }

        for(int i=0;i<friendList.length;i++){
            missionList.start();
            boolean frontChanged=false;
            while(!missionList.isEmpty()){


                if(g.dfs(friendList[i][0],missionList.peekLocation())){

                    friendList[i][1]=friendList[i][1]+ missionList.getPieces();
                    missionList.delete();
                }

                else{
                    if(!frontChanged){
                        frontChanged=true;
                        missionList.changeFront();

                    }
                    else{
                        missionList.moveCurrent();
                    }
                }
            }
        }
        //System.out.println(missionList.getTotalMission());
        if(missionList.getTotalRemaining()==0){
            System.out.println("Mission Accomplished");

        }
        else {
            System.out.println("Mission Failed");
        }
        System.out.println(totalPieces-missionList.getTotalRemaining()+" out of "+totalPieces+" pieces are collected");
        for(int i=0;i<friendList.length;i++){
            System.out.println(i+" collected "+friendList[i][1]+" pieces");
        }


        /*missionList.start();
        while(!missionList.isEmpty()){
            System.out.println(missionList.getPieces()+" from "+missionList.peekLocation());
            missionList.delete();
        }*/

        /*System.out.println("sorce and des");
        int s=sc.nextInt();
        int d=sc.nextInt();
        g.bfs(s,d);*/

    }


}

