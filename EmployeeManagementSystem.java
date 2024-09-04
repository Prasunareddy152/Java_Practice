import java.util.*;

// Employee class representing an employee
class Employee {
    private int employeeID;
    private String name;
    private String department;
    private double salary;

    // Constructor
    public Employee(int employeeID, String name, String department, double salary) {
        this.employeeID = employeeID;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Getter methods
    public int getEmployeeID() {
        return employeeID;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // toString method for displaying employee details
    @Override
    public String toString() {
        return "Employee ID: " + employeeID +
               ", Name: " + name +
               ", Department: " + department +
               ", Salary: $" + salary;
    }
}

// EmployeeManagementSystem class for managing employees
public class EmployeeManagementSystem {
    private List<Employee> employeeList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem();
        ems.run();
    }

    // Method to display the main menu and handle user choices
    private void run() {
        while (true) {
            System.out.println("\nEmployee Management System Menu:");
            System.out.println("1. Add new employee");
            System.out.println("2. Update employee details");
            System.out.println("3. Delete an employee");
            System.out.println("4. Display all employees");
            System.out.println("5. Search for an employee");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addNewEmployee();
                    break;
                case 2:
                    updateEmployeeDetails();
                    break;
                case 3:
                    deleteEmployee();
                    break;
                case 4:
                    displayAllEmployees();
                    break;
                case 5:
                    searchEmployee();
                    break;
                case 6:
                    System.out.println("Exiting the Employee Management System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
    }

    // Method to add a new employee to the system
    private void addNewEmployee() {
        System.out.println("\nAdding a new employee:");

        try {
            System.out.print("Enter Employee ID: ");
            int employeeID = scanner.nextInt();

            // Check if the employee ID already exists
            if (isEmployeeIDExists(employeeID)) {
                System.out.println("Employee ID already exists. Please choose a different ID.");
                return;
            }

            scanner.nextLine(); // Consume the newline character
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Department: ");
            String department = scanner.nextLine();

            System.out.print("Enter Salary: $");
            double salary = scanner.nextDouble();

            Employee newEmployee = new Employee(employeeID, name, department, salary);
            employeeList.add(newEmployee);
            System.out.println("Employee added successfully!");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid values.");
            scanner.nextLine(); // Consume the invalid input
        }
    }

    // Method to update details of an existing employee
    private void updateEmployeeDetails() {
        System.out.println("\nUpdating employee details:");

        try {
            System.out.print("Enter Employee ID to update: ");
            int employeeID = scanner.nextInt();

            Employee employeeToUpdate = getEmployeeByID(employeeID);

            if (employeeToUpdate == null) {
                System.out.println("Employee not found. Please enter a valid Employee ID.");
                return;
            }

            scanner.nextLine(); // Consume the newline character
            System.out.print("Enter new Name (press Enter to keep current name): ");
            String newName = scanner.nextLine();
            if (!newName.isEmpty()) {
                employeeToUpdate.setName(newName);
            }

            System.out.print("Enter new Department (press Enter to keep current department): ");
            String newDepartment = scanner.nextLine();
            if (!newDepartment.isEmpty()) {
                employeeToUpdate.setDepartment(newDepartment);
            }

            System.out.print("Enter new Salary (press Enter to keep current salary): $");
            String newSalaryInput = scanner.nextLine();
            if (!newSalaryInput.isEmpty()) {
                double newSalary = Double.parseDouble(newSalaryInput);
                employeeToUpdate.setSalary(newSalary);
            }

            System.out.println("Employee details updated successfully!");
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid values.");
            scanner.nextLine(); // Consume the invalid input
        }
    }

    // Method to delete an existing employee from the system
    private void deleteEmployee() {
        System.out.println("\nDeleting an employee:");

        try {
            System.out.print("Enter Employee ID to delete: ");
            int employeeID = scanner.nextInt();

            Employee employeeToDelete = getEmployeeByID(employeeID);

            if (employeeToDelete == null) {
                System.out.println("Employee not found. Please enter a valid Employee ID.");
                return;
            }

            employeeList.remove(employeeToDelete);
            System.out.println("Employee deleted successfully!");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid Employee ID.");
            scanner.nextLine(); // Consume the invalid input
        }
    }

    // Method to display details of all employees
    private void displayAllEmployees() {
        System.out.println("\nDisplaying all employees:");

        if (employeeList.isEmpty()) {
            System.out.println("No employees found in the system.");
        } else {
            employeeList.forEach(System.out::println);
        }
    }

    // Method to search for an employee by their employee ID
    private void searchEmployee() {
        System.out.println("\nSearching for an employee:");

        try {
            System.out.print("Enter Employee ID to search: ");
            int employeeID = scanner.nextInt();

            Employee employee = getEmployeeByID(employeeID);

            if (employee == null) {
                System.out.println("Employee not found. Please enter a valid Employee ID.");
            } else {
                System.out.println("Employee details:\n" + employee);
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid Employee ID.");
            scanner.nextLine(); // Consume the invalid input
        }
    }

    // Helper method to check if an employee ID already exists in the system
    private boolean isEmployeeIDExists(int employeeID) {
        for (Employee employee : employeeList) {
            if (employee.getEmployeeID() == employeeID) {
                return true;
            }
        }
        return false;
    }

    // Helper method to get an employee by their employee ID
    private Employee getEmployeeByID(int employeeID) {
        for (Employee employee : employeeList) {
            if (employee.getEmployeeID() == employeeID) {
                return employee;
            }
        }
        return null;
    }
}
