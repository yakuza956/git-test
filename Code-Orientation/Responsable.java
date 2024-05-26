import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Responsable extends Utilisateur {
    private long idResponsable;

    public Responsable(String nom, String prenom, long idResponsable) {
        super(nom, prenom);
        this.idResponsable = idResponsable;
    }

    public long getIdResponsable() {
        return idResponsable;
    }

    public static void activerSaisieVoeux() {
        Etudiant.autorisation = true;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("autorisation_etudiant.txt"))) {
            writer.write(Boolean.toString(Etudiant.autorisation));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void desactiverSaisieVoeux() {
        Etudiant.autorisation = false;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("autorisation_etudiant.txt"))) {
            writer.write(Boolean.toString(Etudiant.autorisation));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void lancerOrientation(List<Etudiant> etudiants) {
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

        Scanner scanner = new Scanner(System.in);

        for (Etudiant etudiant : etudiants) {
            // Affichage des places disponibles
            System.out.println("Places disponibles dans chaque programme:");
            for (Map.Entry<String, Integer> entry : placesDisponibles.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " places disponibles");
            }

            System.out.println("\nNom: " + etudiant.getNom());
            System.out.println("Prénom: " + etudiant.getPrenom());
            System.out.println("idEtudiant: " + etudiant.getIdEtudiant());
            System.out.println("filiere: " + etudiant.getfiliere());
            System.out.println("Moyenne: " + etudiant.getMoyenne());
            System.out.println(); // Ajouter une ligne vide pour séparer les informations des étudiants
            System.out.println("Veuillez attribuer une option à l'étudiant " + etudiant.getNom());
            System.out.println("Voici la liste de vœux de l'étudiant " + etudiant.getNom() + " (ID: " + etudiant.getIdEtudiant() + "):");

            try (BufferedReader reader = new BufferedReader(new FileReader("voeux_etudiant.txt"))) {
                String line;
                int cpt = 3;
                boolean found = false;

                while ((line = reader.readLine()) != null) {
                    if (line.contains("Vœux de l'étudiant " + etudiant.getNom() + " (ID: " + etudiant.getIdEtudiant() + ")")) {
                        found = true;
                        continue;
                    }
                    if (found && line.trim().isEmpty()) {
                        break; // Sortir de la boucle lorsque les vœux de l'étudiant actuel sont terminés
                    }
                    if (found && cpt > 0) {
                        System.out.println(line);
                        cpt--;
                    }
                }

                if (!found) {
                    System.out.println("Aucun vœu trouvé pour cet étudiant.");
                }

                boolean valide = false;
                String attribution = "";
                while (!valide) {
                    attribution = scanner.nextLine();
                    if (placesDisponibles.containsKey(attribution)) {
                        int placesRestantes = placesDisponibles.get(attribution);
                        if (placesRestantes > 0) {
                            placesDisponibles.put(attribution, placesRestantes - 1);
                            etudiant.setoptionAttribuee(attribution);
                            valide = true;
                        } else {
                            System.out.println("Désolé, il n'y a plus de places disponibles pour " + attribution);
                        }
                    } else {
                        System.out.println("Option invalide. Veuillez choisir parmi les options disponibles.");
                    }
                }

                // Enregistrer l'attribution dans un fichier ou une base de données
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("attributions_etudiant.txt", true))) {
                    writer.write("ID: " + etudiant.getIdEtudiant() + ", Nom: " + etudiant.getNom() + ", Option attribuée: " + attribution);
                    writer.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        scanner.close();
    }
}
