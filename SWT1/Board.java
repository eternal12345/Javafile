//Board.java
package test;


import java.util.ArrayList;
import java.util.List;


public class Board {	
	private List<IShape> shapes;
	
	public Board() {
		shapes = new ArrayList<IShape>();
		
	}
	
	
	
	public void insertShape(IShape shape) {
		shapes.add(shape);	
	}
	
	public void refresh() {
		for(IShape shape:shapes) {
			shape.draw();
		}
	}
		
	

}
