public class Objekt {
    //Anfang Attribute
    public String name;
    public int healthPoints;
    //Ende Attribute

    //Anfang Methoden
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
        this.healthPoints = healthPointsNeu;
    }
    //Ende Methoden
}
