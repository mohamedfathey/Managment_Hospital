package com.hospital.Controller;

import com.hospital.Entity.Department;
import com.hospital.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService ;

    @GetMapping("/allData")
    public List<Department> findAllDAta(){
        return departmentService.findAllDAta();
    }
    @GetMapping("/findBy/{id}")
    public Department findById(@PathVariable Long  id){
        return departmentService.findById(id);
    }

    @PostMapping("addNewDep")
    public Department addNewDepartment ( @RequestBody Department department){
        return  departmentService.addNewDepartment(department);
    }

}
