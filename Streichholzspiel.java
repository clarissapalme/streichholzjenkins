package streichholzspiel;
/**
 * Spielt das Streichholzspiel "Schere, Stein, Papier"
 * @author Clarissa
 * @version 1.0
 */
import java.util.Random;
import java.util.Scanner;

public class Streichholzspiel {
	protected static int input;
	protected static int computerAnzahl;
	protected static int anzahlStreichhoelzer;
	
	public static void zufallsZahlGenerieren(){
		Random zufallszahl = new Random();
		int untereGrenze = 9;
		int obereGrenze = 11;
		anzahlStreichhoelzer = zufallszahl.nextInt(obereGrenze-untereGrenze) + untereGrenze;
	}
	
	public static void begruessungAnzeigen(){
		String begruessung = "Wer das letzte Streichholz zieht, verliert.";
		System.out.println(begruessung);
	}
	
	public static void anzahlStreichhoelzerAusgeben(){
		System.out.println("Anzahl Streichhoelzer:" + anzahlStreichhoelzer);
	}
	
	public static void falscheEingabe(){
		System.out.println("Ungültige Eingabe! System wird beendet!");
		System.exit(0);
	}
	
	public static void userZiehtStreichhoelzer(){
		System.out.println("Wie viele Streichhoelzer moechten Sie wegnehmen?(1-3)");
		Scanner scanner = new Scanner(System.in);
		input = scanner.nextInt();
	}
	
	public static void userHatVerloren(){
		System.out.println("Sie haben verloren!");
		System.exit(0);
	}
	
	public static void computerTrifftWahl(){
		if(anzahlStreichhoelzer == 0){
			userHatVerloren();
		} else if(anzahlStreichhoelzer >8){
			computerAnzahl = anzahlStreichhoelzer-9;
		} else if(anzahlStreichhoelzer <= 4){
			computerAnzahl = anzahlStreichhoelzer - 1;//der Computer nimmt alle bis auf eines weg
		} else if (anzahlStreichhoelzer <=8){
			computerAnzahl= anzahlStreichhoelzer -5;//der Computer nimmt alle bis auf fuenf weg
		}
		System.out.println("Der Computer zieht ab: "+ computerAnzahl);
		anzahlStreichhoelzer -= computerAnzahl;
	}
	
	public static void streichholzspielstarten(){
		while (anzahlStreichhoelzer>0){
			userZiehtStreichhoelzer();
			if(input>3 | input<=0){
				falscheEingabe();
			} else{
				anzahlStreichhoelzer-= input;
				anzahlStreichhoelzerAusgeben();
				computerTrifftWahl();
				anzahlStreichhoelzerAusgeben();
			}
		}
	}
	
	public static void main(String[] args) {
		begruessungAnzeigen();
		zufallsZahlGenerieren();
		anzahlStreichhoelzerAusgeben();
		streichholzspielstarten();
	}
}
