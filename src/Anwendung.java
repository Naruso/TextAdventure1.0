import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Anwendung {

    boolean won = false;
    boolean lost = false;
    static Scanner scanner = new Scanner(System.in);
    static boolean roomChanged = false;

    //Spielercharakter wird erstellt
    static Character spieler = new Character(null, 100, "Gude sagen");

    //Generiere NPCs
    public static NPC npcSchulleiter = new NPC("Schulleiter", false, 500, 30);
    public static NPC npcUnbekanntePerson = new NPC("Unbekannte Person", false, 20, 10);
    public static NPC npcZombieSchulleiter = new NPC( "Zombier Schulleiter", false, 1000, 100);
    public static NPC npcBruehne = new NPC("Brühne", true, 100, 10);
    NPC nPC3 = new NPC("Person im Flur", true, 1, 0);

    //Gegenstände
    static Gegenstand iSmartphone = new Gegenstand("Smartphone", false, 0);
    static Gegenstand iTaschenlampe = new Gegenstand("Taschenlampe", true, 5);
    static Gegenstand iLosesKabel = new Gegenstand("loses Stromkabel", false, 100);
    static Gegenstand iLehrerPult = new Gegenstand("Lehrerpult", false, 0);
    static Gegenstand iDeckenplatte = new Gegenstand("Deckenplatte", true, 0);
    static Gegenstand iSchluesselR107 = new Gegenstand("Key107", true, 0);
    static Gegenstand item3 = new Gegenstand("keine Gegenstände", false, 0);
    static Gegenstand iLegendaererFeuerloescher = new Gegenstand("Legendärer Feuerlöscher", true, 170);

    //Fenster
    //Fenster im ersten Raum
    static Fenster fensterRaum107 = new Fenster("Fenster rechts", true);
    static Fenster fenster2Raum107 = new Fenster("Fenster links", false);
    static Fenster fensterRaum108 = new Fenster("Fenster", true);

    //Türen
    //Türen im ersten Raum III-107
    static Tuer tuerLinks107 = new Tuer("Tür 108", true);
    static Tuer tuerRechts107 = new Tuer("Tür Flur", false);
    //static Tuer tuerRaum108 = new Tuer("Tür rechts", false);

    //Türen im zweiten Raum III-108
    static Tuer tuerLinks108 = new Tuer("Tür 107", true);
    static Tuer tuerFlur = new Tuer("Tür hinten", false);

    //Türen und Treppen im Flur
    static Tuer tuerTreppeRunter = new Tuer ("Treppe links", true);
    static Tuer tuerZumFlur2 = new Tuer ("Flur rechts", true);

    //Türen und Treppen imr Flur rechts
    static Tuer tuerTreppe2OG = new Tuer ("Treppe hoch", true);
    static Tuer tuerTreppeEG = new Tuer ("Treppe runter", true);




    static Tuer tuerZumFoyer = new Tuer("hintere Tür", false);

    //Räume
    static Raum raum107 = new Raum("Raum III-107", 2, 2, false, iSmartphone, fensterRaum107, fenster2Raum107, tuerRechts107, tuerLinks107);
    static Raum raum108 = new Raum("Raum III-108", 2, 1, false, iTaschenlampe, iLosesKabel, iLehrerPult, iDeckenplatte, iSchluesselR107, fensterRaum108, tuerFlur, tuerLinks108);
    static Raum flur = new Raum("Flur", 5, 0, true, tuerZumFlur2, tuerTreppeRunter, npcUnbekanntePerson);
    static Raum treppe = new Raum( "Treppe links", 2, 0,true, tuerTreppeRunter, tuerZumFoyer, npcZombieSchulleiter );
    static Raum flurRechts = new Raum("rechten Flur", 0,0,false, tuerTreppe2OG,tuerTreppeEG);
    static Raum zweitesOG = new Raum("2. Obergeschoss", 4, 2, true, tuerZumFlur2, npcBruehne);
    //Raum raum2OG = new Raum("Raum 2.OG", 1, 1, true, item5);


    //Initialisierung der Klassen abgeschlossen


    public static void main(String[] args) {
        System.out.println();
        System.out.println("-----------------Text-Adventure-----------------");
        System.out.println("-------------------Akif & Tobi------------------");
        System.out.println("Hallo und willkommen bei unserem Text-Adventure. ");
        System.out.println("Gib >start< ein um das Spiel zu starten oder >exit< um das Spiel zu verlassen.");
        String eingabeStart = scanner.nextLine().toLowerCase();
        //Warten auf Eingabe vom Benutzer zum Starten des Spiels
        if (eingabeStart.equals("Start".toLowerCase())) {
            System.out.println("Spiel startet...");
            System.out.println();
            System.out.println("Räume werden geladen...");
        }
        else {
            System.exit(0);
        }
        System.out.println();
        System.out.println("------------------------------------------------");
        System.out.println("------------------------------------------------");
        System.out.println("------------------------------------------------");
        System.out.println();
        System.out.println("Bitte gib zuerst deinen Namen ein: ");
        String eingabeName = scanner.nextLine();
        spieler.setName(eingabeName);
        System.out.println();
        System.out.println("Alles klar! Los geht´s. ");

        System.out.println();
        System.out.println("------------------------------------------------");
        System.out.println("-----------------CHARAKTER----------------------");
        System.out.println("------------------------------------------------");
        System.out.println();
        System.out.println("Dein Name lautet: " + spieler.getName());
        System.out.println("Health points: " + spieler.getHealthPoints());
        System.out.println("Inventory: ");
        System.out.println("Fähigkeit: " + spieler.getAbility());
        System.out.println();
        System.out.println("------------------------------------------------");
        System.out.println("------------------SPIELSTART--------------------");
        System.out.println("------------------------------------------------");
        System.out.println();
        System.out.println("Du warst bewusstlos und kommst mitten in der Nacht im Klassenraum " + raum107.getName() + " wieder zu dir.");
        System.out.println("Dein Kopf tut weh und du weißt nicht was passiert ist. Das Einzige woran du dich erinnern kannst ist der Abendunterricht...");
        System.out.println();
        raum107();
    }


    //Erster Raum
    public static void raum107() {
        String sLook;

        do {
            System.out.println("Was möchtest du tun? Schreibe >look< um dich umzusehen...");
            sLook = scanner.nextLine().toLowerCase();
        }
        while (!sLook.equals("look"));
        System.out.println();
        System.out.println("Folgende Objekte befinden sich im Raum: " + raum107.getItems());
        System.out.println();
        System.out.println("Gib >pick< ein um einen Gegendstand zu nehmen,");
        System.out.println(">go< um dich im Raum zum Beispiel zu Türen oder Fenstern zu bewegen");
        System.out.println("oder >use< um Gegenstände in deinem Inventar zu benutzen.");
        System.out.println("Mit >show inventory< kannst du dir dein Inventar anzeigen lassen.");
        String sPickorGo;
        sPickorGo = scanner.nextLine().toLowerCase();

        while (true) {
            if (sPickorGo.equals("pick smartphone")) {
                System.out.println();
                //spieler.pickItemV2(iSmartphone);
                spieler.pickItem(iSmartphone);
                raum107.removeItems(0);
                System.out.println("Du hast " + iSmartphone.getName() + " in dein Inventar gepackt!");
                System.out.println();
                System.out.println("Was willst du als nächstes tun?");
                sPickorGo = scanner.nextLine().toLowerCase();
            }
            else if (sPickorGo.equals("go tür flur")) {
                System.out.println();
                tuerRechts107.isLocked();
                System.out.println();
                if (spieler.items.contains("Key107")) {
                    System.out.println("Du versuchst ob der gefundene Schlüssel passt.....");
                    System.out.println("Der Schlüssel passt, du kannst die Tür aufschließen und gehst hindurch.");
                    System.out.println("------------------------------------------------");
                    System.out.println("------------------------------------------------");
                    System.out.println("------------------------------------------------");
                    spieler.move(flur);
                    flur();
                } else {
                    System.out.println("Was willst du als nächstes tun?");
                    sPickorGo = scanner.nextLine().toLowerCase();
                    //continue;
                }
            }
            else if (sPickorGo.equals("go tür 108")) {
                System.out.println();
                System.out.println("Die Tür ist offen und du gehst hindurch.");
                System.out.println("------------------------------------------------");
                System.out.println("------------------------------------------------");
                System.out.println("------------------------------------------------");
                spieler.move(raum108);
                roomChanged = true;
                System.out.println();
                raum108();
            }
            else if (sPickorGo.equals("go fenster rechts")) {
                System.out.println();
                System.out.println("Du bist aus dem offenen Fenster gesprungen und hast dir alle Knochen gebrochen. Toll gemacht!");
                spieler.setHealthPoints(0);
            }
            else if (sPickorGo.equals("go fenster links")) {
                System.out.println();
                System.out.println("Du bist aus dem offenen Fenster gesprungen und hast dir alle Knochen gebrochen. Toll gemacht!");
                spieler.setHealthPoints(0);
            }
            else if(sPickorGo.equals("show inventory")){
                System.out.println();
                System.out.println("Inventar: "); spieler.getInventory();
                System.out.println();
                System.out.println("Was willst du als nächstes tun?");
                sPickorGo = scanner.nextLine();
                }
            else {
                System.out.println();
                System.out.println("falsche Eingabe....");
                System.out.println("Was willst du als nächstes tun?");
                sPickorGo = scanner.nextLine().toLowerCase();
            }
        }//end of while Schleife
    }

    public static void raum108() {
        String sPickorGo;
        do {
            System.out.println("Was möchtest du tun? Schreibe >look< um dich umzusehen.");
            sPickorGo = scanner.nextLine().toLowerCase();
        }
        while (!sPickorGo.equals("look"));
        System.out.println();
        System.out.println("Folgende Objekte befinden sich im Raum: " + raum108.getItems());
        System.out.println();
        System.out.println("Gib >pick< ein um einen Gegendstand zu nehmen,");
        System.out.println(">go< um dich im Raum zum Beispiel zu Türen oder Fenstern zu bewegen");
        System.out.println("oder >use< um Gegenstände in deinem Inventar zu benutzen.");
        System.out.println("Mit >show inventory< kannst du dir dein Inventar anzeigen lassen.");
       // String sPickorGo;
        sPickorGo = scanner.nextLine().toLowerCase();
        while (true) {
            if (sPickorGo.equals("pick taschenlampe")) {
                System.out.println();
                System.out.println("Schau doch mal auf dem Lehrerpult nach, vielleicht liegt die Taschenlampe da.");
                System.out.println("Was willst du als nächstes tun?");
                sPickorGo = scanner.nextLine().toLowerCase();
                //continue;
            }
            else if (sPickorGo.equals("pick loses stromkabel")) {
                System.out.println();
                int actualDamage = (int) (Math.random() * iLosesKabel.damage);
                System.out.println("Das Kabel scheint unter Strom zu stehen. Du hast einen Stromschlag bekommen.");
                int newHP = spieler.getHealthPoints() - actualDamage;
                spieler.setHealthPoints(newHP);
                if (spieler.getHealthPoints() <= 0) {
                    System.out.println("Du hast einen Stromschlag bekommen und bist gestorben. Toll gemacht!");
                } else {
                    System.out.println();
                    System.out.println("Was willst du als nächstes tun?");
                    sPickorGo = scanner.nextLine();
                }
            }
            else if (sPickorGo.equals("go lehrerpult")) {
                System.out.println();
                System.out.println("Auf dem Lehrerpult liegt eine Taschenlampe und einige Dokumente.");
                System.out.println("Gib >pick Taschenlampe< ein um die Taschenlampe aufzunehmen!");
                sPickorGo = scanner.nextLine().toLowerCase();
                if (sPickorGo.equals("pick taschenlampe")) {
                    //spieler.pickItemV2(iTaschenlampe);
                    System.out.println();
                    spieler.pickItem(iTaschenlampe);
                    raum108.removeItems(0);
                    System.out.println("Du hast " + iTaschenlampe.getName() + " in dein Inventar gepackt!");
                } else {
                    System.out.println();
                    System.out.println("Okay dann eben keine Taschenlampe für dich.");
                }
                System.out.println();
                System.out.println("Im Raum sind nun nur noch: ");
                System.out.print(raum108.getItems());
                System.out.println();
                System.out.println("Was willst du als nächstes tun?");
                sPickorGo = scanner.nextLine().toLowerCase();
                //continue;
            }
            else if (sPickorGo.equals("go deckenplatte")) {
                System.out.println();
                System.out.println("Die Deckenplatte scheint lose zu sein. Du versuchst sie anzuheben und rauszunhemen.");
                System.out.println("...");
                System.out.println("Dir fällt ein Schlüssel entgegen. Wofür der nur ist?");
                System.out.println("Gib >pick Schlüssel< ein um den Schlüssel aufzunehmen!");
                sPickorGo = scanner.nextLine().toLowerCase();
                if (sPickorGo.equals("pick schlüssel")) {
                    //spieler.pickItemV2(iSchluesselR107);
                    System.out.println();
                    spieler.pickItem(iSchluesselR107);
                    if (!raum108.getItems().contains("Taschenlampe")) {
                        raum108.removeItems(3);
                    }
                    else {
                        raum108.removeItems(4);
                    }
                    System.out.println("Du hast " + iSchluesselR107.getName() + " in dein Inventar gepackt!");
                }
                else {
                    System.out.println();
                    System.out.println("Okay... ich hätte den Schlüssel lieber genommen. Vielleicht passt er in irgendeine Tür.");
                }
                System.out.println();
                System.out.println("Im Raum sind nun nur noch: ");
                System.out.print(raum108.getItems());
                System.out.println();
                System.out.println("Was willst du als nächstes tun?");
                sPickorGo = scanner.nextLine().toLowerCase();

            }
            else if (sPickorGo.equals("pick key107")) {
                System.out.println();
                System.out.println("Du weißt noch nicht wo der Schlüssel sein könnte.");
                System.out.println("Was willst du als nächstes tun?");
                sPickorGo = scanner.nextLine().toLowerCase();
            }
            else if (sPickorGo.equals("go fenster")) {
                System.out.println();
                System.out.println("Das Fenster ist geschlossen.");
                System.out.println();
                System.out.println("Hier kommst du nicht raus! Was willst du als nächstes tun?");
                sPickorGo = scanner.nextLine().toLowerCase();

            }
            else if (sPickorGo.equals("go tür 107")) {
                System.out.println();
                System.out.println("Du gehst wieder zurück in Raum III-107.");
                System.out.println("------------------------------------------------");
                System.out.println("------------------------------------------------");
                System.out.println("------------------------------------------------");
                spieler.move(raum107);
                raum107();
            }
            else if (sPickorGo.equals("go tür hinten")) {
                System.out.println();
                System.out.println("Die Tür ist geschlossen.");
                System.out.println();
                System.out.println("Hier kommst du nicht raus! Was willst du als nächstes tun?");
                sPickorGo = scanner.nextLine().toLowerCase();
            }
            else if (sPickorGo.equals("look")) {
                System.out.println();
                System.out.println("Folgende Objekte befinden sich im Raum: " + raum108.getItems());
                System.out.println();
                System.out.println("Gib  pick  ein um einen Gegendstand aufzunehmen");
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
                else if (sPickorGo.equals("go tür links")) {
                    System.out.println();
                    System.out.println("Du gehst wieder zurück in Raum III-107.");
                    System.out.println();
                    spieler.move(raum107);
                    raum107();
                }
                else{
                    System.out.println();
                    System.out.println("Auf dem Lehrerpult liegen einige Dokumente.");
                    sPickorGo = scanner.nextLine().toLowerCase();
                }
            }
            else if(sPickorGo.equals("show inventory")){
                System.out.println();
                spieler.getInventory();
                System.out.println();
                System.out.println("Was willst du als nächstes tun?");
                sPickorGo = scanner.nextLine();
            }
            else {
                System.out.println();
                System.out.println("falsche Eingabe....");
                System.out.println("Was willst du als nächstes tun?");
                sPickorGo = scanner.nextLine().toLowerCase();
            }
        }//end of while Schleife
    }//end of room108

    public static void flur(){

        if (spieler.hasItem(iTaschenlampe)) {
            String sLook3;
            do {
                System.out.println();
                System.out.println("Im Flur ist es stockdunkel und du siehst nichts. Schreibe >use Taschenlampe< um die Taschenlampe anzuschalten.");
                sLook3 = scanner.nextLine().toLowerCase();
            }

            while (!sLook3.equals("use taschenlampe"));
                System.out.println();
                System.out.println("Du benutzt deine Taschenlampe und kannst jemanden am Ende des Flurs erkennen.");
        }
        else {
            System.out.println("Ohne die Taschenlampe kommst du hier nicht weit!");
            System.out.println("Du solltest zurück gehen und die Taschenlampe im Raum-108 finden.");
            System.out.println("------------------------------------------------");
            System.out.println("------------------------------------------------");
            System.out.println("------------------------------------------------");
            spieler.move(raum107);
            raum107();
            }
        String sLook4;
        do {
            System.out.println("Was möchtest du tun? Schreibe >look< um dich umzusehen...");
            sLook4 = scanner.nextLine().toLowerCase();
        }

        while (!sLook4.equals("look"));
        System.out.println();
        System.out.println("Folgende Objekte befinden sich im Raum: " + flur.getItems());
        System.out.println();
        System.out.println("Gib >go< ein um dich im Raum zum Beispiel zu Türen oder Fenstern zu bewegen");
        System.out.println("oder >use< ein um Gegenstände in deinem Inventar zu benutzen.");
        System.out.println("Was willst du tun?");
        String sPickorGo;
        sPickorGo = scanner.nextLine().toLowerCase();

        while (true) {
            if (sPickorGo.equals("go unbekannte person")) {
                System.out.println();
                npcUnbekanntePerson.Says("Hallo " + spieler.getName() + ",was gibt's?");
                System.out.println();
                System.out.println("Was willst du als nächstes tun? Gib >attack< ein, um die unbekannte Person anzugreifen");
                System.out.println("oder >talk<, um mit der Person zu reden.");
                sPickorGo = scanner.nextLine();
                if (sPickorGo.equals("attack")) {
                    while (!npcUnbekanntePerson.isDead) {
                        System.out.println();
                        int newHPNPC = npcUnbekanntePerson.getHealthPoints() - iTaschenlampe.damage;
                        npcUnbekanntePerson.setHealthPoints(newHPNPC);
                        int newHP = spieler.getHealthPoints() - npcUnbekanntePerson.getDamage();
                        spieler.setHealthPoints(newHP);
                        if (spieler.getHealthPoints() <= 0) {
                            System.out.println("Du hast den Kampf verloren und bist gestorben!");
                            System.exit(0);
                        }
                        if (npcUnbekanntePerson.getHealthPoints() <= 0) {
                            npcUnbekanntePerson.isDead = true;
                            System.out.println("Du hast den Kampf gewonnen. Was willst du als nächstes tun?");
                        }
                        else {
                            System.out.println();
                            System.out.println("Dein Gegner steht noch. Was willst du als nächstes tun?");
                        }

                    }
                }
                else {
                    npcUnbekanntePerson.Says("Nimm nicht die Treppe links runter. Sei gewarnt!!");
                }
                System.out.println();
                System.out.println("Was willst du als nächstes tun?");
                sPickorGo = scanner.nextLine().toLowerCase();
            }
            else if (sPickorGo.equals("go treppe links")) {
                System.out.println();
                System.out.println("Du bist nun im Treppenhaus.");
                System.out.println("------------------------------------------------");
                System.out.println("------------------------------------------------");
                System.out.println("------------------------------------------------");
                spieler.move(treppe);
                treppeLinks();
            }
            else if (sPickorGo.equals("go flur rechts")) {
                System.out.println();
                System.out.println("Du gehst den Flur weiter entlang und dann nach rechts...");
                System.out.println("------------------------------------------------");
                System.out.println("------------------------------------------------");
                System.out.println("------------------------------------------------");
                spieler.move(flurRechts);
                flurRechts();
            }
            else if(sPickorGo.equals("show inventory")){
                System.out.println();
                spieler.getInventory();
                System.out.println();
                System.out.println("Was willst du als nächstes tun?");
                sPickorGo = scanner.nextLine();
            }
            else {
                System.out.println();
                System.out.println("falsche Eingabe....");
                System.out.println("Was willst du als nächstes tun?");
                sPickorGo = scanner.nextLine().toLowerCase();
            }
        }
    }//end of flur

    public static void flurRechts() {
        System.out.println();
        System.out.println("Du siehst einen schwachen Mondschein am Ende des Ganges aufleuchten.");
        System.out.println("Du gehst den Flur entlang und bemerkst, dass alle Türen auf dem Weg verschlossen sind.");
        System.out.println("Du stehst im am Ende des Flurs in einem Treppenhaus.");
        String sPickorGo;
        do {
            System.out.println();
            System.out.println("Was willst du als nächstes machen?");
            System.out.println("Gib >look< ein, um dich umzusehen.");
            sPickorGo = scanner.nextLine().toLowerCase();
        }
        while (!sPickorGo.equals("look"));
        System.out.println();
        System.out.println("Folgende Objekte befinden sich im Raum: " + flurRechts.getItems());
        System.out.println();
        System.out.println("Gib >go Treppe hoch< oder >go Treppe runter< ein, um die Treppe entweder hoch oder runter zu gehen");
        sPickorGo = scanner.nextLine().toLowerCase();

        while (true) {
            if (sPickorGo.equals("go treppe hoch")) {
                System.out.println();
                System.out.println("Du nimmst die Treppe nach oben und triffst auf eine weitere unbekannte Person!");
                System.out.println("------------------------------------------------");
                System.out.println("------------------------------------------------");
                System.out.println("------------------------------------------------");
                spieler.move(zweitesOG);
                zweitesOG();
            }
            else if (sPickorGo.equals("go treppe runter")){
                System.out.println();
                System.out.println("Du gehst die Treppe runter und bemerkst, dass die Hintertür offen ist.");
                System.out.println("Die Tür lässt sich mit Leichtigkeit öffnen und du kannst entkommen, aber wirst nie erfahren was in der Schule passiert ist...");
                System.out.println();
                System.out.println("------------------------------------------------");
                System.out.println("---------------DU HAST ÜBERLEBT-----------------");
                System.out.println("------------------------------------------------");
                System.exit(0);
            }
            else {
                System.out.println();
                System.out.println("falsche Eingabe....");
                System.out.println("Was willst du als nächstes tun?");
                sPickorGo = scanner.nextLine().toLowerCase();
            }
        }
    }//end of flur rechts

    public static void treppeLinks()
    {
        System.out.println();
        System.out.println("Du kannst die Treppe hoch oder die Treppe runter gehen.");
        System.out.println("Gib >go Treppe hoch< oder >go Treppe runter< ein, um die Treppe entweder hoch oder runter zu gehen.");
        System.out.println("Mit >go Flur< kommst du wieder zurück in den Flur.");
        System.out.println();
        while (true) {
            String sPickorGo;
            sPickorGo = scanner.nextLine().toLowerCase();
            if (sPickorGo.equals("go treppe hoch")) {
                System.out.println();
                System.out.println("Die Treppe nach oben ist eingestürtzt. Du kommst hier nicht hoch.");
            }
            else if (sPickorGo.equals("go treppe runter")) {
                System.out.println();
                System.out.println("Der Zombie Schulleiter kommt aus dem Hinterhalt und überrascht dich von der Seite. Er greift dich an, ihr kämpft für einen kurzen Moment, aber du merkst dass er viel zu stark für dich ist.");
                spieler.setHealthPoints(0);
                System.exit(0);
            }
            else if (sPickorGo.equals("go flur")) {
                System.out.println();
                System.out.println("Du entscheidest dich dafür lieber wieder zurück zu gehen.");
                System.out.println("------------------------------------------------");
                System.out.println("------------------------------------------------");
                System.out.println("------------------------------------------------");
                spieler.move(flur);
                flur();
            }
            else {
                System.out.println();
                System.out.println("falsche Eingabe....");
                System.out.println("Was willst du als nächstes tun?");
                sPickorGo = scanner.nextLine().toLowerCase();
            }
        }
    }//end of treppe links

    public static void zweitesOG()
    {
        String sPickorGo;
        System.out.println();
        System.out.println("Bevor du dich überhaupt entscheiden kannst wohin es jetzt gehen soll, bemerkst du eine Person auf dich zukommen.");
        System.out.println("Sie sieht ziemlich bedrohlich aus...");
        System.out.println("Die Person kommt immer näher und du kannst erkennen, dass es Herr Brühne ist.");
        System.out.println();
        System.out.println("Was willst du als nächstes machen?");
        System.out.println("Gib >attack< ein, um Herrn Brühne anzugreifen oder >go Treppe runter< ein, um wieder runter zu gehen.");
        sPickorGo = scanner.nextLine().toLowerCase();
        if (sPickorGo.equals("attack")) {
            System.out.println();
            System.out.println("TEST TEST TEST.");
            System.exit(0);

            //Brühne angreifen kommt noch
            //Feuerlöscher droppen

        } else if (sPickorGo.equals("go treppe runter")) {
            System.out.println();
            System.out.println("Du rennst schnell bevor Herr Brühne dich erwischt wieder die Treppe hinunter.");
            System.out.println("------------------------------------------------");
            System.out.println("------------------------------------------------");
            System.out.println("------------------------------------------------");
            spieler.move(flurRechts);
            flurRechts();
        }
        else {
            System.out.println();
            System.out.println("Bitte Eingabe überprüfen.");
            System.out.println();
            System.out.println("------------------------------------------------");
            System.out.println("------------------------------------------------");
            System.out.println("------------------------------------------------");
            spieler.move(zweitesOG);
            zweitesOG();
        }
    }
}// end of class TextAdventure