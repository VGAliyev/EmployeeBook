package EmployeeBook;

public class Employee {
    private final String employeeFullName;
    private float salary;
    private int department;

    private static int counter = 0;
    private final int id;

    /**
     * Create new employee
     * @param employeeFullName - full name employee
     * @param salary           - employee salary
     * @param department       - employee department (1 - 5)
     */
    public Employee(String employeeFullName, float salary, int department) {
        this.employeeFullName = employeeFullName;
        this.salary = salary;
        this.department = department;
        counter++;
        this.id = counter;
    }

    public String getEmployeeFullName() {
        return employeeFullName;
    }

    public float getSalary() {
        return salary;
    }

    public int getDepartment() {
        return department;
    }

    public int getId() {
        return id;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return id + ": " + employeeFullName +
                ", salary: " + salary +
                ", department: " + department;
    }
}
