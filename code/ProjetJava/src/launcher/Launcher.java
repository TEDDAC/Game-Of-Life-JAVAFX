package launcher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import modele.Dieu;
import modele.Monde;
import modele.Rules;

import java.util.Arrays;


public class Launcher extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Monde monde = new Monde(10,10);
        boolean born[] = new boolean[10];
        boolean survive[] = new boolean[10];
        Arrays.fill(born, false);
        Arrays.fill(survive, false);
        born[3]=true;
        survive[2]=true;
        survive[3]=true;
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
        /*GridPane mainGrid = (GridPane) root.lookup("#mainGrid");
        System.out.println(mainGrid);
        GridPane plateau = new GridPane();
        for (int i=0;i<10;i++){
            for (int j=0;j<10;j++){
                plateau.add(new CheckBox(),i,j);
            }
        }
        mainGrid.add(plateau,0,1);*/
        primaryStage.show();
    }
}
