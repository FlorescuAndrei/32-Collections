package com.andrei._1_array_list_Mobile_Phone;

import java.util.ArrayList;

public class MobilePhone {
    private ArrayList<Contact>contacts;

    public MobilePhone() {
       contacts = new ArrayList<>();
    }

    public boolean addNewContact(Contact contact){
        if(findContact(contact.getName()) >= 0 ){
            System.out.println("Contact is already on file");
            return false;
        }

        contacts.add(contact);
        return true;
    }

    public void printContacts(){
        for(int i = 0; i < contacts.size(); i++){
            System.out.println((i+1) + "." + contacts.get(i). getName() + " -> " + contacts.get(i).getNumber());
        }
    }

    public boolean updateContact(Contact oldContact, Contact newContact){
        int foundPosition = findContact(oldContact);
        if(foundPosition < 0){
            System.out.println(oldContact.getName() + " was not found");
            return false;
        }
        contacts.set(foundPosition, newContact);
        System.out.println(oldContact.getName() + " was replaced with " + newContact.getName());
        return true;
    }



    public String queryContact(Contact contact){
        if(findContact(contact) >= 0){
            return contact.getName();
        }
        return null;
    }

    public Contact queryContact(String name){
        int position = findContact(name);

        if(position >= 0){
            return contacts.get(position);
        }
        return null;
    }

    public boolean removeContact(Contact contact){
        int foundPosition = findContact(contact);
        if(foundPosition < 0){
            System.out.println(contact.getName()+ "was not found.");
            return false;
        }

        contacts.remove(foundPosition);
        System.out.println(contact.getName() + ", was deleted.");
        return true;
    }


    public int findContact(String name) {

        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            if (contact.getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }


    private int findContact(Contact contact){
        //return a number < 0 if the contact doesn't exist
        return this.contacts.indexOf(contact);
    }
}
