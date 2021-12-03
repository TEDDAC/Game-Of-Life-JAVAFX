package modele;

import java.util.ArrayList;

public class Jeu {
    private int tailleX;
    private int tailleY;

    private Cellule Grille[][];
    private ArrayList<Cellule> celluleEnVie;
    private ArrayList<Cellule> traité;



    public Jeu(int tailleX, int tailleY, Cellule[][] grille, ArrayList<Cellule> celluleEnVie, ArrayList<Cellule> traité) {
        this.tailleX = tailleX;
        this.tailleY = tailleY;
        Grille = grille;
        this.celluleEnVie = celluleEnVie;
        this.traité = traité;
    }
    public String setCellules(int x,int y)//permet de données à une cellule ces voisines qu'elle gardera en mémoire et que le jeu récupèrera après
    {
        if(Grille[x][y] == null)
        {
            return "Impossible de récuperer les cellules voisines,la cellule est null";
        }
        Grille[x][y].getCellulesVoisines().clear();
        for(int i=x-1;i<=x+1;i++){
            for(int j=x-1;i<=x+1;i++){
                Grille[y][x].getCellulesVoisines().add(Grille[j][i]); //Grille[Ligne][Colonne], donc on doit inverse
            }
        }
        return "";
    }

    public String AjoutCellule(int x, int y, Cellule cell){//permet de faire vivre une cellule
        if(Grille[x][y] != null){
            return "Impossible d'ajouter,une cellule est déja à cet emplacement";
        }
        if(cell == null){
            return "Impossible d'ajouter,la cellule est null";
        }
        Grille[x][y]=cell;
        return "";
    }
    public String SupprimerCellule(int x, int y){//permet de tuer une cellule
        if(Grille[x][y] != null){
            return "Impossible de supprimer,l'emplacement est déja null";
        }
        Grille[x][y]=null;
        return "";
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
        return Grille;
    }

    public void setGrille(Cellule[][] grille) {
        Grille = grille;
    }

    public ArrayList<Cellule> getCelluleEnVie() {
        return celluleEnVie;
    }

    public void setCelluleEnVie(ArrayList<Cellule> celluleEnVie) {
        this.celluleEnVie = celluleEnVie;
    }

    public ArrayList<Cellule> getTraité() {
        return traité;
    }

    public void setTraité(ArrayList<Cellule> traité) {
        this.traité = traité;
    }
}
