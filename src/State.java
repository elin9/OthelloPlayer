
public class State {
	
	final static int EMPTY = 0;
	final static int BLACK = 1;
	final static int WHITE = 2;
	final static int totalB = 2; //total number of black pieces
	final static int totalW = 2; //total number of white pieces
	final int board[][] = new int[8][8];
	
	public State() {}
	
	public State(State copy) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				this.board[i][j] = copy.board[i][j];
			}
		}
	}
	
	public boolean isLegal(int row, int col, int color, boolean flip) {
		boolean legal = false;
		int x;
		int y;
		boolean found;
		int current;
		
		if (board[row][col] == 0) {
			for (int h = -1; h <= 1; h++) {
				for (int v = -1; v <= 1; v++) {
					x = col + h;
					y = row + v;
					found = false;
					current = board[y][x];
					
					if (current == -1 || current == 0 || current == color) continue;
					
					while (!found) {
						x += h;
						y += v;
						current = board[y][x];
						
						if (current == color) {
							found = true;
							legal = true;
							
							if (flip) {
								x -= h;
								y -= v;
								current = board[y][x];
								
								while (current != 0) {
									board[y][x] = color;
									x -= h;
									y -= v;
									current = board[y][x];
								}
							}
						} else if (current == -1 || current == 0)
							found = true;
					}
				}
			}
		}
		return legal;
	}

}
