package karu.view;

import karu.util.Constants;
import karu.view.taux.VueTaux;
import karu.view.toprunes.VueRunes;

import javax.swing.*;

public class MainView {
    private JFrame main;
    private JMenuBar menuBar;
    private VueTaux vueTaux;

    public MainView(){
        main = new JFrame();
        menuBar = new JMenuBar();

        vueTaux = new VueTaux();

        main.add(vueTaux);

        main.setSize(Constants.WIDTH/2,Constants.HEIGHT/2);
        main.setTitle("KARU");
        main.setLocationRelativeTo(null);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setVisible(true);
    }
}
