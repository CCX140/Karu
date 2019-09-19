package karu.view.taux;

import javax.swing.*;

public class VueTaux extends JPanel {

    private JLabel label;
    private JTable table;

    public VueTaux(){
        super();
        label = new JLabel("Taux des Runes");
        table = new JTable();

        this.add(label,table);
    }
}
