import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Anwendung {

    boolean won = false;
    boolean lost = false;
    static Scanner scanner = new Scanner(System.in);

    //Spielercharakter wird erstellt
    static Character spieler = new Character(null, 100, "Gude sagen");

    //Generiere NPCs
    public static NPC nPC1 = new NPC("Schulleiter", false, 500, 30);
    NPC nPC2 = new NPC("Brühne", true, 100, 10);
    NPC nPC3 = new NPC("Person im Flur", true, 1, 0);

    //Gegenstände
    static Gegenstand iSmartphone = new Gegenstand("Smartphone", false, 0);
    static Gegenstand iTaschenlampe = new Gegenstand("Taschenlampe", true, 5);
    static Gegenstand iLosesKabel = new Gegenstand("loses Stromkabel", false, 100);
    static Gegenstand iLehrerPult = new Gegenstand("Lehrerpult", false, 0);
    static Gegenstand iDeckenplatte = new Gegenstand("Deckenplatte", true, 0);
    static Gegenstand iSchluesselR107 = new Gegenstand("Key107", true, 0);
    static Gegenstand item3 = new Gegenstand("keine Gegenstände", false, 0);
    static Gegenstand item4 = new Gegenstand("Legendärer Feuerlöscher", true, 170);

    //Fenster
    //Fenster im ersten Raum
    static Fenster fensterRaum107 = new Fenster("Fenster rechts", true);
    static Fenster fenster2Raum107 = new Fenster("Fenster links", false);
    static Fenster fensterRaum108 = new Fenster("Fenster", true);

    //Türen
    //Türen im ersten Raum III-107
    static Tuer tuerLinks = new Tuer("Tür links", true);
    static Tuer tuerRechts = new Tuer("Tür rechts", false);
    static Tuer tuerRaum108 = new Tuer("Tür rechts", false);
    //Türen im zweiten Raum III-108
    static Tuer tuer3 = new Tuer("hintere Tür", false);

    //Räume
    static Raum raum108 = new Raum("Raum III-108", 2, 1, false, iTaschenlampe, iLosesKabel, iLehrerPult, iDeckenplatte, iSchluesselR107, fensterRaum108, tuerLinks, tuerRaum108);
    static Raum raum107 = new Raum("Raum III-107", 2, 1, false, iSmartphone, fensterRaum107, fenster2Raum107, tuerRechts, tuerLinks);
    static Raum flur = new Raum("Flur", 5, 0, true, item3, tuerRechts);

    static Raum gang = new Raum("Gang", 7, 0, false, item4);
    //Raum raum2OG = new Raum("Raum 2.OG", 1, 1, true, item5);


    //Initialisierung der Klassen abgeschlossen


    public static void main(String[] args) {

        System.out.println("Gude und willkommen bei unserem Text Adventure. ");
        System.out.println("Gib start ein um das Spiel zu starten oder Exit um das Spiel zu verlassen.");
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
        spieler.setName(eingabeName);

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
        System.out.println("Du wachst mitten in der Nacht im Klassenraum " + raum107.getName() + " auf.");
        System.out.println("Du kannst dich nur noch an den Abendunterricht erinnern...");
        System.out.println("");
        raum107();
    }


    //Erster Raum
    public static void raum107() {
        String sLook;

        do {
            System.out.println("Was möchtest du tun? Schreibe  look  um dich umzusehen...");
            sLook = scanner.nextLine().toLowerCase();
        }
        while (!sLook.equals("look"));
        System.out.println("");
        System.out.println("Folgende Objekte befinden sich im Raum: " + raum107.getItems());
        System.out.println("");
        System.out.println("Gebe  pick  ein um einen Gegendstand zu nehmen");
        System.out.println("go  um dich im Raum zum Beispiel zu Türen oder Fenstern zu bewegen");
        System.out.println("oder use um Gegenstände in deinem Inventar zu benutzen.");
        String sPickorGo;
        sPickorGo = scanner.nextLine().toLowerCase();

        while (true) {
            if (sPickorGo.equals("pick smartphone")) {
                System.out.println();
                spieler.pickItem(iSmartphone);
                raum107.removeItems(0);
                System.out.println("Du hast " + iSmartphone.getName() + " in dein Inventar gepackt!");
                System.out.println();
                System.out.println("Was willst du als nächstes tun?");
                sPickorGo = scanner.nextLine().toLowerCase();
            } else if (sPickorGo.equals("go tür rechts")) {
                System.out.println("");
                tuerRechts.isLocked();
                System.out.println();
                if (spieler.items.contains("Key107")) {
                    System.out.println("Du versuchst ob der gefundene Schlüssel passt.....");
                    System.out.println("Der Schlüssel passt, du kannst die Tür aufschließen und gehst hindurch.");
                    System.out.println();
                    spieler.move(flur);
                    flur();
                } else {
                    System.out.println("Was willst du als nächstes tun?");
                    sPickorGo = scanner.nextLine().toLowerCase();
                    //continue;
                }
            } else if (sPickorGo.equals("go tür links")) {
                System.out.println("");
                System.out.println("Die Tür ist offen und du gehst hindurch.");
                spieler.move(raum108);
                System.out.println("");
                raum108();
            } else if (sPickorGo.equals("go fenster rechts")) {
                System.out.println();
                System.out.println("Du bist aus dem offenen Fenster gesprungen und hast dir alle Knochen gebrochen. Toll gemacht!");
                spieler.setHealthPoints(0);
            } else if (sPickorGo.equals("go fenster links")) {
                System.out.println();
                System.out.println("Du bist aus dem offenen Fenster gesprungen und hast dir alle Knochen gebrochen. Toll gemacht!");
                spieler.setHealthPoints(0);
            } else {
                System.out.println();
                System.out.println("falsche Eingabe....");
                System.out.println();
                System.out.println("Was willst du als nächstes tun?");
                sPickorGo = scanner.nextLine().toLowerCase();
            }
        }//end of while Schleife
    }




    public static void raum108() {
        String sLook2;

        do {
            System.out.println("Was möchtest du tun? Schreibe  look  um dich umzusehen...");
            sLook2 = scanner.nextLine().toLowerCase();
        }
        while (!sLook2.equals("look"));
        System.out.println("");
        System.out.println("Folgende Objekte befinden sich im Raum: " + raum108.getItems());
        System.out.println("");
        System.out.println("Gebe  pick  ein um einen Gegendstand aufzunehmen");
        System.out.println("go  um dich im Raum zum Beispiel zu Türen oder Fenstern zu bewegen");
        System.out.println("oder use um Gegenstände in deinem Inventar zu benutzen.");
        String sPickorGo;
        sPickorGo = scanner.nextLine().toLowerCase();
        while (true) {
            if (sPickorGo.equals("pick taschenlampe")) {
                System.out.println();
                System.out.println("Schau doch mal auf dem Lehrerpult nach, vielleicht liegt die Taschenlampe da.");
                System.out.println();
                System.out.println("Was willst du als nächstes tun?");
                sPickorGo = scanner.nextLine().toLowerCase();
                //continue;
            } else if (sPickorGo.equals("go loses stromkabel")) {
                System.out.println();
                int actualDamage = (int) (Math.random() * iLosesKabel.damage);
                int newHP = spieler.getHealthPoints() - actualDamage;
                spieler.setHealthPoints(newHP);
                if (spieler.getHealthPoints() <= 0) {
                    System.out.println("Du hast einen Stromschlag bekommen und bist gestorben. Toll gemacht!");
                } else {
                    System.out.println("Was willst du als nächstes tun?");
                    sPickorGo = scanner.nextLine();

                }
            } else if (sPickorGo.equals("go lehrerpult")) {
                System.out.println();
                System.out.println("Auf dem Lehrerpult liegt eine Taschenlampe und einige Dokumente.");
                System.out.println("Gib pick ein um die Taschenlampe aufzunehmen!");
                sPickorGo = scanner.nextLine().toLowerCase();
                if (sPickorGo.equals("pick")) {
                    spieler.pickItem(iTaschenlampe);
                    raum108.removeItems(0);
                    System.out.println("Du hast " + iTaschenlampe.getName() + " in dein Inventar gepackt!");
                } else {
                    System.out.println();
                    System.out.println("Okay dann eben keine Taschenlampe für dich.");
                }
                System.out.println();
                System.out.println("Was willst du als nächstes tun?");
                System.out.println(raum108.getItems());
                sPickorGo = scanner.nextLine().toLowerCase();
                //continue;
            } else if (sPickorGo.equals("go deckenplatte")) {
                System.out.println();
                System.out.println("Die Deckenplatte scheint lose zu sein. Du versuchst sie anzuheben und rauszunhemen.");
                System.out.println("...");
                System.out.println("Dir fällt ein Schlüssel entgegen. Wofür der nur ist?");
                System.out.println("Gib pick ein um den Schlüssel aufzunehmen!");
                sPickorGo = scanner.nextLine().toLowerCase();
                if (sPickorGo.equals("pick")) {
                    spieler.pickItem(iSchluesselR107);
                    raum108.removeItems(4);
                    System.out.println("Du hast " + iSchluesselR107.getName() + " in dein Inventar gepackt!");
                } else {
                    System.out.println();
                    System.out.println("Okay... ich hätte den Schlüssel lieber genommen. Vielleicht passt er in irgendeine Tür.");
                }
                System.out.println();
                System.out.println("Was willst du als nächstes tun?");
                sPickorGo = scanner.nextLine().toLowerCase();

            } else if (sPickorGo.equals("pick schlüssel für raum-107")) {
                System.out.println();
                System.out.println("Du weißt noch nicht wo der Schlüssel sein könnte.");
                System.out.println("Was willst du als nächstes tun?");
                System.out.println();
                sPickorGo = scanner.nextLine().toLowerCase();

            } else if (sPickorGo.equals("go fenster")) {
                System.out.println();
                System.out.println("Das Fenster ist geschlossen");
                System.out.println("Hier kommst du nicht raus! Was willst du als nächstes tun?");
                System.out.println();
                sPickorGo = scanner.nextLine().toLowerCase();

            } else if (sPickorGo.equals("go tür links")) {
                System.out.println();
                System.out.println("Du gehst wieder zurück in Raum III-107.");
                System.out.println();
                spieler.move(raum107);
                raum107();
            } else if (sPickorGo.equals("go tür rechts")) {
                System.out.println();
                System.out.println("Die Tür ist geschlossen");
                System.out.println();
                System.out.println("Hier kommst du nicht raus! Was willst du als nächstes tun?");
                sPickorGo = scanner.nextLine().toLowerCase();
            } else if (sPickorGo.equals("look")) {
                System.out.println("");
                System.out.println("Folgende Objekte befinden sich im Raum: " + raum108.getItems());
                System.out.println("");
                System.out.println("Gebe  pick  ein um einen Gegendstand aufzunehmen");
                System.out.println("go  um dich im Raum zum Beispiel zu Türen oder Fenstern zu bewegen");
                System.out.println("oder use um Gegenstände in deinem Inventar zu benutzen.");
                sPickorGo = scanner.nextLine().toLowerCase();
                if (sPickorGo.equals("go lehrerpult") && raum108.getItems().contains("Taschenlampe")) {
                    System.out.println();
                    System.out.println("Auf dem Lehrerpult liegt eine Taschenlampe und einige Dokumente.");
                    System.out.println("Gib pick ein um die Taschenlampe aufzunehmen!");
                    sPickorGo = scanner.nextLine().toLowerCase();
                    if (sPickorGo.equals("pick")) {
                        spieler.pickItem(iTaschenlampe);
                        raum108.removeItems(0);
                        System.out.println("Du hast " + iTaschenlampe.getName() + " in dein Inventar gepackt!");
                    }

                }
                else{
                    System.out.println();
                    System.out.println("Auf dem Lehrerpult liegen einige Dokumente.");
                    sPickorGo = scanner.nextLine().toLowerCase();
                }
            } else {
                System.out.println();
                System.out.println("falsche Eingabe....");
                System.out.println();
                System.out.println("Was willst du als nächstes tun?");
                sPickorGo = scanner.nextLine().toLowerCase();
            }
        }//end of while Schleife

    }//end of room108

    public static void flur() {
        String sLook3;
        if (spieler.hasItem(iTaschenlampe)) {

            System.out.println("Der Flur ist stockdunkel und du siehst nichts. Schreibe use um die Taschenlampe zu benutzen!");
            sLook3 = scanner.nextLine();
            if (sLook3.equals("use")) {
                System.out.println();
                System.out.println("Du benutzt deine Taschenlampe und kannst jemanden am Ende des Flurs erkennen.");
                System.out.println();
            }

        } else {
            System.out.println("Ohne die Taschenlampe kommst du nicht weit!");
            System.out.println("Du solltest die Taschenlampe im Raum-108 finden.");
            System.out.println("Was willst du tun?");
            sLook3 = scanner.nextLine();
            if (sLook3.equals("go tür rechts")) {
                spieler.move(raum107);
                raum107();
            } else {
                System.out.println("Du stolperst und brichst dir das Genick!");
                spieler.setHealthPoints(0);

            }
        }
        do {
            System.out.println("Was möchtest du tun? Schreibe  look  um dich umzusehen...");
            sLook3 = scanner.nextLine().toLowerCase();
        }
        while (!sLook3.equals("look"));
        System.out.println("");
        System.out.println("Folgende Objekte befinden sich im Raum: " + flur.getItems());
        System.out.println("");
        System.out.println("Geb   go ein um dich im Raum zum Beispiel zu Türen oder Fenstern zu bewegen");
        System.out.println("oder use ein um Gegenstände in deinem Inventar zu benutzen.");
        System.out.println("Du siehst nichts.");
        System.out.println("Was willst du tun?.");
        String sPickorGo;
        sPickorGo = scanner.nextLine().toLowerCase();

        while (true) {
            if (sPickorGo.equals("use taschenlampe")) {
                System.out.println();
                System.out.println("Du benutzt deine Taschenlampe und kannst jemanden am Ende des Flurs erkennen.");
                System.out.println();
                System.out.println("Was willst du als nächstes tun?");
                sPickorGo = scanner.nextLine().toLowerCase();
                continue;
            }
            else {
                System.out.println("Wie wäre es denn mit der Idee die Taschenlampe zu benutzen?");
                System.out.println();
                System.out.println("Was willst du als nächstes tun?");
                sPickorGo = scanner.nextLine().toLowerCase();
                continue;
            }
        }

    }

    //gude test bitte ignorieren danke


}// end of class TextAdventure