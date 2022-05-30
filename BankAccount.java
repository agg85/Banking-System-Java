/**
 * 
 * @author ARYAN GUPTA
 * 
 * Constructor accepts initial balance (balance), account holder's name (name) and account holder's address (address) and an account is created if minimum balance condition is fulfilled.
 * balance, account number, name of account holder, address of account holder (and number of accounts in the bank) are updated in the constructor.
 * deposit method deposits amount to the bank account, increments number of transactions and returns true on successful transaction.
 * withdraw method withdraws amount from the bank account after checking if it is possible, increments number of transactions and returns true on successful transaction.
 * getBalance method returns the account balance.
 * getNoOfTransactions method returns the account noOfTransactions.
 * transfer method withdraws money from the bank account afer checking if it is possible and deposits it to the specified bank account, and returns true on success.
 * toString() method returns the specified bank account details in the form of a string. 
 */
public abstract class BankAccount implements Comparable<Object>, ITRules {
	
	//FIELD
	protected double balance = 0.0;
	protected int noOfTransactions = 0;
	protected int nod = 199;
	protected int now = 99;
	protected static final double MIN_BAL = 2000;
	protected static final long ST_ACC_NO = 180020131111L;
	protected static int noOfAcc = 0;
	protected long accNo;
	LastTransaction lastTrans = new LastTransaction(); 
	PersonalDetails perDetails;
	protected double taxDeducted;
	
	//CONSTRUCTOR
	public BankAccount(double balance, String name, String address) {
		if(balance<MIN_BAL) {
			System.out.println("Balance less than required minimum balance to create an account.");
		}
		else {
			this.balance = balance;
			this.accNo = ST_ACC_NO + noOfAcc;
			noOfAcc++;
			perDetails = new PersonalDetails(name,address);
		}
	}
	
	//METHODS
	public boolean deposit(double depositAmt) {
		balance += depositAmt;
		noOfTransactions++;
		nod++;
		this.lastTrans.lastTran = "Deposit";
		return true;
	}
	
	public boolean withdraw(double withdrawAmt) {
		if(balance>=(withdrawAmt + MIN_BAL))
		{
			balance -= withdrawAmt;
			noOfTransactions++;
			now++;
			this.lastTrans.lastTran = "Withdraw";
			return true;
		}
		else
		{
			System.out.println("Not enough balance");
			return false;
		}
	}
	
	public double getBalance() {
		return balance;
	}
	
	public double getNoOfTransactions() {
		return noOfTransactions;
	}
	
	public boolean transfer (BankAccount b , double transferAmt) {		
		if(withdraw(transferAmt)) {
			b.deposit(transferAmt);
			this.lastTrans.lastTran = "Transfer";
			b.lastTrans.lastTran = "Transfer";
			return true;
		}
		else
		{
			System.out.println("Not enough balance");
			return false;
		}
	}
	
	public int compareTo(Object otherBA) {
		BankAccount other = (BankAccount) otherBA;
		if(taxDeducted>other.taxDeducted) 
			return 1;
		else if(taxDeducted>other.taxDeducted) 
			return 0;
		else
			return -1;
	}
	
	public double calculateTax(double interest){
		if(interest>SLAB4) 
			taxDeducted = ((interest-100000)*TAX4)+(25000*TAX3)+(45000*TAX2)+(20000*TAX1);
		else if(interest>SLAB3)
			taxDeducted = ((interest-75000)*TAX3)+(45000*TAX2)+(20000*TAX1);
		else if(interest>SLAB2)
			taxDeducted = ((interest-30000)*TAX2)+(20000*TAX1);
		else if(interest>SLAB1)
			taxDeducted = (interest-10000)*TAX1;
		else
			taxDeducted = 0;
		return taxDeducted;
	}
	
	@Override
	public String toString() {
		return String.format("Account number: "+accNo+perDetails+lastTrans+"\n");
	}
}

class LastTransaction {
	String lastTran = "";
	public String toString() {  
		return String.format("\nLast Transaction: "+lastTran);
	}
}

class PersonalDetails {
	private String name;
	private String address;
	PersonalDetails(String name, String address) {
		this.name = name;
		this.address = address;
	}
	@Override
	public String toString() {
		return String.format("\nName of the Account holder: "+name+"\nAddress: "+address);
	}
}