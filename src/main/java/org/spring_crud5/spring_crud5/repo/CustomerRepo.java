package org.spring_crud5.spring_crud5.repo;

import org.spring_crud5.spring_crud5.pojo.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
}
