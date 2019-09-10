package karu.model.ressources.stats;

import karu.util.Constants;

public class Vitalite extends Stat {

    private double poidsUnite;
    private double poidsTotal;

    public Vitalite(int nb){
        super(nb);
        poidsUnite = Constants.POIDS_VITALITE;
        poidsTotal = poidsUnite * nb;
    }

    public double getPoidsUnite() {
        return poidsUnite;
    }

    public double getPoidsTotal() {
        return poidsTotal;
    }

    public void setPoidsUnite(int poidsUnite) {
        this.poidsUnite = poidsUnite;
    }

    public void setPoidsTotal(int poidsTotal) {
        this.poidsTotal = poidsTotal;
    }
}
