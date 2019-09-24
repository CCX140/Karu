package karu.view.recherche;

import karu.model.LesEquipements;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;


public class VueRecherche extends JPanel {

    private LesEquipements model;
    private JRadioButton score;
    private JRadioButton niveau;
    private JPanel groupeBouttons;
    private JTextField barreRecherche;
    private JMenu menuRunes;
    private JMenu menuType;
    private VueResultat vueResultat;
    

    public VueRecherche(LesEquipements lesEquipements){
        super();
        model = lesEquipements;
        TitledBorder title;
        title = BorderFactory.createTitledBorder("Recherche");
        this.setBorder(title);
        this.setLayout(new GridLayout(3,1));

        score = new JRadioButton("score");
        niveau = new JRadioButton("niveau");
        
        groupeBouttons = new JPanel();
        groupeBouttons.add(score);
        groupeBouttons.add(niveau);
        TitledBorder triBorder;
        triBorder = BorderFactory.createTitledBorder("Trier par :");
        groupeBouttons.setBorder(triBorder);
        groupeBouttons.setLayout(new FlowLayout(FlowLayout.LEFT));


        barreRecherche = new JTextField("Recherche");
        barreRecherche.setHorizontalAlignment(JTextField.LEFT);
        barreRecherche.setPreferredSize(new Dimension(200,25));

        JPanel panelRecherche = new JPanel();
        panelRecherche.add(groupeBouttons);
        panelRecherche.add(barreRecherche);

        menuRunes = new JMenu("Stat :");
        menuType = new JMenu("Type :");
        initMenus();
        panelRecherche.add(menuRunes);
        panelRecherche.add(menuType);


        this.add(panelRecherche);
        this.add(new VueResultat());
        this.revalidate();

    }

    public void initMenus(){

    }

}
