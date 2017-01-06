package enm;

/**
 * Created by vishn on 12/24/2016.
 */

public enum EmployeeServiceEnm {

    ADD(1), UPDATE(2), DELETE(3), DISPLAY(4), DISPALYALL(5), INCREASE_SALAARY(6), SENIOR_EMLOYEES(7),EXIT(8),;

    private int operationValue;

    EmployeeServiceEnm(int operationValue) {
        this.operationValue = operationValue;
    }

    public int getOperationValue() {
        return operationValue;
    }

    public static EmployeeServiceEnm resolveNameByOperationValue(int operationValue) {
        for (EmployeeServiceEnm employeeServiceEnm : EmployeeServiceEnm.values()) {
            if (employeeServiceEnm.getOperationValue() == operationValue) {
                return employeeServiceEnm;
            }
        }

        return EmployeeServiceEnm.EXIT;
    }
}