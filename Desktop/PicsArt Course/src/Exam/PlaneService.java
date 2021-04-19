package Exam;

import java.util.Scanner;

public class PlaneService {



    public Plane createPlane(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter The Model of the Plane");
        String model = sc.next();

        System.out.println("Enter The Country of the Plane");
        String country = sc.next();

        System.out.println("Enter The Manufacturing Year ");
        int year = sc.nextInt();

        System.out.println("Enter The Number of Hours in air ");
        int hours = sc.nextInt();

        System.out.println("Is The Plane military? (y/n)");
        boolean isMilitary = sc.next().charAt(0) == 'y';

        System.out.println("Enter The Weight");
        int weight = sc.nextInt();

        System.out.println("Enter The Top Speed");
        int speed = sc.nextInt();

        System.out.println("Enter The Number of Seats");
        int seats = sc.nextInt();

        System.out.println("Enter The Cost");
        double cost = sc.nextDouble();

        Plane newPlane =  new Plane(model,country,year,hours);
        newPlane.setWeightInKG(weight);
        newPlane.setTopSpeedInKMh(speed);
        newPlane.setSeatNum(seats);
        newPlane.setCost(cost);
        newPlane.setMilitary(isMilitary);

        return newPlane;
    }


    //Task 1
    public void printInfoIfMilitary(Plane plane1){
        if(plane1.isMilitary()){
            System.out.println("Military Plane - Cost: " + plane1.getCost() + ", Top Speed: " +
                    plane1.getTopSpeedInKMh());
        } else {
            System.out.println("Not a Military Plane - Model: " + plane1.getModel() + ", Country: " +
                    plane1.getCountry());
        }

    }

    //Task 2
    public Plane newerPlane(Plane plane1, Plane plane2){

        return plane1.getYear()<=plane2.getYear()? plane1:plane2;
    }

    //Task 3
    public void printCountryOfSmallestSeatCount(Plane plane1, Plane plane2, Plane plane3){

        Plane smallest = plane1.getSeatNum()<=plane2.getSeatNum()? plane1:plane2;
        smallest = smallest.getSeatNum()<=plane3.getSeatNum()? smallest:plane3;

        System.out.println("The country of the plane with the smallest seat number: " + smallest.getCountry());

    }

    //Task 4
    public void printNotMilitaryPlanes(Plane[] planes){

        for(Plane plane : planes){
            if (!plane.isMilitary()){
                System.out.println(plane);
            }
        }
    }


    //Task 5
    public void printMilitaryPlanesOverHundredHours(Plane[] planes){

        for(Plane plane : planes){
            if (plane.isMilitary() && plane.getHours()>100){
                System.out.println(plane);
            }
        }
    }

    //Task 6
    public Plane lightestPlane(Plane[] planes){

        Plane lightest = planes[0];

        for (int i = 1; i<planes.length; i++){

            if(planes[i].getWeightInKG()<= lightest.getWeightInKG()){
                lightest = planes[i];
            }

        }

        return lightest;
    }


    // Task 7
    public Plane minimalCostMilitaryPlane(Plane[] planes){

        Plane minimalCostMilitary = null;

        for (int i = 0; i<planes.length; i++){
            if(planes[i].isMilitary()){
                if(minimalCostMilitary==null){
                    minimalCostMilitary = planes[i];
                } else {
                    if(minimalCostMilitary.getCost()>planes[i].getCost()){
                        minimalCostMilitary = planes[i];
                    }
                }
            }
        }

        return minimalCostMilitary;
    }

    //Task 8
    public void printPlanesSorted(Plane[] planes){

        boolean isActive = true;
        int count = 0;
        while (isActive){
            isActive = false;

            for(int i =0; i<planes.length-1-count; i++){
                if(planes[i].getYear() > planes[i+1].getYear()){
                    Plane x = planes[i];
                    planes[i] = planes[i+1];
                    planes[i+1] = x;
                    isActive = true;
                }
            }
            count++;
        }

        for (Plane plane : planes){
            System.out.println(plane);
        }




    }





}
