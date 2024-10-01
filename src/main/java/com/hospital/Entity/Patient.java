package com.hospital.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PatientID;

    private String PatientName;

    private double PatientNationalId;

    private String CauseOfIllness;
    private String arrivalDate;

    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "patient_enrolled",
            joinColumns = @JoinColumn(name = "PatientID"),
            inverseJoinColumns = @JoinColumn(name = "depID")
    )
    private Set<Department> enrolledPatient = new HashSet<>();

    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "Relation-Doctor-Patient",
            joinColumns = @JoinColumn(name = "PatientID"),
            inverseJoinColumns = @JoinColumn(name = "doctorId")
    )
    private Set<Doctor> doctorRelationPatient = new HashSet<>();

    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "Relation-Nurse-Patient",
            joinColumns = @JoinColumn(name = "PatientID"),
            inverseJoinColumns = @JoinColumn(name = "nurseId")
    )
    private Set<Nurse> nurseRelationPatient = new HashSet<>();

    public Set<Nurse> getNurseRelationPatient() {
        return nurseRelationPatient;
    }

    public void setNurseRelationPatient(Set<Nurse> nurseRelationPatient) {
        this.nurseRelationPatient = nurseRelationPatient;
    }

    public Set<Doctor> getDoctorRelationPatient() {
        return doctorRelationPatient;
    }

    public void setDoctorRelationPatient(Set<Doctor> doctorRelationPatient) {
        this.doctorRelationPatient = doctorRelationPatient;
    }

    public Long getPatientID() {
        return PatientID;
    }

    public void setPatientID(Long patientID) {
        PatientID = patientID;
    }

    public String getPatientName() {
        return PatientName;
    }

    public void setPatientName(String patientName) {
        PatientName = patientName;
    }

    public double getPatientNationalId() {
        return PatientNationalId;
    }

    public void setPatientNationalId(double patientNationalId) {
        PatientNationalId = patientNationalId;
    }

    public String getCauseOfIllness() {
        return CauseOfIllness;
    }

    public void setCauseOfIllness(String causeOfIllness) {
        CauseOfIllness = causeOfIllness;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Set<Department> getEnrolledPatient() {
        return enrolledPatient;
    }

    public void setEnrolledPatient(Set<Department> enrolledPatient) {
        this.enrolledPatient = enrolledPatient;
    }

    public void enrollPatent(Department department) {
        enrolledPatient.add(department);
    }

    public void doctorAndPatient(Doctor doctor){
        doctorRelationPatient.add(doctor);
    }
    public void nurseAndPatient(Nurse nurse){
        nurseRelationPatient.add(nurse);
    }
}