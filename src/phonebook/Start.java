package phonebook;

import java.io.File;
import java.util.Hashtable;
import java.util.List;

public class Start {
    private List<Person> directoryList;
    private List<String> findList;
    private Hashtable<String,String> directoryTable;

    Search search = new Search();
    Sort sort = new Sort();

    public void start() {
        directoryList = Files.addDir(new File("data/directory.txt"));
        findList = Files.addFind(new File("find.txt"));

        System.out.println("Start searching (linear search)...");
        search.linearSearch(directoryList, findList, true);

        System.out.println("Start searching (bubble sort + jump search)...");
        List<Person> sortedBubble = sort.bubbleSort(directoryList, findList);
        search.jumpSearch(sortedBubble, findList);

        System.out.println("Start searching (quick sort + binary search)...");
        List<Person> sortedQuick = sort.quickSort(directoryList);
        search.binarySearch(sortedQuick, findList);

        System.out.println("Start searching (hash table)...");
        directoryTable = Files.toHash(directoryList);
        search.hashSearch(directoryTable,findList);
    }
}

