package teamB;

import java.io.*;

public class TeamB {
    private static final int CURRENT_YEAR = 2024;
    private static final int BUDDHIST_OFFSET = 543;

    public static void main(String[] args) {
        try {
            String filePath = "C:/Output/Textfile.txt";
            String data = readFromFile(filePath);
            processAndPrintData(data);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid input: " + e.getMessage());
        }
    }

    public static String readFromFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        StringBuilder data = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            data.append(line).append("\n");
        }
        reader.close();
        return data.toString();
    }

    public static void processAndPrintData(String data) {
        String[] lines = data.split("\n");
        String name = lines[0].split(": ")[1];
        int age = Integer.parseInt(lines[1].split(": ")[1]);
        String grade = lines[2].split(": ")[1];

        validateData(name, age, grade);

        int buddhistEra = CURRENT_YEAR + BUDDHIST_OFFSET - age;
        String rank = getRank(grade);

        System.out.println("Name: " + name);
        System.out.println("Buddhist Era: " + buddhistEra);
        System.out.println("Software Testing Rank: " + rank);
    }

    public static String getRank(String grade) {
        switch (grade) {
            case "A": return "High Distinction";
            case "B+": return "Distinction";
            case "B": return "Good";
            case "C+": return "Normal";
            case "C": return "Normal";
            case "D+": return "Normal";
            case "D": return "Normal";
            case "F": return "Failed";
            default: return "Unknown";
        }
    }

    static void validateData(String name, int age, String grade) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        if (age <= 0 || age > 120) {
            throw new IllegalArgumentException("Invalid age: " + age);
        }
        if (!isValidGrade(grade)) {
            throw new IllegalArgumentException("Invalid grade: " + grade);
        }
    }

    private static boolean isValidGrade(String grade) {
        return grade.matches("A|B\\+?|C\\+?|D\\+?|F");
    }
}
