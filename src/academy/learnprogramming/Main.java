package academy.learnprogramming;

import java.util.Scanner;

public class Main {
    // Set to input
    private static Scanner scanner = new Scanner(System.in);
    // Set my mobile phone
    private static MobilePhone mobilePhone = new MobilePhone("347 506 8520");

    public static void main(String[] args) {

        // Start the phone with menu
        boolean quit = false;
        startPhone();
        printActions();

        // Control phone actions
        while(!quit) {
            System.out.println("\nEnter action : (6 to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("\nShutting down...");
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printContacts();
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

    // Print contacts -> Cannot use b/c myContacts is "private"
//    private static void printContacts() {
//        mobilePhone.printContacts();
//        System.out.println("Contact List");
//        for(int i = 0; i < mobilePhone.myContacts.size(); i++) {
//            System.out.println((i + 1) + ". " + mobilePhone.myContacts.get(i).getName() + " -> " + mobilePhone.myContacts.get(i).getPhoneNumber());
//        }
//    }

    // Add a new contact
    private static void addNewContact() {
        System.out.println("Enter new contact name : ");
        String name = scanner.nextLine();
        System.out.println("Enter phone number : ");
        String phone = scanner.nextLine();
        Contact newContact = Contact.createContact(name, phone);
        if(mobilePhone.addNewContact(newContact)) {
            System.out.println("New contact added : name = " + name + ", phone = " + phone);
        } else {
            System.out.println("Cannot add, " + name + " already on file");
        }
    }

    // Update a contact
    private static void updateContact() {
        System.out.println("Enter existing contact name : ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);

        if(existingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }

        System.out.println("Enter new contact name : ");
        String newName = scanner.nextLine();
        System.out.println("Enter new contact phone number : ");
        String newNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newName, newNumber);
        if(mobilePhone.updateContact(existingContactRecord, newContact)) {
            System.out.println("Successfully updated record.");
        } else {
            System.out.println("Error updating record.");
        }
    }

    // Remove a contact
    private static void removeContact() {
        System.out.println("Enter existing contact name : ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if(existingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }

        if(mobilePhone.removeContact(existingContactRecord)) {
            System.out.println("Successfully deleted.");
        } else {
            System.out.println("Error deleting contact.");
        }
    }

    // Query a contact
    private static void queryContact() {
        System.out.println("Enter existing contact name : ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if(existingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }

        System.out.println("Name : " + existingContactRecord.getName() + ", Phone number is " + existingContactRecord.getPhoneNumber());
    }

    // Start the phone
    private static void startPhone() {
        System.out.println("Starting phone...");
    }

    // Print action options
    private static void printActions() {
        System.out.println("\nAvailable actions:\npress");
        System.out.println(
                "0  - to shut down\n" +
                "1  - to print contacts\n" +
                "2  - to add a new contact\n" +
                "3  - to update an existing contact\n" +
                "4  - to remove an existing contact\n" +
                "5  - to query if a contact exists\n" +
                "6  - to print a list of available actions");
        System.out.println("Choose your action: ");
    }
}
