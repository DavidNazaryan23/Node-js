package Vehicles.Gasoline.Comparators;

import Vehicles.Gasoline.GasolineCar;

import java.util.Comparator;

public class ExpRateComparator implements Comparator<GasolineCar> {

    public int compare(GasolineCar car1, GasolineCar car2){

        return car1.getEngineExpRate() - car2.getEngineExpRate();
    }
}
