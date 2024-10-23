package doctormanager;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class DoctorManagementSystem {
    private List<Doctor> doctors;

    public DoctorManagementSystem() {
        this.doctors = new ArrayList<>();
    }

    // Add a doctor
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
        System.out.println("Doctor added successfully.");
    }

    // Edit a doctor by ID
    public void editDoctor(int id, String newName, String newDOB, String newSpecialization, int newAvailability, String newEmail, String newMobile) {
        Doctor doctor = searchDoctorById(id);
        if (doctor != null) {
            doctor.setName(newName);
            doctor.setDateOfBirth(newDOB);
            doctor.setSpecialization(newSpecialization);
            doctor.setAvailability(newAvailability);
            doctor.setEmail(newEmail);
            doctor.setMobile(newMobile);
            System.out.println("Doctor updated successfully.");
        } else {
            System.out.println("Doctor with ID " + id + " not found.");
        }
    }

    // Delete a doctor by ID
    public void deleteDoctor(int id) {
        Doctor doctor = searchDoctorById(id);
        if (doctor != null) {
            doctors.remove(doctor);
            System.out.println("Doctor deleted successfully.");
        } else {
            System.out.println("Doctor with ID " + id + " not found.");
        }
    }

    // Search a doctor by ID
    public Doctor searchDoctorById(int id) {
        for (Doctor doctor : doctors) {
            if (doctor.getId() == id) {
                return doctor;
            }
        }
        return null;
    }

    // Search doctors by Name
    public void searchDoctorByName(String name) {
        for (Doctor doctor : doctors) {
            if (doctor.getName().equalsIgnoreCase(name)) {
                System.out.println(doctor);
            }
        }
    }

    // Sort doctors by Date of Birth
    public void sortDoctorsByDOB() {
        doctors.sort(Comparator.comparing(Doctor::getDateOfBirth));
        System.out.println("Doctors sorted by Date of Birth.");
        for (Doctor doctor : doctors) {
            System.out.println(doctor);
        }
    }

    // Get all doctors
    public List<Doctor> getDoctors() {
        return doctors;
    }
}
