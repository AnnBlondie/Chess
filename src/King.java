import javax.swing.ImageIcon;


public class King extends Figure{
	private String name ="K";
	private ImageIcon image;
	
	public King(String color) {
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
		if ((p.y1()==p.y2() && (p.x1()-p.x2()==1 || p.x2()-p.x1()==1)) ||
			(p.x1()==p.x2() && (p.y1()-p.y2()==1 || p.y2()-p.y1()==1)) ||
			(p.y1()-p.y2()==1 && (p.x1()-p.x2()==1 || p.x2()-p.x1()==1)) ||
			(p.y2()-p.y1()==1 && (p.x1()-p.x2()==1 || p.x2()-p.x1()==1))&&
			!color.equals(super.getColor())){
		return true;
		}
		else {
			System.out.println("Impossible move for king");	
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
			image = new ImageIcon("black_king.png");
		}
		else{
			image = new ImageIcon("white_king.png");
		}
	}

}