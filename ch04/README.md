# Chapter 04 Repository Contents:

- 4.6  printRange: prints the sequence of numbers between x and y, increasing if x < y, and decreasing if x > y.
- 4.11 longestName: determines and print the longest name in a series of a specified length.
- 4.18 wordCount: counts and returns the number of words in a string.
- 4.19 quadrant: determines and return which quadrant a point resides in on a graph.

Issues:
The tester is currently returning "Expected IllegalArgumentException but was NullPointerException" for longestName and wordCount. To combat this I added numerous conditions that could throw exceptions but I am not sure what the tester is inputing to break the methods.
