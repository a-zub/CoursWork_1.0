// Course work 1.0
// @ Aleksandar Zubanov
// 2022/08/17


public class Main {

    public static final Employee[] employees = new Employee[10];
    /**
     * Массив, в котором храним данные сотрудников
     */
    public static final Employee[] departmentArr = new Employee[10];
    /**
     *
     */
    private static final int index = 25; // Индекс увеличения зарплаты в %

    private static final int department = 1; // Номер отдела

    private static final double accountingSalary = 48_576; // Число, от которого сортируем зарплату

    public static void main(String[] args) {
        addEmployee(); // Добавляем список всех сотрудников

        System.out.println("List all employees"); // Выводим данные всех сотрудников в консоль
        printEmployees(employees);

        // Выводим в консоль затраты на зарплату всех сотрудников за месяц
        System.out.println("All monthly salary all employees: " + calculateAllMonthlySalary(employees));
        splitIntoBlocks(); // Ставим разделитель

        // Находим сотрудника с минимальной зарплатой среди всех сотрудников
        System.out.println("Min salary all employers: " + searchMinimumWage(employees));
        splitIntoBlocks(); // Ставим разделитель

        // Находим сотрудника с максимальной зарплатой среди всех сотрудников
        System.out.println("Max salary all employees: " + searchMaximumWage(employees));
        splitIntoBlocks(); // Ставим разделитель

        //Находим среднюю зарплату всех сотрудников
        System.out.println("Average salary all employees: " + calculateЕheAverageSalary(employees));
        splitIntoBlocks(); // Ставим разделитель

        printEmployeesNames(employees); // Выводим в консоль имена всех сотрудников

        System.out.println("indexed salary: "); // Индексируем зарплату всех сотрудников
        indexingTheSalary(index, employees);
        printEmployees(employees);


        recordEmployeesInDepartment(department); // создаем список сотрудников отдела


        // Находим сотрудника с минимальной зарплатой в отделе
        System.out.println("Min salary department number " + department + " - " + searchMinimumWage(departmentArr));
        splitIntoBlocks(); // Ставим разделитель

        // Находим сотрудника с максимальной зарплатой в отделе
        System.out.println("Max salary department number " + department + " - " + searchMaximumWage(departmentArr));
        splitIntoBlocks(); // Ставим разделитель

        // Находим сумму затрат на зарплату по отделу
        System.out.println("All monthly salary department " + department + " - " + calculateAllMonthlySalary(departmentArr));
        splitIntoBlocks(); // Ставим разделитель

        // Средняя зарплата по отделу
        System.out.println("Average salary department " + department + " - " + calculateЕheAverageSalary(departmentArr));
        splitIntoBlocks(); // Ставим разделитель

        System.out.println("indexed salary department " + department + " :"); // Индексируем зарплату сотрудников отдела
        indexingTheSalary(index, departmentArr);
        splitIntoBlocks(); // Ставим разделитель

        printEmployeesDepartment(); // Выводим в консоль список сотрудников отдела без номера отдела
        splitIntoBlocks(); // Ставим разделитель

        // Список сотрудников с зарплатой меньше числа
        System.out.println("List employees with salary less");
        getSalaryLess(employees, accountingSalary);
        splitIntoBlocks(); // Ставим разделитель

        // Список сотрудников с зарплатой больше числа
        System.out.println("List employees with salary more or equals");
        getSalaryMore(employees, accountingSalary);
        splitIntoBlocks(); // Ставим разделитель

    }

    private static void addEmployee() {
        /** Инициализируем массив Employees данными сотрудников */
        employees[0] = new Employee("Ivan", "Ivanovich",
                "Ivanov", 1, 58_236);
        employees[1] = new Employee("Petr", "Petrovich",
                "Petrov", 2, 45_622);
        employees[2] = new Employee("John", "Johnovich",
                "Silver", 3, 74_600);
        employees[3] = new Employee("Igor", "Igorevich",
                "Smirnov", 1, 35_800);
        employees[4] = new Employee("Andrey", "Andreevich",
                "Andreev", 5, 22_200);
        employees[5] = new Employee("Pavel", "Pavlovich",
                "Pavlov", 4, 38_648);
        employees[6] = new Employee("Mark", "Markovich",
                "Markov", 4, 38_648);
        employees[7] = null;
        employees[8] = new Employee("Aleksandar", "Ivanovich",
                "Ivanov", 4, 38_648);
        employees[9] = new Employee("Uliya", "Ivanovna",
                "Pavlova", 4, 38_648);

    }

    private static void printEmployees(Employee[] employ) {
        /**  Выводим данные сотрудников в консоль */
        for (int i = 0; i < employ.length; i++) {
            if (checkNull(employ[i])) {
                System.out.println(employ[i].toString());
            }
        }
        splitIntoBlocks();
    }

