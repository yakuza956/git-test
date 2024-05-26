import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class MainEtudiantGUI {

    private JFrame frame;
    private JTextField nomField;
    private JTextField idField;
    private JTextArea outputArea;
    private JButton btnOptions;
    private JButton btnFormulerVoeux;
    private JButton btnVoirResultats;
    private JButton btnAfficherVoeux;
    private List<Etudiant> etudiants;
    public Etudiant etudiantConnecte;

    public MainEtudiantGUI() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Application Étudiant");
        frame.setBounds(100, 100, 900, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNom = new JLabel("Nom :");
        lblNom.setBounds(50, 50, 80, 25);
        frame.getContentPane().add(lblNom);

        nomField = new JTextField();
        nomField.setBounds(140, 50, 200, 25);
        frame.getContentPane().add(nomField);
        nomField.setColumns(10);

        JLabel lblId = new JLabel("ID :");
        lblId.setBounds(50, 100, 80, 25);
        frame.getContentPane().add(lblId);

        idField = new JTextField();
        idField.setBounds(140, 100, 80, 25);
        frame.getContentPane().add(idField);
        idField.setColumns(10);

        outputArea = new JTextArea();
        outputArea.setBounds(370, 50, 500, 250);
        outputArea.setEditable(false);
        frame.getContentPane().add(outputArea);

        JButton btnConnexion = new JButton("Connexion");
        btnConnexion.setBounds(250, 100, 100, 25);
        frame.getContentPane().add(btnConnexion);

        btnConnexion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nom = nomField.getText();
                int id = Integer.parseInt(idField.getText());

                boolean trouve = false;

                for (Etudiant etudiant : etudiants) {
                    if (etudiant.getNom().equals(nom) && etudiant.getIdEtudiant() == id) {
                        outputArea.setText("Bienvenue, " + etudiant.getNom() + " !");
                        etudiantConnecte = etudiant;
                        trouverEtAfficherBoutons();
                        trouve = true;
                        break;
                    }
                }

                if (!trouve) {
                    outputArea.setText("Informations incorrectes");
                    cacherBoutons();
                }
            }
        });

        btnOptions = new JButton("Voir Options Disponibles");
        btnOptions.setBounds(50, 150, 200, 25);
        frame.getContentPane().add(btnOptions);
        btnOptions.setVisible(false);

        btnOptions.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                voirOptionsDisponibles();
            }
        });

        btnFormulerVoeux = new JButton("Formuler mes vœux");
        btnFormulerVoeux.setBounds(50, 200, 200, 25);
        frame.getContentPane().add(btnFormulerVoeux);
        btnFormulerVoeux.setVisible(false);

        btnFormulerVoeux.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                formulerVoeux();
            }
        });


        btnVoirResultats = new JButton("Voir mes résultats");
        btnVoirResultats.setBounds(50, 250, 200, 25);
        frame.getContentPane().add(btnVoirResultats);
        btnVoirResultats.setVisible(false);

        btnVoirResultats.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                voirResultats();
            }
        });
        

        btnAfficherVoeux = new JButton("Afficher les vœux");
        btnAfficherVoeux.setBounds(50, 300, 200, 25);
        frame.getContentPane().add(btnAfficherVoeux);
        btnAfficherVoeux.setVisible(false);

        btnAfficherVoeux.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                afficherVoeux();
            }
        });

        etudiants = new ArrayList<>();
        initialiserEtudiants();

        frame.setVisible(true);
    }

    private void initialiserEtudiants() {
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

        for (String[] data : donnees) {
            String nom = data[0];
            String prenom = data[1];
            int numero = Integer.parseInt(data[2]);
            String departement = data[3];
            double moyenne = Double.parseDouble(data[4]);

            Etudiant etudiant = new Etudiant(nom, prenom, numero, departement, moyenne);
            etudiants.add(etudiant);
        }
    }
    private void voirOptionsDisponibles() {
        if (etudiantConnecte != null) {
            StringBuilder message = new StringBuilder();
            message.append("Options disponibles pour l'étudiant ")
                   .append(etudiantConnecte.getNom())
                   .append(" ")
                   .append(etudiantConnecte.getPrenom())
                   .append(" :\n");
            if (etudiantConnecte.getfiliere().equals("GI")) {
                message.append("GI: VisualComputing\n")
                       .append("GI: CyberSécurité\n")
                       .append("GI: IA\n");
            } else if (etudiantConnecte.getfiliere().equals("MF")) {
                message.append("MF: IngFinance\n")
                       .append("MF: Actuariat\n")
                       .append("MF: ModMathFinance\n");
            } else if (etudiantConnecte.getfiliere().equals("MI")) {
                message.append("MI: DataScience\n")
                       .append("MI: HPDA\n")
                       .append("MI: DDD\n");
            } else {
                message.append("Filière inconnue.\n");
            }
            outputArea.setText(message.toString());
        }
    }
    

    private void formulerVoeux() {
        if (etudiantConnecte == null) {
            return;
        }
    
        ArrayList<Option> voeuxList = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            String message;
            if (etudiantConnecte.getfiliere().equals("MI")) {
                message = "Entrez votre " + i + "ème option (DataScience, HPDA, DDD)";
            } else if (etudiantConnecte.getfiliere().equals("MF")) {
                message = "Entrez votre " + i + "ème option (IngFinance, Actuariat, ModMathFinance)";
            } else if (etudiantConnecte.getfiliere().equals("GI")) {
                message = "Entrez votre " + i + "ème option (VisualComputing, CyberSecurite, IA)";
            } else {
                message = "Entrez votre " + i + "ème option";
            }
    
            String optionInput = JOptionPane.showInputDialog(frame, message);
            if (optionInput == null) {
                break; // L'utilisateur a annulé
            }
    
            try {
                Option option = Option.valueOf(optionInput);
                voeuxList.add(option);
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(frame, "Option invalide: " + optionInput);
                i--; // Redemander la même option
            }
        }
        // Écrire les voeux dans un fichier en mode append
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("voeux_etudiant.txt", true))) {
            writer.write("Vœux de l'étudiant " + etudiantConnecte.getNom() + " (ID: " + etudiantConnecte.getIdEtudiant() + "):\n");
            for (Option voeu : voeuxList) {
                writer.write(voeu.name() + "\n");
            }
            writer.flush(); // Assurer l'écriture dans le fichier
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        // Afficher le message de succès
        JOptionPane.showMessageDialog(frame, "Fiche de vœux remplie avec succès.");
    }
    

    
    private void voirResultats() {
        if (etudiantConnecte != null) {
            StringBuilder resultBuilder = new StringBuilder();
    
            // Logique pour récupérer les résultats de l'étudiantConnecte
            String fichier = "attributions_etudiant.txt";
            List<String> optionsAttribuees = new ArrayList<>();
    
            try (BufferedReader br = new BufferedReader(new FileReader(fichier))) {
                String ligne;
                while ((ligne = br.readLine()) != null) {
                    optionsAttribuees.add(ligne);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
    
            boolean found = false;
            for (String attribution : optionsAttribuees) {
                if (attribution.contains("ID: " + etudiantConnecte.getIdEtudiant()) && attribution.contains("Nom: " + etudiantConnecte.getNom())) {
                    String option = attribution.split("Option attribuée: ")[1];
                    resultBuilder.append("Option attribuée pour l'étudiant ")
                                 .append(etudiantConnecte.getNom())
                                 .append(" (ID: ")
                                 .append(etudiantConnecte.getIdEtudiant())
                                 .append("): ")
                                 .append(option)
                                 .append("\n");
                    found = true;
                }
            }
    
            if (!found) {
                resultBuilder.append("Aucune option attribuée trouvée pour l'étudiant ")
                             .append(etudiantConnecte.getNom())
                             .append(" (ID: ")
                             .append(etudiantConnecte.getIdEtudiant())
                             .append(").");
            }
    
            // Afficher les résultats dans la zone de texte
            outputArea.setText(resultBuilder.toString());
        }
    }

    private void afficherVoeux() {
        if (etudiantConnecte != null) {
            StringBuilder voeuxBuilder = new StringBuilder();
    
            voeuxBuilder.append("Liste des vœux de l'étudiant ")
                    .append(etudiantConnecte.getNom())
                    .append(" (ID: ")
                    .append(etudiantConnecte.getIdEtudiant())
                    .append("):\n");

            // Lire les vœux depuis le fichier
            try (BufferedReader reader = new BufferedReader(new FileReader("voeux_etudiant.txt"))) {
                String line;
                boolean found = false;
                int cpt = 3; // Nombre maximum de vœux à afficher
                while ((line = reader.readLine()) != null) {
                    if (line.contains("Vœux de l'étudiant " + etudiantConnecte.getNom() + " (ID: " + etudiantConnecte.getIdEtudiant() + ")")) {
                        found = true;
                        continue;
                    }
                    if (found && line.trim().isEmpty()) {
                        break; // Sortir de la boucle lorsque les vœux de l'étudiant actuel sont terminés
                    }
                    if (found && cpt > 0) {
                        voeuxBuilder.append(line).append("\n");
                        cpt--;
                    }
                }
                if (!found) {
                    voeuxBuilder.append("Aucun vœu trouvé pour cet étudiant.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
    
            // Afficher les vœux dans la zone de texte
            outputArea.setText(voeuxBuilder.toString());
        }
    }
    

    private void trouverEtAfficherBoutons() {
        btnOptions.setVisible(true);
        btnFormulerVoeux.setVisible(true);
        btnVoirResultats.setVisible(true);
        btnAfficherVoeux.setVisible(true);
    }

    private void cacherBoutons() {
        btnOptions.setVisible(false);
        btnFormulerVoeux.setVisible(false);
        btnVoirResultats.setVisible(false);
        btnAfficherVoeux.setVisible(false);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainEtudiantGUI();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
