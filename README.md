# Employee Payroll System

A robust, console-based **Employee Payroll Management System** developed in **Core Java**. This application allows organizations to manage employee records, calculate gross salary, compute applicable taxes using progressive tax slabs, apply deductions, compute net salary, and generate formatted salary slips.

---

## 📋 Table of Contents
- [Project Description](#project-description)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [OOP Concepts Used](#oop-concepts-used)
- [Salary Calculation Formula](#salary-calculation-formula)
- [Tax Slabs](#tax-slabs)
- [Project Structure](#project-structure)
- [How to Compile](#how-to-compile)
- [How to Run](#how-to-run)
- [Sample Usage](#sample-usage)
- [Future Enhancements](#future-enhancements)

---

## 📖 Project Description
The **Employee Payroll System** is designed for efficient and error-free payroll processing in a terminal environment. Built entirely with Core Java and Java Collections Framework (`ArrayList`), the application demonstrates fundamental and intermediate Object-Oriented Programming (OOP) principles, clean code structure, input validation, and defensive programming practices.

---

## ✨ Features
1. **Add Employee Record**:
   - Captures unique Employee ID, Full Name, Department, Basic Salary, Allowances, and Deductions.
   - Prevents duplicate employee IDs.
   - Validates all numeric inputs (rejects negative numbers and non-numeric inputs).
2. **View All Employees**:
   - Tabular presentation displaying ID, Name, Department, Gross Salary, and Net Salary.
   - Handles empty records gracefully with a clear message.
3. **Search Employee**:
   - Quick lookup by unique Employee ID.
   - Displays full salary breakdown when found.
4. **Generate Salary Slip**:
   - Generates a neat, formatted salary slip for any employee.
   - Displays itemized Basic Salary, Allowances, Gross Salary, Tax, Deductions, and Net Salary.
5. **Robust Input Validation**:
   - Prevents program crashes from invalid input or non-numeric tokens.
   - Handles scanner token traps reliably.

---

## 🛠 Technologies Used
- **Language**: Java (JDK 8 or higher, tested on JDK 21 LTS)
- **Data Structures**: Java Collections Framework (`ArrayList`)
- **Console I/O**: `java.util.Scanner`
- **Build / Execution**: Standard Java CLI (`javac`, `java`)

---

## 🧠 OOP Concepts Used
- **Encapsulation**: Private state variables in `Employee` class with public getters, setters, and business logic methods.
- **Data Hiding & Validation**: Setters and helper methods protect class invariants against negative monetary values.
- **Classes and Objects**: Clean separation between model (`Employee.java`) and controller/application workflow (`EmployeePayrollSystem.java`).
- **Constructors**: Parameterized constructors to initialize consistent employee states.
- **Single Responsibility Principle (SRP)**: Each class and method performs a single well-defined task.

---

## ➗ Salary Calculation Formula

### 1. Gross Salary
$$\text{Gross Salary} = \text{Basic Salary} + \text{Allowances}$$

### 2. Net Salary
$$\text{Net Salary} = \text{Gross Salary} - \text{Tax} - \text{Deductions}$$

---

## 📊 Tax Slabs
Tax is computed automatically based on the employee's **Gross Salary**:

| Gross Salary Range | Tax Rate (%) |
| :--- | :--- |
| **Gross Salary $\le$ ₹25,000** | **0%** |
| **Gross Salary > ₹25,000 and $\le$ ₹50,000** | **5%** of Gross Salary |
| **Gross Salary > ₹50,000 and $\le$ ₹1,00,000** | **10%** of Gross Salary |
| **Gross Salary > ₹1,00,000** | **15%** of Gross Salary |

---

## 📁 Project Structure

```
EmployeePayrollSystem/
├── Employee.java                # Employee model class with encapsulation & payroll logic
├── EmployeePayrollSystem.java   # Main application class containing menu & ArrayList storage
├── README.md                    # Project overview, instructions, and specifications
├── PROJECT_DOCUMENTATION.md     # Detailed technical & functional documentation
└── .gitignore                   # Git ignore file for Java artifacts and IDE files
```

---

## ⚙️ How to Compile
Ensure you have the Java Development Kit (JDK) installed and available in your PATH:

```bash
javac Employee.java EmployeePayrollSystem.java
```

---

## 🚀 How to Run
Run the compiled application using:

```bash
java EmployeePayrollSystem
```

---

## 💻 Sample Usage

### Main Menu
```
========================================
        EMPLOYEE PAYROLL SYSTEM         
========================================
1. Add Employee
2. View All Employees
3. Search Employee
4. Generate Salary Slip
5. Exit
========================================
Enter your choice: 1
```

### Adding an Employee
```
----------------------------------------
            ADD NEW EMPLOYEE            
----------------------------------------
Enter Employee ID: 101
Enter Employee Name: John Doe
Enter Department: IT
Enter Basic Salary: 50000
Enter Allowances: 10000
Enter Deductions: 2000

Employee added successfully.
```

### Viewing All Records
```
--------------------------------------------------------------------------------
                              ALL EMPLOYEE RECORDS                              
--------------------------------------------------------------------------------
ID       | Name                   | Department       | Gross Salary  | Net Salary   
--------------------------------------------------------------------------------
101      | John Doe               | IT               | 60000.00      | 52000.00     
--------------------------------------------------------------------------------
```

### Salary Slip Output
```
========================================
           EMPLOYEE SALARY SLIP         
========================================
Employee ID    : 101
Employee Name  : John Doe
Department     : IT
----------------------------------------
Basic Salary   : 50000.00
Allowances     : 10000.00
Gross Salary   : 60000.00
Tax            : 6000.00
Deductions     : 2000.00
Net Salary     : 52000.00
========================================
```

---

## 🔮 Future Enhancements
- **Persistent Storage**: Integration with file storage (CSV/JSON/Serialized objects) or SQL Database (JDBC).
- **Payroll History**: Tracking monthly and annual salary payment history.
- **Role-Based Access Control**: Admin and Employee role permissions.
- **Export Capabilities**: Export salary slips as PDF or CSV.
