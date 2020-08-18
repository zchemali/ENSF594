##Exercise 1
**Description**

This class compares the time needed to sort arrays of different size by using different sorting algorithms.
At runtime you have to pass the following arguments : 
- order (ascending, descending, or random)
- size (any positive integer number)
- algorithm (bubble, insertion, merge, or quick)
- outputfile (must have .txt at the end)

The output file will contain the time need to sort the array, and all the elements of the sorted
array

**UML**

![UML_Exercise_1](Ex1.PNG)


##Exercise 2
This class reads a txt file of words and checks all the anagrams contained in
this text file, then write the result to an output file
At runtime you have to pass the following arguments:
- inputfile (the file to read)
- outputfile (the file name to write)

This class creates a dynamic array of linked lists

1) Dynamic array is simply an array that keeps growing in size as new elements are added
the dynamic array is created by invoking `add(LinkedList ll)` in the DynamicArray class

2) LinkedLists are created by invoking `inserAtEnd(Node n)` in the LinkedList class

**UML**

 ![UML_Exercise_1](Ex2.PNG)