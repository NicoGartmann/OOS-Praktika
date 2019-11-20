
abstract class Geos {
	Point p1; 
	
	abstract double flaeche(); 
	
	public static void main(String[] args) {
		Geos[] geo = new Geos[4]; 
	
		geo[0] = new Rechteck(5,7,4,3); 
		geo[1] = new Rechteck(3,4,7,5); 
		geo[2] = new KreisAgg(0,0,5); 
		geo[3] = new KreisAgg(1,1,4); 
	
		double flaeche=0; 
		for(int i=0; i<geo.length; ++i) {
			flaeche += geo[i].flaeche(); 
		}
		System.out.println("Gesflaeche: "+ flaeche);
	}
	
}
