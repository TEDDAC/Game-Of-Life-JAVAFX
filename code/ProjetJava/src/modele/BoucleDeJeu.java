package modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class BoucleDeJeu implements Runnable{
    /**
     * Instance du dieu
     */
    private final Dieu dieu;

    /**
     * Indique à la pause si elle est lancé ou non
     */
    public static boolean played = false;
    public static boolean getPlayed(){ return played; }
    public static void setPlayed(boolean valeur){ played = valeur;}

    /**
     * Période entre chaque répétition de la boucle
     */
    private final static IntegerProperty time = new SimpleIntegerProperty();
    public static int getTime(){ return time.get(); }
    public static void setTime(int valeur){ time.set(valeur);}
    public static IntegerProperty timeProperty(){ return time; }

    /**
     * Constructeur de la boucle de jeu
     * @param dieu Le dieu qui sera modifié par la boucle de jeu.
     */
    public BoucleDeJeu(Dieu dieu){
        this.dieu = dieu;
        setTime(500);
    }

    /**
     * Algorithme de la boucle de jeu
     */
    @Override
    public void run() {
        while(true){
            if(BoucleDeJeu.getPlayed()){
                dieu.evolution();
                dieu.updateCells();
            }
            try { //ne pas mettre dans la boucle, sinon ça ne tourne pas
                Thread.sleep(getTime());
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
