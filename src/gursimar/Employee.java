package gursimar_navdeep_a2;

/**
 * This class represents an employee.
 *
 * @author Gursimar Singh Hehar
 */
abstract class Employee {

    // Id data field for setting unique id to each employee
    int id;
    // First name of the employee
    String firstName;
    // Last name of  the employee
    String lastName;

    // Constructor 
    public Employee(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // //creating another contructor to check illegalarugmentexception in main class
    public Employee() {
    }

    // Getter and Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ERROR(209): Value must be > 0!");

        }
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * A CaluclatePay() method which will be used to calculate pay of various
     * employees in its sub-classes
     */
    abstract double calculatePay();

    /**
     *
     * @return FirstName , LastName and Id
     */
    @Override
    public String toString() {
        return "FirstName:" + firstName + "\n" + "LastName: " + lastName + "\n" + "ID: " + id;
    }
}
