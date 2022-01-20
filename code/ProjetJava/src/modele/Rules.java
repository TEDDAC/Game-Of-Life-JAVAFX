package modele;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class Rules {
    /**
     * Règle de naissance des cellules.
     */
    private final SimpleBooleanProperty[] BornRules; //tableau de propriété booléen
    public boolean getBornRules(int i){ return BornRules[i].get(); }
    public void setBornRules(int i,boolean valeur){ BornRules[i].set(valeur);}
    public final BooleanProperty bornRulesProperty(int i) { return BornRules[i]; }

    /**
     * Règle de survie des cellules.
     */
    private final SimpleBooleanProperty[] SurviveRules; //tableau de propriété booléen
    public boolean getSurviveRules(int i){ return SurviveRules[i].get(); }
    public void setSurviveRules(int i,boolean valeur){ SurviveRules[i].set(valeur);}
    public final BooleanProperty surviveRulesProperty(int i) { return SurviveRules[i]; }

    /**
     * Constructeur de Rules
     * @param bornRules Règles de naissances
     * @param surviveRules  Règles de survie
     */
    public Rules(SimpleBooleanProperty[] bornRules, SimpleBooleanProperty[] surviveRules){
        this.BornRules = bornRules;
        this.SurviveRules = surviveRules;
    }

    /**
     * Permet de changer les règles du jeu, sans regénérer une nouvelle instance et devoir refaire le binding de la vue.
     * @param newRules Nouvelles règles à appliquer
     */
    public void switchRulesTo(Rules newRules){
        for(int i=0;i<9;i++){
            setBornRules(i, newRules.getBornRules(i));
            setSurviveRules(i, newRules.getSurviveRules(i));
        }
    }
}
