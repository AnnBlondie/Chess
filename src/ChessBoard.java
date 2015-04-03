public class ChessBoard {
	private Figure[][] board = new Figure[8][8];
	private String turn="w";
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	ChessBoard(){//initial position
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				board[i][j]=null;
			}
		}
		//first line
		board[0][0] = new Rook("w");
		board[0][1] = new Knight("w");
		board[0][2] = new Bishop("w"); 
		board[0][3] = new Queen("w");
		board[0][4] = new King("w");
		board[0][5] = new Bishop("w"); 
		board[0][6] = new Knight("w"); 
		board[0][7] = new Rook("w"); 
		//second line
		for(int i=0;i<8;i++){
			board[1][i] = new Pawn("w"); 
		}
		//7th line
		for(int i=0;i<8;i++){
			board[6][i] = new Pawn("b");
		}
		//8th line
		board[7][0]= new Rook("b");
		Knight bh1 = new Knight("b"); board[7][1]=bh1;
		Bishop bb1 = new Bishop("b"); board[7][2]=bb1;
		Queen bq = new Queen("b"); board[7][3]=bq;
		King bk = new King("b"); board[7][4]=bk;
		Bishop bb2 = new Bishop("b"); board[7][5]=bb2;
		Knight bh2 = new Knight("b"); board[7][6]=bh2;
		Rook br2 = new Rook("b"); board[7][7]=br2; 
		message = "Welcome to Chess! (end it with input \"end\")";
	}
	
	public Figure[][] makeMove(String fromTo){
		Path p = new Path(fromTo);
		String color;
		if( board[p.x2()-1][p.y2()-1]==null){color="";}		//got the color of the figure in the destination square
		else color= board[p.x2()-1][p.y2()-1].getColor();
		if(board[p.x1()-1][p.y1()-1]==null){ 				//empty start square 
			message = "There is no one to move!";
		}
		else if(!checkTurn(board[p.x1()-1][p.y1()-1])){			//check turns
			message = "It is not your turn!"; 
		}
		else if(!p.good()){										//check if path is on board
			message = "You are out of chess field!";
		}
		else if(!checkPathFree(p,board[p.x1()-1][p.y1()-1])){	//check if path is free, figures can't jump except Knight
			message = "It can't jump!";
	}
		else if(board[p.x1()-1][p.y1()-1].canMove(p, color) && //check if it is possible move 
					(board[p.x2()-1][p.y2()-1]==null ||			 //check if square is empty or there is figure with another color
						!(board[p.x2()-1][p.y2()-1].getColor().equals(
								board[p.x1()-1][p.y1()-1].getColor())))){
			if(board[p.x2()-1][p.y2()-1]==null){
				message = board[p.x1()-1][p.y1()-1].toString()+" go "+fromTo;
			}
			else message = board[p.x1()-1][p.y1()-1].toString()+" kills "+board[p.x2()-1][p.y2()-1].toString()+"!";
			board[p.x2()-1][p.y2()-1]=board[p.x1()-1][p.y1()-1];
			board[p.x1()-1][p.y1()-1]=null;
			changeTurn();
		}
		else message = ":( try again";
		return board;
	}
		
	public boolean checkPathFree(Path p, Figure f){				//method to find if path is free
		boolean free=true;
		if(!f.getName().equals("H")){
			for(int i=1;i<p.getPath()[0].length-1;i++){
				free=(board[p.getPath()[0][i]-1][p.getPath()[1][i]-1]==null) && free;
			}
		}
		return free;
	}
		
	public boolean checkTurn(Figure f){							
		if (f.getColor()==turn){
			return true;
		}
		else return false;
	}
	
	public void changeTurn(){									
		if (turn=="w"){turn="b";}
		else{turn="w";};
	}
	
	public String toString(){
		String s = " ";
		s="     a    b    c    d    e    f    g    h \n";
		s+="  -----------------------------------------\n";
		for(int i=8;i>0;i--){
			s+=i+" | ";
			for(int j=0;j<8;j++){
				if(board[i-1][j]==null){
					s+="   | ";
				}
				else{
					s+=board[i-1][j].toString()+" | ";
				}
			}
			s+=i+"\n";
			s+="  -----------------------------------------\n";
		}
		s+="     a    b    c    d    e    f    g    h \n";
		return s;
	}

	public Figure[][] getBoard(){
		return board;
	}

}