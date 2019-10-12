package karu.view;

import karu.model.Karu;
import karu.util.Constants;
import karu.view.recherche.VueRecherche;
import karu.view.taux.VueTaux;
import karu.view.toprunes.VueRunes;

import javax.swing.*;
import java.awt.*;

public class MainView {
    private Karu model;
    private JFrame main;
    private JMenuBar menuBar;
    private JPanel panel;
    private JComponent vueTaux;
    private JComponent vueRunes;
    private JComponent vueRecherche;

    public MainView(Karu model){
        this.model = model;
        main = new JFrame();
        menuBar = new JMenuBar();
        vueRunes = new VueRunes(model.getRunes());
        vueTaux = new VueTaux(model.getRunes(), (VueRunes) vueRunes);
        vueRecherche = new VueRecherche(model.getEquipements());
        panel = (JPanel) main.getContentPane();

        panel.setLayout(new GridLayout(1,3));

        panel.add(new JScrollPane(vueTaux));
        panel.add(new JScrollPane(vueRunes));
        panel.add(vueRecherche);

        main.setSize(Constants.WIDTH/2,Constants.HEIGHT/2);
        main.setTitle("KARU");
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setExtendedState(main.MAXIMIZED_BOTH);
        main.pack();
        main.setVisible(true);
    }

    public JComponent getVueRunes() {
        return vueRunes;
    }
}
