package academy.learnprogramming;

public class Contact {

    // Variables
    private String name;
    private String phoneNumber;

    // Constructor
    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Create a contact
    public static Contact createContact (String name, String phoneNumber) {
        return new Contact(name, phoneNumber);
    }
}
