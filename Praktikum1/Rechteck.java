package praktikum1;

public class Rechteck extends Geos {
	
	/*
	 * Rechteck besteht aus vier Punkten 
	 * 
	 *   p4 X---------X p3
	 *      |         |
	 *      |         |
	 *   p1 X---------X p2 
	 * 
	 */
	
	Point p2; 
	Point p3; 
	Point p4; 
	
	Rechteck() {
		this.p1 = new Point(); 
		this.p2 = new Point(); 
		this.p3 = new Point(); 
		this.p4 = new Point(); 
	}
	

	Rechteck(Point p1, Point p2, Point p3, Point p4) {
		this.p1 = new Point(p1); 
		this.p2 = new Point(p2); 
		this.p3 = new Point(p3); 
		this.p4 = new Point(p4); 
	}
	
	double flaeche() {
		double breite = p2.x - p1.x; 
		double laenge = p4.y - p1.y; 
		double res = laenge * breite; 
		return res; 
	}
	
	boolean equals(Rechteck r) {
		return ((this.p1==r.p1)&&(this.p2==r.p2)&&(this.p3==r.p3)&&(this.p4==r.p4)) ;  
	}
	
	public Rechteck clone() {
		Rechteck neu = new Rechteck(this.p1, this.p2, this.p3, this.p4);
		return neu; 
	}
	
	public String toString() {
		String res = "Unten links: " + this.p1 + " Unten Rechts: " + this.p2 + " Oben links: " + 
					 this.p4 + " Oben rechts: " + this.p3; 
		return res; 
	}
	
	public static void main(String[] args) {
		Rechteck r1 = new Rechteck(); 
		Point p1 = new Point(3,4); 
		Point p2 = new Point(8,4);
		Point p3= new Point(8,7); 
		Point p4 = new Point(3,7);
		Rechteck r2 = new Rechteck(p1, p2, p3, p4); 
		System.out.println(r2);
		r1 = r2.clone(); 
		System.out.println(r1); 
	}
}
