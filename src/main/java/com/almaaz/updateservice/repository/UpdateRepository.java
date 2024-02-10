package com.almaaz.updateservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.almaaz.updateservice.model.Employee;

@Repository
public interface UpdateRepository extends CrudRepository<Employee, Integer>{

}
