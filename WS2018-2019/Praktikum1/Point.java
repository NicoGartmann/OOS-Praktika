package praktikum1;


public class Point {
	int x; 
	int y; 
	
	//default Konstruktor
	Point(){}; 
	
	//Konstruktor über anderen Point
	Point(Point p){
		this.x=p.x; 
		this.y=p.y; 
	};
	
	//Konstruktor durch Punktangaben 
	Point(int x, int y){
		this.x=x; 
		this.y=y; 
	};
	
	//Position ermitteln 
	Point getLocation() {
		Point p=new Point(); 
		p.x=this.x; 
		p.y=this.y; 
		return p; 
	}
	
	//Position setzen durch Übergabe eines Punktes
	void setLocation(Point p){
		this.x=p.x;
		this.y=p.y; 
	}
	
	//Position setzen durch Übergabe der Koordinaten 
	void setLocation(int x, int y) {
		this.x=x; 
		this.y=y; 
	}
	
	//Punkt bewegen 
	void move(int dx, int dy) {
		this.x+=dx; 
		this.y+=dy; 
	}
	
	//Gleichheitsvergleich
	boolean equals(Point p) {
		return (this.x==p.x) && (this.y==p.y); 
	}
	
	//Ausgabe des Punktes 
	public String toString() {
		String res; 
		res= "( " + this.x + " , " + this.y + " )"; 
		return res; 
	}

}

