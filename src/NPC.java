public class NPC {

    // Anfang Attribute
    private String name;
    public boolean loot;
    public int healthPoints;
    public int damage;
    // Ende Attribute

    // Anfang Konstruktor

    public NPC (String name, boolean loot, int healthPoints, int damage)
    {
        this.name = name;
        this.loot = loot;
        this.healthPoints = healthPoints;
        this.damage = damage;
    }

    // Ende Konstruktor

    // Anfang Methoden
    public String getName() {
        return name;
    }

    public boolean getLoot() {
        return loot;
    }

    public void setLoot(boolean lootNeu) {
        loot = lootNeu;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPointsNeu) {
        healthPoints = healthPointsNeu;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damageNeu) {
        damage = damageNeu;
    }

    // Ende Methoden
} // end of NPC
