import java.util.*;

public class Company {

    private int income;
    private int employeesCount = 0;
    private ArrayList<Employee> employees = new ArrayList();

    Company() {
        income = 0;
    }

    int getIncome() {
        return income;
    }

    int getEmployeesCount() {
        return employeesCount;
    }

    public void hire(Employee object) {
        income += object.getEarnedMoneyManager();
        employees.add(object);
        employeesCount += 1;
    }

    void hireAll(String employeeType, int count, Company company) {
        for (int i = 0; i < count; i++) {
            Employee object = null;
            switch (employeeType) {
                case "Manager":
                    object = new Manager(company);
                    break;
                case "Operator":
                    object = new Operator(company);
                    break;
                case "TopManager":
                    object = new TopManager(company);
                    break;
            }
            employees.add(object);
            income += object.getEarnedMoneyManager();
            employeesCount += 1;
        }
    }

    void fire(int number) {
        employees.remove(number);
        employeesCount--;
    }

    void getSalaryStaff(int count, Comparator comparator) {
        if (count <= employeesCount & count > 0) {
            ArrayList<Employee> SalaryList = new ArrayList<>(employees);

            SalaryList.sort(comparator);

            for (int i = 0; i < count; i++) {
                System.out.println(i + 1 + ". " + SalaryList.get(i).getMonthSalary() + " руб.");
            }
        } else
            System.out.println("Список не может быть отображен, так как введено некорректоное количество сотрудников");
    }

}
