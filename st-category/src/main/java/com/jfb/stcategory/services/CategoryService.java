package com.jfb.stcategory.services;

import java.util.Optional;

import com.jfb.stcategory.dto.CategoryDTO;
import com.jfb.stcategory.entities.Category;
import com.jfb.stcategory.repositories.CategoryRepository;
import com.jfb.stcategory.services.exceptions.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryService {

  @Autowired
  private CategoryRepository repository;

  @Transactional(readOnly = true)
  public CategoryDTO findById(Long id) {
    Optional<Category> obj = repository.findById(id);
    Category entity = obj.orElseThrow(() -> new ResourceNotFoundException("Category não encontrada"));
    return new CategoryDTO(entity);
  }

  @Transactional(readOnly = true)
  public Page<CategoryDTO> findAllPaged(PageRequest pageRequest) {
    Page<Category> page = repository.findAll(pageRequest);
    return page.map(x -> new CategoryDTO(x));
  }

}
