package karu.view.toprunes;

import javax.swing.*;


public class VueRunes extends JPanel{

    private JLabel label;
    private JTable table;

    public VueRunes(){
        super();
        label = new JLabel("Top Runes");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        table = new JTable();

        this.add(label);
    }

}
