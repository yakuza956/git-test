import matplotlib.pyplot as plt

def read_voeux(filename):
    voeux_dict = {}
    with open(filename, 'r', encoding='utf-8') as file:
        student_id = None
        voeux = []
        for line in file:
            if "ID:" in line:
                if student_id is not None:
                    voeux_dict[student_id] = voeux
                student_id = int(line.split("ID: ")[1].split(')')[0])
                voeux = []
            elif line.strip() and "Vœux de l'étudiant" not in line:
                voeux.append(line.strip())
        if student_id is not None:
            voeux_dict[student_id] = voeux
    return voeux_dict

def read_attributions(filename):
    attributions_dict = {}
    with open(filename, 'r', encoding='utf-8') as file:
        for line in file:
            parts = line.split(", ")
            student_id = int(parts[0].split(": ")[1])
            option_attribuee = parts[2].split(": ")[1].strip()
            attributions_dict[student_id] = option_attribuee
    return attributions_dict

def calculate_percentages(voeux, attributions):
    total_students = len(attributions)
    first_choice_count = 0
    second_choice_count = 0
    last_choice_count = 0

    for student_id, attributed_option in attributions.items():
        if student_id in voeux:
            voeux_list = voeux[student_id]
            if attributed_option == voeux_list[0]:
                first_choice_count += 1
            elif attributed_option == voeux_list[1]:
                second_choice_count += 1
            elif attributed_option == voeux_list[-1]:
                last_choice_count += 1

    first_choice_percentage = (first_choice_count / total_students) * 100
    second_choice_percentage = (second_choice_count / total_students) * 100
    last_choice_percentage = (last_choice_count / total_students) * 100

    return first_choice_percentage, second_choice_percentage, last_choice_percentage

def plot_histogram(first_choice_percentage, second_choice_percentage, last_choice_percentage):
    labels = ['Premier Vœu', 'Deuxième Vœu', 'Dernier Vœu']
    percentages = [first_choice_percentage, second_choice_percentage, last_choice_percentage]

    plt.figure(figsize=(10, 6))
    plt.bar(labels, percentages, color=['blue', 'green', 'red'])
    plt.xlabel('Vœux')
    plt.ylabel('Pourcentage')
    plt.title('Pourcentage d\'étudiants ayant obtenu leur premier, deuxième ou dernier vœu')
    plt.ylim(0, 100)

    for i, v in enumerate(percentages):
        plt.text(i, v + 1, f"{v:.2f}%", ha='center', va='bottom')

    plt.show()

def main():
    voeux_filename = 'voeux_test_python.txt'
    attributions_filename = 'attributions_test_python.txt'

    voeux = read_voeux(voeux_filename)
    attributions = read_attributions(attributions_filename)
    first_choice_percentage, second_choice_percentage, last_choice_percentage = calculate_percentages(voeux, attributions)

    print(f"Pourcentage d'étudiants ayant obtenu leur premier vœu : {first_choice_percentage:.2f}%")
    print(f"Pourcentage d'étudiants ayant obtenu leur deuxième vœu : {second_choice_percentage:.2f}%")
    print(f"Pourcentage d'étudiants ayant obtenu leur dernier vœu : {last_choice_percentage:.2f}%")

    plot_histogram(first_choice_percentage, second_choice_percentage, last_choice_percentage)

if __name__ == "__main__":
    main()
