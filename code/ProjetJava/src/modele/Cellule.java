package modele;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

import java.util.ArrayList;

public class Cellule {
    private int nextTimeStatus; // si c'est -1 la cellule doit mourir à la prochaine itération, si 0 pas de changement, si 1 elle doit vivre

    private BooleanProperty alive = new SimpleBooleanProperty();
    public boolean getAlive(){ return alive.get(); }
    public void setAlive(boolean valeur){ alive.set(valeur);}
    public BooleanProperty aliveProperty(){ return alive; }

    private int x;
    private int y;

    /**
     * Constructeur d'une cellule
     * @param x
     * @param y
     */
    public Cellule(int x,int y) { //on initialise toutes les cellules en créant la grille
        nextTimeStatus = 0;
        alive.set(false);
        this.x = x;
        this.y = y;
    }

    public int getNextTimeStatus() {
        return nextTimeStatus;
    }

    public void setNextTimeStatus(int nextTimeStatus) {
        this.nextTimeStatus = nextTimeStatus;
    }

    public boolean isAlive() {
        return getAlive();
    }


    /**
     * permet à partir du nextTimeStatus fixer dans les méthodes de dieu de définir l'évolution futur d'une cellule vivante,morte.
     */
    public void update(){
        if(nextTimeStatus == 1) setAlive(true);
        else if(nextTimeStatus == -1) setAlive(false);
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "Cellule{" +
                "nextTimeStatus=" + nextTimeStatus +
                ", alive=" + alive +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
