package bingo;

public class Card {
	int[][] data;
	int SIZE;
	private String player_name;
	public Card(String p_name){
		SIZE = 3;
		data = new int[SIZE][SIZE];
		player_name = p_name;
		
	}
	// Neuer Val
	public void add_val(int x, int y, int val) {
		data[x][y] = val;
	}
	// Values werden geupdatet
	public void update_val(int val) {
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
		System.out.println(player_name);
		for (int x = 0; x < SIZE;x++) {
			for(int y = 0; y < SIZE; y++) {
				System.out.print(data[x][y]+ ", "); 
			}
			System.out.println();
		}
	}
	
	public String get_playern(){
		return player_name;
	}
	
	public boolean check_in(int val) {
		for (int[] line: data) {
			for (int y:line) {
				if (y == val) {
					return true;
				}
			}
		}
	return false;
	}
}
