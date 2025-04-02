package com.empmangtsys.repo.privateApis;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.empmangtsys.model.AddEmployee;

@Repository
public interface AddEmployeeRepo extends JpaRepository<AddEmployee, Integer>{

	AddEmployee save(AddEmployee addEmployee);

	List<AddEmployee> findAll();

	@Query("SELECT SUM(salary) FROM AddEmployee ")
	BigDecimal getTotalSalary();
}
