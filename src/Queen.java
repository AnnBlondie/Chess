import javax.swing.ImageIcon;


public class Queen extends Figure {
	private String name ="Q";
	private ImageIcon image;
	
	public Queen(String color) {
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
		if (p.y1()==p.y2() || p.x1()==p.x2() || 
			(p.y1()-p.y2())==(p.x1()-p.x2()) || (p.y1()-p.y2())==(p.x2()-p.x1())&&
			!color.equals(super.getColor())){
			return true;
		}
		else {
			System.out.println("Impossible move for queen");	
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
			image = new ImageIcon("black_queen.png");
		}
		else{
			image = new ImageIcon("white_queen.png");
		}
	}
}