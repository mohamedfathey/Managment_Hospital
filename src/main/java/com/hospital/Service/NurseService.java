package com.hospital.Service;

import com.hospital.Entity.Doctor;
import com.hospital.Entity.Nurse;
import com.hospital.Error.DuplicateRecordException;
import com.hospital.Error.RecordNotFoundException;
import com.hospital.Repo.NurseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NurseService {
    @Autowired
    private NurseRepo nurseRepo;

    public Nurse addNewNurse(Nurse nurse) {
        if (nurse.getNurseEmail() != null && !nurse.getNurseEmail().trim().isEmpty()) {
            Optional<Nurse> nurse1 = findByEmail(nurse.getNurseEmail());
            if (nurse1.isPresent()) {
                throw new DuplicateRecordException("This email is already used!!");
            } else {
                return nurseRepo.save(nurse); // If email is not present, save the doctor
            }
        } else {
            throw new IllegalArgumentException("Email must not be empty or null");
        }
    }


    public Nurse findById (Long id){
        Optional<Nurse> entity=nurseRepo.findById(id);
        if (entity.isPresent()){
            return entity.get();
        }
        else {
            throw new RecordNotFoundException("this record with id : "+id + "not fount");
        }
    }
    public List<Nurse> findAllDoctor (){
        return nurseRepo.findAll();
    }

    public Nurse update (Nurse nurse){
        Nurse current = nurseRepo.findById(nurse.getNurseId()).get();
        current.setNurseName(nurse.getNurseName());
        current.setNurseEmail(nurse.getNurseEmail());
        current.setNursePassword(nurse.getNursePassword());
        current.setYearsOfExperience(nurse.getYearsOfExperience());
        return nurseRepo.save(current);
    }

    public void delete (Long id){
        nurseRepo.deleteById(id);
    }


    public List<String> getNurseNamesByDepartment(String departmentName) {
        List<Nurse> doctors = nurseRepo.findNursesByDepartmentName(departmentName);
        return doctors.stream()
                .map(Nurse::getNurseName)
                .collect(Collectors.toList());
    }

    private Optional<Nurse>findByEmail(String email){
        return nurseRepo.findByNurseEmail(email);
    }





}
