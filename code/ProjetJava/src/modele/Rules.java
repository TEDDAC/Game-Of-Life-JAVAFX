package modele;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class Rules {
    private SimpleBooleanProperty[] bornRules; //tableau de propriété booléen
    public boolean getbornRules(int i){ return bornRules[i].get(); }
    public void setbornRules(int i,boolean valeur){ bornRules[i].set(valeur);}
    public final BooleanProperty bornRulesProperty(int i) { return bornRules[i]; };

    private SimpleBooleanProperty[] surviveRules; //tableau de propriété booléen
    public boolean getsurviveRules(int i){ return surviveRules[i].get(); }
    public void setsurviveRules(int i,boolean valeur){ surviveRules[i].set(valeur);}
    public final BooleanProperty surviveRulesProperty(int i) { return surviveRules[i]; };

    /**
     * Constructeur des règles
     * @param bornRules
     * @param surviveRules
     */
    public Rules(SimpleBooleanProperty[] bornRules, SimpleBooleanProperty[] surviveRules){
        this.bornRules = bornRules;
        this.surviveRules = surviveRules;
    }

    public BooleanProperty[] getbornRules() {
        return bornRules;
    }

    /*public void setbornRules(boolean[] bornRules) {
        this.bornRules = bornRules;
    }*/

    public BooleanProperty[] getsurviveRules() {
        return surviveRules;
    }

    /*public void setsurviveRules(boolean[] surviveRules) {
        this.surviveRules = surviveRules;
    }*/

    /**
     * permet de changer les règles dans un jeu
     * @param newRules
     */
    public void switchRulesTo(Rules newRules){
        for(int i=0;i<9;i++){
            setbornRules(i, newRules.getbornRules(i));
            setsurviveRules(i, newRules.getsurviveRules(i));
        }
    }
}
