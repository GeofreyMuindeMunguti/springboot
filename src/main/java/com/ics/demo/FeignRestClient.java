package com.ics.demo;

import com.ics.demo.models.University;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="client", url = "http://10.51.10.111:9090")
public interface FeignRestClient {
    @RequestMapping(method = RequestMethod.GET, value = "universities")
    List<University> getAllUniversities();

    @RequestMapping(method = RequestMethod.GET, value = "universities/{id}")
    University findUniversityById(@PathVariable(name = "id")Long id);

    @RequestMapping(method = RequestMethod.POST, value = "universities")
    University createUniversity(@RequestBody University university);

    @RequestMapping(method =  RequestMethod.PATCH, value = "universities/{id}")
    University updateUniversity(@PathVariable(name = "id")Long id, @RequestBody University university);

    @RequestMapping(method = RequestMethod.GET, value = "universities/search")
    List<University> searchByName(@RequestParam(value = "name") String name);




}
