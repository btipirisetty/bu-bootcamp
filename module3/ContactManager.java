import java.util.*; 
 
public class ContactManager { 
 
    public static void main(String[] args) { 
 
        HashMap<String, Contact> contacts = new HashMap<>(); 
 
        // Step 4: add contacts here 
        contacts.put("Bharath Tipirisetty", new Contact("Bharath Tipirisetty", "+1 641 230 1940"));
        contacts.put("Nihal Tipirisetty", new Contact("Nihal Tipirisetty", "+1 641 230 1234"));
        contacts.put("Dave Hall", new Contact("Dave Hall", "+1 641 230 3245"));
        contacts.put("Veena Tipirisetty", new Contact("Veena Tipirisetty", "+1 641 411 1000"));
        contacts.put("Jon King", new Contact("Jon King", "+1 641 145 2000"));
        contacts.put("Prince Jr", new Contact("Prince Jr", "+1 641 857 1000"));
        contacts.put("Emer Police", new Contact("Emer Police", "911"));
        // Step 5: look up a contact 
        //String searchKey = "Nihal Tipirisetty";
        String[] searchKeys = {"Nihal Tipirisetty", "David King"};
        System.out.println("--- Contact Lookup ---");
        for (String searchKey : searchKeys) {
        if (contacts.containsKey(searchKey)) {
            System.out.println("Found: " + contacts.get(searchKey) + "in the Contact Manager.");
        } else {
            System.out.println(searchKey + " not found in the Contact Manager.");
        }}
        System.out.println();
        // Step 6: print sorted list 
        System.out.println("--- Sorted Contact List (Alphabetical by Name) ---");
        List<String> sortedNames = new ArrayList<>(contacts.keySet());
        Collections.sort(sortedNames);
        // Iterate through the sorted names and print their corresponding Contact objects
        for (String name : sortedNames) {
            System.out.println(contacts.get(name));
        }
    } 
}
