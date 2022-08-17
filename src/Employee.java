

// Course work 1.0
// @ Aleksandar Zubanov
// 2022/08/17

public class Employee {
    private String employeeName;
    private String employeePatronymic;
    private String employeeSurname;
    private int departmentNumber;
    private double employeeSalary;
    private Integer employeeId;

    private static int counter = 1;

    public Employee(String employeeName, String employeePatronymic, String employeeSurname, int departmentNumber, double employeeSalary) {
        this.employeeName = employeeName;
        this.employeePatronymic = employeePatronymic;
        this.employeeSurname = employeeSurname;
        this.departmentNumber = departmentNumber;
        this.employeeSalary = employeeSalary;
        this.employeeId = counter++;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeePatronymic() {
        return employeePatronymic;
    }

    public String getEmployeeSurname() {
        return employeeSurname;
    }

    public int getDepartmentNumber() {
        return departmentNumber;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public static int getCounter() {
        return counter;
    }

    public void setDepartmentNumber(int departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    @Override
    public String toString() {
        return " " + employeeName +
                " " + employeePatronymic +
                " " + employeeSurname +
                ", department number: " + departmentNumber +
                ", salary: " + employeeSalary +
                ", Id: " + employeeId +
                ".";
    }
}
