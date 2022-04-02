package com.andrei._1_array_list_Mobile_Phone;

public class Contact {
    private String name;
    private String number;


    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    //convenience method
    //factory method
    //it is a static method - no need to create a new Contact class to use it.
    public static Contact createContact(String name, String number){
        return new Contact(name, number);
    }
}
