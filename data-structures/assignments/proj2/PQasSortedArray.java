public class PQasSortedArray<C extends Comparable<?super C>> implements PQ<C>{

    private C[] arr;
    private int currentSize;
    public PQasSortedArray(int size){
        arr = (C[]) new Comparable[size];
        currentSize = 0;
    }

    public boolean isFull(){
        return currentSize == arr.length;
    }
    public boolean isEmpty(){
        return currentSize == 0;
    }
    public void insert(C data){
            int i;
            if(this.isEmpty()){
                arr[0] = data;
            }
            else if(data == null){
                throw new RuntimeException();
            }
            else{
                for(i = 0; i < arr.length - 1; i++){
                    if(arr[i] == null || arr[i].compareTo(data) < 0){
                        break;
                    }
                }
                for(int k = arr.length -2; k >=i; k--){
                    arr[k+1] = arr[k];
                }
                arr[i] = data;
            }
        currentSize++;
    }
    public C min(){
        return arr[0];
    }
    public C deleteMin(){
        C ret = arr[0];
        C temp;
        for(int i = 0; i < currentSize-1; i++){
            arr[i] = arr[i+1];
        }
        currentSize--;
        return ret;
    }

    
}
