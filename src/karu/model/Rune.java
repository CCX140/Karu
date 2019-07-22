package karu.model;

public class Rune {

    private int id;
    private String nom;
    private double taux;
    private int prix;
    private int poids;


    public Rune(int id, int poids, String nom) {
        this.poids = poids;
        this.id = id;
        this.prix = -1;
        this.taux = -1;
        this.nom = nom;
    }


    public void setTaux(double taux) {
        this.taux = taux;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    public double getTaux() {
        return taux;
    }

    public int getPrix() {
        return prix;
    }

    public int getPoids() {
        return poids;
    }

    public void calcuTaux(){
        if (prix != -1){
            taux = prix / poids;
        }
    }

    @Override
    public String toString() {
        return "Rune{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", poids=" + poids +
                ", taux=" + taux +
                ", prix=" + prix +
                '}'+ '\n';
    }
}
