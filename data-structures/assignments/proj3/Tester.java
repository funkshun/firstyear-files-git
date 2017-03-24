import java.util.*;
public class Tester {
   
    public static void main(String[] args) {
        Random r = new Random();
        int N = 5000000; 
        PQasSortedArray<Double> pq1 = new PQasSortedArray<Double>(N);
        PQasSortedArray<Double> pq2 = new PQasSortedArray<Double>(10);
        PriorityQueue<Double> jpq1 = new PriorityQueue<Double>(N);
        
        long sum1, sum2, sum3;
        sum1 = 0;
        sum2 = 0;
        sum3 = 0;
        double[] arr4 = new double[N];
        double[] arr3 = new double[N];
        double[] arr5 = new double[N];
        for(int s = 0; s < 10; s++){
            long startTime, endTime;
                for(int j =0; j < arr4.length; j++){
                    arr4[j] = r.nextDouble();
                    arr3[j] = arr4[j];
                    arr5[j] = arr4[j];
                }
                startTime = System.nanoTime();
                    for (int z =0; z < arr4.length; z++)pq1.insert(arr4[z]);
                    for (int z =arr4.length-1; z >=0 ; z--)arr4[z] = pq1.deleteMin();
                endTime = System.nanoTime();
                sum1 = ((endTime - startTime)/1000000) + sum1; 
                
                startTime = System.nanoTime();
                    for (int z =0; z < arr3.length; z++)jpq1.offer(arr3[z]);
                    for (int z =arr3.length-1; z >=0; z--)arr3[z] = jpq1.poll();
                endTime = System.nanoTime();
                sum2 = ((endTime - startTime)/1000000) + sum2; 
        
                startTime = System.nanoTime();
                    heapSort(arr5);
                endTime = System.nanoTime();
                sum3 = ((endTime - startTime)/1000000) + sum3; 


            /*double[] arrTest = {5.0, 7.0, 3.0, 2.0, 8.0, 9.0, 4.0, 6.0, 1.0, 10.0};
            arrTest = heapSort(arrTest);
            for(int i = 0; i < arrTest.length; i++){
                System.out.print(arrTest[i] + " ");
            }*/
        }
        long avg1, avg2, avg3;
        avg1 = sum1 / 10L;
        avg2 = sum2 / 10L;
        avg3 = sum3 / 10L;
        System.out.println("Over " + N + " elements, " + avg1 + ", " + avg2 + ", " + avg3);
    }
    

    public static double[] heapSort(double[] arr){
        
        heapify(arr, arr.length);
        int end = arr.length - 1;
        while(end > 0){
            double temp = arr[0];
            arr[0] = arr[end];
            arr[end] = temp;
            end--;
            siftDown(arr, 0, end);
        }
        return arr;
    }
    
    private static void heapify(double[] arr, int count){
        int start = (count - 2) / 2;
        
        while(start >= 0){
            siftDown(arr, start, count - 1 );
            start--;
        }
        
    }
        
    private static void siftDown(double[] arr, int start, int end){
        int left, right, max;
        left = 2 * start + 1;
        right = left + 1;
        max = start;
        
        if(left <= end && arr[max] < arr[left]){
            max =left;
        }
        if(right <= end && arr[max] < arr[right]){
            max = right;
        }
        if(max != start){
            double temp;
            temp = arr[max];
            arr[max] = arr[start];
            arr[start] = temp;
            siftDown(arr, max, end);
        }


    }
/*    private static void siftUp(double[] arr, int start){
        double temp;
        int i;
        if(start != 0){
            i = (start - 1) / 2;
            if(arr[i] < (arr[start])){
                temp = arr[start];
                arr[start] = arr[i];
                arr[i] = temp;
                siftUp(arr, i);
            }
        }
        
    }*/
}
