public class Fenster {

    // Anfang Attribute
    public String name;
    public boolean offen;
    // Ende Attribute

    //Anfang Konstruktor

    public Fenster(String name, boolean offen)
    {
        this.name = name;
        this.offen = offen;
    }



    // Anfang Methoden
    public String getName() {
        return name;
    }

    public void setName(String nameNeu) {
        name = nameNeu;
    }

    public boolean getOffen() {
        return offen;
    }

    public void setOffen(boolean offenNeu) {
        offen = offenNeu;
    }

    // Ende Methoden
} // end of Fenster
