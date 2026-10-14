import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Patient {
    private int patientId;
    private String name;
    private int age;

    Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "ID: " + patientId + " | Name: " + name + " | Age: " + age;
    }
}


class Doctor {

    private int doctorId;
    private String name;
    private String specialization;
    Doctor(int doctorId, String name, String specialization) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    @Override
    public String toString() {
        return "ID: " + doctorId +
                " | Dr. " + name +
                " | Specialization: " + specialization;
    }
}

enum AppointmentStatus { BOOKED, CANCELLED }
class Appointment {
    private String appointmentId;
    private Patient patient;
    private Doctor doctor;
    private LocalDate date;
    private LocalTime time;
    private AppointmentStatus status;

    Appointment(String appointmentId, Patient patient, Doctor doctor, LocalDate date, LocalTime time) {

        this.appointmentId = appointmentId;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
        this.status = AppointmentStatus.BOOKED;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void cancel() {
        status = AppointmentStatus.CANCELLED;
    }

    @Override
    public String toString() {
        return "Appointment ID: " + appointmentId + " | Patient: " + patient.getName() + " | Doctor: Dr. " + doctor.getName() + " | Date: " + date + " | Time: " + time + " | Status: " + status;
    }
}

class Hospital {
    private Map<Integer, Patient> patients = new HashMap<>();
    private Map<Integer, Doctor> doctors = new HashMap<>();
    private Map<String, Appointment> appointments = new HashMap<>();
    private int nextAppointmentId = 1;

//      Available hospital appointment slots
    private final LocalTime[] availableSlots = {
            LocalTime.of(9, 0),
            LocalTime.of(10, 0),
            LocalTime.of(11, 0),
            LocalTime.of(14, 0),
            LocalTime.of(15, 0),
            LocalTime.of(16, 0)
    };


//---------------- PATIENT ----------------
    public void registerPatient(Scanner scan) {
        System.out.print("Enter Patient ID: ");
        int patientId = scan.nextInt();
        if (patients.containsKey(patientId)) {
            System.out.println("Error: Patient ID already exists.");
            return;
        }

        scan.nextLine();
        System.out.print("Enter Patient Name: ");
        String name = scan.nextLine();
        System.out.print("Enter Patient Age: ");
        int age = scan.nextInt();
        if (age <= 0) {
            System.out.println("Error: Invalid age.");
            return;
        }

        Patient patient = new Patient(patientId, name, age);
        patients.put(patientId, patient);
        System.out.println("Patient registered successfully.");
    }


    public void displayPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients registered.");
            return;
        }
        System.out.println("\n--- Registered Patients ---");
        for (Patient patient : patients.values()) {
            System.out.println(patient);
        }
    }


//---------------- DOCTOR ----------------
    public void addDoctor(Scanner scan) {
        System.out.print("Enter Doctor ID: ");
        int doctorId = scan.nextInt();

        if (doctors.containsKey(doctorId)) {
            System.out.println("Error: Doctor ID already exists.");
            return;
        }
        scan.nextLine();

        System.out.print("Enter Doctor Name: ");
        String name = scan.nextLine();
        System.out.print("Enter Specialization: ");
        String specialization = scan.nextLine();
        Doctor doctor = new Doctor(doctorId, name, specialization);

        doctors.put(doctorId, doctor);
        System.out.println("Doctor added successfully.");
    }


    public void displayDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors available.");
            return;
        }
        System.out.println("\n--- Doctors ---");

        for (Doctor doctor : doctors.values()) {
            System.out.println(doctor);
        }
    }

