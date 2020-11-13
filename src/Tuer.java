public class Tuer{

    // Anfang Attribute
    public String name;
    public boolean open;

    // Ende Attribute

    public Tuer(String name, boolean open)
    {
        this.name = name;
        this.open = open;
    }

    // Anfang Methoden
    public String getName() {
        return name;
    }

    public void setName(String nameNeu) {
        name = nameNeu;
    }

    public boolean isLocked()
    {
        if (!open) {
            System.out.println("Die Tür ist abgeschlossen. Es wird ein Schlüssel benötigt!");
        }
        else {
            System.out.println("Die Tür ist nicht abgeschlossen. Möchtest du die Tür öffnen?");
        }
        return open;
    }

    public void lockDoor(boolean openNeu)
    {
        open = openNeu;
    }

    // Ende Methoden
} // end of Tuer
