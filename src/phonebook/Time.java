package phonebook;

import java.time.Duration;

public class Time {
    
    private static long startSearchingTime;
    private static long endSearchingTime;
    private static long startSortingTime;
    private static long endSortingTime;
    private static long startCreatingTime;
    private static long endCreatingTime;
    private static long allTime;
    private static long linearSearchTime;
    private Duration duration;
    private long minutes;
    private long seconds;
    private long milliseconds;

    void startSearch() {
        startSearchingTime = System.currentTimeMillis();

    }

    void endSearchTime() {
        endSearchingTime = System.currentTimeMillis();

    }

    void startSorting() {
        startSortingTime = System.currentTimeMillis();

    }

    long getAllSearchingTime() {
        return endSearchingTime - startSearchingTime;
    }

    void endSorting() {
        endSortingTime = System.currentTimeMillis();

    }

    void startCreating() {
        startCreatingTime = System.currentTimeMillis();

    }

    void endCreating() {
        endCreatingTime = System.currentTimeMillis();

    }

    long getAllCreatingTime() {
        return endCreatingTime - startCreatingTime;
    }

    long currentSortingTime() {
        return System.currentTimeMillis() - startSortingTime;
    }

    long getAllSortingTime() {
        return endSortingTime - startSortingTime;
    }

    public void setAllTime() {
        allTime = getAllSortingTime() + getAllSearchingTime();
    }

    public void setLinearSearchTime() {
        linearSearchTime = endSearchingTime - startSearchingTime;
    }

    public long getLinearSearchTime() {
        return linearSearchTime;
    }

    void printAllTime() {
        setAllTime();
        duration = Duration.ofMillis(allTime);
        seconds = duration.toSecondsPart();
        minutes = duration.toMinutesPart();
        milliseconds = duration.toMillisPart();
        System.out.printf("Time taken: %d min. %d sec. %d ms.\n", minutes, seconds, milliseconds);
    }

    void printSearchingTime() {
        duration = Duration.ofMillis(getAllSearchingTime());
        seconds = duration.toSecondsPart();
        minutes = duration.toMinutesPart();
        milliseconds = duration.toMillisPart();
        System.out.printf("\nSearching time: %d min. %d sec. %d ms.\n", minutes, seconds, milliseconds);
    }

    void printSortingTime() {
        duration = Duration.ofMillis(endSortingTime - startSortingTime);
        seconds = duration.toSecondsPart();
        minutes = duration.toMinutesPart();
        milliseconds = duration.toMillisPart();
        System.out.printf("Sorting time: %d min. %d sec. %d ms.", minutes, seconds, milliseconds);
    }

    void printLinearSearchAndBubbleSortTime() {
        duration = Duration.ofMillis(getAllSortingTime() + getLinearSearchTime());
        seconds = duration.toSecondsPart();
        minutes = duration.toMinutesPart();
        milliseconds = duration.toMillisPart();
        System.out.printf("Time taken: %d min. %d sec. %d ms.\n", minutes, seconds, milliseconds);

    }

    void printLinearSearchTime() {
        duration = Duration.ofMillis(getLinearSearchTime());
        seconds = duration.toSecondsPart();
        minutes = duration.toMinutesPart();
        milliseconds = duration.toMillisPart();
        System.out.printf("Time taken: %d min. %d sec. %d ms.\n", minutes, seconds, milliseconds);
    }

    void printFoundEntries(int count, int namesCount) {
        System.out.printf("Found %d / %d entries. ", count, namesCount);
    }

    void printCreating(){
        duration = Duration.ofMillis(endCreatingTime - startCreatingTime);
        seconds = duration.toSecondsPart();
        minutes = duration.toMinutesPart();
        milliseconds = duration.toMillisPart();
        System.out.printf("Creating time: %d min. %d sec. %d ms.", minutes, seconds, milliseconds);
    }

    void printCreatingAndSearchTime(){
        duration = Duration.ofMillis(getAllCreatingTime() + getAllSearchingTime());
        seconds = duration.toSecondsPart();
        minutes = duration.toMinutesPart();
        milliseconds = duration.toMillisPart();
        System.out.printf("Time taken: %d min. %d sec. %d ms.\n", minutes, seconds, milliseconds);
    }
}
