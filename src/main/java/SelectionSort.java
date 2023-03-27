import java.util.Arrays;

public class SelectionSort {

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
            System.out.println(how + " " + size +" Input size for SelectionSort Algorithm: " + (timeD) + " seconds");
            sum = 0;
        }

        return arr;
    }

    public static int[] sort(int[] arr){ return sort(arr,arr.length);}

    private static int[] sort(int[] arr,int size){
        //variables
        int min;
        int t;

        //for i from 1 to size - 1 do
        for (int i = 0; i < size - 1; i++) {

            //min <- i
            min = i;

            //for j from i + 1 to n do
            for (int j = i + 1; j < size; j++) {

                //if list[j] < list[min] then min <-j
                if(arr[j] < arr[min]) min = j;
                //end if

            }
            //end for

            //if min != i swap list[min] and list[i]
            if(min != i){
                t = arr[min];
                arr[min] = arr[i];
                arr[i] = t;
            }
            //end if

        }
        //end for

        return arr;
        //end procedure
    }
}
