package ofline_2;

public class string_queue {
    private char ch[];
    private int i;
    private int head;
    public string_queue(String s){
        ch=s.toCharArray();
        i=0;
        head=0;
    }
    public string_queue (int n){
        ch=new char[n];
        i=0;
        head=0;
    }
    public void enqueue(char c){
        ch[i++]=c;
    }
    public char dequeue(){
        return ch[head++];
    }
    public boolean isEmpty(){
        if(head>=i)
            return true;
        else
            return false;
    }
}
