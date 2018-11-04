package praktikum1;

public class Main {

	public static void main(String[] args) {
		Geos[] geos = new Geos[4]; 

		//Rechteck Nr. 1 
		Point p1 = new Point(5,7); 
		Point p2 = new Point(8,7); 
		Point p3 = new Point(8,11); 
		Point p4 = new Point(5, 11); 
		
		//Rechteck Nr. 2 
		Point p5 = new Point(3,2); 
		Point p6 = new Point(7,2); 
		Point p7 = new Point(7,5); 
		Point p8 = new Point(3,5); 
		
		geos[0] = new KreisAgg(p1,5.0); 
		geos[1] = new Rechteck(p1, p2, p3, p4); 
		geos[2] = new KreisAgg(p2, 7.0); 
		geos[3] = new Rechteck(p5, p6, p7, p8); 
		
		double gesFlaeche=0.0; 
		for(int i=0; i<4; i++) {
			gesFlaeche += geos[i].flaeche(); 
		}
		System.out.println(gesFlaeche);
	}
	
}
