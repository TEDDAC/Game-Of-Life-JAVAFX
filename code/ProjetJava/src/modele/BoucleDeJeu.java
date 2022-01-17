package modele;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

import java.util.ArrayList;
import java.util.List;

public class BoucleDeJeu implements Runnable{
    private final Dieu dieu;
    private ArrayList<Object> observateur= new ArrayList<>();

    public static boolean played = true;
    public static boolean getPlayed(){ return played; }
    public static void setPlayed(boolean valeur){ played = valeur;}

    public BoucleDeJeu(Dieu dieu){
        this.dieu = dieu;
    }

    public void ajouterObservateur(Object a){
        observateur.add(a);
    }

    @Override
    public void run() {
        setPlayed(false);
        while(true){
            if(BoucleDeJeu.getPlayed() == true){
                dieu.evolution();
                dieu.updateCells();
            }
            try { //ne pas mettre dans la boucle, sinon ça ne tourne pas
                Thread.sleep(500);
            } catch(Exception e){

            }
        }
    }
}
