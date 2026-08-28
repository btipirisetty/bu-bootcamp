import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test; 
import static org.junit.jupiter.api.Assertions.*; 
import java.util.ArrayList; 
import java.util.Arrays; 
 
//additional edge case tests//

public class GradeAnalyzerTest { 
 
    @Test
    void calculateAverage_returnsZero_whenListIsEmpty() { 
        ArrayList<Integer> scores = new ArrayList<>(); 
        assertEquals(0.0, GradeAnalyzer.calculateAverage(scores)); 
    } 
 
    @Test
    void calculateAverage_returnsCorrectAverage_forTypicalScores() { 
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(80, 90, 100)); 
        assertEquals(90.0, GradeAnalyzer.calculateAverage(scores));
    }
 
    @Test
    void calculateAverage_returnsSingleValue_whenListHasOneItem() { 
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(75)); 
        assertEquals(75.0, GradeAnalyzer.calculateAverage(scores));
    } 
 
    @Test
    void calculateAverage_returnsDouble_notInteger() { 
        // 1 + 2 = 3, divided by 2 = 1.5, not 1
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(1, 2)); 
        assertEquals(1.5, GradeAnalyzer.calculateAverage(scores)); 
    } 
 
    @Test 
    void calculateAverage_handlesAllSameValues() { 
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(88, 88, 88)); 
        assertEquals(88.0, GradeAnalyzer.calculateAverage(scores)); 
    }
    @Test 
    void calculateAverage_handlesChars() { 
        // 'b' ASCII value is 98, 'd' ASCII value is 100
        // (98 + 100) / 2 = 99.0
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList((int) 'b', (int) 'd')); 
        assertEquals(99.0, GradeAnalyzer.calculateAverage(scores)); 
    }
    @Test
    void calculateAverage_returnsZero_ListIsNull() {
        assertEquals(0.0, GradeAnalyzer.calculateAverage(null));
    }
    @Test
    void calculateAverage_handlesNegativeScores() {
        // (-10 + 90) / 2 = 40.0
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(-10, 90));
        assertEquals(40.0, GradeAnalyzer.calculateAverage(scores));
    }
   @Test
   void calculateAverage_returnsCorrectAverage_formorethan10scores() {
       ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(68, 90, 92, 64, 37, 79, 59, 47, 99, 100, 18, 80, 74, 10, 94, 100)); 
        assertEquals(69.4375, GradeAnalyzer.calculateAverage(scores));
   }    
    
}