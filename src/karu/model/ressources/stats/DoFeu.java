package karu.model.ressources.stats;

import karu.util.Constants;

public class DoFeu implements Stat {

    private double poidsUnite;
    private double poidsTotal;
    private int nb;

    public DoFeu(int nb){
        this.nb = nb;
        poidsUnite = Constants.POIDS_DO_FEU;
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
