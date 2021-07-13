package offline_4;

class binary_node {
    public int value;
    public binary_node lft_tree;
    public binary_node rt_tree;
    public binary_node parent;
    public binary_node(int value){
        this.value=value;
        lft_tree=null;
        rt_tree=null;
        parent=null;
    }

}
public class binary_tree{
    private binary_node root;
    private binary_node current;
    private binary_node psudo_parnt;
    private int size=0;
    public binary_tree(){
        root=null;
        current=null;
        psudo_parnt=null;
    }
    public void insert(binary_node node){
        if(root==null){
            root=node;
            size+=1;

        }
        else {
            current=root;
            //System.out.println(current.value);

            while(true){
                if(current.value<node.value){       //go to the right sub tree when new value is small
                    psudo_parnt=current;
                    if(current.rt_tree==null){
                        node.parent=current;
                        current.rt_tree=node;
                        size+=1;
                        //System.out.println(current.rt_tree.parent.value+"frm");
                        break;
                    }

                    current=current.rt_tree;

                }
                else{                                 //go to left sub tree when new value is large
                    psudo_parnt=current;
                    if(current.lft_tree==null){
                        node.parent=psudo_parnt;
                        current.lft_tree=node;
                        size+=1;
                        break;
                    }
                    current=current.lft_tree;
                }
            }
            //current=node;
            //current.parent=psudo_parnt;

            //System.out.println(current.value+"parent"+current.parent.value);
            //System.out.println(current.parent.rt_tree.value);

        }
    }

    public int maxItem(){
        current=root;
        while(true){
            if(current.rt_tree==null){              //max item will not have a right sub tree
                return current.value;
            }
            current=current.rt_tree;
        }
    }
    public int minItem(){
        current=root;
        while(true){                                //min item will not have a left sub tree
            if(current.lft_tree==null){
                return current.value;
            }
            current=current.lft_tree;
        }
    }
    public int getItemDepth(int x){
        int depth=0;
        current=root;
        while(true){
            if(current.value==x){
                return depth;

            }
            else if(current.value<x){                   //increases the depth for every node traverse from root
                if(current.rt_tree==null){
                    break;
                }
                current=current.rt_tree;
                depth+=1;
            }
            else{
                if(current.lft_tree==null){
                    break;
                }
                current=current.lft_tree;
                depth+=1;
            }
        }



        return -1;
    }
    public boolean find(int x){
        current=root;
        while(true){
            if(current.value==x){

                return true;
            }
            else if(current.value<x){
                if(current.rt_tree==null){
                    break;
                }
                current=current.rt_tree;
            }
            else {
                if(current.lft_tree==null){
                    break;
                }
                current=current.lft_tree;
            }

        }
        return false;
    }
    public void searchItem(int x){
        current=root;
        boolean found=false;
        if(find(x))
            System.out.println(x+" found");

        else
            System.out.println(x+" not found");

    }
    public void leafDelete(int n){
        psudo_parnt=current.parent;
        size-=1;
        //System.out.println(current.value+"deling");
        // deleting the node from parent node

        if(psudo_parnt.rt_tree!=null)
        {
            if(psudo_parnt.rt_tree.value==n){
                psudo_parnt.rt_tree=null;
            }
            else {
                psudo_parnt.lft_tree=null;
            }

        }

        else {
            psudo_parnt.lft_tree=null;
        }
    }
    public void node1cDelete(int n){                      //bypassing the reference from parent of node to child of node
        psudo_parnt=current.parent;
        size-=1;
        //System.out.println(current.value+"deling");
        if(current.lft_tree==null){
            if(psudo_parnt.rt_tree.value==n){
                psudo_parnt.rt_tree=current.rt_tree;
            }
            else{
                psudo_parnt.lft_tree=current.rt_tree;
            }
        }
        else{
            if(psudo_parnt.rt_tree.value==n){
                psudo_parnt.rt_tree=current.lft_tree;
            }
            else{
                psudo_parnt.lft_tree=current.lft_tree;
            }
        }
    }

