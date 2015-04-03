import javax.swing.ImageIcon;


public class Rook extends Figure{
	private String name ="R";
	private ImageIcon image;
		
	public Rook(String color) {
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
		if (p.y1()==p.y2() || p.x1()==p.x2()&&
				!color.equals(super.getColor())){
			return true;
		}
		else {
			System.out.println("Impossible move for rook");	
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
			image = new ImageIcon("black_rook.png");
		}
		else{
			image = new ImageIcon("white_rook.png");
		}
	}
}