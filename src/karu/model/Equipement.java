package karu.model;

import karu.model.ressources.stats.Stat;

import java.util.ArrayList;

public class Equipement {

     private String nom;
     private String type; //chapeau , bottes .... etc
     private int niveau;
     private String panoplie;
     private ArrayList<Stat> listStats;
     private int score; // addition de toutes les stats multipliées par le taux de rune associé

    public Equipement(){

    }

    public String getNom() {
        return nom;
    }

    public String getType() {
        return type;
    }

    public int getNiveau() {
        return niveau;
    }

    public String getPanoplie() {
        return panoplie;
    }

    public ArrayList<Stat> getListStats() {
        return listStats;
    }

    public int getScore() {
        return score;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public void setPanoplie(String panoplie) {
        this.panoplie = panoplie;
    }

    public void setListStats(ArrayList<Stat> listStats) {
        this.listStats = listStats;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
