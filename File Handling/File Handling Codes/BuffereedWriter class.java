import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class Main
{
	public static void main(String[] args) {
		try {
		    FileWriter file = new FileWriter("output.txt");
		    
		    BufferedWriter buffer = new BufferedWriter(file);
		    buffer.write("Hello World");
		    buffer.newLine();
		    buffer.write("This is file handling example");
		    buffer.close();
		    
		    System.out.println("File handled");
		} catch(IOException e) {
		    System.out.println("An error occured" + e.getMessage());
		}
	}
}
