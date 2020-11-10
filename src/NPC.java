public class NPC extends Objekt {

    // Anfang Attribute
    public boolean loot;
    public int healthPoints;
    public int damage;
    public boolean isDead = false;
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
        if (healthPoints <= 0)
        {
            System.out.println("Du hast " + name + " besiegt!");
        }
        else
        {
            System.out.println(healthPoints +" HP übrig. Was willst du tun?");
        }
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damageNeu) {
        damage = damageNeu;
    }


    public void Says(String text)
    {
        System.out.println(text);
    }

    // Ende Methoden
} // end of NPC
