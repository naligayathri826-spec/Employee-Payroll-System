/**
 * Employee.java
 * Model class representing an Employee in the Employee Payroll System.
 * Demonstrates Object-Oriented Programming (OOP) principles including
 * Encapsulation, Data Hiding, and Business Logic Calculation methods.
 */
public class Employee {

    // Private fields for encapsulation
    private int employeeId;
    private String employeeName;
    private String department;
    private double basicSalary;
    private double allowances;
    private double deductions;

    /**
     * Parameterized Constructor to initialize all employee details.
     *
     * @param employeeId   Unique identifier for the employee
     * @param employeeName Full name of the employee
     * @param department   Department where the employee works
     * @param basicSalary  Base salary amount (must be non-negative)
     * @param allowances   Additional allowances (must be non-negative)
     * @param deductions   Salary deductions (must be non-negative)
     */
    public Employee(int employeeId, String employeeName, String department,
                    double basicSalary, double allowances, double deductions) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.department = department;
        this.basicSalary = basicSalary;
        this.allowances = allowances;
        this.deductions = deductions;
    }

    // --- Getter and Setter Methods ---

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        if (basicSalary >= 0) {
            this.basicSalary = basicSalary;
        }
    }

    public double getAllowances() {
        return allowances;
    }

    public void setAllowances(double allowances) {
        if (allowances >= 0) {
            this.allowances = allowances;
        }
    }

    public double getDeductions() {
        return deductions;
    }

    public void setDeductions(double deductions) {
        if (deductions >= 0) {
            this.deductions = deductions;
        }
    }

    // --- Business Logic Methods ---

    /**
     * Calculates Gross Salary:
     * Gross Salary = Basic Salary + Allowances
     *
     * @return Calculated gross salary
     */
    public double calculateGrossSalary() {
        return this.basicSalary + this.allowances;
    }

    /**
     * Calculates Tax based on predefined progressive tax slabs:
     * - Gross Salary <= 25,000           -> 0% tax
     * - Gross Salary > 25,000 to 50,000   -> 5% tax
     * - Gross Salary > 50,000 to 1,00,000 -> 10% tax
     * - Gross Salary > 1,00,000          -> 15% tax
     *
     * @return Calculated tax amount
     */
    public double calculateTax() {
        double grossSalary = calculateGrossSalary();

        if (grossSalary <= 25000.0) {
            return 0.0;
        } else if (grossSalary <= 50000.0) {
            return grossSalary * 0.05;
        } else if (grossSalary <= 100000.0) {
            return grossSalary * 0.10;
        } else {
            return grossSalary * 0.15;
        }
    }

    /**
     * Calculates Net Salary:
     * Net Salary = Gross Salary - Tax - Deductions
     *
     * @return Calculated net salary
     */
    public double calculateNetSalary() {
        double grossSalary = calculateGrossSalary();
        double tax = calculateTax();
        return grossSalary - tax - this.deductions;
    }

    /**
     * Generates and prints the formatted salary slip for this employee.
     */
    public void displaySalarySlip() {
        System.out.println("========================================");
        System.out.println("           EMPLOYEE SALARY SLIP         ");
        System.out.println("========================================");
        System.out.printf("Employee ID    : %d%n", this.employeeId);
        System.out.printf("Employee Name  : %s%n", this.employeeName);
        System.out.printf("Department     : %s%n", this.department);
        System.out.println("----------------------------------------");
        System.out.printf("Basic Salary   : %.2f%n", this.basicSalary);
        System.out.printf("Allowances     : %.2f%n", this.allowances);
        System.out.printf("Gross Salary   : %.2f%n", calculateGrossSalary());
        System.out.printf("Tax            : %.2f%n", calculateTax());
        System.out.printf("Deductions     : %.2f%n", this.deductions);
        System.out.printf("Net Salary     : %.2f%n", calculateNetSalary());
        System.out.println("========================================");
    }

    /**
     * Displays comprehensive details of the employee.
     */
    public void displayDetails() {
        displaySalarySlip();
    }
}
