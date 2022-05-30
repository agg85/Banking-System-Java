/**
 * 
 * @author ARYAN GUPTA
 * constructor calls the constructor of the super class, and sets the term of the FDAccount.
 * transfer (from) and withdraw are overridden to prevent the transaction.
 * deposit is overridden to limit no of deposits to one.
 * addInterest adds the amount at the end of each month.
 */
public class FDAccount extends BankAccount implements java.io.Serializable {
	
	private int noOfMonths = 0;
	private int term = 0;
	private double taxDeducted;
	private double interest;
	
	public FDAccount(double balance, String name, String address, int term){
		super(balance, name, address);
		this.term = term;
		this.noOfMonths = term;
	}
	
	public boolean withdraw(double withdrawAmt) {
		System.out.println("Cannot withdraw/transfer amount from an FD Account.");
		return false;
	}
	
	public boolean deposit(double amount) {
		if(noOfTransactions==0) {
			super.deposit(amount);
			return true;
		}
		else {
			System.out.println("Can't deposit more than once.");
			return false;
		}
	}
	
	public boolean addInterest() {
		if(noOfMonths==0)
		{
			System.out.println("Term has ended");
			return false;
		}
		if(this.term<=12) {
			interest = (this.balance*6/100);
			taxDeducted = calculateTax(interest);
		}
		else if(this.term<=36) {
			interest = (this.balance*7/100);
			taxDeducted = calculateTax(interest);
		}
		else {
			interest = (this.balance*8/100);
			taxDeducted = calculateTax(interest);
		}
		noOfTransactions--;
		noOfMonths--;
		return deposit(interest-taxDeducted);
	}
}