import java.io.File;
import java.util.List;

public class Sort {
    private List<Person> directoryList;
    private List<String> findList;

    Time time = new Time();
    Search search = new Search();

    private void bubbleSort(List<Person> directoryList,List<String> findList) {
        time.startSorting();
        for (int i = 0; i < directoryList.size() - 1; i++) {
            for (int j = 0; j < directoryList.size() - i - 1; j++) {
                if (time.currentSortingTime() > time.getLinearSearchTime() * 10) {
                    time.endSorting();
                    search.linearSearch(directoryList, findList,false);

                    time.printLinearSearchAndBubbleSortTime();
                    time.printSortingTime();
                    System.out.print(" - STOPPED, moved to linear search");
                    time.printSearchingTime();
                    return;
                }

                if (directoryList.get(j).getName().compareTo(directoryList.get(j + 1).getName()) > 0) {
                    Person tmp = directoryList.get(j);
                    directoryList.set(j, directoryList.get(j + 1));
                    directoryList.set(j + 1, tmp);
                }
            }
        }
        time.endSorting();
        search.jumpSearch(directoryList, findList);
    }

    public void start() {
        directoryList = Files.addDir(new File("C:\\Users\\helen\\Phone Book (Java)\\directory.txt"));
        findList = Files.addFind(new File("C:\\Users\\helen\\Phone Book (Java)\\find.txt"));

        System.out.println("Start searching (linear search)...");
        search.linearSearch(directoryList, findList, true);

        Sort sort = new Sort();
        System.out.println("Start searching (bubble sort + jump search)...");
        sort.bubbleSort(directoryList, findList);
    }

}
