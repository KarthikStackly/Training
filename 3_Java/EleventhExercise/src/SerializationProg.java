import java.io.*;

//public class Patient extends Serializable {
class Patient implements Serializable {
    int patientID;
    String patientName;
    int patientAge;

    Patient(int patientID, String patientName, int patientAge) {
        this.patientID = patientID;
        this.patientName = patientName;
        this.patientAge = patientAge;
    }
}


public class SerializationProg {
    static void main() {
//        Creating and Initializing Objects
        Patient karthik = new Patient(1234, "Karthik", 30);
        Patient ramya = new Patient(2345, "Ramya", 34);

//        Serializing first...

        try { //Mandatory try catch block
//            Opening File IO to create new file
            FileOutputStream fileio = new FileOutputStream("karObjFile.abc");
//            Opening Object IO to serialize Objects in the next step
            ObjectOutputStream karObj = new ObjectOutputStream(fileio);

//            Writing both Objects into file using the Objects just created.
            karObj.writeObject(karthik);
            karObj.writeObject(ramya);

            // closing both IO
            fileio.close();
            karObj.close();

            System.out.println("Patient objects serialized");

        } catch (IOException e) {
            System.out.println("Something went wrong: " + e);
        }


//        DeSerializing next...

        try {

            FileInputStream fileio = new FileInputStream("karObjFile.abc"); //next time best to declare a new string to hold file name.
            ObjectInputStream karObj = new ObjectInputStream(fileio);

//            karObj.read(karthik);
//            karObj.read(ramya);

            Patient restoredKarthik = (Patient) karObj.readObject();
            Patient restoredRamya = (Patient) karObj.readObject();

            fileio.close();
            karObj.close();

            System.out.println("******* Retrieving Objects!! *******");

            System.out.println("\n=== Karthik ===");
            System.out.println("Karthik ID: " + restoredKarthik.patientID);
            System.out.println("Karthik Name: " + restoredKarthik.patientName);
            System.out.println("Karthik Age: " + restoredKarthik.patientAge);
            System.out.println("\n=== Ramya === ");
            System.out.println("Ramya ID: " + restoredRamya.patientID);
            System.out.println("Ramya Name: " + restoredRamya.patientName);
            System.out.println("Ramya Age: " + restoredRamya.patientAge);

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Something went wrong : " + e.getMessage());
        }
    }
}
