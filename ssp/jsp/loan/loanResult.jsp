<%@ page import="p1.loan" %>
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
        loan ln = new loan(annualInterestRate, years, loanAmount);
    %>
    <p><strong>Loan Amount			:</strong> Rs.<%= ln.getLoanAmount() %></p>
    <p><strong>Annual Interest Rate :</strong> <%= ln.getInterestRate() %>%</p>
    <p><strong>Number of Years		:</strong> <%= ln.getNumOfYears() %></p>
    <p><strong>Monthly Payment		:</strong> Rs.<%= String.format("%.2f", ln.monthlyPayment()) %></p>
    <p><strong>Total Payment		:</strong> Rs.<%= String.format("%.2f", ln.totalPayment()) %></p>
</body>
</html>