package praktikum1;

public class KreisAgg extends Geos { 
	double radius; 
	
	KreisAgg() {
		this.p1= new Point();
		this.radius= 1.0; 
	}
	
	KreisAgg(Point p1, double radius) {
		this.p1 = new Point(p1); 
		this.radius= radius; 
	}
	
	KreisAgg(int x, int y, double radius) {
		this.p1 = new Point(x,y); 
		this.radius= radius; 
	}
	
	double flaeche() {
		return Math.PI*this.radius*this.radius;
	}
	
	public String toString() {
		return "Mittelpunkt: " + p1.toString() + " Radius: " + this.radius; 
	}
	
	public boolean equals(KreisAgg ka) {
		return (this.p1.equals(ka.p1) && this.radius == ka.radius) ;
	}
	
	public KreisAgg clone() {
		KreisAgg ka= new KreisAgg(this.p1, this.radius);
		return ka; 
	}
	
}
