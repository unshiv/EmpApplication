package service;

import pojo.Employee;
import util.EmployeeUtil;


public class EmployeeHolder implements EmployeeOperations {
    private Employee[] employees;
    private int employeeCount;

    private static final int ARRAY_SIZE = 2;

    {
        employees = new Employee[ARRAY_SIZE];
        employeeCount = 0;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    // jdbc connection


    public void setEmployees(Employee[] employees) {
        this.employeeCount = employees.length;

        if (employeeCount >= ARRAY_SIZE) {
            Employee[] newArr = new Employee[this.employees.length + ARRAY_SIZE];
            this.employees = newArr;
        }

        System.arraycopy(employees,0,this.employees,0,employeeCount);

    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    @Override

    public boolean add(Employee employee) {

        for (int i = 0; i < employeeCount; i++) {
            if (this.employees[i].getEno() == employee.getEno()) {
                return false;
            }
        }

        if (employeeCount >= ARRAY_SIZE) {
            Employee[] newArr = new Employee[this.employees.length + ARRAY_SIZE];
            System.arraycopy(this.employees, 0, newArr, 0, this.employeeCount);
            this.employees = newArr;
        }

        employees[employeeCount] = employee;
        employeeCount++;
        return true;
    }

    //@Override
    /*public void update(Employee employee) {


        for (int i = 0; i < this.employees.length; i++) {
            if (this.employees[i].getEno() == employee.getEno()) {

                employees[i].setEname(employee.getEname());
                employees[i].setSalary(employee.getSalary());
                employees[i].setAge(employee.getAge());
                employees[i].setAddress(employee.getAddress());

                break;
            }
        }
    }*/
    @Override

    public void update(Employee employee) {

            if (employee.getEno() == employee.getEno()) {

                employee.setEname(employee.getEname());
                employee.setSalary(employee.getSalary());
                employee.setAge(employee.getAge());
                employee.setAddress(employee.getAddress());
            }
        }
    @Override
    public int delete(int employeeId) {
        Employee[] empArr = null;
        boolean empFound = false;
        int searchIndex = -1;

        for (int i = 0; i < this.employeeCount; i++) {
            if (employees[i].getEno() == employeeId) {
                empFound = true;
                searchIndex = i;
                break;
            }
        }

        if (empFound) {
            empArr = new Employee[this.employees.length - 1];
            System.arraycopy(this.employees, 0, empArr, 0, searchIndex);
            System.arraycopy(this.employees, searchIndex + 1, empArr, searchIndex, this.employees.length - searchIndex - 1);

            this.employees = empArr;

            employeeCount--;

            return employeeId;
        } else {
            return -1;
        }
    }

    @Override
    public void display(int employeeId) {
        EmployeeUtil.display(find(employeeId));
    }

    @Override
    public void displayAll() {
        System.out.println("\nALL EMPLOYEES :");
        /*for(int i=0;i<this.employeeCount;i++) {
            System.out.println(employees[i]);
        }*/
        EmployeeUtil.displayAll(employees);
    }

    @Override
    public int increaseSalary(int empoyeeId, float increasePercentage) {
        return EmployeeUtil.increaseSalary(empoyeeId, increasePercentage);
    }

    public int increaseSalaries(int[] empoyeeId, float increasePercentage) {
//        return EmployeeUtil.increaseSalary(empoyeeId, increasePercentage);
        return 0;
    }



    private Employee find(int employeeId) {
        for (int i = 0; i < this.employeeCount; i++) {
            if (employees[i].getEno() == employeeId) {
                return employees[i];
            }
        }

        return null;
    }
}
