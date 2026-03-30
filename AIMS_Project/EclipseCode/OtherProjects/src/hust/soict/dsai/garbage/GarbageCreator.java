package hust.soict.dsai.garbage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class GarbageCreator {
    public static void main(String[] args) throws IOException {
        String filename = "test.txt"; 
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line = null;
        String output = "";
        long start = System.currentTimeMillis();
        
        while ((line = reader.readLine()) != null) {
            output += line; 
        }
        long end = System.currentTimeMillis();
        reader.close();
        System.out.println("Time (String +): " + (end - start) + "ms");
        System.out.println("Length of text: " + output.length());
    }
}