import id.ac.polban.employee.model.*;
import id.ac.polban.employee.service.EmployeeService;

public class Main {
    public static void main(String[] args) {
        // buat department
        Department deptIT = new Department("IT");
        Department deptHR = new Department("Human Resource");

        // buat employment type
        EmploymentType fullTime = new EmploymentType("Full-Time");
        EmploymentType partTime = new EmploymentType("Part-Time");

        // buat employee dengan department dan type yang berbeda
        Employee emp1 = new Employee(Employee.generateId(), "Budi Santoso", deptIT, fullTime, 8000000);
        Employee emp2 = new Employee(Employee.generateId(), "Siti Nurhaliza", deptHR, fullTime, 7500000);
        Employee emp3 = new Employee(Employee.generateId(), "Andi Prasetyo", deptIT, partTime, 4000000);

        // buat service dan tambahkan employee
        EmployeeService service = new EmployeeService();
        service.addEmployee(emp1);
        service.addEmployee(emp2);
        service.addEmployee(emp3);

        // tampilkan semua employee sebelum raise
        System.out.println("--- Sebelum Kenaikan Gaji ---");
        service.tampilSemuaEmployee();

        // demo raiseSalary: naikkan gaji Budi 10%
        System.out.println(">> Menaikkan gaji Budi Santoso sebesar 10%...\n");
        service.raiseSalary(1, 10);

        // tampilkan semua employee setelah raise
        System.out.println("--- Setelah Kenaikan Gaji ---");
        service.tampilSemuaEmployee();

        // tampilkan jumlah employee dari static method
        System.out.println("Total employee yang terdaftar: " + Employee.getEmployeeCount());

        // tampilkan info department dan employment type
        System.out.println("\n=== Info Department ===");
        System.out.println("1. " + deptIT.getName());
        System.out.println("2. " + deptHR.getName());

        System.out.println("\n=== Info Employment Type ===");
        System.out.println("1. " + fullTime.getType());
        System.out.println("2. " + partTime.getType());
    }
}
