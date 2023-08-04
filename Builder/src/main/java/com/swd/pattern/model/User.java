package com.swd.pattern.model;

public class User {

    //Required field
    private final String name;

    //Required field
    private final String lastName;

    //Optional field
    private final String phone;

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "User: "+this.name+", "+this.lastName+", "+this.phone;
    }

    /*
    Problem: The user has to be immutable after instantiation, but this would require
    two constructors, to consider the possibility of informing or not the "phone" field.

    Using the builder pattern, it creates the flexibility to leave empty ou to fill
    optional information.
    */

    //Private constructor to force the client to utilize the builder
    private User(UserBuilder builder){
        this.lastName = UserBuilder.lastName;
        this.name = UserBuilder.name;
        this.phone = UserBuilder.phone;
    }

    //Builder inside the User class to facilitate modifications
    public static class UserBuilder
    {
        static String name;
        static String lastName;

        static String phone;

        public UserBuilder(String name, String lastName){
            UserBuilder.name = name;
            UserBuilder.lastName = lastName;
        }

        public UserBuilder phone(String phone){
            UserBuilder.phone = phone;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }

}
