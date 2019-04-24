package com.jpm.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpm.springboot.entities.Employee;
import com.jpm.springboot.exception.EmployeeException;
import com.jpm.springboot.service.IEmployeeService;

@CrossOrigin(origins = "*" , allowedHeaders = "*")
@RestController
@RequestMapping("app/employees")
public class EmployeeController {

		@Autowired
		private IEmployeeService empService;

		@GetMapping(value="", produces="application/json")
		public List<Employee>  getAllEmployee() throws EmployeeException
		{
			return empService.getEmployeeList();
		}

//		//http://localhost:8082/api/employees/1
		@GetMapping("/{employeeId}")
		public ResponseEntity<Employee> getEmployeeById(@PathVariable(value="employeeId") Long employeeId) throws EmployeeException
		
		{
			System.out.println("EmployeeController - > find : "+ employeeId);
			Employee employee = empService.getEmployeeById(employeeId);
			return ResponseEntity.ok().body(employee);
					
		}
//		
		//http://localhost8082/api/employee/save
		@PostMapping("/save")
		public HttpStatus saveEmployees(@RequestBody Employee employee) throws EmployeeException 
		{
		return empService.addEmployee(employee) !=null ?
				HttpStatus.CREATED :HttpStatus.BAD_REQUEST;
		}
		
		//http://localhost:8082/api/employees/10
		@PutMapping("/{employeeId}")
		public HttpStatus updateEmployee(@PathVariable(value="employeeId") Long employeeId ,@Valid @RequestBody Employee employeeDetails) throws EmployeeException
		{
			Employee employee = empService.getEmployeeById(employeeId);
				if(employee==null)
					return HttpStatus.BAD_REQUEST;
				else
				{
					employee.setAge(40);
				//	employee.setSalary(employeeDetails.getSalary());
					return empService.updateEmployee(employee)? HttpStatus.ACCEPTED :HttpStatus.BAD_REQUEST;
				}
		}
		
//		@DeleteMapping("/{employeeId}")
//		public Map<String,Boolean> deleteEmployee(@PathVariable(value="employeeId") Long employeeId) throws EmployeeException
//		{
//			Employee employee = empService.getEmployeeById(employeeId);
//			Map<String,Boolean> response = new HashMap<> ();
//			if (employee !=null)
//			{
//				empService.deleteEmployeeById(employeeId);
//				response.put("deleted",Boolean.TRUE);
//			}
//			return response;
//		}
		
		
		
		
}
	