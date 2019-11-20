
public class Rechteck extends Geos {
	Point p2; 
	int laenge; 
	int breite; 
	
	Rechteck() {
		this.p1 = new Point(); 
		this.p2 = new Point(); 
	}
	
	Rechteck(Point p, int laenge, int breite) {
		this.p1 = new Point(p); 
		this.laenge = laenge; 
		this.breite = breite; 
		this.p2 = new Point(p.x+breite, p.y-laenge); 
	}
	
	Rechteck(int x, int y, int laenge, int breite) {
		this.p1 = new Point(x,y); 
		this.laenge = laenge; 
		this.breite = breite; 
		this.p2 = new Point(x+breite, y-laenge); 
	}
	
	Point getLocation() {
		return this.p1.getLocation(); 
	}
	
	void setLocation(Point p) {
		this.p1.setLocation(p);
		this.p2.setLocation(p.x+this.breite, p.y-this.laenge);
	}
	
	int getLaenge() {
		return this.laenge; 
	}
	
	void setLaenge(int laenge) {
		this.laenge = laenge; 
	}
	
	int getBreite() {
		return this.breite; 
	}
	
	void setBreite(int breite) {
		this.breite = breite; 
	}
	
	void move(int dx, int dy) {
		this.p1.move(dx, dy);
		this.p2.move(dx+this.breite, dy-this.laenge);
	}
	
	double flaeche() {
		return (this.laenge*this.breite); 
	}
	
	public boolean equals(Rechteck r) {
		return (this.p1.equals(r.p1) && this.p2.equals(r.p2) 
				&& this.breite == r.breite && this.laenge == r.laenge); 
	}
	
	public String toString() {
		return ("P1: " + this.p1.toString() + " P2: " + this.p2.toString() 
				+ " breite: " + this.breite + " laenge: " + this.laenge); 
	}
	
}
