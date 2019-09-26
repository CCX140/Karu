package karu.model.ressources.stats;

import karu.util.Constants;

public class StatTest implements Stat {

    private double poidsUnite;
    private double poidsTotal;
    private int nb;

    public StatTest(int nb,double poidsUnite){
        this.nb = nb;
        this.poidsUnite = poidsUnite;
        this.poidsTotal = poidsUnite * nb;
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

    @Override
    public String toString() {
        return "StatTest{" +
                "poidsUnite=" + poidsUnite +
                ", poidsTotal=" + poidsTotal +
                ", nb=" + nb +
                '}';
    }
}
