import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class ChessGUI extends JFrame {
	
	private JTextArea output = new JTextArea(2, 40);
	private JTextField input = new JTextField();
	private JPanel chess = new JPanel();
	private JButton move = new JButton("move");
	
 	public ChessGUI(Figure[][] board){
		initialize(board, "hi");
	}

	public void initialize(final Figure[][] board, String message){
		setBounds(100, 100, 650, 550);
		setTitle("Chess");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setChess(board);
		add(chess, BorderLayout.CENTER);

		setOutput(message);
		
		
		getContentPane().add(new JScrollPane(output), BorderLayout.SOUTH);
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
		input.setText("");
		input.setBounds(2, 2, 10, 10);
		//inputPanel.add(output);
		inputPanel.add(input);
		inputPanel.add(move);
        add(inputPanel, BorderLayout.EAST);
        
		setVisible(true);
	}

	public void setOutput(String message) {
        output.setEditable(false);
        output.append("\n "+message);
	}

	public JTextField getInput() {
		return input;
	}

	public JPanel getChess() {
		return chess;
	}
	
	public void setChess(Figure[][] board) {
		chess.removeAll();
		chess.setBounds(0, 0, 500, 500);
		chess.setLayout(new GridLayout(10,10));
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				if(((i==0 || i==9) && j==0) || ((i==0 || i==9) && j==9)){
					chess.add(new JPanel());
				}
				else if(i==0 || i==9 ){
					chess.add(new JPanel().add(new JLabel(""+(char)(j+96), 0)));
				}
				else if(j==0 || j==9){
					chess.add(new JPanel().add(new JLabel(""+(9-i), 0)));
				}
				else{
					JPanel p = new JPanel();
					if((i+j)%2==0)p.setBackground(Color.lightGray);
					if(board[8-i][j-1]!=null){
						p.add(new JLabel(board[8-i][j-1].getImage()));
					}
					chess.add(p);
				}
			}
		}
	}


	public void addButtonListener(ActionListener enterListening){
		move.addActionListener(enterListening);
	}

}