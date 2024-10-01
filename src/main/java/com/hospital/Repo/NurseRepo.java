package com.hospital.Repo;

import com.hospital.Entity.Doctor;
import com.hospital.Entity.Nurse;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface NurseRepo extends JpaRepository<Nurse,Long> {


    @Query("SELECT d FROM Nurse d WHERE d.department.depName = :depName")
    List<Nurse> findNursesByDepartmentName(@Param("depName") String departmentName);
    void  deleteById(Long id);


    @Override
    @EntityGraph(attributePaths = {"department","patients"} )
    Optional<Nurse> findById(Long aLong);

    @Override
    @EntityGraph(attributePaths = {"department","patients"})
    List<Nurse> findAll();


    Optional<Nurse> findByNurseEmail(String email);

}
