import EmployeeBook.EmployeeBook;

public class Main {


    public static void main(String[] args) {

        System.out.println("Курсовая работа (1 курс)");
        System.out.println("Employee Book");
        System.out.println();

        // Код для проверки курсовой

        // Добавим сотрудников в массив (10) - проверка метода add

        EmployeeBook eb = new EmployeeBook();
        eb.add("Иванов Иван Иванович", 52600.00F, 1);
        eb.add("Алексеев Алексей Алексеевич", 62600.00F, 1);
        eb.add("Сидоров Лев Петрович", 59800.00F, 3);
        eb.add("Магомедов Джамал Ильдусович", 75900.00F, 3);
        eb.add("Скоробогатько Пётр Михайлович", 76100.00F, 2);
        eb.add("Васильев Михаил Петрович", 48300.00F, 3);
        eb.add("Любимова Майа Андреевна", 63500.00F, 2);
        eb.add("Давлетов Давлет Давлетович", 79250.00F, 4);
        eb.add("Шихсаидов Рустем Максудович", 56600.00F, 5);
        eb.add("Алиев Владислав Геннадиевич", 92600.00F, 5);

        // Печать всех сотрудников
        eb.printAllEmployees();

        // Печать сотрудников по отделам
        eb.printEmployeesByAllDepartments();

        // Пробуем добавить ещё одного сотрудника (11-го)
        if (eb.add("Одиннадцатый", 10000.0F, 3)) {
            System.out.println("Сотрудник успешно добавлен");
        } else {
            System.out.println("Сотрудник лишний!");
        }

        // Удаляем сотрудника (существующее имя)
        if (eb.delete("Иванов Иван Иванович")) {
            System.out.println("Сотрудник успешно удалён!");
        } else {
            System.out.println("Неудачная попытка удаления!");
        }
        // Пробуем удалить сотрудника с несуществующим ID
        if (eb.delete(12)) {
            System.out.println("Сотрудник успешно удалён!");
        } else {
            System.out.println("Неудачная попытка удаления!");
        }

        // Salary all
        System.out.println("All salary = " + eb.getSalaryAllEmployees());

        // Salary by department 3
        System.out.println("Salary department 3 = " + eb.getSalaryDepartmentEmployees(3));

        // Max, min and average salary
        System.out.println("Max salary - " + eb.maxSalaryEmployee());
        System.out.println("Min salary - " + eb.minSalaryEmployee());
        System.out.println("Average salary - " + eb.averageSalary());

        // Max, min and average salary by department
        System.out.println("Max salary (department 3) - " + eb.maxSalaryEmployeeDepartment(3));
        System.out.println("Min salary (department 3) - " + eb.minSalaryEmployeeDepartment(3));
        System.out.println("Average salary (department 3) - " + eb.averageSalaryDepartment(3));

        // Get full names all employee
        eb.getEmployeeFullNames();

        // Index salary for all employee
        eb.indexSalary(13);
        eb.printAllEmployees();

        // Index salary for employees by department 3
        eb.indexSalaryByDepartment(13, 3);
        eb.printEmployeesByDepartment(3);

        // Print employees with salary >= givenSalary and salary < givenSalary
        float givenSalary = 69000.0F;
        System.out.println("Salary >= " + givenSalary);
        eb.printEmployeesWithHigherSalary(givenSalary);
        System.out.println("Salary < " + givenSalary);
        eb.printEmployeesWithLowerSalary(givenSalary);

        // Change employee successful
        if (eb.changeEmployee("Сидоров Лев Петрович", 4, 23000.0F)) {
            System.out.println("Successful change employee!");
        } else {
            System.out.println("Unsuccessful change!");
        }

        // Change employee unsuccessful
        if (eb.changeEmployee("", 4, 23000.0F)) {
            System.out.println("Successful change employee!");
        } else {
            System.out.println("Unsuccessful change!");
        }
    }
}