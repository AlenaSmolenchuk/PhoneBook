import java.io.File;
import java.util.List;
import java.util.TreeMap;

public class Search {
    private TreeMap<String, String> directoryList;
    private List<String> findList;
    Timer timer = new Timer();

    private long searching(){
        long foundCount = 0;
        for (String found : findList) {
            if (directoryList.containsKey(found)) {
               foundCount++;
            }
           // foundCount ++;
        }
         return foundCount;
    }

    public  void start() {
        timer.start();
        System.out.println("Start searching...");
        directoryList = Files.addDir(new File("directory.txt"));
        findList = Files.addFind(new File("find.txt"));
        long findNumber = searching();
        timer.stop();
        System.out.println("Found " + findNumber + " / " + findList.size() +
                " entries. Time taken: " + timer.getMins() + " min. " +
                timer.getSecs() + " sec. " + timer.getMs() + " ms.");
    }
}


