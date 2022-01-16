package modele;

import java.util.ArrayList;
import java.util.List;

public class BoucleDeJeu implements Runnable{
    private Dieu dieu;
    private ArrayList<Object> observateur= new ArrayList<>();



    public BoucleDeJeu(Dieu dieu){
        this.dieu = dieu;
    }

    public void ajouterObservateur(Object a){
        observateur.add(a);
    }

    @Override
    public void run() {

        /*for (Object a: observateur)
        {
            //beep
        }*/

        for(int x=0;x<31;x++){
            dieu.evolution();
            dieu.updateCells();
            try {
                Thread.sleep(500);
            } catch(Exception e){

            }
        }

    }
}
