package com.jfb.stproduct.feignclients;

import java.util.List;

import com.jfb.stproduct.dto.CategoryDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "st-category", path = "/categories")
public interface CategoryFeignClient {
  
  @GetMapping(value = "/{id}")
  ResponseEntity<List<CategoryDTO>> findById(@PathVariable("id") Long id);
}
