
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Files {
    static Scanner sc;
   public List addFind(File find) {
        try {
            sc = new Scanner(find);
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + find);
        }
       List<String> findList = new ArrayList<>(500);
        while (sc.hasNext()) {
            findList.add(sc.nextLine());
        }
       return  findList;
   }

   public List addDir(File directory) {
        try {
            sc = new Scanner(directory);
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + directory);
        }
        List<String> directoryList = new ArrayList<>(100000000);
        while (sc.hasNext()) {
            directoryList.add(sc.nextLine());
        }

       return  directoryList;
   }
}


