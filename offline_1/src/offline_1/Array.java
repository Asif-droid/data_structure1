package offline_1;

public class Array {
    private String array[];
    private  int count;
    public Array(){
        array=new String[5];
        count=0;
    }
    public Array(int l){
        array=new String[l];
        count=0;
    }
    public Array(String []arr){
        array=new String[arr.length];
        for(int i=0;i<arr.length;i++){
            array[i]=arr[i];
        }
        count=arr.length;
    }
    String[] getArray(){
        return array;
    }
    String getAnElement(int i){
        return array[i] ;
    }
    void add(String s){
        if(count<array.length){

            array[count++]=s;
        }
        else{
            //System.out.println("out of index");
            String[] temp= new String[array.length];
            for(int i=0;i<count;i++){
                temp[i]=array[i];
            }
            array=new String[count+1];
            for(int i=0;i<count;i++){
                array[i]=temp[i];
            }
            array[count++]=s;


        }

    }
    void add(int index,String s){
        if(index>array.length){
            System.out.println("index out of bound");
        }
        else{
            if(index==array.length){
                add(s);
            }
            else{
                String [] temp=new String[array.length-index];
                for( int i=0;i<temp.length;i++){
                    temp[i]=array[index+i];
                }
                array[index]=s;
                int j=0;
                for(int i=index+1;i<array.length;i++){
                    array[i]=temp[j++];
                }
                add(temp[j]);

            }
        }

    }
    void remove(String s){
        for(int i=0;i<count;i++){
            if(array[i].equals(s)){
                for(int j=i;j<count-1;j++){
                    array[j]=array[j+1];
                }
                count--;
                i--;
            }
        }

    }
    int getSize(){
        return count;
    }
    int findIndex(String s){
        for(int i=0;i<count;i++){
            if(s.equals(array[i])){
                return i;
            }
        }
        return -1;
    }
    String [] subarray(int strt,int end){
        String []temp=new String[end-strt+1];
        for(int i=0;i<=(end-strt);i++){
            if(i==count){
                return temp;
            }
            temp[i]=array[i+strt];
        }
        return temp;
    }



}
