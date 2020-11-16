public class Gegenstand extends Objekt{

    // Anfang Attribute
    public boolean benutzbar;
    public int damage;
    // Ende Attribute

    // Anfang Methoden
    public Gegenstand(String name, boolean benutzbar, int damage)
    {
        this.name = name;
        this.benutzbar = benutzbar;
        this.damage = damage;
    }
    public boolean getBenutzbar() {
        return benutzbar;
    }

    public void setBenutzbar(boolean benutzbarNeu) {
        benutzbar = benutzbarNeu;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damageNeu) {
        damage = damageNeu;
    }

    public String ToString()
    {
        return getName() + getBenutzbar() + getDamage();
    }


    // Ende Methoden
} // end of Gegenstand
