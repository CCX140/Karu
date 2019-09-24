package karu.model.ressources.stats;

import karu.util.Constants;

public class RePerDi implements Stat {

    private double poidsUnite;
    public double poidsTotal;
    private int nb;

    public RePerDi(int nb){
        this.nb = nb;
        poidsUnite = Constants.POIDS_RE_PER_DI;
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
