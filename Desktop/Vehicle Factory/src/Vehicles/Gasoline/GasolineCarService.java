package Vehicles.Gasoline;

import Exceptions.*;
import Files.FileManagment;
import Vehicles.Car;
import Vehicles.Gasoline.Comparators.BrandComparator;
import Vehicles.Gasoline.Comparators.ExpRateComparator;
import Vehicles.Gasoline.Comparators.MileageComparator;
import Vehicles.Gasoline.Comparators.PlateComparator;

import java.io.IOException;
import java.util.*;

public class GasolineCarService {

    public static GasolineCar createCar(String brand, String model, int productionYear, int mileage, String plateNumber, double speed, int tankSize, int gasLevel, int numOfCyl, int expRate){


        GasolineCar car = null;
        try {
            car = new GasolineCar(brand, model, productionYear, mileage, plateNumber, speed, tankSize, gasLevel, numOfCyl,expRate);

        } catch (InvalidBrandException e) {
            System.out.println("No such brand");
        } catch (InvalidModelException e) {
            System.out.println("No such model");
        } catch (InvalidYearException e) {
            System.out.println("Invalid year");
        } catch (InvalidMileageException e) {
            System.out.println("Invalid mileage");
        } catch (WrongPlateNumberException e) {
            System.out.println("Invalid plate number");;
        } catch (InvalidSpeedException e) {
            System.out.println("Invalid speed");
        } catch (InvalidTankSizeException e) {
            System.out.println("Invalid tank size");
        } catch (InvalidGasLevelException e) {
            System.out.println("Invalid gas level");
        } catch (InvalidExpenditureRateException e) {
            System.out.println("Invalid engine expenditure rate");
        } catch (InvalidNumberOfCylinders invalidNumberOfCylinders) {
            System.out.println("Invalid number of cylinders");
        }


        return car;
    }


    public static void printAllNewCars(List<GasolineCar> cars){

        for(Car car: cars){
            if(car.getProductionYear()>=2010){
                System.out.println(car);
            }

        }

    }


    public static void sortCarsByYearReverse(List<GasolineCar>cars){


         Collections.sort(cars, Collections.reverseOrder());

    }


    public static ArrayList<GasolineCar> copyCarsAndSortByMileage(List<GasolineCar> gasolineCars){
        ArrayList<GasolineCar> copiedList = new ArrayList<>(gasolineCars); // uses the clone method from gasoline class
        Collections.sort(copiedList, new MileageComparator());


        return copiedList;

    }

    public static void sortByExpRateReversedAndDeleteEvenIndex(List<GasolineCar> cars){

        Collections.sort(cars, new ExpRateComparator().reversed());

        for(int i = cars.size()-1; i>=0; i--){
            if(i%2==0){
                cars.remove(i);
            }
        }


    }

    public static void writeTwoFirstBrandsToFile(List<GasolineCar> cars)  {

        ArrayList<GasolineCar> copyList = new ArrayList<>(cars);
        Collections.sort(copyList, new BrandComparator());

        try {
            FileManagment.writeWithAppend( "Files\\GasolineCars.txt",copyList.get(copyList.size()-1).toStringForSave()+"\n");
            FileManagment.writeWithAppend( "Files\\GasolineCars.txt",copyList.get(copyList.size()-2).toStringForSave()+"\n");
        } catch (IOException e) {
            System.out.println("Couldn't write to file");
        }


    }

    public static void sortByPlateReverseAndWriteFirstToFile(List<GasolineCar> cars){

        Collections.sort(cars, new PlateComparator().reversed());


        try {
            FileManagment.writeWithAppend( "Files\\GasolineCars.txt",cars.get(0).toStringForSave()+"\n");


        } catch (IOException e){
            System.out.println("Couldn't write to file");
        }

    }

    public static ArrayList<GasolineCar> getCarsFromFile(){

        ArrayList<GasolineCar> resCars = new ArrayList<>();
        try {
            List<String> res = FileManagment.read("Files\\GasolineCars.txt");

            for (String carString: res){

                String[] splitString = carString.split(",", 10);
//
//                for(int i = 0; i<splitString.length;i++){
//                    System.out.println(splitString[i]);
//                }
                if(splitString.length>=9){

                    String brand = splitString[0];
                    String model = splitString[1];
                    int year = Integer.parseInt(splitString[2]);
                    int mileage = Integer.parseInt(splitString[3]);
                    String plateNum = splitString[4];
                    double speed = Double.parseDouble(splitString[5]);
                    int tankSize  = Integer.parseInt(splitString[6]);
                    int currLevel = Integer.parseInt(splitString[7]);
                    int numOfCylinders = Integer.parseInt(splitString[8]);
                    int expRate = Integer.parseInt(splitString[9]);
//
                    resCars.add(GasolineCarService.createCar(brand,model,year,mileage,plateNum,speed,tankSize,currLevel,numOfCylinders,expRate));

                }



            }



        } catch (IOException e) {
            System.out.println("Couldn't read from file ");
        }

        return resCars;
    }

















}
