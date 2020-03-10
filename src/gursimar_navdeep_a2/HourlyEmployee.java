package gursimar_navdeep_a2;

/**
 *
 * @author Navdeep Singh Thind This class represents an employee who gets paid
 * per hour for his work , and it is sub-class of employee class.
 */
public class HourlyEmployee extends Employee {

    //Data fields to calculate salary of employee who gets paid per hour
    double numHours;
    double hourlyRate;

    public HourlyEmployee(double numHours, double hourlyRate, int id, String firstName, String lastName) {
        super(id, firstName, lastName);
        this.numHours = numHours;
        this.hourlyRate = hourlyRate;
    }

    //creating another contructor to check illegalarugmentexception in main class
    public HourlyEmployee() {
    }

    public void setNumHours(double numHours) {
        if (numHours <= 0) {
            throw new IllegalArgumentException("ERROR(209):Value must be greater than 0!");
        }
        this.numHours = numHours;
    }

    //Getter and Setter
    public void setHourlyRate(double hourlyRate) {
        if (hourlyRate < 14) {
            throw new IllegalArgumentException("ERROR(209):Value must be greater than or equal to 14!");
        }
        this.hourlyRate = hourlyRate;
    }

    public double getNumHours() {
        return numHours;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    //Constructor
    /**
     *
     * @return salary of employee using calculatePay()
     */
    @Override
    public double calculatePay() {
        return numHours * hourlyRate;

    }

    /**
     *
     * @return Name, Id , Hours worked and rate of employee
     */
    @Override
    public String toString() {
        return "Employee " + id + ": " + lastName + "," + firstName + "\n" + "Hours Worked: " + getNumHours() + "\n" + "Hourly Rate: " + "$" + getHourlyRate();
    }
}
