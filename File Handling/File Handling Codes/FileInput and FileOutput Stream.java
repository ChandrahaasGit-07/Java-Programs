import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;

public class Main
{
    public static void main(String[] args)
    {
        FileInputStream fileinput = null;
        FileOutputStream fileoutput = null;
        try {
            fileinput = new FileInputStream("input(source).txt");
            fileoutput = new FileOutputStream("Output(destination).txt");
            
            int byteData;
            
            while((byteData = fileinput.read()) != -1)
            {
                // copy into output file
                fileoutput.write(byteData);
            }
            System.out.println("File is Sucessfully copied");
            
        } catch(IOException e) {
            e.printStackTrace();
        }
        finally
        {
            try {
                if(fileinput != null)
                    fileinput.close();
                if(fileoutput != null)
                    fileoutput.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        
    }
}
