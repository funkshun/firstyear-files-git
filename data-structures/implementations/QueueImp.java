public class QueueImp {
    public static void main(String[] args) {
        QueueImplementation q1 = new QueueImplementation(10);
        q1.enqueue(1.0);
        q1.enqueue(2.0);
        q1.enqueue(3.0);
        System.out.println(q1.dequeue());
        System.out.println(q1.dequeue());
        System.out.println(q1.dequeue());
    }    

}

class QueueImplementation {
    private int size;
    private Node current;
    private Node rear;

    public QueueImplementation(int s){
        size = s;
        current = null;
        rear = null;
    }

    public void enqueue(double d){
        
        Node n = new Node(d);
        if(current == null){
            current = n;
            return;
        }
        this.rear.setNext(n);
        this.rear = n;
    }

    public double dequeue(){
        Node tmp = current;
        current = current.getNext();
        return tmp.getVal();
    }
}

class Node{
    private double val;
    private Node next;
    
    public Node(double d, Node next){
        val = d;
        next = next;
    }

    public Node(double d){
        val = d;
        next = null;
    }

    public void setNext(Node n){
        this.next = n;
    }

    public double getVal(){
        return this.val;
    }
    
    public Node getNext(){
        return this.next;
    }

}
