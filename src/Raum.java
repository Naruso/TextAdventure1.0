public class Raum {

    // Anfang Attribute
    public String name;
    public int anzahlTueren;
    public int anzahlFenster;
    public boolean npc;
    // Ende Attribute

    public Raum (String name, int anzahlTueren, int anzahlFenster, boolean npc)
    {
        this.name = name;
        this.anzahlTueren = anzahlTueren;
        this.anzahlFenster = anzahlFenster;
        this.npc = npc;
    }
    // Anfang Methoden
    public String getName() {
        return name;
    }

    public void setName(String nameNeu) {
        name = nameNeu;
    }

    public int getAnzahlTueren() {
        return anzahlTueren;
    }

    public void setAnzahlTueren(int anzahlTuerenNeu) {
        anzahlTueren = anzahlTuerenNeu;
    }

    public int getAnzahlFenster() {
        return anzahlFenster;
    }

    public void setAnzahlFenster(int anzahlFensterNeu) {
        anzahlFenster = anzahlFensterNeu;
    }

    public boolean getNpc() {
        return npc;
    }

    public void setNpc(boolean npcNeu) {
        npc = npcNeu;
    }

    // Ende Methoden
} // end of Raum
