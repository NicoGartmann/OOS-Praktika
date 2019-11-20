
public class KreisVererb extends Point {
	int rad; 
	
	KreisVererb() {
	}
	
	KreisVererb(Point p, int rad) {
		super(p); 
		this.rad = rad; 
	}
	
	KreisVererb(int x, int y, int rad) {
		super(x, y); 
		this.rad = rad; 
	}
	
	void setRadius(int rad) {
		this.rad = rad; 
	}
	
	int getRadius() {
		return this.rad; 
	}
	
	public boolean equals(KreisVererb k) {
		return (super.equals(k) && this.rad == k.rad); 
	}
	
	public String toString() {
		return ("( " + super.toString() + ", rad: " + this.rad + " )"); 
	}
	
	public static void main(String[] args) {
		//Default
		KreisVererb k1 = new KreisVererb(); 
		System.out.println("Default: k1 " +k1); 
		//int  
		KreisVererb k2 = new KreisVererb(5,7,3); 
		System.out.println("Int's: k2 " + k2); 
		//Point 
		Point p1 = new Point(); 
		Point p2 = new Point(p1); 
		Point p3 = new Point(3,5); 
		KreisVererb k3 = new KreisVererb(p3, 7);
		System.out.println("Point: k2 " + k3); 
		
		//keine Gleichheit
		System.out.println("k1 == k2 ? " + k1.equals(k2)); 
		//setLocation 
		k2.setLocation(k1);
		k2.setRadius(k1.getRadius()); 
		System.out.println("Location k2 = k1 : k2" + k2); 
		//Gleichheit 
		System.out.println("k1 == k2 ? " + k1.equals(k2)); 
		
		//move 
		System.out.println("k1 bevor move um dx = 3 & dy = 3 : " + k1); 
		k1.move(3, 3);
		System.out.println("k1 nach move um dx = 3 & dy = 3 : " + k1); 
	}
}
