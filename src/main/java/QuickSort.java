import java.util.Arrays;
import java.util.Random;

public class QuickSort{

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
            System.out.println(how + " " + size +" Input size for QuickSort Algorithm: " + (timeD) + " seconds");
            sum = 0;
        }

        return arr;
    }
    public static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    public static void sort(int[] array, int lowIndex, int highIndex) {
        int stackSize = highIndex - lowIndex + 1;
        int[] stack = new int[stackSize];
        int top = -1;
        stack[++top] = lowIndex;
        stack[++top] = highIndex;

        while (top >= 0){

            highIndex = stack[top--];
            lowIndex = stack[top--];

            int pivotIndex = partition(array,lowIndex,highIndex);

            if(pivotIndex - 1 > lowIndex){
                stack[++top] = lowIndex;
                stack[++top] = pivotIndex - 1;
            }

            if(pivotIndex + 1 < highIndex) {
                stack[++top] = pivotIndex + 1;
                stack[++top] = highIndex;
            }
        }
    }

    private static int partition(int[] array, int lowIndex, int highIndex) {
        int pivot = array[highIndex];
        int i = lowIndex - 1;
        for (int j = lowIndex; j < highIndex; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array,i + 1, highIndex);
        return  i + 1;
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

}

