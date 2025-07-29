package com.pm.patientservice.mapper;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.model.Patient;

import java.time.LocalDate;

public class PatientMapper {


    public static PatientResponseDTO toDTO(Patient patient){
        PatientResponseDTO patientDTO=new PatientResponseDTO();
        patientDTO.setId(patient.getId().toString());
        patientDTO.setName(patient.getName());
        patientDTO.setAddress(patient.getAddress());
        patientDTO.setEmail(patient.getEmail());
        patientDTO.setDateOfBirth(patient.getDateOfBirth().toString());
        patientDTO.setRegisteredDate(patient.getRegisteredDate().toString()); // ✅ Add this

        return patientDTO;


    }
    public static Patient toModel(PatientRequestDTO dto) {
        Patient patient = new Patient();
        patient.setName(dto.getName());
        patient.setAddress(dto.getAddress());
        patient.setEmail(dto.getEmail());

        // Prevent crash if null or blank
        if (dto.getDateOfBirth() != null && !dto.getDateOfBirth().isBlank()) {
            patient.setDateOfBirth(LocalDate.parse(dto.getDateOfBirth()));
        } else {
            patient.setDateOfBirth(null);  // No crash
        }


        // ✅ Set registered date: use today's date if not provided
        if (dto.getRegisteredDate() == null || dto.getRegisteredDate().isBlank()) {
            patient.setRegisteredDate(LocalDate.now());
        } else {
            patient.setRegisteredDate(LocalDate.parse(dto.getRegisteredDate()));
        }

        return patient;
    }

}
