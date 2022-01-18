package launcher;

import Stub.Stub;
import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import modele.BoucleDeJeu;
import modele.Dieu;
import modele.Monde;
import modele.Rules;

import java.util.Arrays;
import java.util.HashMap;


public class Launcher extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Stub stub = new Stub();

        HashMap<String,Monde> CollectionMonde= new HashMap<String,Monde>();

        Dieu dieu = stub.Base();
        CollectionMonde = stub.Config();
        dieu.setMonde(CollectionMonde.get("Glider"));
        //instanciation des vues
        Parent root = FXMLLoader.load(getClass().getResource("/Vue.fxml")); //relatif à /ressource
        primaryStage.setTitle("Jeu de la vie");
        primaryStage.setScene(new Scene(root,1500,1500));
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.exit(0);
            }
        });
        primaryStage.show();

        Thread th = new Thread(new BoucleDeJeu(dieu));
        th.start();
    }
}
