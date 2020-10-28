import java.util.Scanner;

public class Anwendung {

    public static void main(String[] args) {

        System.out.println("Gude und willkommen bei unserem Text Adventure. ");
        System.out.println("Gib Start ein um das Spiel zu starten oder Exit um das Spiel zu verlassen.");

        Scanner scanner1 = new Scanner(System.in);
        String eingabeStart = scanner1.nextLine();


        //Warten auf Eingabe vom Benutzer zum Starten des Spiels
        if (eingabeStart.equals("Start")) {
            System.out.println("Spiel startet......");
        } else {
            System.exit(0);
        }

        System.out.println("Bitte Namen eingeben...");
        Scanner scanner2 = new Scanner(System.in);
        String eingabeName = scanner2.nextLine();


        System.out.println("Dein Name lautet: " + eingabeName + " Los gehts!");
        System.out.println("------------------------------------------------");
        System.out.println("------------------SPIELSTART--------------------");
        System.out.println("------------------------------------------------");







        //Spielercharakter erstellen
        Character Spieler = new Character(eingabeName, 100, 2, "Gude sagen");

        //NPCs
        NPC NPC1 = new NPC("Schulleiter", false, 500, 30);
        NPC NPC2 = new NPC("Brühne", true, 100, 10);
        NPC NPC3 = new NPC("Person im Flur", true, 1, 0);

        //Gegenstände
        Gegenstand Item1 = new Gegenstand("Smartphone", false, 0);
        Gegenstand Item2 = new Gegenstand("Taschenlampe", true, 5);
        Gegenstand Item3 = new Gegenstand("Schlüssel für Raum III-107", true, 0);
        Gegenstand Item4 = new Gegenstand("Legendärer Feuerlöscher", true, 170);
        //Fenster
        //Fenster im ersten Raum
        Fenster fenster1 = new Fenster("mehrere Fenster", true);

        //Türen
        //Türen im ersten Raum III-107
        Tuer tuer1 = new Tuer("Tür links", true);
        Tuer tuer2 = new Tuer("Tür rechts", false);
        //Türen im zweiten Raum III-108
        Tuer tuer3 = new Tuer("hintere Tür", false);

        //Räume
        Raum Raum1 = new Raum("Raum III-107", 2, 1, false);
        Raum Raum2 = new Raum("Raum III-108", 2, 1, false);
        Raum Raum3 = new Raum("Flur", 5, 0, true);
        Raum Raum4 = new Raum("Gang", 7, 0, false);
        Raum Raum5 = new Raum("Raum 2.OG", 1, 1, true);


        System.out.println(Spieler.getName());
        System.out.println(fenster1.getOffen());
        System.out.println(tuer1.getName());
        System.out.println(tuer1.getOffen());
        System.out.print(Item4.getName());
        System.out.print(" mit ");
        System.out.print(Item4.getDamage());
        System.out.print("Schaden!!1111!!1OMG");


    } // end of main

} // end of class TextAdventure
