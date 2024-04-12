import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
public class DataBase {
    static int nurseTurn;
    ArrayList<Patient> patData = new ArrayList<>();
    ArrayList<Doctor> docData = new ArrayList<>();
    ArrayList<Nurse> nurData = new ArrayList<>();

    public DataBase() throws IOException {
        // DUMMY DATA
        // -------------------------------------------------------------------------------------------

        // Adding dummy data for patients
        Patient patient1 = new Patient(101, "Anjali Gupta", "1234567890", "123, Main Street, City", "O+", "Female", 35,"Cardiology",101,201);
        patData.add(patient1);

        Patient patient2 = new Patient(102, "Amit Singh", "9876543210", "456, Second Avenue, Town", "A-", "Male", 45,"Rheumatology",102,202);
        patData.add(patient2);

        Patient patient3 = new Patient(103, "Priya Sharma", "9998887776", "789, Third Road, Village", "B+", "Female",
                25,"Pediatry",103,203);
        patData.add(patient3);

        Patient patient4 = new Patient(104, "Rahul Kapoor", "8887776665", "101, Fourth Lane, Countryside", "AB-",
                "Male", 55,"ENT",104,204);
        patData.add(patient4);

        Patient patient5 = new Patient(105, "Neha Patel", "6665554443", "678, Fifth Street, Suburb", "O-", "Female",
                30,"Dental",105,205);
        patData.add(patient5);

        // // Adding dummy data for doctors
        Doctor doctor1 = new Doctor(101, "Dr. Rajesh Kumar", "Cardiology", "Cardiologist", 150000);
        docData.add(doctor1);

        Doctor doctor2 = new Doctor(102, "Dr. Priya Patel", "Rheumatology", "Rheumatologist", 140000);
        docData.add(doctor2);

        Doctor doctor3 = new Doctor(103, "Dr. Amit Sharma", "Pediatry", "Pediatrician", 130000);
        docData.add(doctor3);

        Doctor doctor4 = new Doctor(104, "Dr. Naman Gehlot", "ENT", "ENT Specialist", 130000);
        docData.add(doctor4);

        Doctor doctor5 = new Doctor(105, "Dr. Vaibhav Sehgal ", "Dental", "Dentist", 130000);
        docData.add(doctor5);

        // Adding dummy data for nurses
        Nurse nurse1 = new Nurse(201, "Nurse Sunita Verma", 80000);
        nurData.add(nurse1);

        Nurse nurse2 = new Nurse(202, "Nurse Sanjay Mishra", 75000);
        nurData.add(nurse2);

        Nurse nurse3 = new Nurse(203, "Nurse Meera Patel",  85000);
        nurData.add(nurse3);

        Nurse nurse4 = new Nurse(204, "Nurse Reshma Ahuja",  86000);
        nurData.add(nurse4);

        Nurse nurse5 = new Nurse(205, "Nurse Ekta Kapoor",  83500);
        nurData.add(nurse5);
        // ------------------------------------------------------------------------------------------
    }

    public void initiateDatabase()
    {
        Iterator<Patient> pat_Iter = patData.iterator();

        while(pat_Iter.hasNext())
        {
            Patient pat = pat_Iter.next();
            Iterator<Doctor> doc_Iter = docData.iterator();
            while(doc_Iter.hasNext())
            {
                Doctor doc = doc_Iter.next();
                if(pat.getAllotedDoctor() == doc.get_Id())
                {
                    doc.PatientsAssignedToDoc.add(pat.get_Id());
                    doc.setNumberOfPatientsAssigned(1);
                    break;
                }
            }

            Iterator<Nurse> nur_Iter = nurData.iterator();
            while(nur_Iter.hasNext())
            {
                Nurse nur = nur_Iter.next();
                if(pat.getAllotedNurse() == nur.get_Id())
                {
                    nur.PatientsAssignedToNur.add(pat.get_Id());
                    nur.setNumberOfPatientsAssigned(1);
                    break;
                }
            }
        }
    }

    public void searchPatient(int patID)
    {
        for(Patient pat : this.patData)
        {
            if(pat.get_Id() == patID)
            {
                pat.displayPatient();
                return;
            }
        }
        System.out.println("Patient Not Found...");
    }

