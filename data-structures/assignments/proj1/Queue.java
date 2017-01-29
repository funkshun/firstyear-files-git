//package proj1;

public class Queue<T> {
    private T[] arr;
    private int pointer;
    private int rear;
    private int members;
    private int size;

    public Queue(int capacity){
        arr = (T[]) new Object[capacity];
        pointer = 0;
        rear = 0;
        members = 0;
        size = capacity;
    }

    public boolean isEmpty(){
        return members == 0; 
    }

    public boolean isFull(){
        return members == size;
    }

    public T peek(){
        if(isEmpty()){
            throw new RuntimeException("No Values in Queue"); 
        }
        return arr[pointer];
    }

    public T dequeue(){
        if(isEmpty()){
            throw new RuntimeException("No Values in Queue");
        }
        members--;
        T tmp = arr[pointer];
        pointer = (pointer + 1) % size;
        return tmp;
    }

    public void enqueue(T element){
        if(isFull()){
            throw new RuntimeException("Queue is Full");
        }
        arr[rear] = element;
        rear = (rear + 1) % size;
        members++;
    }
    
    public int getMembers(){
        return this.members;
    }
    
    //testing
    /*public static void main(String[] args) {
        Queue<Integer> q1 = new Queue<Integer>(10);
        q1.enqueue(1);
        q1.enqueue(2);
        q1.enqueue(3);
        q1.enqueue(4);
        q1.enqueue(5);
        System.out.println(q1.dequeue());
        System.out.println(q1.peek());
        System.out.println(q1.dequeue());
        System.out.println(q1.dequeue());
        System.out.println(q1.dequeue());
        System.out.println(q1.dequeue());
        q1.enqueue(7);
        q1.enqueue(8);
        q1.enqueue(9);
        q1.enqueue(10);
        q1.enqueue(11);
        System.out.println(q1.dequeue());
        System.out.println(q1.peek());
        System.out.println(q1.dequeue());
        System.out.println(q1.dequeue());
        System.out.println(q1.dequeue());
        System.out.println(q1.dequeue());
        q1.enqueue(12);
        q1.enqueue(13);
        q1.enqueue(14);
        q1.enqueue(15);
        q1.enqueue(16);
        System.out.println(q1.dequeue());
        System.out.println(q1.dequeue());
        System.out.println(q1.dequeue());
        System.out.println(q1.dequeue());
        System.out.println(q1.dequeue());
    }*/
    
}
