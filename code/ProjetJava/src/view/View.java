package view;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import modele.Cellule;
import modele.Dieu;
import modele.Monde;
import modele.Rules;
import test.Afficheur;

import java.awt.*;
import java.util.Arrays;

public class View {
    public void charger (){

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
        VBox root = new VBox();

        GridPane plateau = new GridPane();
        root.getChildren().add(plateau);
        plateau.setVgap(3);
        plateau.setHgap(3);
        //a revoir
        for (int i=0;i<10;i++){
            for (int j=0;j<10;j++){
                plateau.add(monde.getGrille()[i][j],i,j);
            }
        }
        for(int x=0;x<31;x++) {
            dieu.evolution();
            dieu.updateCells();
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }
    }
}
