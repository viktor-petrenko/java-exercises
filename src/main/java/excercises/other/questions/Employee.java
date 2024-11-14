package excercises.other.questions;

import java.io.*;

public class Employee {

    /**
     * Create a Parent Class Employee with a common method Calculate. Create 2 Child classes "Regular" and "NightShift".
     * Night shift employees get special pay rate, which is 50% more than their actual rate amount.
     * <p>
     * <p>
     * Invoke the calculate function based on the below inputs:
     * <p>
     * I/P: Employee, 10, 8
     * Invoke Calculate method from Employee reference pointing to Employee object
     * Expected: Regular rate calculated.
     * O/P: 80
     * <p>
     * I/P: EmployeePointingRegularEmployee, 10, 8
     * Invoke Calculate method from Employee reference pointing to RegularShift object
     * Expected: Regular rate calculated.
     * O/P: 80
     * <p>
     * I/P: EmployeePointingNightShift, 10, 8
     * Invoke Calculate method from Employee reference pointing to NightShift object
     * Expected: Special rate calculated.
     * O/P: 120
     *
     * @param amount
     * @param hours
     * @return
     */

    public Double Calculate(Double amount, Double hours) {
        return amount * hours;
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            // Print options for the user
            System.out.println("Enter employee type, amount, and hours (e.g., 'Employee,10.0,8.0') or press Enter to quit:");

            String input = br.readLine().trim();
            // Exit loop if input is empty
            if (input.isEmpty()) {
                break;
            }

            // Split input into parts
            String[] parts = input.split(",");

            if (parts.length != 3) {
                System.out.println("Invalid input format. Please enter in the format 'Employee,10.0,8.0'.");
                continue;
            }


            String employeeType = parts[0];
            Double amount = Double.parseDouble(parts[1]);
            Double hours = Double.parseDouble(parts[2]);

            Employee employee;

            // Determine the type of Employee and instantiate accordingly
            switch (employeeType) {
                case "EmployeePointingRegularEmployee":
                    employee = new RegularShift();
                    break;
                case "EmployeePointingNightShift":
                    employee = new NightShift();
                    break;
                default:
                    employee = new Employee();
            }

            System.out.println(employee.Calculate(amount, hours));
        }
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
