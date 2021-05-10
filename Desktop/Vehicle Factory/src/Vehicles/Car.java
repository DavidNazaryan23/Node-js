package Vehicles;

import Exceptions.*;

public abstract class Car implements Cloneable,Comparable{

    private String brand;
    private String model;
    private int productionYear;
    private int mileage;
    private String plateNumber;
    private double speed;


    public Car(){

    }


    public Car(String brand, String model, int productionYear, int mileage, String plateNumber, double speed) throws InvalidBrandException, InvalidModelException, InvalidYearException, InvalidMileageException, WrongPlateNumberException, InvalidSpeedException {
        setBrand(brand);
        setModel(model);
        setProductionYear(productionYear);
        setMileage(mileage);
        setPlateNumber(plateNumber);
        setSpeed(speed);
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) throws InvalidBrandException {

        if(brand == null || brand.isEmpty()){
            throw new InvalidBrandException();
        }

        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) throws InvalidModelException {
        if(model == null || model.isEmpty()){
            throw new InvalidModelException();
        }
        this.model = model;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) throws InvalidYearException {
        if(productionYear<0 || productionYear>2021){
          throw new InvalidYearException();
        }

        this.productionYear = productionYear;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) throws InvalidMileageException {
        if(mileage<0 ){
           throw new InvalidMileageException();
        }
        this.mileage = mileage;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

//    !plateNumber.matches("[a-zA-Z]{2}\\d{2}\\[a-zA-Z]{3}")

    public void setPlateNumber(String plateNumber) throws WrongPlateNumberException {
        if(plateNumber == null || plateNumber.isEmpty() ){
            throw new WrongPlateNumberException();
        }

        this.plateNumber = plateNumber;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) throws InvalidSpeedException {
        if(speed < 0.0){
            throw new InvalidSpeedException();
        }

        this.speed = speed;
    }


    @Override
    public Car  clone() throws CloneNotSupportedException {

        Car clone = null;
        try {

            clone = (Car)super.clone();



        }catch (CloneNotSupportedException e){
            System.out.println("Clone not supported: " + e.getMessage());
        }

        return clone;
    }

    @Override
    public int compareTo(Object o) {

        Car otherCar = (Car) o;
        return this.productionYear- otherCar.productionYear;

    }

    @Override
    public String toString() {
        return  "Brand: " + brand +", Model: " + model + ", Year: "+ productionYear + ", Mileage: " + mileage + "miles, Plate Number: "+ plateNumber +", Speed: "+ speed + "mph";
    }

    public abstract boolean isValidBrand(String brandName);
    public abstract boolean isValidModel(String modelName);


}
