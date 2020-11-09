package learn;

public class Factors {
	
	
	public static void main (String args[]) {
		for (int i=2;i<=100;i++) {
			int increment = i % 2 == 0 ? 1 : 2;
			System.out.print("Factors of "+i+" are: ");
			for (int j=1;j<i;j+=increment) {
				if (j==1) continue;
				if (i%j==0) {
					System.out.print(j+" ");
				}
			}
			System.out.println();
		}
	}

}
