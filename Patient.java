    import java.util.*;

import javax.print.Doc;
    public class Patient
    {
        static int PatientID_Gen = 100;
        private int PatientID;
        private int allottedDoctorID;
        private int allottedNurseID;
        private String PatientName;
        private String Contact_No;
        private String Address;
        private String BloodGroup;
        private String Gender;
        String[] DepartmentConcernedList = {"Rheumatology","Cardiology","Pediatric","ENT","Dentist"};
        private String DepartmentConcerned;
        private int Age;    

        public Patient(DataBase dat)
        {
            PatientID = ++PatientID_Gen;

            Scanner scan = new Scanner(System.in);
            System.out.print("\nPATIENT'S NAME: ");
                PatientName = scan.nextLine();
                

            System.out.print("GENDER: ");
                Gender = scan.nextLine();

            System.out.println("Select Nature of Illness:");
            System.out.println("1. Joint-Pain Issues");
            System.out.println("2. Cardiac Issues");
            System.out.println("3. Dietary Issues");
            System.out.println("4. ENT Issues");
            System.out.println("5. Dental Issues");
    
            whileloop: while (true) 
            {
                int n = scan.nextInt();
                switch (n) 
                {
                    case 1:
                    DepartmentConcerned  = DepartmentConcernedList[0];
                        break whileloop;
                    case 2:
                    DepartmentConcerned  = DepartmentConcernedList[1];
                        break whileloop;  
                    case 3:
                    DepartmentConcerned  = DepartmentConcernedList[2];
                        break whileloop;  
                    case 4:
                    DepartmentConcerned  = DepartmentConcernedList[3];
                        break whileloop;  
                    case 5:
                    DepartmentConcerned  = DepartmentConcernedList[4];
                        break whileloop;
                    default:
                    System.out.println("Please select a valid option");
                        break;
                }    
            }

            System.out.println("Allotting Doctor...");
            this.allot_Doctor(dat);

            System.out.println("Alloting Nurse...");
            this.allot_Nurse(dat);

            System.out.print("CONTACT NUMBER: ");
                Contact_No = scan.nextLine();


            System.out.print("BLOOD GROUP: ");
            System.out.print("Enter the blood group if known, else enter NA : ");
                BloodGroup = scan.nextLine();

            System.out.print("ADDRESS: ");
                Address = scan.nextLine();

            System.out.print("AGE: ");
                Age = scan.nextInt();
            
            
        }


        // Dummy data constructor
        public Patient(int PatientID,String PatientName,String Contact_No,String Address,String BloodGroup,String Gender,int Age,String DepartmentConcerned,int allottedDoctorID, int allottedNurseID)
        {
            this.PatientID = PatientID;
            this.PatientName = PatientName;
            this.Contact_No = Contact_No;
            this.Address = Address;
            this.BloodGroup = BloodGroup;
            this.Gender = Gender;
            this.Age = Age;
            this.DepartmentConcerned = DepartmentConcerned;
            this.allottedDoctorID = allottedDoctorID;
            this.allottedNurseID = allottedNurseID;
        }

        public int get_Id()
        {
            return this.PatientID;
        }

        public void allot_Doctor(DataBase dat)
        {
            this.allottedDoctorID = dat.assign_Doctor(this.DepartmentConcerned);
        }

        public void allot_Nurse(DataBase dat)
        {
            this.allottedNurseID = dat.assign_Nurse();
        }

  
        public void displayPatient()
        {
            System.out.println("Patient ID: "+ PatientID);
            System.out.println("FULL NAME: " + PatientName);
            System.out.println("CONTACT NUMBER: " + Contact_No);
            System.out.println("BLOOD GROUP: " + BloodGroup);
            System.out.println("GENDER: "  + Gender);
            System.out.println("ADDRESS: " + Address);
            System.out.println("AGE: " + Age);
            System.out.println("Consulting Physician: " + DepartmentConcerned);
            System.out.println("Alloted Doctor ID: "+ allottedDoctorID);
            System.out.println("Alloted Nurse ID: "+ allottedNurseID);

        }
    }