package launcher;

import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import modele.BoucleDeJeu;
import modele.Dieu;
import modele.Monde;
import modele.Rules;

import java.util.Arrays;


public class Launcher extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Monde monde = new Monde(30,30);

        //initialisation du tableau de proprieté au démarrage (règle de naissances)
        SimpleBooleanProperty[] born = new SimpleBooleanProperty[9];
        for(int i=0;i<9;i++){
            born[i] = new SimpleBooleanProperty();
            born[i].set(false);
        }
        born[3].set(true);

        //initialisation du tableau de proprieté au démarrage (règle de survie)
        SimpleBooleanProperty[] survive = new SimpleBooleanProperty[9];
        for(int i=0;i<9;i++){
            survive[i] = new SimpleBooleanProperty();
            survive[i].set(false);
        }
        survive[2].set(true);
        survive[3].set(true);

        Rules rules = new Rules(born,survive);
        Dieu dieu = new Dieu(monde, rules);

        //glider
        dieu.faireNaitre(1,0);
        dieu.faireNaitre(2,1);
        dieu.faireNaitre(0,2);
        dieu.faireNaitre(1,2);
        dieu.faireNaitre(2,2);

        //instanciation des vues
        Parent root = FXMLLoader.load(getClass().getResource("/Vue.fxml")); //relatif à /ressource
        primaryStage.setTitle("Jeu de la vie");
        primaryStage.setScene(new Scene(root,1500,1500));
        primaryStage.show();

        Thread th = new Thread(new BoucleDeJeu(dieu));
        th.start();
    }
}
