package Vehicles.Gasoline;

import Exceptions.*;
import Vehicles.Car;

import java.util.ArrayList;
import java.util.Arrays;

public class GasolineCar extends Car {

    enum GasolineCarBrand{

        Mercedes(new String[]{"G class", "C class", "E class", "S class"}),
        BMW(new String[]{"3 series", "5 series", "6 series", "7 series"}),
        Ferrari(new String[]{"Tributo", "Maranello", "Spyder", "Roma"}),
        Lamborghini(new String[]{"Urus", "Aventador", "Huracan", "Gallardo"} );

        private ArrayList<String> models;

        GasolineCarBrand(String[] models){

            this.models = new ArrayList<>(Arrays.asList(models));

        }




    }

    private int tankSize;
    private int currentGasLevel;
    private Engine engine;


    public GasolineCar(String brand, String model, int productionYear, int mileage, String plateNumber, double speed, int tankSize, int currentGasLevel, int numOfCylinders, int expRate) throws InvalidBrandException, InvalidModelException, InvalidYearException, InvalidMileageException, WrongPlateNumberException, InvalidSpeedException, InvalidTankSizeException, InvalidGasLevelException, InvalidNumberOfCylinders, InvalidExpenditureRateException {
        super(brand, model, productionYear, mileage, plateNumber, 0);
        this.engine = new Engine(numOfCylinders,expRate);
        setSpeed(speed);

        setTankSize(tankSize);
        setCurrentGasLevel(currentGasLevel);
    }




    @Override
    public void setBrand(String brand) throws InvalidBrandException {
        if(brand == null || brand.isEmpty() || !isValidBrand(brand)){
            throw new InvalidBrandException();
        }
        super.setBrand(brand);
    }

    @Override
    public void setModel(String model) throws InvalidModelException{
        if(model == null || model.isEmpty() || !isValidModel(model)){
            throw new InvalidModelException();
        }
        super.setModel(model);

    }

    @Override
    public void setSpeed(double speed) throws InvalidSpeedException {
        super.setSpeed(speed);

        if(this.engine != null){
            this.engine.setActiveGear((int)speed);
        }

    }

    public int getTankSize() {
        return tankSize;
    }

    public void setTankSize(int tankSize) throws InvalidTankSizeException {
        if(tankSize<0){
            throw new InvalidTankSizeException();
        }

        this.tankSize = tankSize;
    }

    public int getCurrentGasLevel() {
        return currentGasLevel;
    }

    public void setCurrentGasLevel(int currentGasLevel) throws InvalidGasLevelException {
        if(currentGasLevel<0 || currentGasLevel>tankSize){
            System.out.println(this.tankSize);
            throw new InvalidGasLevelException();
        }

        this.currentGasLevel = currentGasLevel;
    }

    public boolean isValidBrand(String brandName){

        for(GasolineCarBrand brand : GasolineCarBrand.values()){
            if(brand.toString().equals(brandName)){
                return true;
            }
        }

        return false;
    }

    public boolean isValidModel(String modelName){

        for(GasolineCarBrand brand : GasolineCarBrand.values()){

            for (String model: brand.models){
                if(model.equals(modelName)){
                    return true;
                }
            }

        }

        return false;

    }


    public Engine getEngine() {
        return engine.clone();
    }

    public int getEngineExpRate(){
        return getEngine().expenditureRate;
    }

    @Override
    public GasolineCar clone() throws CloneNotSupportedException {
        GasolineCar clone = null;

        try {
            clone = (GasolineCar)super.clone();
            clone.engine = this.engine.clone();

        } catch (CloneNotSupportedException e){
            System.out.println();
        }
        return clone;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tank Size: " + tankSize + "liters,  Gas Level: " + currentGasLevel + "liters, " + engine.toString();
    }

    public String toStringForSave(){
        return getBrand() + "," +getModel()+","+getProductionYear()+"," + getMileage()+"," + getPlateNumber()+","+ getSpeed()+"," + tankSize+","+currentGasLevel+","+ engine.numberOfCylinders+","+engine.expenditureRate;
    }


    private class Engine implements Cloneable, Comparable{

        private int numberOfCylinders;
        private int activeGear;
        private int expenditureRate;


        Engine(int numberOfCylinders, int expenditureRate) throws InvalidNumberOfCylinders, InvalidExpenditureRateException {

            setNumberOfCylinders(numberOfCylinders);
            setExpenditureRate(expenditureRate);

        }

        public void setNumberOfCylinders(int numberOfCylinders) throws InvalidNumberOfCylinders{
            if(numberOfCylinders<1){
                throw new InvalidNumberOfCylinders();
            }

            this.numberOfCylinders = numberOfCylinders;
        }

        public int getNumberOfCylinders() {
            return numberOfCylinders;
        }

        public void setActiveGear(int speed){

            if(speed<20){
                activeGear = 1;
            } else if( speed< 40){
                activeGear = 2;
            } else if(speed < 60){
                activeGear = 3;
            } else if (speed <80){
                activeGear = 4;
            } else if(speed<100){
                activeGear = 5;
            } else {
                activeGear = 6;
            }


        }

        public void setExpenditureRate(int rate) throws InvalidExpenditureRateException{
            if(rate<0){
                throw new InvalidExpenditureRateException();
            }

            expenditureRate = rate;
        }

        public int getExpenditureRate() {
            return expenditureRate;
        }

        public Engine clone(){
            Engine clone = null;

            try {
                clone = (Engine) super.clone();

            } catch (CloneNotSupportedException e) {
                System.out.println("");
            }

            return clone;
        }

        @Override
        public int compareTo(Object o) {
            Engine otherEngine = (Engine) o;
            return this.numberOfCylinders- otherEngine.numberOfCylinders;
        }

        @Override
        public String toString() {
            return "Number of Cylinders: " + numberOfCylinders + ", Expenditure Rate: " + expenditureRate + ", Active Gear: " + activeGear;
        }
    }
}
