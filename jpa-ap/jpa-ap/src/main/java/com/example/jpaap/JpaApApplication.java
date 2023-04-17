package com.example.jpaap;


import com.example.jpaap.entities.Patient;
import com.example.jpaap.repositories.PatientRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class JpaApApplication implements CommandLineRunner {
    @Autowired
    private PatientRepository PatientRepository ;


    public static void main(String[] args) {

        SpringApplication.run(JpaApApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        for(int i = 0; i<100 ; i++) {
             PatientRepository.save(

                    new Patient(null, "basma", new Date(), Math.random() > 0.5 ? true : false, (int) (Math.random() * 100)));
        }

         PatientRepository.save(new Patient(1L, "basma", new Date(), false, 50));


         PatientRepository.save(new Patient(2L, "salma", new Date(), false, 50));

         PatientRepository.save(new Patient(3L, "aya", new Date(), false, 50));

        List<Patient> patientList;
        patientList =  PatientRepository.findAll();
        patientList.forEach(p -> {
            System.out.println("====================");
            System.out.println(p.getId());
            System.out.println(p.getNom());
            System.out.println(p.getScore());
            System.out.println(p.getDatedenaisaance());
            System.out.println(p.isMalade());

        });
        System.out.println("***********************");
        Patient patient =  PatientRepository.findById(1L).orElse(null);
        if (patient != null) {
            System.out.println(patient.getNom());
            System.out.println(patient.isMalade());
        }
        patient.setScore(155);
         PatientRepository.save(patient);

    }}




