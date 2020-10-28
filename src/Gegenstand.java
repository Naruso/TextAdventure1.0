public class Gegenstand {

    // Anfang Attribute
    public String name;
    public boolean benutzbar;
    public int damage;
    // Ende Attribute

    public Gegenstand(String name, boolean benutzbar, int damage)
    {
        this.name = name;
        this.benutzbar = benutzbar;
        this.damage = damage;
    }
    // Anfang Methoden
    public String getName() {
        return name;
    }

    public void setName(String nameNeu) {
        name = nameNeu;
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

    // Ende Methoden
} // end of Gegenstand
