import java.io.*;
import java.util.*;

public class ExpenseManager {
    private static final String FILE_NAME = "expenses.txt";

    public void addExpense(Expense expense) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bw.write(expense.toString());
            bw.newLine();
            System.out.println("✅ Expense added successfully!");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public List<Expense> getAllExpenses() {
        List<Expense> expenses = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                expenses.add(Expense.fromString(line));
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return expenses;
    }

    public double getTotalExpense() {
        List<Expense> expenses = getAllExpenses();
        double total = 0;
        for (Expense e : expenses) {
            total += e.getAmount();
        }
        return total;
    }

    public void clearExpenses() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            pw.print("");
            System.out.println("🧹 All expenses cleared!");
        } catch (IOException e) {
            System.out.println("Error clearing file: " + e.getMessage());
        }
    }
}
