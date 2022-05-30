/**
 * 
 * @author ARYAN GUPTA
 *
 */
public class Main {
	
	public static void main(String args[]) {
		
		BankAccountMonitored ba = new BankAccountMonitored(6000,"Aryan","Delhi");
		ba.withdraw(50);
		ba.withdraw(100);
		ba.deposit(3000);
		ba.deposit(900);
		ba.deposit(10000);
		ba.withdraw(4000);
		
		ba.displayWithdrawal(102);
		
		ba.depositsList();
		ba.removeTID(200);
		ba.withdrawsList();
	}
}