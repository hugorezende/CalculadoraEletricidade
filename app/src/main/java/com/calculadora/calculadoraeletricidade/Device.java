package com.calculadora.calculadoraeletricidade;

public class Device {
    private String name;
    private double power;
    private double hoursPerDay;

    public Device(String name, double power, double hoursPerDay, double daysPerWeek) {
        this.name = name;
        this.power = power;
        this.hoursPerDay = hoursPerDay;
        this.daysPerWeek = daysPerWeek;
    }

    private double daysPerWeek;
    private final double kwhPrice = .5;

    public String getName() {
        return name;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public double getHoursPerDay() {
        return hoursPerDay;
    }

    public void setHoursPerDay(double hoursPerDay) {
        this.hoursPerDay = hoursPerDay;
    }

    public double getDaysPerWeek() {
        return daysPerWeek;
    }

    public void setDaysPerWeek(double daysPerWeek) {
        this.daysPerWeek = daysPerWeek;
    }

    public double calculateSpent(){
        return (power*hoursPerDay * daysPerWeek*4 /1000)*kwhPrice;
    }
}
