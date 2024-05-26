import matplotlib.pyplot as plt
from collections import Counter
import os

# Path to the file
file_path = 'voeux_test_python.txt'  # Change this path if necessary

# Ensure the file exists
if not os.path.exists(file_path):
    print(f"Le fichier {file_path} n'existe pas.")
else:
    # Read the file and extract the options
    options = []

    with open(file_path, 'r', encoding='utf-8') as file:
        lines = file.readlines()
        for line in lines:
            line = line.strip()
            if line and not line.startswith("Vœux de l'étudiant"):
                options.append(line)

    # Count the occurrences of each option
    option_counts = Counter(options)

    # Create the histogram
    plt.figure(figsize=(10, 6))
    plt.bar(option_counts.keys(), option_counts.values(), color='skyblue')
    plt.xlabel('Options')
    plt.ylabel('Nombre de fois où elles se répètent')
    plt.title('Nombre de répétitions de chaque option dans le fichier de vœux')
    plt.xticks(rotation=45)
    plt.tight_layout()
    
    # Display the plot
    plt.show()
