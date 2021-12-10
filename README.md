# Conway Game of Life

Arthur Lashermes
Mathis Ribémont



J'ai commencé le modèle(j'ai fait qql méthode qui seront utile), on pourra le continuer et le tester.

notes sur le databinding en java :

private StringProperty toto = newSimpleStringProperty();

public String getToto{return toto.get();}
public void setToto(String valeur){toto.set(valeur)}

accèsseur -> public ReadOnlyStringProperty totoProperty(){return toto;}

objet.propriété().bind(object2.property());

<Button text="${object.prop}"/>