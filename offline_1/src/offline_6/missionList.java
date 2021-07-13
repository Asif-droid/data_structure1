package offline_6;




class missionNode{
    int missionLocation;
    int pieces;
    missionNode next;
    missionNode prev;
    missionNode(int missionLocation,int pieces){
        this.missionLocation=missionLocation;
        this.pieces=pieces;
        this.prev=null;
        this.next=null;
    }
}

public class missionList {
    private missionNode front;
    private missionNode current;
    private int totalRemaining;
    missionList(){
        front=null;
        current=null;
        totalRemaining=0;
    }
    public void add(int location,int pieces){
        missionNode node=new missionNode(location,pieces);
        totalRemaining+=pieces;

        if(front==null){
            current=node;
            front=current;

        }
        else{
            missionNode oldNode=current;
            oldNode.next=node;
            node.prev=oldNode;
            current=node;

        }

    }
    public void start(){
        current=front;
    }
    public int peekLocation(){
        return  current.missionLocation;
    }
    public int getPieces(){
        return current.pieces;
    }
    public boolean isEmpty(){
        if(current==null||front==null){
            return true;
        }
        else {
            return false;
        }
    }
    public void delete(){
        missionNode prevNode=current.prev;
        missionNode nextNode=current.next;
        totalRemaining-=current.pieces;
        //System.out.println(totalRemaining+"deleting");
        if(prevNode!=null){
            prevNode.next=nextNode;
        }

        if(nextNode!=null){
            nextNode.prev=prevNode;
        }
        current=nextNode;
        if(totalRemaining<=0){
            front=null;
        }
    }
    public int getTotalRemaining(){
        return totalRemaining;
    }
    public void moveCurrent(){
        current=current.next;
    }
    public void changeFront(){
        front=current;
        current=current.next;
    }

}
