import matplotlib.pyplot as plt

# Function to read the data from the file and return it
def read_data(filename):
    sizes = []
    quickSort_times = []
    randomizedQuickSort_times = []
    
    with open(filename, 'r') as file:
        # Skip the header line
        next(file)
        
        # Read the data lines
        for line in file:
            data = line.split("\t")
            sizes.append(int(data[0]))  # First column is the size
            quickSort_times.append(float(data[1]))  # Second column is QuickSort time
            randomizedQuickSort_times.append(float(data[2]))  # Third column is Randomized QuickSort time

    return sizes, quickSort_times, randomizedQuickSort_times

# Read the data from the file
sizes, quickSort_times, randomizedQuickSort_times = read_data('sorting_times.txt')

# Plotting the graph
plt.figure(figsize=(10, 6))
plt.plot(sizes, quickSort_times, label='QuickSort', marker='o', color='blue')
plt.plot(sizes, randomizedQuickSort_times, label='Randomized QuickSort', marker='s', color='green')

# Adding title and labels
plt.title('Performance Comparison: QuickSort vs Randomized QuickSort')
plt.xlabel('Input Size (n)')
plt.ylabel('Execution Time (ms)')
plt.grid(True, linestyle='--', alpha=0.6)

# Adding a legend
plt.legend()

# Display the plot
plt.tight_layout()
plt.show()
