package com.lynas.controller;

import com.google.appengine.api.datastore.*;
import com.lynas.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@Controller
@RequestMapping(value = "/")
public class HomeController {


    @RequestMapping("")
    public String home(Map<String,Object> map) {
        DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
        Query query = new Query("employee");
        PreparedQuery preparedQuery = datastoreService.prepare(query);
        List<Employee> employeeList = new ArrayList<>();

        for (Entity entity : preparedQuery.asIterable()) {
            employeeList.add(
                    new Employee(
                            entity.getProperty("first_name").toString(),
                            entity.getProperty("last_name").toString()
                    )
            );
        }


        map.put("employeeList", employeeList);
        return "mainpage";
    }

    @RequestMapping("addEmployee")
    public String addEmployee(Map<String,Object> map, @RequestParam String firstName,@RequestParam String lastName) {
        DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
        UUID uniqueKey = UUID.randomUUID();
        Entity entity = new Entity("employee", "" + uniqueKey);
        entity.setProperty("first_name", firstName);
        entity.setProperty("last_name", lastName);

        datastoreService.put(entity);


        map.put("val1", "val1");
        return "redirect:/";
    }
}
