package karu.view.recherche;

import javax.swing.*;


public class VueRecherche extends JPanel {

    private JLabel label;
    private JTable table;

    public VueRecherche(){
        super();
        label = new JLabel("Recherche");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        table = new JTable();

        this.add(label);
    }
}
