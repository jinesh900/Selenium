package learn;

public class inchesToMeters {
	public static void main (String args[]) {
		int inches, count=0;
		
		for(inches=1;inches<=144;inches++) {
			count=count+1;
			System.out.println(inches+" inches equals to "+inches/39.37+" meters.");
			if (count==12) {
				System.out.println("");
				count=0;
			}
		}
	}
}	
		
	


