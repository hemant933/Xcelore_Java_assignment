package com.example.demo.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @Email
    private String email;

    @NotBlank
    @Size(min = 10)
    private String phone;

    @NotNull
    @Enumerated(EnumType.STRING)
    private City city;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Speciality speciality;

    // ✅ Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public City getCity() {
        return city;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    // ✅ Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }
}



