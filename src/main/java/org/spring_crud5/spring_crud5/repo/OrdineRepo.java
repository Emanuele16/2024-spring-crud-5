package org.spring_crud5.spring_crud5.repo;

import org.spring_crud5.spring_crud5.pojo.Ordine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdineRepo extends JpaRepository<Ordine, Integer> {
}
