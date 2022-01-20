package modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;


public class Monde{

    /**
     * Taille X de la grille de cellule. Bind sur un spinner dans la vue.
     */
    private final static IntegerProperty tailleX = new SimpleIntegerProperty();
    public static int getTailleX(){ return tailleX.get(); }
    public static void setTailleX(int valeur){ tailleX.set(valeur);}
    public static IntegerProperty tailleXProperty(){ return tailleX; }

    /**
     * Taille Y de la grille de cellule. Bind sur un spinner dans la vue.
     * Taille Y de la grille de cellule. Bind sur un spinner dans la vue.
     */
    private final static IntegerProperty tailleY = new SimpleIntegerProperty();
    public static int getTailleY(){ return tailleY.get(); }
    public static void setTailleY(int valeur){ tailleY.set(valeur);}
    public static IntegerProperty tailleYProperty(){ return tailleY; }

    /**
     * Grille de cellule.
     */
    private Cellule[][] grille;


    /**
     * Constructeur du monde
     * @param tailleX Taille X du monde
     * @param tailleY Taille Y du monde
     */
    public Monde(int tailleX, int tailleY) {
        setTailleX(tailleX);
        setTailleY(tailleY);
        grille = GrilleCellFactory.createCellGrid(tailleX,tailleY);
    }

    /**
     * Getter
     * @return
     */
    public Cellule[][] getGrille() {
        return grille;
    }

    /**
     * Setter
     * @param grille
     */
    public void setGrille(Cellule[][] grille) {
        this.grille = grille;
    }
}
