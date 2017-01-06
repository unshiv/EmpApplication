package pojo;



import java.util.Date;

/**
 * Created by vishn on 12/24/2016.
 */
public class Employee
{
    public String ename;
    public int eno;
    private float salary;
    public int age;
    private static String companyname = "xyz company";
    public Address address;
    public Date joinDate;

    public Employee(String ename, int eno, float salary, int age, String str)
    {
        this.ename = ename;
        this.eno = eno;
        this.salary = salary;
        this.age = age;

    }

    public Employee(String ename, int eno, float salary, int age)
    {
        this.eno = eno;
        this.ename = ename;
        this.salary = salary;
        this.age = age;

    }

    public Employee() {


    }


    public  Date getJoinDate() {

        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }


    public Address getAddress()
    {
        return address;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }



    public Employee(String ename, int eno, float salary, int age ,Date joinDate )
    {
        this.ename = ename;
        this.eno = eno;
        this.salary = salary;
        this.age = age;
        this.joinDate= joinDate;

    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename)
    {
        this.ename = ename;
    }

    public int getEno() {
        return eno;
    }

    public void setEno(int eno) {
        this.eno = eno;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary)
    {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ename='" + ename + '\'' +
                ", eno=" + eno +
                ", salary=" + salary +
                ", age=" + age +
               // ", address=" + address +
                //", joinDate=" + EmployeeUtil.dateToString(joinDate, "MM-dd-yyyy")+
                '}';
    }
}
