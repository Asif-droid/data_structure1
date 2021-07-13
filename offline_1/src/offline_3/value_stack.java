package offline_3;

public class value_stack {
    private float values[]=new float[20];
    private int i;
    private int t;
    public value_stack(){
        i=0;
        t=0;
    }
    public void push(float x){
        values[i++]=x;
        t=i-1;
    }
    public float pop(){
        if(t<0)
            return -1;
        else{
            i--;
            return values[t--];
        }

    }

}
