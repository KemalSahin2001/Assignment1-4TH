import java.util.*;

public class BucketSort {

    public static double[] test(int[] input,String how){
        double sum = 0;
        int count = 0;
        double[] arr = new double[10];
        int[] sizes = {500,1000,2000,4000,8000,16000,32000,64000,128000,250000};
        int[] subset;
        long time;
        double timeD;

        for(int size: sizes){
            subset = Arrays.copyOf(input,size);
            for (int i = 0; i < 10; i++) {
                time = System.currentTimeMillis();
                sort(subset);
                sum += System.currentTimeMillis() - time;
            }
            timeD = (sum / 10000);
            arr[count++] = timeD;
            System.out.println(how + " " + size +" Input size for BucketSort Algorithm: " + (timeD) + " seconds");
            sum = 0;
        }

        return arr;
    }

    public static void sort(int[] arr){sort(arr,arr.length);}
    public static void sort(int[] arr,int n){
        if (n <= 0) return;

        final int numberOfBuckets = (int) Math.sqrt(arr.length);
        int max = findMax(arr);

        //Create n empty buckets
        Vector<Integer>[] buckets = new Vector[n];
        for (int i = 0; i < n; i++) buckets[i] = new Vector<>();

        //Put array elements in different buckets
        for (int i : arr){
            buckets[hash(i,max,numberOfBuckets)].add(i);
        }

        // Sort individual buckets
        for (int i = 0; i < n; i++) Collections.sort(buckets[i]);

        // 4) Concatenate all buckets into arr[]
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets[i].size(); j++) arr[index++] = buckets[i].get(j);
        }
    }
    private static int hash(int i, int max, int numberOfBuckets) { return (int) ((double) i / max * (numberOfBuckets - 1));}
    private static int findMax(int[] input) {
        int m = Integer.MIN_VALUE;
        for (int i : input) m = Math.max(i, m);
        return m;
    }
}
