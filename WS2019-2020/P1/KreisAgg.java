
public class KreisAgg extends Geos {
	int rad; 
	
	KreisAgg() {
		this.p1 = new Point(); 
	}
	
	KreisAgg(Point p) {
		this.p1 = new Point(p); 
	}
	
	KreisAgg(int x, int y, int rad) {
		this.p1 = new Point(x, y); 
		this.rad = rad; 
	}
	
	Point getLocation() {
		return (this.p1.getLocation()); 
	}
	
	void setLocation(Point p) {
		this.p1.setLocation(p);
	}
	
	void setLocation(int x, int y) {
		this.p1.setLocation(x, y);
	}
	
	int getRadius() {
		return this.rad; 
	}
	
	void setRadius(int rad) {
		this.rad = rad; 
	}
	
	void move(int dx, int dy) {
		this.p1.move(dx, dy);
	}
	
	
	double flaeche() {
		return (Math.PI*(this.rad*this.rad)); 
	}
	
	public boolean equals(KreisAgg k) {
		return (this.p1.equals(k) && this.rad == k.rad);
	}
	
	public String toString() {
		return (this.p1.toString() + ", " + this.rad);
	}
}
