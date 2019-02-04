package karu.view.taux;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import karu.model.Karu;
import karu.model.Runes;
import karu.util.Constants;
import karu.util.Constants.*;

import javax.swing.text.Element;
import javax.swing.text.TableView;
import java.util.Observable;
import java.util.Observer;
import static karu.util.Constants.*;

public class Taux implements Observer{

    //model
    private Karu model;

    @FXML
    private HBox hbox;

    private VBox runes;
    private VBox nomRunes;
    private VBox prix;
    private VBox taux;


    public Taux(Karu model){
        this.model = model;
        this.runes = new VBox();
        this.nomRunes = new VBox();
        this.prix = new VBox();
        this.taux = new VBox();
    }

    @FXML
    public void initialize() throws Exception {
        hbox.getChildren().addAll(runes,nomRunes,prix,taux);
        Runes runes = model.getRunes();

        //Remplissage de la colone "Nom de la rune"

        //Titre colone "nom des runes"
        Label TitreNomRunes = new Label("Nom de la Rune");
        TitreNomRunes.setStyle("-fx-font-size:18px;");
        TitreNomRunes.setStyle("-fx-font-weight: bold");
        TitreNomRunes.setPrefSize(LABEL_NOM_RUNE_WIDTH,LABEL_NOM_RUNE_HEIGHT);
        nomRunes.getChildren().add(TitreNomRunes);

        //remplissage du tableau : colone "nom de la rune"
        runes.getListRunes().forEach((nom,poids)-> {
            Label nomRune = new Label(nom);
            nomRune.setStyle("-fx-border-color : black");
            nomRune.setStyle("-fx-font-size:14px;");
            nomRune.setPrefSize(LABEL_NOM_RUNE_WIDTH,LABEL_NOM_RUNE_HEIGHT);
            nomRune.setTextAlignment(TextAlignment.CENTER);
            this.nomRunes.getChildren().add(nomRune);
        });

    }



    @Override
    public void update(Observable o, Object arg) {

    }
}
