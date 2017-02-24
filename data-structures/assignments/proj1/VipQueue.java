//package proj1;

public class VipQueue<T>{

    private int size;
    private Stack<T> vips;
    private Queue<T> norms;

    public VipQueue(int capacity){
        size = capacity;
        vips = new Stack<T>(size);
        norms = new Queue<T>(size);

    }

    public boolean isEmpty(){
        if(vips.isEmpty() && norms.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isFull(){
        if(vips.isFull() && norms.isFull()){
            return true;
        }
        else{
            return false;
        }
    }

    public T peek(){
        if(isEmpty()){
            throw new RuntimeException("No elements in queue");
        }
        else if(!(vips.isEmpty())){
            return vips.peek();
        }
        else{
            return norms.peek();
        }
    }

    public T dequeue(){
        if(isEmpty()){
            throw new RuntimeException("No elements in queue");
        }
        else if(!(vips.isEmpty())){
            return vips.pop();
        }
        else{
            return norms.dequeue();
        }
    }

    public void enqueue(T element){
        if(isFull()){
            throw new RuntimeException("Abstraction is Full");
        }
        else if(norms.isFull()){
            throw new RuntimeException("Abstraction is Full");
        }
        else{
            norms.enqueue(element);
        }
    }

    public void vipEnqueue(T element){
        if(isFull()){
            throw new RuntimeException("Abstraction is Full");
        }
        //else if(vips.isFull()){
        //    throw new RuntimeException("Abstraction is Full - sub");
        //}
        else{
            vips.push(element);
        }
    }

    public int count(){
        return vips.getMembers() + norms.getMembers();
    }
    
    //testing - throws exception to test catching
    /*public static void main(String[] args) {
        VipQueue<Integer> v1 = new VipQueue<Integer>(10);
        v1.enqueue(1);
        v1.enqueue(2);
        v1.enqueue(3);
        v1.enqueue(4);
        v1.enqueue(5);
        System.out.println(v1.dequeue());
        System.out.println(v1.dequeue());
        v1.vipEnqueue(10);
        System.out.println(v1.dequeue());
        System.out.println(v1.dequeue());
        System.out.println(v1.dequeue());
        System.out.println(v1.dequeue());
        System.out.println(v1.dequeue());
    }*/

} 

