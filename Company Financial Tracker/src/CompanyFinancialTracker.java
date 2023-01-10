import java.util.Scanner;

public class CompanyFinancialTracker {

    // Array to store expenses and income for each month
    private double[] expenses;
    private double[] income;

    // Constructor
    public CompanyFinancialTracker() {
        expenses = new double[12];
        income = new double[12];
    }

    // Add an expense for a given month
    public void addExpense(int month, double amount) {
        expenses[month - 1] += amount;
    }

    // Add income for a given month
    public void addIncome(int month, double amount) {
        income[month - 1] += amount;
    }

    // Get the total expenses for the year
    public double getTotalExpenses() {
        double total = 0.0;
        for (double expense : expenses) {
            total += expense;
        }
        return total;
    }

    // Get the total income for the year
    public double getTotalIncome() {
        double total = 0.0;
        for (double inc : income) {
            total += inc;
        }
        return total;
    }

    // Get the annual profit
    public double getAnnualProfit() {
        return getTotalIncome() - getTotalExpenses();
    }

    // Get the mean monthly expenses
    public double getMeanMonthlyExpenses() {
        if (expenses.length == 0) {
            return 0.0;
        }
        return getTotalExpenses() / expenses.length;
    }

    // Get the mean monthly income
    public double getMeanMonthlyIncome() {
        if (income.length == 0) {
            return 0.0;
        }
        return getTotalIncome() / income.length;
    }

}