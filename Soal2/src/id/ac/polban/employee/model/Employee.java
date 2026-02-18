package id.ac.polban.employee.model;

public class Employee {
    private int id;
    private String name;
    private Department department;    // aggregation: Employee HAS-A Department
    private EmploymentType type;      // aggregation: Employee HAS-A EmploymentType
    private double salary;

    // static field untuk menghitung jumlah employee
    private static int employeeCount = 0;

    public Employee(int id, String name, Department department, EmploymentType type, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.type = type;
        this.salary = salary;
        employeeCount++;
    }

    // static method untuk generate id otomatis
    public static int generateId() {
        return employeeCount + 1;
    }

    public static int getEmployeeCount() {
        return employeeCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public EmploymentType getType() {
        return type;
    }

    public void setType(EmploymentType type) {
        this.type = type;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
