
public class Bishop extends Figure{
	private String name ="B";
	
	public Bishop(String color) {
		super.setColor(color);
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
}
