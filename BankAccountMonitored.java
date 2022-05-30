/**
 * 
 * @author ARYAN GUPTA
 *
 */
import java.util.*;
public class BankAccountMonitored extends BankAccount{
	
	protected LinkedList<Action> deposits = new LinkedList<Action>();
	protected Map<Integer,Double> withdrawals = new HashMap<Integer,Double>(); 
	
	public BankAccountMonitored(double balance, String name, String address) {
		super(balance, name, address);
	}
	
	public class Action {
		private String act;
		private double amount;
		private int tid;
		
		Action(String act,double amount,int tidInp){
			this.act = act;
			this.amount = amount;
			this.tid = tidInp;
		}
	}
	
	public boolean deposit(double depositAmt) {
		if(super.deposit(depositAmt)==false)
			return false;
		Action a = new Action(this.lastTrans.lastTran,depositAmt,this.nod);
		ListIterator<Action> li = deposits.listIterator();
		li.add(a);
		return true;
	}
	
	public boolean withdraw(double withdrawAmt) {
		if(super.withdraw(withdrawAmt)==false)
			return false;
		//Action a = new Action(this.lastTrans.lastTran,withdrawAmt,this.nod);
		withdrawals.put(this.now, withdrawAmt);
		return true;
	}
	
	public boolean displayWithdrawal(int tid) {
		if(withdrawals.containsKey(tid)) {
			System.out.println("Withdrawn amount in TransactionID: "+tid+" is: "+withdrawals.get(tid));
			return true;
		}
		System.out.println("Invalid TransactionID");
		return false;
	}
	
	public void depositsList() {
		System.out.println("The deposits list: ");
		ListIterator<Action> n = deposits.listIterator();
		while(n.hasNext()) {
			System.out.println(((Action)n.next()).amount);
		}
		System.out.println();
	}
	
	public void withdrawsList() {
		System.out.println("The withdrawals list: ");
		for(Integer tid : withdrawals.keySet()) {
			System.out.print(tid+" : "+withdrawals.get(tid)+"\n");
		}
		System.out.println("\n");
	}
	
	public boolean removeTID(int remTID) {
		
		ListIterator<Action> n = deposits.listIterator();
		while(n.hasNext()) {
			if(((Action)n.next()).tid==remTID) {
				n.remove();
				System.out.println("Transaction with tid = "+remTID+" removed.");
				this.depositsList();
				return true;
			}
		}
		return false;
	}
}


//public void allActionsList() {
//	LinkedList.Node n = deposits.getHead();
//	while(n.next!=null) {
//		System.out.println(((Action)n.data).act+": "+((Action)n.data).amount);
//		n = n.next;
//	}
//}

//public void displayTrans() {
//LinkedList.Node n = deposits.getHead();
//System.out.println("\n"+((Action)n.data).act+" "+((Action)n.data).amount);
//n=n.next;
//System.out.println(((Action)n.data).act+" "+((Action)n.data).amount);
//n=n.prev;
//System.out.println(((Action)n.data).act+" "+((Action)n.data).amount+"\n");
//}