public class ChessBoard {
	private Figure[][] board = new Figure[8][8];
	private String turn="w";
	
	ChessBoard(){//initial position
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				board[i][j]=null;
			}
		}
		//first line
		Rook wr1 = new Rook("w"); board[0][0]=wr1;
		Knight wh1 = new Knight("w"); board[0][1]=wh1;
		Bishop wb1 = new Bishop("w"); board[0][2]=wb1;
		Queen wq = new Queen("w"); board[0][3]=wq;
		King wk = new King("w"); board[0][4]=wk;
		Bishop wb2 = new Bishop("w"); board[0][5]=wb2;
		Knight wh2 = new Knight("w"); board[0][6]=wh2;
		Rook wr2 = new Rook("w"); board[0][7]=wr2;
		//second line
		for(int i=0;i<8;i++){
			Pawn pawn = new Pawn("w"); board[1][i]=pawn;
		}
		//7th line
		for(int i=0;i<8;i++){
			Pawn pawn = new Pawn("b"); board[6][i]=pawn;
		}
		//8th line
		Rook br1 = new Rook("b"); board[7][0]=br1;
		Knight bh1 = new Knight("b"); board[7][1]=bh1;
		Bishop bb1 = new Bishop("b"); board[7][2]=bb1;
		Queen bq = new Queen("b"); board[7][3]=bq;
		King bk = new King("b"); board[7][4]=bk;
		Bishop bb2 = new Bishop("b"); board[7][5]=bb2;
		Knight bh2 = new Knight("b"); board[7][6]=bh2;
		Rook br2 = new Rook("b"); board[7][7]=br2; 
	}
	
	public void makeMove(String fromTo){
		Path p = new Path(fromTo);
		String color;
		if( board[p.x2()-1][p.y2()-1]==null){color="";}		//got the color of the figure in the destination square
		else color= board[p.x2()-1][p.y2()-1].getColor();
		if(board[p.x1()-1][p.y1()-1]==null){ 				//empty start square 
			System.out.println("There is no one to move!");
		}
		else if(!checkTurn(board[p.x1()-1][p.y1()-1])){			//check turns
			System.out.println("It is not your turn!"); 
		}
		else if(!p.good()){										//check if path is on board
			System.out.println("You are out of chess field!");
		}
		else if(!checkPathFree(p,board[p.x1()-1][p.y1()-1])){	//check if path is free, figures can't jump except Knight
			System.out.println("It can't jump!");
		}
		else if(board[p.x1()-1][p.y1()-1].canMove(p, color) && //check if it is possible move 
					(board[p.x2()-1][p.y2()-1]==null ||			 //check if square is empty or there is figure with another color
						!(board[p.x2()-1][p.y2()-1].getColor().equals(
								board[p.x1()-1][p.y1()-1].getColor())))){
			if(board[p.x2()-1][p.y2()-1]==null){
				System.out.println(board[p.x1()-1][p.y1()-1].toString()+" go "+fromTo);
			}
			else System.out.println(board[p.x1()-1][p.y1()-1].toString()+" kills "+board[p.x2()-1][p.y2()-1].toString()+"!");
			board[p.x2()-1][p.y2()-1]=board[p.x1()-1][p.y1()-1];
			board[p.x1()-1][p.y1()-1]=null;
			changeTurn();
		}
		else System.out.println(":( try again");
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
}
