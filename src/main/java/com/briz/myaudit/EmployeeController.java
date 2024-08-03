package com.briz.myaudit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class EmployeeController 
{
@Autowired
EmployeeRepository erepo;
@RequestMapping("/test")
public String test()
{
	return "this is test";
}
@RequestMapping("/save")
public Employee save(@RequestBody Employee employee)
{
	return erepo.save(employee);
	
}
@RequestMapping("/upd/{id}")// during the update only update time is changed 
public Employee upd(@RequestBody Employee employee,@PathVariable int id)
{
Employee e=erepo.findById(id).get();
e.setCity(employee.getCity());
e.setName(employee.getName());
erepo.save(e);
return e;
}
@RequestMapping("/all")
public List<Employee> alldata()
{
	return erepo.findAll();
}
}
