import javax.swing.ImageIcon;


public class Bishop extends Figure{
	private String name ="B";
	private ImageIcon image;
	
	public Bishop(String color) {
		super.setColor(color);
		setImage();
	}
	
	public String getName(){
		return name;
	}
	
	public String toString() {
		return super.getColor()+name;
	}
	
	@Override
	public boolean canMove(Path p, String color) {
		if (p.y1()-p.y2()==p.x1()-p.x2() || p.y1()-p.y2()==p.x2()-p.x1()&&
				!color.equals(super.getColor())){
		return true;
		}
		else {System.out.println("Impossible move for bishop");	
		return false;}
	}

	@Override
	ImageIcon getImage() {
		return image;
	}

	@Override
	void setImage() {
		if(super.getColor().equals("b")){
			image = new ImageIcon("black_bishop.png");
		}
		else{
			image = new ImageIcon("white_bishop.png");
		}
	}
}