package com.hospital.Repo;

import com.hospital.Entity.Department;
import com.hospital.Entity.Doctor;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface DoctorRepo extends JpaRepository<Doctor,Long> {


    @Query("SELECT d FROM Doctor d WHERE d.department.depName = :depName")
    List<Doctor> findDoctorsByDepartmentName(@Param("depName") String departmentName);
    void   deleteById(Long id);

    @Override
    @EntityGraph(attributePaths = {"patients"} )
    Optional<Doctor> findById(Long aLong);

    @Override
    @EntityGraph(attributePaths = {"patients"})
    List<Doctor> findAll();



    Optional<Doctor> findByDoctorEmail(String email);


}
