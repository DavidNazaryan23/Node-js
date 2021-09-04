package sortAlgorithms;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {23, 4351, 21, 2, 3, 1, 232, 54, 3, 22, 3221, 4, 7777};

        mergeSort(arr, 0,arr.length);



        for(int i : arr){
            System.out.println(i);
        }
    }

    public static void mergeSort(int[] input, int start, int end){
        if(end-start<2){
            return;
        }


        int mid = (end+start)/2;

        mergeSort(input, 0,mid);
        mergeSort(input,mid,end);
        merge(input,start,mid,end);

    }

    public static void merge(int[] input, int start, int mid, int end){
        if(input[mid-1] <= input[mid]){
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int [] temp = new int[end - start];

        while (i<mid && j<end){
            temp[tempIndex++] = (input[i]<=input[j])? input[i++]: input[j++];
        }


        System.arraycopy(input, i, input, start+tempIndex, mid-i);
        System.arraycopy(temp, 0,input, start, tempIndex);


    }

}

//O(n*logn) , stable