//---------------- APPOINTMENT ----------------
    public void bookAppointment(Scanner scan) {
        if (patients.isEmpty() || doctors.isEmpty()) {
            System.out.println("You need at least one patient and one doctor before booking.");
            return;
        }

        System.out.print("Enter Patient ID: ");
        int patientId = scan.nextInt();
        Patient patient = patients.get(patientId);

        if (patient == null) {
            System.out.println("Error: Patient not found");
            return;
        }

        System.out.print("Enter Doctor ID: ");
        int doctorId = scan.nextInt();
        Doctor doctor = doctors.get(doctorId);
        if (doctor == null) {
            System.out.println("Error: Doctor not found");
            return;
        }

        System.out.print("Enter appointment date (YYYY-MM-DD): ");
        String dateInput = scan.next();
        LocalDate date;

        try {
            date = LocalDate.parse(dateInput);
        } catch (Exception e) {
            System.out.println("Error: Invalid date format");
            return;
        }

        if (date.isBefore(LocalDate.now())) {
            System.out.println("Error: Appointment cannot be in the past.");
            return;
        }

        System.out.println("\nAvailable time slots:");

        for (LocalTime slot : availableSlots) {
            if (isSlotAvailable(doctor, date, slot)) {
                System.out.println(slot);
            }
        }

        System.out.print("Enter time (HH:MM): ");
        String timeInput = scan.next();
        LocalTime time;

        try {
            time = LocalTime.parse(timeInput);
        } catch (Exception e) {
            System.out.println("Error: Invalid time format.");
            return;
        }

        if (!isValidSlot(time)) {
            System.out.println("Error: This is not a valid hospital slot.");
            return;
        }

        if (!isSlotAvailable(doctor, date, time)) {
            System.out.println("Error: This doctor already has an appointment at this time.");
            return;
        }

        String appointmentId = String.format("A%03d", nextAppointmentId++);
        Appointment appointment = new Appointment(appointmentId, patient, doctor, date, time);
        appointments.put(appointmentId, appointment);
        System.out.println("\nAppointment booked successfully.");
        System.out.println(appointment);
    }


    private boolean isValidSlot(LocalTime time) {
        for (LocalTime slot : availableSlots) {
            if (slot.equals(time)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSlotAvailable(Doctor doctor, LocalDate date, LocalTime time) {
        for (Appointment appointment : appointments.values()) {
            if (appointment.getStatus() == AppointmentStatus.BOOKED && appointment.getDoctor().getDoctorId() == doctor.getDoctorId() && appointment.getDate().equals(date) && appointment.getTime().equals(time)) {

                return false;
            }
        }
        return true;
    }


//---------------- CANCEL ----------------
    public void cancelAppointment(Scanner scan) {
        System.out.print("Enter Appointment ID: ");
        String appointmentId = scan.next();

        Appointment appointment = appointments.get(appointmentId);

        if (appointment == null) {
            System.out.println("Error: Appointment not found.");
            return;
        }

        if (appointment.getStatus() == AppointmentStatus.CANCELLED) {
            System.out.println("Appointment is already cancelled.");
            return;
        }
        appointment.cancel();
        System.out.println("Appointment cancelled successfully.");
    }


//---------------- AVAILABLE SLOTS ----------------
    public void viewAvailableSlots(Scanner scan) {
        System.out.print("Enter Doctor ID: ");
        int doctorId = scan.nextInt();
        Doctor doctor = doctors.get(doctorId);

        if (doctor == null) {
            System.out.println("Error: Doctor not found.");
            return;
        }

        System.out.print("Enter date (YYYY-MM-DD): ");
        String dateInput = scan.next();
        LocalDate date;
        try {
            date = LocalDate.parse(dateInput);
        } catch (Exception e) {
            System.out.println("Error: Invalid date.");
            return;
        }

        System.out.println("\nAvailable slots for Dr. " + doctor.getName() + " on " + date + ":");
        boolean found = false;
        for (LocalTime slot : availableSlots) {
            if (isSlotAvailable(doctor, date, slot)) {
                System.out.println(slot);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No slots available.");
        }
    }


    // ---------------- DOCTOR SCHEDULE ----------------
    public void viewDoctorSchedule(Scanner scan) {
        System.out.print("Enter Doctor ID: ");
        int doctorId = scan.nextInt();
        Doctor doctor = doctors.get(doctorId);

        if (doctor == null) {
            System.out.println("Error: Doctor not found.");
            return;
        }

        System.out.println("\n--- Schedule for Dr. " + doctor.getName() + " ---");
        boolean found = false;
        for (Appointment appointment : appointments.values()) {
            if (appointment.getDoctor().getDoctorId() == doctorId && appointment.getStatus() == AppointmentStatus.BOOKED) {
                System.out.println(appointment);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No appointments scheduled.");
        }
    }


//---------------- PATIENT HISTORY ----------------
    public void viewPatientHistory(Scanner scan) {
        System.out.print("Enter Patient ID: ");
        int patientId = scan.nextInt();
        Patient patient = patients.get(patientId);

        if (patient == null) {
            System.out.println("Error: Patient not found.");
            return;
        }

        System.out.println("\n--- Appointment History for " + patient.getName() + " ---");
        boolean found = false;
        for (Appointment appointment : appointments.values()) {
            if (appointment.getPatient().getPatientId() == patientId) {
                System.out.println(appointment);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No appointment history.");
        }
    }
}


public class HospitalAppointmentSystm {
    static void main() {
        Scanner scan = new Scanner(System.in);
        Hospital hospital = new Hospital();

        int choice;
        do {

            System.out.println("\n==================================");
            System.out.println("   HOSPITAL APPOINTMENT SYSTEM");
            System.out.println("==================================");

            System.out.println("1. Register Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. View Patients");
            System.out.println("4. View Doctors");
            System.out.println("5. Book Appointment");
            System.out.println("6. Cancel Appointment");
            System.out.println("7. View Available Slots");
            System.out.println("8. View Doctor Schedule");
            System.out.println("9. View Patient History");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            choice = scan.nextInt();

            switch (choice) {
                case 1 -> hospital.registerPatient(scan);
                case 2 -> hospital.addDoctor(scan);
                case 3 -> hospital.displayPatients();
                case 4 -> hospital.displayDoctors();
                case 5 -> hospital.bookAppointment(scan);
                case 6 -> hospital.cancelAppointment(scan);
                case 7 -> hospital.viewAvailableSlots(scan);
                case 8 -> hospital.viewDoctorSchedule(scan);
                case 9 -> hospital.viewPatientHistory(scan);
                case 10 -> System.out.println("Exiting Hospital System...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 10);
        scan.close();
    }
}