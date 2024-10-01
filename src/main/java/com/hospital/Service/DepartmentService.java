package com.hospital.Service;

import com.hospital.Entity.Department;
import com.hospital.Repo.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepo departmentRepo ;

    public List<Department> findAllDAta(){
        return departmentRepo.findAll();
    }

    public Department findById(Long  id){
        return departmentRepo.findById(id).get();
    }

    public Department addNewDepartment (Department department){
        return  departmentRepo.save(department);
    }

}
