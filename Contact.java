public class Contact {
    // two private String fields: name and phone
    private String name;
    private String phone;

    // Constructor that takes both fields
    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for phone
    public String getPhone() {
        return phone;
    }

    // Override toString to format the contact info
    @Override
    public String toString() {
        return name + " | " + phone;
    }
}