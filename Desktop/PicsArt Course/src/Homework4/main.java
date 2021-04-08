package Homework4;

public class main {


    public static void main(String[] args) {

        int[] arr = {12,-1,312,32,4321,-232,23,4,8};

        System.out.println("Unsorted");
        for(int i : arr){
            System.out.print(i+" ");
        }
        bubbleSort(arr);

        System.out.println();
        System.out.println("Sorted");
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();

        //Task 2

        BankAccount myAccount = new BankAccount("Davit", "Nazaryan", "+37494583034", 233123, -120, false, 15 );

        System.out.println(myAccount);


    }

    public static void bubbleSort(int[] array) {
        int tempVar = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < (array.length - i); j++) {
                if (array[j - 1] > array[j]) {
                    //swap elements
                    tempVar = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = tempVar;
                }

            }
        }

    }
}
