//package com.hospital.Config;
//
//import com.hospital.Entity.Department;
//import com.hospital.Entity.Doctor;
//import com.hospital.Entity.Nurse;
//import com.hospital.Entity.Patient;
//import com.hospital.Service.DepartmentService;
//import com.hospital.Service.DoctorService;
//import com.hospital.Service.NurseService;
//import com.hospital.Service.PatientService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.Collections;
//@Component
//public class insertConfig implements CommandLineRunner {
//
//    @Autowired
//    private DoctorService doctorService;
//    @Autowired
//    private NurseService nurseService;
//    @Autowired
//    private DepartmentService departmentService;
//    @Autowired
//    private PatientService patientService;
//
//    @Override
//    public void run(String... args) throws Exception {
////        Department department11 = departmentService.findById(1L);
////        Department department2 = departmentService.findById(2L);
//
//        // Creating and saving Doctor 1
//        Doctor doctor = new Doctor();
//        doctor.setDoctorName("mhmd");
//        doctor.setDoctorPassword("mhmd");
//        doctor.setDoctorEmail("mhmd@gmail.com");
//        doctor.setYearsOfExperience("5");
//        doctor.setDepartment(departmentService.findById(1L));  // Assuming department with id 1 exists
//        doctorService.addNewDoctor(doctor);  // Persist doctor to the database
//
//        // Creating and saving Doctor 2
//        Doctor doctor2 = new Doctor();
//        doctor2.setDoctorName("doctor2");
//        doctor2.setDoctorPassword("doctor2");
//        doctor2.setDoctorEmail("doctor2@gmail.com");
//        doctor2.setYearsOfExperience("10");
//        doctor2.setDepartment(departmentService.findById(2L));  // Assuming department with id 2 exists
//        doctorService.addNewDoctor(doctor2);  // Persist doctor to the database
//
//        // Creating and saving Nurse 1
//        Nurse nurse = new Nurse();
//        nurse.setNurseName("mhmd");
//        nurse.setNurseEmail("mhmd@gmail.com");
//        nurse.setNursePassword("mhmd");
//        nurse.setYearsOfExperience("5");
//        nurse.setDepartment(departmentService.findById(1L));  // Assuming department with id 1 exists
//        nurseService.addNewNurse(nurse);  // Persist nurse to the database
//
//        // Creating and saving Nurse 2
//        Nurse nurse2 = new Nurse();
//        nurse2.setNurseName("nurse2");
//        nurse2.setNurseEmail("nurse2@gmail.com");
//        nurse2.setNursePassword("nurse2");
//        nurse2.setYearsOfExperience("10");
//        nurse2.setDepartment(departmentService.findById(2L));  // Assuming department with id 2 exists
//        nurseService.addNewNurse(nurse2);  // Persist nurse to the database
//
//        // Creating and saving Department
//        Department department = new Department();
//        department.setDepName("mok");
//        departmentService.addNewDepartment(department);// Save the department first
//
//        Department department1 = new Department();
//        department1.setDepName("lko");
//        departmentService.addNewDepartment(department1);
//
//
//
//        // Creating and saving Patient
//        Patient patient = new Patient();
//        patient.setPatientName("mhmd");
//        patient.setPatientNationalId(123456789);
//        patient.setCauseOfIllness("mookok");
//        patient.setArrivalDate("2020-8-5");
//        patient.setEnrolledPatient(Collections.singleton(department));  // Associate patient with the newly created department
//        patientService.AddNewPatient(patient);  // Persist patient to the database
//    }
//    }
//
