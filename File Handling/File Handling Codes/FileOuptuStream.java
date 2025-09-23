import java.io.FileOutputStream;
import java.io.IOException;

public class Main
{
    public static void main(String[] args)
    {
        FileOutputStream fileoutput = null;
        try {
            fileoutput = new FileOutputStream("Output.txt");
            
            // Data to write
            String data = "Hello World";
            
            // Converting this data to byte
            byte[] byteData = data.getBytes();
            // Writing the data into FileOutputStream
            fileoutput.write(byteData);
        } catch(IOException e) {
            e.printStackTrace();
        }
        finally
        {
            if(fileoutput != null)
            {
                try {
                    fileoutput.close();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }
        
    }
}
