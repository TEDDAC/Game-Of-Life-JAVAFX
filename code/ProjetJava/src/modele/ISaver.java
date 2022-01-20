package modele;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public interface ISaver {

    /**
     * Sauvegarde une grille de cellule dans un fichier
     * @param monde Monde dont on souhaite sauvegarder la grille de cellule
     * @param fichier Fichier dans lequel on souhaite sauvegarder la grille
     */
    static void save(Monde monde, File fichier) {
        int sizex = monde.getTailleX();
        int sizey = monde.getTailleY();
        String nom = fichier.getPath();
        try {
            if(!nom.endsWith(".cgl")){
                nom = nom+".cgl";
            }
            FileWriter writer = new FileWriter(nom);
            writer.write(sizex+"\n");
            writer.write(sizey+"\n");
            for(int x=0;x<sizex;x++){
                for(int y=0;y<sizey;y++){
                    writer.write((monde.getGrille()[x][y].isAlive() ? "1" : "0")+"\n");
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
