package Vehicles.Gasoline;

import Exceptions.*;
import Vehicles.Car;

import java.util.List;

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


    public static void printAllNewCars(List<Car> cars){

        for(Car car: cars){
            if(car.getProductionYear()>=2010){
                System.out.println(car);
            }

        }

    }









}
