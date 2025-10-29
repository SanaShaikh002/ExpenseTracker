import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExpenseManager manager = new ExpenseManager();

        while (true) {
            System.out.println("\n==== PERSONAL EXPENSE TRACKER ====");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. View Total Expense");
            System.out.println("4. Clear All Expenses");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Date (YYYY-MM-DD): ");
                    String date = sc.nextLine();
                    System.out.print("Enter Category (Food, Travel, etc.): ");
                    String category = sc.nextLine();
                    System.out.print("Enter Amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter Description: ");
                    String desc = sc.nextLine();

                    Expense expense = new Expense(date, category, amount, desc);
                    manager.addExpense(expense);
                    break;

                case 2:
                    System.out.println("\n--- All Expenses ---");
                    for (Expense e : manager.getAllExpenses()) {
                        System.out.println(e);
                    }
                    break;

                case 3:
                    System.out.println("💰 Total Expense: " + manager.getTotalExpense());
                    break;

                case 4:
                    manager.clearExpenses();
                    break;

                case 5:
                    System.out.println("👋 Exiting... Thank you!");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option! Try again.");
            }
        }
    }
}
