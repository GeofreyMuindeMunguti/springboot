package com.ics.demo;

import com.ics.demo.models.Student;
import com.ics.demo.models.University;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class SampleClient implements CommandLineRunner {

    private final String url = "http://10.51.10.111:9090";


    @Override
    public void run(String... args) throws Exception {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<University>> response = restTemplate.exchange(
                url+"/universities",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<University>>(){}
        );
        List<University> universities = response.getBody();
        System.out.println("Universities:" +universities.toString());


        ResponseEntity<List<Student>> students = restTemplate.exchange(
                url+"/universities",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Student>>() {
                }
        );

        List<Student> stude = students.getBody();
        System.out.println("Students: "+stude.toString());

        University university = restTemplate.getForObject(
                url+"/universities/5",
                University.class
        );

        String uri = url+"/universities/search?name="+university.getName();
        University seached = restTemplate.getForObject(
                uri,
                University.class
        );
    }
}
