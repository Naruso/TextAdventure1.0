import java.util.ArrayList;

public class Raum extends Objekt{

    // Anfang Attribute
    public int anzahlTueren;
    public int anzahlFenster;
    public boolean npc;
    private ArrayList<String> items = new ArrayList<>();
    // Ende Attribute

    //Anfang Konstruktor
   /* public Raum (String name, int anzahlTueren, int anzahlFenster, boolean npc)
    {

        this.name = name;
        this.anzahlTueren = anzahlTueren;
        this.anzahlFenster = anzahlFenster;
        this.npc = npc;
    }*/

    /*public Raum(String name, int anzahlTueren, int anzahlFenster, boolean npc, Gegenstand item)
    {
        this.name = name;
        this.anzahlTueren = anzahlTueren;
        this.anzahlFenster = anzahlFenster;
        this.npc = npc;
        this.items.add(item.getName());
    }*/

    public Raum(String name, int anzahlTueren, int anzahlFenster, boolean npc, Tuer object1, Tuer object2)
    {
        this.name = name;
        this.anzahlTueren = anzahlTueren;
        this.anzahlFenster = anzahlFenster;
        this.npc = npc;
        this.items.add(object1.getName());
        this.items.add(object2.getName());
    }
   /* public Raum(String name, int anzahlTueren, int anzahlFenster, boolean npc, Gegenstand item, Fenster fenster1, Fenster fenster2)
    {
        this.name = name;
        this.anzahlTueren = anzahlTueren;
        this.anzahlFenster = anzahlFenster;
        this.npc = npc;
        this.items.add(item.getName());
        this.items.add(fenster1.getName());
        this.items.add(fenster2.getName());
    }*/
    /*public Raum(String name, int anzahlTueren, int anzahlFenster, boolean npc, Gegenstand item, Fenster fenster1, Fenster fenster2, Tuer tuer1)
    {
        this.name = name;
        this.anzahlTueren = anzahlTueren;
        this.anzahlFenster = anzahlFenster;
        this.npc = npc;
        this.items.add(item.getName());
        this.items.add(fenster1.getName());
        this.items.add(fenster2.getName());
        this.items.add(tuer1.getName());
    }*/
    /*public Raum(String name, int anzahlTueren, int anzahlFenster, boolean npc, Gegenstand item, Tuer tuer1)
    {
        this.name = name;
        this.anzahlTueren = anzahlTueren;
        this.anzahlFenster = anzahlFenster;
        this.npc = npc;
        this.items.add(item.getName());
        this.items.add(tuer1.getName());
    }*/
    public Raum(String name, int anzahlTueren, int anzahlFenster, boolean npc, Tuer object1, Tuer object2, NPC npcPlaceHolder)
    {
        this.name = name;
        this.anzahlTueren = anzahlTueren;
        this.anzahlFenster = anzahlFenster;
        this.npc = npc;
        this.items.add(npcPlaceHolder.getName());
        this.items.add(object1.getName());
        this.items.add(object2.getName());
    }
    public Raum(String name, int anzahlTueren, int anzahlFenster, boolean npc, Tuer object, NPC npcPlaceHolder)
    {
        this.name = name;
        this.anzahlTueren = anzahlTueren;
        this.anzahlFenster = anzahlFenster;
        this.npc = npc;
        this.items.add(npcPlaceHolder.getName());
        this.items.add(object.getName());
    }
    public Raum(String name, int anzahlTueren, int anzahlFenster, boolean npc, Tuer object1, Tuer object2, Tuer object3, NPC npcPlaceHolder)
    {
        this.name = name;
        this.anzahlTueren = anzahlTueren;
        this.anzahlFenster = anzahlFenster;
        this.npc = npc;
        this.items.add(npcPlaceHolder.getName());
        this.items.add(object1.getName());
        this.items.add(object2.getName());
        this.items.add(object3.getName());
    }
    public Raum(String name, int anzahlTueren, int anzahlFenster, boolean npc, Gegenstand item, Fenster fObject1, Fenster fObject2, Tuer object1, Tuer object2)
    {
        this.name = name;
        this.anzahlTueren = anzahlTueren;
        this.anzahlFenster = anzahlFenster;
        this.npc = npc;
        this.items.add(item.getName());
        this.items.add(fObject1.getName());
        this.items.add(fObject2.getName());
        this.items.add(object1.getName());
        this.items.add(object2.getName());
    }
    public Raum(String name, int anzahlTueren, int anzahlFenster, boolean npc, Gegenstand item1, Gegenstand item2, Gegenstand item3, Gegenstand item4, Gegenstand item5, Fenster fObject, Tuer object1, Tuer object2)
    {
        this.name = name;
        this.anzahlTueren = anzahlTueren;
        this.anzahlFenster = anzahlFenster;
        this.npc = npc;
        this.items.add(item1.getName());
        this.items.add(item2.getName());
        this.items.add(item3.getName());
        this.items.add(item4.getName());
        this.items.add(item5.getName());
        this.items.add(fObject.getName());
        this.items.add(object1.getName());
        this.items.add(object2.getName());
    }

    public Raum()
    {

    }
    //Ende Konstruktor

    // Anfang Methoden
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

    public ArrayList<String> removeItems(int i)
    {
        this.items.remove(i);
        return items;
    }




    // Ende Methoden
} // end of Raum
