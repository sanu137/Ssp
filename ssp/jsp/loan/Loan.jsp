<%@ page import="java.text.DecimalFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Loan Calculation Results</title>
</head>
<body>
	<h1>Loan Calculation Results</h1>
	<%
		double loanAmount = Double.parseDouble(request.getParameter("loanAmount"));
		double annualInterestRate = Double.parseDouble(request.getParameter("annualInterestRate"));
		int years = Integer.parseInt(request.getParameter("years"));
		double monthlyInterestRate = annualInterestRate / 100 / 12;
		int numberOfPayments = years * 12;
		double monthlyPayment = (loanAmount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));
		double totalPayment = monthlyPayment * numberOfPayments;
		DecimalFormat df = new DecimalFormat("0.00");
	%>
	<p>Loan Amount: <%= df.format(loanAmount) %></p>
	<p>Annual Interest Rate: <%= df.format(annualInterestRate) %>%</p>
	<p>Number of Years: <%= years %></p>
	<p>Monthly Payment: <%= df.format(monthlyPayment) %></p>
	<p>Total Payment: <%= df.format(totalPayment) %></p>
</body>
</html>