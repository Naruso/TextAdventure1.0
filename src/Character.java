public class Character {

    // Anfang Attribute
    public String name;
    public int healthPoints;
    public int inventar;
    public String ability;
    // Ende Attribute

    public Character (String name, int healthPoints, int inventar, String ability)
    {
        this.name = name;
        this.healthPoints = healthPoints;
        this.inventar= inventar;
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

    public void setHealthPoints(int healthPointsNeu) {
        healthPoints = healthPointsNeu;
    }

    public int getInventar() {
        return inventar;
    }

    public void setInventar(int inventarNeu) {
        inventar = inventarNeu;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String abilityNeu) {
        ability = abilityNeu;
    }

    // Ende Methoden
} // end of Character
