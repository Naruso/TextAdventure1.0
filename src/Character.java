import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Character extends Objekt {

    // Anfang Attribute
    private int healthPoints;
    public String ability;
    public Raum standort;
    public ArrayList<String> items = new ArrayList<>();

    // Ende Attribute

    public Character (String name, int healthPoints , String ability)
    {
        this.name = name;
        this.healthPoints = healthPoints;;
        this.ability = ability;
    }

    // Anfang Methoden
    public String getName() {
        return name;
    }

    public void setName(String nameNeu) {
        name = nameNeu;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPointsNeu)

    {
        healthPoints = healthPointsNeu;
        if (healthPoints == 0) {
            System.out.println("");
            System.out.println("Du bist Tod!");
            System.exit(0);
        }
    }

    /*public int getInventar() {
        return inventar;
    }
    public void setInventar(int inventarNeu) {
        inventar = inventarNeu;
    }*/

    public String getAbility() {
        return ability;
    }

    public void setAbility(String abilityNeu) {
        ability = abilityNeu;
    }
    public void getInventory()
    {
        System.out.println(items.toString());
    }
    public boolean pickItem(Gegenstand item)
    {
        if (item != null)
        {
            items.add(item.getName());
            System.out.println("Du hast das Item " + item.getName() + " erhalten.");
            return true;
        }
        else
        {
            return false;
        }
    }

    public void move(Raum zielRaum)
    {
        standort = zielRaum;
        System.out.println("Du befindest dich nun im " + standort.getName() + ".");
    }


    // Ende Methoden
} // end of Character