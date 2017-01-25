




public class Stack<T> {
    private int size;
    private int currentSize;
    private T[] arr;
    private Node<T> top;

    public Stack(int capacity){
        this.size = capacity;
        arr = (T[]) new Object[size];
        top = null;
        currentSize =0;
    }

    public boolean isEmpty(){
        return currentSize == 0;
    }

    public boolean isFull(){
        return !(currentSize == size);
    }
    
    public T peek(){
        if(!(isEmpty())){
            return top.getData();
        }
        else{
            return null;
        }
    }

    public T pop(){
        if(!(isEmpty())){
            T tmp = top.getData();
            this.top = top.getNext();
            currentSize--;
            return tmp;
        }
        else{
            return null;
        }
    }

    public void push(T element){
        if(isEmpty()){
            top = new Node<T>(element);
            currentSize++;
            return;
        }
        else{
            Node<T> tmp = top;
            top = new Node<T>(element);
            top.setNext(tmp);
            currentSize++;
        }
    }
    
    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<Integer>(10);
        s1.push(1);
        s1.push(2);
        s1.push(3);
        System.out.println(s1.pop());
        System.out.println(s1.peek());
        System.out.println(s1.pop());
        System.out.println(s1.pop());
    }
    

    
}

class Node<T>{
    private T data;
    private Node<T> next;

    public Node(T d, Node<T> n){
        data = d;
        next = n;
    }

    public Node(T d){
        data = d;
        next = null;
    }

    public T getData(){
        return data;
    }

    public Node<T> getNext(){
        return next;
    }
    public void setNext(Node<T> n){
        next = n;
    }

}



