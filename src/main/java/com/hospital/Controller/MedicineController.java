package com.hospital.Controller;

import com.hospital.Entity.Medicine;
import com.hospital.Service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicine")
public class MedicineController {
    @Autowired
    private MedicineService medicineService;

    @PostMapping("/addNewMedicine")
    public Medicine addNewMedicine (@RequestBody Medicine medicine){
        return medicineService.addNewMedicine(medicine);
    }

    @PutMapping("/updateMedicine")
    public Medicine updateMedicine (@RequestBody Medicine medicine){
        return medicineService.updateMedicine(medicine);
    }


    @GetMapping("/medicine/byName/{medicineName}")
    public Medicine findByName(@PathVariable String medicineName) {
        return medicineService.findByName(medicineName);
    }

    @GetMapping("/medicine/byActiveIngredient/{medicineActiveIngredient}")
    public Medicine findByActiveIngredient(@PathVariable String medicineActiveIngredient) {
        return medicineService.findByActiveIngredient(medicineActiveIngredient);
    }


    @GetMapping("/findAllMedicine")
    public List<Medicine> findAllMedicine (){
        return medicineService.findAllMedicine();
    }
    @DeleteMapping("/deleteThe/{id}")
    public void deleteById (@PathVariable long id){
        medicineService.deleteById(id);
    }

}
