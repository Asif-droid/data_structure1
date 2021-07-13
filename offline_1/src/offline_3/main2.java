package offline_3;

import java.util.Scanner;

public class main2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        char cArr[]=s.toCharArray();
        char_queue oldString=new char_queue();
        char_queue newString=new char_queue();
        int charCount[]=new int[26];                        //representing 26 characters as each index and values are frequency
        //int charOutcount[]=new int[26];
        int count=0;


        for(int i=0;i<cArr.length;i++){
            char_node cNode=new char_node(cArr[i]);
            count++;

            oldString.enqueue(cNode);                       //populating the oldString increasing frequency of that character
            charCount[cArr[i]-'a']+=1;
            while (!oldString.isEmpty()) {                   // the loop continues until there is a non repeating head or end
                count++;

                if (charCount[oldString.peek() - 'a'] > 1) {       //if the head is a repeating character we change the head
                    oldString.dequeue();
                    if(oldString.isEmpty()){                           //if there is no non repeating head but oldStr has ended we put # in newStr

                        char_node c=new char_node('#');
                        newString.enqueue(c);
                    }

                } else {
                    char_node c = new char_node(oldString.peek());        //if the head is not repeating we put it in newString
                    newString.enqueue(c);
                    //System.out.println(c.c);
                    break;
                }
            }



        }

        while (!newString.isEmpty()){
            System.out.print(newString.peek());
            newString.dequeue();
        }
        //System.out.println(count);

    }
}
