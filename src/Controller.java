import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controller {

	private ChessGUI view;
	private ChessBoard board = new ChessBoard();
	
	Controller(){
		view = new ChessGUI(board.getBoard());
		view.addButtonListener(new InputListener());
	}
	
	public ChessGUI getView() {
		return view;
	}

	public void setView(ChessGUI view) {
		this.view = view;
	}

	public void makeMove(String move){
		board.makeMove(move);
	}
	
	public String toString(){
		return board.toString();
	}
	
	private class InputListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String move = view.getInput().getText();
		//	makeMove(move);
		//	System.out.println(board);
		//	view.setChess(board.getBoard());
		//	view.setOutput(move);
			view.initialize(board.makeMove(move),move+": "+board.getMessage());
		}		
	}
}