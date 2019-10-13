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
    private JComboBox menuType;
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
                vueResultat.updateRecherche(barreRecherche.getText());
            }
        });
        barreRecherche.setHorizontalAlignment(JTextField.LEFT);
        barreRecherche.setPreferredSize(new Dimension(200,25));

        JPanel panelRecherche = new JPanel();
        panelRecherche.add(groupeBouttons);
        panelRecherche.add(barreRecherche);
        panelRecherche.setBackground(new Color(R_GRAY,G_GRAY,B_GRAY));

        menuRunes = new JComboBox();
        menuType = new JComboBox();

        /*initMenus();
        panelRecherche.add(new Label("Stat :"));
        panelRecherche.add(menuRunes);
        panelRecherche.add(new Label("Type :"));
        panelRecherche.add(menuType);*/


        this.add(panelRecherche);
        this.add(new JScrollPane(vueResultat));
        this.revalidate();

    }

    public void initMenus(){
        menuRunes.addItem("(aucune)");
        menuRunes.addItem("Agilité");
        menuRunes.addItem("Chance");
        menuRunes.addItem("Force");
        menuRunes.addItem("Intelligence");
    }

    public void updateOrdreScore(){
        if (score.isSelected()){
            niveau.setSelected(false);
            model.trierParTaux();
            vueResultat.updateRecherche(barreRecherche.getText());
        }
    }

    public void updateOrdreNiveau(){
        if(niveau.isSelected()) {
            score.setSelected(false);
            model.trierParNiveaux();
            vueResultat.updateRecherche(barreRecherche.getText());
        }
    }


}
