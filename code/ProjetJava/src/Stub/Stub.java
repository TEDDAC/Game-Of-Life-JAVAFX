package Stub;

import javafx.beans.property.SimpleBooleanProperty;
import modele.Dieu;
import modele.Monde;
import modele.Rules;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Stub {
    public Stub() {
    }
    public HashMap<String,Dieu> Config(){
        HashMap<String,Dieu> Config= new HashMap<String, Dieu>();
        Dieu dieu = Base();
        //glider
        dieu.faireNaitre(1,0);
        dieu.faireNaitre(2,1);
        dieu.faireNaitre(0,2);
        dieu.faireNaitre(1,2);
        dieu.faireNaitre(2,2);

        Config.put("Glider",dieu);

        //récursif config
        Dieu dieu1 = Base();

        dieu1.faireNaitre(1,5);
        dieu1.faireNaitre(2,5);
        dieu1.faireNaitre(3,5);


        Config.put("Récursif",dieu1);

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
