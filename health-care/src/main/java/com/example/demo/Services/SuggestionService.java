package com.example.demo.Services;


import com.example.demo.Entity.*;
import com.example.demo.Mapper.SymptomToSpecialityMapper;
import com.example.demo.Repository.DoctorRepository;
import com.example.demo.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuggestionService {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientService patientService;

    public List<Doctor> suggestDoctors(Long patientId) {
        Patient patient = patientService.getPatientById(patientId);
        Speciality speciality = SymptomToSpecialityMapper.getSpeciality(patient.getSymptom());

        if (speciality == null) {
            throw new RuntimeException("Invalid symptom");
        }

        try {
            City city = City.valueOf(patient.getCity().toUpperCase());
            List<Doctor> doctors = doctorService.getDoctorsByCityAndSpeciality(city, speciality);

            if (doctors.isEmpty()) {
                throw new RuntimeException("There isn’t any doctor present at your location for your symptom");
            }

            return doctors;

        } catch (IllegalArgumentException e) {
            throw new RuntimeException("We are still waiting to expand to your location");
        }
    }
}


