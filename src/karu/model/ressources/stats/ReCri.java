package karu.model.ressources.stats;

import karu.util.Constants;

public class ReCri extends Stat {

    private double poidsUnite;
    private double poidsTotal;

    public ReCri(int nb){
        super(nb);
        poidsUnite = Constants.POIDS_RE_CRI;
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
