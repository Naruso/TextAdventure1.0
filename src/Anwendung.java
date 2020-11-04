import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Anwendung {

    boolean won = false;
    boolean lost = false;
    //Generiere NPCs
    public static NPC nPC1 = new NPC("Schulleiter", false, 500, 30);
    NPC nPC2 = new NPC("Brühne", true, 100, 10);
    NPC nPC3 = new NPC("Person im Flur", true, 1, 0);

    public static void main(String[] args) {

        System.out.println("Gude und willkommen bei unserem Text Adventure. ");
        System.out.println("Gib start ein um das Spiel zu starten oder Exit um das Spiel zu verlassen.");

        Scanner scanner = new Scanner(System.in);
        String eingabeStart = scanner.nextLine().toLowerCase();


        //Warten auf Eingabe vom Benutzer zum Starten des Spiels
        if (eingabeStart.equals("Start".toLowerCase())) {
            System.out.println("Spiel startet...");
        } else {
            System.exit(0);
        }
        System.out.println("Bitte Namen eingeben...");
        System.out.println("");
        String eingabeName = scanner.nextLine();
        //Spielercharakter wird erstellt
        Character spieler = new Character(eingabeName, 100, "Gude sagen");
        System.out.println("");
        System.out.println("------------------------------------------------");
        System.out.println("-----------------CHARAKTER----------------------");
        System.out.println("------------------------------------------------");
        System.out.println("");
        System.out.println("Dein Name lautet: " + spieler.getName() + " Los gehts!");
        System.out.println("Health points: " + spieler.getHealthPoints());
        System.out.println("Inventory: ");
        System.out.println("Fähigkeit: " + spieler.getAbility());
        System.out.println("");
        System.out.println("------------------------------------------------");
        System.out.println("------------------SPIELSTART--------------------");
        System.out.println("------------------------------------------------");
        System.out.println("");


        //Gegenstände
        Gegenstand item1 = new Gegenstand("Smartphone", false, 0);
        Gegenstand iTaschenlampe = new Gegenstand("Taschenlampe", true, 5);
        Gegenstand iLosesKabel = new Gegenstand("Loses Stromkabel", false, 100);
        Gegenstand iLehrerPult = new Gegenstand("Lehrerpult", false, 0);
        Gegenstand iDeckenplatte = new Gegenstand("Deckenplatte", true, 0);
        Gegenstand iSchluesselR107 = new Gegenstand("Schlüssel für Raum-107", true, 0);
        Gegenstand item3 = new Gegenstand("Schlüssel für Raum III-107", true, 0);
        Gegenstand item4 = new Gegenstand("Legendärer Feuerlöscher", true, 170);

        //Fenster
        //Fenster im ersten Raum
        Fenster fensterRaum107 = new Fenster("Fenster rechts", true);
        Fenster fenster2Raum107 = new Fenster("Fenster links", false);
        Fenster fensterRaum108 = new Fenster("Fenster", true);


        //Türen
        //Türen im ersten Raum III-107
        Tuer tuerLinks = new Tuer("Tür links", true);
        Tuer tuerRechts = new Tuer("Tür rechts", false);
        Tuer tuerRaum108 = new Tuer("Tür rechts", false);
        //Türen im zweiten Raum III-108
        Tuer tuer3 = new Tuer("hintere Tür", false);

        //Räume
        Raum raum107 = new Raum("Raum III-107", 2, 1, false, item1, fensterRaum107, fenster2Raum107, tuerRechts, tuerLinks);
        Raum raum108 = new Raum("Raum III-108", 2, 1, false, iTaschenlampe, iLosesKabel, iLehrerPult, iDeckenplatte, iSchluesselR107, fensterRaum108, tuerLinks, tuerRaum108);
        Raum flur = new Raum("Flur", 5, 0, true, item3);
        Raum gang = new Raum("Gang", 7, 0, false, item4);
        //Raum raum2OG = new Raum("Raum 2.OG", 1, 1, true, item5);

        System.out.println("Du wachst mitten in der Nacht im Klassenraum " + raum107.getName() + " auf.");
        System.out.println("Du kannst dich nur noch an den Abendunterricht erinnern.");
        System.out.println("");
        String sLook;

        do {
            System.out.println("Was möchtest du tun? Schreibe  look  um dich umzusehen...");
            sLook = scanner.nextLine();
        }
        while (!sLook.equals("look"));
        System.out.println("");
        System.out.println("Folgende Objekte befinden sich im Raum: " + raum107.getItems());
        System.out.println("");
        System.out.println("Gebe  pick  ein um einen Gegendstand zu nehmen");
        System.out.println("oder  go  um mit einer Tür oder einem Fenster zu interagieren.");
        String sPickorGo;

        sPickorGo = scanner.nextLine();
        switch (sPickorGo) {
            case "pick smartphone":
                spieler.pickItem(item1);
                System.out.println("Du hast " + item1.getName() + " in dein Inventar gepackt!");
                if (spieler.items.contains("Smartphone")) {
                    System.out.println("Das Smartphone ist im Inventar");
                } else {
                    System.out.println("Du hast kein Smartphone du Knecht.");
                }
                break;
            case "go right door":
                System.out.println("");
                tuerRechts.isLocked();
                System.out.println("");
                break;
            case "go left door":
                System.out.println("");
                spieler.move(raum108);
                System.out.println("");
                break;
            case "go right fenster":
                System.out.println("Fenster rechts TEST");
                break;
            case "go left fenster":
                System.out.println("Fenster links TEST");
                break;
            default:
                System.out.println("");
                // while (sPickorGo.equals("pick smartphone") || !sPickorGo.equals("go right door") || !sPickorGo.equals("go left door") || !sPickorGo.equals("go right fenster") || !sPickorGo.equals("go left fenster"));
        }
                System.out.println("");
                System.out.println("Gebe show inventory ein um das Inventar zu öffnen");
                String sShowInventory = scanner.nextLine();

                if (sShowInventory.equals("show inventory".toLowerCase())) {
                    spieler.getInventory();
                }

                System.out.println("Was möchtest du tun? Schreibe  look  um dich umzusehen...");
                //TEST



    }// end of main

    public static void look(Gegenstand item)
    {
        System.out.println(item.getName());
    }

    public static void pick()
    {

    }

} // end of class TextAdventure
