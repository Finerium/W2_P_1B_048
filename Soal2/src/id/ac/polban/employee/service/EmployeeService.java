package id.ac.polban.employee.service;

import java.util.HashMap;
import java.util.Map;
import id.ac.polban.employee.model.*;

// dependency: EmployeeService USES Employee (Employee sebagai parameter method)
public class EmployeeService {
    private Map<Integer, Employee> employees = new HashMap<>();

    public void addEmployee(Employee emp) {
        employees.put(emp.getId(), emp);
    }

    public Employee getEmployee(int id) {
        return employees.get(id);
    }

    public void raiseSalary(int id, double percent) {
        Employee emp = employees.get(id);
        if (emp != null) {
            emp.setSalary(emp.getSalary() * (1 + percent / 100));
        }
    }

    // tampilkan semua employee
    public void tampilSemuaEmployee() {
        System.out.println("=== Data Semua Employee ===");
        for (Map.Entry<Integer, Employee> entry : employees.entrySet()) {
            Employee emp = entry.getValue();
            System.out.println("ID         : " + emp.getId());
            System.out.println("Nama       : " + emp.getName());
            System.out.println("Department : " + emp.getDepartment().getName());
            System.out.println("Tipe       : " + emp.getType().getType());
            System.out.printf("Gaji       : Rp. %.0f%n", emp.getSalary());
            System.out.println("--------------------------");
        }
    }
}
