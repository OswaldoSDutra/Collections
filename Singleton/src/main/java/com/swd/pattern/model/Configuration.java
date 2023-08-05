package com.swd.pattern.model;

public class Configuration {

    /*
    Creates a reference to an instance of the class in the memory,
    to avoid the possibility of accessing a thread cash reference.
     */
    private static volatile Configuration instace;

    //Auxiliary object to help locking the class in the lowest level
    private static final Object lockHelper = new Object();

    private String environment;

    private String databaseHost;

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getDatabaseHost() {
        return databaseHost;
    }

    public void setDatabaseHost(String databaseHost) {
        this.databaseHost = databaseHost;
    }

    //Prevent client from create new instances using the new operator
    private Configuration(){

    }

    public static Configuration getInstance(){

        /*
        Gets a copy of the instance from the memory instead of working with
        the memory directly to improve performance
        */
        Configuration temp = instace;

        if(temp == null){
            synchronized (lockHelper){

                //Makes sure to use an instance that might have been created by an early executed thread
                temp = instace;

                if(temp == null)
                    temp = instace = new Configuration();
            }
        }

        return temp;
    }

}
