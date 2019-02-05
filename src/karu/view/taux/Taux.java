package karu.view.taux;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.effect.Lighting;
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

    private VBox runesSprite;
    private VBox nomRunes;
    private VBox prix;
    private VBox taux;


    public Taux(Karu model){
        this.model = model;
        this.runesSprite = new VBox();
        this.nomRunes = new VBox();
        this.prix = new VBox();
        this.taux = new VBox();
    }

    @FXML
    public void initialize() throws Exception {

        //on range les 4 Vbox dans la Hbox principal
        hbox.getChildren().addAll(runesSprite,nomRunes,prix,taux);
        Runes runes = model.getRunes();

        //Remplissage de la colone "Nom de la rune"

        //Titre colone "nom des runes"
        Label TitreNomRunes = new Label("Nom de la Rune");
        //style -> size 18px, bold, border black
        TitreNomRunes.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-border-color: black;");
        TitreNomRunes.setPrefSize(LABEL_NOM_RUNE_WIDTH,LABEL_NOM_RUNE_HEIGHT);
        this.nomRunes.getChildren().add(TitreNomRunes);

        //remplissage du tableau : colone "nom de la rune"
        runes.getListRunes().forEach((nom,poids)-> {
            Label nomRune = new Label(nom);
            //Style -> alignement center, size 14px, border black 1px
            nomRune.setStyle("-fx-alignment: center; -fx-font-size: 14px; -fx-border-color: black;");
            nomRune.setPrefSize(LABEL_NOM_RUNE_WIDTH,LABEL_NOM_RUNE_HEIGHT);
            this.nomRunes.getChildren().add(nomRune);
        });

        //remplissage du tableau : colone "Prix" avec des textes fields
        //l'utilisateur rentre le prix de la rune correspondante
        //Titre
        Label TitrePrix = new Label("Prix de la rune");
        //style -> size 18px, bold, border black
        TitrePrix.setStyle("-fx-font-size: 18px; -fx-border-color: black; -fx-font-weight: bold; ");
        TitrePrix.setPrefSize(LABEL_NOM_RUNE_WIDTH,LABEL_NOM_RUNE_HEIGHT);
        prix.getChildren().add(TitrePrix);
        runes.getListRunes().forEach((nom,poids)-> {
            TextField field = new TextField();
            field.setStyle("-fx-faint-focus-color: red");
            field.setPrefSize(LABEL_NOM_RUNE_WIDTH,LABEL_NOM_RUNE_HEIGHT);
            this.prix.getChildren().add(field);
        });





    }



    @Override
    public void update(Observable o, Object arg) {

    }
}
