package karu.model.ressources.stats;

import karu.util.Constants;

public class RePerNeutre extends Stat {

    private double poidsUnite;
    private double poidsTotal;

    public RePerNeutre(int nb){
        super(nb);
        poidsUnite = Constants.POIDS_RE_PER_NEUTRE;
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
