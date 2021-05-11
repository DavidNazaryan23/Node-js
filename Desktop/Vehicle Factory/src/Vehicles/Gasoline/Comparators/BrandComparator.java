package Vehicles.Gasoline.Comparators;

import Vehicles.Gasoline.GasolineCar;

import java.util.Comparator;

public class BrandComparator implements Comparator<GasolineCar> {


    @Override
    public int compare(GasolineCar o1, GasolineCar o2) {
        return o1.getBrand().compareTo(o2.getBrand());
    }
}
