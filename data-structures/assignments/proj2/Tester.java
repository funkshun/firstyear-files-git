import java.util.*;
public class Tester {
   
    public static void main(String[] args) {
        Random r = new Random();
        int N = 1000000; 
        PQasSortedArray<Double> pq1 = new PQasSortedArray<Double>(N);
        PQasSortedArray<Double> pq2 = new PQasSortedArray<Double>(10);
        PriorityQueue<Double> jpq1 = new PriorityQueue<Double>(N);
        
        double[] arr4 = new double[N];
        double[] arr3 = new double[N];
        
/*        double[] arr1 = new double[10]; 
        for(int x = 0; x < 5; x++){    
        for(int j =0; j < arr1.length; j++){
                arr1[j] = r.nextDouble();
            }
        
        for (int z =0; z < arr1.length; z++)pq2.insert(arr1[z]);
        for (int z =arr1.length-1; z >=0 ; z--)arr1[z] = pq2.deleteMin();
        for (int z =0; z < arr1.length; z++){
            System.out.println(arr1[z]);
        }
        }*/
        long startTime, endTime;
            for(int j =0; j < arr4.length; j++){
                arr4[j] = r.nextDouble();
                arr3[j] = arr4[j];
            }
            startTime = System.nanoTime();
                for (int z =0; z < arr4.length; z++)pq1.insert(arr4[z]);
                for (int z =arr4.length-1; z >=0 ; z--)arr4[z] = pq1.deleteMin();
            endTime = System.nanoTime();
            System.out.println("Custom Implementation took" + ((endTime - startTime)/1000000) + " time units over "+ N +" elements");
 
            
            startTime = System.nanoTime();
                for (int z =0; z < arr3.length; z++)jpq1.offer(arr3[z]);
                for (int z =arr3.length-1; z >=0; z--)arr3[z] = jpq1.poll();
            endTime = System.nanoTime();
            System.out.println("Java Implementation took" + ((endTime - startTime)/1000000) + " time units over "+N+" elements");
         
    }
}
