package Homework1_3;

public class Main {


    public static void main(String[] args) {


        //Task 1
        System.out.println("Task 1");
        int[] arr = new int[2];
        arr[0] = 1;
        arr[1] = 2;

        for(Integer i:arr){
            System.out.println(i);
        }
        System.out.println();

        // Task 2
        System.out.println("Task 2");
        int[] secondArr = new int[1000];

        for(int i = 0; i<secondArr.length;i++ ){
            secondArr[i] = i+1;
            System.out.print(secondArr[i]+" ");
        }
        System.out.println();
        System.out.println();

        //Task 3
        System.out.println("Task 3 ");
        int[] oddArr = new int[20];

        int index = 0;
        for(int i = -19; i<=19;i+=2){
            oddArr[index] = i;
            System.out.print(oddArr[index++] + " ");

        }
        System.out.println();
        System.out.println();

        //Task 4
        System.out.println("Task 4");
        int[] fourthArray = new int[100];
        for(int i = 0; i<fourthArray.length;i++){

            fourthArray[i] = (int)((Math.random() * (100 + 1)) + 1); // create a random integer between 1 and 100
            if(fourthArray[i]%5==0){
                System.out.print(fourthArray[i] + " "); // print only the elements divisible by 5
            }

        }
        System.out.println();
        System.out.println();

        //Task 5
        System.out.println("Task 5");

        double[] fifthArray = new double[100];

        for(int i = fifthArray.length-1; i>=0 ; i--){
            fifthArray[i] =  Math.random()*(1000 + 1); //create a random double between 0 and 1000

            if(fifthArray[i]>24.12 && fifthArray[i]<467.23){
                System.out.print(  Math.round(fifthArray[i] * 100.0) / 100.0  + " "); //print ony the elements between 24.12 and 467.23, rounded up to the second decimal place
            }

        }
        System.out.println();
        System.out.println();

        //Task 6
        System.out.println("Task 6");

        int[] sixthArray = new int[100];

        int i = 0;
        int count = 0;
        while(i<sixthArray.length){

            sixthArray[i] =  (int)(Math.random()*(1000 + 1)); //create a random integer between 0 and 1000
            if(sixthArray[i]%2==0){
                System.out.print(sixthArray[i] + " "); // print only the even integers
                count++; // increment the count for every even integer
            }


            i++;
        }
        System.out.println();
        System.out.println(count);
        System.out.println();


        //Task 7
        System.out.println("Task 7");
        printMultiples(12);
        printMultiples(-12);


    }

    //task 7
    public static void printMultiples(int n){
        if(n<=0 || n>=21){
            System.out.println("Give a number between 0 and 21");
            return;
        }

        System.out.println("The number is " + n);

        for(int i = 1; i<11; i++){
            System.out.println( n + " * " + i + " = " + n*i);
        }

    }


}
