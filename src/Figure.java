public abstract class Figure {
		
	private String color;
	
	public Figure(){
		setColor("");
	}
	
	abstract boolean canMove(Path fromTo, String color);

	abstract String getName();	
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}

