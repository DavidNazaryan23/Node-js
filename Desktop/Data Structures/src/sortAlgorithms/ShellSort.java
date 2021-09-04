package sortAlgorithms;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {23, 4351, 21, 2, 3, 1, 232, 54, 3, 22, 3221, 4, 7777};





        for(int gap = arr.length/2; gap>0; gap/=2){



            for(int i = gap; i<arr.length;i++){


                int element = arr[i];

                int j = i;

                while (j >=gap && arr[j-gap]>=element){
                    arr[j] = arr[j-gap];
                    j-=gap;
                }
                arr[j] = element;



            }








        }








        for (int i : arr) {
            System.out.println(i);
        }
    }
}

// Worst case O(n^2) but usually much faster.  unstable