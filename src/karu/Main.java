/* Romain Guittienne alias CCX 28/01/2019*/

package karu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import karu.model.Karu;
import karu.util.Constants;
import karu.view.calculpoids.CalculPoids;
import karu.view.items.Items;
import karu.view.main.MainControl;
import karu.view.taux.Taux;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        ///////MODEL//////
        Karu model = new Karu();
        System.out.println(model.toString());

        //main controller
        MainControl mainControl = new MainControl();

        //calcul poids controller
        CalculPoids calculPoids = new CalculPoids();

        //items controller
        Items items = new Items();

        //Taux
        Taux taux = new Taux(model);

        //load main view
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/karu/view/main/main.fxml"));
        loader.setControllerFactory(instantiatedClass -> { return mainControl ; });
        BorderPane root = loader.load();

        //TabPane
        TabPane tabPane = new TabPane();

        //////////////load taux view//////////////////
        FXMLLoader loader3 = new FXMLLoader();
        loader3.setLocation(getClass().getResource("/karu/view/taux/taux.fxml"));
        loader3.setControllerFactory(instantiatedClass -> { return taux ; });
        ScrollPane tauxRoot = loader3.load();
        //Tab creation
        Tab tabTaux = new Tab("Taux des runes");
        tabTaux.setContent(tauxRoot);
        //Add tab to tabpane
        tabPane.getTabs().add(tabTaux);


        //////////////load calcul poids view//////////////////
        FXMLLoader loader2 = new FXMLLoader();
        loader2.setLocation(getClass().getResource("/karu/view/calculPoids/calculpoids.fxml"));
        loader2.setControllerFactory(instantiatedClass -> { return calculPoids ; });
        BorderPane poidsRoot = loader2.load();
        //Tab creation
        Tab tabPoids = new Tab("Calcul de Poids");
        tabPoids.setContent(poidsRoot);
        //Add tab to tabpane
        tabPane.getTabs().add(tabPoids);

        //////////////load items view//////////////////
        FXMLLoader loader4 = new FXMLLoader();
        loader4.setLocation(getClass().getResource("/karu/view/items/items.fxml"));
        loader4.setControllerFactory(instantiatedClass -> { return items ; });
        BorderPane itemsRoot = loader4.load();
        //Tab creation
        Tab tabItems = new Tab("Items");
        tabItems.setContent(itemsRoot);
        //Add tab to tabpane
        tabPane.getTabs().add(tabItems);


        //add tabpane to center of main view
        root.setCenter(tabPane);

        //set title
        primaryStage.setTitle("Karu");

        //root to primary stage
        primaryStage.setScene(new Scene(root));
        primaryStage.setMaximized(true);

        //display app
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
