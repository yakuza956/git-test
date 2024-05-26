public abstract class Utilisateur {
    public String nom;
    public String prenom;
    
    public Utilisateur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }
        public String getNom() {
        return nom;
    }
        public String getPrenom() {
        return prenom;
    }
}
