package com.jpm.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jpm.springboot.entities.Employee;
import com.jpm.springboot.exception.EmployeeException;

//prep-work 1 - @Repository EmployeeDao
@Repository
public class EmployeeDao implements IEmployeeDao {

	// Prep work 2 - annotate the entity manager
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Long addEmployee(Employee employee) throws EmployeeException {
		entityManager.persist(employee);
		return employee.getEmpId();
	}

	@Override
	public List<Employee> getEmployeeList() throws EmployeeException {
		Query qry = entityManager.createQuery("from Employee");
		List<Employee> empList = qry.getResultList();
		System.out.println(empList);
		return empList;
	}

	@Override
	public boolean updateEmployee(Employee employee) throws EmployeeException {

		return entityManager.merge(employee) != null;
	}

	@Override
	public boolean deleteEmployeeById(Long empId) throws EmployeeException {
		Employee emp = this.getEmployeeById(empId);
		if (emp == null)
			return false;
		else {
			entityManager.remove(emp); // Now it is detached object
			return true;
		}
	}

	@Override
	public Employee getEmployeeById(Long empId) throws EmployeeException {
		Employee emp = entityManager.find(Employee.class, empId);
		return emp;
	}

}
