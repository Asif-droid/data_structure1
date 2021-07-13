package offline_6;

import java.util.LinkedList;
import java.util.Scanner;

public class graph {
    private LinkedList<Integer> []adjList;
    private integerQueue queue;
    public graph(int n){
        adjList=new LinkedList[n];

        for(int i=0;i<n;i++){
            adjList[i]=new LinkedList<Integer>();

        }



    }
    public boolean bfs(int source,int destination){
        queue=new integerQueue();
        boolean visited[]=new boolean[adjList.length];
        boolean found=false;
        queue.enqueue(source);
        visited[source]=true;
        while(!queue.isEmpty()){
            int  cur=queue.dequeue();
            if(cur==destination){
                found=true;
                break;
            }
            for(int neighbour:adjList[cur]){

               if(!visited[neighbour]){
                   visited[neighbour]=true;
                   queue.enqueue(neighbour);
               }
            }


        }

        return found;


    }
    public boolean dfs(int source,int destination){
        boolean visited[]=new boolean[adjList.length];
        visited[source]=true;
        return dfsFinder(source,destination,visited);

    }
    public boolean dfsFinder(int source, int destination,boolean []visited){
        if(source==destination){
            return true;
        }
        for(int neighbour:adjList[source]){
            if(!visited[neighbour]){
                visited[neighbour]=true;
                boolean isFound=dfsFinder(neighbour,destination,visited);
                if(isFound){
                    return true;
                }
            }
        }
        return false;
    }




    public void addEdge(int source,int destination){                //there is a road from source to destination
                                                                    //so source will have destination and destination will have source in adjlist
        adjList[source].add(destination);
        adjList[destination].add(source);
    }

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
        //System.out.println(totalPieces);

        for(int i=0;i<friendList.length;i++){
            missionList.start();
            boolean frontChanged=false;
            while(!missionList.isEmpty()){

                //searching using bfs
                if(g.bfs(friendList[i][0],missionList.peekLocation())){

                    friendList[i][1]=friendList[i][1]+ missionList.getPieces();
                    missionList.delete();
                }

                //searching using dfs
                /*if(g.dfs(friendList[i][0],missionList.peekLocation())){

                    friendList[i][1]=friendList[i][1]+ missionList.getPieces();
                    missionList.delete();
                }*/


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
            //System.out.println("end of"+i);
        }
        //System.out.println(missionList.getTotalMission());
        if(missionList.getTotalRemaining()<=0){
            System.out.println("Mission Accomplished");

        }
        else {
            System.out.println("Mission Failed");
        }
        //System.out.println(missionList.getTotalRemaining());
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
