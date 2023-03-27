import java.util.Arrays;
import java.util.Random;
public class BinarySearch {

    public static double[] test(int[] input,String how){
        double sum = 0;
        int count = 0;
        double[] arr = new double[10];
        int[] sizes = {500,1000,2000,4000,8000,16000,32000,64000,128000,250000};
        int[] subset;
        long time;
        double timeD;
        Random rand = new Random();
        int randomindex;
        for(int size: sizes){
            subset = Arrays.copyOf(input,size);
            for (int i = 0; i < 1000; i++) {
                randomindex = rand.nextInt(0,size);
                time = System.nanoTime();
                search(subset,subset[randomindex]);
                sum += System.nanoTime() - time;
            }
            timeD = (sum / 100000000);
            arr[count++] = timeD;
            System.out.println(how + " " + size +" Input size for BinarySearch Algorithm: " + (timeD) + " seconds");
            sum = 0;
        }

        return arr;
    }

    public static int search(int[] arr,int val){
        int low = 0;
        int high = arr.length - 1;

        while (low <= high){

            int mid = (low + high) / 2;
            int midNum = arr[mid];

            if(val == midNum) return mid;
            if(midNum > val) high = mid - 1;
            else low = mid+1;

        }
        return -1;
    }
}
