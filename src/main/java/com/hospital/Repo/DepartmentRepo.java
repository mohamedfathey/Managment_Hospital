package com.hospital.Repo;

import com.hospital.Entity.Department;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepo extends JpaRepository<Department,Long> {
    @Override
    @EntityGraph(attributePaths = {"patients"} )
    Optional<Department> findById(Long aLong);

    @Override
    @EntityGraph(attributePaths = {"patients"})
    List<Department> findAll();

}
