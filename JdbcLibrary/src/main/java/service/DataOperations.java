package service;



import pojo.Employee;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by bukia on 12/25/2016.
 */
public interface DataOperations {
    Employee[] read();
    boolean write(Employee[] employees, int employeeCount);
}
