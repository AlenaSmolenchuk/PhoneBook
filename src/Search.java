import java.io.File;
import java.util.List;
import java.util.TreeMap;

public class Search implements TimeTimer {
    private TreeMap<String, String> directoryList;
    private List<String> findList;
    Timer timer = new Timer();


    private long linSearching(){
        long foundCount = 0;
        for (String query : findList) {
            if (directoryList.containsKey(query)) {
                foundCount ++;
                break;
            }
        }
         return foundCount;
    }

    private boolean bubbleSort(){
        long startSearch = timer.start();
        for (int i = 0; i < findList.size(); i++) {
           for (int j = 0; j < findList.size() - i - 1; j++) {
                if (findList.get(j).compareTo(findList.get(j + 1)) > 0) {
                    String temp = findList.get(j);
                    findList.set(j, findList.get(j + 1));
                    findList.set(j + 1, temp);
                }
            }
        }
        return true;
    }



    @Override
    public void start() {
        timer.start();
        System.out.println("Start searching (linear search)...");
        directoryList = Files.addDir(new File("C:\\Users\\helen\\Phone Book (Java)\\directory.txt"));
        findList = Files.addFind(new File("C:\\Users\\helen\\Phone Book (Java)\\find.txt"));
        long findNumber = linSearching();
        timer.stop();
        timer.duration();
        System.out.println("Found " + findNumber + " / " + findList.size() +
                " entries. Time taken: " + timer.getMins() + " min. " +
                timer.getSecs() + " sec. " + timer.getMs() + " ms.");

    }
}



