package EmployeeBook;

import java.util.ArrayList;

public class EmployeeBook {
    private final Employee[] employees = new Employee[10];

    /**
     * Get all employees from array (all employee information)
     */
    public void printAllEmployees() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    /**
     * Get payroll costs for all employees
     *
     * @return float - payroll costs for all employees
     */
    public float getSalaryAllEmployees() {
        float result = 0.0f;

        for (Employee employee : employees) {
            if (employee != null) {
                result += employee.getSalary();
            }
        }

        return result;
    }

    /**
     * Minimum wage employee
     *
     * @return String - full name minimum wage employee
     */
    public String minSalaryEmployee() {
        int index = getFirstNotNullEmployeeIndex();
        float min = employees[index].getSalary();

        for (int i = index; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getSalary() < min) {
                    min = employees[i].getSalary();
                    index = i;
                }
            }
        }

        return employees[index].getEmployeeFullName();
    }

    /**
     * Highest paid employee
     *
     * @return String - full name highest paid employee
     */
    public String maxSalaryEmployee() {
        int index = getFirstNotNullEmployeeIndex();
        float max = employees[index].getSalary();

        for (int i = 1; i < employees.length; i++) {
            if (employees[i].getSalary() > max) {
                max = employees[i].getSalary();
                index = i;
            }
        }

        return employees[index].getEmployeeFullName();
    }

    /**
     * Average salary
     *
     * @return float - average salary
     */
    public float averageSalary() {
        int employeeNum = 0; // number of employees
        for (Employee employee : employees) {
            if (employee != null) {
                employeeNum++;
            }
        }
        // Round the return value to two decimal places
        int i = (int) (getSalaryAllEmployees() / employeeNum * 100);
        return (float) i / 100.0F;
    }

    /**
     * Get all employees from array (only full name)
     */
    public void getEmployeeFullNames() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getEmployeeFullName());
            }
        }
    }

    /**
     * Index salary for all employee
     *
     * @param index - percentage index
     */
    public void indexSalary(int index) {
        for (Employee employee :
                employees) {
            if (employee != null) {
                employee.setSalary(employee.getSalary() * index / 100.0F + employee.getSalary());
            }
        }
    }

    /**
     * Minimum wage employee for department
     *
     * @param department - department
     * @return String - full name minimum wage employee
     */
    public String minSalaryEmployeeDepartment(int department) {
        Employee[] employeesByDepartment = getEmployeesByDepartment(department);

        int j = 0;
        float min = employeesByDepartment[0].getSalary();

        for (int i = 1; i < employeesByDepartment.length; i++) {
            if (employeesByDepartment[i].getSalary() < min) {
                min = employeesByDepartment[i].getSalary();
                j = i;
            }
        }

        return employeesByDepartment[j].getEmployeeFullName();
    }

    /**
     * Highest paid employee for department
     *
     * @param department - department
     * @return String - full name highest paid employee
     */
    public String maxSalaryEmployeeDepartment(int department) {
        Employee[] employeesByDepartment = getEmployeesByDepartment(department);

        int j = 0;
        float max = employeesByDepartment[0].getSalary();

        for (int i = 1; i < employeesByDepartment.length; i++) {
            if (employeesByDepartment[i].getSalary() > max) {
                max = employeesByDepartment[i].getSalary();
                j = i;
            }
        }

        return employeesByDepartment[j].getEmployeeFullName();
    }

    public float getSalaryDepartmentEmployees(int department) {
        Employee[] employeesByDepartment = getEmployeesByDepartment(department);

        float result = 0.0F;

        for (Employee employee :
                employeesByDepartment) {
            result += employee.getSalary();
        }

        return result;
    }

    /**
     * Average salary for department
     *
     * @param department - department
     * @return float - average salary (rounded to two decimal places)
     */
    public float averageSalaryDepartment(int department) {
        Employee[] employeesByDepartment = getEmployeesByDepartment(department);

        float result = 0.0F;

        for (Employee employee : employeesByDepartment) {
            result += employee.getSalary() / employeesByDepartment.length;
        }

        // До вывода результата, округляем до двух цифр (копеек) после запятой
        int i = (int) (result * 100);
        return  (float) i / 100;
    }

    /**
     * Index salary for employee by department
     *
     * @param index - percentage index
     * @param department - department
     */
    public void indexSalaryByDepartment (int index, int department) {
        Employee[] employeesByDepartment = getEmployeesByDepartment(department);

        for (Employee employee : employeesByDepartment) {
            employee.setSalary(employee.getSalary() + employee.getSalary() * index);
        }
    }

    /**
     * Output to the console of department employees
     *
     * @param department - department
     */
    public void printEmployeesByDepartment(int department) {
        Employee[] employeesByDepartment = getEmployeesByDepartment(department);

        for (Employee employee :
                employeesByDepartment) {
            System.out.println(stringEmployeeWithoutDepartment(employee));
        }
    }

    /**
     * Output to the console of employees with lower salary
     *
     * @param salary - given salary
     */
    public void printEmployeesWithLowerSalary(float salary) {
        for (Employee employee :
                employees) {
            if (employee != null) {
                if (employee.getSalary() < salary) {
                    System.out.println(stringEmployeeWithoutDepartment(employee));
                }
            }
        }
    }

    /**
     * Output to the console of employees with higher or equal salary
     *
     * @param salary - given salary
     */
    public void printEmployeesWithHigherSalary(float salary) {
        for (Employee employee :
                employees) {
            if (employee != null) {
                if (employee.getSalary() >= salary) {
                    System.out.println(stringEmployeeWithoutDepartment(employee));
                }
            }
        }
    }

    /**
     * Add employee
     *
     * @param fullName String - full name employee
     * @param salary float - employee salary
     * @param department int - department
     *
     * @return boolean - true, if adding an employee was successful, else false
     */
    public boolean add(String fullName, float salary, int department) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = new Employee(fullName, salary, department);
                return true;
            }
        }
        return false;
    }

    /**
     * Delete employee by full name
     *
     * @param fullName - full name employee
     *
     * @return boolean - true, if deleting an employee was successful, else false
     */
    public boolean delete(String fullName) {
        if (fullName != null) {
            for (int i = 0; i < employees.length; i++) {
                if (employees[i] != null) {
                    if (employees[i].getEmployeeFullName().equals(fullName)) {
                        employees[i] = null;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Delete employee by ID
     *
     * @param id - employee ID
     *
     * @return boolean - true, if deleting an employee was successful, else false
     */
    public boolean delete(int id) {
        if (id != 0) {
            for (int i = 0; i < employees.length; i++) {
                if (employees[i] != null) {
                    if (employees[i].getId() == id) {
                        employees[i] = null;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Change employee
     *
     * @param fullName - full name employee (if != "", then, if exists full name - change)
     * @param department -  department (if != 0, then change)
     * @param salary - salary employee
     *
     * @return boolean - true, if change an employee was successful, else false
     */
    public boolean changeEmployee(String fullName, int department, float salary) {
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getEmployeeFullName().equals(fullName)) {
                    if (salary != 0.0F) {
                        employee.setSalary(salary);
                    }
                    if (department != 0) {
                        employee.setDepartment(department);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Print all employees by department (department \n employees)
     */
    public void printEmployeesByAllDepartments() {
        // Обходим все отделы (по условиям их 5)
        for (int i = 1; i <= 5; i++)
        {
            if (getEmployeesByDepartment(i).length != 0) {
                System.out.printf("Department %d\n", i);
                for (int j = 0; j < getEmployeesByDepartment(i).length; j++) {
                    System.out.println(getEmployeesByDepartment(i)[j].getEmployeeFullName());
                }
                System.out.println(); // Separate department
            }
        }
    }

    private int getFirstNotNullEmployeeIndex() {
        int index = 0;
        for (int i = index; i < employees.length; i++) {
            if (employees[i] != null) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * Getting an array of employees of a given department
     *
     * @param department - department
     * @return Employee[] by department
     */
    private Employee[] getEmployeesByDepartment(int department) {
        ArrayList<Employee> employeeDepartmentList = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getDepartment() == department) {
                    employeeDepartmentList.add(employee);
                }
            }
        }
        return employeeDepartmentList.toArray(new Employee[0]);
    }

    /**
     * Get string employee without department
     *
     * @param employee - employee
     * @return String - formatted string
     */
    private String stringEmployeeWithoutDepartment(Employee employee) {
        return employee.getId() + ": "
                + employee.getEmployeeFullName() + ", salary: "
                + employee.getSalary();
    }
}
