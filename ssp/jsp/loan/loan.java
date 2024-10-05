package p1;

public class loan {
private double interestRate;
private int numOfYears;
private double loanAmount;
private java.util.Date loanDate;

public loan() {
	this(7.5,30,100000);
}

public loan(double interestRate, int numOfYears, double loanAmount) {
	this.interestRate = interestRate;
	this.numOfYears = numOfYears;
	this.loanAmount = loanAmount;
	loanDate = new java.util.Date();
}

public double getInterestRate() {
	return interestRate;
}

public void setInterestRate(double interestRate) {
	this.interestRate = interestRate;
}

public int getNumOfYears() {
	return numOfYears;
}

public void setNumOfYears(int numOfYears) {
	this.numOfYears = numOfYears;
}

public double getLoanAmount() {
	return loanAmount;
}

public void setLoanAmount(double loanAmount) {
	this.loanAmount = loanAmount;
}

public java.util.Date getLoanDate() {
	return loanDate;
}

public void setLoanDate(java.util.Date loanDate) {
	this.loanDate = loanDate;
}
public double monthlyPayment() {
    double monthlyInterestRate = (interestRate / 100) / 12;
    int numberOfPayments = numOfYears * 12;
    return (loanAmount * monthlyInterestRate) / 
           (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));
}
public double totalPayment() {
    return monthlyPayment() * numOfYears * 12;
}
}