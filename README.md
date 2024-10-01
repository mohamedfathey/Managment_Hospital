# Hospital Management System

This project is a **Spring Data JDBC** application for managing a hospital, including doctors, nurses, patients, departments, and medicine. The system handles basic CRUD operations for each entity with a relational database structure.

## Table of Contents
- [Entities](#entities)
- [Relationships](#relationships)
- [API Endpoints](#api-endpoints)
- [Global Exception Handling](#global-exception-handling)
- [How to Run](#how-to-run)
- [Technologies Used](#technologies-used)

## Entities

### 1. Doctor
- **Fields:**
  - `doctorId` (Primary Key)
  - `doctorName`
  - `specialization`
  - `yearsOfExperience`
- **Relationship:**
  - One doctor belongs to one department.
  - One department can have many doctors.
  
### 2. Nurse
- **Fields:**
  - `nurseId` (Primary Key)
  - `nurseName`
  - `nurseField`
  - `yearsOfExperience`
- **Relationship:**
  - One nurse belongs to one department.
  - One department can have many nurses.

### 3. Patient
- **Fields:**
  - `patientId` (Primary Key)
  - `patientName`
  - `caseHistory`
  - `contactInformation`
- **Relationship:**
  - Many patients can be associated with both doctors and nurses.
  
### 4. Department
- **Fields:**
  - `departmentId` (Primary Key)
  - `departmentName`
- **Relationship:**
  - One department has many doctors and nurses.

### 5. Medicine
- **Fields:**
  - `medicineId` (Primary Key)
  - `medicineName`
  - `medicineType`
  - `medicineAdministration`

## Relationships
- **Doctor-Department:** One-to-Many relationship (One department can have many doctors).
- **Nurse-Department:** One-to-Many relationship (One department can have many nurses).
- **Doctor-Patient:** Many-to-Many relationship (One doctor can treat many patients and vice versa).
- **Nurse-Patient:** Many-to-Many relationship (One nurse can attend to many patients and vice versa).

## API Endpoints

### Doctor Endpoints:
- `POST /doctors`: Add a new doctor.
- `PUT /doctors/{id}`: Update an existing doctor.
- `GET /doctors/{id}`: Find a doctor by ID.
- `DELETE /doctors/{id}`: Delete a doctor by ID.
- `GET /doctors?name={doctorName}`: Get department by doctor name.

### Nurse Endpoints:
- `POST /nurses`: Add a new nurse.
- `PUT /nurses/{id}`: Update an existing nurse.
- `GET /nurses/{id}`: Find a nurse by ID.
- `DELETE /nurses/{id}`: Delete a nurse by ID.
- `GET /nurses?name={nurseName}`: Get department by nurse name.

### Patient Endpoints:
- `POST /patients`: Add a new patient.
- `PUT /patients/{id}`: Update an existing patient.
- `GET /patients/{id}`: Find a patient by ID.
- `DELETE /patients/{id}`: Delete a patient by ID.
- `POST /relations/patient/doctor`: Add a relation between a doctor and a patient.
- `POST /relations/patient/nurse`: Add a relation between a nurse and a patient.

## Global Exception Handling
The system has centralized exception handling with a global exception handler. Exceptions handled include:
- `ResourceNotFoundException`: Thrown when a resource (e.g., doctor, nurse, patient) is not found.
- `DuplicateRecordException`: Thrown when attempting to add a record that already exists.

## How to Run

1. **Clone the repository:**
   ```bash
   git clone <https://github.com/mohamedfathey/Managment_Hospital.git>
    cd Managment_Hospital

### Technologies Used
`Java 11`

`Spring Boot`

`Spring Data JPA`

`Mysql DataBase`

`Maven`


