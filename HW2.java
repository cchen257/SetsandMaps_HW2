import java.io.*;
import java.util.*;

public class HW2 {
   
   // Prints a list of words that appear in both files.
   public static void intersection(String filename1, String filename2) {
	   
      try (Scanner in1 = new Scanner(new FileReader(filename1));
            Scanner in2 = new Scanner(new FileReader(filename2))) {
    	  
    	  Set <String> set = new HashSet<>();
    
    	  while (in1.hasNextLine()) {
              String line1 = in1.nextLine();
              set.add(line1);
          }
    	  
    	  while (in2.hasNextLine()) {
              String line2 = in2.nextLine();
              
              if (set.contains(line2))
            	  System.out.println(line2);
           }
    	  
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      }
   }
   
   // Prints all words in the file that occur at least k times
   // (print the word followed by the number of occurrences in parentheses).
   // Each line in the file contains only one word.
   public static void frequentWords(String filename, int k) {
	   
      try (Scanner in = new Scanner(new FileReader(filename))) {
    	  Map <String, Integer> map = new HashMap<>();
    	  
    	  while (in.hasNextLine()) {
    		  String line = in.nextLine();
    		  Integer counter = map.get(line);
    		  
    		  if (counter != null)
    		  	map.put(line, counter + 1);
    		  else
    		    map.put(line, 1);
    	  }
    	  
    	  for (Map.Entry<String, Integer> entry:map.entrySet() ) {
    		  if (entry.getValue() >= k)
    			  System.out.print(entry.getKey() + " (" + entry.getValue() + ") \n");
    	  }
    	  
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      }
   }
   
   // Returns the string with the characters sorted alphabetically.
   private static String sortString(String s) {
      char[] array = s.toCharArray();
      Arrays.sort(array);
      return new String(array);
   }

   // Prints all sets of anagrams, one set per line.
   // Each line in the file contains only one word.
   public static void anagrams(String filename) {
	   
	  Map <String, Set<String>> map = new HashMap<>(); //mapping a word, with its anagrams
  	  map.put("now", new HashSet<String>()); //anagram set
  	  
      try (Scanner in = new Scanner(new FileReader(filename))) {
    	  
    	  while (in.hasNextLine()) {
    		  String line = in.nextLine();
    		  
    		  String sortedLine = sortString(line); //acehp
    		  
    		  if ( !(map.containsKey(sortedLine)) ) { //does not contain acehp
    			  map.put( sortedLine, new HashSet <String>() );
    		  		( map.get(sortedLine) ).add(line);
    		  }
    		  
    		  else { //contains acehp
    			  map.get(sortedLine).add(line);
    		  }
   
    	  }
    	 
    	  for (Map.Entry<String, Set<String> > entry:map.entrySet() ) {
    		  if (entry.getValue().size() > 1)
    			  System.out.print(entry.getValue() + "");
    	  }
    	  
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      }
   }

   public static void main(String[] args) {
      System.out.println("***Intersection***");
      intersection("english_words.txt", "french_words.txt");
      
      System.out.println("***Frequent words***");
      frequentWords("english_words.txt", 2);
      
      System.out.println("***Anagrams***");
      anagrams("english_words.txt");
   }
}