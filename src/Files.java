
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.*;

class Files {

   public static List<String> addFind(File find) {
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

   public static TreeMap<String,String> addDir(File directory) {

       TreeMap<String,String> directoryList = new TreeMap<>();
       try (BufferedReader br = new BufferedReader(
               new java.io.FileReader(directory))) {
           String line = null;
           while ((line = br.readLine()) != null) {
               String[] data = line.trim().split("(?<=\\d)");
               directoryList.put(data[1], data[0]);
           }
       } catch (IOException e) {
           e.printStackTrace();
           System.out.println("No file found: " + directory);
       }
       return  directoryList;
   }
}


