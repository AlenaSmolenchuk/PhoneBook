import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.*;
  
class Files {
    static List<String> addFind(File find) {
        List<String> findList = new ArrayList<>();
       try (BufferedReader br = new BufferedReader(
               new java.io.FileReader(find))) {
           String line = null;
           while ((line = br.readLine()) != null) {
               findList.add(line.trim());
           }
       } catch (IOException e) {
           e.printStackTrace();
           System.out.println("No file found: " + find);
       }
     return  findList;
   }
 
    
   static List<Person> addDir(File directory) {
       List<Person> directoryList = new ArrayList<>();
       try (BufferedReader br = new BufferedReader(
               new java.io.FileReader(directory))) {
           String line = null;
           while ((line = br.readLine()) != null) {
               String number = String.valueOf(br.read());
               String name = br.readLine();
               directoryList.add(new Person(name.trim(), number));
           }
       } catch (IOException e) {
           e.printStackTrace();
           System.out.println("No file found: " + directory);
       }
     return  directoryList;
   }
}
