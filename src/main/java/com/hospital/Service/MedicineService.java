package com.hospital.Service;

import com.hospital.Entity.Medicine;
import com.hospital.Repo.MedicineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineService {
    @Autowired
    private MedicineRepo medicineRepo ;

    public Medicine addNewMedicine (Medicine medicine){
        return medicineRepo.save(medicine);
    }

    public Medicine updateMedicine (Medicine medicine){

        Medicine current = medicineRepo.findById(medicine.getMedicineId()).get();
        current.setMedicineName(medicine.getMedicineName());
        current.setMedicineActiveIngredient(medicine.getMedicineActiveIngredient());
        current.setMedicinePrice(medicine.getMedicinePrice());
        current.setMedicineAlternative(medicine.getMedicineAlternative());
        return medicineRepo.save(medicine);
    }

    public Medicine findByName (String medicineName){
        return medicineRepo.findByName(medicineName);
    }

    public Medicine findByActiveIngredient(String medicineActiveIngredient) {
        return medicineRepo.findByActiveIngredient(medicineActiveIngredient);
    }

    public List<Medicine> findAllMedicine (){
        return medicineRepo.findAll();
    }

    public void deleteById (long id){
        medicineRepo.deleteById(id);
    }

}
