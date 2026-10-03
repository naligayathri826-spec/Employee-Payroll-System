import java.util.ArrayList;
import java.util.Scanner;

/**
 * EmployeePayrollSystem.java
 * Main application class for the Employee Payroll System.
 * Manages employee records using an ArrayList and provides a console-based
 * interactive menu to add, view, search, and generate salary slips.
 */
public class EmployeePayrollSystem {

    // Storage for employee records using ArrayList
    private final ArrayList<Employee> employeeList;

    /**
     * Constructor initializing the employee collection.
     */
    public EmployeePayrollSystem() {
        this.employeeList = new ArrayList<>();
    }

    /**
     * Finds an employee by their unique Employee ID.
     *
     * @param id The employee ID to search for.
     * @return Employee object if found, null otherwise.
     */
    public Employee findEmployeeById(int id) {
        for (Employee emp : employeeList) {
            if (emp.getEmployeeId() == id) {
                return emp;
            }
        }
        return null;
    }

    /**
     * Checks if an employee with the given ID already exists.
     *
     * @param id The employee ID to check.
     * @return true if an employee exists with the ID, false otherwise.
     */
    public boolean isEmployeeIdTaken(int id) {
        return findEmployeeById(id) != null;
    }

    /**
     * Adds an employee to the system directly (useful for testing or batch loading).
     *
     * @param employee The employee object to add.
     * @return true if added successfully, false if duplicate ID.
     */
    public boolean addEmployeeRecord(Employee employee) {
        if (employee == null || isEmployeeIdTaken(employee.getEmployeeId())) {
            return false;
        }
        employeeList.add(employee);
        return true;
    }

    /**
     * Interactive flow to add a new employee via console input.
     *
     * @param scanner Scanner instance for user input.
     */
    public void addEmployee(Scanner scanner) {
        System.out.println("\n----------------------------------------");
        System.out.println("            ADD NEW EMPLOYEE            ");
        System.out.println("----------------------------------------");

        int id;
        while (true) {
            id = readPositiveInt(scanner, "Enter Employee ID: ");
            if (isEmployeeIdTaken(id)) {
                System.out.println("Error: Employee ID " + id + " already exists! Please enter a unique ID.");
            } else {
                break;
            }
        }

        String name = readNonEmptyString(scanner, "Enter Employee Name: ");
        String department = readNonEmptyString(scanner, "Enter Department: ");
        double basicSalary = readNonNegativeDouble(scanner, "Enter Basic Salary: ");
        double allowances = readNonNegativeDouble(scanner, "Enter Allowances: ");
        double deductions = readNonNegativeDouble(scanner, "Enter Deductions: ");

        Employee employee = new Employee(id, name, department, basicSalary, allowances, deductions);
        employeeList.add(employee);

        System.out.println("\nEmployee added successfully.");
    }

    /**
     * Displays all stored employees in a clean tabular format.
     */
    public void viewAllEmployees() {
        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.println("                              ALL EMPLOYEE RECORDS                              ");
        System.out.println("--------------------------------------------------------------------------------");

        if (employeeList.isEmpty()) {
            System.out.println("No employee records found.");
            System.out.println("--------------------------------------------------------------------------------");
            return;
        }

        System.out.printf("%-8s | %-22s | %-16s | %-13s | %-13s%n",
                "ID", "Name", "Department", "Gross Salary", "Net Salary");
        System.out.println("--------------------------------------------------------------------------------");

        for (Employee emp : employeeList) {
            System.out.printf("%-8d | %-22s | %-16s | %-13.2f | %-13.2f%n",
                    emp.getEmployeeId(),
                    emp.getEmployeeName(),
                    emp.getDepartment(),
                    emp.calculateGrossSalary(),
                    emp.calculateNetSalary());
        }
        System.out.println("--------------------------------------------------------------------------------");
    }

    /**
     * Searches for an employee by ID and displays complete salary details.
     *
     * @param scanner Scanner instance for user input.
     */
    public void searchEmployee(Scanner scanner) {
        System.out.println("\n----------------------------------------");
        System.out.println("            SEARCH EMPLOYEE             ");
        System.out.println("----------------------------------------");

        int id = readPositiveInt(scanner, "Enter Employee ID to search: ");
        Employee emp = findEmployeeById(id);

        if (emp != null) {
            System.out.println("\nEmployee Record Found:\n");
            emp.displaySalarySlip();
        } else {
            System.out.println("\nEmployee not found.");
        }
    }

    /**
     * Generates and prints the formatted salary slip for a given employee ID.
     *
     * @param scanner Scanner instance for user input.
     */
    public void generateSalarySlip(Scanner scanner) {
        System.out.println("\n----------------------------------------");
        System.out.println("          GENERATE SALARY SLIP          ");
        System.out.println("----------------------------------------");

        int id = readPositiveInt(scanner, "Enter Employee ID: ");
        Employee emp = findEmployeeById(id);

        if (emp != null) {
            System.out.println();
            emp.displaySalarySlip();
        } else {
            System.out.println("\nEmployee not found.");
        }
    }

    // --- Helper Input Methods with Strict Validation ---

    /**
     * Reads a non-empty string from console.
     */
    private String readNonEmptyString(Scanner scanner, String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Error: Input cannot be empty. Please try again.");
        }
    }

    /**
     * Reads a positive integer (greater than 0) from console.
     */
    private int readPositiveInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(input);
                if (value > 0) {
                    return value;
                } else {
                    System.out.println("Error: Number must be greater than 0. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid numeric input. Please enter a valid integer.");
            }
        }
    }

    /**
     * Reads a non-negative double (greater than or equal to 0.0) from console.
     */
    private double readNonNegativeDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                double value = Double.parseDouble(input);
                if (value >= 0.0) {
                    return value;
                } else {
                    System.out.println("Error: Amount cannot be negative. Please enter a value >= 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid numeric input. Please enter a valid decimal/number.");
            }
        }
    }

    /**
     * Displays the main menu options.
     */
    public static void displayMenu() {
        System.out.println("\n========================================");
        System.out.println("        EMPLOYEE PAYROLL SYSTEM         ");
        System.out.println("========================================");
        System.out.println("1. Add Employee");
        System.out.println("2. View All Employees");
        System.out.println("3. Search Employee");
        System.out.println("4. Generate Salary Slip");
        System.out.println("5. Exit");
        System.out.println("========================================");
        System.out.print("Enter your choice: ");
    }

    /**
     * Main method running the interactive console application loop.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        EmployeePayrollSystem system = new EmployeePayrollSystem();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            displayMenu();
            String choiceInput = scanner.nextLine().trim();

            int choice;
            try {
                choice = Integer.parseInt(choiceInput);
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid choice! Please enter a number between 1 and 5.");
                continue;
            }

            switch (choice) {
                case 1:
                    system.addEmployee(scanner);
                    break;
                case 2:
                    system.viewAllEmployees();
                    break;
                case 3:
                    system.searchEmployee(scanner);
                    break;
                case 4:
                    system.generateSalarySlip(scanner);
                    break;
                case 5:
                    System.out.println("\nThank you for using the Employee Payroll System. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("\nInvalid choice! Please enter a number between 1 and 5.");
                    break;
            }
        }

        scanner.close();
    }
}
