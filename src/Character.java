import java.util.ArrayList;

public class Character extends Objekt {

    // Anfang Attribute
    public String ability;
    public Raum standort;
    private boolean _hasItem = false;
    public ArrayList<String> items = new ArrayList<>();
    // Ende Attribute

    public Character (String name, int healthPoints , String ability)
    {
        this.name = name;
        this.healthPoints = healthPoints;
        this.ability = ability;
    }

    // Anfang Methoden

    /*public int getHealthPoints() {
        return healthPoints;
    }*/

    public void setHealthPoints(int healthPointsNeu)
    {
        healthPoints = healthPointsNeu;
        if (healthPoints <= 0)
        {
            System.out.println("Du bist Tod!");
            System.exit(0);
        }
        else
        {
            System.out.println("Du hast " + healthPoints +" HP übrig. Pass besser auf!");
        }
    }

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
        System.out.println();
        System.out.println("Du befindest dich nun im " + standort.getName() + ".");
    }
    public boolean hasItem(Gegenstand item)
    {
        _hasItem = items.contains(item.name);
        return _hasItem;
    }
    public void useItem(Gegenstand item)
    {
        if (items.contains(item.name)) {
            _hasItem = true;
            System.out.println("Du benutzt " + item + "!");
        }
        else {
            System.out.println("Du kannst nicht etwas benutzen, was du nicht hast!");
        }
    }


    // Ende Methoden
} // end of Character
