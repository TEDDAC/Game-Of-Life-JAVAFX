package modele;

import java.util.ArrayList;

public class Monde {
    private int tailleX;
    private int tailleY;

    private Cellule[][] grille;
    private ArrayList<Cellule> celluleEnVie;
    private ArrayList<Cellule> traite;


    public Monde(int tailleX, int tailleY) {
        this.tailleX = tailleX;
        this.tailleY = tailleY;
        grille = new Cellule[tailleY][tailleX];
        this.celluleEnVie = new ArrayList<>();
        this.traite = new ArrayList<>();
        generer();
    }

    public void generer(){
        for (int i = 0; i < tailleX; i++) {
            for (int j = 0; j < tailleY; j++) {
                grille[i][j]=new Cellule();
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

    public ArrayList<Cellule> getCelluleEnVie() {
        return celluleEnVie;
    }

    public void setCelluleEnVie(ArrayList<Cellule> celluleEnVie) {
        this.celluleEnVie = celluleEnVie;
    }

    public ArrayList<Cellule> getTraite() {
        return traite;
    }

    public void setTraite(ArrayList<Cellule> traite) {
        this.traite = traite;
    }
}
