package karu.view;

import karu.model.Karu;
import karu.util.Constants;
import karu.view.recherche.VueRecherche;
import karu.view.taux.VueTaux;
import karu.view.toprunes.VueRunes;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

import static karu.util.Constants.*;
import static karu.util.Constants.B_GRAY;

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

        UIManager.put("TitledBorder.border", new LineBorder(new Color(R_DARK_GRAY,G_DARK_GRAY,B_DARK_GRAY ), 2));

        JScrollPane scrollVueTaux = new JScrollPane(vueTaux);
        scrollVueTaux.setBorder(null);
        scrollVueTaux.getVerticalScrollBar().setBackground(new Color(R_GRAY,G_GRAY,B_GRAY));
        scrollVueTaux.getHorizontalScrollBar().setBackground(new Color(R_GRAY,G_GRAY,B_GRAY));

        JScrollPane scrollVueRunes = new JScrollPane(vueRunes);
        scrollVueRunes.setBorder(null);
        scrollVueRunes.getVerticalScrollBar().setBackground(new Color(R_GRAY,G_GRAY,B_GRAY));
        scrollVueRunes.getHorizontalScrollBar().setBackground(new Color(R_GRAY,G_GRAY,B_GRAY));

        panel.add(scrollVueTaux);
        panel.add(scrollVueRunes);
        panel.add(vueRecherche);
        main.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/karu/model/ressources/icone.png")));

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
