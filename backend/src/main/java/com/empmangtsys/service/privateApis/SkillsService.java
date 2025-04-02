package com.empmangtsys.service.privateApis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empmangtsys.model.EmployeeSkills;
import com.empmangtsys.repo.privateApis.EmpManagementSystemRepo;

@Service
public class SkillsService {

	@Autowired
	private EmpManagementSystemRepo empManagementSystemRepo;

	public EmployeeSkills addSkills(EmployeeSkills employeeSkills) {
		EmployeeSkills skills = new EmployeeSkills();
		skills.setEmpid(employeeSkills.getEmpid());
		skills.setSkills(employeeSkills.getSkills());
		  return empManagementSystemRepo.save(employeeSkills);
		}

	public List<EmployeeSkills> getEmployeeSkills() {
		return empManagementSystemRepo.findAll();
	}
}
