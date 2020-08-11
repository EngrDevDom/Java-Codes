

public class paintFill {
    enum Color{Black,White,Red,Yellow,Green};

    public static String PrintColor(Color c) {
		switch(c) {
		case Black:
			return "B";
		case White:
			return "W";
		case Red:
			return "R";
		case Yellow:
			return "Y";
		case Green:
			return "G";
		}
		return "X";
	}
    
    public static void PrintScreen(Color[][] screen) {
		for (int r = 0; r < screen.length; r++) {
			for (int c = 0; c < screen[0].length; c++) {
				System.out.print(PrintColor(screen[r][c]));
			}
			System.out.println();
		}
    }
    
    public static int randomInt(int n){
        return (int) (Math.random()*n);
    }
    
    private static boolean PaintFill(Color[][] screen, int row, int column , Color old_color, Color new_color) {
        //base case: check for within boundaries
        if(row<0 || row >= screen.length || column<0 || column>=screen.length){
            return false;
        }

        if(screen[row][column] == old_color){
            screen[row][column] = new_color;
            PaintFill(screen, row-1, column, old_color, new_color); //UP
            PaintFill(screen, row+1, column, old_color, new_color); //DOWN
            PaintFill(screen, row, column-1, old_color, new_color); //LEFT
            PaintFill(screen, row, column+1, old_color, new_color); //RIGHT
        }
        return true;
    }
    
    private static boolean PaintFill(Color[][] screen, int row, int column, Color new_color) {
        if(screen[row][column] == new_color) return false;
        return PaintFill(screen, row, column,screen[row][column], new_color);
    }

    public static void main(String[] args) {
		int N = 5;
		Color[][] screen = new Color[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				screen[i][j] = Color.Black;
			}			
		}
		for (int i = 0; i < 10; i++) {
			screen[randomInt(N)][randomInt(N)] = Color.Green;
		}
		PrintScreen(screen);
		PaintFill(screen, 2, 2, Color.White);
		System.out.println();
		PrintScreen(screen);
	}

}