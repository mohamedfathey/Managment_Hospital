package com.hospital.Repo;

import com.hospital.Entity.Department;
import com.hospital.Entity.Patient;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PatientRepo extends JpaRepository<Patient,Long> {
    void deleteById(Long id) ;

    @Query("SELECT p.PatientName, d.depName, doc.doctorName, n.nurseName " +
            "FROM Patient p " +
            "JOIN p.enrolledPatient d " +
            "JOIN p.doctorRelationPatient doc " +
            "JOIN p.nurseRelationPatient n " +
            "WHERE p.PatientName = :patientName")
    List<Object[]> findPatientRelationsByPatientName(@Param("patientName") String patientName);

}
