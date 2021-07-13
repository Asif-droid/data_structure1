package offline_4;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        binary_tree tree=new binary_tree();
        int d;
        Scanner scanner=new Scanner(System.in);
        /*for(int i=0;i<5;i++){
            int x=scanner.nextInt();
            scanner.nextLine();
            binary_node node=new binary_node(x);
            tree.insert(node);
        }*/
        //tree.show();

        while (true){
            String instruction=scanner.nextLine();
            if(instruction.equalsIgnoreCase("close")){
                break;
            }
            else if(instruction.equalsIgnoreCase("insert")){
                int i=scanner.nextInt();
                scanner.nextLine();
                binary_node node=new binary_node(i);
                tree.insert(node);
            }
            else if(instruction.equalsIgnoreCase("delete")){
                d=scanner.nextInt();
                scanner.nextLine();
                tree.Delete(d);
            }
            else if(instruction.equalsIgnoreCase("search")){
                int i=scanner.nextInt();
                scanner.nextLine();
                tree.searchItem(i);
            }
            else if(instruction.equalsIgnoreCase("depth")){
                int i=scanner.nextInt();
                scanner.nextLine();
                int x=tree.getItemDepth(i);
                if(x==-1){
                    System.out.println("item not found");
                }
                else
                    System.out.println(x);
            }
            else if(instruction.equalsIgnoreCase("successor")){
                d=scanner.nextInt();
                scanner.nextLine();
                //System.out.println(d);
                int x=tree.getInorderSuccessor(d);
                if(x==-1){
                    System.out.println("successor not found");
                }
                else{
                    System.out.println(x);
                }
            }
            else if(instruction.equalsIgnoreCase("predecessor")){
                d=scanner.nextInt();
                scanner.nextLine();
                int x=tree.getInorderPredecessor(d);
                if(x==-1){
                    System.out.println("predecessor not found");
                }
                else{
                    System.out.println(x);
                }
            }
            else if(instruction.equalsIgnoreCase("maxitem")){
                System.out.println(tree.maxItem());
            }
            else if(instruction.equalsIgnoreCase("minitem")){
                System.out.println(tree.minItem());
            }
            else if(instruction.equalsIgnoreCase("size")){
                System.out.println(tree.getSize());
            }
            else if(instruction.equalsIgnoreCase("height")){
                System.out.println(tree.getHeight());
            }
            else if (instruction.equalsIgnoreCase("inorder")){
                tree.printInorder();
            }
            else if(instruction.equalsIgnoreCase("preorder")){
                tree.printPreorder();
            }
            else if(instruction.equalsIgnoreCase("postorder")){
                tree.printPostorder();
            }
            else{
                System.out.println("not recognized");
            }
        }
        /*tree.searchItem(3);
        System.out.println(tree.getItemDepth(10));*/
        //tree.printInorder();
        /*int x=scanner.nextInt();
        scanner.nextLine();
        tree.Delete(x);
        tree.printInorder();
        /*tree.printPostorder();
        tree.printPreorder();
        tree.getInorderPredecessor(4);
        tree.getHeight();
        tree.getSize();
        tree.maxItem();
        tree.minItem();
        System.out.println(tree.getInorderSuccessor(3));
        System.out.println("dd"+tree.getSize());*/
    }
}
