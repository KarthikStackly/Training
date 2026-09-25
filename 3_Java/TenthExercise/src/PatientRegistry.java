class Patient {

    private int patientID;
    private String patientName;
    private int patientAge;
    private String patientIllness;
    private double billAmount;

    public Patient(int patientID, String patientName, int patientAge) {
        this.patientID = patientID;
        this.patientName = patientName;
        this.patientAge = patientAge;
        this.billAmount = 0.0;
    }

//  Controlled update (mutation)
    public void registerIllness(String patientIllness) {
        if (patientIllness != null && !patientIllness.trim().isEmpty()) {
            this.patientIllness = patientIllness;
        }
    }

    public double calculateBill(double consultationFee, double medicineCost) {
        this.billAmount = consultationFee + medicineCost;
        return this.billAmount;
    }

//  Getters for controlled read access
    public int getPatientID() { return patientID; }
    public String getPatientName() { return patientName; }
    public int getPatientAge() { return patientAge; }
    public String getPatientIllness() { return patientIllness; }
    public double getBillAmount() { return billAmount; }

    // Helper method to display complete summary
    public String getPatientDetails() {
        return "ID: " + patientID + " | Name: " + patientName +
                " | Age: " + patientAge + " | Illness: " + patientIllness;
    }
}

public class PatientRegistry {
    public static void main(String[] args) {
        System.out.println("*** Welcome to Scampollo Scamspitals ***\n");

        Patient karthik = new Patient(1234, "Karthik", 30);
        karthik.registerIllness("Fever");

        karthik.calculateBill(500.00, 250.00);

        System.out.println(karthik.getPatientDetails());
        System.out.println("Total Bill Amount: INR " + karthik.getBillAmount());
    }
}