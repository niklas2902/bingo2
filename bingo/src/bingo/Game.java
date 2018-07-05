package bingo;
import java.util.*;

public class Game {
	private boolean start;
	private ArrayList<Card> cards;
	private ArrayList<Integer> store; // Werte, die noch dran kommen können
	
	int playercount; // anzahl der Spieler
	
	public Game(int playerc) {
		start = true;
		cards = new ArrayList<Card>();
		store = new ArrayList<Integer>();
		playercount = playerc;
		for (int i = 0; i < 100; i++) {
			store.add(i+1);
		}
		for(int j = 0; j < playerc; j++) {
			cards.add(new Card());
		}
	}
	public int generate() {
		// generiert eine Zufallszahl von 1 bis 100
		int index = (int)(Math.random() * store.size());
		int output = store.get(index);
		store.remove(index);
		return output;
	}
	
	public void input_player() {
		/* Startphase, Karten werden erzeugt und gefüllt*/
		for (int i = 1; i<10;i++) {
			Scanner ScIn= new Scanner(System.in);
			System.out.print(i + ". Zahl: ");
			int j=ScIn.nextInt();
			cards.get(0).add_val(((i-1)/3), (i-1)%3, j);
		}
		
	}
	
	public void input_ki() {
		// erzeugt das Blatt der KI-Mitspieler
		for (int i = 1; i<10;i++) {
			int j = (int)(Math.random() * 100 + 1);
			cards.get(1).add_val(((i-1)/3), (i-1)%3, j);
		}
	}
	
	public void update_cards(int val) {
		// Zustand des Blatts der Spieler wird geupdatet (es werden Werte herausgestrichen, die genannt wurden)
		for (Card c: cards) {
			c.update_val(val);
		}
	}
	
	public boolean win() {
		/* ArrayList cards durchlaufen, prüfen, ob ein Spieler gewonnen hat.*/
		boolean win= false; 
		for (Card c: cards) {
			System.out.println(c.check_win());
			win = c.check_win();
		}
		return win;
	}
	
	public void run() {
		// Initialisiert das Spiel und Steuert in einer Endlosschleife das Spielgeschehen
		input_player();
		input_ki();
		while (start) {
			
			int numb = generate();
			update_cards(numb);
			System.out.println("Zahl: " + numb);
			for(int i = 0; i < playercount; i++) {
				cards.get(i).output_test();
				System.out.println();
			}
			if(start == win()) {
				return;
			}
		}
		
	}

}
