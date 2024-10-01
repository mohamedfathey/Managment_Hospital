package com.hospital.Controller;

import com.hospital.Entity.Department;
import com.hospital.Entity.Doctor;
import com.hospital.Entity.Nurse;
import com.hospital.Entity.Patient;
import com.hospital.Repo.DepartmentRepo;
import com.hospital.Repo.DoctorRepo;
import com.hospital.Repo.NurseRepo;
import com.hospital.Repo.PatientRepo;
import com.hospital.Service.DepartmentService;
import com.hospital.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("patient")
public class PatientController {

    @Autowired
    private PatientService patientService;
    @Autowired
    private DepartmentRepo departmentRepo ;
    @Autowired
    private DoctorRepo doctorRepo ;

    @Autowired
    private PatientRepo patientRepo ;
    @Autowired
    private NurseRepo nurseRepo;


    @PostMapping("/addNewPatient")
    public Patient AddNewPatient(@RequestBody Patient patient){
        return patientService.AddNewPatient(patient);
    }

    @PutMapping("/updatePatient")
    public Patient update(@RequestBody Patient patient){
        return patientService.update(patient);
    }

    @GetMapping("findPatientBy/{id}")
    public Patient findPatientById (@PathVariable  Long id ){
        return  patientService.findPatientById(id);
    }
    @GetMapping("findAllPatient")
    public List<Patient> findAllPatient(){
        return patientService.findAllPatient();
    }

    @DeleteMapping("deleteBy/{id}")
    public void deleteByID(@PathVariable  Long id){
        patientService.deleteByID(id);
    }

    @PutMapping("/{patientId}/department/{depId}")
    public Patient enrollPatientToDepartment(
            @PathVariable long patientId ,
            @PathVariable long depId
    ) {
        Patient patient = patientRepo.findById(patientId).get();
        Department department = departmentRepo.findById(depId).get();

        patient.enrollPatent(department);
        return patientRepo.save(patient);

    }

    @PutMapping("/{patientId}/doctor/{docId}")
    public Patient RelationBetweenPatientAndDoctor(
            @PathVariable long patientId ,
            @PathVariable long docId
    ) {
        Patient patient = patientRepo.findById(patientId).get();
        Doctor doctor = doctorRepo.findById(docId).get();

        patient.doctorAndPatient(doctor);
        return patientRepo.save(patient);

    }

    @PutMapping("/{patientId}/nurse/{nurseId}")
    public Patient RelationBetweenPatientAndNurse(
            @PathVariable long patientId ,
            @PathVariable long nurseId
    ) {
        Patient patient = patientRepo.findById(patientId).get();
        Nurse nurse = nurseRepo.findById(nurseId).get();

        patient.nurseAndPatient(nurse);
        return patientRepo.save(patient);

    }

    @GetMapping("/name/{patientName}")
    public List<Map<String, String>> getPatientRelations(@PathVariable String patientName) {
        // جلب البيانات من قاعدة البيانات
        List<Object[]> relations = patientService.getPatientRelationsByPatientName(patientName);

        // تشكيل الاستجابة
        List<Map<String, String>> result = new ArrayList<>();

        for (Object[] relation : relations) {
            Map<String, String> map = new HashMap<>();

            // إضافة البيانات إلى الخريطة
            map.put("PatientName", (String) relation[0]);       // اسم المريض
            map.put("DepartmentName", (String) relation[1]);    // اسم القسم
            map.put("DoctorName", (String) relation[2]);        // اسم الدكتور
            map.put("NurseName", (String) relation[3]);         // اسم الممرض

            result.add(map);
        }

        return result;  // إرجاع النتيجة على شكل JSON
    }

}

