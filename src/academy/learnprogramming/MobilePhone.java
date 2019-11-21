package academy.learnprogramming;

import java.util.ArrayList;

public class MobilePhone {

    // Variables
    private String myNumber;
    private ArrayList<Contact> myContacts;

    // Constructor
    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }



    // Add a new contact
    public boolean addNewContact(Contact contact) {
        if(findContact(contact.getName()) >= 0) {
            System.out.println("Contact is already on file");
            return false;
        }

        myContacts.add(contact);
        return true;
    }

    // Update a contact
    public boolean updateContact(Contact oldContact, Contact newContact) {
        int foundPosition = findContact(oldContact);
        if(foundPosition < 0) {
            System.out.println(oldContact.getName() + " was not found.");
            return false;
        } else if(findContact(newContact.getName()) != -1) {
            System.out.println("The contact you entered already exists.");
            return false;
        }

        this.myContacts.set(foundPosition, newContact);
        System.out.println(oldContact.getName() + " was replaced with " + newContact.getName());
        return true;
    }

    // Remove a contact
    public boolean removeContact(Contact removedContact) {
        int foundPosition = findContact(removedContact);
        if(foundPosition < 0) {
            System.out.println(removedContact.getName() + " was not found.");
            return false;
        }

        this.myContacts.remove(foundPosition);
        System.out.println(removedContact.getName() + " was removed.");
        return true;
    }

    // Find the contact
    private int findContact(Contact contact) {
        return this.myContacts.indexOf(contact);
    }

    private int findContact(String contactName) {
        for(int i = 0; i < this.myContacts.size(); i++) {
            Contact contact = this.myContacts.get(i);
            if(contact.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    // Query a contact
//    public String queryContact(Contact contact) {
//        if(findContact(contact) >= 0) {
//            return contact.getName();
//        }
//        return null;
//    }

    public Contact queryContact(String name) {
        int position = findContact(name);
        if(position >= 0) {
            return this.myContacts.get(position);
        }

        return null;
    }

    // Print contacts
    public void printContacts() {
        System.out.println("Contact List");
        for(int i = 0; i < this.myContacts.size(); i++) {
            System.out.println((i + 1) + ". " + this.myContacts.get(i).getName() + " -> " + this.myContacts.get(i).getPhoneNumber());
        }
    }
}
