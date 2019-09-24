package karu.view.recherche;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;


public class VueRecherche extends JPanel {


    private JRadioButton score;
    private JRadioButton niveau;
    private JPanel groupeBouttons;
    private JTextField barreRecherche;
    private VueResultat vueResultat;
    

    public VueRecherche(){
        super();
        //Titled borders
        TitledBorder title;
        title = BorderFactory.createTitledBorder("Recherche");
        this.setBorder(title);
        this.setLayout(new FlowLayout(FlowLayout.LEFT));

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

        this.add(groupeBouttons);
        this.add(barreRecherche);
        this.add(new VueResultat());
        this.revalidate();

    }


}
