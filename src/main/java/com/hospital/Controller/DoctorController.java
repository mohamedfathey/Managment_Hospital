package com.hospital.Controller;

import com.hospital.Entity.Doctor;
import com.hospital.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    //////// function or Method //////////////
    @PostMapping("/newDoctor")
    public Doctor addNewDoctor (@RequestBody Doctor doctor){
        return doctorService.addNewDoctor(doctor);
    }

    @GetMapping("/{id}")
    public Doctor findById (@PathVariable long id){
        return doctorService.findById(id);
    }
    @GetMapping("/allDoctor")
    public List<Doctor> findAllDoctor(){
        return doctorService.findAllDoctor();
    }

    @PutMapping("/update")
    public Doctor update (@RequestBody Doctor doctor){
        return doctorService.update(doctor);
    }

    @DeleteMapping("/{id}")
    public void deleteByID (@PathVariable long id)
    {
         doctorService.delete(id);
    }


    @GetMapping("/getBy/{departmentName}")
    public List<String> getDoctorsByDepartment(@PathVariable String departmentName) {
        return doctorService.getDoctorNamesByDepartment(departmentName);
    }

}
