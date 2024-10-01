package com.hospital.Entity;

import jakarta.persistence.*;

@Entity
@Table()
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long medicineId ;
    private String medicineName;
    private String medicineActiveIngredient ;
    private double medicinePrice ;
    private String medicineAlternative ;

    public long getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(long medicineId) {
        this.medicineId = medicineId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getMedicineActiveIngredient() {
        return medicineActiveIngredient;
    }

    public void setMedicineActiveIngredient(String medicineActiveIngredient) {
        this.medicineActiveIngredient = medicineActiveIngredient;
    }

    public double getMedicinePrice() {
        return medicinePrice;
    }

    public void setMedicinePrice(double medicinePrice) {
        this.medicinePrice = medicinePrice;
    }

    public String getMedicineAlternative() {
        return medicineAlternative;
    }

    public void setMedicineAlternative(String medicineAlternative) {
        this.medicineAlternative = medicineAlternative;
    }
}
