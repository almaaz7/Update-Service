package com.almaaz.updateservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.almaaz.updateservice.model.Employee;



@FeignClient("INSERT-SERVICE")
public interface UpdateFeign {
	@PostMapping("insert/addEmployee")
	public ResponseEntity<String> insertEmployee(@RequestBody Employee employee);
}
