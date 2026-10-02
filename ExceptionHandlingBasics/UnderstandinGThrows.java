import java.io.FileReader;
import java.io.IOException;

public class UnderstandinGThrows {

    static void readFile() throws IOException {

        FileReader file = new FileReader("data.txt");

        System.out.println("File opened successfully");
    }

    public static void main(String[] args) {

        try {
            readFile();
        }
        catch (IOException e) {
            System.out.println("Could not open the file");
        }

        System.out.println("Program continues...");
    }
}