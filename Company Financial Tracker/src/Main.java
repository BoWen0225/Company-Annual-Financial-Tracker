import java.io.FileOutputStream;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Main {

    public static void main(String[] args) throws Exception {
        CompanyFinancialTracker tracker = new CompanyFinancialTracker();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the month number (1-12), expense amount, and income amount (enter 0 0 0 to exit):");
            int month = scanner.nextInt();
            double expense = scanner.nextDouble();
            double income = scanner.nextDouble();
            if (month == 0) {
                break;
            }
            tracker.addExpense(month, expense);
            tracker.addIncome(month, income);
        }
        scanner.close();

        // Create a new Excel workbook
        XSSFWorkbook workbook = new XSSFWorkbook();
        // Create a new sheet
        XSSFSheet sheet = workbook.createSheet("Financial Data");
        // Write the annual profit to the first row
        Row row1 = sheet.createRow(0);
        Cell cell1 = row1.createCell(0);
        cell1.setCellValue("Annual Profit");
        cell1 = row1.createCell(1);
        cell1.setCellValue(tracker.getAnnualProfit());

        // Write the mean monthly expenses to the second row
        Row row2 = sheet.createRow(1);
        Cell cell2 = row2.createCell(0);
        cell2.setCellValue("Mean Monthly Expenses");
        cell2 = row2.createCell(1);
        cell2.setCellValue(tracker.getMeanMonthlyExpenses());

        // Write the mean monthly income to the third row
        Row row3 = sheet.createRow(2);
        Cell cell3 = row3.createCell(0);
        cell3.setCellValue("Mean Monthly Income");
        cell3 = row3.createCell(1);
        cell3.setCellValue(tracker.getMeanMonthlyIncome());

        // Write the workbook to a file
        FileOutputStream outputStream = new FileOutputStream("/Users/bowen/financial_data.xlsx");
        workbook.write(outputStream);
        outputStream.close();
        workbook.close();
    }

}