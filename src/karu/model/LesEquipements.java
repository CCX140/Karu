package karu.model;

import karu.model.ressources.stats.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static karu.util.Constants.*;

public class LesEquipements {

    private ArrayList<Equipement> listEquipements;

    public LesEquipements(){
        listEquipements = new ArrayList<>();
        create();
    }

    public void create(){
        try
        {
            InputStream flux = getClass().getResourceAsStream("/karu/model/ressources/data.txt");
            InputStreamReader lecture = new InputStreamReader(flux);
            BufferedReader buff = new BufferedReader(lecture);

            int id = 0;
            String line;

            //déplace le curseur a la ligne de nom
            do{
                line=buff.readLine();
            }while((line.isEmpty()));

            //lis les équipements un par un
            while((line!=null)){
                Equipement e = new Equipement();

                //nom
                addNom(e,line);

                line = buff.readLine();

                //si l'item fait partie d'une panoplie on saute la ligne
                if (line.contains("Panopl")||line.contains("plie")){
                    line = buff.readLine();

                }

                //type et niveau
                addType(e,line);
                addNiveau(e,line);


                //déplace le curseur aux stats
                do{
                    line=buff.readLine();

                }while((line.isEmpty()));

                while(!(line.isEmpty())){

                    addStat(e,line);
                    line=buff.readLine();
                }

                e.calculScore();
                listEquipements.add(e);

                id++;

                //déplace le curseur a la ligne du prochain equipement
                do{
                    line=buff.readLine();
                    if (line == null){ //si on est a la fin du data.txt
                        break;
                    }
                }while((line.isEmpty()));
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
        String[] split = s.split(" ");
        lvl = Integer.parseInt(split[split.length-1]);
        e.setNiveau(lvl);
        if (lvl == -1){
            System.out.println("\nErreur Niveau Inconnu "+e.getNom());
        }
    }

    public void addType(Equipement e,String s){
        if(s.contains("Anneau")){
            e.setType(ANNEAU);
        }else if(s.contains("Amulette")){
            e.setType(AMULETTE);
        }else if(s.contains("Chapeau")){
            e.setType(CHAPEAU);
        }else if(s.contains("Bottes")){
            e.setType(BOTTES);
        }else if(s.contains("Bouclier")){
            e.setType(BOUCLIER);
        }else if(s.contains("Cape")){
            e.setType(CAPE);
        }else if(s.contains("Ceinture")){
            e.setType(CEINTURE);
        }else if(s.contains("Sac")){
            e.setType(SAC);
        }else if(s.contains("Arc")){
            e.setType(ARC);
        }else if(s.contains("Baguette")){
            e.setType(BAGUETTE);
        }else if(s.contains("Bâton")){
            e.setType(BATON);
        }else if(s.contains("Dagues")){
            e.setType(DAGUE);
        }else if(s.contains("Épée")){
            e.setType(EPEE);
        }else if(s.contains("Faux")){
            e.setType(FAUX);
        }else if(s.contains("Marteau")){
            e.setType(MARTEAU);
        }else if(s.contains("Hache")){
            e.setType(HACHE);
        }else if(s.contains("Pelle")){
            e.setType(PELLE);
        }else if(s.contains("Pioche")){
            e.setType(PIOCHE);
        }else{
            System.out.println("\nErreur type inconnu "+e.getNom());
        }

    }

    public void addStat(Equipement e, String s){
        String[] split = s.split(" ");

        if(!s.contains("-")) {
            if (s.contains("Agilité")) {
                e.addStat(new Agilite(Integer.parseInt(split[0])));
            } else if (s.contains("Chance")) {
                e.addStat(new Chance(Integer.parseInt(split[0])));
            } else if (s.contains("% Critique")) {
                e.addStat(new Cri(Integer.parseInt(split[0])));
            } else if (s.contains("Dommages")) {
                e.addStat(new Do(Integer.parseInt(split[0])));
            } else if (s.contains("Dommages air")) {
                e.addStat(new DoAir(Integer.parseInt(split[0])));
            } else if (s.contains("Dommages eau")) {
                e.addStat(new DoEau(Integer.parseInt(split[0])));
            } else if (s.contains("Dommages Critique")) {
                e.addStat(new DoCri(Integer.parseInt(split[0])));
            } else if (s.contains("Dommages Feu")) {
                e.addStat(new DoFeu(Integer.parseInt(split[0])));
            } else if (s.contains("Dommages Neutre")) {
                e.addStat(new DoNeutre(Integer.parseInt(split[0])));
            } else if (s.contains("% Dmg Mêlée")) {
                e.addStat(new DoPerMe(Integer.parseInt(split[0])));
            } else if (s.contains("% Dmg aux Sorts")) {
                e.addStat(new DoPerSo(Integer.parseInt(split[0])));
            } else if (s.contains("% Dmg Distance")) {
                e.addStat(new DoPerDi(Integer.parseInt(split[0])));
            } else if (s.contains("% Dmg d'Armes")) {
                e.addStat(new DoPerAr(Integer.parseInt(split[0])));
            } else if (s.contains("Dommages Piège")) {
                e.addStat(new DoPi(Integer.parseInt(split[0])));
            } else if (s.contains("Dommages Poussée")) {
                e.addStat(new DoPou(Integer.parseInt(split[0])));
            } else if (s.contains("Renvoi")) { // si c'est du renvoi de dommages, le nombre de stats est en deuxieme position
                e.addStat(new DoRen(Integer.parseInt(split[1])));
            } else if (s.contains("Dommages Terre")) {
                e.addStat(new DoTerre(Integer.parseInt(split[0])));
            } else if (s.contains("Force")) {
                e.addStat(new Force(Integer.parseInt(split[0])));
            } else if (s.contains("Fuite")) {
                e.addStat(new Fuite(Integer.parseInt(split[0])));
            } else if (s.contains("Intelligence")) {
                e.addStat(new Intelligence(Integer.parseInt(split[0])));
            } else if (s.contains("Invocation")) {
                e.addStat(new Invo(Integer.parseInt(split[0])));
            } else if (s.contains("PA")) {
                e.addStat(new Pa(Integer.parseInt(split[0])));
            } else if (s.contains("PM")) {
                e.addStat(new Pm(Integer.parseInt(split[0])));
            } else if (s.contains("PO")) {
                e.addStat(new Po(Integer.parseInt(split[0])));
            } else if (s.contains("Pods")) {
                e.addStat(new Pod(Integer.parseInt(split[0])));
            } else if (s.contains("Prospection")) {
                e.addStat(new Prospe(Integer.parseInt(split[0])));
            } else if (s.contains("Puissance Piège")) {
                e.addStat(new PuiPi(Integer.parseInt(split[0])));
            } else if (s.contains("Puissance")) {
                e.addStat(new Puissance(Integer.parseInt(split[0])));
            } else if (s.contains("Rés. Feu")) {
                e.addStat(new ReFeu(Integer.parseInt(split[0])));
            } else if (s.contains("Rés. Eau")) {
                e.addStat(new ReEau(Integer.parseInt(split[0])));
            } else if (s.contains("Rés. Terre")) {
                e.addStat(new ReTerre(Integer.parseInt(split[0])));
            } else if (s.contains("Rés. Neutre")) {
                e.addStat(new ReNeutre(Integer.parseInt(split[0])));
            } else if (s.contains("Rés. Air")) {
                e.addStat(new ReAir(Integer.parseInt(split[0])));
            } else if (s.contains("Rés. Critique")) {
                e.addStat(new ReCri(Integer.parseInt(split[0])));
            } else if (s.contains("Esquive PA")) {
                e.addStat(new RePa(Integer.parseInt(split[0])));
            } else if (s.contains("Esquive PM")) {
                e.addStat(new RePm(Integer.parseInt(split[0])));
            } else if (s.contains("Rés. Poussée")) {
                e.addStat(new RePou(Integer.parseInt(split[0])));
            } else if (s.contains("% Rés. Feu")) {
                e.addStat(new RePerFeu(Integer.parseInt(split[0])));
            } else if (s.contains("% Rés. Air")) {
                e.addStat(new RePerAir(Integer.parseInt(split[0])));
            } else if (s.contains("% Rés. Eau")) {
                e.addStat(new RePerEau(Integer.parseInt(split[0])));
            } else if (s.contains("% Rés. Terre")) {
                e.addStat(new RePerTerre(Integer.parseInt(split[0])));
            } else if (s.contains("% Rés. Neutre")) {
                e.addStat(new RePerNeutre(Integer.parseInt(split[0])));
            } else if (s.contains("Rés. Distance")) {
                e.addStat(new RePerDi(Integer.parseInt(split[0])));
            } else if (s.contains("Rés. Mêlée")) {
                e.addStat(new RePerMe(Integer.parseInt(split[0])));
            } else if (s.contains("Retrait PM")) {
                e.addStat(new RetPm(Integer.parseInt(split[0])));
            } else if (s.contains("Retrait PA")) {
                e.addStat(new RetPa(Integer.parseInt(split[0])));
            } else if (s.contains("Sagesse")) {
                e.addStat(new Sagesse(Integer.parseInt(split[0])));
            } else if (s.contains("Soin")) {
                e.addStat(new So(Integer.parseInt(split[0])));
            } else if (s.contains("Tacle")) {
                e.addStat(new Tacle(Integer.parseInt(split[0])));
            } else if (s.contains("Vitalité")) {
                e.addStat(new Vitalite(Integer.parseInt(split[0])));
            } else if (s.contains("Initiative")) {
                e.addStat(new Initiative(Integer.parseInt(split[0])));
            } else {
                System.out.println("\nErreur stat inconnue " + e.getNom());
            }
        }
    }

    public int size(){
        return listEquipements.size();
    }

    public void trierParTaux(){
        Collections.sort(listEquipements, (o1, o2) -> (int) o1.getScore() - o2.getScore());
    }

    public void trierParNiveaux(){
        Collections.sort(listEquipements, (o1, o2) -> (int) o1.getNiveau() - o2.getNiveau());
    }

    public ArrayList<Equipement> getListEquipements() {
        return listEquipements;
    }

    @Override
    public String toString() {
        return "LesEquipements{" +
                "listEquipements=" + listEquipements +
                '}';
    }
}
