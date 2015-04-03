import java.io.IOException;
import java.util.Scanner; 

import javax.swing.SwingUtilities;

public class Main {
	public static void main(String[] args) throws IOException{
	    ChessBoard board1 = new ChessBoard();

	    final Controller chess = new Controller();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                chess.getView().setVisible(true);
            }
        });
	}
}

