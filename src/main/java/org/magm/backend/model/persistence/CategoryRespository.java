package org.magm.backend.model.persistence;

import java.util.Optional;

import org.magm.backend.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRespository extends JpaRepository<Category, Long>{ 
	//https://docs.spring.io/spring-data/jpa/docs/2.7.0/reference/html/#repositories.query-methods.details
	//https://www.baeldung.com/spring-data-derived-queries

	public Optional<Category> findOneByCategory(String category);
}