    public void Delete(int n){
        current=root;

        while(true){
            if(current==null){
                return;
            }
            if(current.value==n){
                if(current.lft_tree==null && current.rt_tree==null){
                    leafDelete(n);
                }
                else if(current.lft_tree==null || current.rt_tree==null){
                    //System.out.println("del frm"+n);
                    node1cDelete(n);
                }
                else{
                    psudo_parnt=current;                                //if both the child are not null then we find
                                                                        //the left most in the right sub-tree


                    while(current.lft_tree!=null){
                        if(current.rt_tree!=null)
                            current=current.rt_tree;
                        else
                            current=current.lft_tree;
                        //System.out.println(temp.value+"del");
                    }
                    psudo_parnt.value=current.value;                   //we replace the value of node with left most one
                    //System.out.println(current.lft_tree.value);
                    //current=temp;
                                                                        //we delete the left most node
                    if( current.rt_tree==null){
                        leafDelete(current.value);
                    }
                    else{
                        node1cDelete(current.value);
                    }

                }
                return;
            }
            else if(current.value<n){
                current=current.rt_tree;
            }
            else if(current.value>n){
                current=current.lft_tree;
            }

        }

    }
    public int getInorderSuccessor(int n){
        //System.out.println(n+"from fnc");
        if(find(n)){                                    //either it is in the right sub tree
            if(current.rt_tree!=null){
                binary_node temp=current.rt_tree;
                while(temp.lft_tree!=null){
                    temp=temp.lft_tree;
                }
                return temp.value;
            }
            else{                                       //or in the parents
                while(current!=null){
                    if(current.value>n){
                        return current.value;
                    }
                    current=current.parent;

                }
            }

        }else{
            System.out.println("item not found");
        }
        return -1;

    }
    public int getInorderPredecessor(int n){
        if(find(n)){
            if(current.lft_tree!=null){
                binary_node temp=current.lft_tree;
                while(temp.rt_tree!=null){
                    temp=temp.rt_tree;
                }
                return temp.value;
            }
            else{
                while(current!=null){
                    if(current.value<n){
                        return current.value;
                    }
                    current=current.parent;

                }
            }

        }
        else{
            System.out.println("item not found");
        }
        return -1;
    }
    int max(int a, int b){
        if(a>b)
            return a;
        else
            return b;
    }
    public int getHeight(){
        //System.out.println(root.value+"h");
        return height(root);
    }

    public int height(binary_node node){
        if (node==null){                                //finds the height of left and right sub tree
            return -1;                                      //two node consists 1 height
        }
        int l_h=height(node.lft_tree);
        int r_h=height(node.rt_tree);
        return max(l_h,r_h)+1;                          //the maximum is the height and adding 1 we have the height of the node
    }
    public int getSize(){
       return nodeCount(root);
    }
    public int nodeCount(binary_node node){
        if(node==null){
            return 0;
        }
        int l_h=nodeCount(node.lft_tree);
        int r_h=nodeCount(node.rt_tree);
        return l_h+r_h+1;

    }
    public void printInorder(){
        inOrder(root);
    }
    public void inOrder(binary_node node){
        if(node==null){
            return;
        }
        inOrder(node.lft_tree);
        System.out.println(node.value);
        inOrder(node.rt_tree);

    }
    public void printPreorder(){
        preOrder(root);

    }
    public void preOrder(binary_node node){
        if (node==null){
            return;
        }
        System.out.println(node.value);
        preOrder(node.lft_tree);
        preOrder(node.rt_tree);
    }
    public void printPostorder(){
        postOrder(root);

    }
    public void postOrder(binary_node node){
        if(node==null){
            return;
        }
        postOrder(node.lft_tree);
        postOrder(node.rt_tree);
        System.out.println(node.value);

    }
    public void show(){
        System.out.println("show called");
        current=root;
        System.out.println(current.value);
        while (current.lft_tree!=null){
            current=current.lft_tree;
        }
        //current=current.parent;
        while (current!=null){
            System.out.println(current.value);
            
            current=current.parent;
        }

    }


}
