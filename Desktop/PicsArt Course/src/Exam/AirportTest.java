package Exam;

import java.util.Scanner;

public class AirportTest {

    public static void main(String[] args) {


        //Testing all the methods from PlaneService
//
//        Plane boeing = new Plane("Boeing", "France", 1950, 9000);
//
//        boeing.setWeightInKG(3000);
//        boeing.setTopSpeedInKMh(1000);
//        boeing.setSeatNum(100);
//        boeing.setCost(543.2);
//
//        System.out.println(boeing);
//
//        System.out.println();
//        Plane airBus = new Plane("AirBus", "England", 1960, 9500);
//        airBus.setWeightInKG(3400);
//        airBus.setTopSpeedInKMh(1200);
//        airBus.setSeatNum(80);
//        airBus.setCost(321.4);
//        airBus.setMilitary(true);
//
//        Plane armenianPlane = new Plane("Armenian", "Armenia", 2000, 1400);
//        armenianPlane.setWeightInKG(5400);
//        armenianPlane.setTopSpeedInKMh(1300);
//        armenianPlane.setSeatNum(120);
//        armenianPlane.setCost(400.0);
//        armenianPlane.setMilitary(false);
//
//        Plane russianPlane = new Plane("Russian", "Russia", 2015, 50);
//        russianPlane.setWeightInKG(5400);
//        russianPlane.setTopSpeedInKMh(1300);
//        russianPlane.setSeatNum(120);
//        russianPlane.setCost(400.0);
//        russianPlane.setMilitary(true);
//
//        System.out.println(airBus);
//
//        System.out.println();
//        PlaneService service1 = new PlaneService();
//        service1.printInfoIfMilitary(boeing);
//        service1.printInfoIfMilitary(airBus);
//
//        System.out.println();
//        System.out.println(service1.newerPlane(boeing,airBus));
//
//        System.out.println();
//        service1.printCountryOfSmallestSeatCount(armenianPlane, airBus, boeing);
//
//
//        Plane[] arrayOfPlanes = {airBus,boeing,armenianPlane,russianPlane};
//        System.out.println();
//        service1.printNotMilitaryPlanes(arrayOfPlanes);
//
//        System.out.println();
//        service1.printMilitaryPlanesOverHundredHours(arrayOfPlanes);
//
//        System.out.println();
//        System.out.println(service1.lightestPlane(arrayOfPlanes));
//
//
//        System.out.println();
//        System.out.println(service1.minimalCostMilitaryPlane(arrayOfPlanes));
//
//        System.out.println();
//        service1.printPlanesSorted(arrayOfPlanes);


        PlaneService service = new PlaneService();
        Plane plane1 =  service.createPlane();
        Plane plane2 =  service.createPlane();
        Plane plane3 =  service.createPlane();


        Plane[] planes = {plane1, plane2, plane3};

        Scanner scanner = new Scanner(System.in);
        boolean isMenuActive = true;

        while (isMenuActive){

            System.out.println("Enter Command Number");
            System.out.println("1. printInfoIfMilitary()");
            System.out.println("2. newerPlane()");
            System.out.println("3. printCountryOfSmallestSeatCount()");
            System.out.println("4. printNotMilitaryPlanes()");
            System.out.println("5. printMilitaryPlanesOverHundredHours()");
            System.out.println("6. lightestPlane()");
            System.out.println("7. minimalCostMilitaryPlane()");
            System.out.println("8. printPlanesSorted()");
            System.out.println("9. Exit");

            int command = scanner.nextInt();

            switch (command){

                case 1 -> service.printInfoIfMilitary(plane1);
                case 2 -> System.out.println(service.newerPlane(plane1,plane2));
                case 3 -> service.printCountryOfSmallestSeatCount(plane1,plane2,plane3);
                case 4 -> service.printNotMilitaryPlanes(planes);
                case 5 -> service.printMilitaryPlanesOverHundredHours(planes);
                case 6 -> System.out.println(service.lightestPlane(planes));
                case 7 -> System.out.println(service.minimalCostMilitaryPlane(planes));
                case 8 -> service.printPlanesSorted(planes);
                case 9 -> isMenuActive=false;
                default -> System.out.println("Invalid input");


            }

        }





    }






}
