# PhoneBook
Program will solve this problem once and forever: create a phonebook where you can easily, quickly and efficiently find necessary information. 
  
Names and numbers, here we come. 
 
 
# Stage 1/4: A needle in the hay   
 
In this stage, you should implement the simplest possible search to find the numbers of a few people whose names are listed in the file find.txt *(you can find it in folder "data")*. The data is randomly sorted, so we should use a Linear Search to look through each of the directory entries until we find our target. While there may be faster ways to do this, avoid using optimizations like Maps in this stage - we'll get to optimizing in later stages.

Your program should output a message to show it has started searching, followed by a message stating how many entries out of the total number of targets in find.txt you were able to find along with the time taken to search for those entries
  
  
 # Stage 2/4: Jumping bubbles

In this stage, you should sort the list of numbers alphabetically by the owner’s name. Sort the list using the bubble sort algorithm and search in the list using the jump search algorithm.
After sorting, search for 500 phone numbers using the list from the previous stage. Note how long it takes to sort the list, and also measure the time the program spends searching. Don't include the sorting time in the searching time, because the list of numbers stays sorted after every search request. If you want to save the sorted list into the file so you don’t have to sort it again, do not override the file that contains the unsorted list of phone numbers. This file will also be required in the next stage.

If the sorting process takes too long (more than 10 times longer than all 500 iterations of the linear search), you should stop sorting and use the linear search.

Output both approaches one after another and see which one is faster.


 # Stage 3/4: Need for speed

Like in the previous stage, you should first sort the list of phone numbers by the owner’s name and then search for the numbers of the 500 people from the list given in the first stage. Remember: to get decent and comparable results, you should put all the algorithms in the same initial conditions.

For sorting, use the quick sort algorithm, and for searching, the binary search algorithm.

Output all three approaches one after another and see which one is faster.


# Stage 4/4: Instant search

In the previous stage, you prepared the data using an algorithm with a complexity of O(n log n) and found the data using an algorithm with a complexity of O(log n). At this stage, you will implement faster data preparation and a faster search. The preparation will have a complexity of O(n), and the search will have a complexity of O(1). A hash table will help you with this.

You need to add all the elements to the hash table and then find the necessary phone numbers, as in the previous stages. Since the hash table is filled once, you need to measure the hash table creation time separately (just like you did with sorting in the previous stage).

Output all four approaches one after another and see which one is faster.
