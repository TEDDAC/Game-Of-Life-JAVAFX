package Stub;

import javafx.beans.property.SimpleBooleanProperty;
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
    public HashMap<String,Monde> Config(){
        HashMap<String,Monde> Config= new HashMap<String, Monde>();
        Monde monde = new Monde(30,30);
        //glider

        monde.getGrille()[1][0].setAlive(true);
        monde.getGrille()[2][1].setAlive(true);
        monde.getGrille()[0][2].setAlive(true);
        monde.getGrille()[1][2].setAlive(true);
        monde.getGrille()[2][2].setAlive(true);

        Config.put("Glider",monde);

        //récursif config
        Monde monde1 = new Monde(30,30);


        monde1.getGrille()[1][5].setAlive(true);
        monde1.getGrille()[2][5].setAlive(true);
        monde1.getGrille()[3][5].setAlive(true);


        Config.put("Récursif",monde1);

        return Config;

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
}
