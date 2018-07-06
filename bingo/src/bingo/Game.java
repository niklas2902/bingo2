package bingo;
import java.util.*;

public class Game {
	private boolean start;
	private ArrayList<Card> cards;
	private ArrayList<Integer> store; // Werte, die noch dran kommen können
	
	int playercount;
	
	public Game(int playerc) {
		start = true;
		cards = new ArrayList<Card>();
		store = new ArrayList<Integer>();
		playercount = playerc;
		for (int i = 0; i < 100; i++) {
			store.add(i+1);
		}
		for(int j = 0; j < playerc; j++) {
			if (j== 0) {
				cards.add(new Card("Spieler"));
			}
			else {
				cards.add(new Card("KI "+ j));
			}
			
		}
	}
	public int generate() {
		int index = (int)(Math.random() * store.size());
		int output = store.get(index);
		store.remove(index);
		return output;
	}
	
	public void input_player() {
		/* Startphase, Karten werden erzeugt und gefüllt*/
		int i = 1;
		while(i<10) {
			Scanner ScIn= new Scanner(System.in);
			System.out.print(i + ". Zahl: ");
			int j=ScIn.nextInt();
			if (cards.get(0).check_in(j)) {
				continue;
			}
			cards.get(0).add_val(((i-1)/3), (i-1)%3, j);
			i++;
		}
		
	}
	
	public void input_ki() {
		ArrayList<Integer>nums; // hier werden die Zahlen generiert, um zu verhindern, dass Zahlen doppelt gewählt werden
		for(int k = 1; k < playercount; k++) {
			nums = new ArrayList();
			int ran;
			for (int i = 0; i<100;i++) {
				nums.add(i+1);
			}
			for (int i = 1; i<10;i++) {
				ran = (int)(Math.random() * nums.size());
				int j = nums.get((int)(Math.random() * nums.size()));
				cards.get(k).add_val(((i-1)/3), (i-1)%3, j);
				nums.remove(ran);
			}
		}
	}
	
	public void update_cards(int val) {
		for (Card c: cards) {
			c.update_val(val);
		}
	}
	
	public boolean win() {
		/* ArrayList cards durchlaufen, prüfen, ob ein Spieler gewonnen hat.*/
		boolean win= false; 
		for (Card c: cards) {
			//System.out.println(c.check_win());
			win = c.check_win();
			if(win == true) {
				return win;
			}
		}
		return win;
	}
	
	public void run() {
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
			System.out.println("-----------------------------------------------");
			if(start == win()) {
				start = false;
				String winner_string = ""; // Ausgabe, welche KIs gewonnen haben
				if(cards.get(0).check_win() == true) {
					System.out.println("Der Spieler hat gewonnen!!!");
				} else {
					System.out.println("Die KI hat leider gewonnen.");
					System.out.print("Gewinner ist: ");
					for (int i = 0; i< cards.size();i++) {
						if (cards.get(i).check_win()) {
							if (winner_string != "") {
								winner_string += ", ";
							}
							winner_string+=cards.get(i).get_playern();
						}
					}
					System.out.println(winner_string);
				}
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
