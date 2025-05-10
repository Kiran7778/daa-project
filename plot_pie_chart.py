import os
import matplotlib.pyplot as plt

# Create the 'plots' directory if it doesn't exist
if not os.path.exists('plots'):
    os.makedirs('plots')

# Assuming you already have the pie chart code here
# Example pie chart
labels = ['QuickSort', 'Randomized QuickSort']
sizes = [20, 80]  # Example data

# Create a pie chart
plt.pie(sizes, labels=labels, autopct='%1.1f%%', startangle=140)
plt.axis('equal')  # Equal aspect ratio ensures that pie chart is drawn as a circle.

# Save the pie chart to the 'plots' folder
plt.savefig('plots/sorting_times_pie_chart.png')
print("Pie chart saved successfully!")
