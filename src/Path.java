
public class Path {
	private String fromTo;
		
	Path(String fromTo){
		this.fromTo=fromTo;
	}	
	
	public int y1(){
		char yy1 = fromTo.charAt(0);
		int y1=(int)yy1-96;
		return y1;
	}
	
	public int x1(){
		int x1 = Character.getNumericValue(fromTo.charAt(1));
		return x1;
	}
	
	public int y2(){
		char yy2 = fromTo.charAt(3);
		int y2=(int)yy2-96;
		return y2;
	}
	
	public int x2(){
		int x2 = Character.getNumericValue(fromTo.charAt(4));
		return x2;
	}
	
	public boolean good(){
		char y1 = fromTo.charAt(0);
		int x1 = Character.getNumericValue(fromTo.charAt(1));
		char y2 = fromTo.charAt(3);
		int x2 = Character.getNumericValue(fromTo.charAt(4));
		if ('a'<=y1 && y1<='h' && 0<x1 && x1<9 
				&& 'a'<=y2 && y2<='h' && 0<x2 && x2<9){
			return true;
		}
		return false;
	}
	
	public int[][] getPath(){
		int[][] p;
		if (x1()==x2()){
			p = new int[2][Math.abs(y1()-y2())+1];
			for(int i=0;i<p[0].length;i++){
				p[0][i]=x1();
				p[1][i]=Math.min(y1(), y2())+i;
			}
		}
		else if(y1()==y2()){
			p = new int[2][Math.abs(x1()-x2())+1];
			for(int i=0;i<p[0].length;i++){
				p[0][i]=Math.min(x1(), x2())+i;
				p[1][i]=y1();
			}
		}
		else if (Math.abs(x1()-x2())==Math.abs(y1()-y2())){
			p = new int[2][Math.abs(x1()-x2())+1];
			for(int i=0;i<p[0].length;i++){
				p[0][i]=Math.min(x1(), x2())+i;
				p[1][i]=Math.min(y1(), y2())+i;
			}
		}
		else p=new int[1][1];//possible for knight only, will check in chessBoard
		return p;
	}
}
