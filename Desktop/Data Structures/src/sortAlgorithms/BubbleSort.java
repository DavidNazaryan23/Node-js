package sortAlgorithms;

public class BubbleSort {


    public static void main(String[] args) {


        int[] unsortedArray = {9,8,7,5,12,13,14,15,16};


        int count = 0; // checking if the didSwap works correctly

        for(int i =0; i<unsortedArray.length-1;i++){

            boolean didSwap = false;


            for(int j = 0; j<unsortedArray.length-1-i; j++){

                if(unsortedArray[j]>unsortedArray[j+1]) {


                    int temp = unsortedArray[j];
                    unsortedArray[j] = unsortedArray[j + 1];
                    unsortedArray[j + 1] = temp;
                    didSwap = true;
                }

            }



            if(!didSwap) break;
            else count++;

        }

        System.out.println(count);
        for(int i : unsortedArray){
            System.out.println(i);
        }


    }





//  O(n^2) stable



}
