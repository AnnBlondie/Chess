import javax.swing.ImageIcon;

public abstract class Figure {
		
	private String color;
	private ImageIcon image;
	
	abstract ImageIcon getImage();

	abstract void setImage();

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
