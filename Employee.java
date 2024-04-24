import java.util.Scanner;

public class Employee 
{
    String employeeName;
    int salary;
    String type;

    public Employee()
    {
        Scanner scan = new Scanner(System.in);

        System.out.print("\nEmployee's Name: ");
        // employeeName = scan.nextLine();
        employeeName = scan.nextLine();

        System.out.print("Salary: ");
        salary = scan.nextInt();
    }

    // dummy data constructor
    public Employee(String employeeName, int salary, String type) {
        this.employeeName = employeeName;
        this.salary = salary;
        this.type = type;
    }

    public void displayEmployeeTabular() {
        // System.out.println("-------------------------------------------------");
        System.out.printf("| %-19s |", this.employeeName);
        System.out.printf("| %-8s |", this.salary);

    }

    // for patient medical record
    public void displayEmployeeTabular(int dummy) {
        if (dummy == 1) {
            // doctor called this
        System.out.println("-----------------------------------------------------------------");
        }
        else{
            // nurse called this
            System.out.println("------------------------------");

        }
        System.out.printf("| %-19s |", this.employeeName);
    }

    // function for printing single employee
    public void displayEmployee() {
        System.out.println("\nFULL NAME: " + employeeName);
        System.out.println("Salary: " + salary);
    }

}
