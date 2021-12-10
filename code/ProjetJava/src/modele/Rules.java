package modele;

public class Rules {

    private Boolean[] bornRules;
    private Boolean[] surviveRules;

    public Rules(Boolean[] bornRules, Boolean[] surviveRules){
        this.bornRules = bornRules;
        this.surviveRules = surviveRules;
    }

    public Boolean[] getBornRules() {
        return bornRules;
    }

    public void setBornRules(Boolean[] bornRules) {
        this.bornRules = bornRules;
    }

    public Boolean[] getSurviveRules() {
        return surviveRules;
    }

    public void setSurviveRules(Boolean[] surviveRules) {
        this.bornRules = surviveRules;
    }
}
