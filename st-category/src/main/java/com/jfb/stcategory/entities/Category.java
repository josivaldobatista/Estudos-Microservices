package com.jfb.stcategory.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "tb_category")
public class Category implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private Instant createdAt;
  private Instant updatedAt;

  @ManyToMany(mappedBy = "categories")
  private Set<Product> products = new HashSet<>();

  public Category() {
  }

  public Category(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Instant getCreatedAt() {
    return this.createdAt;
  }

  public Instant getUpdatedAt() {
    return this.updatedAt;
  }

  public void setProducts(Set<Product> products) {
    this.products = products;
  }

  public Set<Product> getProducts() {
    return this.products;
  }

  @PrePersist
  public void prePersist() {
    createdAt = Instant.now();
  }

  @PreUpdate
  public void PreUpdate() {
    updatedAt = Instant.now();
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Category)) {
      return false;
    }
    Category category = (Category) o;
    return Objects.equals(id, category.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }

}