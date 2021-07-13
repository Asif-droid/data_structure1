package ofline_2;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        int total_player=0;
        boolean iscurrentAhead=false;
        //String winner=null;
        player_list list=new player_list();
        int time=0;
        int Dir=0;                              ///Dir=0 means passing from left to right,1 means opposite
        Scanner myscanner=new Scanner(System.in);
        int playerNum=myscanner.nextInt();
        total_player=playerNum;
        for(int i=1;i<=playerNum;i++){
            int rx_time=myscanner.nextInt();
            player p=new player(rx_time,Integer.toString(i));
            list.addplayer(p);
        }
        myscanner.nextLine();
        System.out.println("testing");
        list.start();

        player cur_p=list.get_head();
        while(true){

            String query=myscanner.nextLine();
            String[] q_str=query.split(" ");
            int q_time=Integer.parseInt(q_str[0]);
            //System.out.println(q_time);
            if(q_str[1].equalsIgnoreCase("F")){
                if(q_time>time){
                    while(true){

                        if(Dir==0){
                            cur_p=list.pop_rt();
                        }
                        else{
                            cur_p=list.pop_lft();

                        }
                        time+=cur_p.rx_time;
                        if(q_time<=time){
                            System.out.println("Player "+cur_p.name+" holding at "+q_time);
                            break;
                        }
                    }
                }
                else{
                    System.out.println("Player "+cur_p.name+" holding at "+q_time);

                }
                //list.start();

                System.out.println("Passing order");
                if(Dir==0){
                    list.pop_lft();
                    for(int i=0;i<total_player;i++){
                        System.out.println(list.pop_rt().name);
                    }

                }else{
                    list.pop_rt();
                    for(int i=0;i<total_player;i++){
                        System.out.println(list.pop_lft().name);
                    }

                }
                if(total_player==1){
                    System.out.println(cur_p.name+" is winner!!!!");
                }


                break;
            }
            else if(q_str[1].equalsIgnoreCase("R")){
                iscurrentAhead=true;
                if(q_time>time){
                    while(true){

                        if(Dir==0){
                            cur_p=list.pop_rt();
                        }
                        else{
                            cur_p=list.pop_lft();

                        }
                        time+=cur_p.rx_time;
                        if(q_time<=time){
                            //System.out.println("Player "+cur_p.name+" holding at "+q_time);
                            break;
                        }
                    }
                }
                if(Dir==0){
                    list.pop_lft();             //as poping right leaves the current node pointing the right node
                    list.pop_lft();             //one left pop left will bring it on the node we are operating
                }                               //another pop left will make the current node follow the left Direction
                else {
                    list.pop_rt();
                    list.pop_rt();
                }
                Dir=1^Dir;
                //System.out.println(Dir);
            }
            else if (q_str[1].equalsIgnoreCase("P")){
                //System.out.println("in P");
                iscurrentAhead=true;

                if(q_time>time){
                    while(true){

                        if(Dir==0){
                            cur_p=list.pop_rt();
                        }
                        else{
                            cur_p=list.pop_lft();

                        }
                        time+=cur_p.rx_time;
                        if(q_time<=time){
                            System.out.println("Player "+cur_p.name+" holding at "+q_time);
                            break;
                        }
                    }
                }
                else{
                    System.out.println("Player "+cur_p.name+" holding at "+q_time);

                }


            }
            else if(q_str[1].equalsIgnoreCase("M")&&total_player>1){

                total_player-=1;
                if(q_time>time){
                    while(true){
                        if(Dir==0){
                            cur_p=list.pop_rt();
                            iscurrentAhead=true;
                        }
                        else {
                            cur_p=list.pop_lft();
                            iscurrentAhead=true;
                        }
                        time+=cur_p.rx_time;
                        if(q_time<=time){
                            System.out.println("PLayer "+cur_p.name+" eliminated at"+q_time);
                           if(Dir==0){                              //direction left to right

                               if(iscurrentAhead){                  //if the current is ahead due to pop,
                                   list.pop_lft();                  //we make it point the prev that is the node we need
                                   cur_p=list.eliminate(Dir);
                               }
                               else{
                                   cur_p=list.eliminate(Dir);
                                   //System.out.println("elem");
                               }


                           }
                           else{
                               if(iscurrentAhead){                  //if the current is ahead due to pop,
                                   list.pop_rt();                   //we make it point the prev that is the node we need
                                   cur_p=list.eliminate(Dir);
                               }
                               else {
                                   cur_p=list.eliminate(Dir);
                                   //System.out.println("elemint");
                               }


                           }


                            //System.out.println("rt "+cur_p.rt_player.name);
                            time+=cur_p.rx_time;


                            break;
                        }
                    }

                }
                else{
                    System.out.println("PLayer "+cur_p.name+" eliminated at"+q_time);
                    time-=cur_p.rx_time;
                    if(Dir==0){
                        if (iscurrentAhead){
                            list.pop_lft();
                            cur_p=list.eliminate(Dir);
                        }
                        else {
                            cur_p=list.eliminate(Dir);
                        }

                        //list.pop_rt();
                    }
                    else{
                        if(iscurrentAhead){
                            list.pop_rt();
                            cur_p=list.eliminate(Dir);
                        }
                        else {
                            cur_p=list.eliminate(Dir);
                        }

                        //list.pop_lft();
                    }

                    //System.out.println(cur_p.rt_player.name);
                    time+=cur_p.rx_time;


                }
                iscurrentAhead=false;

            }
            else if(q_str[1].equalsIgnoreCase("I")){
                if(q_time>time){
                    while(true){

                        if(Dir==0){
                            cur_p=list.pop_rt();
                        }
                        else{
                            cur_p=list.pop_lft();

                        }
                        time+=cur_p.rx_time;
                        if(q_time<=time){
                            //System.out.println("Player "+cur_p.name+" holding at "+q_time);
                            break;
                        }
                    }
                }
                if(total_player>1){
                    int rx_time=Integer.parseInt(q_str[2]);
                    playerNum += 1;
                    total_player+=1;
                    player p=new player(rx_time,Integer.toString(playerNum));
                    if(Dir==0){
                        list.pop_lft();                    //pillow is moving towards right
                        list.insert_lft(p);                 //when we pop the current from list points the nxt element so we need to
                                                            // back it with left pop
                        list.pop_rt();                      //after inserting we put the current to it's original
                    }


                    else{                               //pillow is moving towards left

                        list.pop_rt();                      //when we pop the current from list points the nxt element so we need to
                                                            // back it with right pop
                        list.insert_right(p);
                        list.pop_lft();
                    }

                }


            }
            else {

            }

        }


    }
}
