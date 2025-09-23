// Import necessary classes for file reading and user input
import java.io.FileReader;
import java.util.Scanner;
import java.io.FileNotFoundException;


class ReadFileExampleWithScanner {
    public static void main(String[] args) {
        
        try {
            // Create a Scanner object to read user input from the console
            Scanner scanner = new Scanner(System.in);
            // Prompt the user to enter the name of the file they want to read
            System.out.println("Enter the name of the file you want to read.");
            
            // Create a new Scanner object to read from the file specified by the user
            // FileReader is used to read the file, and the file name is obtained from the user input
            FileReader fileReader = new FileReader(scanner.nextLine());
            Scanner fileScanner = new Scanner(fileReader);
            
            // Loop through the file line by line
            while(fileScanner.hasNext()) {
                // Read the next line from the file
                String fileLine = fileScanner.nextLine();
                
                System.out.println(fileLine);
            }
            
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
