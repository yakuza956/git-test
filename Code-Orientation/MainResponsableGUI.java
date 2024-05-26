import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import java.util.Comparator;

public class MainResponsableGUI extends JFrame {

    private List<Etudiant> etudiants;
    private List<Responsable> listeResponsables;
    private JPanel cardPanel;
    private CardLayout cardLayout;
    private JTextField textFieldNom;
    private JTextField textFieldID;

    public MainResponsableGUI(String[][] donnees) {
        etudiants = new ArrayList<>();
        listeResponsables = new ArrayList<>();

        // Initialisation des étudiants à partir des données
        for (String[] data : donnees) {
            try {
                String nom = data[0];
                String prenom = data[1];
                int numero = Integer.parseInt(data[2]);
                String departement = data[3];
                double moyenne = Double.parseDouble(data[4]);

                Etudiant etudiant = new Etudiant(nom, prenom, numero, departement, moyenne);
                etudiants.add(etudiant);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                // Handle invalid number format
            }
        }
        // Trier les étudiants par ordre décroissant de moyenne
        Collections.sort(etudiants, new Comparator<Etudiant>() {
            @Override
            public int compare(Etudiant e1, Etudiant e2) {
                return Double.compare(e2.getMoyenne(), e1.getMoyenne());
            }
        });

        // Ajout des responsables (à titre d'exemple)
        Responsable responsable1 = new Responsable("Dubois", "Laurent", 1);
        Responsable responsable2 = new Responsable("Moreau", "Claire", 2);
        listeResponsables.add(responsable1);
        listeResponsables.add(responsable2);

        setupGUI();
    }

