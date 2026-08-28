import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*; 

public class ContactTest { 

    private Contact Contact1;
    private Contact Contact2;
    private Contact Contact3;
    private Contact Contact4;

    @BeforeEach
    void setUp() {
        // Shared instance for default standard tests
        Contact1 = new Contact("Ada Lovelace", "+1 617 555 0101");
        // Shared instance for toString/formatting tests
        Contact2 = new Contact("Alan Turing", "555-0001");
        Contact3 = new Contact("Test", "+1 (800) 555-0199");
        Contact4 = new Contact("Ada O'Lovelace", "+1 (800) 555-0100");
    }

    @Test 
    void constructor_setsNameCorrectly() { 
        assertEquals("Ada Lovelace", Contact1.getName()); 
    } 

    @Test
    void constructor_setsPhoneCorrectly() { 
        assertEquals("+1 617 555 0101", Contact1.getPhone()); 
    } 

    @Test
    void getName_returnsExactString_notTransformed() { 
        Contact c = new Contact("Grace Hopper", "555-0000"); 
        assertEquals("Grace Hopper", c.getName());
    } 

    @Test
    void toString_containsName() { 
        assertTrue(Contact2.toString().contains("Alan Turing"));
    } 

    @Test
    void toString_containsPhone() {
        assertTrue(Contact2.toString().contains("555-0001"));
    }

    // adding new tests //
    @Test
    void getPhone_returnsExactString_includingSpacesAndSymbols() {
        // Option A: Direct getter comparison (Recommended)
        assertEquals("+1 (800) 555-0199", Contact3.getPhone());
    }
    @Test
    void getName_containsApostrophe_returnsTrue() {
          assertTrue(Contact4.getName().contains("'"));
        }     
}