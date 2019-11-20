
public class Point {
	int x; 
	int y; 
	
	Point() {
	}
	
	Point(Point p) {
		this.x = p.x; 
		this.y = p.y;
	}
	
	Point(int x, int y) {
		this.x = x; 
		this.y = y; 
	}
	
	Point getLocation() {
		return this; 	
	}
	
	void setLocation(Point p) {
		this.x = p.x; 
		this.y = p.y; 
	}
	
	void setLocation(int x, int y) {
		this.x = x; 
		this.y = y; 
	}
	
	void move(int dx, int dy) {
		this.x += dx; 
		this.y += dy; 
	}
	
	public boolean equals(Point p) {
		return(this.x == p.x && this.y == p.y);  
	}
	
	public String toString() {
		return ("("+this.x+","+this.y+")"); 
	}
	
}
