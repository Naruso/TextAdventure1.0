import java.util.ArrayList;

public class Raum extends Objekt{

    // Anfang Attribute
    public int anzahlTueren;
    public int anzahlFenster;
    private Fenster fenster;
    private boolean bItem;
    private Gegenstand item;
    public boolean npc;
    private ArrayList<String> items = new ArrayList<>();
    // Ende Attribute

    public Raum (String name, int anzahlTueren, int anzahlFenster, boolean npc)
    {

        this.name = name;
        this.anzahlTueren = anzahlTueren;
        this.anzahlFenster = anzahlFenster;
        this.npc = npc;
    }

    public Raum(String name, int anzahlTueren, int anzahlFenster, boolean npc, Gegenstand item)
    {
        this.name = name;
        this.anzahlTueren = anzahlTueren;
        this.anzahlFenster = anzahlFenster;
        this.npc = npc;
        this.items.add(item.getName());
    }

    public Raum(String name, int anzahlTueren, int anzahlFenster, boolean npc, Gegenstand item, Fenster fenster)
    {
        this.name = name;
        this.anzahlTueren = anzahlTueren;
        this.anzahlFenster = anzahlFenster;
        this.npc = npc;
        this.items.add(item.getName());
        this.items.add(fenster.getName());
    }
    public Raum(String name, int anzahlTueren, int anzahlFenster, boolean npc, Gegenstand item, Fenster fenster1, Fenster fenster2)
    {
        this.name = name;
        this.anzahlTueren = anzahlTueren;
        this.anzahlFenster = anzahlFenster;
        this.npc = npc;
        this.items.add(item.getName());
        this.items.add(fenster1.getName());
        this.items.add(fenster2.getName());
    }
    public Raum()
    {

    };
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
    public ArrayList<String> getItems() {
        return items;
    }




    // Ende Methoden
} // end of Raum
