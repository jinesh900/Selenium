package learn;

public class PrimeNumber {
 
	static boolean p;
	public boolean isPrime(int i) {
		p=false;
		for (int j=2;j<i;j++) {
			if (i%j==0) {
				p=true;
				break;
			} 
				
		}
		return p;
	}
	
	public static void main (String args[]) {
		
		PrimeNumber pn = new PrimeNumber();
		System.out.print("Prime Number between 2 to 200 are: ");
		for (int k=2;k<=200;k++) {
			p=pn.isPrime(k);
			if (!p) {
				System.out.print(k+", ");
				
			}
			
		}
		System.out.print("\n ");
	}
}
