package com.example.demo.Mapper;

import com.example.demo.Entity.Speciality;

public class SymptomToSpecialityMapper {
    public static Speciality getSpeciality(String symptom) {
        return switch (symptom.toLowerCase()) {
            case "arthritis", "back pain", "tissue injuries" -> Speciality.ORTHOPAEDIC;
            case "dysmenorrhea" -> Speciality.GYNECOLOGY;
            case "skin infection", "skin burn" -> Speciality.DERMATOLOGY;
            case "ear pain" -> Speciality.ENT;
            default -> null;
        };
    }
}
