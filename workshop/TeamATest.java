import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class TeamATest {

    @Test
    void testCalculateAge() {
        assertEquals(29, TeamA.calculateAge(1995));
        assertEquals(0, TeamA.calculateAge(2024));
        assertEquals(100, TeamA.calculateAge(1924));
    }

    @Test
    void testGetGrade() {
        assertEquals("A", TeamA.getGrade(90));
        assertEquals("B+", TeamA.getGrade(80));
        assertEquals("B", TeamA.getGrade(70));
        assertEquals("C+", TeamA.getGrade(60));
        assertEquals("C", TeamA.getGrade(50));
        assertEquals("D+", TeamA.getGrade(45));
        assertEquals("D", TeamA.getGrade(35));
        assertEquals("F", TeamA.getGrade(20));
    }

    @Test
    void testWriteToFile() throws IOException {
        String name = "TestUser";
        int age = 25;
        String grade = "A";
        String filePath = "C:/Output/TestOutput.txt";

        // Write to file
        TeamA.writeToFile(name, age, grade, filePath);

        // Validate file contents
        Path path = Path.of(filePath);
        assertTrue(Files.exists(path));

        String content = Files.readString(path);
        assertTrue(content.contains("Name: TestUser"));
        assertTrue(content.contains("Age: 25"));
        assertTrue(content.contains("Software Testing Grade: A"));

        // Cleanup
        Files.deleteIfExists(path);
    }
}
