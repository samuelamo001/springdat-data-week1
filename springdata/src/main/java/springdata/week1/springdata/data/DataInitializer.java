/*
package springdata.week1.springdata.data;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springdata.week1.springdata.entities.*;
import springdata.week1.springdata.repository.*;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(
            DepartmentRepository departmentRepository,
            DoctorRepository doctorRepository,
            NurseRepository nurseRepository,
            PatientRepository patientRepository,
            WardRepository wardRepository
    ) {

        return args -> {

            // Create sample doctors
            List<Doctor> doctors = new ArrayList<>();
            for (int i = 1; i <= 10; i++) {
                Doctor doctor = new Doctor();
                doctor.setFirstName("DoctorFirstName" + i);
                doctor.setSurname("DoctorLastName" + i);
                doctor.setSpeciality("Speciality" + i);
                doctor.setAddress("Address" + i);
                doctor.setTelephoneNumber("123-456-789" + i);
                doctors.add(doctor);
            }
            doctorRepository.saveAll(doctors);

            // Create sample departments
            List<Department> departments = new ArrayList<>();
            for (int i = 1; i <= 10; i++) {
                Department department = new Department();
                department.setName("DepartmentName" + i);
                department.setCode("DPT" + i);
                department.setBuilding("Building" + i);
                department.setDirector(doctors.get(i - 1)); // Assign each department a doctor as director
                departments.add(department);
            }
            departmentRepository.saveAll(departments);

            // Create sample wards
            List<Ward> wards = new ArrayList<>();
            for (int i = 1; i <= 10; i++) {
                Ward ward = new Ward();
                ward.setNumber("Ward" + i);
                ward.setNumberOfBeds(20 + i);
                ward.setDepartment(departments.get(i - 1));
                wards.add(ward);
            }
            wardRepository.saveAll(wards);

            // Create sample nurses
            List<Nurse> nurses = new ArrayList<>();
            for (int i = 1; i <= 10; i++) {
                Nurse nurse = new Nurse();
                nurse.setFirstName("NurseFirstName" + i);
                nurse.setSurname("NurseLastName" + i);
                nurse.setAddress("Address" + i);
                nurse.setTelephoneNumber("789-456-123" + i);
                nurse.setRotation("Rotation" + i);
                nurse.setSalary(50000.0 + i * 1000);
                nurse.setDepartment(departments.get(i - 1));
                nurses.add(nurse);
            }
            nurseRepository.saveAll(nurses);

            // Assign nurses as supervisors of wards
            for (int i = 0; i < 10; i++) {
                wards.get(i).setSupervisor(nurses.get(i));
            }
            wardRepository.saveAll(wards);

            // Create sample patients
            List<Patient> patients = new ArrayList<>();
            for (int i = 1; i <= 10; i++) {
                Patient patient = new Patient();
                patient.setName("PatientName" + i);
                patient.setSurname("PatientLastName" + i);
                patient.setAddress("PatientAddress" + i);
                patient.setTelephone("456-789-123" + i);
                patient.setDiagnosis("Diagnosis" + i);
                patient.setBedNumber(i);
                patient.setWard(wards.get(i - 1));
                patient.setTreatingDoctor(doctors.get(i - 1));
                patients.add(patient);
            }
            patientRepository.saveAll(patients);


        };
    }
}
*/
