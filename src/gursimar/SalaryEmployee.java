package gursimar_navdeep_a2;

/**
 *
 * @author Navdeep Singh Thind This class is a sub-class of employee class and
 * it represents a salaried employee
 */
public class SalaryEmployee extends Employee {

    //Salary data-field to get salary of the employee
    double salary;

    //Constructor
    public SalaryEmployee(double salary, int id, String firstName, String lastName) {
        super(id, firstName, lastName);
        this.salary = salary;
    }

    //creating another contructor to check illegalarugmentexception in main class
    SalaryEmployee() {
    }

    //Getter and Setter
    public void setSalary(double salary) {
        if (salary <=40000) {
            throw new IllegalArgumentException("ERROR: Yearly Salary must be greater than 40000");
        }
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    /**
     *
     * @return Salary of the employee
     */
    @Override
    public double calculatePay() {
        return salary / 52;
    }

    /**
     *
     * @return name,id and salary
     */
    @Override
    public String toString() {
        return "Employee " + id + ": " + lastName + "," + firstName + "\n" + "Salary:" + "$" + getSalary();
    }

}
