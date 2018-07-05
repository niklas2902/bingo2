package bingo;
// Test Commit
public class Card {
	// Beinhaltet Zahlen, die die Spieler auf ihren Bongo-Scheinen haben
	int[][] data;
	int SIZE;
	public Card(){
		SIZE = 3;
		data = new int[SIZE][SIZE];
		
	}
	public void add_val(int x, int y, int val) {
		// fügt eine neuer zahl zum Bingo-Schein hinzu
		data[x][y] = val;
	}
	
	public void update_val(int val) {
		// streicht werte von der Bingo-Karte, die genannt wurden
		for (int x = 0; x < SIZE;x++) {
			for (int y = 0; y < SIZE; y++) {
				if (data[x][y] == val) {
					data[x][y] = 0;
					return;
				}
			}
		}
	}
	
	public boolean check_win() {
		// überprüft, ob eine Gewinnbedingung eingetreten ist (horizontale, vertikale, diagonale Reihe)
		for (int x = 0; x < SIZE;x++) {
			if (data[x][0] == 0 && data[x][1] ==0 && data[x][2] == 0) {
				return true;
			}
		}
		for (int y = 0; y < SIZE;y++) {
			if (data[0][y] == 0 && data[1][y] ==0 && data[2][y] == 0) {
				return true;
			}
		}
		if(data[0][0] ==0 &&  data[1][1] == 0 && data[2][2] == 0) {
			return true;
		}
		if (data[0][2] == 0 && data[1][1] == 0 && data[2][0] == 0) {
			return true;
		}
		
		return false; 
	}
	
	public void output_test() {
		// Test-Funktion, die das Blatt des Spielers ausgibt.
		for (int x = 0; x < SIZE;x++) {
			for(int y = 0; y < SIZE; y++) {
				System.out.print(data[x][y]+ ", "); 
			}
			System.out.println();
		}
	}
}
