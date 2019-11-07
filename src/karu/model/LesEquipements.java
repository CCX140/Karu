package karu.model;

import karu.model.ressources.stats.StatTest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

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
        }else if(s.contains("Baton")){
            e.setType(BATON);
        }else if(s.contains("Dagues")){
            e.setType(DAGUE);
        }else if(s.contains("Epee")){
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
            if (s.contains("Agilite")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_AGILITE));
                e.addStatString("Agilite");
            } else if (s.contains("Chance")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_CHANCE));
                e.addStatString("Chance");
            } else if (s.contains("% Critique")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_CRI));
                e.addStatString("% Critique");
            } else if (s.contains("Dommages Air")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_DO_AIR));
                e.addStatString("Dommages Air");
            } else if (s.contains("Dommages Eau")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_DO_EAU));
                e.addStatString("Dommages Eau");
            } else if (s.contains("Dommages Critique")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_DO_CRI));
                e.addStatString("Dommages Critique");
            } else if (s.contains("Dommages Feu")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_DO_FEU));
                e.addStatString("Dommages Feu");
            } else if (s.contains("Dommages Neutre")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_DO_NEUTRE));
                e.addStatString("Dommages Neutre");
            } else if (s.contains("% Dmg Melee")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_DO_PER_ME));
                e.addStatString("% Dmg Melee");
            } else if (s.contains("% Dmg aux Sorts")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_DO_PER_SO));
                e.addStatString("% Dmg aux Sorts");
            } else if (s.contains("% Dmg Distance")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_DO_PER_DI));
                e.addStatString("% Dmg Distance");
            } else if (s.contains("% Dmg d'Armes")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_DO_PER_AR));
                e.addStatString("% Dmg d'Armes");
            } else if (s.contains("Dommages Piege")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_DO_PI));
                e.addStatString("Dommages Piege");
            } else if (s.contains("Dommages Poussee")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_DO_POU));
                e.addStatString("Dommages Poussee");
            } else if (s.contains("Renvoi")) { // si c'est du renvoi de dommages, le nombre de stats est en deuxieme position
                e.addStat(new StatTest(Integer.parseInt(split[1]), POIDS_DO_REN));
                e.addStatString("Renvoi");
            } else if (s.contains("Dommages Terre")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_DO_TERRE));
                e.addStatString("Dommages Terre");
            } else if (s.contains("Force")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_FORCE));
                e.addStatString("Force");
            } else if (s.contains("Fuite")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_FUI));
                e.addStatString("Fuite");
            } else if (s.contains("Intelligence")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_INTELLIGENCE));
                e.addStatString("Intelligence");
            } else if (s.contains("Invocation")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_INVO));
                e.addStatString("Invocation");
            } else if (s.contains("PO")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_PO));
                e.addStatString("PO");
            } else if (s.contains("Pods")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_POD));
                e.addStatString("Pods");
            } else if (s.contains("Prospection")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_PROSPE));
                e.addStatString("Prospection");
            } else if (s.contains("Puissance Piege")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_PUI_PI));
                e.addStatString("Puissance Piege");
            } else if (s.contains("Puissance")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_PUI));
                e.addStatString("Puissance");
            } else if (s.contains("Res. Critique")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_RE_CRI));
                e.addStatString("Res. Critique");
            } else if (s.contains("Esquive PA")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_RE_PA));
                e.addStatString("Esquive PA");
            } else if (s.contains("Esquive PM")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_RE_PM));
                e.addStatString("Esquive PM");
            } else if (s.contains("Res. Poussee")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_RE_POU));
                e.addStatString("Res. Poussee");
            } else if (s.contains("% Res. Feu")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_RE_PER_FEU));
                e.addStatString("% Res. Feu");
            } else if (s.contains("% Res. Air")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_RE_PER_AIR));
                e.addStatString("% Res. Air");
            } else if (s.contains("% Res. Eau")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_RE_PER_EAU));
                e.addStatString("% Res. Eau");
            } else if (s.contains("% Res. Terre")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_RE_PER_TERRE));
                e.addStatString("% Res. Terre");
            } else if (s.contains("% Res. Neutre")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_RE_PER_NEUTRE));
                e.addStatString("% Res. Neutre");
            } else if (s.contains("Res. Distance")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_RE_PER_DI));
                e.addStatString("Res. Distance");
            } else if (s.contains("Res. Melee")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_RE_PER_ME));
                e.addStatString("Res. Melee");
            } else if (s.contains("Retrait PM")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_RET_PM));
                e.addStatString("Retrait PM");
            } else if (s.contains("Retrait PA")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_RET_PA));
                e.addStatString("Retrait PA");
            } else if (s.contains("Sagesse")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_SAGESSE));
                e.addStatString("Sagesse");
            } else if (s.contains("Res. Feu")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_RE_FEU));
                e.addStatString("Res. Feu");
            } else if (s.contains("Res. Eau")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_RE_EAU));
                e.addStatString("Res. Eau");
            } else if (s.contains("Res. Terre")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_RE_TERRE));
                e.addStatString("Res. Terre");
            } else if (s.contains("Res. Neutre")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_RE_NEUTRE));
                e.addStatString("Res. Neutre");
            } else if (s.contains("Res. Air")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_RE_AIR));
                e.addStatString("Res. Air");
            } else if (s.contains("Soin")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_SO));
                e.addStatString("Soin");
            } else if (s.contains("Tacle")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_TAC));
                e.addStatString("Tacle");
            } else if (s.contains("Vitalite")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_VITALITE));
                e.addStatString("Vitalite");
            } else if (s.contains("Initiative")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_INI));
                e.addStatString("Initiative");
            }else if (s.contains("Dommages")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_DO));
                e.addStatString("Dommages");
            }else if (s.contains("PA")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_PA));
                e.addStatString("PA");
            } else if (s.contains("PM")) {
                e.addStat(new StatTest(Integer.parseInt(split[0]), POIDS_PM));
                e.addStatString("PM");
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
        Collections.sort(listEquipements, (o1, o2) -> (int) (o2.getScore() - o1.getScore()));
    }

    public void trierParNiveaux(){
        Collections.sort(listEquipements, (o1, o2) -> (int) o2.getNiveau() - o1.getNiveau());
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
