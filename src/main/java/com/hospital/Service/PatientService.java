package com.hospital.Service;

import com.hospital.Entity.Patient;
import com.hospital.Repo.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PatientService {
    @Autowired
    private PatientRepo patientRepo;

    public Patient AddNewPatient(Patient patient){
        return patientRepo.save(patient);
    }

    public Patient update(Patient patient){
        Patient current = patientRepo.findById(patient.getPatientID()).get();
        current.setPatientName(patient.getPatientName());
        current.setArrivalDate(patient.getArrivalDate());
        current.setCauseOfIllness(patient.getCauseOfIllness());
        current.setPatientNationalId(patient.getPatientNationalId());
        return patientRepo.save(current);
    }

    public Patient findPatientById (Long id ){
        return  patientRepo.findById(id).get();
    }
    public List<Patient> findAllPatient(){
        return patientRepo.findAll();
    }

    public void deleteByID(Long id){
         patientRepo.deleteById(id);
    }

    // باستخدام JPQL
    public List<Object[]> getPatientRelationsByPatientName(String patientName) {
        return patientRepo.findPatientRelationsByPatientName(patientName);
    }
}
