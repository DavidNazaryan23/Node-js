package sortAlgorithms;

public class SelectionSort {


    public static void main(String[] args) {


        int[] theArray = {23, 4351, 21, 2, 3, 1, 232, 54, 3, 22, 3221, 4, 7777};



        for (int i = 0; i <theArray.length-1;i++){

            int min = i;

            for(int j = i+1; j<theArray.length-1;j++){
                if(theArray[j]<=theArray[min]){

                    min = j;

                }
            }

            int temp = theArray[min];
            theArray[min] = theArray[i];
            theArray[i] = temp;


        }

        for(int i: theArray){
            System.out.println(i);
        }

    }
}

//O(n^2) unstable