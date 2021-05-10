package com.company;

import Exceptions.*;
import Vehicles.Car;
import Vehicles.Gasoline.GasolineCar;
import Vehicles.Gasoline.GasolineCarService;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here

        ArrayList<Car> cars = new ArrayList<>();

        GasolineCar car1 = GasolineCarService.createCar("BMW", "7 series", 2000, 10000, "22am312", 20, 100, 80, 3, 2);
        GasolineCar car2 = GasolineCarService.createCar("Mercedes", "G class", 2008, 1000, "22ag352", 80, 150, 50, 6, 4);
        GasolineCar car3 = GasolineCarService.createCar("Ferrari", "Spyder", 2012, 12000, "54am312", 60, 90, 60, 8, 3);
        GasolineCar car4 = GasolineCarService.createCar("Lamborghini", "Urus", 2017, 20000, "78gm312", 110, 130, 14, 12, 5);

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);


        cars.forEach(car -> System.out.println(car));

        System.out.println();

        GasolineCarService.printAllNewCars(cars);

    }
}
