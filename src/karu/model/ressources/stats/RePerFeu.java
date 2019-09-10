package karu.model.ressources.stats;

import karu.util.Constants;

public class RePerFeu extends Stat {

    private double poidsUnite;
    private double poidsTotal;

    public RePerFeu(int nb){
        super(nb);
        poidsUnite = Constants.POIDS_RE_PER_FEU;
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
