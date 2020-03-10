package gursimar_navdeep_a2;

/**
 *
 * @author gursimar Singh Hehar This class extends employee class and It is a
 * representation of a commission Employee
 */
public class CommissionEmployee extends Employee {

    //data fields to calculate pay of CommissionEmployee
    double rate;
    double sales;

    //Constructor 
    public CommissionEmployee(int id, String firstName, String lastName, double rate, double sales) {
        super(id, firstName, lastName);
        this.sales = sales;
        this.rate = rate;
    }

    //creating another contructor to check illegalarugmentexception in main class
    public CommissionEmployee() {
    }

    //Getter and Setter
    public void setRate(double rate) {
        if (rate < 0) {
            throw new IllegalArgumentException("Value must be greater than 0!");
        }
        this.rate = rate;
    }

    public void setSales(double sales) {
        if (sales < 0) {
            throw new IllegalArgumentException("ERROR(209): Value must be greater than or equal to 0!");
        }
        this.sales = sales;
    }

    public double getRate() {
        return rate;
    }

    public double getSales() {

        return sales;
    }

    /**
     *
     * @return Pay of the employee using CalculatePay()
     */
    @Override
    public double calculatePay() {
        return sales * rate / 100;

    }

    /**
     *
     * @return FirstName , LastName ,Id,Sales and rate of employee.
     */
    @Override
    public String toString() {
        return "Employee " + id + ": " + lastName + "," + firstName + "\n" + "Rate: " + getRate() + "\n" + "Sales: " + "$" + getSales();
    }

}
