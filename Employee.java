import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Employee 
{
    String employeeName;
    int salary;
    String type;

    public Employee() throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        Scanner scan = new Scanner(System.in);

        System.out.print("\nEmployee's Name: ");
        // employeeName = scan.nextLine();
        employeeName = bfr.readLine();

        System.out.print("Salary: ");
        salary = scan.nextInt();
    }

    // dummy data constructor
    public Employee(String employeeName, int salary, String type) {
        this.employeeName = employeeName;
        this.salary = salary;
        this.type = type;
    }


    
    public void displayEmployeeTabular() 
    {   
        // System.out.println("-------------------------------------------------");
        System.out.printf("| %-19s |", this.employeeName);
        System.out.printf("| %-8s |", this.salary);

    }

    // function for printing single employee
    public void displayEmployee() 
    {   
        System.out.println("-------------------------------------------------");
        System.out.println("\nFULL NAME: " + employeeName);
        System.out.println("Salary: " + salary);
    }
    public void displayEmployee(int dummy) 
    {   
        System.out.println("-------------------------------------------------");
        System.out.println("\nFULL NAME: " + employeeName);
    }
}
