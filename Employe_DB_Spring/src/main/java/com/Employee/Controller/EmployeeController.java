package com.Employee.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Employee.Bean.Employee;
import com.Employee.Repository.EmployeeRepository;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository repository;
	
	@PostMapping("/create")
	public String createEmployee(@RequestBody Employee employee) {
		if(!(employee.getAge() >= 20 && employee.getAge() <= 60)) {
			return "Invalid age...";
		}
		repository.save(employee);
		return "Employee Details Saved Successfully";
	}
	
	/*
	 * System.out.print("Designation List: \n"
					+ "1.Programmer\n"
					+ "2.Manager\n"
					+ "3.Tester\n"
					+ "Enter Designation: ");
			int des = sc.nextInt();
			switch(des) {
			case 1:
				salary = 20000;
				designation = "Programmer";
				status = false;
				break;
			case 2:
				salary = 25000;
				designation = "Manager";
				status = false;
				break;
			case 3:
				salary = 15000;
				designation = "Tester";
				status = false;
				break;
			default:
				System.out.println("Enter the valid number:");
				break;
			}
	 */
	
	@GetMapping("/list")
	public List<Employee> fetchAllEmployee(){
		return repository.findAll();
	}
	
	@PutMapping("/{empId}/{hike}")
	public String riseSalary(@PathVariable int empId,@PathVariable int hike) {
		Optional<Employee> byId = repository.findById(empId);
		if(byId.isEmpty()) {
			return empId + " data not found / Please try again later";
		}
		else if(!(hike > 0 && hike <= 10)) {
			return "Salary increment should be 1% to 10%";
		}

		double salary = (byId.get().getSalary() + (byId.get().getSalary() * (hike/100.0)));
		byId.get().setSalary(salary);
		System.out.println("Salary " +  (hike/100.0));
		repository.save(byId.get());
		return empId+" Salary incremented Successfully by " + hike + "%";
	}
	
	
}
