package modele;

import java.util.ArrayList;

public class Monde {
    private int tailleX;
    private int tailleY;

    private Cellule[][] grille;



    public Monde(int tailleX, int tailleY) {
        this.tailleX = tailleX;
        this.tailleY = tailleY;
        grille = new Cellule[tailleX][tailleY];
        generer();
    }

    public void generer(){
        for (int i = 0; i < tailleX; i++) {
            for (int j = 0; j < tailleY; j++) {
                grille[i][j]=new Cellule(i,j);
            }
        }
    }
    public int getTailleX() {
        return tailleX;
    }

    public void setTailleX(int tailleX) {
        this.tailleX = tailleX;
    }

    public int getTailleY() {
        return tailleY;
    }

    public void setTailleY(int tailleY) {
        this.tailleY = tailleY;
    }

    public Cellule[][] getGrille() {
        return grille;
    }

    public void setGrille(Cellule[][] grille) {
        this.grille = grille;
    }


}
