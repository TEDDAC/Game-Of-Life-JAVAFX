package modele;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class Rules {
    private SimpleBooleanProperty[] BornRules; //tableau de propriété booléen
    public boolean getBornRules(int i){ return BornRules[i].get(); }
    public void setBornRules(int i,boolean valeur){ BornRules[i].set(valeur);}
    public final BooleanProperty bornRulesProperty(int i) { return BornRules[i]; };

    private SimpleBooleanProperty[] SurviveRules; //tableau de propriété booléen
    public boolean getSurviveRules(int i){ return SurviveRules[i].get(); }
    public void setSurviveRules(int i,boolean valeur){ SurviveRules[i].set(valeur);}
    public final BooleanProperty surviveRulesProperty(int i) { return SurviveRules[i]; };

    /**
     * Constructeur des règles
     * @param bornRules
     * @param surviveRules
     */
    public Rules(SimpleBooleanProperty[] bornRules, SimpleBooleanProperty[] surviveRules){
        this.BornRules = bornRules;
        this.SurviveRules = surviveRules;
    }

    public BooleanProperty[] getBornRules() {
        return BornRules;
    }

    /*public void setBornRules(boolean[] bornRules) {
        this.bornRules = bornRules;
    }*/

    public BooleanProperty[] getSurviveRules() {
        return SurviveRules;
    }

    /*public void setSurviveRules(boolean[] surviveRules) {
        this.SurviveRules = surviveRules;
    }*/

    /**
     * permet de changer les règles dans un jeu
     * @param newRules
     */
    public void switchRulesTo(Rules newRules){
        for(int i=0;i<9;i++){
            setBornRules(i, newRules.getBornRules(i));
            setSurviveRules(i, newRules.getSurviveRules(i));
        }
    }
}
