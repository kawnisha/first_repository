package com.jpm.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpm.springboot.dao.IEmployeeDao;
import com.jpm.springboot.entities.Employee;
import com.jpm.springboot.exception.EmployeeException;

@Service
public class EmployeeService implements IEmployeeService {
	
	@Autowired
	private IEmployeeDao employeeDao;

	@Override
	@Transactional
	public Long addEmployee(Employee employee) throws EmployeeException {
		// TODO Auto-generated method stub
		return employeeDao.addEmployee(employee);
	}

	@Override
	public List<Employee> getEmployeeList() throws EmployeeException {
		// TODO Auto-generated method stub
		
		return employeeDao.getEmployeeList();
	}

	@Override
	@Transactional
	public boolean updateEmployee(Employee employee) throws EmployeeException {
		// TODO Auto-generated method stub
		return employeeDao.updateEmployee(employee);
	}
//
//	@Override
//	@Transactional
//	public boolean deleteEmployeeById(Long empId) throws EmployeeException {
//		// TODO Auto-generated method stub
//		return employeeDao.deleteEmployeeById(empId);
//	}
//
	@Override
	public Employee getEmployeeById(Long empId) throws EmployeeException {
		Employee emp = employeeDao.getEmployeeById(empId);
		return emp;
	}

}