    private void setupGUI() {
        setTitle("Application Responsable");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Création du panneau principal avec CardLayout
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Panneau pour le formulaire de connexion
        JPanel panelConnexion = new JPanel(new GridLayout(3, 2));
        JLabel labelNom = new JLabel("Nom:");
        textFieldNom = new JTextField();
        JLabel labelID = new JLabel("ID:");
        textFieldID = new JTextField();
        JButton buttonConnexion = new JButton("Se connecter");

        panelConnexion.add(labelNom);
        panelConnexion.add(textFieldNom);
        panelConnexion.add(labelID);
        panelConnexion.add(textFieldID);
        panelConnexion.add(buttonConnexion);

        // Ajout du panneau de connexion au cardPanel
        cardPanel.add(panelConnexion, "connexion");

        add(cardPanel, BorderLayout.CENTER);

        // Actions des boutons
        buttonConnexion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nomUtilisateur = textFieldNom.getText();
                try {
                    int idUtilisateur = Integer.parseInt(textFieldID.getText());
                    boolean trouve = false;
                    for (Responsable responsable : listeResponsables) {
                        if (responsable.getNom().equals(nomUtilisateur) && responsable.getIdResponsable() == idUtilisateur) {
                            trouve = true;
                            JOptionPane.showMessageDialog(MainResponsableGUI.this, "Bienvenue, " + responsable.getNom() + " !");

                            // Afficher le menu après connexion réussie
                            showMenu();
                            break;
                        }
                    }

                    if (!trouve) {
                        JOptionPane.showMessageDialog(MainResponsableGUI.this, "Informations incorrectes");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(MainResponsableGUI.this, "ID invalide");
                }
            }
        });

        pack();
        setLocationRelativeTo(null); // Centrer la fenêtre
        setVisible(true);
    }

    private void showMenu() {
        // Panneau pour le menu après connexion
        JPanel panelMenu = new JPanel(new GridLayout(4, 1));
        JLabel labelMenu = new JLabel("Menu");
        JButton buttonActiver = new JButton("Activer la campagne de formulation des voeux");
        JButton buttonDesactiver = new JButton("Désactiver la campagne de formulation des voeux");
        JButton buttonOrientation = new JButton("Lancer l'orientation");

        panelMenu.add(labelMenu);
        panelMenu.add(buttonActiver);
        panelMenu.add(buttonDesactiver);
        panelMenu.add(buttonOrientation);

        // Actions des boutons du menu
        buttonActiver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Responsable.activerSaisieVoeux();
                JOptionPane.showMessageDialog(MainResponsableGUI.this, "Vous venez d'activer la campagne de formulation des voeux");
            }
        });

        buttonDesactiver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Responsable.desactiverSaisieVoeux();
                JOptionPane.showMessageDialog(MainResponsableGUI.this, "Vous venez de désactiver la campagne de formulation des voeux");
            }
        });

        buttonOrientation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Appeler la méthode pour lancer l'orientation
                lancerOrientation();
            }
        });

        // Ajout du panneau de menu au cardPanel
        cardPanel.add(panelMenu, "menu");

        // Affichage du panneau de menu
        cardLayout.show(cardPanel, "menu");

        // Redimensionner la fenêtre pour le menu
        pack();
    }

    private void lancerOrientation() {
        Map<String, Integer> placesDisponibles = new HashMap<>();
        placesDisponibles.put("DataScience", 15);
        placesDisponibles.put("HPDA", 15);
        placesDisponibles.put("DDD", 15);
        placesDisponibles.put("IngFinance", 15);
        placesDisponibles.put("Actuariat", 15);
        placesDisponibles.put("ModMathFinance", 15);
        placesDisponibles.put("VisualComputing", 15);
        placesDisponibles.put("CyberSecurite", 15);
        placesDisponibles.put("IA", 15);

        for (Etudiant etudiant : etudiants) {
            StringBuilder message = new StringBuilder();
            message.append("Nom: ").append(etudiant.getNom()).append("\n");
            message.append("Prénom: ").append(etudiant.getPrenom()).append("\n");
            message.append("ID: ").append(etudiant.getIdEtudiant()).append("\n");
            message.append("Filière: ").append(etudiant.getfiliere()).append("\n");
            message.append("Moyenne: ").append(etudiant.getMoyenne()).append("\n\n");

            // Affichage des places disponibles dans chaque programme
            message.append("Places disponibles dans chaque programme:\n\n");
            for (Map.Entry<String, Integer> entry : placesDisponibles.entrySet()) {
                message.append(entry.getKey()).append(": ").append(entry.getValue()).append(" places disponibles\n");
            }

            StringBuilder voeux = new StringBuilder();
            voeux.append("Voici la liste de vœux de l'étudiant ").append(etudiant.getNom()).append(" (ID: ").append(etudiant.getIdEtudiant()).append("):\n");

            boolean found = false;
            try (BufferedReader reader = new BufferedReader(new FileReader("voeux_etudiant.txt"))) {
                String line;
                int cpt = 3; // Nombre de voeux à afficher
                while ((line = reader.readLine()) != null) {
                    if (line.contains("Vœux de l'étudiant " + etudiant.getNom() + " (ID: " + etudiant.getIdEtudiant() + ")")) {
                        found = true;
                        continue;
                    }

                    if (found && !line.trim().isEmpty()) {
                        voeux.append(line).append("\n");
                        cpt--;
                        if (cpt == 0) {
                            break; // Arrêter la lecture après avoir affiché les 3 premiers voeux
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (!found) {
                voeux.append("Aucun vœu trouvé pour cet étudiant.");
            }

            JOptionPane.showMessageDialog(MainResponsableGUI.this, voeux.toString(), "Liste de Voeux", JOptionPane.INFORMATION_MESSAGE);

            message.append("\nVeuillez attribuer une option à l'étudiant ").append(etudiant.getNom()).append("\n");
            boolean valide = false;
            String attribution = "";
            while (!valide) {
                attribution = JOptionPane.showInputDialog(MainResponsableGUI.this, message.toString());
                if (attribution == null) {
                    // L'utilisateur a appuyé sur Annuler ou fermé la fenêtre
                    return;
                } else if (placesDisponibles.containsKey(attribution)) {
                    int placesRestantes = placesDisponibles.get(attribution);
                    if (placesRestantes > 0) {
                        placesDisponibles.put(attribution, placesRestantes - 1);
                        valide = true;
                    } else {
                        JOptionPane.showMessageDialog(MainResponsableGUI.this, "Désolé, il n'y a plus de places disponibles pour " + attribution);
                    }
                } else {
                    JOptionPane.showMessageDialog(MainResponsableGUI.this, "Option invalide. Veuillez choisir parmi les options disponibles.");
                }
            }

            // Enregistrer l'attribution dans un fichier ou une base de données
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("attributions_etudiant.txt", true))) {
                writer.write("ID: " + etudiant.getIdEtudiant() + ", Nom: " + etudiant.getNom() + ", Option attribuée: " + attribution);
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        JOptionPane.showMessageDialog(MainResponsableGUI.this, "Orientation effectuée. Vous avez attribué à chaque étudiant une option.");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
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
                new MainResponsableGUI(donnees);
            }
        });
    }
}






    
