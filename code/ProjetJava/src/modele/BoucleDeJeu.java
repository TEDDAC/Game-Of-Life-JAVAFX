package modele;

import java.util.ArrayList;
import java.util.List;

public class BoucleDeJeu implements Runnable{
    private Monde monde;
    private ArrayList<Object> observateur= new ArrayList<>();



    public BoucleDeJeu(){
        monde = new Monde(100,100);
    }

    public Monde getMonde() {
        return monde;
    }

    public void setMonde(Monde monde) {
        this.monde = monde;
    }

    public void ajouterObservateur(Object a){
        observateur.add(a);
    }

    @Override
    public void run() {

        for (Object a: observateur)
        {
            //beep
        }

    }
}
