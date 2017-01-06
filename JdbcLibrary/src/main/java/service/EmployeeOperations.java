package service;

import pojo.Employee;


import java.sql.SQLException;

public interface EmployeeOperations {
    boolean add(Employee employee) ;
    void update(Employee emp) ;
    int delete(int employeeId) ;
    void display(int employeeId) ;
    void displayAll()  ;
    int increaseSalary(int empoyeeId, float increasePercentage);
    Employee[] getEmployees();
    int getEmployeeCount();
    void setEmployees(Employee[] employees);

}

