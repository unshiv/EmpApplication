

import dboperations.DbEmployeeOperations;
import enm.EmployeeServiceEnm;
import pojo.Employee;
import service.DataOperations;
import service.EmployeeHolder;
import service.EmployeeOperations;
import service.FileHandler;
import util.EmployeeUtil;

import java.sql.SQLException;
import java.util.Scanner;




/**
 * Created by Manohar on 12/23/2016.
 */
public class EmployeeApplication {
    static final String filePath = "C:\\Users\\sprak\\Desktop\\files\\employeedata.csv";

    EmployeeOperations employeeService = new EmployeeHolder();

    DataOperations fileService = new FileHandler(EmployeeApplication.filePath);

    DbEmployeeOperations dbOperations = new DbEmployeeOperations();


    /* public static final String dateFormat;

    static {
        String dateFormat1;
        Properties properties = new Properties();
        try {
            properties.load(EmployeeApplication.class.getResourceAsStream("/trng/emp/configs/appconfig.properties"));
            dateFormat1 = properties.getProperty("dateFormat");
        } catch (IOException e) {
            e.printStackTrace();
            dateFormat1 = "MM-dd-yyyy";
        }
        dateFormat = dateFormat1;
    }
*/
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        EmployeeApplication application = new EmployeeApplication();

        application.loadFromFile();

        EmployeeServiceEnm choice = null;
        do {
            choice = readUserOption();
            if(choice==null) break;
            switch (choice) {
                case ADD:
                    System.out.println("1. Enter new employee info: ");
                    application.addEmployee();
                    //dbOperations.insert();

                    break;
                case UPDATE:
                    System.out.println("Update employee");
                    application.updateEmployee();
                    break;
                case DELETE:
                    System.out.println("Enter employee id to be deleted:  ");
                    application.deleteEmployee();
                    break;
                case DISPLAY:
                    System.out.println("Enter employee id: ");
                    application.displayEmployee();
                    break;
                case DISPALYALL:
                    System.out.println("Employees information is:  ");
                    application.displayEmployees();
                    break;
                case INCREASE_SALAARY:
                    System.out.println("Enter the new salary");
                    application.increaseSalarySalary();
                    break;

                default:
                    System.out.println("Invalid input.");
                    break;
            }
        } while (choice != null);

        application.saveToFile();
    }

    private void loadFromFile() {
        System.out.println("Loading data...");
        Employee[] employees = this.fileService.read();
        if(employees!=null) {
            //this.employeeService.setEmployees(employees);
        }
        System.out.println(((employees!=null)?employees.length:0)+" records loaded.");
    }

    private void saveToFile() {
        System.out.println("Saving data...");
        boolean ret = false;
        if(this.employeeService.getEmployeeCount() > 0) {
           // ret = this.fileService.write(this.employeeService.getEmployees(), this.employeeService.getEmployeeCount());
        }
        if(ret) {
            System.out.println("Data saved to file.");
        } else {
            System.out.println("Data couldn't be saved to file.");
        }
    }

    private static EmployeeServiceEnm readUserOption() {
        displayMenu();
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        EmployeeServiceEnm employeeServiceEnm = null;
        do {
            if (value == 8) {
                break;
            }

            employeeServiceEnm = EmployeeServiceEnm.resolveNameByOperationValue(value);
        } while (employeeServiceEnm == null);

        return employeeServiceEnm;
    }

    private static void displayMenu() {
        System.out.println("Select one of the following operation: \n1.Add a new employee\n2.Update employee" +
                "\n 3.Delete employee \n 4.Display employee information \n 5.Display all employees information \n 6.Increase Salary \n 7.Employees Serving more than  years \n 8.Exit");
    }

    private void displayEmployee() throws SQLException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter emp no");
        int empno = scanner.nextInt();
        dbOperations.findEmployee(empno);
        //employeeService.display(empno);
    }

    private void deleteEmployee() throws SQLException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter emp no");
        int empno = scanner.nextInt();
        dbOperations.delete(empno);
        employeeService.delete(empno);

    }

    private void increaseSalarySalary() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter emp no");
        int empno = scanner.nextInt();
        employeeService.increaseSalary(empno, 10);
    }

    private void displayEmployees() throws SQLException, ClassNotFoundException {
        dbOperations.findAll();

        //employeeService.displayAll();
    }

    private void updateEmployee() throws SQLException, ClassNotFoundException {
        Employee emp = EmployeeUtil.readEmployee();
        dbOperations.update(emp);
        employeeService.update(emp);
    }

    private void addEmployee() throws SQLException, ClassNotFoundException {
        Employee emp = EmployeeUtil.readEmployee();
        //EmployeeUtil.addEmployee();
        dbOperations.insert(emp);
        boolean succes = false;
        succes = employeeService.add(emp);
        if (succes) {
            System.out.println("Employee added successfully");
        } else {
            System.out.println("Employee already exist with given number");
        }
    }
}
