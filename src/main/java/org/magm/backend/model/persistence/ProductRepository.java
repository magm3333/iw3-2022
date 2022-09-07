package org.magm.backend.model.persistence;

import java.util.Optional;

import javax.transaction.Transactional;

import org.magm.backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	Optional<Product> findByProduct(String product);

	@Query(value = "SELECT count(*) FROM products where id_category=?", nativeQuery = true)
	public Integer countProductsByCategory(long idCategory);

	@Transactional
	@Modifying
	@Query(value = "UPDATE products SET stock=? WHERE id=?", nativeQuery = true)
	public int setStock(boolean stock, long idProduct);

}
