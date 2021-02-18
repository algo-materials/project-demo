# project-demo

This is designed to show how timing and testing should happen for projects in 44-349 (Survey of Algorithms).
This is an implementation of a fake project comparing two different searches on sorted lists (jumpsearch and binary search).
It contains both an implementation, tests, and timing code in Python and Java.
The Java implementation formats a table of various sizes for the different methods.
The Python version asks for user input (though it would also be appropriate to bring the value in as a command line)
The Python implementation also shows how to use both the `timeit` module and the `perf_counter` timer to measure execution time.
Note that there were no real error cases to test for in this project, but the testing is thorough (it tests for values that are and aren't in the list for both hand generated and random lists).  They could be more thorough by picking larger sizes of lists, but these tests should pick up the edge cases (finding the value at the end of the list) as well as values in the middle, as each test searches for every value in the list.

A possible error case to consider might be what happens if a user passes in a non-sorted list; this is a precondition of these functions and not tested for (as it would greatly affect overall runtime).  
Simple index bounds checking is expected in your tests.

## Sample output
### Java Implementation
```text
	5	10	50	100	1000	10000	100000
Binary	7349.0	625.0	1191.0	1413.0	404.0	265.0	328.0
Jump	2625.0	772.0	700.0	873.0	701.0	685.0	3323.0
```

### Python Implementation
```bash
$ python time_searches.py
Enter list size:10
timeit: jumpSearch
3.8749000000000147e-07
timeit: binarySearch
6.683900000000076e-07
---
Using perf_counter
jumpSearch: 4.429200000000022e-07
binarySearch: 6.826200000000005e-07
```
