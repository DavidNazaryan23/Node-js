package Homework4;

public class BankAccount {

    private String name;
    private String secondName;
    private String phoneNum;
    private int accountNumber;
    private int balance;
    private boolean isVIP;
    private int lockerNum;


    public BankAccount(String name, String secondName, String phoneNum, int accountNumber, int balance, boolean isVIP, int lockerNum) {
        this.name = name;
        this.secondName = secondName;
        this.phoneNum=phoneNum;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.isVIP = isVIP;
        this.lockerNum = lockerNum;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean isVIP() {
        return isVIP;
    }

    public void setVIP(boolean VIP) {
        isVIP = VIP;
    }

    public int getLockerNum() {
        return lockerNum;
    }

    public void setLockerNum(int lockerNum) {
        this.lockerNum = lockerNum;
    }


    public String toString(){
        return "Name: " + getName() +", Second Name: " + getSecondName() + ", Phone Number: "+ getPhoneNum() + ", Account Number: " + getAccountNumber()+ ", Balance: " + getBalance() +", Status: " + (isVIP()? "VIP":"Standard") + ", Locker Number: " + getLockerNum();
    }
}
