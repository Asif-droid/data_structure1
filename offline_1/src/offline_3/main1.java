package offline_3;

import java.util.Scanner;

public class main1 {
    public static boolean validity=true;
    public static void main(String[] args) {
        operator_stack operators=new operator_stack();
        value_stack values =new value_stack();

        Scanner scanner=new Scanner(System.in);
        String exp=scanner.nextLine();
        char[] chrs=exp.toCharArray();
        int n_fparan=0;
        int n_bparan=0;


        for(int i=0;i<chrs.length;i++){
            if(chrs[i]=='('){
                n_fparan++;
            }
            if(chrs[i]=='+' || chrs[i]=='-'|| chrs[i]=='*'||chrs[i] =='/'){
                if(chrs[i]=='-'&& chrs[i-1]=='('){                      //checks if - is used as unary operator
                    if(chrs[i+2]!=')'){
                        validity=false;
                        //System.out.println("Invalid");
                        break;
                    }
                    values.push(0);                                 //if it is an unary operator we push an extra 0 in value stack

                }

                if(!operators.isEmpty() && precedence(operators.pick(),chrs[i]) &&chrs[i-2]!='('){
                    float x=values.pop();                              //after checking precedence pushes the calculated value
                    float y=values.pop();
                    values.push(calculate(operators.pop(),y,x));
                }

                operators.push(chrs[i]);
                //System.out.println("operarotr push"+chrs[i]);
            }

            else if(chrs[i]==')'){                                  //when there is a closing ) we push the calculated value in the value stack
                n_bparan++;
                if(!operators.isEmpty()){
                    char c=operators.pop();
                    float x=values.pop();
                    float y=values.pop();
                    values.push(calculate(c,y,x));
                }


            }
            else if(chrs[i]>=48&& chrs[i]<=57){
                String s=Character.toString(chrs[i]);
                values.push(Integer.parseInt(s));



            }
        }
        if(n_bparan!=n_fparan){
            System.out.println("Invalid expression");
            validity=false;
            return;
        }

        while (!operators.isEmpty()){                           //in case of paranthesis end before operation
            float x=values.pop();
            float y=values.pop();
            values.push(calculate(operators.pop(),y,x));
        }
        if(validity){
            System.out.println(values.pop());
        }


    }
    public static boolean precedence(char op1,char op2){            //checks precedence
        if((op1=='*'||op1=='/')&&(op2=='+'||op2=='-'))
            return true;
        else
            return false;
    }
    public  static float calculate(char op, float o1,float o2){         //calculates values
        if(op=='+'){
            //System.out.println(o1+o2);
            return o1+o2;
        }
        else if(op=='-'){
            return o1-o2;
        }else if(op=='*'){
            //System.out.println(o1*o2);
            return o1*o2;
        }else if(op=='/'){
            if(o2==0){
                System.out.println("can not divide");
                validity=false;
                return -1;
            }
            return o1/o2;
        }
        System.out.println("cant calculate");
        validity=false;
        return -1;
    }
}
