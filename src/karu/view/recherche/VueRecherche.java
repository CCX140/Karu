package karu.view.recherche;

import karu.model.LesEquipements;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static karu.util.Constants.*;


public class VueRecherche extends JPanel {

    private LesEquipements model;
    private JRadioButton score;
    private JRadioButton niveau;
    private JPanel groupeBouttons;
    private JTextField barreRecherche;
    private JComboBox menuRunes;
    private String currentStat;
    private VueResultat vueResultat;
    

    public VueRecherche(LesEquipements lesEquipements){
        super();
        model = lesEquipements;
        TitledBorder title;
        title = BorderFactory.createTitledBorder("Recherche");
        title.setTitleColor(new Color(WHITE_GRAY,WHITE_GRAY,WHITE_GRAY));
        this.setBorder(title);
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setBackground(new Color(R_DARK_GRAY,G_DARK_GRAY,B_DARK_GRAY));

        vueResultat = new VueResultat(model);

        score = new JRadioButton("score");
        score.setForeground(Color.white);
        score.setBackground(new Color(R_GRAY,G_GRAY,B_GRAY));
        score.addActionListener(e -> updateOrdreScore());
        niveau = new JRadioButton("niveau");
        niveau.setForeground(Color.white);
        niveau.setBackground(new Color(R_GRAY,G_GRAY,B_GRAY));
        niveau.addActionListener(e -> updateOrdreNiveau());
        
        groupeBouttons = new JPanel();
        groupeBouttons.add(score);
        groupeBouttons.add(niveau);
        TitledBorder triBorder;
        triBorder = BorderFactory.createTitledBorder("Trier par :");
        triBorder.setTitleColor(new Color(WHITE_GRAY,WHITE_GRAY,WHITE_GRAY));
        groupeBouttons.setBackground(new Color(R_GRAY,G_GRAY,B_GRAY));
        groupeBouttons.setBorder(triBorder);
        groupeBouttons.setLayout(new FlowLayout(FlowLayout.LEFT));
        groupeBouttons.setBackground(new Color(R_GRAY,G_GRAY,B_GRAY));


        barreRecherche = new JTextField();
        barreRecherche.setBackground(new Color(R_LIGHT_GRAY,G_LIGHT_GRAY,B_LIGHT_GRAY));
        barreRecherche.setForeground(Color.white);
        barreRecherche.setCaretColor(Color.white);
        barreRecherche.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        barreRecherche.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                vueResultat.updateRecherche(barreRecherche.getText(),currentStat);
            }
        });
        barreRecherche.setHorizontalAlignment(JTextField.LEFT);
        barreRecherche.setPreferredSize(new Dimension(200,25));

        JPanel panelRecherche = new JPanel();
        panelRecherche.add(groupeBouttons);
        panelRecherche.add(barreRecherche);
        panelRecherche.setBackground(new Color(R_GRAY,G_GRAY,B_GRAY));

        menuRunes = new JComboBox();
        initMenus();
        menuRunes.setBackground(new Color(R_GRAY,G_GRAY,B_GRAY));
        menuRunes.setForeground(new Color(WHITE_GRAY,WHITE_GRAY,WHITE_GRAY));
        menuRunes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentStat = (String)menuRunes.getSelectedItem();
                vueResultat.updateRecherche(barreRecherche.getText(),currentStat);
            }
        });

        JLabel stat = new JLabel("Stat :");
        stat.setForeground(new Color(WHITE_GRAY,WHITE_GRAY,WHITE_GRAY));
        panelRecherche.add(stat);
        panelRecherche.add(menuRunes);

        this.add(panelRecherche);
        this.add(new JScrollPane(vueResultat));

    }

    public void initMenus(){
        menuRunes.addItem("(aucune)");
        menuRunes.addItem("Agilite");
        menuRunes.addItem("Chance");
        menuRunes.addItem("Force");
        menuRunes.addItem("Intelligence");
        menuRunes.addItem("Vitalite");
        menuRunes.addItem("Initiative");
        menuRunes.addItem("Sagesse");
        menuRunes.addItem("% Critique");
        menuRunes.addItem("Dommages");
        menuRunes.addItem("Dommages Air");
        menuRunes.addItem("Dommages Eau");
        menuRunes.addItem("Dommages Feu");
        menuRunes.addItem("Dommages Neutre");
        menuRunes.addItem("Dommages Terre");
        menuRunes.addItem("Dommages Critique");
        menuRunes.addItem("% Dmg Melee");
        menuRunes.addItem("% Dmg aux Sorts");
        menuRunes.addItem("% Dmg Distance");
        menuRunes.addItem("% Dmg d'Armes");
        menuRunes.addItem("Dommages Piege");
        menuRunes.addItem("Dommages Poussee");
        menuRunes.addItem("Renvoi");
        menuRunes.addItem("Fuite");
        menuRunes.addItem("Tacle");
        menuRunes.addItem("Pods");
        menuRunes.addItem("Prospection");
        menuRunes.addItem("Puissance Piege");
        menuRunes.addItem("Puissance");
        menuRunes.addItem("Res. Critique");
        menuRunes.addItem("Res. Poussee");
        menuRunes.addItem("% Res. Feu");
        menuRunes.addItem("% Res. Air");
        menuRunes.addItem("% Res. Eau");
        menuRunes.addItem("% Res. Terre");
        menuRunes.addItem("% Res. Neutre");
        menuRunes.addItem("Res. Feu");
        menuRunes.addItem("Res. Eau");
        menuRunes.addItem("Res. Terre");
        menuRunes.addItem("Res. Neutre");
        menuRunes.addItem("Res. Air");
        menuRunes.addItem("Res. Distance");
        menuRunes.addItem("Res. Melee");
        menuRunes.addItem("Esquive PA");
        menuRunes.addItem("Esquive PM");
        menuRunes.addItem("Retrait PM");
        menuRunes.addItem("Retrait PA");
        menuRunes.addItem("Soin");
        menuRunes.addItem("Invocation");
        menuRunes.addItem("PO");
        menuRunes.addItem("PM");
        menuRunes.addItem("PA");
    }

    public void updateOrdreScore(){
        if (score.isSelected()){
            niveau.setSelected(false);
            model.trierParTaux();
            vueResultat.updateRecherche(barreRecherche.getText(),currentStat);
        }
    }

    public void updateOrdreNiveau(){
        if(niveau.isSelected()) {
            score.setSelected(false);
            model.trierParNiveaux();
            vueResultat.updateRecherche(barreRecherche.getText(),currentStat);
        }
    }


}
