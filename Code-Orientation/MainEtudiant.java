import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MainEtudiant {

    public static void main(String[] args) {
        // Liste des données fournies (nom, prenom, numero, departement, moyenne)
        String[][] donnees = {
            {"Taylor", "Michael", "32", "GI", "19.38"},
            {"Harrington", "Linda", "42", "MF", "10.03"},
            {"Chapman", "Jenny", "50", "MF", "19.88"},
            {"Hess", "Rose", "4", "MF", "16.07"},
            {"Thompson", "Jerry", "13", "GI", "10.06"},
            {"Johnson", "Jeffrey", "2", "GI", "12.08"},
            {"Garrett", "Gary", "72", "GI", "10.88"},
            {"Nelson", "James", "14", "MF", "11.49"},
            {"Smith", "Danielle", "89", "MF", "12.04"},
            {"Dennis", "Danielle", "3", "GI", "11.05"},
            {"Walton", "Renee", "71", "MF", "16.81"},
            {"Johnson", "Ryan", "98", "MF", "19.03"},
            {"Fox", "Michelle", "54", "MF", "12.59"},
            {"Owen", "Anthony", "93", "MF", "19.00"},
            {"Jefferson", "Rebecca", "63", "GI", "12.76"},
            {"Chapman", "David", "43", "MI", "12.73"},
            {"Bowers", "Anthony", "77", "MF", "16.90"},
            {"Johnson", "Lindsey", "45", "MI", "15.11"},
            {"Smith", "William", "78", "GI", "11.45"},
            {"Perez", "Jacob", "22", "MF", "15.22"},
            {"Herrera", "Nancy", "81", "GI", "18.64"},
            {"Santos", "Michelle", "61", "GI", "10.47"},
            {"Odom", "Kimberly", "34", "MI", "19.45"},
            {"Drake", "Andre", "21", "MI", "19.81"},
            {"Clark", "Gail", "36", "GI", "19.71"},
            {"Rosario", "Gregory", "46", "MF", "14.22"},
            {"Abbott", "Lori", "25", "MI", "16.51"},
            {"Henderson", "Jesse", "97", "MF", "19.56"},
            {"Brown", "Brittany", "30", "GI", "12.28"},
            {"Brady", "Donna", "1", "MF", "12.13"},
            {"Todd", "Diana", "87", "MF", "17.47"},
            {"Garcia", "Pamela", "67", "GI", "12.75"},
            {"Rich", "Brandon", "41", "GI", "13.32"},
            {"Perez", "Joshua", "34", "GI", "16.82"},
            {"Bowen", "Robert", "93", "MI", "14.92"},
            {"Dawson", "Robert", "59", "MI", "19.71"},
            {"Stone", "Maurice", "75", "MI", "17.62"},
            {"Smith", "Michelle", "50", "MF", "14.06"},
            {"Thomas", "Matthew", "7", "MF", "18.75"},
            {"Martin", "Charlene", "26", "GI", "12.92"},
            {"Walker", "Miranda", "47", "MI", "11.42"},
            {"Johnson", "Marc", "95", "MI", "10.82"},
            {"Davidson", "Robert", "42", "MI", "11.73"},
            {"Moore", "Allison", "77", "MF", "14.65"},
            {"Burgess", "Sarah", "88", "MF", "11.30"},
            {"Marsh", "Ryan", "66", "MF", "10.20"},
            {"Bryant", "Crystal", "53", "GI", "14.38"},
            {"Haney", "Kenneth", "4", "GI", "11.49"},
            {"Tucker", "Joseph", "29", "MF", "10.70"},
            {"White", "Gary", "89", "MI", "16.89"},
            {"Harris", "Bryan", "57", "MF", "12.35"},
            {"Bolton", "Joshua", "44", "MF", "12.78"},
            {"Deleon", "Cassandra", "76", "GI", "13.16"},
            {"Velazquez", "Daniel", "13", "MI", "11.79"},
            {"Clarke", "Christopher", "86", "MI", "16.69"},
            {"Wheeler", "Judith", "12", "GI", "12.14"},
            {"Fuller", "David", "85", "MI", "10.80"},
            {"Davis", "Jennifer", "14", "MI", "17.74"},
            {"Gomez", "Andrew", "35", "MF", "14.66"},
            {"Baker", "Tracy", "27", "MI", "19.10"},
            {"Brown", "Kenneth", "72", "MF", "10.40"},
            {"James", "Jennifer", "22", "MI", "19.60"},
            {"Morrison", "Alejandro", "81", "MI", "19.66"},
            {"Yu", "William", "38", "GI", "13.45"},
            {"Gonzalez", "Melissa", "52", "MF", "14.06"},
            {"Andrade", "Lauren", "96", "MI", "15.33"},
            {"Alvarado", "Patrick", "74", "MI", "16.63"},
            {"Fields", "Shawn", "32", "MF", "12.06"},
            {"Alexander", "John", "16", "MF", "19.09"},
            {"Bowman", "Clarence", "39", "MI", "18.61"},
            {"Berry", "Taylor", "65", "GI", "10.70"},
            {"Williams", "Ryan", "69", "MI", "19.73"},
            {"Oliver", "Ralph", "28", "MI", "14.37"},
            {"Rose", "Taylor", "64", "GI", "11.47"},
            {"Smith", "Dennis", "90", "GI", "17.87"},
            {"Andrade", "Paula", "78", "MI", "16.60"},
            {"Fuller", "Richard", "3", "MF", "19.43"},
            {"Cooper", "Robert", "46", "MF", "16.04"},
            {"Dunn", "Adam", "21", "GI", "16.20"},
            {"Johnston", "Oscar", "17", "GI", "18.20"},
            {"Hopkins", "Haley", "43", "GI", "10.46"},
            {"Thompson", "Dana", "36", "GI", "19.90"},
            {"Johnson", "Jason", "15", "MI", "15.76"},
            {"Fischer", "Regina", "83", "MI", "16.17"},
            {"Woodward", "Erin", "45", "MF", "18.50"},
            {"Perez", "Bobby", "2", "MF", "18.33"},
            {"Hanson", "Tara", "31", "GI", "11.22"},
            {"Bryant", "Ashlee", "48", "MI", "12.00"},
            {"Lee", "Kenneth", "68", "GI", "12.06"},
            {"Jaankins", "Tamy", "8", "MF", "14.92"}
        };

        // Liste pour stocker les étudiants créés
        List<Etudiant> etudiants = new ArrayList<>();
        Etudiant.autorisation = false;
        // Parcourir les données et créer les étudiants
        for (String[] data : donnees) {
            String nom = data[0];
            String prenom = data[1];
            int numero = Integer.parseInt(data[2]);
            String departement = data[3];
            double moyenne = Double.parseDouble(data[4]);

            Etudiant etudiant = new Etudiant(nom, prenom, numero, departement, moyenne);
            etudiants.add(etudiant);
        }

        // Trier les étudiants par ordre décroissant de moyenne
        Collections.sort(etudiants, new Comparator<Etudiant>() {
            @Override
            public int compare(Etudiant e1, Etudiant e2) {
                return Double.compare(e2.getMoyenne(), e1.getMoyenne());
            }
        });

        Scanner scanner = new Scanner(System.in);
        System.out.println("Connexion");

        String nomUtilisateur = "";
        int idUtilisateur = -1;
        boolean trouve = false;

        while (!trouve) {
            System.out.print("Entrez votre nom : ");
            nomUtilisateur = scanner.nextLine();

            System.out.print("Entrez votre ID : ");
            idUtilisateur = scanner.nextInt();
            scanner.nextLine(); // Pour consommer le retour à la ligne restant après nextInt()

            // Parcourir la liste des étudiants pour vérifier les informations
            for (Etudiant etudiant : etudiants) {
                if (etudiant.getNom().equals(nomUtilisateur) && etudiant.getIdEtudiant() == idUtilisateur) {
                    trouve = true;
                    System.out.println("Bienvenue, " + etudiant.getNom() + " !");
                    break;
                }
            }

            if (!trouve) {
                System.out.println("Informations incorrectes");
            }
        }

        // Exemple d'utilisation
        Etudiant etudiant1 = null;
        for (Etudiant etudiant : etudiants) {
            if (etudiant.getNom().equals(nomUtilisateur) && etudiant.getIdEtudiant() == idUtilisateur) {
                etudiant1 = etudiant;
                break;
            }
        }
        // Verification autorisation de formuler des voeux
        try (BufferedReader reader = new BufferedReader(new FileReader("autorisation_etudiant.txt"))) {
            String line = reader.readLine();
            if (line != null) {
                Etudiant.autorisation = Boolean.parseBoolean(line);
            } else {
                Etudiant.autorisation = true; // valeur par défaut si le fichier est vide
            }
        } catch (IOException e) {
            Etudiant.autorisation = false; // valeur par défaut en cas d'erreur
            e.printStackTrace();
        }

        System.out.println("Menu");
        System.out.println("1- Voir les options disponibles");
        System.out.println("2- Formuler mes vœux");
        System.out.println("3- Voir mes résultats");
        System.out.println("4- Afficher les vœux");

        int choix = scanner.nextInt();
        scanner.nextLine();

        if (!Etudiant.autorisation && choix == 2) {
            System.out.println("La formulation des voeux n'est plus possible");
        } else {
            switch (choix) {
                case 1:
                    etudiant1.voirOptionsDisponibles();
                    break;
                case 2:
                    // Simulation de la saisie des vœux par l'utilisateur
                    System.out.println("Formuler vos vœux (entrez 'fin' pour terminer) :");
                    ArrayList<Option> voeuxList = new ArrayList<>();

                    for (int i = 1; i <= 3; i++) {
                        if (etudiant1.getfiliere().equals("MI")) {
                            System.out.println("Entrez votre " + i + "ème option (DataScience, HPDA, DDD)");
                        } else if (etudiant1.getfiliere().equals("MF")) {
                            System.out.println("Entrez votre " + i + "ème option (IngFinance, Actuariat, ModMathFinance)");
                        } else if (etudiant1.getfiliere().equals("GI")) {
                            System.out.println("Entrez votre " + i + "ème option (VisualComputing, CyberSecurite, IA)");
                        }
                        String optionInput = scanner.nextLine();
                        try {
                            voeuxList.add(Option.valueOf(optionInput));
                        } catch (IllegalArgumentException e) {
                            System.out.println("Option invalide: " + optionInput);
                            i--; // Pour redemander la même option
                        }
                    }

                    Option[] voeuxArray = new Option[voeuxList.size()];
                    voeuxArray = voeuxList.toArray(voeuxArray);
                    etudiant1.remplirFicheVoeux(voeuxArray);

                    // Écrire les vœux dans un fichier en mode append
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter("voeux_etudiant.txt", true))) {
                        writer.write("Vœux de l'étudiant " + etudiant1.getNom() + " (ID: " + etudiant1.getIdEtudiant() + "):\n");
                        for (Option voeu : etudiant1.getListeVoeux()) {
                            writer.write(voeu.name() + "\n");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    break;
                case 3:
                    etudiant1.voirResultat();
                    break;
    
                case 4:
                int cpt=3;
                    // Lire les vœux depuis le fichier
                    System.out.println("Liste des vœux de l'étudiant " + etudiant1.getNom() + " (ID: " + etudiant1.getIdEtudiant() + "):");
                    try (BufferedReader reader = new BufferedReader(new FileReader("voeux_etudiant.txt"))) {
                        String line;
                        boolean found = false;
                        while ((line = reader.readLine()) != null) {
                            if (line.contains("Vœux de l'étudiant " + etudiant1.getNom() + " (ID: " + etudiant1.getIdEtudiant() + ")")) {
                                found = true;
                                continue;
                                

                            }
                            if (found && line.trim().isEmpty()) {
                                break; // Sortir de la boucle lorsque les vœux de l'étudiant actuel sont terminés
                            }
                            if (found && cpt>0) {
                
                                System.out.println(line);
                                cpt=cpt-1;
                            }
                        }
                        if (!found) {
                            System.out.println("Aucun vœu trouvé pour cet étudiant.");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
         // Fermer le scanner
         scanner.close();
    }
}

