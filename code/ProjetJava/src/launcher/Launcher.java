package launcher;

import stub.Stub;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modele.BoucleDeJeu;
import modele.Dieu;


public class Launcher extends Application {
    /**
     * Méthode permettant le lancement de la fenetre et le chargement de nos ressources
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Stub stub = new Stub();

        Dieu dieu = stub.Base();
        //instanciation des vues
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Vue.fxml")); //relatif à /ressource

        primaryStage.setTitle("Jeu de la vie");
        Scene scene = new Scene(root,1500,1500);
        scene.getStylesheets().add(getClass().getResource("/css/application.css").toExternalForm());

        primaryStage.setScene(scene);


        primaryStage.setOnCloseRequest(event -> System.exit(0));
        primaryStage.show();

        Thread th = new Thread(new BoucleDeJeu(dieu));
        th.start();
    }
}
