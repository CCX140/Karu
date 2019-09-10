package karu.model;

import karu.model.ressources.stats.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static karu.util.Constants.*;

public class LesEquipements {

    private ArrayList<Equipement> listEquipements;

    public LesEquipements(){
        listEquipements = new ArrayList<>();
    }

    public void create(){
        try
        {
            InputStream flux = getClass().getResourceAsStream("/karu/model/ressources/data.txt");
            InputStreamReader lecture = new InputStreamReader(flux);
            BufferedReader buff = new BufferedReader(lecture);

            Equipement e = new Equipement();
            int id = 0;
            String line;

            while((line=buff.readLine())!=null){
                //déplace le curseur a la ligne de nom
                while((line=buff.readLine()) == ""){

                }
                //nom
                addNom(e,line);

                line = buff.readLine();
                //si l'item fait partie d'une panoplie on saute la ligne
                if (line.contains("Panoplie")){
                    line = buff.readLine();
                }

                //type et niveau
                addNiveau(e,line);
                addType(e,line);

                //saute les lignes vide jusqu'aux stats de l'item
                while((line=buff.readLine()) == ""){

                }



                listEquipements.add(e);
                id++;
            }

        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }

    public void addNom(Equipement e,String s){
        e.setNom(s);
    }

    public void addNiveau(Equipement e,String s){
        int lvl = -1;
        String sub = s.substring(s.length()-3);
        sub.replaceAll(" ", "0");
        sub.replaceAll("u", "0");
        lvl = Integer.parseInt(sub);
        e.setNiveau(lvl);
        if (lvl == -1){
            System.out.println("\nErreur Niveau Inconnu"+e.getNom());
        }
    }

    public void addType(Equipement e,String s){
        String[] split = s.split(" ");
        String type = split[0];

        if(type == "Anneau"){
            e.setType(ANNEAU);
        }else if(type == "Amulette"){
            e.setType(AMULETTE);
        }else if(type == "Chapeau"){
            e.setType(CHAPEAU);
        }else if(type == "Bottes"){
            e.setType(BOTTES);
        }else if(type == "Bouclier"){
            e.setType(BOUCLIER);
        }else if(type == "Cape"){
            e.setType(CAPE);
        }else if(type == "Ceinture"){
            e.setType(CEINTURE);
        }else if(type == "Sac"){
            e.setType(SAC);
        }else if(type == "Arc"){
            e.setType(ARC);
        }else if(type == "Baguette"){
            e.setType(BAGUETTE);
        }else if(type == "Bâton"){
            e.setType(BATON);
        }else if(type == "Dagues"){
            e.setType(DAGUE);
        }else if(type == "Épée"){
            e.setType(EPEE);
        }else if(type == "Faux"){
            e.setType(FAUX);
        }else if(type == "Marteau"){
            e.setType(MARTEAU);
        }else if(type == "Hache"){
            e.setType(HACHE);
        }else if(type == "Pelle"){
            e.setType(PELLE);
        }else if(type == "Pioche"){
            e.setType(PIOCHE);
        }else{
            System.out.println("\nErreur type inconnu"+e.getNom());
        }

    }

    public void addStat(Equipement e, String s){
        String[] split = s.split(" ");
        int nb = Integer.parseInt(split[0]);

        if( s.contains("Agilité")){
            e.addStat(new Agilite(nb));
        }else if( s.contains("Chance")){
            e.addStat(new Chance(nb));
        }else if( s.contains("% Critique")){
            e.addStat(new Cri(nb));
        }else if( s.contains("Dommages")){
            e.addStat(new Do(nb));
        }else if( s.contains("Dommages air")){
            e.addStat(new DoAir(nb));
        }else if( s.contains("Dommages eau")){
            e.addStat(new DoEau(nb));
        }else if( s.contains("Dommages Critique")){
            e.addStat(new DoCri(nb));
        }else if( s.contains("Dommages Feu")){
            e.addStat(new DoFeu(nb));
        }else if( s.contains("Dommages Neutre")){
            e.addStat(new DoNeutre(nb));
        }else if( s.contains("% Dmg Mêlée")){
            e.addStat(new DoPerMe(nb));
        }else if( s.contains("% Dmg aux Sorts")){
            e.addStat(new DoPerSo(nb));
        }else if( s.contains("% Dmg Distance")){
            e.addStat(new DoPerDi(nb));
        }else if( s.contains("% Dmg d'Armes")){
            e.addStat(new DoPerAr(nb));
        }else if( s.contains("Dommages Piège")){
            e.addStat(new DoPi(nb));
        }else if( s.contains("Dommages Poussée")){
            e.addStat(new DoPou(nb));
        }else if( s.contains("Renvoi")){ // si c'est du renvoie de dommage le nombre de stats est en deuxieme position
            e.addStat(new DoRen(Integer.parseInt(split[1])));
        }else if( s.contains("Dommages Terre")){
            e.addStat(new DoTerre(nb));
        }else if( s.contains("Force")){
            e.addStat(new Force(nb));
        }else if( s.contains("Fuite")){
            e.addStat(new Fuite(nb));
        }else if( s.contains("Intelligence")){
            e.addStat(new Intelligence(nb));
        }else if( s.contains("Invocation")){
            e.addStat(new Invo(nb));
        }else if( s.contains("PA")){
            e.addStat(new Pa(nb));
        }else if( s.contains("PM")){
            e.addStat(new Pm(nb));
        }else if( s.contains("PO")){
            e.addStat(new Po(nb));
        }else if( s.contains("Pods")){
            e.addStat(new Pod(nb));
        }else if( s.contains("Prospection")){
            e.addStat(new Prospe(nb));
        }else if( s.contains("Puissance Piège")){
            e.addStat(new PuiPi(nb));
        }else if( s.contains("Puissance")){
            e.addStat(new Puissance(nb));
        }else if( s.contains("Rés. Feu")){
            e.addStat(new ReFeu(nb));
        }else if( s.contains("Rés. Eau")){
            e.addStat(new ReEau(nb));
        }else if( s.contains("Rés. Terre")){
            e.addStat(new ReTerre(nb));
        }else if( s.contains("Rés. Neutre")){
            e.addStat(new ReNeutre(nb));
        }else if( s.contains("Rés. Air")){
            e.addStat(new ReAir(nb));
        }else if( s.contains("Rés. Critique")){
            e.addStat(new ReCri(nb));
        }else if( s.contains("Esquive PA")){
            e.addStat(new RePa(nb));
        }else if( s.contains("Esquive PM")){
            e.addStat(new RePm(nb));
        }else if( s.contains("Rés. Poussée")){
            e.addStat(new RePou(nb));
        }else if( s.contains("% Rés. Feu")){
            e.addStat(new RePerFeu(nb));
        }else if( s.contains("% Rés. Air")){
            e.addStat(new RePerAir(nb));
        }else if( s.contains("% Rés. Eau")){
            e.addStat(new RePerEau(nb));
        }else if( s.contains("% Rés. Terre")){
            e.addStat(new RePerTerre(nb));
        }else if( s.contains("% Rés. Neutre")){
            e.addStat(new RePerNeutre(nb));
        }else if( s.contains("Rés. Distance")){
            e.addStat(new RePerDi(nb));
        }else if( s.contains("Rés. Mêlée")){
            e.addStat(new RePerMe(nb));
        }else if( s.contains("Retrait PM")){
            e.addStat(new RetPm(nb));
        }else if( s.contains("Retrait PA")){
            e.addStat(new RetPa(nb));
        }else if( s.contains("Sagesse")){
            e.addStat(new Sagesse(nb));
        }else if( s.contains("Soin")){
            e.addStat(new So(nb));
        }else if( s.contains("Tacle")){
            e.addStat(new Tacle(nb));
        }else if( s.contains("Vitalité")){
            e.addStat(new Vitalite(nb));
        }else {
            System.out.println("\nErreur stat inconnue"+e.getNom());
        }
    }
}
