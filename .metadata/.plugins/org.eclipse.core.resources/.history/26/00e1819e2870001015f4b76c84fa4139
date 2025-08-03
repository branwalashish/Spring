package in.scalive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.scalive.entity.Emp;
import in.scalive.service.EmpService;

@RestController
@RequestMapping("/api/emp")
public class EmpController {

	private EmpService service;

	@Autowired
	public EmpController(EmpService service) {
		this.service = service;
	}

	@PostMapping("/add")
	public String addEmp(@RequestBody Emp emp) {
		return service.addEmp(emp);
	}

	@GetMapping("/{empId}")
	public Emp getEmp(@PathVariable("empId") Integer empId) {
		return service.getEmp(empId);
	}

	@PutMapping("/update/{empId}")
	public String updateEmp(@RequestBody Emp emp, @PathVariable("empId") Integer empId) {
		return service.updateEmp(emp, empId);
	}
}
