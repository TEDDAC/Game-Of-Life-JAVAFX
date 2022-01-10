package modele;

import java.util.ArrayList;

public class BoucleDeJeu {
    private Monde monde;

    public BoucleDeJeu(){
        monde = new Monde(100,100);
    }

    public Monde getMonde() {
        return monde;
    }

    public void setMonde(Monde monde) {
        this.monde = monde;
    }
}
