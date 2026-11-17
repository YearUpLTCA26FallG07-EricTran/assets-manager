package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){

        Asset wallet = new Asset("cash in wallet", "2026-01-01", new BigDecimal("320"));
        Asset bedStash = new Asset("cash under bed", "2023-01-01", new BigDecimal("1000"));
        House myMainHouse = new House("main house", "2026-02-01", new BigDecimal(2500000) , "asdfasdf", 1, 2_300, 10_000);
        House myOtherHouse = new House("other house", "2010-02-01", new BigDecimal(1500000) , "asdfasdf", 1, 1_500, 3_000);
        Vehicle myMainDriver = new Vehicle("main ride", "2016-01-01", new BigDecimal(15000), "jeep liberty",2016, 260000);



        ArrayList<Asset> myAssets = new ArrayList<>();

        myAssets.add(wallet);
        myAssets.add(bedStash);
        myAssets.add(myMainHouse);
        myAssets.add(myOtherHouse);
        myAssets.add(myMainDriver);

        BigDecimal netWorth = new BigDecimal(0);
        for(Asset a : myAssets){
            netWorth = netWorth.add(a.getValue());
            System.out.println(a);
        }

        System.out.println("Your net worth:");
        System.out.println(netWorth);




    }
}