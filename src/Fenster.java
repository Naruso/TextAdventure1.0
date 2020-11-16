public class Fenster extends Objekt{

    // Anfang Attribute
    private boolean offen;
    // Ende Attribute

    //Anfang Konstruktor

    public Fenster(String name, boolean offen)
    {
        this.name = name;
        this.offen = offen;
    }
    //Ende Konstruktor

    // Anfang Methoden
    public boolean getOffen() {
        return offen;
    }

    public void setOffen(boolean offenNeu) {
        offen = offenNeu;
    }

    // Ende Methoden
} // end of Fenster
