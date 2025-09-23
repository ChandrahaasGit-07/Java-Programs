
import java.io.FileInputStream;
import java.io.IOException;

public class Main
{
    public static void main(String[] args)
    {
        FileInputStream fileinput = null;
        try {
            fileinput = new FileInputStream("example.txt");
            
            // variable to hold the byte by byte
            int byteData;
            // read the byte until it reaches -1( no value )
            while((byteData = fileinput.read()) != -1)
            {
                System.out.println((char) byteData);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        finally{
            // close the stream to free resources
            if(fileinput != null)
            {
                try{
                    fileinput.close();
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
