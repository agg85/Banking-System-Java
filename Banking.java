/**
 * 
 * @author ARYAN GUPTA
 *
 * BankAccount object ba1 with parent's name and address is created.
 * BankAccount object ba2 with my name and address is created.
 * amount of 1000 rupees deposited to my account (ba2) and required details printed.
 * amount of 500 rupees withdrawn from my account (ba2) and required details printed.
 * amount of 1000 rupees transferred from parent's account (ba1) to my account (ba2) and required details of my account printed.
 */

public class Banking {

	public static void main(String[] args) {
		
		BankAccount b1 = new CheckingAccount(3000,"Name1","Add1",5);
		BankAccount b2 = new SavingsAccount(3000,"Name2","Add1",5);
		BankAccount b3 = new FDAccount(3000,"Name2","Add1",5);
		CheckingAccount b4 = new CheckingAccount(3000,"Name3","Add1",5);
		SavingsAccount b5 = new SavingsAccount(3000,"Name4","Add1",5);
		FDAccount b6 = new FDAccount(3000,"Name5","Add1",5);
		
		b1.deposit(1000);
		b1.withdraw(500);
		b1.transfer(b2,5);
		b1.transfer(b3,5);
		b1.transfer(b4,5);
		b1.transfer(b5,5);
		b1.transfer(b6,5);
		
		b2.deposit(1000);
		b2.withdraw(500);
		b2.transfer(b1,5);
		b2.transfer(b3,5);
		b2.transfer(b4,5);
		b2.transfer(b5,5);
		b2.transfer(b6,5);
		
		b3.deposit(1000);
		b3.withdraw(500);
		b3.transfer(b1,5);
		b3.transfer(b2,5);
		b3.transfer(b4,5);
		b3.transfer(b5,5);
		b3.transfer(b6,5);
		
		b4.deposit(1000);
		b4.withdraw(500);
		b4.transfer(b2,5);
		b4.transfer(b3,5);
		b4.transfer(b2,5);
		b4.transfer(b5,5);
		b4.transfer(b6,5);
		
		b5.deposit(1000);
		b5.withdraw(500);
		b5.transfer(b2,5);
		b5.transfer(b3,5);
		b5.transfer(b4,5);
		b5.transfer(b1,5);
		b5.transfer(b6,5);
		
		b6.deposit(1000);
		b6.withdraw(500);
		b6.transfer(b2,5);
		b6.transfer(b3,5);
		b6.transfer(b4,5);
		b6.transfer(b5,5);
		b6.transfer(b1,5);
	}
}