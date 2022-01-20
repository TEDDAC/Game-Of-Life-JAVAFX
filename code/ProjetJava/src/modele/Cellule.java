package modele;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class Cellule {
    /**
     * Etat de la cellule au prochain tour de boucle. -1 signifie que la cellule va mourir, 1 signifie qu'elle va naitre, 0 ne change rien
     */
    private int nextTimeStatus;

    /**
     * Etat de la cellule (en vie ou morte).
     */
    private final BooleanProperty alive = new SimpleBooleanProperty();
    public boolean getAlive(){ return alive.get(); }
    public void setAlive(boolean valeur){ alive.set(valeur);}
    public BooleanProperty aliveProperty(){ return alive; }

    /**
     * Coordonnée X de la cellule dans la grille
     */
    private int x;
    /**
     * Coordonnée Y de la cellule dans la grille
     */
    private int y;

    /**
     * Constructeur d'une cellule
     * @param x Coordonnée X de la cellule dans la grille
     * @param y Coordonnée Y de la cellule dans la grille
     */
    public Cellule(int x,int y) { //on initialise toutes les cellules en créant la grille
        nextTimeStatus = 0;
        alive.set(false);
        this.x = x;
        this.y = y;
    }

    /**
     * Guetter de nextTimeStatus
     * @return entier
     */
    public int getNextTimeStatus() {
        return nextTimeStatus;
    }

    /**
     * Setter de nextTimeStatus
     * @param nextTimeStatus
     */
    public void setNextTimeStatus(int nextTimeStatus) {
        this.nextTimeStatus = nextTimeStatus;
    }

    /**
     * Indique si la cellule est en vie ou non.
     * @return True si elle est en vie, false sinon
     */
    public boolean isAlive() {
        return getAlive();
    }


    /**
     * Permet d'actualiser la cellule et de lui donner sont état pour le prochain tour de boucle.
     */
    public void update(){
        if(nextTimeStatus == 1) setAlive(true);
        else if(nextTimeStatus == -1) setAlive(false);
    }

    /**
     * Guetter de Y
     * @return entier
     */
    public int getY() {
        return y;
    }

    /**
     * Setter de Y
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Getter
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * Setter
     * @param x
     */
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
