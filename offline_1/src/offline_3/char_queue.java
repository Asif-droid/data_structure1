package offline_3;



class char_node{
    public char_node nxt;
    public char c;
    public char_node(char c){
        this.c=c;
        nxt=null;
    }
    public char_node(){
        nxt=null;
    }
}

public class char_queue {
    public char_node head;
    public char_node current;
    public char_queue(){
        head=null;
        current=null;
    }
    public void enqueue(char_node c){
        if(head==null){
            current=c;
            head=current;
            //System.out.println(head.c);
        }
        else {
            current.nxt=c;
            current=c;
            //System.out.println(current.c);
        }
    }
    public boolean isEmpty(){
        if(head==null)
            return true;
        else
            return false;
    }
    public boolean isNearlyempty(){
        if(head.nxt==null){
            return true;
        }
        else
            return false;
    }
    public void dequeue(){
        head=head.nxt;
    }
    public char peek(){
        return head.c;
    }
}
