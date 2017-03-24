public class PQasSortedArray<C extends Comparable<?super C>> implements PQ<C> {
    private C[] arr; // store the elements in the priority queue IN SORTED ORDER
    private int currentSize;
    public PQasSortedArray(int size){
        arr =  (C[]) new Comparable[size];
        currentSize = 0;
    }
    public boolean isFull(){
        return currentSize == arr.length;
    }
    public boolean isEmpty(){
        return currentSize == 0;
    }
    public void insert(C data){
        arr[currentSize] = data;
        currentSize++;
        siftUp(currentSize - 1);

    }
    public C min(){
        return arr[0];
    }
    public C deleteMin(){
        C temp = arr[0];
        arr[0] = arr[currentSize - 1];
        currentSize--;
        siftDown(0);
        return temp;
    }
    private void siftUp(int start){
        C temp;
        int i;
        if(start != 0){
            i = (start - 1) / 2;
            if(arr[i].compareTo(arr[start]) > 0){
                temp = arr[start];
                arr[start] = arr[i];
                arr[i] = temp;
                siftUp(i);
            }
        }
        
    }
    private void siftDown(int start){
        int left, right, min;
        C temp;
        left = (start * 2) + 1;
        right = left + 1;
        if(right >= currentSize){
            if(left >= currentSize){
                return;
            }
            else{
                min = left;
            } 
        }
        else{
            if(arr[left].compareTo(arr[right]) < 0){
                min = left;
            }
            else{
                min = right;
            }
        }
        if(arr[start].compareTo(arr[min]) > 0){
            temp = arr[start];
            arr[start] = arr[min];
            arr[min] = temp;
            siftDown(min);
        }
    }

}
