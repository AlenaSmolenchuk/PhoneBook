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
        int firstIndex = 0;
        int lastIndex = directoryList.size() - 1;


        for(int j = 0; j < findList.size(); j++){
            while (firstIndex <= lastIndex){
                int middleIndex = (firstIndex + lastIndex)/2;
                if(directoryList.get(middleIndex).getName()
                        .equals(findList.get(j))){
                    //  count ++;
                } else if (directoryList.get(middleIndex).getName()
                        .compareTo(findList.get(j)) < 0){
                        firstIndex = middleIndex + 1;
                } else if (directoryList.get(middleIndex).getName()
                        .compareTo(findList.get(j)) > 0){
                        lastIndex = middleIndex - 1;
                }
            }
            count ++;
        }
        time.endSearchTime();
        time.printFoundEntries(count, findList.size());
        time.printAllTime();
        time.printSortingTime();
        time.printSearchingTime();

    }
}
