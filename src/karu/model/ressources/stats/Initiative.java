package karu.model.ressources.stats;

import karu.util.Constants;

public class Initiative implements Stat {

    private double poidsUnite;
    private double poidsTotal;
    private int nb;

    public Initiative(int nb){
        this.nb = nb;
        poidsUnite = Constants.POIDS_INI;
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
