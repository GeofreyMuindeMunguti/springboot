package com.ics.demo;

import com.ics.demo.models.Student;
import com.ics.demo.models.University;
import com.ics.demo.repositories.StudentRepository;
import com.ics.demo.repositories.UniversityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DummyData implements CommandLineRunner {
    private final UniversityRepository universityRepository;
    private final StudentRepository studentRepository;

    public DummyData(UniversityRepository universityRepository, StudentRepository studentRepository) {

        this.universityRepository = universityRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        University strath = new University("Strathmore", "Ole sangale");
        universityRepository.save(strath);

        University jkuat = new University("Jkuat", "Thika Road");
        universityRepository.save(jkuat);

        Student geo = new Student("Muinde","Geofrey", "Munguti","12 August");
        studentRepository.save(geo);

        Student brian = new Student("Mutinda","Brian", "Muema","12 August");
        studentRepository.save(brian);


    }
}
