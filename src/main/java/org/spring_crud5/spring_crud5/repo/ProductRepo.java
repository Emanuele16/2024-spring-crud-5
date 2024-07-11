package org.spring_crud5.spring_crud5.repo;

import org.spring_crud5.spring_crud5.pojo.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {
}
