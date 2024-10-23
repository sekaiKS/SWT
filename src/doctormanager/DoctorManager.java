package doctormanager;

import java.util.Scanner;

public class DoctorManager {

    public static void main(String[] args) {
        DoctorManagementSystem system = new DoctorManagementSystem();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Doctor Management System ---");
            System.out.println("1. Add Doctor");
            System.out.println("2. Edit Doctor");
            System.out.println("3. Delete Doctor");
            System.out.println("4. Search Doctor by ID");
            System.out.println("5. Search Doctor by Name");
            System.out.println("6. Sort Doctors by Date of Birth");
            System.out.println("7. Display All Doctors");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    // Add a new doctor
                    System.out.println("Enter Doctor Name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter Doctor Date of Birth (dd/MM/yyyy):");
                    String dob = scanner.nextLine();
                    System.out.println("Enter Doctor Specialization:");
                    String specialization = scanner.nextLine();
                    System.out.println("Enter Doctor Availability (0: Vacation, 1: Available, 2: Emergency, 3: Diagnosing):");
                    int availability = scanner.nextInt();
                    scanner.nextLine();  // consume newline
                    System.out.println("Enter Doctor Email:");
                    String email = scanner.nextLine();
                    System.out.println("Enter Doctor Mobile ((000)-000-0000):");
                    String mobile = scanner.nextLine();

                    Doctor doctor = new Doctor(name, dob, specialization, availability, email, mobile);
                    system.addDoctor(doctor);
                    break;

                case 2:
                    // Edit an existing doctor
                    System.out.println("Enter Doctor ID to Edit:");
                    int editId = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.println("Enter New Doctor Name:");
                    String newName = scanner.nextLine();
                    System.out.println("Enter New Doctor Date of Birth (dd/MM/yyyy):");
                    String newDob = scanner.nextLine();
                    System.out.println("Enter New Doctor Specialization:");
                    String newSpec = scanner.nextLine();
                    System.out.println("Enter New Doctor Availability:");
                    int newAvailability = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.println("Enter New Doctor Email:");
                    String newEmail = scanner.nextLine();
                    System.out.println("Enter New Doctor Mobile:");
                    String newMobile = scanner.nextLine();

                    system.editDoctor(editId, newName, newDob, newSpec, newAvailability, newEmail, newMobile);
                    break;

                case 3:
                    // Delete a doctor
                    System.out.println("Enter Doctor ID to Delete:");
                    int deleteId = scanner.nextInt();
                    system.deleteDoctor(deleteId);
                    break;

                case 4:
                    // Search a doctor by ID
                    System.out.println("Enter Doctor ID to Search:");
                    int searchId = scanner.nextInt();
                    Doctor foundDoctor = system.searchDoctorById(searchId);
                    if (foundDoctor != null) {
                        System.out.println(foundDoctor);
                    } else {
                        System.out.println("Doctor with ID " + searchId + " not found.");
                    }
                    break;

                case 5:
                    // Search a doctor by Name
                    System.out.println("Enter Doctor Name to Search:");
                    String searchName = scanner.nextLine();
                    system.searchDoctorByName(searchName);
                    break;

                case 6:
                    // Sort doctors by Date of Birth
                    system.sortDoctorsByDOB();
                    break;

                case 7:
                    // Display all doctors
                    for (Doctor doc : system.getDoctors()) {
                        System.out.println(doc);
                    }
                    break;

                case 0:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice! Please select again.");
            }
        }

        scanner.close();
    }
}
