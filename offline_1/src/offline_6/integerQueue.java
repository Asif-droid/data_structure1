package offline_6;




class node{
    public node nxt;
    public int value;
    public node(int value){
        this.value=value;
        nxt=null;
    }
    public node(){
        nxt=null;
    }

}

public class integerQueue {
    public node front;
    public node rear;
    public integerQueue(){
        front=null;
        rear=null;
    }
    public void enqueue(int value){
        node n=new node(value);
        if(front==null){
            rear=n;
            front=rear;
            //System.out.println(head.c);
        }
        else {
            rear.nxt=n;
            rear=n;
            //System.out.println(current.c);
        }
    }
    public boolean isEmpty(){
        if(front==null)
            return true;
        else
            return false;
    }
    public boolean isNearlyempty(){
        if(front.nxt==null){
            return true;
        }
        else
            return false;
    }
    public int dequeue(){
        int temp=front.value;
        front=front.nxt;
        return temp;
    }
    public int peek(){
        return front.value;
    }
}
