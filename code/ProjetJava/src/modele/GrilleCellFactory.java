package modele;

public class GrilleCellFactory {
    public static Cellule[][] createCellGrid(int sizeX,int sizeY){
        Cellule[][] grille = new Cellule[sizeX][sizeY];
        for(int x=0;x<sizeX;x++){
            for(int y=0;y<sizeY;y++){
                grille[x][y] = new Cellule(x,y);
            }
        }

        return grille;
    }
}
