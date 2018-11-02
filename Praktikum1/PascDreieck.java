package praktikum1;

public class PascDreieck {
	public static void main (String[] args) {
		final int depth=10; 
		//Erzeugung eines mehrdimensionalen Arrays in Dreieck-Style
		int[][] triangle= new int[depth][]; 
		
		for(int i=0; i<depth; i++) {
			triangle[i]=new int[i+1];
			for(int j=0; j<=i; j++) {
				// i=zeile
				//j=spalte 
				
				if(j==0 || j==i ) {
					//raender
					triangle[i][j]=1; 
				}
				else {
					//berechnung der "innenelemente"
					triangle[i][j]=triangle[i-1][j-1]+triangle[i-1][j]; 
				}
				//print statt println, um es in eine Zeile zu schreiben 
				System.out.print(triangle[i][j]+ " "); 
			}
			//println um zeile abzuschliessen 
			System.out.println("");
		}
	}
}


