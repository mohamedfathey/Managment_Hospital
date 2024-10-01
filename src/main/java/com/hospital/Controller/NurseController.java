package com.hospital.Controller;

import com.hospital.Entity.Nurse;
import com.hospital.Service.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/nurse")
public class NurseController {


    @Autowired
    private NurseService nurseService;

    //////// function or Method //////////////
    @PostMapping("/newNurse")
    public Nurse addNewDoctor (@RequestBody Nurse nurse){
    return nurseService.addNewNurse(nurse);
}

    @GetMapping("/{id}")
    public Nurse findById (@PathVariable long id){
    return nurseService.findById(id);
}


    @GetMapping("/allNurse")
    public List<Nurse> findAllDoctor(){
    return nurseService.findAllDoctor();
}

    @PutMapping("/update")
    public Nurse update (@RequestBody Nurse nurse){
    return nurseService.update(nurse);
}

    @DeleteMapping("/{id}")
    public void deleteByID (@PathVariable long id)
    {
        nurseService.delete(id);
    }

    @GetMapping("/getBy/{departmentName}")
    public List<String> getNursesByDepartment(@PathVariable String departmentName) {
        return nurseService.getNurseNamesByDepartment(departmentName);
    }
}
