package learn;

public class GalToLitreTable {
	public static void main (String args[]) {
		double gallons, litres;
		int count = 0;
		for (gallons=1 ; gallons<=100 ; gallons++) {
			count = count + 1;
			litres = gallons*3.7854;
			System.out.println(gallons + " gallons equal to " + litres+ " litres.");
			if (count==10) {
				System.out.println("");
				count=0;
			}
		}
		
	}

}
