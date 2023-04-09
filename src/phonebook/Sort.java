package phonebook;

import java.util.ArrayList;
import java.util.List;

public class Sort {

    Time time = new Time();
    Search search = new Search();

    protected List<Person> bubbleSort(List<Person> directoryList, List<String> findList) {
        time.startSorting();
        for (int i = 0; i < directoryList.size() - 1; i++) {
            for (int j = 0; j < directoryList.size() - i - 1; j++) {
                if (time.currentSortingTime() > time.getLinearSearchTime() * 10) {
                    time.endSorting();
                    search.linearSearch(directoryList, findList, false);

                    time.printLinearSearchAndBubbleSortTime();
                    time.printSortingTime();
                    System.out.print(" - STOPPED, moved to linear search");
                    time.printSearchingTime();
                    return directoryList;
                }

                if (directoryList.get(j).getName().compareTo(directoryList.get(j + 1).getName()) > 0) {
                    Person tmp = directoryList.get(j);
                    directoryList.set(j, directoryList.get(j + 1));
                    directoryList.set(j + 1, tmp);
                }
            }
        }
        time.endSorting();
        return directoryList;
    }

     protected List<Person> quickSort(List<Person> directoryList) {
         time.startSorting();
        if(directoryList.isEmpty()){
            return directoryList;
        }
        int pivot = directoryList.size() / 2;

        List<Person> sorted;
        List<Person> lesser = new ArrayList<>();
        List<Person> greater = new ArrayList<>();

        Person piv = directoryList.get(pivot);
        String pivotVal = piv.getName();

        for (int i = 1; i < directoryList.size(); i++) {
            Person p = directoryList.get(i);
            if (p.getName().compareTo(pivotVal) < 0) {
                lesser.add(p);
            } else {
                greater.add(p);
            }
        }

        lesser = quickSort(lesser);
        greater = quickSort(greater);
        lesser.add(piv);
        lesser.addAll(greater);
        sorted = lesser;
        time.endSorting();
        return sorted;
    }
}
