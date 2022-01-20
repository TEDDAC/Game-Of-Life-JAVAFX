package modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.ArrayList;

public class Monde {
    private static IntegerProperty tailleX = new SimpleIntegerProperty();
    public static int getTailleX(){ return tailleX.get(); }
    public static void setTailleX(int valeur){ tailleX.set(valeur);}
    public static IntegerProperty tailleXProperty(){ return tailleX; }

    private static IntegerProperty tailleY = new SimpleIntegerProperty();
    public static int getTailleY(){ return tailleY.get(); }
    public static void setTailleY(int valeur){ tailleY.set(valeur);}
    public static IntegerProperty tailleYProperty(){ return tailleY; }

    private Cellule[][] grille;



    public Monde(int tailleX, int tailleY) {
        setTailleX(tailleX);
        setTailleY(tailleY);
        grille = new Cellule[tailleX][tailleY];
        generer();
    }

    public void generer(){
        for (int i = 0; i < getTailleX(); i++) {
            for (int j = 0; j < getTailleY(); j++) {
                grille[i][j]=new Cellule(i,j);
            }
        }
    }

    public Cellule[][] getGrille() {
        return grille;
    }

    public void setGrille(Cellule[][] grille) {
        this.grille = grille;
    }
}
