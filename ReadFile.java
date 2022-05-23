import java.io.*;
import java.util.*;

public class ReadFile {
   
   public static void readFile(String inFile) {
      try (Scanner in = new Scanner(new FileReader(inFile))) {
         while (in.hasNextLine()) {
            String line = in.nextLine();
            System.out.println(line);
         }
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      }
   }

   public static void main(String[] args) {
      readFile("input.txt");
   }
}
