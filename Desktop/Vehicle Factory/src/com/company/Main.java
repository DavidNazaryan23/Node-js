package com.company;

import Exceptions.*;
import Files.FileManagment;
import Vehicles.Car;
import Vehicles.Gasoline.GasolineCar;
import Vehicles.Gasoline.GasolineCarService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        try{
            FileManagment.makeFile("Files","GasolineCars.txt");

        }catch(IOException e) {
            e.printStackTrace();
        }

        ArrayList<GasolineCar> cars = new ArrayList<>();

        GasolineCar car1 = GasolineCarService.createCar("BMW", "7 series", 2000, 10000, "22am312", 20, 100, 80, 3, 2);
        GasolineCar car2 = GasolineCarService.createCar("BMW", "6 series", 2001, 10030, "22aj352", 22, 105, 76, 2, 1);
        GasolineCar car3 = GasolineCarService.createCar("Mercedes", "G class", 2008, 1000, "22ag352", 80, 150, 50, 6, 4);
        GasolineCar car4 = GasolineCarService.createCar("Ferrari", "Spyder", 2012, 12000, "54am312", 60, 90, 60, 8, 3);
        GasolineCar car5 = GasolineCarService.createCar("Lamborghini", "Urus", 2017, 20000, "78gm312", 110, 130, 14, 12, 5);
        GasolineCar car6 = GasolineCarService.createCar("Lamborghini", "Huracan", 2019, 100, "28mm513", 150, 170, 19, 8, 4);

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
        cars.add(car6);

        System.out.println("List of all cars at the moment");
        System.out.println();
        cars.forEach(car -> System.out.println(car));
        System.out.println();


        Scanner sc = new Scanner(System.in);
        boolean isActive = true;

        while (isActive){


            System.out.println("PRESS");
            System.out.println("1: to create a new car");
            System.out.println("2: to print all new cars");
            System.out.println("3: to sort cars by year, reversed");
            System.out.println("4: to create a new list of cars sorted by mileage");
            System.out.println("5: to sort by expenditure rate and delete even indices");
            System.out.println("6: to write to first brands lexicographically to the file");
            System.out.println("7: to sort by plate, reversed, and write the first one to file");
            System.out.println("8: to get a list of all cars from the file");
            System.out.println("0: to exit");

            int command = sc.nextInt();

            switch (command){

                case 0 -> {
                    System.out.println("Exiting");
                    isActive=false;
                }
                case 1 ->{
                    GasolineCar car = null;

                    sc.nextLine();
                    System.out.println("Enter a brand");
                    String brand = sc.nextLine();
                    System.out.println("Enter a model");
                    String model = sc.nextLine();
                    System.out.println("Enter production year");
                    int year = sc.nextInt();
                    System.out.println("Enter mileage");
                    int mileage = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter plate number");
                    String plate = sc.nextLine();
                    System.out.println("Enter speed");
                    double speed = sc.nextDouble();
                    System.out.println("Enter tank size");
                    int tank = sc.nextInt();
                    System.out.println("Enter gas level");
                    int currLevel = sc.nextInt();
                    System.out.println("Enter number of cylinders");
                    int cylNum = sc.nextInt();
                    System.out.println("Enter expenditure rate");
                    int expRate = sc.nextInt();

                    car = GasolineCarService.createCar(brand,model,year,mileage,plate,speed,tank,mileage,cylNum,expRate);

                    if(car != null){
                        System.out.println("Car created");
                        System.out.println(car);
                        System.out.println("Adding car to list");
                        cars.add(car);
                        System.out.println();
                    } else {
                        System.out.println("No car created. Nothing added to the list");
                        System.out.println();
                    }



                }
                case 2 -> {
                    System.out.println("All new cars");
                    GasolineCarService.printAllNewCars(cars);
                    System.out.println();
                }
                case 3 ->{
                    System.out.println("Cars sorted by year, reversed");
                    GasolineCarService.sortCarsByYearReverse(cars);
                    cars.forEach(gasolineCar -> System.out.println(gasolineCar));
                    System.out.println();
                }
                case 4->{
                    System.out.println("Copy array, sorted by mileage");
                    ArrayList<GasolineCar> copyList = GasolineCarService.copyCarsAndSortByMileage(cars);
                    copyList.forEach(car -> System.out.println(car));
                    System.out.println();
                }
                case 5 -> {
                    System.out.println("Sort by expenditure rate and delete even indices");
                    GasolineCarService.sortByExpRateReversedAndDeleteEvenIndex(cars);
                    cars.forEach(car-> System.out.println(car));
                    System.out.println();
                }
                case 6 ->{
                    System.out.println("Writing two first brands to file");
                    GasolineCarService.writeTwoFirstBrandsToFile(cars);
                    System.out.println();

                }
                case 7->{
                    System.out.println("Sorting by plates, reversed, and writing first one to file");
                    GasolineCarService.sortByPlateReverseAndWriteFirstToFile(cars);
                    cars.forEach(car-> System.out.println(car));
                    System.out.println();
                }
                case 8->{
                    System.out.println("Getting cars from file");
                    ArrayList<GasolineCar> fileCars = GasolineCarService.getCarsFromFile();
                    fileCars.forEach(car-> System.out.println(car));
                    System.out.println();
                }
                default -> {
                    System.out.println("Not a valid command");
                }

            }


        }
//


    }
}
