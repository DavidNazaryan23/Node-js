package sortAlgorithms;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {23, 4351, 21, 2, 3, 1, 232, 54, 3, 22, 3221, 4, 7777};


        for(int i = 1; i<arr.length; i++){


            int temp = arr[i];

           int j;

           for( j = i; j>0 && arr[j-1] > temp; j--){

               arr[j] = arr[j-1];
           }

           arr[j] = temp;




        }



        for(int i : arr){
            System.out.println(i);
        }

    }
}

// O(n^2) stable