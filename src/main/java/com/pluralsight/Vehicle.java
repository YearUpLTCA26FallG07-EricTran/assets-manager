package com.pluralsight;

import java.math.BigDecimal;
import java.time.Year;


public class Vehicle extends Asset {

    private String makeMOdel;
    private int year;
    private int odometer;


    public Vehicle(String description, String dateAcquired, BigDecimal originalCost, String makeMOdel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeMOdel = makeMOdel;
        this.year = year;
        this.odometer = odometer;


    }

    public String getMakeMOdel() {
        return makeMOdel;
    }

    public void setMakeMOdel(String makeMOdel) {
        this.makeMOdel = makeMOdel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    @Override
    public BigDecimal getValue() {
        int age = Math.max(0, Year.now().getValue() - year);
        BigDecimal value = initialValueOfVehicle(age);

        return super.getValue();
    }

    private BigDecimal initialValueOfVehicle(int age) {
        if (age > 10) {
            return new BigDecimal("1000.00");
        }
        int annualPercent;
        if (age <= 3) {
            annualPercent = 3;
        } else if (age <= 6) {
            annualPercent = 6;
        } else {
            annualPercent = 8;
        }
        BigDecimal depreciateRate = BigDecimal.valueOf((long) age * annualPercent, 2);
        return getOriginalCost().multiply(BigDecimal.ONE.subtract(depreciateRate));
    }
}
