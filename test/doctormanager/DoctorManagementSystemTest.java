/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctormanager;

import doctormanager.Doctor;
import doctormanager.DoctorManagementSystem;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DoctorManagementSystemTest {
    private DoctorManagementSystem system;

    @Before
    public void setUp() {
        system = new DoctorManagementSystem();
    }

    @Test
    public void testAddDoctor() {
        Doctor doctor = new Doctor("John Doe", "01/01/1980", "Cardiology", 1, "johndoe@example.com", "(123)-456-7890");
        system.addDoctor(doctor);

        assertEquals(1, system.getDoctors().size());
        assertEquals("John Doe", system.getDoctors().get(0).getName());
    }

    @Test
    public void testEditDoctor() {
        Doctor doctor = new Doctor("Jane Doe", "02/02/1985", "Neurology", 2, "janedoe@example.com", "(987)-654-3210");
        system.addDoctor(doctor);

        system.editDoctor(1, "Jane Smith", "03/03/1985", "Dermatology", 1, "janesmith@example.com", "(111)-222-3333");

        Doctor editedDoctor = system.getDoctors().get(0);
        assertEquals("Jane Smith", editedDoctor.getName());
        assertEquals("Dermatology", editedDoctor.getSpecialization());
        assertEquals("(111)-222-3333", editedDoctor.getMobile());
    }

    @Test
    public void testDeleteDoctor() {
        Doctor doctor = new Doctor("Mark", "12/12/1970", "Radiology", 1, "mark@example.com", "(444)-555-6666");
        system.addDoctor(doctor);

        system.deleteDoctor(1);
        assertTrue(system.getDoctors().isEmpty());
    }

    @Test
    public void testSearchDoctorById() {
        Doctor doctor = new Doctor("Sarah", "05/05/1990", "Oncology", 1, "sarah@example.com", "(777)-888-9999");
        system.addDoctor(doctor);

        Doctor foundDoctor = system.searchDoctorById(1);
        assertNotNull(foundDoctor);
        assertEquals("Sarah", foundDoctor.getName());
    }

    @Test
    public void testSortDoctorsByDOB() {
        Doctor doc1 = new Doctor("Alice", "10/10/1980", "Cardiology", 1, "alice@example.com", "(111)-111-1111");
        Doctor doc2 = new Doctor("Bob", "05/05/1975", "Orthopedics", 1, "bob@example.com", "(222)-222-2222");
        system.addDoctor(doc1);
        system.addDoctor(doc2);

        system.sortDoctorsByDOB();

        assertEquals("Bob", system.getDoctors().get(0).getName());
        assertEquals("Alice", system.getDoctors().get(1).getName());
    }
}
