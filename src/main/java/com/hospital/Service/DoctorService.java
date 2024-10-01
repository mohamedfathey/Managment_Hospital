package com.hospital.Service;

import com.hospital.Entity.Department;
import com.hospital.Entity.Doctor;
import com.hospital.Error.DuplicateRecordException;
import com.hospital.Error.RecordNotFoundException;
import com.hospital.Repo.DepartmentRepo;
import com.hospital.Repo.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class DoctorService {
    @Autowired
    private DoctorRepo doctorRepo;
    @Autowired
    DepartmentRepo departmentRepo ;

    public Doctor addNewDoctor(Doctor doctor) {
        // التحقق من البريد الإلكتروني
        if (doctor.getDoctorEmail() != null && !doctor.getDoctorEmail().trim().isEmpty()) {
            Optional<Doctor> existingDoctor = findByEmail(doctor.getDoctorEmail());
            if (existingDoctor.isPresent()) {
                throw new DuplicateRecordException("This email is already used!!");
            }

            // التحقق من أن `Department` موجود في قاعدة البيانات
            if (doctor.getDepartment() != null) {

                Department department = departmentRepo.findById(doctor.getDepartment().getDepID())
                        .orElseThrow(() -> new IllegalArgumentException("Department not found!"));

                // ربط القسم بالطبيب
                doctor.setDepartment(department);
            } else {
                throw new IllegalArgumentException("Doctor must be assigned to a department");
            }

            // حفظ الطبيب مع القسم المرتبط به
            return doctorRepo.save(doctor);
        } else {
            throw new IllegalArgumentException("Email must not be empty or null");
        }
    }


    public Doctor findById (Long id){
        Optional<Doctor>entity=doctorRepo.findById(id);
        if (entity.isPresent()){
            return entity.get();
        }
        else {
            throw new RecordNotFoundException("this record with id : "+id + "not fount");
        }
    }

    public List<Doctor> findAllDoctor (){
        return doctorRepo.findAll();
    }

    public Doctor update (Doctor doctor){
        Doctor current = doctorRepo.findById(doctor.getDoctorId()).get();
        current.setDoctorName(doctor.getDoctorName());
        current.setDoctorEmail(doctor.getDoctorEmail());
        current.setDoctorPassword(doctor.getDoctorPassword());
        current.setYearsOfExperience(doctor.getYearsOfExperience());
        return doctorRepo.save(current);
    }

    public void delete (Long id){
         doctorRepo.deleteById(id);
    }


    public List<String> getDoctorNamesByDepartment(String departmentName) {
        List<Doctor> doctors = doctorRepo.findDoctorsByDepartmentName(departmentName);
        return doctors.stream()
                .map(Doctor::getDoctorName)
                .collect(Collectors.toList());
    }

    private Optional<Doctor>findByEmail(String email){
        return doctorRepo.findByDoctorEmail(email);
    }

}
