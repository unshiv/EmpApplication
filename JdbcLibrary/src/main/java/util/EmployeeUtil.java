package util;



import pojo.Employee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Manohar on 12/23/2016.
 */
public class EmployeeUtil {
    public static void display(Employee employee) {
        if (employee == null) {
            return;
        }
        System.out.println(employee);
    }

    public static void displayAll(Employee[] employeesArray) {
        for (Employee e: employeesArray) {
            System.out.println(e);
        }
    }

    public static int increaseSalary(int empoyeeId, float increasePercentage) {
        return 0;
    }

    public  static Date joindateParsing() {
        return joindateParsing();
    }

    public  static Date joindateParsing(String strDate) {
        String ddMMyyyyFormat = "dd-MM-yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(ddMMyyyyFormat);
        Date joinDate=null;
        try {
            joinDate = sdf.parse(strDate);
            System.out.println("Parsed Date : " + strDate);

        } catch (ParseException e) {

            e.printStackTrace();
        }
        return joinDate;
    }
    
    public static String dateToString(Date jDate, String strDate){
        SimpleDateFormat sdf = new SimpleDateFormat(strDate);
        String joinDate =sdf.format(jDate);
        return joinDate;
    }
    public static int servingYears (Date currentDate, Date joinDate) {
        long diff = currentDate.getTime() - joinDate.getTime();
        int years =(int)Math.floor((diff/((long)1000*60*60*24*365)));
        return years;
    }

    
    
  public static Employee readEmployee() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter empno");
        int empno = scanner.nextInt();
        System.out.println("Enter empame");
        String name= scanner.next();
        System.out.println("Enter Salary");
        float salary = scanner.nextFloat();
        System.out.println("Enter age");
        int age = scanner.nextInt();
       // System.out.println("Enter joining Date  dd-MM-yyyy ");
        //String joiningDate=scanner.next();
        //Date joinDate = joindateParsing(joiningDate);
        Employee emp = new Employee(name, empno, salary, age);
        return emp;
    }

    public static void addEmployee() {

    }
}
