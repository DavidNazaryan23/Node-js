package Exam;

public class Plane {

    private String model;
    private String country;
    private int year;
    private int hours;
    private boolean isMilitary;
    private int weightInKG;
    private int topSpeedInKMh;
    private int seatNum;
    private double cost;

    public Plane(String model, String country, int year, int hours) {
        setModel(model);
        setCountry(country);
        setYear(year);
        setHours(hours);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {

        if (model.isBlank()){
            System.out.println("Enter a valid Model");
            return;
        }
        this.model = model;

    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {

        if (country.isBlank()){
            System.out.println("Enter a valid Country");
            return;
        }
        this.country = country;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if(year<1903 || year>2020){
            System.out.println("Enter a valid Year");
            return;
        }
        this.year = year;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        if(hours<0 || hours>10000){
            System.out.println("Enter a valid number of hours");
            return;
        }
        this.hours = hours;
    }

    public boolean isMilitary() {
        return isMilitary;
    }

    public void setMilitary(boolean military) {

        isMilitary = military;
    }

    public int getWeightInKG() {
        return weightInKG;
    }

    public void setWeightInKG(int weightInKG) {
        if (weightInKG < 1000 || weightInKG>160000){
            System.out.println("Enter a valid Weight");
            return;
        }
        this.weightInKG = weightInKG;
    }

    public int getTopSpeedInKMh() {
        return topSpeedInKMh;
    }

    public void setTopSpeedInKMh(int topSpeedInKMh) {
        if(topSpeedInKMh<0){
            System.out.println("Enter a valid Top Speed");
            return;
        }

        this.topSpeedInKMh = topSpeedInKMh;

    }

    public int getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(int seatNum) {
        if(seatNum<0){
            System.out.println("Enter a valid Number of Seats");
            return;
        }
        this.seatNum = seatNum;
    }

    public double getCost() {

        return cost;
    }

    public void setCost(double cost) {
        if(cost<0.0){
            System.out.println("Enter a valid Cost");
            return;
        }
        this.cost = cost;
    }


    @Override
    public String toString() {
        return "Plane{" + " " +
                "Model: " + model + '\'' +
                ", Country: " + country + '\'' +
                ", Year: " + year +
                ", Hours: " + hours +
                ", IsMilitary: " + (isMilitary? "Yes":"No") +
                ", Weight: " + weightInKG +
                ", Top Speed: " + topSpeedInKMh +
                ", Number of Seats: " + seatNum +
                ", Cost: " + cost + " " +
                 '}';
    }
}
