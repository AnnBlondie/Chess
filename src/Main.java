import java.util.Scanner; 

public class Main {
	public static void main(String[] args){
	    System.out.println("Welcome to Chess! (end it with input \"end\")");
	    ChessBoard board1 = new ChessBoard();
		System.out.println(board1.toString());
	    System.out.print("White starts (in format \"e2-e4\"): ");
	    Scanner move = new Scanner(System.in);
	    String s = move.next();
	    while(!s.equals("end")) { 
	          board1.makeMove(s);
	          System.out.println(board1.toString());
	          System.out.print("input next move: ");
	          s = move.next();
	        } 
	    System.out.println("bye!");
	    move.close();
	    
	}
}

