package in.scalive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.scalive.entity.Emp;
import in.scalive.exception.EmpAlreadyExistsException;
import in.scalive.exception.NoSuchEmpExistsException;
import in.scalive.repository.EmpRepository;

@Service
public class EmpService {

	private EmpRepository empRepo;

	@Autowired
	public EmpService(EmpRepository empRepo) {
		this.empRepo = empRepo;
	}

	public String addEmp(Emp emp) {
		Emp e = empRepo.findByEname(emp.getEname()).orElse(null);
		if (e != null) {
			throw new EmpAlreadyExistsException("Employee already exist with this name: " + e.getEname());
		}
		empRepo.save(emp);
		return "new Emp saved successfully ! :-)";
	}

	public Emp getEmp(Integer empId) {
		Emp e = empRepo.findById(empId).orElse(null);
		if (e == null) {
			throw new NoSuchEmpExistsException("Emp not exist with this id: " + empId);
		}
		return e;
	}

	public String updateEmp(Emp emp, Integer empId) {
		Emp e = empRepo.findById(empId).orElse(null);
		if (e == null) {
			throw new NoSuchEmpExistsException("Emp not exist with this id: " + empId);
		}
		e.setEname(emp.getEname());
		e.setSal(emp.getSal());
		empRepo.save(e);
		return "Emp saved successfully ! :-) ";
	}

}
