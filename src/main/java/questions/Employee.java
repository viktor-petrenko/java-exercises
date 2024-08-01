package questions;

import java.io.*;
import java.util.*;

public class Employee {

    /**
     * Create a Parent Class Employee with a common method Calculate. Create 2 Child classes "Regular" and "NightShift".
     * Night shift employees get special pay rate, which is 50% more than their actual rate amount.
     *
     *
     * Invoke the calculate function based on the below inputs:
     *
     *     I/P: Employee, 10, 8
     *         Invoke Calculate method from Employee reference pointing to Employee object
     *         Expected: Regular rate calculated.
     *         O/P: 80
     *
     *     I/P: EmployeePointingRegularEmployee, 10, 8
     *         Invoke Calculate method from Employee reference pointing to RegularShift object
     *         Expected: Regular rate calculated.
     *         O/P: 80
     *
     *     I/P: EmployeePointingNightShift, 10, 8
     *         Invoke Calculate method from Employee reference pointing to NightShift object
     *         Expected: Special rate calculated.
     *         O/P: 120
     * @param amount
     * @param hours
     * @return
     */

    public Double Calculate(Double amount, Double hours) {
        return amount * hours;
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine().trim();
        String[] parts = input.split(",");

        String employeeType = parts[0];
        Double amount = Double.parseDouble(parts[1]);
        Double hours = Double.parseDouble(parts[2]);

        Employee employee;

        // Determine the type of Employee and instantiate accordingly
        switch(employeeType) {
            case "RegularShift":
                employee = new RegularShift();
                break;
            case "NightShift":
                employee = new NightShift();
                break;
            default:
                employee = new Employee();
        }

        System.out.println(employee.Calculate(amount, hours));
    }
}

class RegularShift extends Employee {
    @Override
    public Double Calculate(Double amount, Double hours) {
        return super.Calculate(amount, hours); // Call parent class method
    }
}

class NightShift extends Employee {
    @Override
    public Double Calculate(Double amount, Double hours) {
        // 50% more than the regular rate
        return super.Calculate(amount * 1.5, hours);
    }
}
