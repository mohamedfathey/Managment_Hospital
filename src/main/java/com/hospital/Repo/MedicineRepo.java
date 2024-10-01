package com.hospital.Repo;

import com.hospital.Entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository

public interface MedicineRepo extends JpaRepository<Medicine,Long> {
    @Query("SELECT m FROM Medicine m WHERE m.medicineName = :medicineName")
    Medicine findByName(@Param("medicineName") String medicineName);

    @Query("SELECT m FROM Medicine m WHERE m.medicineActiveIngredient = :medicineActiveIngredient")
    Medicine findByActiveIngredient(@Param("medicineActiveIngredient") String medicineActiveIngredient);

//    Medicine findByName(String name);
//    Medicine findByActiveIngredient(String activeIngredient);
    void deleteById(Long id);
}
