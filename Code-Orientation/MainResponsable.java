import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;


public class MainResponsable {
    public static void main(String[] args) {
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
        Responsable Responsable1 = new Responsable("Dubois","Laurent", 1);
        Responsable Responsable2 = new Responsable("Moreau","Claire", 2);
    
        
        List<Responsable> listeResponsables = new ArrayList<>();

        // Ajout des responsables à la liste
        listeResponsables.add(Responsable1);
        listeResponsables.add(Responsable2);

        System.out.println("Connexion");
        boolean trouve = false;
        Scanner scanner = new Scanner(System.in);
        
        while (!trouve) {
            System.out.print("Entrez votre nom : ");
            String nomUtilisateur = scanner.nextLine();
        
            System.out.print("Entrez votre ID : ");
            int idUtilisateur = scanner.nextInt();
            scanner.nextLine(); 

            for (Responsable responsable : listeResponsables) {
                if (responsable.getNom().equals(nomUtilisateur) && responsable.getIdResponsable() == idUtilisateur) {
                    trouve = true;
                    System.out.println("Bienvenue, " + responsable.getNom() + " !");
                    break;
                }
            }
        
            if (!trouve) {
                System.out.println("Informations incorrectes");
            
            }
        }
        System.out.println("Menu");
        System.out.println("1- Activer la compagne de formulation des voeux");
        System.out.println("2- Desactiver la campagne de formulation des voeux");
        System.out.println("3- Lancer l'orientation");

        int choix = scanner.nextInt();
        scanner.nextLine();

        switch (choix) {
            case 1:
                Responsable.activerSaisieVoeux();
               System.out.println("Vous venez d'activer la campagne de formulation des voeux ");
                break;
            case 2:
            Responsable.desactiverSaisieVoeux();
               System.out.println("Vous venez de desactiver la campagne de formulation des voeux ");
                break;
            case 3:
            System.out.println("");
            Responsable.lancerOrientation(etudiants);
            System.out.println("Orientation effectuée. Vous venez d'attribuer à chaque étudiant une option.");   
                   
        }
         // Fermer le scanner
            scanner.close();
    }
   
}        
    

