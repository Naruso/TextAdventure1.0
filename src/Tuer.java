public class Tuer extends Objekt{

    // Anfang Attribute
    private boolean open;

    // Ende Attribute

    //Anfang Konstruktor
    public Tuer(String name, boolean open)
    {
        this.name = name;
        this.open = open;
    }
    //Ende Konstruktor

    // Anfang Methoden
    public void isLocked()
    {
        if (!open) {
            System.out.println("Die Tür ist abgeschlossen. Es wird ein Schlüssel benötigt!");

        }
        else {
            System.out.println("Die Tür ist nicht abgeschlossen. Möchtest du die Tür öffnen?");
        }
    }

    public void lockDoor(boolean openNeu)
    {
        open = openNeu;
    }

    // Ende Methoden
} // end of Tuer
