public class Queue<T> {
    private T[] arr;
    private int pointer;
    private int size;

    public Queue(int capacity){
        arr = (T[]) new Object[capacity];
        pointer = 0;
        size = capacity;
    }

    public boolean isEmpty(){
        return arr.isEmpty(); 
    }

    public boolean isFull(){
        return !(arr.isEmpty());
    }

    public T peek(){
        return arr[]
    }
    
}
