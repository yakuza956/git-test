import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class Etudiant extends Utilisateur{

    private long idEtudiant;
    public String filiere;
    public Option[] voeux;
    public static boolean autorisation;
    public double moyenne;
    public String optionAttribuee;

    public static List<Option> listeVoeux = new ArrayList<>();
    
    public Etudiant(String nom, String prenom, long idEtudiant, String filiere, double moyenne) {
        super(nom, prenom);
        this.idEtudiant = idEtudiant;
        this.filiere = filiere;
    
        this.moyenne = moyenne;
    }
    
    public long getIdEtudiant() {
        return idEtudiant;
    }
    public void setoptionAttribuee(String optionAttribuee) {
        this.optionAttribuee = optionAttribuee;
    }
    public String getfiliere() {
        return filiere;
    }
    public void setfiliere(String filiere) {
        this.filiere = filiere;
    }

    public double getMoyenne() {
        return moyenne;
    }

    public void voirOptionsDisponibles() {
        System.out.println("Options disponibles pour l'étudiant " + getNom() + " " + getPrenom() + ":");
        if (filiere.equals("MI")) {
            System.out.println("MI: DataScience, HPDA, DDD");
        } else if (filiere.equals("MF")) {
            System.out.println("MF: IngFinance, Actuariat, ModMathFinance");
        } else if (filiere.equals("GI")) {
            System.out.println("GI: VisualComputing, CyberSsécurité, IA");
        } else {
            System.out.println("Filière inconnue.");
        }
    }

    public void remplirFicheVoeux(Option[] voeux) {
        this.voeux = voeux;
        for (Option v : voeux) {
            listeVoeux.add(v);
        }
        System.out.println("Fiche de vœux remplie avec succès.");
    }

    public List<Option> getListeVoeux() {
        return new ArrayList<>(listeVoeux); // Pour éviter les modifications externes
    }

    public void voirResultat() {
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
            if (attribution.contains("ID: " + idEtudiant) && attribution.contains("Nom: " + nom)) {
                String option = attribution.split("Option attribuée: ")[1];
                System.out.println("Option attribuée pour l'étudiant " + nom + " (ID: " + idEtudiant + "): " + option);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Aucune option attribuée trouvée pour l'étudiant " + nom + " (ID: " + idEtudiant + ").");
        }
    }

    
   
}