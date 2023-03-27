import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

class Main {
    public static void main(String args[]) throws IOException {
        int[] arr = new int[250000];
        try{
            BufferedReader scan = new BufferedReader(new FileReader
                    ("D:\\Assignments\\Assignment1\\src\\main\\java\\data.csv"));
            scan.readLine();
            for (int j = 0; j < 250000; j++) arr[j] = Integer.parseInt(scan.readLine().split(",")[6]);
            scan.close();
        }
        catch (Exception e){
            System.out.println("File not found");
        }

        //Random input SelectionSort
        double[] RandominputSelectionSort = SelectionSort.test(arr,"Random");
        System.out.println("------------------------------------------------------------------------------");

        //Random input BucketSort
        double[] RandominputBucketSort = BucketSort.test(arr,"Random");
        System.out.println("------------------------------------------------------------------------------");

        //Random input QuickSort
        double[] RandominputQuickSort = QuickSort.test(arr,"Random");
        System.out.println("------------------------------------------------------------------------------");

        //Random input LinearSearch
        double[] RandominputLinearSearch = LinearSearch.test(arr,"Random");
        System.out.println("------------------------------------------------------------------------------");


        //Sorting
        Arrays.sort(arr);

        //Sorted input SelectionSort
        double[] SortedinputSelectionSort = SelectionSort.test(arr,"Sorted");
        System.out.println("------------------------------------------------------------------------------");

        //Sorted input BucketSort
        double[] SortedinputBucketSort = BucketSort.test(arr,"Sorted");
        System.out.println("------------------------------------------------------------------------------");

        //Sorted input QuickSort
        double[] SortedinputQuickSort = QuickSort.test(arr,"Sorted");
        System.out.println("------------------------------------------------------------------------------");

        //Sorted input LinearSearch
        double[] SortedinputLinearSearch = LinearSearch.test(arr,"Sorted");
        System.out.println("------------------------------------------------------------------------------");

        //Sorted input BinarySearch
        double[] SortedinputBinarySearch = BinarySearch.test(arr,"Sorted");
        System.out.println("------------------------------------------------------------------------------");


        //Reversely Sorting
        reverse(arr);

        //Reversely Sorted input SelectionSort
        double[] ReverselySortedinputSelectionSort = SelectionSort.test(arr,"Reversely Sorted");
        System.out.println("------------------------------------------------------------------------------");

        //Reversely Sorted input BucketSort
        double[] ReverselySortedinputBucketSort = BucketSort.test(arr,"Reversely Sorted");;
        System.out.println("------------------------------------------------------------------------------");

        //Reversely Sorted input QuickSort
        double[] ReverselySortedinputQuickSort = QuickSort.test(arr,"Reversely Sorted");
        System.out.println("------------------------------------------------------------------------------");


        // X axis data
        int[] inputAxis = {500, 1000, 2000, 4000, 8000, 16000, 32000, 65000, 128000, 250000};

        // Random Sort
        double[][] yAxis = new double[3][10];
        yAxis[0] = RandominputSelectionSort;
        yAxis[1] = RandominputBucketSort;
        yAxis[2] = RandominputQuickSort;

        // Save the char as .png and show it
        showAndSaveChart("Random Input Sorting Algorithms", inputAxis, yAxis,true);


        // Sorted sort
        yAxis[0] = SortedinputSelectionSort;
        yAxis[1] = SortedinputBucketSort;
        yAxis[2] = SortedinputQuickSort;

        // Save the char as .png and show it
        showAndSaveChart("Sorted Input Sorting Algorithms", inputAxis, yAxis,true);


        // Reversely sorted sort
        yAxis[0] = ReverselySortedinputSelectionSort;
        yAxis[1] = ReverselySortedinputBucketSort;
        yAxis[2] = ReverselySortedinputQuickSort;

        // Save the char as .png and show it
        showAndSaveChart(" Reversely Sorted Input Sorting Algorithms", inputAxis, yAxis,true);

        // Search Algorithms
        yAxis[0] = RandominputLinearSearch;
        yAxis[1] = SortedinputLinearSearch;
        yAxis[2] = SortedinputBinarySearch;

        // Save the char as .png and show it
        showAndSaveChart("Search Algorithms", inputAxis, yAxis,false);

        System.out.println("Process finished.");
    }

    public static void showAndSaveChart(String title, int[] xAxis, double[][] yAxis,boolean sort) throws IOException {
        // Create Chart
        XYChart chart = new XYChartBuilder().width(800).height(600).title(title)
                .yAxisTitle("Time in Seconds").xAxisTitle("Input Size").build();

        // Convert x axis to double[]
        double[] doubleX = Arrays.stream(xAxis).asDoubleStream().toArray();

        // Customize Chart
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNE);
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);

        // Add a plot for a sorting algorithm
        if(sort) {
            chart.addSeries("Selection Sort", doubleX, yAxis[0]);
            chart.addSeries("Bucket Sort", doubleX, yAxis[1]);
            chart.addSeries("Quick Sort", doubleX, yAxis[2]);
        }
        else {
            chart.addSeries("Random LinearSearch", doubleX, yAxis[0]);
            chart.addSeries("Sorted LinearSearch Sort", doubleX, yAxis[1]);
            chart.addSeries("BinarySearch", doubleX, yAxis[2]);
        }

        // Save the chart as PNG
        BitmapEncoder.saveBitmap(chart, title + ".png", BitmapEncoder.BitmapFormat.PNG);

        // Show the chart
        new SwingWrapper(chart).displayChart();
    }

    public static void reverse(int[] array)
    {
        // Length of the array
        int n = array.length;

        // Swapping the first half elements with last half
        // elements
        for (int i = 0; i < n / 2; i++) {

            // Storing the first half elements temporarily
            int temp = array[i];

            // Assigning the first half to the last half
            array[i] = array[n - i - 1];

            // Assigning the last half to the first half
            array[n - i - 1] = temp;
        }
    }

}
