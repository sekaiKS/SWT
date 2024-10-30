package doctormanager;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class DoctorManagementSystem {
    private List<Doctor> doctors = new ArrayList<>();

    // Add a doctor
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
        System.out.println("Doctor added successfully.");
    }

    // Edit a doctor by ID
    public void editDoctor(int id, String newName, String newDOB, String newSpecialization, int newAvailability, String newEmail, String newMobile) {
        Doctor doctor = searchDoctorById(id);
        if (doctor == null) {
            System.out.println("Doctor with ID " + id + " not found.");
            return;
        }
        doctor.setName(newName);
        doctor.setDateOfBirth(newDOB);
        doctor.setSpecialization(newSpecialization);
        doctor.setAvailability(newAvailability);
        doctor.setEmail(newEmail);
        doctor.setMobile(newMobile);
        System.out.println("Doctor updated successfully.");
    }

    // Delete a doctor by ID
    public void deleteDoctor(int id) {
        Doctor doctor = searchDoctorById(id);
        if (doctor != null && doctors.remove(doctor)) {
            System.out.println("Doctor deleted successfully.");
        } else {
            System.out.println("Doctor with ID " + id + " not found.");
        }
    }

    // Search a doctor by ID
    public Doctor searchDoctorById(int id) {
        return doctors.stream().filter(d -> d.getId() == id).findFirst().orElse(null);
    }

    // Search doctors by Name
    public void searchDoctorByName(String name) {
        doctors.stream()
            .filter(d -> d.getName().equalsIgnoreCase(name))
            .forEach(System.out::println);
    }

    // Sort doctors by Date of Birth
    public void sortDoctorsByDOB() {
        doctors.sort(Comparator.comparing(Doctor::getDateOfBirth));
        System.out.println("Doctors sorted by Date of Birth:");
        doctors.forEach(System.out::println);
    }

    // Get all doctors
    public List<Doctor> getDoctors() {
        return new ArrayList<>(doctors); // Return a copy to avoid external modification
    }
}
