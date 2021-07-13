package ofline_2;


class player{
    public player lft_player;
    public player rt_player;
    public int rx_time;
    String name;
    public player(){
        lft_player=null;
        rt_player=null;
    }
    public player(int time,String name){
        lft_player=null;
        rt_player=null;
        rx_time=time;
        this.name=name;
    }
    void setRx_time(int rx_time){this.rx_time=rx_time;
    }
}

public class player_list {
    public player beginner;
    public player current;
    public player_list(){
        beginner=null;
        current=null;
    }
    void addplayer(player p){
        if(beginner==null){
            current=p;
            beginner=current;
            //System.out.println(beginner.name);
        }
        else{
            player old_current=current;
            old_current.rt_player=p;

            current=p;
            current.lft_player=old_current;
            current.rt_player=beginner;
            beginner.lft_player=current;
        }
    }
    void insert_lft(player p){
        player curr_left=current.lft_player;    //saves the left node of current
        current.lft_player=p;
        curr_left.rt_player=p;                  //p will sit between curr_left and current
        p.rt_player=current;
                                                // p is on the right of curr_left and left of current
        p.lft_player=curr_left;
    }
    void insert_right(player p){
        player curr_rt=current.rt_player;       //saves right node of current

        current.rt_player=p;
        curr_rt.lft_player=p;                   //p will sit between current and curr_rt
        p.lft_player=current;
        p.rt_player=curr_rt;                    //p is on the right of current and left of curr_rt


    }
    void start(){
        current=beginner;
    }
    player pop_rt(){            //pops from current to current right
        player rtrn=current;
        current=rtrn.rt_player;
        return rtrn;

    }
    player pop_lft(){           //pops from current to current left
        player rtrn=current;
        current=rtrn.lft_player;
        return rtrn;
    }
    player get_head(){
        return beginner;
    }
    player eliminate(int d){
        player left=current.lft_player;
        player right=current.rt_player;
        left.rt_player=right;
        right.lft_player=left;
        if(d==0){               //passing dir is right so new current is right node
            current=right;
        }
        else{                   //passing dir is left so new current is left node
            current=left;
        }
        return current;

    }

}
