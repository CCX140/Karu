package karu.view.recherche;

import karu.model.LesEquipements;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


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
        this.setBorder(title);
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        vueResultat = new VueResultat(model);

        score = new JRadioButton("score");
        score.addActionListener(e -> updateOrdreScore());
        niveau = new JRadioButton("niveau");
        niveau.addActionListener(e -> updateOrdreNiveau());
        
        groupeBouttons = new JPanel();
        groupeBouttons.add(score);
        groupeBouttons.add(niveau);
        TitledBorder triBorder;
        triBorder = BorderFactory.createTitledBorder("Trier par :");
        groupeBouttons.setBorder(triBorder);
        groupeBouttons.setLayout(new FlowLayout(FlowLayout.LEFT));


        barreRecherche = new JTextField();
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

        menuRunes = new JComboBox();
        menuType = new JComboBox();

        initMenus();
        panelRecherche.add(new Label("Stat :"));
        panelRecherche.add(menuRunes);
        panelRecherche.add(new Label("Type :"));
        panelRecherche.add(menuType);


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
