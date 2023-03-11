import java.io.File;
import java.util.List;

import java.util.TreeMap;

public class Search {
    private TreeMap<String, String> directoryList;
    private List<String> findList;
    Timer timer = new Timer();

    private long searching(){
        long foundCount = 0;

        for (String query : findList) {
            if (directoryList.containsKey(query)) {
              // foundCount = count++;
            }
            foundCount ++;
        }
         return foundCount;
    }

    public  void start() {
        timer.start();
        System.out.println("Start searching...");
        directoryList = Files.addDir(new File("C:\\Users\\helen\\Phone Book (Java)\\directory.txt"));
        findList = Files.addFind(new File("C:\\Users\\helen\\Phone Book (Java)\\find.txt"));
        long findNumber = searching();
        timer.stop();
        System.out.println("Found " + findNumber + " / " + findList.size() +
                " entries. Time taken: " + timer.getMins() + " min. " +
                timer.getSecs() + " sec. " + timer.getMs() + " ms.");
    }
}


