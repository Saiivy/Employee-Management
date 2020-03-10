package gursimar_navdeep_a2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Gursimar Singh Hehar This class is the main class and it has fields
 * to take input and store employees plus display results
 */
public class Gursimar_Navdeep_a2 {

    // commmon data fields for every employee
    // made them static to acccess them outside main class and in other methods,to make main method smaller as possible
    private static String firstName = " ";
    private static String lastName = " ";
    private static int id = 0;
    //for salary employee
    private static double salary = 0;

    //For hourly employee
    private static double numHours = 0;
    private static double hourlyRate = 0;

    //For Commission Employee
    private static double rate = 0;
    private static double sales = 0;

    public static void main(String[] args) {
        //Number Of Employees field to set desired number of employees
        int numberOfEmployees = 0;

        //option datafield for menu-options
        int option = 0;

        //For Exiiting Loops
        boolean exitLoop = true;

        //Creating User-Menu
        System.out.println("Welcome, \nHow Many Employess Do You Want To Create?");
        Scanner input = new Scanner(System.in);
        //Adding try-catch blocks for proper required and apporpraite input for the program to funnction.
        do {
            try {
                numberOfEmployees = input.nextInt();
                try {
                    if (numberOfEmployees <= 0) {
                        throw new IllegalArgumentException("Error:Value Must Be Greater Than 0");
                    }
                    exitLoop = false;
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                }
            } catch (InputMismatchException ex) {
                System.out.println("Enter Only Numbers!");
            }
            input.nextLine();
        } while (exitLoop);

        //The size of the arraylist is defined as the no. of employees entered by the user
        ArrayList< Employee> employees = new ArrayList<>();

        //This loop's size is as long as noEmployee and it fills Employee object
        for (int i = 0; i < numberOfEmployees; i++) {
            System.out.printf("Employee %d Of %d \n", i + 1, numberOfEmployees);

            //This method will display options to user related to menu and will ask for their input.
            employeeDetails(option, employees);
            System.out.printf("Employee %d of %d added successfully", i + 1, numberOfEmployees);
            System.out.println("");

        }
        //Results
        results(option, employees);
    } // main-class ends

