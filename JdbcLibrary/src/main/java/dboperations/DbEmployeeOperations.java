package dboperations;

import pojo.Employee;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;




/**
 * Created by vishn on 12/31/2016.
 */
public class DbEmployeeOperations {
    Connection con;

    {
        try {
            con = createConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Connection createConnection() throws ClassNotFoundException, SQLException {
        //register driver
        Class.forName("com.mysql.jdbc.Driver");

        //establish connection
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/imcs", "root", "root");

        return connection;
    }

    public void insert(Employee emp) throws SQLException, ClassNotFoundException {
        Connection conn = createConnection();

        PreparedStatement pstmt = conn.prepareStatement("insert into imcs.employee (ename, salary,age) values (?,?,?) ");

        //StringBuilder queryBuilder = new StringBuilder("");
//            pstmt.setInt(1, );
        pstmt.setString(1, emp.getEname());
        pstmt.setFloat(2, emp.getSalary());
        pstmt.setInt(3, emp.getAge());
        pstmt.executeUpdate();// executeQuery();

    }


    public void update(Employee employee) throws SQLException, ClassNotFoundException {

        Connection conn = createConnection();
        PreparedStatement pstmt = conn.prepareStatement("UPDATE imcs.employee SET ename = ? ,salary = ?, age = ?  where eno = ?");
        //UPDATE `imcs`.`employee` SET `ename`='kkk', `salary`='2525', `age`='24' WHERE `eno`='4';
        //(ename, salary,age) values (?,?,?) WHERE eno = ?
        //PreparedStatement pstmt = null;
        //con = createConnection();
        // pstmt = con.prepareStatement("update imcs.employee (ename,salary,age) values (?,?,?) ");
        //StringBuilder queryBuilder = new StringBuilder("");

        pstmt.setString(1, employee.getEname());
        pstmt.setFloat(2, employee.getSalary());
        pstmt.setInt(3, employee.getAge());
        pstmt.setInt(4, employee.getEno());
        pstmt.executeUpdate();

    }

    public void delete(int empno) throws SQLException, ClassNotFoundException {

        Connection conn = createConnection();
        PreparedStatement pstmt = conn.prepareStatement("delete from imcs.employee where eno = ?");
        pstmt.setInt(1, empno);
        pstmt.executeUpdate();
    }

    public void findEmployee(int empno) throws SQLException, ClassNotFoundException {

        PreparedStatement pstmt = null;
        con = createConnection();

        pstmt = con.prepareStatement("select * from imcs.employee where eno = ? ");
        pstmt.setInt(1, empno);
        //pstmt.executeUpdate();
        ResultSet resultSet = pstmt.executeQuery();
        if (resultSet.next()) {
            //Account account = new Account();
            Employee employee = new Employee();
            employee.setEno(resultSet.getInt(1));
            employee.setEname(resultSet.getString(2));
            employee.setSalary(resultSet.getFloat(3));
            employee.setAge(resultSet.getInt(4));

            System.out.println(employee);
        }
    }

    public void findAll() throws SQLException, ClassNotFoundException {

            Connection conn = createConnection();
            //PreparedStatement statement = null;
            PreparedStatement pstmt = conn.prepareStatement("select * from imcs.employee");

        ResultSet resultSet = pstmt.executeQuery();
        List<Employee> employees = new ArrayList<>();
        while (resultSet.next()) {
            //Account account = new Account();
            Employee employee = new Employee();
            employee.setEno(resultSet.getInt(1));
            employee.setEname(resultSet.getString(2));
            employee.setSalary(resultSet.getFloat(3));
            employee.setAge(resultSet.getInt(4));
            employees.add(employee);
        }
        for (Employee e: employees) {
            System.out.println(e);
        }


    }


    }







