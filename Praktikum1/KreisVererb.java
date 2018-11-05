package praktikum1;

public class KreisVererb extends Point {
	double radius; 
	
	//Default Konstruktor
	KreisVererb() {
	}
	
	//Konstruktor mittels Point u Radius
	KreisVererb(Point p, double radius) {
		super(p); 
		this.radius=radius; 
	}
	
	//Konstruktor mittels Point 
	KreisVererb(Point p){
		super(p); 
		this.radius=1.0; 
	}
	
	KreisVererb(int x, int y, double radius) {
		super(x,y);  
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

}
