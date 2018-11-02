package praktikum1;

public class KreisVererb extends Point {
	double radius; 
	
	//Default Konstruktor
	KreisVererb() {
	}
	
	//Konstruktor mittels Point u Radius
	KreisVererb(Point p, int radius) {
		this.x=p.x;
		this.y=p.y; 
		this.radius=radius; 
	}
	
	//Konstruktor mittels Point 
	KreisVererb(Point p){
		this.x=p.x; 
		this.y=p.y; 
		this.radius=1.0; 
	}
	
	KreisVererb(int x, int y, double radius) {
		this.x=x; 
		this.y=y; 
		this.radius=radius; 
	}
	
	//setzen des Radiuses
	void setRadius(double radius) {
		this.radius=radius; 
	}
	
	//Ausgabe des Kreises mittels Methode aus Point
	public String toString() {
		String res= "Mittelpunkt: " + super.toString() +" Radius: "+ this.radius; 
		return res; 
	}
	
	//Gleichheitsvergleich mittels equals Methode aus Point
	boolean equals(KreisVererb k) {
		return ((super.equals(k)) && (this.radius==k.radius));  
	}
	
	//Berechnung der Flaeche
	double flaeche() {
		return Math.PI*this.radius*this.radius;
	}
	
	//Berechnung des Umfangs
	double umfang() {
		return 2*Math.PI*this.radius; 
	}
	
	
	public static void main(String[] args) {
	 
	}

}
