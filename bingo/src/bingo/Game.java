package bingo;
import java.util.*;

public class Game {
	private boolean start;
	private ArrayList<Card> cards;
	private ArrayList<Integer> store; // Werte, die ncoh dran kommen k�nnen
	
	
	public Game(int playerc) {
		start = true;
		cards = new ArrayList<Card>();
		store = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++) {
			store.add(i+1);
		}
		cards.add(new Card());
	}
	public int generate() {
		int index = (int)(Math.random() * store.size());
		int output = store.get(index);
		store.remove(index);
		return output;
	}
	
	public void input_player() {
		/* Startphase, Karten werden erzeugt und gef�llt*/
		for (int i = 1; i<10;i++) {
			Scanner ScIn= new Scanner(System.in);
			System.out.print(i + ". Zahl: ");
			int j=ScIn.nextInt();
			cards.get(0).add_val(((i-1)/3), (i-1)%3, j);
		}
		
	}
	
	public void update_cards(int val) {
		for (Card c: cards) {
			c.update_val(val);
		}
	}
	
	public boolean win() {
		/* ArrayList cards durchlaufen, pr�fen, ob ein Spieler gewonnen hat.*/
		boolean win= false; 
		for (Card c: cards) {
			System.out.println(c.check_win());
			win = c.check_win();
		}
		return win;
	}
	
	public void run() {
		input_player();
		while (start) {
			
			int numb = generate();
			update_cards(numb);
			System.out.println("Zahl: " + numb);
			start = !win();
			cards.get(0).output_test();
		}
		
	}

}