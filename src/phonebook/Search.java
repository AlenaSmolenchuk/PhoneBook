package phonebook;

import java.util.List;

public class Search  {
    Time time = new Time();


    protected void linearSearch(List<Person> directoryList, List<String> findList, boolean printResult) {
        int count = 0;
        int namesCount = findList.size();

        time.startSearch();

        for (String findStr : findList) {
            for (Person person : directoryList) {
                if (person.getName().equals(findStr)) {
                    //count  ++;
                   // break;
                }
            }
            count ++;
        }


        time.endSearchTime();
        time.setLinearSearchTime();
        time.printFoundEntries(count, namesCount);
        if (printResult) {
            time.printLinearSearchTime();
        }

    }

    protected void jumpSearch(List<Person> directoryList, List<String> findList) {
        int count = 0;
        time.startSearch();

        for (int i = 0; i < findList.size(); i++) {
            String element = findList.get(i);
            int blockSize = (int) Math.floor(Math.sqrt(directoryList.size()));
            int currentLastIndex = blockSize - 1;
            while (currentLastIndex < directoryList.size()
                    && element.compareTo(directoryList.get(currentLastIndex).getName()) > 0) {
                currentLastIndex += blockSize;
            }
            for (int currentSearchIndex = currentLastIndex - blockSize + 1;
                 currentSearchIndex <= currentLastIndex
                 && currentSearchIndex < directoryList.size();
                 currentSearchIndex++) {
                if (directoryList.get(currentSearchIndex).getName().equals(element)) {
                    count++;
                    break;
                }
            }
        }

        time.endSearchTime();
        time.printFoundEntries(count, findList.size());
        time.printAllTime();
        time.printSortingTime();
        time.printSearchingTime();

    }

    protected void binarySearch(List<Person> directoryList, List<String> findList){
        time.startSearch();
        int count = 0;
        int first = 0;
        int last = findList.size() - 1;
        int mid = (first + last) / 2;

        while (first <= last) {
            for (int i = 0; i < directoryList.size(); i++) {
                if (findList.get(mid).compareTo(directoryList.get(i).getName()) < 0){
                    first = mid + 1;
                } else if (findList.get(mid).compareTo(directoryList.get(i).getName()) > 0) {
                    last = mid - 1;
                } else {
                    count = mid;
                }
                count++;
            }
        }
        time.endSearchTime();
        time.printFoundEntries(count, findList.size());
        time.printAllTime();
        time.printSortingTime();
        time.printSearchingTime();
    }

}
