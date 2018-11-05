package praktikum1;

public class Main {

	public static void main(String[] args) {
		
		//Test Aufgabe 2
		
		//Point
		System.out.println("Konstruktore: ");
		Point pDefault= new Point();
		System.out.println(pDefault); 
		
		Point pPoint = new Point(pDefault); 
		System.out.println(pPoint);
		
		Point pKoordinaten = new Point (3,4); 
		System.out.println(pKoordinaten);
		
		System.out.print("getLocation: ");
		System.out.println(pKoordinaten.getLocation());
		
		System.out.println("setLocation über Punkt: ");
		System.out.println("vorher: "+ pPoint);
		pPoint.setLocation(pKoordinaten);
		System.out.println("nachher: "+ pPoint);
		
		System.out.println("setLocation über Koordinaten: "); 
		System.out.println("vorher: " + pPoint);
		pPoint.setLocation(5, 5);
		System.out.println("nachher: " + pPoint);
		
		System.out.println("move: ");
		System.out.println("vorher: "+ pPoint);
		pPoint.move(2, 2);
		System.out.println("nachher (um 2 in x- bzw y-Richtung verschoben): " + pPoint); 
		
		System.out.println("equals: ");
		pDefault.setLocation(1,1);
		System.out.println("erster Punkt: " + pDefault +" zweiter Punkt: " + pPoint);
		System.out.println(pDefault.equals(pPoint));
		pPoint.setLocation(pDefault);
		System.out.println("erster Punkt: " + pDefault +" zweiter Punkt: " + pPoint);
		System.out.println(pDefault.equals(pPoint));
		
		//KreisVererb
		KreisVererb kvDefault= new KreisVererb();
		System.out.println(kvDefault);
		KreisVererb kvPunktRadius = new KreisVererb(pDefault, 7.0); 
		System.out.println(kvPunktRadius);
		KreisVererb kvPunkt = new KreisVererb(pDefault); 
		System.out.println(kvPunkt);
		KreisVererb kvKoordinatenRadius = new KreisVererb(2,2,3.0);
		System.out.println(kvKoordinatenRadius);
		
		System.out.println("setRadius: ");
		System.out.println("vorher: "+ kvDefault);
		kvDefault.setRadius(3.5);
		System.out.println("nachher: "+ kvDefault);
		
		System.out.println("equals: ");
		System.out.println("erster Kreis: " + kvDefault + " zweite Kreis: " + kvKoordinatenRadius);
		System.out.println(kvDefault.equals(kvKoordinatenRadius));
		System.out.println("erster Kreis: " + kvDefault + " zweite Kreis: " + kvDefault);
		System.out.println(kvDefault.equals(kvDefault));
		kvKoordinatenRadius.setLocation(0,0);
		System.out.println("erster Kreis: " + kvDefault + " zweite Kreis: " + kvKoordinatenRadius);
		System.out.println(kvDefault.equals(kvKoordinatenRadius));
		kvKoordinatenRadius.setLocation(0, 1);
		kvKoordinatenRadius.setRadius(3.5);
		System.out.println("erster Kreis: " + kvDefault + " zweite Kreis: " + kvKoordinatenRadius);
		System.out.println(kvDefault.equals(kvKoordinatenRadius));
		

		//Test Aufgabe 3
		
		//KreisAgg
		System.out.println("Konstruktore: ");
		KreisAgg kaDefault = new KreisAgg(); 
		System.out.println(kaDefault);
		KreisAgg kaPunktRadius = new KreisAgg(pDefault, 5.0); 
		System.out.println(kaPunktRadius);
		KreisAgg kaKoordinatenRadius = new KreisAgg(5,5,5.0); 
		System.out.println(kaKoordinatenRadius);
		
		System.out.println("Flaeche: ");
		System.out.println(kaKoordinatenRadius.flaeche());
		
		System.out.println("equals: ");
		System.out.println("erster Kreis: " + kaDefault + " zweiter Kreis: " + kaKoordinatenRadius);
		System.out.println(kaDefault.equals(kaKoordinatenRadius));
		System.out.println("erster Kreis: " + kaDefault + " zweiter Kreis: " + kaDefault);
		System.out.println(kaDefault.equals(kaDefault));
		
		//abstrakte Klasse 
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
		
		double gesFlaeche = 0.0; 
		for(int i=0; i<4; i++) {
			gesFlaeche += geos[i].flaeche(); 
		}
		System.out.println(gesFlaeche);
		
	}
	
}
