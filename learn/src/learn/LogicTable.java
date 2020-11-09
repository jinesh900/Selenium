package learn;

public class LogicTable {
	
	
	public void printOutput(boolean p1) {
		if (p1) {
			System.out.print(1);
		}else {
			System.out.print(0);
		}
		System.out.print("\t");
		//System.out.println(p1+"\t"+q1+"\t"+(p1&q1)+"\t"+(p1|q1)+"\t"+(p1^q1)+"\t"+(!p1));
		
	}
	
	public void callPrint(boolean p2,boolean q2) {
		//printOutput(p2);
		//printOutput(q2);
		System.out.print(p2+"\t");
		System.out.print(q2+"\t");
		printOutput(p2&q2);
		printOutput(p2|q2);
		printOutput(p2^q2);
		printOutput(!p2);
		System.out.print("\n");
		
	}
	public static void main (String args[]) {
		LogicTable lt = new LogicTable();
		System.out.println("P\tQ\tAND\tOR\tXOR\tNOT");
		lt.callPrint(true,true);
		lt.callPrint(true,false);
		lt.callPrint(false,true);
		lt.callPrint(false,false);
		
	}

}
