package sortAlgorithms;

import java.nio.file.Paths;

public class quickSort {


    public static void main(String[] args) {
        int[] arr = {23, 4351, 21, 2, 3, 1, 232, 54, 3, 22, 3221, 4, 7777};



        quickSort(arr,0, arr.length);





        for(int i : arr){
            System.out.println(i);
        }

    }

    public static void quickSort(int[] inputArray, int start, int end){

        if(end- start<2){
            return;
        }


        int sortedPivot = findPivotPosition(inputArray, start, end);
        quickSort(inputArray, start,sortedPivot);
        quickSort(inputArray, sortedPivot+1, end);


    }

    private static int findPivotPosition(int[] inputArray, int start, int end) {

        int pivot = inputArray[start];
        int i = start;
        int j = end;

        while (i<j){

            while (i<j && inputArray[--j]>=pivot);
            if (i<j) inputArray[i] = inputArray[j];

            while (i<j && inputArray[++i]<=pivot);
            if (i<j) inputArray[j]=inputArray[i];


        }

        inputArray[i] = pivot;
        return j;

    }


}
