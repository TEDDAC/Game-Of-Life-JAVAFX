package stub;

import javafx.beans.property.SimpleBooleanProperty;
import modele.*;
import java.util.HashMap;

/**
 * Permet de générer toutes les données au lancement.
 */
public class Stub {
    public Stub() {
    }

    /**
     * Configure les différentes règles.
     * @return Retourne un dictionnaire de règles.
     */
    public HashMap<String,Rules> configRules(){
        HashMap<String,Rules> config= new HashMap<>();

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

        //Maze: live 1-5, born 3
        born = new SimpleBooleanProperty[9];
        for(int i=0;i<9;i++){
            born[i] = new SimpleBooleanProperty();
            born[i].set(false);
        }
        born[3].set(true);

        survive = new SimpleBooleanProperty[9];
        for(int i=0;i<9;i++){
            survive[i] = new SimpleBooleanProperty();
            survive[i].set(false);
        }
        survive[1].set(true);
        survive[2].set(true);
        survive[3].set(true);
        survive[4].set(true);
        survive[5].set(true);

        config.put("Maze",new Rules(born,survive));
        return config;
    }

    /**
     * Permet de créer le dieu au démarrage.
     * @return retourne une instance de dieu.
     */
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
        return new Dieu(monde, rules);
    }
}
