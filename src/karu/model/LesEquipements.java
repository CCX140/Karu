package karu.model;

import karu.model.ressources.stats.*;
import karu.util.Constants;

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
        System.out.println(s);
        System.out.println(split[0]);
        if(!s.contains("-")) {
            if (s.contains("Agilité")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_AGILITE));
            } else if (s.contains("Chance")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_CHANCE));
            } else if (s.contains("% Critique")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_CRI));
            } else if (s.contains("Dommages Air")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_DO_AIR));
            } else if (s.contains("Dommages Eau")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_DO_EAU));
            } else if (s.contains("Dommages Critique")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_DO_CRI));
            } else if (s.contains("Dommages Feu")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_DO_FEU));
            } else if (s.contains("Dommages Neutre")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_DO_NEUTRE));
            } else if (s.contains("% Dmg Mêlée")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_DO_PER_ME));
            } else if (s.contains("% Dmg aux Sorts")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_DO_PER_SO));
            } else if (s.contains("% Dmg Distance")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_DO_PER_DI));
            } else if (s.contains("% Dmg d'Armes")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_DO_PER_AR));
            } else if (s.contains("Dommages Piège")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_DO_PI));
            } else if (s.contains("Dommages Poussée")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_DO_POU));
            } else if (s.contains("Renvoi")) { // si c'est du renvoi de dommages, le nombre de stats est en deuxieme position
                e.addStat(new StatTest(Integer.parseInt(split[1]), POIDS_DO_REN));
            } else if (s.contains("Dommages Terre")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_DO_TERRE));
            } else if (s.contains("Force")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_FORCE));
            } else if (s.contains("Fuite")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_FUI));
            } else if (s.contains("Intelligence")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_INTELLIGENCE));
            } else if (s.contains("Invocation")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_INVO));
            } else if (s.contains("PO")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_PO));
            } else if (s.contains("Pods")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_POD));
            } else if (s.contains("Prospection")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_PROSPE));
            } else if (s.contains("Puissance Piège")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_PUI_PI));
            } else if (s.contains("Puissance")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_PUI));
            } else if (s.contains("Rés. Critique")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_RE_CRI));
            } else if (s.contains("Esquive PA")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_RE_PA));
            } else if (s.contains("Esquive PM")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_RE_PM));
            } else if (s.contains("Rés. Poussée")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_RE_POU));
            } else if (s.contains("% Rés. Feu")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_RE_PER_FEU));
            } else if (s.contains("% Rés. Air")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_RE_PER_AIR));
            } else if (s.contains("% Rés. Eau")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_RE_PER_EAU));
            } else if (s.contains("% Rés. Terre")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_RE_PER_TERRE));
            } else if (s.contains("% Rés. Neutre")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_RE_PER_NEUTRE));
            } else if (s.contains("Rés. Distance")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_RE_PER_DI));
            } else if (s.contains("Rés. Mêlée")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_RE_PER_ME));
            } else if (s.contains("Retrait PM")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_RET_PM));
            } else if (s.contains("Retrait PA")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_RET_PA));
            } else if (s.contains("Sagesse")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_SAGESSE));
            } else if (s.contains("Rés. Feu")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_RE_FEU));
            } else if (s.contains("Rés. Eau")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_RE_EAU));
            } else if (s.contains("Rés. Terre")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_RE_TERRE));
            } else if (s.contains("Rés. Neutre")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_RE_NEUTRE));
            } else if (s.contains("Rés. Air")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_RE_AIR));
            } else if (s.contains("Soin")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_SO));
            } else if (s.contains("Tacle")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_TAC));
            } else if (s.contains("Vitalité")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_VITALITE));
            } else if (s.contains("Initiative")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_INI));
            }else if (s.contains("Dommages")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_DO));
            }else if (s.contains("PA")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_PA));
            } else if (s.contains("PM")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_PM));
            }

            else {
                System.out.println("\nErreur stat inconnue " + e.getNom());
            }
        }
    }

    public int size(){
        return listEquipements.size();
    }

    public void trierParTaux(){
        Collections.sort(listEquipements, (o1, o2) -> (int) (o1.getScore() - o2.getScore()));
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
