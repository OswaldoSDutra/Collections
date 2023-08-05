package com.swd.pattern;

import com.swd.pattern.model.Configuration;

public class Main {

    public static void main(String[] args) {

        /*
        Using the singleton pattern to make sure that modifications of configuration properties
        reflects in the entire application
         */
        Configuration configInstance1 = Configuration.getInstance();
        configInstance1.setDatabaseHost("10.34.34.34");

        System.out.println("Printing instance 1 host:" + configInstance1.getDatabaseHost());

        Configuration configInstance2 = Configuration.getInstance();
        configInstance2.setDatabaseHost("9.33.33.33");

        System.out.println("Printing instance 2 host:" + configInstance2.getDatabaseHost());

        //Should present host value modified configInstance2
        System.out.println("Printing instance 1 host again:" + configInstance1.getDatabaseHost());

    }
}