
public interface ITRules {
	int SLAB4=100000;
	int SLAB3=75000;
	int SLAB2=30000;
	int SLAB1=10000;
	double TAX4=10/100;
	double TAX3=8/100;
	double TAX2=4/100;
	double TAX1=3/100;
	double calculateTax(double amount);
}