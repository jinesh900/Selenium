package learn;

public class ReverseString {
	String t="";
	
	public void reverseString(String str1) {
		
			for (int i=str1.length()-1;i>=0;i--) {
			t=t+str1.charAt(i);
			
		}
		System.out.println(t);
		System.out.println(str1);
		if (str1.equals(t)) {
			System.out.println(str1+" is a palindrome");
		}
	}
	
	public static void main (String args[]) {
		ReverseString r = new ReverseString();
		r.reverseString("hannah");
	}

}
