package com.jfb.stproduct.services;

import java.util.Optional;
import java.util.stream.Collectors;

import com.jfb.stproduct.dto.ProductDTO;
import com.jfb.stproduct.entities.Product;
import com.jfb.stproduct.repositories.ProductRepository;
import com.jfb.stproduct.services.exceptions.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

  @Autowired
  private ProductRepository repository;
  
  @Transactional(readOnly = true)
  public ProductDTO findById(Long id) {
    Optional<Product> obj = repository.findById(id);
    Product entity = obj.orElseThrow(() -> new ResourceNotFoundException("Product não encontrada"));
    return new ProductDTO(entity, entity.getCategories());
  }

  @Transactional(readOnly = true)
  public Page<ProductDTO> findAllPaged(PageRequest pageRequest) {
    Page<Product> page = repository.findAll(pageRequest);
    repository.findProductsCategories(page.stream().collect(Collectors.toList()));
    return page.map(x -> new ProductDTO(x, x.getCategories()));
  }
  
}
