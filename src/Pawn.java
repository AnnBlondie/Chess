import javax.swing.ImageIcon;


public class Pawn extends Figure{
	private String name ="p";
	private ImageIcon image;
	
	public Pawn(String color) {
		super.setColor(color);
		setImage();
	}

	public String getName() {
		return name;
	}

	public String toString(){
		return super.getColor()+name;
	}
	@Override
	public boolean canMove(Path p, String color) {
		if ((super.getColor()=="b" && p.y1()==p.y2() && ( p.x1()-p.x2()==1 ||//possible for white move
			(p.x1()==7 && p.x2()==5))&&
			color.equals(""))||
			(super.getColor()=="w" && p.y1()==p.y2() && (p.x2()-p.x1()==1 ||//possible for black move
			(p.x1()==2 && p.x2()==4))&&
			color.equals(""))||
			(Math.abs(p.y1()-p.y2())==1 && Math.abs(p.x1()-p.x2())==1 && // possible for beat
			!color.equals(super.getColor()))){
			return true;
		}
		else {
			System.out.println("Impossible move for pawn");	
			return false;
		}
	}

	@Override
	ImageIcon getImage() {
		return image;
	}

	@Override
	void setImage() {
		if(super.getColor().equals("b")){
			image = new ImageIcon("black_paw.png");
		}
		else{
			image = new ImageIcon("white_paw.png");
		}
	}
}