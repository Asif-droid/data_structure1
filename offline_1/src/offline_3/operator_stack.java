package offline_3;

public class operator_stack {
    private char operators[]=new char[10];
    private int i;
    private int t;
    public operator_stack(){
        i=0;
        t=0;
    }
    void push(char s){
        operators[i++]=s;
        t=i-1;
    }
    char pop(){

        if(t<0)
            return '\0';
        else{
            i--;
            return operators[t--];
        }

    }
    char pick(){
        return operators[t];
    }
    boolean isEmpty(){
        if(i==0)
            return true;
        return false;
    }
}
