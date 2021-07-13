package offline_1;

public class main {

    public static void main(String[] args) {
        Array arr=new Array();
        arr.add("a1");
        arr.add("a2");
        arr.add("b1");
        arr.add("a1");
        arr.add("a1");
        arr.add("a2");
        arr.add("b2");
        arr.add(3,"b1");
        arr.add(7,"b2");
        arr.add("xz");
        String []tmp=arr.subarray(2,5);
        for(int i=0;i<tmp.length;i++){
            System.out.println(tmp[i]);
        }

       /*for(int i=0;i<arr.getSize();i++){
           System.out.println(arr.getAnElement(i));
       }
        arr.remove("a1");
       arr.add(5,"a2");
        System.out.println("after delete");
        for(int i=0;i<arr.getSize();i++){
            System.out.println(arr.getAnElement(i));
        }*/

    }


}
