package karu.view.recherche;

import javax.swing.*;
import javax.swing.border.TitledBorder;


public class VueRecherche extends JPanel {


    private JTable table;

    public VueRecherche(){
        super();
        //Titled borders
        TitledBorder title;
        title = BorderFactory.createTitledBorder("Recherche");
        this.setBorder(title);
        table = new JTable();
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setSize(300,500);
        this.add(new JLabel("edfghj"));

    }
}
