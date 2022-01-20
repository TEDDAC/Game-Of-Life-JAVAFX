package Stub;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.control.Cell;
import modele.Cellule;
import modele.Dieu;
import modele.Monde;
import modele.Rules;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Stub {
    public Stub() {
    }
    public HashMap<String,Cellule[][]> Config(){
        HashMap<String,Cellule[][]> Config= new HashMap<>();

        Cellule[][] grille = createGrid();

        //glider
        grille[1][0].setAlive(true);
        grille[2][1].setAlive(true);
        grille[0][2].setAlive(true);
        grille[1][2].setAlive(true);
        grille[2][2].setAlive(true);

        Config.put("Glider",grille);


        //récursif config
        grille = createGrid();

        grille[1][5].setAlive(true);
        grille[2][5].setAlive(true);
        grille[3][5].setAlive(true);


        Config.put("Récursif",grille);


        grille = createGrid();

        grille[1][0].setAlive(true);
        grille[2][0].setAlive(true);
        grille[0][1].setAlive(true);
        grille[1][2].setAlive(true);
        grille[1][3].setAlive(true);

        grille[2][5].setAlive(true);
        grille[3][4].setAlive(true);
        grille[3][5].setAlive(true);
        grille[3][6].setAlive(true);
        grille[5][2].setAlive(true);
        grille[5][3].setAlive(true);
        grille[5][4].setAlive(true);
        grille[6][3].setAlive(true);
        grille[7][5].setAlive(true);
        grille[7][6].setAlive(true);
        grille[8][7].setAlive(true);
        grille[6][8].setAlive(true);
        grille[7][8].setAlive(true);
        grille[7][6].setAlive(true);

        Config.put("Achim Flammenkamp",grille);

        return Config;

    }

    public HashMap<String,Rules> configRules(){
        HashMap<String,Rules> config= new HashMap<String, Rules>();

        //default
        SimpleBooleanProperty[] born = new SimpleBooleanProperty[9];
        for(int i=0;i<9;i++){
            born[i] = new SimpleBooleanProperty();
            born[i].set(false);
        }
        born[3].set(true);

        SimpleBooleanProperty[] survive = new SimpleBooleanProperty[9];
        for(int i=0;i<9;i++){
            survive[i] = new SimpleBooleanProperty();
            survive[i].set(false);
        }
        survive[2].set(true);
        survive[3].set(true);

        config.put("Default",new Rules(born,survive));



        //water: live 0-9, born 3,5-8
        born = new SimpleBooleanProperty[9];
        for(int i=0;i<9;i++){
            born[i] = new SimpleBooleanProperty();
            born[i].set(false);
        }
        born[3].set(true);
        born[5].set(true);
        born[6].set(true);
        born[7].set(true);
        born[8].set(true);

        survive = new SimpleBooleanProperty[9];
        for(int i=0;i<9;i++){
            survive[i] = new SimpleBooleanProperty();
            survive[i].set(true);
        }

        config.put("Water",new Rules(born,survive));


        //blob: live 0-9, born 3,6-8
        born = new SimpleBooleanProperty[9];
        for(int i=0;i<9;i++){
            born[i] = new SimpleBooleanProperty();
            born[i].set(false);
        }
        born[3].set(true);
        born[6].set(true);
        born[7].set(true);
        born[8].set(true);

        survive = new SimpleBooleanProperty[9];
        for(int i=0;i<9;i++){
            survive[i] = new SimpleBooleanProperty();
            survive[i].set(true);
        }

        config.put("Blob",new Rules(born,survive));
        return config;
    }

    public Dieu Base(){
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
        return  dieu;
    }

    public Cellule[][] createGrid(){
        Cellule[][] grille = new Cellule[Dieu.monde.getTailleX()][Dieu.monde.getTailleY()];
        for(int x=0;x<Dieu.monde.getTailleX();x++){
            for(int y=0;y<Dieu.monde.getTailleY();y++){
                grille[x][y] = new Cellule(x,y);
            }
        }

        return grille;
    }
}
