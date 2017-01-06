package service;



import pojo.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bukia on 12/25/2016.
 */
public class FileHandler implements DataOperations {
    private final String filePath;

    public FileHandler(String filePath) {
        this.filePath = filePath;
        createFile();
    }

    @Override
    public Employee[] read() {
        File file = new File(filePath);

        List<Employee> employeeList = new ArrayList<>();
        try {
            if(!file.exists()) {
                file.createNewFile();
            }

            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String s;
            try {
                while ((s = bufferedReader.readLine()) != null) {
                    String[] strs = s.split(",");
                    Employee employee = new Employee(strs[0], Integer.parseInt(strs[1]),
                            Float.parseFloat(strs[2]), Integer.parseInt(strs[3]), strs[5]);
                    employeeList.add(employee);
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            } finally {
                if (bufferedReader != null) bufferedReader.close();
                if (reader != null) reader.close();
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        if(employeeList.size()>0) {
            Employee[] employees = new Employee[employeeList.size()];
            employeeList.toArray(employees);
            return employees;
        } else
            return null;
    }

    @Override
    public boolean write(Employee[] employees, int employeeCount) {
        if (employees == null) return false;
        boolean res = true;

        File file = new File(filePath);
        try {
            FileWriter writer = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            try {
                for (int i=0;i<employeeCount;i++) {
                    Employee e = employees[i];
                    bufferedWriter.write(e.getEname() + "," + e.getEno() + "," + e.getSalary() + "," + e.getAge() + "\n");
                }
                bufferedWriter.flush();
                writer.flush();
            } catch (IOException ioe) {
                ioe.printStackTrace();
                res = false;
            } finally {
                if (bufferedWriter != null) bufferedWriter.close();
                if (writer != null) writer.close();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
            res = false;
        }
        return true;
    }

    private boolean createFile() {
        boolean ret = false;
        int i = this.filePath.lastIndexOf("\\");
        String dir = this.filePath.substring(0, i);
        String fi = this.filePath.substring(i+1);

        System.out.println(dir+", "+fi);

        File dirf = new File(dir);
        File filf = new File(fi);
        try {
            if (!dirf.exists()) {
                ret = dirf.mkdirs();
            }
            if (!filf.exists()) {
                ret = (ret && filf.createNewFile());
            }
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }

        return ret;
    }
}