    // This method is used to take inputs from the users about firstname,lastname and id, and their pay and add them to arraylist
    private static void employeeDetails(int option, ArrayList< Employee> employees) {
        //creating instances
        SalaryEmployee salaryEmployee = new SalaryEmployee();
        HourlyEmployee hourlyEmployee = new HourlyEmployee();
        CommissionEmployee commissionEmployee = new CommissionEmployee();

        Scanner input = new Scanner(System.in);
        //Option to user
        do {
            System.out.printf("Press 1 for Salaried \nPress 2 for Hourly \nPress 3 for Commission\n");
            //try-catch block to ensure proper input
            try {
                option = input.nextInt();
                input.nextLine();
                try {
                    if (option < 1 || option > 3) {
                        throw new IllegalArgumentException("ERROR: Enter Valid Input\nTry-Again");
                    }
                    break;
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                }
            } catch (InputMismatchException ex) {
                System.out.println("Enter Only Numbers!");
            }
            input.nextLine();

        } while (true);

        //Option to enter firstname
        System.out.println("Enter First Name Of  Employee");
        firstName = input.nextLine();

        //Option to enter lasttname
        System.out.println("Enter Last Name Of Employee");
        lastName = input.nextLine();

        //Option to enter id
        System.out.println("Enter id Of Employee");
        do {
            //try-catch block to ensure proper input
            try {

                id = input.nextInt();
                try {
                    salaryEmployee.setId(id);
                    if (idCheck(id, employees)) {
                        break;
                    }
                } catch (IllegalArgumentException ex) {

                    System.out.println("ERROR: Enter Valid Input");
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Enter Valid Input");
            }
            input.nextLine();
        } while (true);
        //different cases for different input
        switch (option) {
            case 1:
                //Option to enter salary.
                System.out.println("Enter Yearly Salary For Salaried Employee");
                do {
                    try {
                        salary = input.nextDouble();
                        try {
                            salaryEmployee.setSalary(salary);
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }//
                    } catch (InputMismatchException ex) {
                        System.out.println("Enter valid Input");

                    }
                    input.nextLine();
                } while (true);
                //Adds every detail of employee entered by the user to arraylist.
                employees.add(new SalaryEmployee(salary, id, firstName, lastName));
                break;
            case 2:
                //Option to enter number of hours worked by employee.
                System.out.println("For How Many hours Did The Employee Work?");
                do {
                    //try-catch block to ensure proper input
                    try {
                        numHours = input.nextDouble();
                        try {
                            hourlyEmployee.setNumHours(numHours);
                            break;
                        } catch (IllegalArgumentException ex) {
                            System.out.println("Error:Enter Valid Input");
                        }//
                    } catch (InputMismatchException e) {
                        System.out.println("ERROR: Enter Valid Input");
                    }
                    input.nextLine();
                } while (true);
                //Option to enter hourly rate given to employee
                System.out.println("What is the hourly rate of the employee?");
                do {
                    //try-catch block to ensure proper input
                    try {
                        hourlyRate = input.nextDouble();
                        try {
                            hourlyEmployee.setHourlyRate(hourlyRate);
                            break;
                        } catch (IllegalArgumentException ex) {
                            System.out.println(ex.getMessage());
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("ERROR: Enter Valid Input");
                    }
                    input.nextLine();
                } while (true);
                //Adds every detail of employee entered by the user to arraylist.
                employees.add(new HourlyEmployee(numHours, hourlyRate, id, firstName, lastName));
                break;
            case 3:
                System.out.println("What is the rate of the employee?");
                do {
                    //try-catch block to ensure proper input
                    try {
                        rate = input.nextDouble();
                        try {
                            commissionEmployee.setRate(rate);
                            break;
                        } catch (IllegalArgumentException ex) {
                            System.out.println(ex.getMessage());
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("ERROR: Enter Valid Input");
                    }
                    input.nextLine();
                } while (true);
                //Option to sales done by employee
                System.out.println("What are the sales of the employee?");
                do {
                    //try-catch block to ensure proper input
                    try {
                        sales = input.nextDouble();
                        try {
                            commissionEmployee.setSales(sales);
                            break;
                        } catch (IllegalArgumentException ex) {

                            System.out.println(ex.getMessage());
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("ERROR: Enter Valid Input");
                    }

                    input.nextLine();
                } while (true);
                //Adds every detail of employee entered by the user to arraylist.
                employees.add(new CommissionEmployee(id, firstName, lastName, rate, sales));

        }
    }

    //method to give option to user to choose a report and its options and results
    private static void results(int option, ArrayList< Employee> Employee) {
        int repeatResult = 0;
        while (repeatResult == 0) {
            do {
                Scanner input = new Scanner(System.in);
                System.out.println("Choose A Report");
                System.out.println("1. Employee Listing");
                System.out.println("2. Payroll Listing");
                System.out.println("3. Exit");

                try {
                    option = input.nextInt();
                    break;
                } catch (InputMismatchException ex) {
                    System.out.println("Error:Enter Valid Input");
                    input.nextLine();
                }

            } while (true);

            switch (option) {
                case 1:
                    //Calling displayEmployeeInfo and display's it if user entered 1.
                    displayEmployeeInfo(Employee);
                    break;
                case 2:
                    //Calling displayEmployeePayroll and display's it if user entered 2.
                    displayEmployeePayroll(Employee);
                    break;
                //Exits app if user enters 3
                case 3:
                    System.out.println("Have A Nice Day!");
                    repeatResult = 1;
                    break;
                default:
                    break;
            }
        }
    }

    // this method displays the info about employess
    private static void displayEmployeeInfo(ArrayList< Employee> employees) {
        //Looping through each employee and displaying employee's info

        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }

    //this method displays payroll of  employess
    private static void displayEmployeePayroll(ArrayList< Employee> employees) {
        //Looping through each employee and displaying employee's Pay with name and id in format.
        for (Employee employee : employees) {
            System.out.println("Weekly Pay For " + Gursimar_Navdeep_a2.lastName + ", " + Gursimar_Navdeep_a2.firstName
                    + " Having ID " + Gursimar_Navdeep_a2.id + " Is " + "$" + String.format("%.2f", employee.calculatePay()));
        }
    }

    //this method checks if everytime unique id is provided to the employees
    public static boolean idCheck(int id, ArrayList< Employee> employees) {

        boolean unique = true;

        for (Employee employee : employees) {
            if (id == employee.getId()) {
                System.out.println("Id Already Exits ,\nTryAgain");
                unique = false;
                break;
            }
        }
        return unique;
    }

}
