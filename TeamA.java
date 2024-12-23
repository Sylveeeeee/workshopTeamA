import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TeamA {

    public static void main(String[] args) {
        
        String name = "John";
        int christianEra = 1995;
        int score = 80;

        try {
            
            int age = calculateAge(christianEra);
            String grade = getGrade(score);

            
            String filePath = "C:/Output/Textfile.txt";
            writeToFile(name, age, grade, filePath);

            System.out.println("Data written to " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public static int calculateAge(int christianEra) {
        return 2024 - christianEra;
    }

    public static String getGrade(int score) {
        if (score >= 85) return "A";
        else if (score >= 75) return "B+";
        else if (score >= 65) return "B";
        else if (score >= 55) return "C+";
        else if (score >= 50) return "C";
        else if (score >= 40) return "D+";
        else if (score >= 35) return "D";
        else return "F";
    }

    public static void writeToFile(String name, int age, String grade, String filePath) throws IOException {
        // Ensure directory exists
        Path path = Path.of(filePath).getParent();
        if (path != null) {
            Files.createDirectories(path);
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Software Testing Grade: " + grade + "\n");
        }
    }
}
