
public class Knight extends Figure{
	private String name ="H";
	
	public Knight(String color) {
		super.setColor(color);
	}

	public String getName() {
		return name;
	}

	public String toString(){
		return super.getColor()+name;
	}
	@Override
	public boolean canMove(Path p, String color) {
		if (((p.y1()-p.y2()==2 || p.y2()-p.y1()==2) && (p.x1()-p.x2()==1 || p.x2()-p.x1()==1)) || 
			((p.y2()-p.y1()==1 || p.y1()-p.y2()==1) && (p.x1()-p.x2()==2 || p.x2()-p.x1()==2))&&
			!color.equals(super.getColor())){
			return true;
		}
		else {
			System.out.println("Impossible move for knight");	
			return false;
		}
	}
}
