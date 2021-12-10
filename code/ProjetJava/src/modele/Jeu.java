package modele;

import java.util.ArrayList;

public class Jeu {
    private int tailleX;
    private int tailleY;

    private Cellule[][] grille;
    private ArrayList<Cellule> celluleEnVie;
    private ArrayList<Cellule> traite;

    private Rules rules;


    public Jeu(int tailleX, int tailleY) {
        this.tailleX = tailleX;
        this.tailleY = tailleY;
        grille = new Cellule[tailleY][tailleX];
        this.celluleEnVie = new ArrayList<>();
        this.traite = new ArrayList<>();
    }
    public void setCellules(int x,int y)//permet de données à une cellule ces voisines qu'elle gardera en mémoire et que le jeu récupèrera après
    {
        if(grille[y][x] == null)
        {
            //exception return "Impossible de récuperer les cellules voisines,la cellule est null";
        }
        this.giveVoisine(x,y);
    }

    public void AjoutCellule(int x, int y, Cellule cell){//permet de faire vivre une cellule
        if(grille[x][y] != null){
            //exception
        }
        if(cell == null){
            //exception
        }
        grille[x][y]=cell;
    }
    public void SupprimerCellule(int x, int y){//permet de tuer une cellule
        if(grille[x][y] != null){
            //exception "Impossible de supprimer,l'emplacement est déja null";
        }
        grille[x][y]=null;
    }

    public void giveVoisine(int x, int y){
        ArrayList<Cellule> voisines = grille[y][x].getCellulesVoisines();
        voisines.clear();
        for(int i=x-1;i<=x+1;i++){
            if(i < 0) i = 0;
            if(i > tailleX) i = tailleX;
            for(int j=y-1;j<=y+1;j++){
                if(j < 0) j = 0;
                if(j > tailleY) i = tailleY;
                if(j != y && i!= x)
                    voisines.add(grille[j][i]); //Grille[Ligne][Colonne], donc on doit inverse x et y
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

    public Rules getRules() {
        return rules;
    }

    public void setRules(Rules rules) {
        this.rules = rules;
    }
}
