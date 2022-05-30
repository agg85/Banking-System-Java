/**
 * 
 * @author ARYAN GUPTA
 * The constructor calls the constructor of the super class which creates a bank account. It also stores the rate of interest passed as parameter.
 * addInterest updates the balance in the account by adding the interest.
 */
public class SavingsAccount extends BankAccount implements java.io.Serializable {
	private double interestRate;
	private double taxDeducted;
	private double interest;
	
	public SavingsAccount(double balance, String name, String address, double interestRate){
		super(balance, name, address);
		this.interestRate = interestRate;
	}
	public void addInterest() {
		interest = (this.getBalance()*interestRate/100);
		taxDeducted = calculateTax(interest);
		super.deposit(interest-taxDeducted);
	}
}