    public void searchDoctor(int docID)
    {
        for(Doctor doc : this.docData)
        {
            if(doc.get_Id() == docID)
            {
                doc.displayDoctor();
                return;
            }
        }
        System.out.println("Doctor Not Found...");
    }

    public void searchNurse(int nurID)
    {
        for(Nurse nur : this.nurData)
        {
            if(nur.get_Id() == nurID)
            {
                nur.displayNurse();
                return;
            }
        }
        System.out.println("Nurse Not Found...");
    }

    public void displayAllPatients()
    {
        System.out.println("\n------------------Patients Data----------------------");
        for(Patient pat : this.patData)
        {
            System.out.println("---------------------------------------------------\n");
            pat.displayPatient();
        }
    }

    public void displayAllDoctors()
    {
        System.out.println("\n------------------Doctors Data----------------------");
        for(Doctor doc : this.docData)
        {
            System.out.println("---------------------------------------------------\n");
            doc.displayDoctor();
        }
    }

    public void displayAllNurses()
    {
        System.out.println("\n------------------Nurse Data----------------------");
        for(Nurse nur : this.nurData)
        {
            System.out.println("---------------------------------------------------\n");
            nur.displayNurse();
        }
    }

    public void addPatient(Patient Pat) {
        patData.add(Pat);
    }

    public void addDoctor(Doctor Doc) {
        docData.add(Doc);
    }

    public void addNurse(Nurse Nur) {
        nurData.add(Nur);
    }

    public void removePatient(int pat_ID) 
    {
        Iterator<Patient> iterator = patData.iterator();
        while (iterator.hasNext()) {
            Patient pat = iterator.next();
            if (pat.get_Id() == pat_ID) 
            {
                iterator.remove();
                System.out.println("Patient Removed.\n");
                // If you want to remove only the first occurrence of the patient ID
                return;
            }
        }
        System.out.println("Patient you wanted to remove was not found.\n");
    }
    public void removeDoctor(int doc_ID) {
        Iterator<Doctor> iterator = docData.iterator();
        while (iterator.hasNext()) {
            Doctor doc = iterator.next();
            if (doc.get_Id() == doc_ID) {
                iterator.remove();
                System.out.println("Doctor Removed.\n");
                // If you want to remove only the first occurrence of the doctor ID
                return;
            }
        }
        System.out.println("Doctor you wanted to remove was not found.\n");
    }

    public void removeNurse(int nur_ID) {
        Iterator<Nurse> iterator = nurData.iterator();
        while (iterator.hasNext()) {
            Nurse nur = iterator.next();
            if (nur.get_Id() == nur_ID) {
                iterator.remove();
                System.out.println("Nurse Removed.\n");
                // If you want to remove only the first occurrence of the nurse ID
                return;
            }
        }
        System.out.println("Nurse you wanted to remove was not found.\n");
    }

    public int assign_Doctor(String dept, int patId)
    {
        Iterator<Doctor> iterator = this.docData.iterator();
        while (iterator.hasNext()) 
        {
           Doctor doc  = iterator.next();
           if (dept.equals(doc.department)) 
           {
            doc.PatientsAssignedToDoc.add(patId);
            doc.setNumberOfPatientsAssigned(1);
            System.out.println("Doctor assigned.");
            return doc.get_Id();
           }
        }
        System.out.println("Doctor could not be assigned.");
            return -1;
    }

    public int assign_Nurse(int patId)
    {
        int allotID =  this.nurData.get(nurseTurn % this.nurData.size()).get_Id();
        Iterator<Nurse> iterator = this.nurData.iterator();
        while(iterator.hasNext())
        {
            Nurse nur = iterator.next();
            if(allotID == nur.get_Id())
            {
                nur.PatientsAssignedToNur.add(patId);
                nur.setNumberOfPatientsAssigned(1);
                break;
            }
        }
        nurseTurn++;
        System.out.println("Nurse Alloted");
        return allotID;
    }

    
    public Patient getPatient(int patID){
        Iterator<Patient> iterator =this.patData.iterator();
        while (iterator.hasNext()) 
        {
            Patient pat  = iterator.next();
            if (pat.get_Id() == patID) 
            {
                return pat;
            }
        }
        return null;
    }
}