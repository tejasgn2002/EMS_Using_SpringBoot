package com.Employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Employee.Bean.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
