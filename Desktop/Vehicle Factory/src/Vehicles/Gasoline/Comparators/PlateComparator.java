package Vehicles.Gasoline.Comparators;

import Vehicles.Gasoline.GasolineCar;

import java.util.Comparator;

public class PlateComparator implements Comparator<GasolineCar> {

    @Override
    public int compare(GasolineCar o1, GasolineCar o2) {
        return o1.getPlateNumber().compareTo(o2.getPlateNumber());
    }
}
