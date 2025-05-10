Interactive Comparison of QuickSort vs Randomized QuickSort

 I have comparing two sorting algorithms (QuickSort and RandomizedQuickSort) by measuring how long they take to sort random data. Then, you create a pie chart to show the time comparison between them.

2. Code Files
a. CompareSorts.java:
Generates random data of different sizes.

Measures time taken by QuickSort and RandomizedQuickSort.
Saves results (times) in a text file called sorting_times.txt.

b. QuickSort.java:
Implements the QuickSort algorithm.
Measures the time it takes to sort an array using QuickSort.

c. RandomizedQuickSort.java:
Implements the RandomizedQuickSort algorithm (similar to QuickSort but uses random pivot).
Measures time taken to sort using this method.

d. plot_pie_chart.py:
Reads the time data from sorting_times.txt.
Creates a pie chart to compare the times for both sorting algorithms.
Saves the chart as an image file (sorting_times_pie_chart.png).
![image](https://github.com/user-attachments/assets/c500325b-61ff-47c1-80bf-ce2ae71157da)


3. Uploading to GitHub
You used Git to upload your project to GitHub:
git init: Initializes the Git project in your folder.
git add .: Adds all your files to Git.
git commit -m "message": Saves the current state of your project.
git push -u origin master: Uploads your project to GitHub.

Steps Summary:
Generate Data: Create random arrays.
Sort and Time: Use QuickSort and RandomizedQuickSort to sort and measure time.
Save Data: Store sorting times in a text file (sorting_times.txt).
Visualize: Create a pie chart to compare the times using Python.
Upload to GitHub: Use Git commands to push your project to GitHub.

