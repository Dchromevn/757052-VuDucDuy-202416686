package hust.soict.dsai.garbage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class NoGarbage {
    public static void main(String[] args) throws IOException {
        String filename = "test.txt";
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line = null;
        StringBuilder outputBuilder = new StringBuilder(); 
        long start = System.currentTimeMillis();
        
        while ((line = reader.readLine()) != null) {
            outputBuilder.append(line);
        }
        long end = System.currentTimeMillis();
        reader.close();
        String output = outputBuilder.toString();
        System.out.println("Time (StringBuilder): " + (end - start) + "ms");
        System.out.println("Length of text: " + output.length());
    }
}