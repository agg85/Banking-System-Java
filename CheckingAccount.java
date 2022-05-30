/**
 * 
 * @author ARYAN GUPTA
 * constructor calls the constructor of the super class.
 * transactionCount keeps record of the no of transactions in the month. 
 * deposit and withdraw are overridden to increase transactionCount.
 * deductFees deducts the fees levied at the end of each month on the number of transactions that exceed the free limit.
 */
public class CheckingAccount extends BankAccount implements java.io.Serializable {

	private static final double FEES = 100.00;
	private static final int FREETRANS = 5;
	private int transactionCount = 0;
	private double interestRate;
	private double taxDeducted;
	private double interest;
	
	public CheckingAccount(double balance, String name, String address, double interestRate){
		super(balance, name, address);
		this.interestRate = interestRate;
	}
	
	public boolean deposit(double depositAmt) {
		super.deposit(depositAmt);
		transactionCount++;
		return true;
	}
	
	public boolean withdraw(double withdrawAmt) {
		if(super.withdraw(withdrawAmt)) {
			transactionCount++;
			return true;
		}
		else
			return false;
	}
	
	public void deductFees() {
		if(transactionCount-FREETRANS<=0)
			return;
		withdraw(FEES*(transactionCount-FREETRANS));
		transactionCount = 0;
	}

	public void addInterest() {
		interest = (this.getBalance()*interestRate/100);
		taxDeducted = calculateTax(interest);
		super.deposit(interest-taxDeducted);
	}
}