    private static double calculateAllMonthlySalary(Employee[] employ) {
        /** Считаем и возвращаем затраты  на зарплату за месяц */
        double salaryCounter = 0;
        for (int i = 0; i < employ.length; i++) {
            if (checkNull(employ[i])) {
                salaryCounter += employ[i].getEmployeeSalary();
            }
        }
        return salaryCounter;
    }

    private static String searchMinimumWage(Employee[] employ) {
        /** Находим и возвращаем сотрудника с минимальной зарплатой */
        double minSalary = employ[0].getEmployeeSalary();
        for (int i = 0; i < employ.length; i++) {
            if (checkNull(employ[i])) {
                if (employ[i].getEmployeeSalary() < minSalary) {
                    minSalary = employ[i].getEmployeeSalary();
                }
            }
        }
        String minSalaryEmployee = "";
        for (int j = 0; j < employ.length; j++) {
            if (checkNull(employ[j])) {
                if (employ[j].getEmployeeSalary() == minSalary) {
                    minSalaryEmployee = employ[j].toString();
                }
            }
        }
        return minSalaryEmployee;
    }

    private static String searchMaximumWage(Employee[] employ) {
        /** Находим и возвращаем сотрудника с максимальной зарплатой */
        double maxSalary = employ[0].getEmployeeSalary();
        for (int i = 0; i < employ.length; i++) {
            if (checkNull(employ[i])) {
                if (maxSalary < employ[i].getEmployeeSalary()) {
                    maxSalary = employ[i].getEmployeeSalary();
                }
            }
        }
        String maxSalaryEmployee = "";
        for (int j = 0; j < employ.length; j++) {
            if (checkNull(employ[j])) {
                if (employ[j].getEmployeeSalary() == maxSalary) {
                    maxSalaryEmployee = employ[j].toString();
                }
            }
        }
        return maxSalaryEmployee;

    }

    private static double calculateЕheAverageSalary(Employee[] employ) {
        /** Находим и возвращаем среднюю зарплату  */
        double salaryCounter = 0;
        int counterEmployee = 0;
        for (int i = 0; i < employ.length; i++) {
            if (checkNull(employ[i])) {
                salaryCounter += employ[i].getEmployeeSalary();
                counterEmployee++;
            }
        }
        return salaryCounter / counterEmployee;
    }

    private static void printEmployeesNames(Employee[] employ) {
        /** Выводим ФИО сотрудников в консоль */
        System.out.println("F.I.O all employees: ");
        for (Employee employee : employ) {
            if (checkNull(employee)) {
                System.out.println("Employee: " + employee.getEmployeeName() + " " +
                        employee.getEmployeePatronymic() + "  " + employee.getEmployeeSurname());
            }
        }
        splitIntoBlocks();
    }

    private static void indexingTheSalary(int index, Employee[] employ) {
        /** Индексируем зарплату сотрудников */
        for (int i = 0; i < employ.length; i++) {
            if (checkNull(employ[i])) {
                employees[i].setEmployeeSalary(employ[i].getEmployeeSalary() + (employ[i].getEmployeeSalary()
                        / 100) * index);
            }
        }
    }

    private static void recordEmployeesInDepartment(int department) {
        /** создаем список сотрудников отдела*/
        for (int i = 0; i < employees.length; i++) {
            if (checkNull(employees[i])) {
                if (employees[i].getDepartmentNumber() == department) {
                    departmentArr[i] = employees[i];
                }
            }
        }
    }

    private static void printEmployeesDepartment() {
        /** Выводим список сотрудников отдела без номера отдела*/
        System.out.println("List employees department number " + department);
        for (int i = 0; i < departmentArr.length; i++) {
            if (checkNull(departmentArr[i])) {
                System.out.println(departmentArr[i].getEmployeeName() + " " + departmentArr[i].getEmployeePatronymic() + " "
                        + departmentArr[i].getEmployeeSurname() + " salary: " + departmentArr[i].getEmployeeSalary() + " id: " +
                        departmentArr[i].getEmployeeId());
            }
        }
    }

    private static void getSalaryLess(Employee[] employ, double accountingSalary) {
        /** Выводим список сотрудников, чьи зарплаты меньше указанного числа*/
        for (int i = 0; i < employ.length; i++) {
            if (checkNull(employ[i])) {
                if (employ[i].getEmployeeSalary() < accountingSalary) {
                    System.out.println(employ[i].toString());
                }
            }
        }
    }

    private static void getSalaryMore(Employee[] employ, double accountingSalary) {
        /** Выводим список сотрудников, чьи зарплаты больше или равны указанному числу */
        for (int i = 0; i < employ.length; i++) {
            if (checkNull(employ[i])) {
                if (employ[i].getEmployeeSalary() >= accountingSalary) {
                    System.out.println(employ[i].toString());
                }
            }
        }
    }

    private static boolean checkNull(Employee employee) {
        /** проверяем полученные данные на отсутствие Null */
        return employee != null;
    }

    private static void splitIntoBlocks() {
        /** Вставляем разделитель */
        System.out.println("==================================================");
        System.out.println("==================================================");
    }
}
