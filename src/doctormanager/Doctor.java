package doctormanager;

public class Doctor {
    private static int idCounter = 1;
    private int id;
    private String name;
    private String dateOfBirth;
    private String specialization;
    private int availability; // 0: Vacation, 1: Available, 2: Emergency, 3: Diagnosing
    private String email;
    private String mobile;

    public Doctor(String name, String dateOfBirth, String specialization, int availability, String email, String mobile) {
        this.id = idCounter++;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.specialization = specialization;
        this.availability = availability;
        this.email = email;
        this.mobile = mobile;
    }

    // Getters and Setters
    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        Doctor.idCounter = idCounter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "Doctor [ID=" + id + ", Name=" + name + ", DOB=" + dateOfBirth + ", Specialization=" + specialization
                + ", Availability=" + availability + ", Email=" + email + ", Mobile=" + mobile + "]";
    }
}
