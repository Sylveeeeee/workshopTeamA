package teamB;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class TeamBTest {

    @Test
    public void testGetRank() {
        assertEquals("High Distinction", TeamB.getRank("A"));
        assertEquals("Distinction", TeamB.getRank("B+"));
        assertEquals("Good", TeamB.getRank("B"));
        assertEquals("Normal", TeamB.getRank("C+"));
        assertEquals("Failed", TeamB.getRank("F"));
        assertEquals("Unknown", TeamB.getRank("Z")); 
    }

    @Test
    public void testReadFromFile() throws IOException {
        String testFilePath = "C:/Output/TestFile.txt";
        String fileContent = "Name: TestUser\nAge: 25\nSoftware Testing Grade: B+\n";

        BufferedWriter writer = new BufferedWriter(new FileWriter(testFilePath));
        writer.write(fileContent);
        writer.close();

        String result = TeamB.readFromFile(testFilePath);
        assertEquals(fileContent, result);

        new File(testFilePath).delete();
    }

    @Test
    public void testProcessAndPrintData() {
        
        String inputData = "Name: TestUser\nAge: 25\nSoftware Testing Grade: B+\n";
    
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
    
        
        TeamB.processAndPrintData(inputData);
    
        System.setOut(originalOut);
    
        
        String expectedOutput = String.join(System.lineSeparator(),
                "Name: TestUser",
                "Buddhist Era: 2542",
                "Software Testing Rank: Distinction",
                "") + System.lineSeparator();
        String actualOutput = outputStream.toString().trim(); 
    
        assertEquals(expectedOutput.trim(), actualOutput); 
    }
    

    @Test
    public void testValidateData() {
        
        assertDoesNotThrow(() -> TeamB.validateData("John", 25, "A"));

        Exception e1 = assertThrows(IllegalArgumentException.class, () -> TeamB.validateData("", 25, "A"));
        assertEquals("Name cannot be null or empty.", e1.getMessage());

        Exception e2 = assertThrows(IllegalArgumentException.class, () -> TeamB.validateData("John", 0, "A"));
        assertEquals("Invalid age: 0", e2.getMessage());

        Exception e3 = assertThrows(IllegalArgumentException.class, () -> TeamB.validateData("John", 25, "Z"));
        assertEquals("Invalid grade: Z", e3.getMessage());
    }
}
