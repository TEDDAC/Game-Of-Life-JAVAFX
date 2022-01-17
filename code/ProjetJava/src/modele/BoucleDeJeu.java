package modele;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.ArrayList;
import java.util.List;

public class BoucleDeJeu implements Runnable{
    private final Dieu dieu;
    private ArrayList<Object> observateur= new ArrayList<>();

    public static boolean played = false;
    public static boolean getPlayed(){ return played; }
    public static void setPlayed(boolean valeur){ played = valeur;}

    private static IntegerProperty time = new SimpleIntegerProperty();
    public static int getTime(){ return time.get(); }
    public static void setTime(int valeur){ time.set(valeur);}
    public static IntegerProperty timeProperty(){ return time; }

    public BoucleDeJeu(Dieu dieu){
        this.dieu = dieu;
        setTime(500);
    }

    public void ajouterObservateur(Object a){
        observateur.add(a);
    }

    @Override
    public void run() {
        int cpt = 0;
        while(true){
            if(BoucleDeJeu.getPlayed() == true){
                dieu.evolution();
                dieu.updateCells();
            }
            try { //ne pas mettre dans la boucle, sinon ça ne tourne pas
                Thread.sleep(getTime());
            } catch(Exception e){

            }
            System.out.println(cpt = cpt+1);
        }
    }
}
