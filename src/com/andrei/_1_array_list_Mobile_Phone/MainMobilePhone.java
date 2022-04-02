package com.andrei._1_array_list_Mobile_Phone;

import java.util.Scanner;

public class MainMobilePhone {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone();

    public static void main(String[] args) {

        boolean quit = false;
        startPhone();
        printActions();

        while (!quit){
            System.out.println("\nEnter action: (6 to show available actions)");

            int action = scanner.nextInt();
            scanner.nextLine();


            switch (action){
                case 0:
                    System.out.println("\nShutting down");
                    quit = true;
                    break;
                case 1:
                    printCotacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;

            }
        }
    }

    private static void printCotacts(){
        System.out.println("Contact list");
        mobilePhone.printContacts();
    }

    private static void addNewContact(){
        System.out.println("Enter new contact name:");
        String name = scanner.nextLine();

        System.out.println("Enter phone number:");
        String phone = scanner.nextLine();

        //we create a new contact record without having to create a new contact class
        //I do not see the advantage....?
        Contact contact = Contact.createContact(name, phone);

        if(mobilePhone.addNewContact(contact)){
            System.out.println("New contact added: " + name  + " -> " + phone);
        }else {
            System.out.println(name + " already on file");
        }
    }

    private static void updateContact(){
        System.out.println("Enter existing contact name");
        String oldName = scanner.nextLine();

        Contact existingContact = mobilePhone.queryContact(oldName);
        if(existingContact == null){
            System.out.println("Contact not found!");
            return;
        }
        System.out.println("Enter new contact name");
        String newName = scanner.nextLine();
        System.out.println("Enter new contact number");
        String newNumber = scanner.nextLine();

        Contact newContact = Contact.createContact(newName, newNumber);

        if(mobilePhone.updateContact(existingContact, newContact)){
            System.out.println("Successfully updated record");
        }else {
            System.out.println("Error updating record");
        }
    }

    private static void removeContact(){
        System.out.println("Enter contact to be deleted");
        String name = scanner.nextLine();

        Contact contact = mobilePhone.queryContact(name);
        if(contact == null){
            System.out.println("Contact not found!");
            return;
        }
       if(mobilePhone.removeContact(contact)){
           System.out.println("Successfully deleted");
       }else {
           System.out.println("Error deleting contact");
       }
    }

    private static void queryContact(){

        System.out.println("Enter contact you search for");
        String name = scanner.nextLine();

        Contact contact = mobilePhone.queryContact(name);
        if(contact == null){
            System.out.println("Contact not found!");
            return;
        }
        System.out.println("Name: " + contact.getName() + " -> " + contact.getNumber());

    }


    public static void startPhone(){
        System.out.println("Starting phone....");
    }

    public static void printActions(){
        System.out.println("\nAvailable action: \npress");
        System.out.println("0 - to shutdown\n" +
                "1 - print contacts\n" +
                "2 - add a new contact\n" +
                "3 - update an existing contact\n" +
                "4 - remove an existing contact\n" +
                "5 - query if an existing contact exists\n" +
                "6 - print a list of available actions.");
        System.out.println("Choose an action: ");
    }
}
